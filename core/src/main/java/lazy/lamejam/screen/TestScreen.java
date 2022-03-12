package lazy.lamejam.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import lazy.lamejam.core.Ability;
import lazy.lamejam.core.DamageAbility;
import lazy.lamejam.core.HealAbility;
import lazy.lamejam.core.HeroStats;
import lazy.lamejam.util.Transform;

import static lazy.lamejam.util.GdxHelper.*;

public class TestScreen extends ScreenAdapter {

	private SpriteBatch spriteBatch;
	private ShapeRenderer shapeRenderer;
	private BitmapFont bitmapFont;
	private HeroStats stats;
	private HeroStats enemyStats;

	@Override
	public void show() {
		shapeRenderer = new ShapeRenderer();
		spriteBatch = new SpriteBatch();
		bitmapFont = new BitmapFont();
		stats = new HeroStats(1000, 1000);
		stats.addAbility(new HealAbility(10,100, 100));
		stats.addAbility(new DamageAbility(10,100, 100));
		stats.addAbility(new HealAbility(10,100, 100));
		stats.addAbility(new HealAbility(10,100, 100));
		enemyStats = new HeroStats(1000, 1000);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		Transform hero = new Transform(center().x - 75, center().y - 25, 50, 50);
		Transform enemyHero = new Transform(center().x + 25, center().y - 25, 50, 50);

		beginDrawing();
		drawPoint(new Transform(center().x, center().y, 0, 0), Color.WHITE);
		drawRect(hero, Color.GREEN);
		drawText(hero.x, hero.yRelative(70), "Health: " + stats.getHealth(), Color.WHITE);
		drawText(hero.x, hero.yRelative(90), "Mana: " + stats.getMana(), Color.WHITE);
		drawRect(enemyHero, Color.RED);
		drawText(enemyHero.x, enemyHero.yRelative(70), "Health: " + enemyStats.getHealth(), Color.WHITE);
		drawText(enemyHero.x, enemyHero.yRelative(90), "Mana: " + enemyStats.getMana(), Color.WHITE);
		endDrawing();

		if(Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
			stats.useAbility(HeroStats.Q, enemyStats);
		} else {
			if(Gdx.input.isKeyJustPressed(Input.Keys.W)) {
				stats.useAbility(HeroStats.W, enemyStats);
			}
		}
	}

	@Override
	public void resize(int width, int height) {
		// Resize your screen here. The parameters represent the new window size.
	}

	@Override
	public void hide() {
		// This method is called when another screen replaces this one.
	}

	@Override
	public void dispose() {
		disposeHelper();
	}
}
