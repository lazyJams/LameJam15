package lazy.lamejam.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import lazy.lamejam.core.AbilityButton;
import lazy.lamejam.core.DamageAbility;
import lazy.lamejam.core.HealAbility;
import lazy.lamejam.core.HeroStats;
import lazy.lamejam.util.TimedManager;
import lazy.lamejam.util.Transform;

import static lazy.lamejam.util.GdxHelper.*;

public class TestScreen extends ScreenAdapter {

	private SpriteBatch spriteBatch;
	private ShapeRenderer shapeRenderer;
	private BitmapFont bitmapFont;
	private HeroStats stats;
	private HeroStats enemyStats;

	private Stage stage;
	private Skin skin = new Skin(Gdx.files.internal("./ui/uiskin.json"));
	private TimedManager manager = new TimedManager();

	private float regenTimer;

	@Override
	public void show() {
		shapeRenderer = new ShapeRenderer();
		spriteBatch = new SpriteBatch();
		bitmapFont = new BitmapFont();
		stage = new Stage();
		stats = new HeroStats(1000, 1000, 10.0f, 2.0f);
		stats.addAbility(new HealAbility(3, 100, 100, Input.Keys.Q));
		stats.addAbility(new DamageAbility(3, 100, 100, Input.Keys.W));
		stats.addAbility(new HealAbility(10, 100, 100, Input.Keys.E));
		stats.addAbility(new HealAbility(10, 100, 100, Input.Keys.R));
		enemyStats = new HeroStats(1000, 1000, 2f, 3.2f);
		Table table = new Table();
		table.setPosition(center().x, center().y - 100);

		table.add(new AbilityButton(stats.getAbility(HeroStats.Q), "Q", skin, stats, enemyStats)).size(25, 25).pad(10);
		table.add(new AbilityButton(stats.getAbility(HeroStats.W), "W", skin, stats, enemyStats)).size(25, 25).pad(10);
		table.add(new AbilityButton(stats.getAbility(HeroStats.E), "E", skin, stats, enemyStats)).size(25, 25).pad(10);
		table.add(new AbilityButton(stats.getAbility(HeroStats.R), "R", skin, stats, enemyStats)).size(25, 25).pad(10);

		stage.addActor(table);

		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		regenTimer += delta;
		if(regenTimer >= 1){
			stats.regen();
			enemyStats.regen();
			regenTimer = 0;
		}

		stage.act();
		stage.draw();

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
