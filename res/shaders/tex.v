#version 150
in vec4 ecken;
in vec4 color;
in vec4 normal;
in vec4 cornNormals;
in vec4 texCoord;
out vec4 colorToFrag;
out vec4 normalToFrag;
out vec4 position;
out vec2 texCoordToFrag;
uniform mat4 glFrustum;
void main(void) {
		texCoordToFrag.x = texCoord.x;
		texCoordToFrag.x = texCoord.x;
        colorToFrag=color;
        normalToFrag = glFrustum*normal;
        position = glFrustum*ecken;
        gl_Position=glFrustum*ecken;
        }
        
        