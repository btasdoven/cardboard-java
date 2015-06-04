/*
 * Copyright 2014 Google Inc. All Rights Reserved.

 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.vrtoolkit.cardboard.samples.treasurehunt;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;

import com.google.vrtoolkit.cardboard.CardboardActivity;
import com.google.vrtoolkit.cardboard.CardboardView;
import com.google.vrtoolkit.cardboard.Eye;
import com.google.vrtoolkit.cardboard.HeadTransform;
import com.google.vrtoolkit.cardboard.Viewport;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.egl.EGLConfig;

/**
 * A Cardboard sample application.
 */
public class MainActivity extends CardboardActivity implements CardboardView.StereoRenderer {

  private static final String TAG = "MainActivity";

  private static final float Z_NEAR = 0.1f;
  private static final float Z_FAR = 100.0f;

  private static final float CAMERA_Z = 0.01f;

  // We keep the light always position just above the user.
  private static final float[] LIGHT_POS_IN_WORLD_SPACE = new float[] { 0.0f, 2.0f, 0.0f, 1.0f };

  private final float[] lightPosInEyeSpace = new float[4];

  private FloatBuffer coordBuffer;
  private ShortBuffer indexBuffer;

  private int sphereProgram;

  private int sphereSamplerParam;
  private int spherePositionParam;
  private int sphereModelParam;
  private int sphereModelViewParam;
  private int sphereModelViewProjectionParam;
  private int sphereLightPosParam;
  private int sphereTexture;

  private float[] camera;
  private float[] view;
  private float[] headView;
  private float[] modelViewProjection;
  private float[] modelView;
  private float[] modelSphere;

  private Vibrator vibrator;
  private CardboardOverlayView overlayView;

  /**
   * Sets the view to our CardboardView and initializes the transformation matrices we will use
   * to render our scene.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.common_ui);
    CardboardView cardboardView = (CardboardView) findViewById(R.id.cardboard_view);
    cardboardView.setRenderer(this);
    setCardboardView(cardboardView);

    camera = new float[16];
    view = new float[16];
    modelViewProjection = new float[16];
    modelView = new float[16];
    modelSphere = new float[16];
    headView = new float[16];
    vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

    overlayView = (CardboardOverlayView) findViewById(R.id.overlay);
    overlayView.show3DToast("Welcome to 3D viewer");
  }

  @Override
  public void onRendererShutdown() {
    Log.i(TAG, "onRendererShutdown");
  }

  @Override
  public void onSurfaceChanged(int width, int height) {
    Log.i(TAG, "onSurfaceChanged");
  }

  /**
   * Creates the buffers we use to store information about the 3D world.
   *
   * <p>OpenGL doesn't use Java arrays, but rather needs data in a format it can understand.
   * Hence we use ByteBuffers.
   *
   * @param config The EGL configuration used when creating the surface.
   */
  @Override
  public void onSurfaceCreated(EGLConfig config) {
    Log.i(TAG, "onSurfaceCreated");

    sphereTexture = Helper.loadGLTexture(getApplicationContext(), R.drawable.sample);
    Log.e(TAG, sphereTexture + " is the texture id");

    GLES20.glClearColor(0.1f, 0.1f, 0.1f, 0.5f); // Dark background so text shows up well.

    coordBuffer = null;
    indexBuffer = null;

    coordBuffer = ByteBuffer.allocateDirect(WorldLayoutData.SPHERE_COORDS.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    coordBuffer.put(WorldLayoutData.SPHERE_COORDS);
    coordBuffer.position(0);

    indexBuffer = ByteBuffer.allocateDirect(WorldLayoutData.SPHERE_INDICES.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
    indexBuffer.put(WorldLayoutData.SPHERE_INDICES);
    indexBuffer.position(0);

    int sphereVertexShader = Helper.loadGLShader(getApplicationContext(), GLES20.GL_VERTEX_SHADER, R.raw.sphere_vertex);
    int sphereFragmentShader = Helper.loadGLShader(getApplicationContext(), GLES20.GL_FRAGMENT_SHADER, R.raw.sphere_fragment);

    sphereProgram = GLES20.glCreateProgram();
    GLES20.glAttachShader(sphereProgram, sphereVertexShader);
    GLES20.glAttachShader(sphereProgram, sphereFragmentShader);
    GLES20.glLinkProgram(sphereProgram);
    GLES20.glUseProgram(sphereProgram);

    Helper.checkGLError("Sphere program");

    sphereModelParam = GLES20.glGetUniformLocation(sphereProgram, "u_Model");
    sphereModelViewParam = GLES20.glGetUniformLocation(sphereProgram, "u_MVMatrix");
    sphereModelViewProjectionParam = GLES20.glGetUniformLocation(sphereProgram, "u_MVP");
    sphereLightPosParam = GLES20.glGetUniformLocation(sphereProgram, "u_LightPos");

    sphereSamplerParam = GLES20.glGetUniformLocation(sphereProgram, "s_Texture");
    if (sphereSamplerParam == -1)
        Log.e(TAG, "sampler is null");

    spherePositionParam = GLES20.glGetAttribLocation(sphereProgram, "a_Position");
    GLES20.glEnableVertexAttribArray(spherePositionParam);

    Helper.checkGLError("Sphere program params");


    Matrix.setIdentityM(modelSphere, 0);
    Matrix.rotateM(modelSphere, 0, 90, 1, 0, 0);
    Matrix.scaleM(modelSphere, 0, 50, 50, 50);

    Helper.checkGLError("onSurfaceCreated");
  }


  /**
   * Prepares OpenGL ES before we draw a frame.
   *
   * @param headTransform The head transformation in the new frame.
   */
  @Override
  public void onNewFrame(HeadTransform headTransform) {
    // Build the Model part of the ModelView matrix.
    // Matrix.rotateM(modelCube, 0, TIME_DELTA, 0.5f, 0.5f, 1.0f);

    // Build the camera matrix and apply it to the ModelView.
    Matrix.setLookAtM(camera, 0, 0.0f, 0.0f, CAMERA_Z, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);

    headTransform.getHeadView(headView, 0);

    Helper.checkGLError("onReadyToDraw");
  }

  /**
   * Draws a frame for an eye.
   *
   * @param eye The eye to render. Includes all required transformations.
   */
  @Override
  public void onDrawEye(Eye eye) {
    GLES20.glEnable(GLES20.GL_DEPTH_TEST);
    GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

    Helper.checkGLError("colorParam");

    // Apply the eye transformation to the camera.
    Matrix.multiplyMM(view, 0, eye.getEyeView(), 0, camera, 0);

    // Set the position of the light
    Matrix.multiplyMV(lightPosInEyeSpace, 0, view, 0, LIGHT_POS_IN_WORLD_SPACE, 0);

    // Build the ModelView and ModelViewProjection matrices
    // for calculating SPHERE_COORDS position and light.
    float[] perspective = eye.getPerspective(Z_NEAR, Z_FAR);

    // Set modelView for the floor, so we draw floor in the correct location
    Matrix.multiplyMM(modelView, 0, view, 0, modelSphere, 0);
    Matrix.multiplyMM(modelViewProjection, 0, perspective, 0, modelView, 0);
    drawSphere();
  }

    @Override
  public void onFinishFrame(Viewport viewport) {
  }

    /**
     * Draw the floor.
     *
     * <p>This feeds in data for the floor into the shader. Note that this doesn't feed in data about
     * position of the light, so if we rewrite our code to draw the floor first, the lighting might
     * look strange.
     */
    public void drawSphere() {
        GLES20.glUseProgram(sphereProgram);
        GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, sphereTexture);

        // Set ModelView, MVP, position, normals, and color.
        GLES20.glUniform3fv(sphereLightPosParam, 1, lightPosInEyeSpace, 0);
        GLES20.glUniformMatrix4fv(sphereModelParam, 1, false, modelSphere, 0);
        GLES20.glUniformMatrix4fv(sphereModelViewParam, 1, false, modelView, 0);
        GLES20.glUniformMatrix4fv(sphereModelViewProjectionParam, 1, false, modelViewProjection, 0);
        GLES20.glUniform1i(sphereSamplerParam, 0);

        GLES20.glVertexAttribPointer(spherePositionParam, 3, GLES20.GL_FLOAT, false, 12, coordBuffer);

      GLES20.glDrawElements(GLES20.GL_TRIANGLES, 192 * 3, GLES20.GL_UNSIGNED_SHORT, indexBuffer);

      Helper.checkGLError("drawing sphere");
    }


  /**
   * Called when the Cardboard trigger is pulled.
   */
  @Override
  public void onCardboardTrigger() {
    Log.i(TAG, "onCardboardTrigger");

    // Always give user feedback.
    vibrator.vibrate(50);
  }
}
