package lazy.lamejam.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class GdxHelper {

	private static Vector2 tmp = new Vector2();

	private static ShapeRenderer shapeRenderer = new ShapeRenderer();
	private static SpriteBatch batch = new SpriteBatch();
	private static BitmapFont font = new BitmapFont();

	public static Vector2 dimensions(){
		return tmp.set(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	public static Vector2 center() {
		return tmp.set(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
	}

	public static Vector2 relativeCenter(float amtX, float amtY) {
		return tmp.set((Gdx.graphics.getWidth() >> 2) + amtX, (Gdx.graphics.getHeight() >> 2) + amtY);
	}


	public static void beginDrawing() {
		batch.begin();
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
	}

	public static ShapeRenderer shapeRenderer() {
		return shapeRenderer;
	}

	public static void drawRect(Transform transform, Color color) {
		shapeRenderer.setColor(color);
		shapeRenderer.rect(transform.x, transform.y, transform.w, transform.h);
	}

	public static void drawPoint(Transform transform, Color color) {
		shapeRenderer.setColor(color);
		shapeRenderer.circle(transform.x, transform.y, 1);
	}

	public static SpriteBatch spriteBatch() {
		return batch;
	}

	public static void drawText(float x, float y, String text, Color color) {
		font.setColor(color);
		font.draw(batch, text, x, y);
	}

	public static void endDrawing() {
		batch.end();
		shapeRenderer.end();
	}

	public static void disposeHelper() {
		shapeRenderer.dispose();
		batch.dispose();
		font.dispose();
	}
}
