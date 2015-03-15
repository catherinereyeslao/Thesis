package com.example.aralingpanlipunan.views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Displays the Help screen.
 * @deprecated Currently not in use and has been replaced by settings.
 * This may be completely deleted in the future if decided
 */
public class Help extends AppView {
    private static final byte HELP_MENU = 0;
    private static final byte CHAPTER1 = 1;
    private static final byte CHAPTER2 = 2;
    private static final byte CREDIT = 3;
    private static final byte MENU1 = 4;
    private static final byte MENU2 = 5;
    private static final byte MINI_GAME = 6;
    private static final byte QUIZ1 = 7;
    private static final byte QUIZ2 = 8;
    private static final byte QUIZ3 = 9;

    private Texture helpBgTexture, chapterTexture1, chapterTexture2, creditTexture, mainMenuTexture1, mainMenuTexture2, miniGameTexture, quizTexture1, quizTexture2, quizTexture3, cloudTexture, nextTexture, prevTexture;
    private Sprite chapterSprite, miniGameSprite, mainMenuSprite, quizSprite, creditSprite, next, prev;
    private byte helpSection;

    @Override
    public void setUp(int screenW, int screenH) {
        screenWidth = screenW;
        screenHeight = screenH;
        helpSection = HELP_MENU;

        helpBgTexture = new Texture("help/help-bg.png");
        chapterTexture1 = new Texture("help/chapter-help1.jpg");
        chapterTexture2 = new Texture("help/chapter-help2.jpg");
        creditTexture = new Texture("help/credit-help.png");
        mainMenuTexture1 = new Texture("help/main-menu-help1.png");
        mainMenuTexture2 = new Texture("help/main-menu-help2.png");
        miniGameTexture = new Texture("help/mini-game-help.png");
        quizTexture1 = new Texture("help/quiz-help1.png");
        quizTexture2 = new Texture("help/quiz-help2.png");
        quizTexture3 = new Texture("help/quiz-help3.png");
        cloudTexture = new Texture("help/cloud.jpg");
        nextTexture = new Texture("help/next.png");
        prevTexture = new Texture("help/prev.png");

        final float chapterX = screenWidth / 5.2f;
        final float chapterY = screenHeight / 1.75f;
        final float miniGameX = screenWidth / 2;
        final float miniGameY = screenHeight / 2.1f;
        final float mainMenuX = screenWidth / 3.3f;
        final float mainMenuY = screenHeight / 3.1f;
        final float quizSpriteX= screenWidth / 1.475f;
        final float quizSpriteY = screenHeight / 3.5f;
        final float creditSpriteX = screenWidth / 2.1f;
        final float creditSpriteY = screenHeight / 10;
        final float nextX = screenWidth / 1.45f;
        final float prevX = screenWidth / 3.5f;
        final float nextPrevY = screenHeight / 1.5f;

        next = new Sprite(nextTexture);
        next.setSize(next.getWidth() * getButtonScale() / 2, next.getHeight() * getButtonScale() / 2);
        next.setPosition(nextX, nextPrevY);
        next.setBounds(nextX, nextPrevY, next.getWidth(), next.getHeight());

        prev = new Sprite(prevTexture);
        prev.setSize(next.getWidth(), next.getHeight());
        prev.setPosition(prevX, nextPrevY);
        prev.setBounds(prevX, nextPrevY, prev.getWidth(), prev.getHeight());

        chapterSprite = new Sprite(cloudTexture);
        chapterSprite.setSize(chapterSprite.getWidth() * getButtonScale() * 1.4f, chapterSprite.getHeight() * getButtonScale() * 0.9f);
        chapterSprite.setPosition(chapterX, chapterY);
        chapterSprite.setBounds(chapterX, chapterY, chapterSprite.getWidth(), chapterSprite.getHeight());

        miniGameSprite = new Sprite(cloudTexture);
        miniGameSprite.setSize(chapterSprite.getWidth(), chapterSprite.getHeight());
        miniGameSprite.setPosition(miniGameX, miniGameY);
        miniGameSprite.setBounds(miniGameX, miniGameY, miniGameSprite.getWidth(), miniGameSprite.getHeight());

        mainMenuSprite = new Sprite(cloudTexture);
        mainMenuSprite.setSize(chapterSprite.getWidth(), chapterSprite.getHeight());
        mainMenuSprite.setPosition(mainMenuX, mainMenuY);
        mainMenuSprite.setBounds(mainMenuX, mainMenuY, mainMenuSprite.getWidth(), mainMenuSprite.getHeight());

        quizSprite = new Sprite(cloudTexture);
        quizSprite.setSize(chapterSprite.getWidth(), chapterSprite.getHeight());
        quizSprite.setPosition(quizSpriteX, quizSpriteY);
        quizSprite.setBounds(quizSpriteX, quizSpriteY, quizSprite.getWidth(), quizSprite.getHeight());

        creditSprite = new Sprite(cloudTexture);
        creditSprite.setSize(chapterSprite.getWidth(), chapterSprite.getHeight());
        creditSprite.setPosition(creditSpriteX, creditSpriteY);
        creditSprite.setBounds(creditSpriteX, creditSpriteY, creditSprite.getWidth(), creditSprite.getHeight());
    }

    @Override
    public void display(Batch batch) {
        switch (helpSection) {
            case HELP_MENU:
                batch.draw(helpBgTexture, 0, 0, screenWidth, screenHeight);
                break;
            case CHAPTER1:
                batch.draw(chapterTexture1, 0, 0, screenWidth, screenHeight);
                next.draw(batch);
                break;
            case CHAPTER2:
                batch.draw(chapterTexture2, 0, 0, screenWidth, screenHeight);
                prev.draw(batch);
                break;
            case CREDIT:
                batch.draw(creditTexture, 0, 0, screenWidth, screenHeight);
                break;
            case MENU1:
                batch.draw(mainMenuTexture1, 0, 0, screenWidth, screenHeight);
                next.draw(batch);
                break;
            case MENU2:
                batch.draw(mainMenuTexture2, 0, 0, screenWidth, screenHeight);
                prev.draw(batch);
                break;
            case MINI_GAME:
                batch.draw(miniGameTexture, 0, 0, screenWidth, screenHeight);
                break;
            case QUIZ1:
                batch.draw(quizTexture1, 0, 0, screenWidth, screenHeight);
                next.draw(batch);
                break;
            case QUIZ2:
                batch.draw(quizTexture2, 0, 0, screenWidth, screenHeight);
                next.draw(batch);
                prev.draw(batch);
                break;
            case QUIZ3:
                batch.draw(quizTexture3, 0, 0, screenWidth, screenHeight);
                prev.draw(batch);
                break;
        }
    }

    @Override
    public void dispose() {
        helpBgTexture.dispose();
        chapterTexture1.dispose();
        chapterTexture2.dispose();
        creditTexture.dispose();
        mainMenuTexture1.dispose();
        mainMenuTexture2.dispose();
        miniGameTexture.dispose();
        quizTexture1.dispose();
        quizTexture2.dispose();
        quizTexture3.dispose();
        cloudTexture.dispose();
        nextTexture.dispose();
        prevTexture.dispose();
    }

    /**
     * Detect touch listener for Help
     * @param x X coordinate of touched screen
     * @param y Y coordinate of touched screen
     * @return true to signal back to Chapter
     */
    public boolean touchDown(float x, float y) {
        switch (helpSection) {
            case HELP_MENU:
                if (chapterSprite.getBoundingRectangle().contains(x, y)) {
                    helpSection = CHAPTER1;
                } else if (creditSprite.getBoundingRectangle().contains(x, y)) {
                    helpSection = CREDIT;
                } else if (mainMenuSprite.getBoundingRectangle().contains(x, y)) {
                    helpSection = MENU1;
                } else if (miniGameSprite.getBoundingRectangle().contains(x, y)) {
                    helpSection = MINI_GAME;
                } else if (quizSprite.getBoundingRectangle().contains(x, y)) {
                    helpSection = QUIZ1;
                }
                break;
            case CHAPTER1:
                if (next.getBoundingRectangle().contains(x, y))
                    helpSection = CHAPTER2;
                break;
            case CHAPTER2:
                if (prev.getBoundingRectangle().contains(x, y))
                    helpSection = CHAPTER1;
                break;
            case MENU1:
                if (next.getBoundingRectangle().contains(x, y))
                    helpSection = MENU2;
                break;
            case MENU2:
                if (prev.getBoundingRectangle().contains(x, y))
                    helpSection = MENU1;
                break;
            case QUIZ1:
                if (next.getBoundingRectangle().contains(x, y))
                    helpSection = QUIZ2;
                break;
            case QUIZ2:
                if (next.getBoundingRectangle().contains(x, y))
                    helpSection = QUIZ3;
                else if (prev.getBoundingRectangle().contains(x, y))
                    helpSection = QUIZ1;
                break;
            case QUIZ3:
                if (prev.getBoundingRectangle().contains(x, y))
                    helpSection = QUIZ2;
                break;
        }
        return false;
    }

    /**
     * Detect if user pressed android's back button.
     * @param keycode Pressed keycode
     * @return Returns true if user closes help
     */
    public boolean keyDown(int keycode) {
        if (keycode == 4 && helpSection != HELP_MENU) {
            helpSection = HELP_MENU;
            return false;
        }
        return keycode == 4;
    }
}
