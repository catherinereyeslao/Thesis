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
 * Displays a random trivia.
 */
public class Trivia extends AppView {
    private Texture triviaTexture, blackBgTexture;
    private TextureAtlas boyAtlas;
    private Animation boyAnimation;
    private Sprite boy, triviaBalloon, blackBg;
    private float randomAppearanceTime, runTime;
    private boolean displayed, done;

    @Override
    public void setUp(int screenW, int screenH) {
        screenWidth = screenW;
        screenHeight = screenH;

        Random rand = new Random();
        randomAppearanceTime = rand.nextFloat() + rand.nextInt(36);

        blackBgTexture = new Texture("backgrounds/black-bg.jpg");
        blackBg = new Sprite(blackBgTexture);
        blackBg.setSize(screenWidth, screenHeight);
        blackBg.setAlpha(1);

        boyAtlas = new TextureAtlas("characters/boy/boy.atlas");
        boyAnimation = new Animation(0.25f, boyAtlas.getRegions());
        boy = new Sprite(boyAnimation.getKeyFrames()[0]);
        boy.setSize(boy.getWidth() * getButtonScale(), boy.getHeight() * getButtonScale());
        boy.setPosition(screenW / 4, screenH / 10);

        triviaTexture = new Texture(randomTrivia());
        triviaBalloon = new Sprite(triviaTexture);
        triviaBalloon.setSize(triviaBalloon.getWidth() * getButtonScale(), triviaBalloon.getHeight() * getButtonScale());
        triviaBalloon.setPosition(boy.getX() + boy.getWidth() / 2, boy.getY() + boy.getHeight() / 1.7f);

        Gdx.app.log("Trivia", "Trivia will appear in " + randomAppearanceTime + " seconds");
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
    public boolean isDone() {
        return done;
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
