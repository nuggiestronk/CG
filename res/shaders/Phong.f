	

    #version 150
    in vec4 colorToFrag;
    in vec4 normalToFrag;
    in vec4 position;
    out vec4 farbe;
     
     void main(void){
     		float intensity = 0.5;
     		float reflectiveness = 0.01;
     		float diffusiveness = 1;
     		vec4 camera;
     		camera.x = 0;
     		camera.y = 0;
     		camera.z = 0;
     		vec4 licht;
     		licht.x = 0;
     		licht.y = 0;
     		licht.z = -100;
     		
     		vec4 cameraVec = camera - position;
     		vec4 lichtVec = licht - position;
     		
     		vec4 reflec;
     		reflec = lichtVec*normalToFrag;
     		reflec = 2*(reflec.x + reflec.y + reflec.z)*normalToFrag;
     		reflec = normalize(reflec) * normalize(cameraVec);
     		float reflecLicht =  reflec.x + reflec.y + reflec.z;
     		reflecLicht=reflectiveness * reflecLicht;
     		
     		vec4 diffuse = normalize(lichtVec) * normalize(normalToFrag);
     		float diffuseLicht = diffuse.x + diffuse.y + diffuse.z;
     		diffuseLicht = diffusiveness* diffuseLicht;
     		
     		float areaLicht = 0.1f;
     		
     		vec4 color;
     		color.x = intensity*(colorToFrag.x + areaLicht + diffuseLicht + reflecLicht);
     		color.y = intensity*(colorToFrag.y + areaLicht + diffuseLicht + reflecLicht);
     		color.z = intensity*(colorToFrag.z + areaLicht + diffuseLicht + reflecLicht);
     		
     		
     		
            farbe = color;
     }

