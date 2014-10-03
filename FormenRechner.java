
public class FormenRechner {
	//GEGEN UHRZEIGERSINN!!!!!
	
	float[][] helpArrayNormals;
	
	public float[][] buildWuerfel(float[] ecke1, float kantenlänge,float[]farbe){
		//position variables
		final int front = 0;
		final int right = 1;
		final int back = 2;
		final int left = 3;
		final int top = 4;
		final int bot = 5;
		
		final int x = 0;
		final int y = 1;
		final int z = 2;
		
		//color variables
		float r;
		float g;
		float b;
		
		//normal variables
		float[][] normals = new float[6][3];
		float[][][] normals2 = new float[6][4][3];
		
		//
		//Positions
		//
		int counter;
		
		float[][] wuerfel = new float[5][72];
		float[][][] eckenArray = new float[6][4][3];
				
		if(ecke1.length > 3){
			float[] ecke1new = new float[2];
			for(int i = 0; i < 2; i++){
				ecke1new[i] = ecke1[i];
			}
			eckenArray[front][0] = ecke1new;
			eckenArray[right][0] = ecke1new;
			eckenArray[bot][0] = ecke1new;
			ecke1 = ecke1new;
		}
		
		//initialy make all edges = ecke1
		for(int i =0; i < eckenArray.length; i ++){
			for(int j =0; j < eckenArray[i].length; j ++){
				eckenArray[i][j] = ecke1.clone();
			}
		}
		
		//front
		eckenArray[front][1][y] += kantenlänge;
		eckenArray[front][3][x] -= kantenlänge;
		eckenArray[front][2][y] += kantenlänge;
		eckenArray[front][2][x] -= kantenlänge;

		//right
		eckenArray[right][1][z] -= kantenlänge;
		eckenArray[right][3][y] += kantenlänge;
		eckenArray[right][2][z] -= kantenlänge;
		eckenArray[right][2][y] += kantenlänge;
		
		//bot
		eckenArray[bot][1][x] -= kantenlänge;
		eckenArray[bot][3][z] -= kantenlänge;
		eckenArray[bot][2][x] -= kantenlänge;
		eckenArray[bot][2][z] -= kantenlänge;
		
		//back
		for(int i = 0; i < eckenArray[back].length;i++){
			eckenArray[back][i] = eckenArray[front][3-i].clone();
			eckenArray[back][i][z] -= kantenlänge;
		}
		
		//left
		for(int i = 0; i < eckenArray[left].length;i++){
			eckenArray[left][i] = eckenArray[right][3-i].clone();
			eckenArray[left][i][x] -= kantenlänge;
		}
		
		//top
		for(int i = 0; i < eckenArray[top].length;i++){
			eckenArray[top][i] = eckenArray[bot][3-i].clone();
			eckenArray[top][i][y] += kantenlänge;
		}
		
		counter = 0;
		for(int i = 0; i< eckenArray.length; i++){
			for(int j = 0; j< eckenArray[i].length; j++){
				for(int k = 0; k< eckenArray[i][j].length; k++){
					wuerfel[0][counter] = eckenArray[i][j][k];
					counter++;
				}
			}
		}
		
		//
		//colors
		//
		r = farbe[0];
		g = farbe[1];
		b = farbe[2];
		for(int i =0; i < 72; i+=3){
			wuerfel[1][i] = r;
			wuerfel[1][i+1] = g;
			wuerfel[1][i+2] = b;
		}
		
		//
		//normals
		//
		for(int i = 0;i <6 ; i++ ){
			
			float aX = eckenArray[i][0][x];
			float aY = eckenArray[i][0][y];
			float aZ = eckenArray[i][0][z];
			
			float bX = eckenArray[i][3][x];
			float bY = eckenArray[i][3][y];
			float bZ = eckenArray[i][3][z];
			
			float cX = eckenArray[i][2][x];
			float cY = eckenArray[i][2][y];
			float cZ = eckenArray[i][2][z];
			
			float uX = aX - bX;
			float uY = aY - bY;
			float uZ = aZ - bZ;
			
			float vX = cX - bX;
			float vY = cY - bY;
			float vZ = cZ - bZ;
			
			normals[i][0] = uY*vZ - uZ*vY;
			normals[i][1] = -1*(uX*vZ - uZ*vX);
			normals[i][2] = uX*vY - uY*vX;
		}
		helpArrayNormals = normals.clone();
		
		for(int i = 0;i <6 ; i++ ){
			
			//front0 back1 right0 left1 bot0 top1
			normals2[front][0][x] = cornNCoord(x, front,right, bot);
			normals2[front][0][y] = cornNCoord(y, front,right, bot);
			normals2[front][0][z] = cornNCoord(z, front,right, bot);
			normals2[right][0] = normals2[front][0];
			normals2[bot][0] = normals2[front][0];
			
			normals2[back][1][x] = -normals2[front][0][x];
			normals2[back][1][y] = -normals2[front][0][y];
			normals2[back][1][z] = -normals2[front][0][z];
			normals2[top][1] = normals2[back][1];
			normals2[left][1] = normals2[back][1];
			
			//front1 back0 right3 left2 bot2 top3
			normals2[front][1][x] = cornNCoord(x, front,right, top);
			normals2[front][1][y] = cornNCoord(y, front,right, top);
			normals2[front][1][z] = cornNCoord(z, front,right, top);
			normals2[right][3] = normals2[front][0];
			normals2[top][3] = normals2[front][0];
			
			normals2[back][0][x] = -normals2[front][1][x];
			normals2[back][0][y] = -normals2[front][1][y];
			normals2[back][0][z] = -normals2[front][1][z];
			normals2[bot][2] = normals2[back][1];
			normals2[left][2] = normals2[back][1];
			
			//front2 back3 right1 left0 bot3 top2
			normals2[front][2][x] = cornNCoord(x, front,left, top);
			normals2[front][2][y] = cornNCoord(y, front,left, top);
			normals2[front][2][z] = cornNCoord(z, front,left, top);
			normals2[left][0] = normals2[front][0];
			normals2[top][2] = normals2[front][0];
			
			normals2[back][3][x] = -normals2[front][2][x];
			normals2[back][3][y] = -normals2[front][2][y];
			normals2[back][3][z] = -normals2[front][2][z];
			normals2[bot][3] = normals2[back][1];
			normals2[right][1] = normals2[back][1];
			
			//front3 back2 right2 left3 bot1 top0
			normals2[front][3][x] = cornNCoord(x, front,left, bot);
			normals2[front][3][y] = cornNCoord(y, front,left, bot);
			normals2[front][3][z] = cornNCoord(z, front,left, bot);
			normals2[left][3] = normals2[front][0];
			normals2[bot][1] = normals2[front][0];
			
			normals2[back][2][x] = -normals2[front][2][x];
			normals2[back][2][y] = -normals2[front][2][y];
			normals2[back][2][z] = -normals2[front][2][z];
			normals2[top][0] = normals2[back][1];
			normals2[right][2] = normals2[back][1];
		}
		
		counter = 0;
		for(int i = 0; i< normals2.length; i++){
			for(int j = 0; j< normals2[i].length; j++){
				for(int k = 0; k< normals2[i][j].length; k++){
					wuerfel[3][counter] = normals2[i][j][k];
					counter++;
				}
			}
		}
		//
		//TextureCoordinates
		//
		for(int i = 0; i < wuerfel[4].length; i+= 12){
			wuerfel[4][i] = 0.f;
			wuerfel[4][i+1] = 0.f;
			wuerfel[4][i+2] = 0.f;
			wuerfel[4][i+3] = 0.f;
			wuerfel[4][i+4] = 1.f;
			wuerfel[4][i+5] = 0.f;
			wuerfel[4][i+6] = 1.f;
			wuerfel[4][i+7] = 1.f;
			wuerfel[4][i+8] = 0.f;
			wuerfel[4][i+9] = 1.f;
			wuerfel[4][i+10] = 1.f;
			wuerfel[4][i+11] = 0.f;
		}

		
		
		// 72/6 = 12
		for(int i = 0;i < 72 ; i+= 12){
			for(int j = 0; j <12 ; j+= 3){
				wuerfel[2][i+j] = normals[i/12][0];
				wuerfel[2][i+j+1] = normals[i/12][1];
				wuerfel[2][i+j+2] = normals[i/12][2];
			}
		}
		
		return wuerfel;
		
	}
	
	public int cornNCoord(int coordinate, int side1, int side2, int side3){
		return (int)(this.helpArrayNormals[side1][coordinate] + helpArrayNormals[side2][coordinate] + helpArrayNormals[side3][coordinate]);
	}
	
	public float[] buildWuerfelFarbe(float r, float g, float b){
		float[] wuerfel = new float[72]; 
		for(int i =0; i < 72; i+=3){
			wuerfel[i] = r;
			wuerfel[i+1] = g;
			wuerfel[i+2] = b;
		}
		return wuerfel;
	}
	
	
}
