package com.example.aralingpanlipunan.views.chapters;

import android.database.sqlite.SQLiteException;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Disposable;
import com.example.aralingpanlipunan.AppFragment;
import com.example.aralingpanlipunan.android.AndroidInterface;
import com.example.aralingpanlipunan.utils.ScreenSizeUtil;
import com.example.aralingpanlipunan.views.AppView;

public abstract class ChapterCore extends AppView implements AppFragment, Disposable {
    protected AndroidInterface android;
    protected TextureAtlas girlAtlas;
    protected Animation girlAnimation;
    protected Sprite girl, balloonSprite, backgroundSprite, imageQuestion, helpSprite, soundSprite, backToChapters, startQuiz;
    protected String loggedInStudent;
    protected int chapterSection, correctAnswers = 0;
    protected int startOfQuestionSection, lastChapterSection = 10;
    protected boolean assetNeedUpdate, lectureStarted, isDragging, questionIsDraggable = false;
    protected float animationCounter, touchX, questionX, questionY, questionWidth = 0;
    protected String tanong = "PILIIN ANG URI NG KOMUNIDAD NA MAKIKITA SA LARAWAN";
    protected Texture questionBg, retakeTexture, exitTexture, nextChapTexture;
    protected BitmapFont question;
    protected int currentScore = 0;
    private Texture helpTexture, soundTexture, startQuizTexture, backToChapterTexture;

    public ChapterCore(AndroidInterface androidInterface, String studentName) {
        this.android = androidInterface;
        this.loggedInStudent = studentName;
    }

    @Override
    public void setUp(int screenW, int screenH) {
        screenWidth = screenW;
        screenHeight = screenH;
        ScreenSizeUtil screenSizeUtil = new ScreenSizeUtil();
        Texture introBalloonTexture = new Texture("chapters/chapter1/balloons/intro1.png");
        helpTexture = new Texture("buttons/help.png");
        soundTexture = new Texture("buttons/sound.png");
        startQuizTexture = new Texture("buttons/menu/start.png");
        backToChapterTexture = new Texture("buttons/back-to-chapters.png");
        questionBg = new Texture("backgrounds/question.jpg");
        retakeTexture = new Texture("buttons/retake.png");
        exitTexture = new Texture("buttons/exit.png");
        nextChapTexture = new Texture("buttons/next-chapter.png");

        backgroundSprite = new Sprite(introBalloonTexture);
        backgroundSprite.setSize(screenW, screenH);

        girlAtlas = new TextureAtlas("characters/girl/girl.atlas");
        girlAtlas.getRegions().removeIndex(0); // Remove waved hand for now, seems ugly to have this
        girlAnimation = new Animation(0.15f, girlAtlas.getRegions());
        girl = new Sprite(girlAnimation.getKeyFrames()[0]);
        girl.setSize(girl.getWidth() * getButtonScale() * 1.3f, girl.getHeight() * getButtonScale() * 1.3f);
        final float girlX = (screenW / 4) * -1;
        final float girlY = (screenH / 2.8f) - (girl.getHeight() / 2);
        girl.setPosition(girlX, girlY);
        girl.setBounds(girlX, girlY, girl.getWidth(), girl.getHeight());

        balloonSprite = new Sprite(introBalloonTexture);
        balloonSprite.setSize(balloonSprite.getWidth() * getButtonScale() * 2.3f, balloonSprite.getHeight() * getButtonScale() * 2.3f);
        balloonSprite.setPosition((screenW / 5) + (girl.getWidth() / 2), girlY + (girl.getHeight() / 2));

        helpSprite = new Sprite(helpTexture);
        helpSprite.setSize((helpSprite.getWidth() * getButtonScale() / 1.8f), (helpSprite.getHeight() * getButtonScale() / 1.8f));
        final float helpSpriteX = (screenW / 10) - (helpSprite.getWidth() / 2);
        final float helpSpriteY = (screenH - (screenH / 10)) - (helpSprite.getHeight() / 2);
        helpSprite.setPosition(helpSpriteX, helpSpriteY);
        helpSprite.setBounds(helpSpriteX, helpSpriteY, helpSprite.getWidth(), helpSprite.getHeight());

        soundSprite = new Sprite(soundTexture);
        soundSprite.setSize(helpSprite.getWidth(), helpSprite.getHeight());
        final float soundSpriteX = helpSpriteX + soundSprite.getWidth();
        soundSprite.setPosition(soundSpriteX, helpSpriteY);
        soundSprite.setBounds(soundSpriteX, helpSpriteY, soundSprite.getWidth(), soundSprite.getHeight());

        startQuiz = new Sprite(startQuizTexture);
        startQuiz.setSize(startQuiz.getWidth() * getButtonScale(), startQuiz.getHeight() * getButtonScale());
        final float startQuizX = (screenW - (screenW / 8)) - (startQuiz.getWidth() / 2);
        final float startQuizY = (screenH / 4) - (startQuiz.getHeight() / 2);
        startQuiz.setPosition(startQuizX, startQuizY);
        startQuiz.setBounds(startQuizX, startQuizY, startQuiz.getWidth(), startQuiz.getHeight());

        backToChapters = new Sprite(backToChapterTexture);
        backToChapters.setSize(startQuiz.getWidth(), startQuiz.getHeight());
        final float backToChapY = startQuizY - (backToChapters.getHeight());
        backToChapters.setPosition(startQuizX, backToChapY);
        backToChapters.setBounds(startQuizX, backToChapY, backToChapters.getWidth(), backToChapters.getHeight());

        question = new BitmapFont(screenSizeUtil.fontAsset(screenW));
        question.setColor(1, 1, 1, 1);
        question.setScale(getQuestionFontScale());
        questionWidth = screenWidth / 1.5f;
        questionX = (screenW / 1.7f) - (question.getWrappedBounds(tanong, questionWidth).width / 2);
        questionY = (screenH - (screenH / 11)) - ((question.getMultiLineBounds(tanong).height / 2));

        introBalloonTexture.dispose();
    }

    @Override
    public void dispose() {
        helpTexture.dispose();
        soundTexture.dispose();
        startQuizTexture.dispose();
        backToChapterTexture.dispose();
        questionBg.dispose();
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
     * This method renders all shared assets across all chapters in the game.
     * Put this in the chapter's draw method to put the animating girl and balloon
     * @param batch Batch
     */
    protected void  renderSharedAssets(Batch batch) {
        backgroundSprite.draw(batch);
        if (girl.getX() < (screenWidth / 5) - (girl.getWidth() / 2)) {
            girl.setX(girl.getX() + 5);
        } else if (chapterSection < startOfQuestionSection) {
            lectureStarted = true;
            animationCounter += Gdx.graphics.getDeltaTime();
            girl.setRegion(girlAnimation.getKeyFrame(animationCounter, true));
            balloonSprite.draw(batch);
        }
        if (chapterSection < startOfQuestionSection) {
            girl.draw(batch);
            helpSprite.draw(batch);
            soundSprite.draw(batch);
        }
        if (chapterSection == startOfQuestionSection - 1) {
            startQuiz.draw(batch);
            backToChapters.draw(batch);
        }
    }

    public int touchDown(float x, float y) {
        touchX = x;
        if (chapterSection == startOfQuestionSection-1) {
            if (startQuiz.getBoundingRectangle().contains(x, y)) {
                chapterSection++;
                assetNeedUpdate = true;
            }
        }
        return 100;
    }

    /**
     * Detects touch drag event so we'll move to next balloon
     * @param x The x coordinate of the finger's current position
     */
    public void touchDragged(int x) {
        float slide = touchX - x;
        if ((chapterSection < startOfQuestionSection || questionIsDraggable) && lectureStarted && !isDragging) {
            if (((chapterSection > 0 && chapterSection < startOfQuestionSection) || (questionIsDraggable && chapterSection > startOfQuestionSection)) && slide <= screenWidth * -0.20f) {
                chapterSection--;
                isDragging = true;
                assetNeedUpdate = true;
            } else if ((questionIsDraggable || chapterSection < startOfQuestionSection-1) && slide >= screenWidth * 0.20f && chapterSection < lastChapterSection) {
                if (chapterSection != startOfQuestionSection-1) {
                    chapterSection++;
                    isDragging = true;
                    assetNeedUpdate = true;
                }
            }
        }
    }

    public void touchUp() {
        touchX = 0;
        isDragging = false;
    }

    /**
     * If achieved score is higher than currently recorded chapter 1 score, then update
     * the student's score record.
     * @param chapter String The name of the database table to update the chapter record after the game
     */
    protected void saveProgress(String chapter) {
        if (correctAnswers > currentScore) {
            try {
                android.setStudentScore(loggedInStudent, chapter, correctAnswers);
                android.showToast("Your progress has been saved", 1);
            } catch (SQLiteException e) {
                android.showToast("Failed to save data", 1);
            }
        }
    }

    /**
     * Display the last 2 buttons at the end of the quiz. User will be able to retake the quiz
     * if they failed. If passed, they'll have the option to take the next chapter
     * @param currentChapNum int Current Chapter number
     * @param x float The x coordinate of touched screen
     * @param y float The y coordinate of touched screen
     * @return int
     */
    protected int displayLastSectionButtons(int currentChapNum, float x, float y) {
        // If failed, we give student the option to retake quiz or back to chapters
        if (correctAnswers < 2) {
            if (startQuiz.getBoundingRectangle().contains(x, y)) {
                questionY = (screenHeight - (screenHeight / 11)) - ((question.getMultiLineBounds(tanong).height / 2));
                chapterSection = startOfQuestionSection;
                correctAnswers = 0;
                assetNeedUpdate = true;
                imageQuestion.setAlpha(1);
                question.setScale(getQuestionFontScale() + 0.4f);
                tanong = "PILIIN ANG URI NG KOMUNIDAD NA MAKIKITA SA LARAWAN";
            }
            else if (backToChapters.getBoundingRectangle().contains(x, y))
                return 500;
        } else {
            if (startQuiz.getBoundingRectangle().contains(x, y)) {
                return currentChapNum + 501;
            } else if (backToChapters.getBoundingRectangle().contains(x, y)) {
                android.exit();
            }
        }
        return 100;
    }

    /**
     * All shared across all chapters (all those we've loaded here
     * in chapterCore) will be disposed.
     *
     * @deprecated Please use super.dispose() instead
     */
    protected void disposeSharedAssets() {
        helpTexture.dispose();
        soundTexture.dispose();
    }

    /**
     * Default assets being shared between all chapters should be placed
     * here. Always place this in the setUp() method of the child class
     * This sets up the girl & balloon above her
     *
     * @deprecated Please use super.setUp(screenW, screenH)
     */
    protected void setUpDefaultAssets() {
        Texture introBalloonTexture = new Texture("chapters/chapter1/balloons/intro1.png");
        helpTexture = new Texture("buttons/help.png");
        soundTexture = new Texture("buttons/sound.png");
        startQuizTexture = new Texture("buttons/menu/start.png");
        backToChapterTexture = new Texture("buttons/back-to-chapters.png");

        backgroundSprite = new Sprite(introBalloonTexture);
        backgroundSprite.setSize(screenWidth, screenHeight);

        girlAtlas = new TextureAtlas("characters/girl/girl.atlas");
        girlAtlas.getRegions().removeIndex(0); // Remove waved hand for now, seems ugly to have this
        girlAnimation = new Animation(0.15f, girlAtlas.getRegions());
        girl = new Sprite(girlAnimation.getKeyFrames()[0]);
        girl.setSize((girl.getWidth() * getButtonScale()) * 1.2f, (girl.getHeight() * getButtonScale()) * 1.2f);
        final float girlX = (screenWidth / 4) * -1;
        final float girlY = (screenHeight / 3) - (girl.getHeight() / 2);
        girl.setPosition(girlX, girlY);
        girl.setBounds(girlX, girlY, girl.getWidth(), girl.getHeight());

        balloonSprite = new Sprite(introBalloonTexture);
        balloonSprite.setSize((balloonSprite.getWidth() * getButtonScale()) * 2, (balloonSprite.getHeight() * getButtonScale()) * 2);
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

        startQuiz = new Sprite(startQuizTexture);
        startQuiz.setSize(startQuiz.getWidth() * getButtonScale(), startQuiz.getHeight() * getButtonScale());
        final float startQuizX = (screenWidth - (screenWidth / 8)) - (startQuiz.getWidth() / 2);
        final float startQuizY = (screenHeight / 4) - (startQuiz.getHeight() / 2);
        startQuiz.setPosition(startQuizX, startQuizY);
        startQuiz.setBounds(startQuizX, startQuizY, startQuiz.getWidth(), startQuiz.getHeight());

        backToChapters = new Sprite(backToChapterTexture);
        backToChapters.setSize(startQuiz.getWidth(), startQuiz.getHeight());
        final float backToChapY = startQuizY - (backToChapters.getHeight());
        backToChapters.setPosition(startQuizX, backToChapY);
        backToChapters.setBounds(startQuizX, backToChapY, backToChapters.getWidth(), backToChapters.getHeight());

        introBalloonTexture.dispose();
    }

    private float getQuestionFontScale() {
        ScreenSizeUtil screenSizeUtil = new ScreenSizeUtil();
        switch (screenSizeUtil.getScreenCategory(screenWidth)) {
            case ScreenSizeUtil.LDPI:
                return 1.4f;
            case ScreenSizeUtil.MDPI:
                return 1.8f;
            case ScreenSizeUtil.HDPI:
                return 2;
            case ScreenSizeUtil.XHDPI:
                return 2.2f;
            default:
                return 2.2f;
        }
    }
}
