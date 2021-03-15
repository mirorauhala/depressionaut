package fi.tuni.tamk.tiko.depressionaut;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends Game {
	SpriteBatch gameBatch;
	SpriteBatch hudBatch;
	private BottomHud bottomHud;
	private GameScreen gameScreen;
	private ShopScreen shopScreen;
	public final float SCREEN_WIDTH = 1080;
	public final float SCREEN_HEIGHT = 1920;
	public long splashTimer = System.nanoTime();

	public OrthographicCamera camera;
	
	@Override
	public void create () {
		gameBatch = new SpriteBatch();
		hudBatch = new SpriteBatch();
		bottomHud = new BottomHud();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);

		setScreen(new SplashScreen(this));
		ScoreCounter.addToClickPower(1);
		ScoreCounter.addToMultiplier(1);


	}

	@Override
	public void render () {
		hudBatch.setProjectionMatrix(camera.combined);
		// Uses the render method from current screen.
		super.render();

		hudBatch.begin();

		bottomHud.draw(hudBatch);
		hudBatch.end();

		ScoreCounter.checkForClick();
		ScoreCounter.drawScore();

	}

	public void setComicScreen () {
		setScreen(new Comic(this));
	}

	public void setGameScreen () {
		setScreen(new GameScreen(this));
	}

	/*public void setShopScreen () {
		setScreen(new ShopScreen(this));
	}*/
	
	@Override
	public void dispose () {
		gameBatch.dispose();
		hudBatch.dispose();

	}
}
