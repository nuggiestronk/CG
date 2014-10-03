/*
 * 1. Imports von LWJGLTut richtig implementieren
 * 
 * 
 * 
 * 2. Frustum/Ortho Camera Matrix insitialisierung raffen 
 * 
 * 
 */














import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.LWJGLException;
 
public class LWJGLDisplay {
	public static void main(String[] args) {
		try {
			Display.setDisplayMode(new DisplayMode(640, 480));
			Display.setTitle("A fresh display!");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
		while(!Display.isCloseRequested()) {
								// Start Drawing A Triangle
		         GL11.glColor3f(1.0f,0.0f,0.0f);						// Red
		         GL11.glVertex3f( 0.0f, 1.0f, 0.0f);					// Top Of Triangle (Front)
		         GL11.glColor3f(0.0f,1.0f,0.0f);						// Green
		         GL11.glVertex3f(-1.0f,-1.0f, 1.0f);					// Left Of Triangle (Front)
		         GL11.glColor3f(0.0f,0.0f,1.0f);						// Blue
		         GL11.glVertex3f( 1.0f,-1.0f, 1.0f);					// Right Of Triangle (Front)
		         GL11.glColor3f(1.0f,0.0f,0.0f);						// Red
		         GL11.glVertex3f( 0.0f, 1.0f, 0.0f);					// Top Of Triangle (Right)
		         GL11.glColor3f(0.0f,0.0f,1.0f);						// Blue
		         GL11.glVertex3f( 1.0f,-1.0f, 1.0f);					// Left Of Triangle (Right)
		         GL11.glColor3f(0.0f,1.0f,0.0f);						// Green
		         GL11.glVertex3f( 1.0f,-1.0f, -1.0f);					// Right Of Triangle (Right)
		         GL11.glColor3f(1.0f,0.0f,0.0f);						// Red
		         GL11.glVertex3f( 0.0f, 1.0f, 0.0f);					// Top Of Triangle (Back)
		         GL11.glColor3f(0.0f,1.0f,0.0f);						// Green
		         GL11.glVertex3f( 1.0f,-1.0f, -1.0f);					// Left Of Triangle (Back)
		         GL11.glColor3f(0.0f,0.0f,1.0f);						// Blue
		         GL11.glVertex3f(-1.0f,-1.0f, -1.0f);					// Right Of Triangle (Back)
		         GL11.glColor3f(1.0f,0.0f,0.0f);						// Red
		         GL11.glVertex3f( 0.0f, 1.0f, 0.0f);					// Top Of Triangle (Left)
		         GL11.glColor3f(0.0f,0.0f,1.0f);						// Blue
		         GL11.glVertex3f(-1.0f,-1.0f,-1.0f);					// Left Of Triangle (Left)
		         GL11.glColor3f(0.0f,1.0f,0.0f);						// Green
		         GL11.glVertex3f(-1.0f,-1.0f, 1.0f);					// Right Of Triangle (Left)
		         GL11.glEnd();											// Done Drawing The Pyramid
		      
		         GL11.glLoadIdentity();									// Reset The Current Modelview Matrix
		         GL11.glTranslatef(1.5f,0.0f,-9.0f);						// Move Right 1.5 Units And Into The Screen 7.0
									// Draw A Quad
		         GL11.glColor3f(0.0f,1.0f,0.0f);						// Set The Color To Blue
		         GL11.glVertex3f( 1.0f, 1.0f,-1.0f);					// Top Right Of The Quad (Top)
		         GL11.glVertex3f(-1.0f, 1.0f,-1.0f);					// Top Left Of The Quad (Top)
		         GL11.glVertex3f(-1.0f, 1.0f, 1.0f);					// Bottom Left Of The Quad (Top)
		         GL11.glVertex3f( 1.0f, 1.0f, 1.0f);					// Bottom Right Of The Quad (Top)
		         GL11.glColor3f(1.0f,0.5f,0.0f);						// Set The Color To Orange
		         GL11.glVertex3f( 1.0f,-1.0f, 1.0f);					// Top Right Of The Quad (Bottom)
		         GL11.glVertex3f(-1.0f,-1.0f, 1.0f);					// Top Left Of The Quad (Bottom)
		         GL11.glVertex3f(-1.0f,-1.0f,-1.0f);					// Bottom Left Of The Quad (Bottom)
		         GL11.glVertex3f( 1.0f,-1.0f,-1.0f);					// Bottom Right Of The Quad (Bottom)
		         GL11.glColor3f(1.0f,0.0f,0.0f);						// Set The Color To Red
		         GL11.glVertex3f( 1.0f, 1.0f, 1.0f);					// Top Right Of The Quad (Front)
		         GL11.glVertex3f(-1.0f, 1.0f, 1.0f);					// Top Left Of The Quad (Front)
		         GL11.glVertex3f(-1.0f,-1.0f, 1.0f);					// Bottom Left Of The Quad (Front)
		         GL11.glVertex3f( 1.0f,-1.0f, 1.0f);					// Bottom Right Of The Quad (Front)
		         GL11.glColor3f(1.0f,1.0f,0.0f);						// Set The Color To Yellow
		         GL11.glVertex3f( 1.0f,-1.0f,-1.0f);					// Top Right Of The Quad (Back)
		         GL11.glVertex3f(-1.0f,-1.0f,-1.0f);					// Top Left Of The Quad (Back)
		         GL11.glVertex3f(-1.0f, 1.0f,-1.0f);					// Bottom Left Of The Quad (Back)
		         GL11.glVertex3f( 1.0f, 1.0f,-1.0f);					// Bottom Right Of The Quad (Back)
		         GL11.glColor3f(0.0f,0.0f,1.0f);						// Set The Color To Blue
		         GL11.glVertex3f(-1.0f, 1.0f, 1.0f);					// Top Right Of The Quad (Left)
		         GL11.glVertex3f(-1.0f, 1.0f,-1.0f);					// Top Left Of The Quad (Left)
		         GL11.glVertex3f(-1.0f,-1.0f,-1.0f);					// Bottom Left Of The Quad (Left)
		         GL11.glVertex3f(-1.0f,-1.0f, 1.0f);					// Bottom Right Of The Quad (Left)
		         GL11.glColor3f(1.0f,0.0f,1.0f);						// Set The Color To Violet
		         GL11.glVertex3f( 1.0f, 1.0f,-1.0f);					// Top Right Of The Quad (Right)
		         GL11.glVertex3f( 1.0f, 1.0f, 1.0f);					// Top Left Of The Quad (Right)
		         GL11.glVertex3f( 1.0f,-1.0f, 1.0f);					// Bottom Left Of The Quad (Right)
		         GL11.glVertex3f( 1.0f,-1.0f,-1.0f);					// Bottom Right Of The Quad (Right)
		         GL11.glEnd();											// Done Drawing The Quad

			
			
			
			
			
			
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
		System.exit(0);
	}
}
