	

    #version 150
    in vec4 colorToFrag;
    in vec4 normalToFrag;
    in vec4 position;
    out vec4 farbe;
     
     void main(void){

     		vec4 randomVec;
     		randomVec.x = position.x-position.y;
     		randomVec.y = position.y-position.x;
     		randomVec.z = randomVec.x - randomVec.y;
     		
     		vec4 color;
     		color.x = mod(randomVec.x,4);
     		color.y = mod(randomVec.y,4);
     		color.z = mod(randomVec.z,4);
     		
     		
     		
            farbe = color;
     }

