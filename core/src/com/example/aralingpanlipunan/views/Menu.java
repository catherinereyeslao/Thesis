package com.example.aralingpanlipunan.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Disposable;
import com.example.aralingpanlipunan.AppFragment;
import com.example.aralingpanlipunan.utils.BackgroundMusic;

/**
 * This renders the Main Menu which can be seen once the App is opened
 */
public class Menu extends AppView implements Disposable, AppFragment {
    public static final byte MENU = 1;
    public static final byte START = 2;
    public static final byte MINI_GAMES = 4;
    public static final byte EXIT = 8;

    private Texture background, splashScreen, startTexture, exitTexture;
    private Sprite start, exit;
    private float splashTimer = 0;
    private boolean freshlyStarted = true;

    @Override
    public void setUp(int screenW, int screenH) {
        screenWidth = screenW;
        screenHeight = screenH;

        if (!BackgroundMusic.isBgMUsicPlaying())
            BackgroundMusic.playBgMusic();

        startTexture = new Texture("buttons/menu/start.png");
        exitTexture = new Texture("buttons/exit.png");
        splashScreen = new Texture("backgrounds/splash.jpg");
        background = new Texture("backgrounds/menu-background.jpg");

        start = new Sprite(startTexture);
        start.setScale(getButtonScale());
        final float startX = (screenWidth - (screenWidth / 4)) - start.getWidth()/ 1.7f;
        final float startY = screenH / 4;
        start.setPosition(startX, startY);
        start.setBounds(startX, startY, start.getWidth(), start.getHeight());

        exit = new Sprite(exitTexture);
        exit.setScale(getButtonScale());
        final float exitX = (screenWidth - (screenWidth / 4)) - exit.getWidth()/ 1.7f;
        final float exitY = startY - (exit.getHeight() / exitScaledY);
        exit.setPosition(exitX, exitY);
    }

    @Override
    public void display(Batch batch) {
        // If app is freshly started, display splash for 3.5 secs before going to main menu
        if (freshlyStarted) {
            if (splashTimer > 3.5f) {
                freshlyStarted = false;
                splashScreen.dispose();
            }
            batch.draw(splashScreen, 0, 0, screenWidth, screenHeight);
            splashTimer += Gdx.graphics.getDeltaTime();
        } else {
            batch.draw(background, 0, 0, screenWidth, screenHeight);
            start.draw(batch);
            exit.draw(batch);
        }
    }

    /**
     * Detect screen touch event and determine which menu option is tapped
     * @param x The x coordinate of touched screen
     * @param y The y coordinate of touched screen
     * @return int
     */
    public int clickedMenu(float x, float y) {
        if (start.getBoundingRectangle().contains(x, y))
            return START;
        else if (exit.getBoundingRectangle().contains(x, y))
            return EXIT;
        else
            return MENU;
    }

    @Override
    public void dispose() {
        startTexture.dispose();
        exitTexture.dispose();
        background.dispose();
    }
}
