#ifdef GL_FRAGMENT_PRECISION_HIGH
    precision highp float;
#else
    precision mediump float;
#endif

uniform sampler2D s_Texture;
varying vec4 v_Color;
varying vec4 v_Coord;

void main()
{
    vec2 longitudeLatitude = vec2((atan(v_Coord.y, v_Coord.x) / 3.1415926 + 1.0) * 0.5,
                                  (asin(v_Coord.z) / 3.1415926 + 0.5));
    gl_FragColor = texture2D( s_Texture, longitudeLatitude );
}