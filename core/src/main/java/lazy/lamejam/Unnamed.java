package lazy.lamejam;

import com.badlogic.gdx.Game;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Unnamed extends Game {
	@Override
	public void create() {
		setScreen(new FirstScreen());
	}
}