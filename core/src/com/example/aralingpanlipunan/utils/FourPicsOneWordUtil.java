package com.example.aralingpanlipunan.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Utility class for FourPics1Word game
 */
public class FourPicsOneWordUtil {
    private Texture blackBgTexture;
    private Sprite blackBg;
    private BitmapFont font;
    private float screenWidth, screenHeight;

    /**
     * Load the black transparent background with a
     * text to display that the user has entered the correct answer
     * @param screenW Width of the screen
     * @param screenH Height of the screen
     */
    public void loadAssets(int screenW, int screenH) {
        screenWidth = screenW;
        screenHeight = screenH;

        ScreenSizeUtil screenSizeUtil = new ScreenSizeUtil();
        font = new BitmapFont(screenSizeUtil.fontAsset(screenW));
        font.setScale(1.5f);

        blackBgTexture = new Texture("backgrounds/black-bg.jpg");
        blackBg = new Sprite(blackBgTexture);
        blackBg.setPosition(0, 0);
        blackBg.setSize(screenWidth, screenHeight);
        blackBg.setAlpha(0.5f);
    }

    /**
     * Display the text saying the answer is correct, whilst
     * darkening the background at the same time
     * @param batch Batch
     */
    public void displayCorrect(Batch batch) {
        blackBg.draw(batch);
        font.setScale(2.3f);
        font.draw(batch, "Correct!", (screenWidth / 2) - (font.getBounds("Correct!").width / 2), screenHeight / 1.7f);
    }

    /**
     * Dispose the assets to free up memory
     */
    public void dispose() {
        blackBgTexture.dispose();
        font.dispose();
    }
}
