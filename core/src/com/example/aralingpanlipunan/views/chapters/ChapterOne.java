package com.example.aralingpanlipunan.views.chapters;

import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.utils.Disposable;
import com.example.aralingpanlipunan.AppFragment;
import com.example.aralingpanlipunan.android.AndroidInterface;
import com.example.aralingpanlipunan.android.database.DatabaseSetup;
import com.example.aralingpanlipunan.utils.ScreenSizeUtil;
import com.example.aralingpanlipunan.views.AppView;

public class ChapterOne extends AppView implements AppFragment, Disposable {
    private static final String LUNGSOD = "Lungsod";
    private static final String KABUNDUKAN = "Kabundukan";
    private static final String BUKIRIN = "BUKIRIN";
    private static final String BAYBAYIN = "Baybayin";

    private String tanong = "PILIIN ANG URI NG KOMUNIDAD NA MAKIKITA SA LARAWAN";
    private String loggedInStudent;
    private int chapterSection, correctAnswers = 0;
    private Texture introBg, baybayinBg, kabukirinBg, kabundukanBg, lungsodBg, intro1balloonTexture, intro2balloonTexture, baybayin1Texture, baybayin2Texture, baybayin3Texture, bukid1Texture, bukid2Texture, lungsod1Texture, lungsod2Texture, questionBg, backToChapterTexture, startQuizTexture, helpTexture, soundTexture, retakeTexture, exitTexture, nextChapTexture;
    private TextureAtlas girlAtlas;
    private Sound baybayin1sound, baybayin2sound, baybayin3sound, bukid1sound, bukid2sound, intro1sound, intro2sound, lungsod1sound, lungsod2sound;
    private Animation girlAnimation;
    private Sprite girl, balloonSprite, backgroundSprite, imageQuestion, helpSprite, soundSprite, backToChapters, startQuiz, ans1, ans2, ans3, ans4;
    private BitmapFont question, answer1, answer2, answer3, answer4;
    private float animationCounter, questionX, questionY, questionWidth, answerX, answerY, answer2X, answer2Y, answer3X, answer3Y, answer4X, answer4Y, touchX;
    private boolean assetNeedUpdate, lectureStarted, isDragging = false;
    private AndroidInterface android;
    private int currentScore;

    public ChapterOne(AndroidInterface androidInterface, String studentName) {
        loggedInStudent = studentName;
        android = androidInterface;
    }

    @Override
    public void setUp(int screenW, int screenH) {
        screenWidth = screenW;
        screenHeight = screenH;

        currentScore = android.getScoresByStudent(loggedInStudent).get(0); // Get Chapter1 score

        ScreenSizeUtil screenSizeUtil = new ScreenSizeUtil();
        baybayin1sound = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter1/sounds/baybayin1.mp3"));
        baybayin2sound = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter1/sounds/baybayin2.mp3"));
        baybayin3sound = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter1/sounds/baybayin3.mp3"));
        bukid1sound = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter1/sounds/bukid1.mp3"));
        bukid2sound = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter1/sounds/bukid2.mp3"));
        intro1sound = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter1/sounds/intro1.mp3"));
        intro2sound = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter1/sounds/intro2.mp3"));
        lungsod1sound = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter1/sounds/lungsod1.mp3"));
        lungsod2sound = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter1/sounds/lungsod2.mp3"));
        introBg = new Texture("chapters/chapter1/backgrounds/intro.png");
        baybayinBg = new Texture("chapters/chapter1/backgrounds/baybayin.png");
        kabukirinBg = new Texture("chapters/chapter1/backgrounds/kabukirin.png");
        kabundukanBg = new Texture("chapters/chapter1/backgrounds/kabundukan.png");
        lungsodBg = new Texture("chapters/chapter1/backgrounds/lungsod.png");
        questionBg = new Texture("backgrounds/question.jpg");
        backToChapterTexture = new Texture("buttons/back-to-chapters.png");
        startQuizTexture = new Texture("buttons/menu/start.png");
        helpTexture = new Texture("buttons/help.png");
        soundTexture = new Texture("buttons/sound.png");
        retakeTexture = new Texture("buttons/retake.png");
        exitTexture = new Texture("buttons/exit.png");
        nextChapTexture = new Texture("buttons/next-chapter.png");

        backgroundSprite = new Sprite(introBg);
        backgroundSprite.setSize(screenWidth, screenHeight);

        question = new BitmapFont(screenSizeUtil.fontAsset(screenW));
        question.setColor(1, 1, 1, 1);
        question.setScale(2.2f);
        questionWidth = screenWidth / 1.5f;
        questionX = (screenW / 1.7f) - (question.getWrappedBounds(tanong, questionWidth).width / 2);
        questionY = (screenH - (screenH / 11)) - ((question.getMultiLineBounds(tanong).height / 2));

        answer1 = new BitmapFont(screenSizeUtil.fontAsset(screenW));
        answer1.setScale(1.7f);
        answer1.setColor(1, 1, 1, 1);
        answerX = (screenW - (screenW / 6)) - (answer1.getBounds(LUNGSOD).width / 2);
        answerY = (screenH / 1.5f) + (answer1.getBounds(LUNGSOD).height / 2);
        // Set an invisible sprite to detect touch on answer fonts
        ans1 = new Sprite(startQuizTexture);
        ans1.setAlpha(0);
        ans1.setSize(answer1.getBounds(LUNGSOD).width, answer1.getBounds(LUNGSOD).height);
        ans1.setPosition(answerX, answerY - answer1.getBounds(LUNGSOD).height);


        answer2 = new BitmapFont(screenSizeUtil.fontAsset(screenW));
        answer2.setScale(1.7f);
        answer2.setColor(1, 1, 1, 1);
        answer2X = answerX;
        answer2Y = answerY - (answer2.getBounds(BUKIRIN).height * 3);
        // Set an invisible sprite to detect touch on answer fonts
        ans2 = new Sprite(startQuizTexture);
        ans2.setAlpha(0);
        ans2.setSize(answer2.getBounds(LUNGSOD).width, answer2.getBounds(LUNGSOD).height);
        ans2.setPosition(answer2X, answer2Y - answer2.getBounds(LUNGSOD).height);

        answer3 = new BitmapFont(screenSizeUtil.fontAsset(screenW));
        answer3.setScale(1.7f);
        answer3.setColor(1, 1, 1, 1);
        answer3X = answerX;
        answer3Y = answer2Y - (answer3.getBounds(BAYBAYIN).height * 3);
        // Set an invisible sprite to detect touch on answer fonts
        ans3 = new Sprite(startQuizTexture);
        ans3.setAlpha(0);
        ans3.setSize(answer3.getBounds(LUNGSOD).width, answer3.getBounds(LUNGSOD).height);
        ans3.setPosition(answer3X, answer3Y - answer3.getBounds(LUNGSOD).height);

        answer4 = new BitmapFont(screenSizeUtil.fontAsset(screenW));
        answer4.setScale(1.7f);
        answer4.setColor(1, 1, 1, 1);
        answer4X = answerX;
        answer4Y = answer3Y - (answer4.getBounds(KABUNDUKAN).height * 3);
        // Set an invisible sprite to detect touch on answer fonts
        ans4 = new Sprite(startQuizTexture);
        ans4.setAlpha(0);
        ans4.setSize(answer4.getBounds(LUNGSOD).width, answer4.getBounds(LUNGSOD).height);
        ans4.setPosition(answer4X, answer4Y - answer4.getBounds(LUNGSOD).height);

        imageQuestion = new Sprite(baybayinBg);
        imageQuestion.setSize(screenW / 2.2f, screenH / 2.2f);
        final float imageQuestionX = (screenW / 2) - (imageQuestion.getWidth() / 2);
        final float imageQuestionY = (screenH / 2.2f) - (imageQuestion.getHeight()) / 2;
        imageQuestion.setPosition(imageQuestionX, imageQuestionY);

        intro2balloonTexture = new Texture("chapters/chapter1/balloons/intro2.png");
        baybayin1Texture = new Texture("chapters/chapter1/balloons/baybayin1.png");
        baybayin2Texture = new Texture("chapters/chapter1/balloons/baybayin2.png");
        baybayin3Texture = new Texture("chapters/chapter1/balloons/baybayin3.png");
        bukid1Texture = new Texture("chapters/chapter1/balloons/bukid1.png");
        bukid2Texture = new Texture("chapters/chapter1/balloons/bukid2.png");
        lungsod1Texture = new Texture("chapters/chapter1/balloons/lungsod1.png");
        lungsod2Texture = new Texture("chapters/chapter1/balloons/lungsod2.png");

        girlAtlas = new TextureAtlas("characters/girl/girl.atlas");
        girlAtlas.getRegions().removeIndex(0); // Remove waved hand for now, seems ugly to have this
        girlAnimation = new Animation(0.15f, girlAtlas.getRegions());
        girl = new Sprite(girlAnimation.getKeyFrames()[0]);
        girl.setSize((girl.getWidth() * getButtonScale()) * 1.4f, (girl.getHeight() * getButtonScale()) * 1.4f);
        final float girlX = (screenW / 4) * -1;
        final float girlY = (screenH / 3) - (girl.getHeight() / 2);
        girl.setPosition(girlX, girlY);
        girl.setBounds(girlX, girlY, girl.getWidth(), girl.getHeight());

        intro1balloonTexture = new Texture("chapters/chapter1/balloons/intro1.png");
        balloonSprite = new Sprite(intro1balloonTexture);
        balloonSprite.setSize((balloonSprite.getWidth() * getButtonScale()) * 2.5f, (balloonSprite.getHeight() * getButtonScale()) * 2.5f);
        balloonSprite.setPosition((screenWidth / 5) + (girl.getWidth() / 2), girlY + (girl.getHeight() / 2));

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
    }

    @Override
    public void display(Batch batch) {
        if (assetNeedUpdate) chapter1AssetManager();
        chapter1Display(batch);
    }

    @Override
    public void dispose() {
        exitTexture.dispose();
        nextChapTexture.dispose();
        helpTexture.dispose();
        soundTexture.dispose();
        baybayin1sound.dispose();
        baybayin2sound.dispose();
        baybayin3sound.dispose();
        intro1sound.dispose();
        intro2sound.dispose();
        lungsod1sound.dispose();
        lungsod2sound.dispose();
        bukid1sound.dispose();
        bukid2sound.dispose();
        introBg.dispose();
        intro1balloonTexture.dispose();
        intro2balloonTexture.dispose();
        baybayinBg.dispose();
        kabukirinBg.dispose();
        kabundukanBg.dispose();
        lungsodBg.dispose();
        girlAtlas.dispose();
        backToChapterTexture.dispose();
        startQuizTexture.dispose();
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
     * If user finished
     * the lecture and clicked "back to chapter", 50 is returned to
     * signal to go back to chapters selection. 100 is returned to
     * do nothing. If user finished the quiz, its score is returned
     * to Student class.
     *
     * @param x The x coordinate of touched screen
     * @param y The y coordinate of touched screen
     * @return int
     */
    public int touchDown(float x, float y) {
        touchX = x;
        if (soundSprite.getBoundingRectangle().contains(x, y)) {
            playSoundForSection();
        }

        switch (chapterSection) {
            case 8:
                if (startQuiz.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                if (backToChapters.getBoundingRectangle().contains(x, y))
                    return 50;
                break;
            case 9:
                if (ans1.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                else if (ans2.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                else if (ans3.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                else if (ans4.getBoundingRectangle().contains(x, y)) {
                    correctAnswers++;
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                break;
            case 10:
                if (ans1.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                else if (ans2.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                else if (ans3.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    correctAnswers++;
                    assetNeedUpdate = true;
                }
                else if (ans4.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                break;
            case 11:
                if (ans1.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    correctAnswers++;
                    assetNeedUpdate = true;
                }
                else if (ans2.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                else if (ans3.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                else if (ans4.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                break;
            case 12:
                if (ans1.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                else if (ans2.getBoundingRectangle().contains(x, y)) {
                    correctAnswers++;
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                else if (ans3.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                else if (ans4.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                break;
            case 13:
                // If failed, we give student the option to retake quiz or back to chapters
                Log.i("correct answers", "current score is " + correctAnswers);
                if (correctAnswers < 2) {
                    if (startQuiz.getBoundingRectangle().contains(x, y)) {
                        questionY = (screenHeight - (screenHeight / 11)) - ((question.getMultiLineBounds(tanong).height / 2));
                        chapterSection = 9;
                        correctAnswers = 0;
                        assetNeedUpdate = true;
                        imageQuestion.setAlpha(1);
                        question.setScale(2.2f);
                        tanong = "PILIIN ANG URI NG KOMUNIDAD NA MAKIKITA SA LARAWAN";
                    }
                    else if (backToChapters.getBoundingRectangle().contains(x, y))
                        return 500;
                } else {
                    if (startQuiz.getBoundingRectangle().contains(x, y)) {
                        //TODO: MOVE TO NEXT CHAPTER
                    } else if (backToChapters.getBoundingRectangle().contains(x, y)) {
                        android.exit();
                    }
                }
                break;
        }
        return 100;
    }

    private void playSoundForSection() {
        switch (chapterSection) {
            case 0:
                intro1sound.stop();
                intro1sound.play();
                break;
            case 1:
                intro2sound.stop();
                intro2sound.play();
                break;
            case 2:
                baybayin1sound.stop();
                baybayin1sound.play();
                break;
            case 3:
                baybayin2sound.stop();
                baybayin2sound.play();
                break;
            case 4:
                baybayin3sound.stop();
                baybayin3sound.play();
                break;
            case 5:
                bukid1sound.stop();
                bukid1sound.play();
                break;
            case 6:
                bukid2sound.stop();
                bukid2sound.play();
                break;
            case 7:
                lungsod1sound.stop();
                lungsod1sound.play();
                break;
            case 8:
                lungsod2sound.stop();
                lungsod2sound.play();
                break;
        }
    }

    public void touchDragged(int x) {
        float slide = touchX - x;
        if (chapterSection < 9 && lectureStarted && !isDragging) {
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

    private void chapter1AssetManager() {
        switch (chapterSection) {
            case 0:
                balloonSprite.setTexture(intro1balloonTexture);
                break;
            case 1:
                if (backgroundSprite.getTexture() != introBg)
                    backgroundSprite.setTexture(introBg);
                balloonSprite.setTexture(intro2balloonTexture);
                intro1sound.stop();
                break;
            case 2:
                backgroundSprite.setTexture(baybayinBg);
                balloonSprite.setTexture(baybayin1Texture);
                intro2sound.stop();
                break;
            case 3:
                balloonSprite.setTexture(baybayin2Texture);
                baybayin1sound.stop();
                break;
            case 4:
                if (backgroundSprite.getTexture() != baybayinBg)
                    backgroundSprite.setTexture(baybayinBg);
                balloonSprite.setTexture(baybayin3Texture);
                baybayin2sound.stop();
                break;
            case 5:
                backgroundSprite.setTexture(kabukirinBg);
                balloonSprite.setTexture(bukid1Texture);
                baybayin3sound.stop();
                break;
            case 6:
                if (backgroundSprite.getTexture() != kabukirinBg)
                    backgroundSprite.setTexture(kabukirinBg);
                balloonSprite.setTexture(bukid2Texture);
                bukid1sound.stop();
                break;
            case 7:
                backgroundSprite.setTexture(lungsodBg);
                balloonSprite.setTexture(lungsod1Texture);
                bukid2sound.stop();
                break;
            case 8:
                if (backgroundSprite.getTexture() != lungsodBg)
                    backgroundSprite.setTexture(lungsodBg);
                balloonSprite.setTexture(lungsod2Texture);
                lungsod1sound.stop();
                break;
            case 9:
                backgroundSprite.setTexture(questionBg);
                lungsod2sound.stop();
                break;
            case 10:
                imageQuestion.setTexture(kabundukanBg);
                break;
            case 11:
                imageQuestion.setTexture(lungsodBg);
                break;
            case 12:
                imageQuestion.setTexture(kabukirinBg);
                break;
            case 13:
                imageQuestion.setAlpha(0);
                question.setScale(3.5f);
                questionY = (screenHeight - (screenHeight / 9)) - ((question.getMultiLineBounds(tanong).height / 2));
                tanong = correctAnswers >= 2 ? "CONGRATULATIONS!\n You're Passed!" : "YOU'RE FAILED!";
                saveProgress();
                backToChapters.setPosition(
                        screenWidth - (screenWidth / 6) - startQuiz.getWidth() / 2,
                        screenHeight / 4.2f
                );
                // If student fails the test
                if (correctAnswers < 2)
                    startQuiz.setTexture(retakeTexture);
                else {
                    startQuiz.setTexture(nextChapTexture);
                    backToChapters.setTexture(exitTexture);
                }
                backToChapters.setSize(startQuiz.getWidth(), startQuiz.getHeight());
                startQuiz.setPosition(backToChapters.getX(), backToChapters.getY() + startQuiz.getHeight());
                break;

        }
        assetNeedUpdate = false;
    }

    /**
     * If achieved score is higher than currently recorded chapter 1 score, then update
     * the student's score record.
     */
    private void saveProgress() {
        if (correctAnswers > currentScore) {
            try {
                android.setStudentScore(loggedInStudent, DatabaseSetup.CHAPTER_ONE_SCORE, correctAnswers);
                android.showToast("Your progress has been saved", 1);
            } catch (SQLiteException e) {
                android.showToast("Failed to save data", 1);
            }
        }
    }

    /**
     * Renders the content for Chapter 1
     * @param batch The batch of the main game
     */
    private void chapter1Display(Batch batch) {
        backgroundSprite.draw(batch);

        if (chapterSection < 9) {
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
            if (chapterSection == 8) {
                startQuiz.draw(batch);
                backToChapters.draw(batch);
            }
        } else if (chapterSection >= 9 && chapterSection < 13) {
            question.drawWrapped(batch, tanong, questionX, questionY, questionWidth);
            answer1.draw(batch, LUNGSOD, answerX, answerY);
            answer2.draw(batch, BUKIRIN, answer2X, answer2Y);
            answer3.draw(batch, BAYBAYIN, answer3X, answer3Y);
            answer4.draw(batch, KABUNDUKAN, answer4X, answer4Y);
            imageQuestion.draw(batch);
            ans1.draw(batch);
        } else if (chapterSection == 13) {
            question.drawMultiLine(batch, tanong, questionX, questionY, screenWidth * 0.65f, BitmapFont.HAlignment.CENTER);
            startQuiz.draw(batch);
            backToChapters.draw(batch);
        }
    }
}
