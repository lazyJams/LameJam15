package lazy.lamejam.util;

import com.badlogic.gdx.math.Vector2;

public class Transform {

	public float x;
	public float y;
	public float w;
	public float h;

	public Transform(float x, float y, float w, float h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public Transform(Vector2 pos, float w, float h) {
		this(pos.x, pos.y, w, h);
	}

	public float xRelative(float amt) {
		return this.x + amt;
	}

	public float yRelative(float amt) {
		return this.y + amt;
	}

	public Transform relative(float x, float y) {
		return new Transform(this.x + x, this.y + y, this.w, this.h);
	}
}
