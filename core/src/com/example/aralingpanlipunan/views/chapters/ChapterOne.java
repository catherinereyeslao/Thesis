package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.example.aralingpanlipunan.android.AndroidInterface;
import com.example.aralingpanlipunan.android.database.DatabaseSetup;
import com.example.aralingpanlipunan.utils.ScreenSizeUtil;

public class ChapterOne extends ChapterCore {
    private static final String LUNGSOD = "Lungsod";
    private static final String KABUNDUKAN = "Kabundukan";
    private static final String BUKIRIN = "BUKIRIN";
    private static final String BAYBAYIN = "Baybayin";

    private Texture introBg, baybayinBg, kabukirinBg, kabundukanBg, lungsodBg, intro1balloonTexture, intro2balloonTexture, baybayin1Texture, baybayin2Texture, baybayin3Texture, bukid1Texture, bukid2Texture, lungsod1Texture, lungsod2Texture, backToChapterTexture, startQuizTexture;
    private Sound baybayin1sound, baybayin2sound, baybayin3sound, bukid1sound, bukid2sound, intro1sound, intro2sound, lungsod1sound, lungsod2sound;
    private Sprite ans1, ans2, ans3, ans4;
    private BitmapFont answer1, answer2, answer3, answer4;
    private float answerX, answerY, answer2X, answer2Y, answer3X, answer3Y, answer4X, answer4Y;
    private boolean questionStarted = false;

    public ChapterOne(AndroidInterface androidInterface, String studentName) {
        super(androidInterface, studentName);
    }

    @Override
    public void setUp(int screenW, int screenH) {
        super.setUp(screenW, screenH);
        screenWidth = screenW;
        screenHeight = screenH;
        startOfQuestionSection = 9;

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
        backToChapterTexture = new Texture("buttons/back-to-chapters.png");
        startQuizTexture = new Texture("buttons/menu/start.png");
        intro1balloonTexture = new Texture("chapters/chapter1/balloons/intro1.png");

        backgroundSprite = new Sprite(introBg);
        backgroundSprite.setSize(screenWidth, screenHeight);
        balloonSprite.setTexture(intro1balloonTexture);

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
    }

    @Override
    public void display(Batch batch) {
        if (assetNeedUpdate) assetManager();
            chapter1Display(batch);
    }

    @Override
    public void dispose() {
        super.dispose();
        exitTexture.dispose();
        nextChapTexture.dispose();
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
        backToChapterTexture.dispose();
        startQuizTexture.dispose();
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
    @Override
    public int touchDown(float x, float y) {
        super.touchDown(x, y);
        if (soundSprite.getBoundingRectangle().contains(x, y)) {
            playSoundForSection();
        }

        switch (chapterSection) {
            case 8:
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
                else if (questionStarted && ans4.getBoundingRectangle().contains(x, y)) {
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
                return displayLastSectionButtons(1, x, y);
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

    /**
     * When assetNeedUpdate is true, this will be called to update
     * properties of objects & other assets. Any tasks that are
     * not supposed to be called at all time should be placed here to
     * help improve performance
     */
    private void assetManager() {
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
                backgroundSprite.setTexture(lungsodBg);
                balloonSprite.setTexture(lungsod2Texture);
                lungsod1sound.stop();
                break;
            case 9:
                backgroundSprite.setTexture(questionBg);
                lungsod2sound.stop();
                questionStarted = true;
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
                saveProgress(DatabaseSetup.CHAPTER_ONE_SCORE);
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
                startQuiz.setPosition(backToChapters.getX(), backToChapters.getY() + startQuiz.getHeight());
                backToChapters.setSize(startQuiz.getWidth(), startQuiz.getHeight());
                break;

        }
        assetNeedUpdate = false;
    }

    /**
     * Renders the content for Chapter 1
     * @param batch The batch of the main game
     */
    private void chapter1Display(Batch batch) {
        backgroundSprite.draw(batch);

        if (chapterSection < startOfQuestionSection) {
            renderSharedAssets(batch);
        } else if (chapterSection >= startOfQuestionSection && chapterSection < 13) {
            question.drawWrapped(batch, tanong, questionX, questionY, questionWidth);
            answer1.draw(batch, LUNGSOD, answerX, answerY);
            answer2.draw(batch, BUKIRIN, answer2X, answer2Y);
            answer3.draw(batch, BAYBAYIN, answer3X, answer3Y);
            answer4.draw(batch, KABUNDUKAN, answer4X, answer4Y);
            imageQuestion.draw(batch);
        } else if (chapterSection == 13) {
            question.drawMultiLine(batch, tanong, questionX, questionY, screenWidth * 0.65f, BitmapFont.HAlignment.CENTER);
            startQuiz.draw(batch);
            backToChapters.draw(batch);
        }
    }
}
