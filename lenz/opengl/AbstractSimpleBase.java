package lenz.opengl;
import static org.lwjgl.opengl.GL11.*;



import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public abstract class AbstractSimpleBase {

	public void start() {

		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
		} catch (LWJGLException e) {
			throw new RuntimeException("Unable to intialize display", e);
		}

		// hier Initialisieren
		initOpenGL();

		while (!Display.isCloseRequested()) {

			// hier Zeichnen
			render();
			
			
			glTranslated(0,0,-32);
			glRotated(20,0,0,-1);
			glRotated(3,1,0,0);
			glTranslated(0,0,31.9);

			glRotated(20,0,0,1);
			glPushMatrix();

			Display.update();
			Display.sync(60);
		}

		Display.destroy();

	}

	protected abstract void initOpenGL();

	protected abstract void render();

}
