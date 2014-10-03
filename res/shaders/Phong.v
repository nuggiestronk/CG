#version 150
in vec4 ecken;
in vec4 color;
in vec4 normal;
in vec4 cornNormals;
out vec4 colorToFrag;
out vec4 normalToFrag;
out vec4 position;
uniform mat4 glFrustum;
uniform mat4 glFrustum2; 
void main(void) {
        colorToFrag=color;
        normalToFrag = glFrustum*normal;
        position = glFrustum*ecken;
        gl_Position=glFrustum*ecken;
        }
        
        