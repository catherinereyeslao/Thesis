package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;
import com.example.aralingpanlipunan.AppFragment;
import com.example.aralingpanlipunan.android.AndroidInterface;
import com.example.aralingpanlipunan.views.AppView;

public abstract class ChapterCore extends AppView implements AppFragment, Disposable {
    protected AndroidInterface android;
    protected TextureAtlas girlAtlas;
    protected Animation girlAnimation;
    protected Sprite girl, balloonSprite, backgroundSprite, imageQuestion, helpSprite, soundSprite, backToChapters, startQuiz;
    protected String loggedInStudent;
    protected int chapterSection, correctAnswers, startOfQuestionSection = 0;
    protected boolean assetNeedUpdate, lectureStarted, isDragging = false;
    protected float animationCounter, touchX = 0;
    private Texture helpTexture, soundTexture;

    public ChapterCore(AndroidInterface androidInterface, String studentName) {
        this.android = androidInterface;
        this.loggedInStudent = studentName;
    }

    /**
     * If android's back key is pressed, return 1 to Student class
     * to give a signal to go back to Chapter Select
     *
     * @param keycode the keycode of the pressed button
     * @return int
     */
    public int keyDown(int keycode) {
        return keycode == 4 ? 1 : 0;
    }

    /**
     * Default assets being shared between all chapters should be placed
     * here. Always place this in the setUp() method of the child class
     * This sets up the girl & balloon above her
     */
    protected void setUpDefaultAssets() {
        Texture introBalloonTexture = new Texture("chapters/chapter1/balloons/intro1.png");
        helpTexture = new Texture("buttons/help.png");
        soundTexture = new Texture("buttons/sound.png");

        backgroundSprite = new Sprite(introBalloonTexture);
        backgroundSprite.setSize(screenWidth, screenHeight);

        girlAtlas = new TextureAtlas("characters/girl/girl.atlas");
        girlAtlas.getRegions().removeIndex(0); // Remove waved hand for now, seems ugly to have this
        girlAnimation = new Animation(0.15f, girlAtlas.getRegions());
        girl = new Sprite(girlAnimation.getKeyFrames()[0]);
        girl.setSize((girl.getWidth() * getButtonScale()) * 1.4f, (girl.getHeight() * getButtonScale()) * 1.4f);
        final float girlX = (screenWidth / 4) * -1;
        final float girlY = (screenHeight / 3) - (girl.getHeight() / 2);
        girl.setPosition(girlX, girlY);
        girl.setBounds(girlX, girlY, girl.getWidth(), girl.getHeight());

        balloonSprite = new Sprite(introBalloonTexture);
        balloonSprite.setSize((balloonSprite.getWidth() * getButtonScale()) * 2.5f, (balloonSprite.getHeight() * getButtonScale()) * 2.5f);
        balloonSprite.setPosition((screenWidth / 5) + (girl.getWidth() / 2), girlY + (girl.getHeight() / 2));

        helpSprite = new Sprite(helpTexture);
        helpSprite.setSize((helpSprite.getWidth() * getButtonScale() / 1.8f), (helpSprite.getHeight() * getButtonScale() / 1.8f));
        final float helpSpriteX = (screenWidth / 10) - (helpSprite.getWidth() / 2);
        final float helpSpriteY = (screenHeight - (screenHeight / 10)) - (helpSprite.getHeight() / 2);
        helpSprite.setPosition(helpSpriteX, helpSpriteY);
        helpSprite.setBounds(helpSpriteX, helpSpriteY, helpSprite.getWidth(), helpSprite.getHeight());

        soundSprite = new Sprite(soundTexture);
        soundSprite.setSize(helpSprite.getWidth(), helpSprite.getHeight());
        final float soundSpriteX = helpSpriteX + soundSprite.getWidth();
        soundSprite.setPosition(soundSpriteX, helpSpriteY);
        soundSprite.setBounds(soundSpriteX, helpSpriteY, soundSprite.getWidth(), soundSprite.getHeight());

        introBalloonTexture.dispose();
    }

    /**
     * This method renders all shared assets across all chapters in the game.
     * Put this in the chapter's draw method to put the animating girl and balloon
     * @param batch Batch
     */
    protected void renderSharedAssets(Batch batch) {
        backgroundSprite.draw(batch);
        if (girl.getX() < (screenWidth / 5) - (girl.getWidth() / 2)) {
            girl.setX(girl.getX() + 5);
        } else {
            lectureStarted = true;
            animationCounter += Gdx.graphics.getDeltaTime();
            girl.setRegion(girlAnimation.getKeyFrame(animationCounter, true));
            balloonSprite.draw(batch);
        }
        girl.draw(batch);
        helpSprite.draw(batch);
        soundSprite.draw(batch);
        if (chapterSection == startOfQuestionSection - 1) {
            startQuiz.draw(batch);
            backToChapters.draw(batch);
        }
    }

    public int touchDown(float x, float y) {
        touchX = x;
        return 100;
    }

    /**
     * Detects touch drag event so we'll move to next balloon
     * @param x The x coordinate of the finger's current position
     */
    public void touchDragged(int x) {
        float slide = touchX - x;
        if (chapterSection < startOfQuestionSection && lectureStarted && !isDragging) {
            if (chapterSection > 0 && slide <= screenWidth * -0.20f) {
                chapterSection--;
                isDragging = true;
                assetNeedUpdate = true;
            } else if (chapterSection < 8 && slide >= screenWidth * 0.20f) {
                chapterSection++;
                isDragging = true;
                assetNeedUpdate = true;
            }
        }
    }

    public void touchUp() {
        touchX = 0;
        isDragging = false;
    }

    /**
     * All shared across all chapters (all those we've loaded here
     * in chapterCore) will be disposed.
     */
    protected void disposeSharedAssets() {
        helpTexture.dispose();
        soundTexture.dispose();
    }
}
