uniform mat4 u_Model;
uniform mat4 u_MVP;
uniform mat4 u_MVMatrix;
uniform vec3 u_LightPos;

uniform sampler2D s_Texture;

attribute vec4 a_Position;

varying vec4 v_Color;
varying vec4 v_Coord;

void main() {
   vec3 modelViewVertex = vec3(u_MVMatrix * a_Position);
   vec3 modelViewNormal = vec3(u_MVMatrix * vec4(vec3(a_Position), 0.0));

   float distance = length(u_LightPos - modelViewVertex);
   vec3 lightVector = normalize(u_LightPos - modelViewVertex);
   float diffuse = max(dot(modelViewNormal, lightVector), 0.5);

   diffuse = diffuse * (1.0 / (1.0 + (0.00001 * distance * distance)));

   v_Color = vec4(0,1,0,1) * diffuse;
   v_Coord = a_Position;

   gl_Position = u_MVP * a_Position;
}
