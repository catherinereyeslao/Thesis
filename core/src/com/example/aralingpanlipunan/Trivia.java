package com.example.aralingpanlipunan;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.example.aralingpanlipunan.views.AppView;

import java.util.Random;

/**
 * Displays a random trivia in the Chapter lecture at a random time (5 minutes max)
 */
public class Trivia extends AppView {
    private Texture triviaTexture, blackBgTexture;
    private TextureAtlas boyAtlas;
    private Animation boyAnimation;
    private Sprite boy, triviaBalloon, blackBg;
    private static float runTime, randomAppearanceTime = 0;
    private static boolean done;
    private boolean displayed;

    @Override
    public void setUp(int screenW, int screenH) {
        screenWidth = screenW;
        screenHeight = screenH;
        done = false;

        if (randomAppearanceTime == 0) {
            Random rand = new Random();
            randomAppearanceTime = rand.nextFloat() + rand.nextInt(300);
        }

        blackBgTexture = new Texture("backgrounds/black-bg.jpg");
        blackBg = new Sprite(blackBgTexture);
        blackBg.setSize(screenWidth, screenHeight);
        blackBg.setAlpha(0.5f);

        boyAtlas = new TextureAtlas("characters/boy/boy.atlas");
        boyAnimation = new Animation(0.25f, boyAtlas.getRegions());
        boy = new Sprite(boyAnimation.getKeyFrames()[0]);

        triviaTexture = new Texture(randomTrivia());
        triviaBalloon = new Sprite(triviaTexture);
        triviaBalloon.setSize(triviaBalloon.getWidth() * getButtonScale() * 1.2f, triviaBalloon.getHeight() * getButtonScale());

        setBoySize(boy.getWidth() * getButtonScale(), boy.getHeight() * getButtonScale());
    }

    @Override
    public void display(Batch batch) {
        if (!done) {
            runTime += Gdx.graphics.getDeltaTime();
            if (runTime >= randomAppearanceTime) {
                blackBg.draw(batch);
                boy.setRegion(boyAnimation.getKeyFrame(runTime, true));
                boy.draw(batch);
                triviaBalloon.draw(batch);
                if (!displayed) displayed = true;
            }
        }
    }

    @Override
    public void dispose() {
        boyAtlas.dispose();
        blackBgTexture.dispose();
        triviaTexture.dispose();
    }

    /**
     * Returns true if the trivia is being displayed
     * @return boolean
     */
    public boolean isDisplayed() {
        return displayed;
    }

    /**
     * Determine whether trivia has been seen or not
     * @return true if trivia has been seen and closed by user
     */
    public static boolean isDone() {
        return done;
    }

    /**
     * Modify the size of the boy character
     * This can be used in {@link com.example.aralingpanlipunan.views.chapters.ChapterCore}
     * to set the size of the boy same as the size of the girl
     * Also adjusts the position of the balloon relative to the new position of boy
     * @param boyWidth The new width of the boy character sprite
     * @param boyHeight The new height of the boy character sprite
     */
    public void setBoySize(float boyWidth, float boyHeight) {
        boy.setSize(boyWidth, boyHeight);
        boy.setPosition(screenWidth / 3.1f, 0);
        triviaBalloon.setPosition((boy.getX() + boy.getWidth()) / 1.3f, (boy.getY() + boy.getHeight()) / 1.75f);
    }

    /**
     * Set the trivia as done, meaning that it has been read by the user.
     * Trivia will never appear again until user reopens the app again
     */
    public void setDone() {
        done = true;
    }

    /**
     * Get a random trivia balloon
     * @return Sting path for the texture of a random trivia balloon
     */
    private String randomTrivia() {
        int randomTriviaNum = new Random().nextInt(8);
        switch (randomTriviaNum) {
            case 0:
                return "trivias/trivia1.png";
            case 1:
                return "trivias/trivia2.png";
            case 2:
                return "trivias/trivia3.png";
            case 3:
                return "trivias/trivia4.png";
            case 4:
                return "trivias/trivia5.png";
            case 5:
                return "trivias/trivia6.png";
            case 6:
                return "trivias/trivia7.png";
            case 7:
                return "trivias/trivia8.png";
            default:
                return "trivias/triva9.png";
        }
    }
}
