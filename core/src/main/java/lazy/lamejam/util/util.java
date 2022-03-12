package lazy.lamejam.util;

import com.badlogic.gdx.math.Vector2;

public class util {

	public static Transform vecToTransPos(Vector2 pos, int width, int height) {
		return new Transform(pos.x, pos.y, width, height);
	}

	public static Transform vecToTransSize(Vector2 size, int x, int y) {
		return new Transform(x, y, size.x, size.y);
	}
}
