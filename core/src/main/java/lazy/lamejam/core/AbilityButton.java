package lazy.lamejam.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;

import java.util.concurrent.atomic.AtomicReference;

public class AbilityButton extends TextButton {

	private final Ability ability;
	private int currentTime;
	private float timer;
	private String original;

	// FIXME: 13/03/2022 I dont like the idea of passing the stats to the button itself,
	// but its a game jam no one cares right?

	public AbilityButton(Ability ability, String text, Skin skin, HeroStats stats, HeroStats enemyStats) {
		super(text, skin);
		this.original = text;
		this.ability = ability;
		removeListener(getClickListener());
		addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(ability.onUse(stats, enemyStats) == Ability.Result.OK) {
					setDisabled(true);
					currentTime = ability.uptime;
					Timer.schedule(new Timer.Task() {
						@Override
						public void run() {
							setDisabled(false);
						}
					}, ability.uptime);
				}
			}
		});
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);

		if(!isDisabled() && Gdx.input.isKeyJustPressed(this.ability.key)) {
			getFromList().clicked(null, 0, 0);
		}

		if(currentTime > 0) {
			setText("" + currentTime);
			timer += Gdx.graphics.getDeltaTime();
			if(timer >= 1) {
				currentTime--;
				setText("" + currentTime);
				timer = 0;
			}
		}

		if(currentTime == 0) {
			setText(original);
		}
	}

	private ClickListener getFromList() {
		AtomicReference<ClickListener> tmp = new AtomicReference<>();
		getListeners().forEach(l -> {
			if (l instanceof ClickListener) {
				tmp.set(((ClickListener) l));
			}
		});
		return tmp.get();
	}
}
