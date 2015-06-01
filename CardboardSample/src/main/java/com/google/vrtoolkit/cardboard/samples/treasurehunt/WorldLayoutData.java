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

/**
 * Contains vertex, normal and color data.
 */
public final class WorldLayoutData {

  public static final float[] CUBE_COORDS = new float[] {
      // Front face
      -1.0f, 1.0f, 1.0f,
      -1.0f, -1.0f, 1.0f,
      1.0f, 1.0f, 1.0f,
      -1.0f, -1.0f, 1.0f,
      1.0f, -1.0f, 1.0f,
      1.0f, 1.0f, 1.0f,

      // Right face
      1.0f, 1.0f, 1.0f,
      1.0f, -1.0f, 1.0f,
      1.0f, 1.0f, -1.0f,
      1.0f, -1.0f, 1.0f,
      1.0f, -1.0f, -1.0f,
      1.0f, 1.0f, -1.0f,

      // Back face
      1.0f, 1.0f, -1.0f,
      1.0f, -1.0f, -1.0f,
      -1.0f, 1.0f, -1.0f,
      1.0f, -1.0f, -1.0f,
      -1.0f, -1.0f, -1.0f,
      -1.0f, 1.0f, -1.0f,

      // Left face
      -1.0f, 1.0f, -1.0f,
      -1.0f, -1.0f, -1.0f,
      -1.0f, 1.0f, 1.0f,
      -1.0f, -1.0f, -1.0f,
      -1.0f, -1.0f, 1.0f,
      -1.0f, 1.0f, 1.0f,

      // Top face
      -1.0f, 1.0f, -1.0f,
      -1.0f, 1.0f, 1.0f,
      1.0f, 1.0f, -1.0f,
      -1.0f, 1.0f, 1.0f,
      1.0f, 1.0f, 1.0f,
      1.0f, 1.0f, -1.0f,

      // Bottom face
      1.0f, -1.0f, -1.0f,
      1.0f, -1.0f, 1.0f,
      -1.0f, -1.0f, -1.0f,
      1.0f, -1.0f, 1.0f,
      -1.0f, -1.0f, 1.0f,
      -1.0f, -1.0f, -1.0f,
  };

  public static final float[] CUBE_COLORS = new float[] {
      // front, green
      0f, 0.5273f, 0.2656f, 1.0f,
      0f, 0.5273f, 0.2656f, 1.0f,
      0f, 0.5273f, 0.2656f, 1.0f,
      0f, 0.5273f, 0.2656f, 1.0f,
      0f, 0.5273f, 0.2656f, 1.0f,
      0f, 0.5273f, 0.2656f, 1.0f,

      // right, blue
      0.0f, 0.3398f, 0.9023f, 1.0f,
      0.0f, 0.3398f, 0.9023f, 1.0f,
      0.0f, 0.3398f, 0.9023f, 1.0f,
      0.0f, 0.3398f, 0.9023f, 1.0f,
      0.0f, 0.3398f, 0.9023f, 1.0f,
      0.0f, 0.3398f, 0.9023f, 1.0f,

      // back, also green
      0f, 0.5273f, 0.2656f, 1.0f,
      0f, 0.5273f, 0.2656f, 1.0f,
      0f, 0.5273f, 0.2656f, 1.0f,
      0f, 0.5273f, 0.2656f, 1.0f,
      0f, 0.5273f, 0.2656f, 1.0f,
      0f, 0.5273f, 0.2656f, 1.0f,

      // left, also blue
      0.0f, 0.3398f, 0.9023f, 1.0f,
      0.0f, 0.3398f, 0.9023f, 1.0f,
      0.0f, 0.3398f, 0.9023f, 1.0f,
      0.0f, 0.3398f, 0.9023f, 1.0f,
      0.0f, 0.3398f, 0.9023f, 1.0f,
      0.0f, 0.3398f, 0.9023f, 1.0f,

      // top, red
      0.8359375f,  0.17578125f,  0.125f, 1.0f,
      0.8359375f,  0.17578125f,  0.125f, 1.0f,
      0.8359375f,  0.17578125f,  0.125f, 1.0f,
      0.8359375f,  0.17578125f,  0.125f, 1.0f,
      0.8359375f,  0.17578125f,  0.125f, 1.0f,
      0.8359375f,  0.17578125f,  0.125f, 1.0f,

      // bottom, also red
      0.8359375f,  0.17578125f,  0.125f, 1.0f,
      0.8359375f,  0.17578125f,  0.125f, 1.0f,
      0.8359375f,  0.17578125f,  0.125f, 1.0f,
      0.8359375f,  0.17578125f,  0.125f, 1.0f,
      0.8359375f,  0.17578125f,  0.125f, 1.0f,
      0.8359375f,  0.17578125f,  0.125f, 1.0f,
  };

  public static final float[] CUBE_FOUND_COLORS = new float[] {
      // front, yellow
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,

      // right, yellow
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,

      // back, yellow
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,

      // left, yellow
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,

      // top, yellow
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,

      // bottom, yellow
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
      1.0f,  0.6523f, 0.0f, 1.0f,
  };

  public static final float[] CUBE_NORMALS = new float[] {
      // Front face
      0.0f, 0.0f, 1.0f,
      0.0f, 0.0f, 1.0f,
      0.0f, 0.0f, 1.0f,
      0.0f, 0.0f, 1.0f,
      0.0f, 0.0f, 1.0f,
      0.0f, 0.0f, 1.0f,

      // Right face
      1.0f, 0.0f, 0.0f,
      1.0f, 0.0f, 0.0f,
      1.0f, 0.0f, 0.0f,
      1.0f, 0.0f, 0.0f,
      1.0f, 0.0f, 0.0f,
      1.0f, 0.0f, 0.0f,

      // Back face
      0.0f, 0.0f, -1.0f,
      0.0f, 0.0f, -1.0f,
      0.0f, 0.0f, -1.0f,
      0.0f, 0.0f, -1.0f,
      0.0f, 0.0f, -1.0f,
      0.0f, 0.0f, -1.0f,

      // Left face
      -1.0f, 0.0f, 0.0f,
      -1.0f, 0.0f, 0.0f,
      -1.0f, 0.0f, 0.0f,
      -1.0f, 0.0f, 0.0f,
      -1.0f, 0.0f, 0.0f,
      -1.0f, 0.0f, 0.0f,

      // Top face
      0.0f, 1.0f, 0.0f,
      0.0f, 1.0f, 0.0f,
      0.0f, 1.0f, 0.0f,
      0.0f, 1.0f, 0.0f,
      0.0f, 1.0f, 0.0f,
      0.0f, 1.0f, 0.0f,

      // Bottom face
      0.0f, -1.0f, 0.0f,
      0.0f, -1.0f, 0.0f,
      0.0f, -1.0f, 0.0f,
      0.0f, -1.0f, 0.0f,
      0.0f, -1.0f, 0.0f,
      0.0f, -1.0f, 0.0f
  };

  public static final float[] FLOOR_COORDS = new float[] {
      200f, 0, -200f,
      -200f, 0, -200f,
      -200f, 0, 200f,
      200f, 0, -200f,
      -200f, 0, 200f,
      200f, 0, 200f,
  };

  public static final float[] FLOOR_NORMALS = new float[] {
      0.0f, 1.0f, 0.0f,
      0.0f, 1.0f, 0.0f,
      0.0f, 1.0f, 0.0f,
      0.0f, 1.0f, 0.0f,
      0.0f, 1.0f, 0.0f,
      0.0f, 1.0f, 0.0f,
  };

  public static final float[] FLOOR_COLORS = new float[] {
      0.0f, 0.3398f, 0.9023f, 1.0f,
      0.0f, 0.3398f, 0.9023f, 1.0f,
      0.0f, 0.3398f, 0.9023f, 1.0f,
      0.0f, 0.3398f, 0.9023f, 1.0f,
      0.0f, 0.3398f, 0.9023f, 1.0f,
      0.0f, 0.3398f, 0.9023f, 1.0f,
  };

    public static final float[] cube = new float[] {0.000000f,-0.878472f,-0.000000f,
            0.350694f,-0.819444f,-0.000000f,
            -0.000000f,-0.819444f,0.350694f,
            -0.350694f,-0.819444f,-0.000000f,
            0.000000f,-0.819444f,-0.350695f,
            0.326389f,-0.763889f,-0.326389f,
            0.326389f,-0.763889f,0.326389f,
            -0.326389f,-0.763889f,0.326389f,
            -0.326389f,-0.763889f,-0.326389f,
            -0.000000f,0.878472f,0.000000f,
            0.000000f,0.819444f,-0.350694f,
            -0.350695f,0.819444f,0.000000f,
            -0.000000f,0.819444f,0.350695f,
            0.350694f,0.819444f,0.000000f,
            0.326389f,0.763889f,-0.326389f,
            -0.326389f,0.763889f,-0.326389f,
            -0.326389f,0.763889f,0.326389f,
            0.326389f,0.763889f,0.326389f,
            0.878472f,0.000000f,0.000000f,
            0.819445f,0.000000f,-0.350694f,
            0.819444f,0.350694f,0.000000f,
            0.819444f,-0.000000f,0.350695f,
            0.819444f,-0.350694f,0.000000f,
            0.763889f,-0.326389f,-0.326389f,
            0.763889f,0.326389f,-0.326389f,
            0.763889f,0.326389f,0.326389f,
            0.763889f,-0.326389f,0.326389f,
            -0.000000f,-0.000000f,0.878472f,
            0.350694f,0.000000f,0.819445f,
            -0.000000f,0.350694f,0.819444f,
            -0.350695f,0.000000f,0.819444f,
            -0.000000f,-0.350694f,0.819444f,
            0.326389f,-0.326389f,0.763889f,
            0.326389f,0.326389f,0.763889f,
            -0.326389f,0.326389f,0.763889f,
            -0.326389f,-0.326389f,0.763889f,
            -0.878472f,0.000000f,-0.000000f,
            -0.819445f,0.000000f,0.350694f,
            -0.819444f,0.350694f,-0.000000f,
            -0.819444f,0.000000f,-0.350695f,
            -0.819444f,-0.350694f,-0.000000f,
            -0.763889f,-0.326389f,0.326389f,
            -0.763889f,0.326389f,0.326389f,
            -0.763889f,0.326389f,-0.326389f,
            -0.763889f,-0.326389f,-0.326389f,
            0.000000f,0.000000f,-0.878472f,
            0.350695f,0.000000f,-0.819444f,
            0.000000f,-0.350694f,-0.819444f,
            -0.350694f,0.000000f,-0.819444f,
            0.000000f,0.350694f,-0.819444f,
            0.326389f,0.326389f,-0.763889f,
            0.326389f,-0.326389f,-0.763889f,
            -0.326389f,-0.326389f,-0.763889f,
            -0.326389f,0.326389f,-0.763889f,
            0.598958f,-0.598958f,-0.302083f,
            0.643229f,-0.643229f,0.000000f,
            0.598958f,-0.598958f,0.302083f,
            0.302083f,-0.598958f,-0.598958f,
            0.000000f,-0.643229f,-0.643229f,
            -0.302083f,-0.598958f,-0.598958f,
            0.598958f,-0.302083f,-0.598958f,
            0.643229f,0.000000f,-0.643229f,
            0.598958f,0.302083f,-0.598958f,
            0.302083f,-0.598958f,0.598958f,
            -0.000000f,-0.643229f,0.643229f,
            -0.302083f,-0.598958f,0.598958f,
            0.598958f,-0.302083f,0.598958f,
            0.643229f,0.000000f,0.643229f,
            0.598958f,0.302083f,0.598959f,
            -0.598958f,-0.598958f,0.302083f,
            -0.643229f,-0.643229f,-0.000000f,
            -0.598958f,-0.598958f,-0.302084f,
            -0.598958f,-0.302083f,0.598958f,
            -0.643229f,0.000000f,0.643229f,
            -0.598959f,0.302083f,0.598958f,
            -0.598958f,-0.302083f,-0.598958f,
            -0.643229f,0.000000f,-0.643229f,
            -0.598958f,0.302083f,-0.598958f,
            0.598958f,0.598958f,-0.302083f,
            0.643229f,0.643229f,0.000000f,
            0.598958f,0.598958f,0.302084f,
            0.302083f,0.598958f,-0.598958f,
            0.000000f,0.643229f,-0.643229f,
            -0.302083f,0.598958f,-0.598958f,
            0.302083f,0.598958f,0.598959f,
            -0.000000f,0.643229f,0.643229f,
            -0.302084f,0.598958f,0.598958f,
            -0.598958f,0.598958f,0.302083f,
            -0.643229f,0.643229f,-0.000000f,
            -0.598958f,0.598958f,-0.302083f,
            0.509259f,-0.509259f,-0.509259f,
            0.509259f,-0.509259f,0.509259f,
            -0.509259f,-0.509259f,0.509259f,
            -0.509259f,-0.509259f,-0.509259f,
            0.509259f,0.509259f,-0.509259f,
            0.509259f,0.509259f,0.509260f,
            -0.509260f,0.509259f,0.509259f,
            -0.509259f,0.509259f,-0.509259f};
    //colors for each vertices
    public static final float[] colors = new float[] {
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1,
            1,0,0,1,        1,0,0,1
    };
    //indeces for drawing the vertices in specified order
    public static final short[] indeces = new short[] {0,4,5,
            1,5,54,
            4,58,57,
            5,57,90,
            0,1,6,
            2,6,63,
            1,55,56,
            6,56,91,
            0,2,7,
            3,7,69,
            2,64,65,
            7,65,92,
            0,3,8,
            4,8,59,
            3,70,71,
            8,71,93,
            9,13,14,
            10,14,81,
            13,79,78,
            14,78,94,
            9,10,15,
            11,15,89,
            10,82,83,
            15,83,97,
            9,11,16,
            12,16,86,
            11,88,87,
            16,87,96,
            9,12,17,
            13,17,80,
            12,85,84,
            17,84,95,
            18,22,23,
            19,23,60,
            22,55,54,
            23,54,90,
            18,19,24,
            20,24,78,
            19,61,62,
            24,62,94,
            18,20,25,
            21,25,68,
            20,79,80,
            25,80,95,
            18,21,26,
            22,26,56,
            21,67,66,
            26,66,91,
            27,31,32,
            28,32,66,
            31,64,63,
            32,63,91,
            27,28,33,
            29,33,84,
            28,67,68,
            33,68,95,
            27,29,34,
            30,34,74,
            29,85,86,
            34,86,96,
            27,30,35,
            31,35,65,
            30,73,72,
            35,72,92,
            36,40,41,
            37,41,72,
            40,70,69,
            41,69,92,
            36,37,42,
            38,42,87,
            37,73,74,
            42,74,96,
            36,38,43,
            39,43,77,
            38,88,89,
            43,89,97,
            36,39,44,
            40,44,71,
            39,76,75,
            44,75,93,
            45,49,50,
            46,50,62,
            49,82,81,
            50,81,94,
            45,46,51,
            47,51,57,
            46,61,60,
            51,60,90,
            45,47,52,
            48,52,75,
            47,58,59,
            52,59,93,
            45,48,53,
            49,53,83,
            48,76,77,
            53,77,97,
            1,0,5,
            55,1,54,
            5,4,57,
            54,5,90,
            2,0,6,
            64,2,63,
            6,1,56,
            63,6,91,
            3,0,7,
            70,3,69,
            7,2,65,
            69,7,92,
            4,0,8,
            58,4,59,
            8,3,71,
            59,8,93,
            10,9,14,
            82,10,81,
            14,13,78,
            81,14,94,
            11,9,15,
            88,11,89,
            15,10,83,
            89,15,97,
            12,9,16,
            85,12,86,
            16,11,87,
            86,16,96,
            13,9,17,
            79,13,80,
            17,12,84,
            80,17,95,
            19,18,23,
            61,19,60,
            23,22,54,
            60,23,90,
            20,18,24,
            79,20,78,
            24,19,62,
            78,24,94,
            21,18,25,
            67,21,68,
            25,20,80,
            68,25,95,
            22,18,26,
            55,22,56,
            26,21,66,
            56,26,91,
            28,27,32,
            67,28,66,
            32,31,63,
            66,32,91,
            29,27,33,
            85,29,84,
            33,28,68,
            84,33,95,
            30,27,34,
            73,30,74,
            34,29,86,
            74,34,96,
            31,27,35,
            64,31,65,
            35,30,72,
            65,35,92,
            37,36,41,
            73,37,72,
            41,40,69,
            72,41,92,
            38,36,42,
            88,38,87,
            42,37,74,
            87,42,96,
            39,36,43,
            76,39,77,
            43,38,89,
            77,43,97,
            40,36,44,
            70,40,71,
            44,39,75,
            71,44,93,
            46,45,50,
            61,46,62,
            50,49,81,
            62,50,94,
            47,45,51,
            58,47,57,
            51,46,60,
            57,51,90,
            48,45,52,
            76,48,75,
            52,47,59,
            75,52,93,
            49,45,53,
            82,49,83,
            53,48,77,
            83,53,97
    };
}
