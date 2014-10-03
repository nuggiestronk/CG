	

    #version 150
    in vec4 colorToFrag;
    in vec4 normalToFrag;
    in vec4 position;
    in vec2 texCoordToFrag;
    out vec4 farbe;
    uniform sampler2D tex;
     
     void main(void){
     	vec4 color =  texture2D(tex, texCoordToFrag.st);
  	    farbe = color;
     }

