    import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL15.*;


import java.nio.FloatBuffer;
     




    import org.lwjgl.BufferUtils;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

     





    import lenz.opengl.AbstractSimpleBase;
import lenz.opengl.utils.ShaderProgram;
import lenz.opengl.utils.Texture;


public class Example extends AbstractSimpleBase {
	
	//!!!!!!!! Important Variable Start
	private String usedShader = "tex"; //There is: Phong, proztex, tex
	//!!!!!!!! Important Variable End
	
	
	long time = System.currentTimeMillis();
	private int vaoID, vaoID2;
	private int vboIDE, vboIDF, vboIDN, vboIDCN, vboIDTC, vboIDE2, vboIDF2, vboIDN2, vboIDCN2, vboIDTC2;
	Matrix4f glFrustum;
	Matrix4f modelViewProj, modelViewProj2;
	ShaderProgram shadeP, shadeP2;
	float[] ecken1, color1, normals1, cornNormals1, texCoords1;
	float[] ecken2, color2, normals2, cornNormals2, texCoords2;
	FormenRechner objects = new FormenRechner();

	public static void main(String[] args) {
		new Example().start();
	}

	Texture steinTex;

	@Override
	protected void initOpenGL() {
        float d = 1;
        float f = 200;
        float right = 1;
        float left = -1;
        float bot = -1;
        float top = 1;
        
        glFrustum = new Matrix4f();
        glFrustum.m00 = 2*d/(right-left);
        glFrustum.m11 = 2*d/(top-bot);
        glFrustum.m20 = (right + left) / (right-left);
        glFrustum.m21 = (top+bot) / (top-bot);
        glFrustum.m22 = -((f+d) / (f - d));
        glFrustum.m23 = -1;
        glFrustum.m32 = -((2*f*d)/(f - d));
		
		modelViewProj = new Matrix4f(glFrustum);
		modelViewProj.translate(new Vector3f(0.0f,5.f,-20.f));
		
		//Building Objects
		float[][] wuerfel = objects.buildWuerfel(new float[]{4.f,-4.f,-4.f }, 8,new float[]{0.3f,0.9f,1.0f});
		ecken1 = wuerfel[0];
		color1 = wuerfel[1];
		normals1 = wuerfel[2];
		cornNormals1 = wuerfel[3];
		texCoords1 = wuerfel[4];
		
		float[][] wuerfel2 = objects.buildWuerfel(new float[]{7.f,7.f,7.f }, 3,new float[]{0.9f,1.0f,0.4f});
		ecken2 = wuerfel2[0];
		color2 = wuerfel2[1];
		normals2 = wuerfel2[2];
		cornNormals2 = wuerfel2[3];
		texCoords2 = wuerfel[4];
		
		//
		//Object1 Start
		//
        vaoID = glGenVertexArrays();
        glBindVertexArray(vaoID);
		
        //Bind Vertices       
        FloatBuffer eckenBuffer = BufferUtils.createFloatBuffer(ecken1.length);
        eckenBuffer.put(ecken1);
        eckenBuffer.flip();
        vboIDE = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboIDE);
        glBufferData(GL_ARRAY_BUFFER, eckenBuffer, GL_STATIC_DRAW);
        glVertexAttribPointer(0,3,GL_FLOAT,false,0,0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
		
        //Bind Color
        FloatBuffer farbenBuffer = BufferUtils.createFloatBuffer(color1.length);
        farbenBuffer.put(color1);
        farbenBuffer.flip();
        vboIDF = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboIDF);
        glBufferData(GL_ARRAY_BUFFER, farbenBuffer, GL_STATIC_DRAW);
        glVertexAttribPointer(1,3,GL_FLOAT,false,0,0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        
        //Bind Normals
        FloatBuffer normalenBuffer = BufferUtils.createFloatBuffer(normals1.length);
        normalenBuffer.put(normals1);
        normalenBuffer.flip();
        vboIDN = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboIDN);
        glBufferData(GL_ARRAY_BUFFER, normalenBuffer, GL_STATIC_DRAW);
        glVertexAttribPointer(2,3,GL_FLOAT,false,0,0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        
        //Bind Corner Normals
        FloatBuffer cornNormalenBuffer = BufferUtils.createFloatBuffer(cornNormals1.length);
        cornNormalenBuffer.put(cornNormals1);
        cornNormalenBuffer.flip();
        vboIDCN = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboIDCN);
        glBufferData(GL_ARRAY_BUFFER, cornNormalenBuffer, GL_STATIC_DRAW);
        glVertexAttribPointer(3,3,GL_FLOAT,false,0,0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        
        //Bind Texture Coordinates
        FloatBuffer texCoordBuffer = BufferUtils.createFloatBuffer(texCoords1.length);
        texCoordBuffer.put(texCoords1);
        texCoordBuffer.flip();
        vboIDTC = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboIDTC);
        glBufferData(GL_ARRAY_BUFFER, texCoordBuffer, GL_STATIC_DRAW);
        glVertexAttribPointer(4,3,GL_FLOAT,false,0,0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        //
        //Object1 End
        //
        
        
        //
		//Object2 Start
        //
        vaoID2 = glGenVertexArrays();
        glBindVertexArray(vaoID2);
		
        //Bind Vertices       
        FloatBuffer eckenBuffer2 = BufferUtils.createFloatBuffer(ecken2.length);
        eckenBuffer2.put(ecken2);
        eckenBuffer2.flip();
        vboIDE2 = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboIDE2);
        glBufferData(GL_ARRAY_BUFFER, eckenBuffer2, GL_STATIC_DRAW);
        glVertexAttribPointer(0,3,GL_FLOAT,false,0,0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
		
        //Bind Color
        FloatBuffer farbenBuffer2 = BufferUtils.createFloatBuffer(color2.length);
        farbenBuffer2.put(color2);
        farbenBuffer2.flip();
        vboIDF2 = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboIDF2);
        glBufferData(GL_ARRAY_BUFFER, farbenBuffer2, GL_STATIC_DRAW);
        glVertexAttribPointer(1,3,GL_FLOAT,false,0,0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        
        //Bind Normals
        FloatBuffer normalenBuffer2 = BufferUtils.createFloatBuffer(normals2.length);
        normalenBuffer2.put(normals2);
        normalenBuffer2.flip();
        vboIDN2 = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboIDN2);
        glBufferData(GL_ARRAY_BUFFER, normalenBuffer2, GL_STATIC_DRAW);
        glVertexAttribPointer(2,3,GL_FLOAT,false,0,0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        
        //Bind Corner Normals
        FloatBuffer cornNormalenBuffer2 = BufferUtils.createFloatBuffer(cornNormals2.length);
        cornNormalenBuffer2.put(cornNormals2);
        cornNormalenBuffer2.flip();
        vboIDCN2 = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboIDCN2);
        glBufferData(GL_ARRAY_BUFFER, cornNormalenBuffer2, GL_STATIC_DRAW);
        glVertexAttribPointer(3,3,GL_FLOAT,false,0,0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        
        //Bind Texture Coordinates
        FloatBuffer texCoordBuffer2 = BufferUtils.createFloatBuffer(texCoords2.length);
        texCoordBuffer2.put(texCoords2);
        texCoordBuffer2.flip();
        vboIDTC2 = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboIDTC2);
        glBufferData(GL_ARRAY_BUFFER, texCoordBuffer2, GL_STATIC_DRAW);
        glVertexAttribPointer(4,3,GL_FLOAT,false,0,0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        //
        //Object2 End
        //
        
        glEnable(GL_TEXTURE_2D);
        steinTex = new Texture("SteinTextur.jpg");
        glEnable(GL_CULL_FACE);
        

        
		
        shadeP = new ShaderProgram(usedShader);
        glBindAttribLocation(shadeP.getId(), 0, "ecken");
        glBindAttribLocation(shadeP.getId(), 1, "color");
        glBindAttribLocation(shadeP.getId(), 2, "normals");
        glBindAttribLocation(shadeP.getId(), 3, "cornNormals");
        glUseProgram(shadeP.getId());

        
	}
	

	@Override
	protected void render() {
		glClear(GL_COLOR_BUFFER_BIT);
		
		glBindTexture(GL_TEXTURE_2D, 1);

		if(System.currentTimeMillis() - time > 1){
			modelViewProj.translate(new Vector3f(0.0f, 0.f,-6.72f));
			modelViewProj.rotate(0.003f, new Vector3f(-5.0f,3.0f,-3.0f));
			modelViewProj.translate(new Vector3f(-0.0f, -0.f,6.7f));
			time +=1;
		}
		
		glBindVertexArray(vaoID);
		glEnableVertexAttribArray(0);
		glEnableVertexAttribArray(1);
		glEnableVertexAttribArray(2);
		glEnableVertexAttribArray(3);
		glDrawArrays(GL_QUADS, 0, ecken1.length/3);
		glDisableVertexAttribArray(3);
		glDisableVertexAttribArray(2);
		glDisableVertexAttribArray(1);
		glDisableVertexAttribArray(0);
		glBindVertexArray(1);
		
		glBindVertexArray(vaoID2);
		glEnableVertexAttribArray(0);
		glEnableVertexAttribArray(1);
		glEnableVertexAttribArray(2);
		glEnableVertexAttribArray(3);
		glDrawArrays(GL_QUADS, 0, ecken2.length/3);
		glDisableVertexAttribArray(3);
		glDisableVertexAttribArray(2);
		glDisableVertexAttribArray(1);
		glDisableVertexAttribArray(0);
		glBindVertexArray(0);

        FloatBuffer fb = BufferUtils.createFloatBuffer(16);
		modelViewProj.store(fb);
		fb.flip();
		glUniformMatrix4(glGetUniformLocation(shadeP.getId(),"glFrustum"),false,fb);
		

		

		




	}
}
