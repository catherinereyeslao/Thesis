package com.example.aralingpanlipunan.views;

import android.util.Log;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.utils.Disposable;
import com.example.aralingpanlipunan.AppFragment;
import com.example.aralingpanlipunan.utils.ScreenSizeUtil;

public class ChapterView extends AppView implements AppFragment, Disposable {
    private static final String QUESTION = "PILIIN ANG URI NG KOMUNIDAD NA MAKIKITA SA LARAWAN";
    private static final String LUNGSOD = "Lungsod";
    private static final String KABUNDUKAN = "Kabundukan";
    private static final String BUKIRIN = "BUKIRIN";
    private static final String BAYBAYIN = "Baybayin";

    private int chapter, chapterSection, correctAnswers = 0;
    private Texture introBg, baybayinBg, kabukirinBg, kabundukanBg, lungsodBg, intro1balloonTexture, intro2balloonTexture, baybayin1Texture, baybayin2Texture, baybayin3Texture, bukid1Texture, bukid2Texture, lungsod1Texture, lungsod2Texture, questionBg, backToChapterTexture, startQuizTexture;
    private TextureAtlas girlAtlas;
    private Sound baybayin1sound, baybayin2sound, baybayin3sound, bukid1sound, bukid2sound, intro1sound, intro2sound, lungsod1sound, lungsod2sound;
    private Animation girlAnimation;
    private Sprite girl, balloonSprite, backgroundSprite, imageQuestion, backToChapters, startQuiz, ans1, ans2, ans3, ans4;
    private BitmapFont question, answer1, answer2, answer3, answer4;
    private float animationCounter, questionX, questionY, questionWidth, answerX, answerY, answer2X, answer2Y, answer3X, answer3Y, answer4X, answer4Y, touchX;
    //TODO: characterIsTouched is confusing attribute name cause we changed something from orig plan, refactor this to something appropriate
    private boolean characterIsTouched, lectureStarted, isDragging = false;

    public ChapterView(int chapterNumber) {
        chapter = chapterNumber;
    }

    @Override
    public void setUp(int screenW, int screenH) {
        screenWidth = screenW;
        screenHeight = screenH;

        switch (chapter) {
            case 1:
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
                backToChapterTexture = new Texture("buttons/exit.png");
                startQuizTexture = new Texture("buttons/menu/start.png");

                backgroundSprite = new Sprite(introBg);
                backgroundSprite.setSize(screenWidth, screenHeight);

                question = new BitmapFont(screenSizeUtil.fontAsset(screenW));
                question.setColor(1, 1, 1, 1);
                question.setScale(2.2f);
                questionWidth = screenWidth / 1.5f;
                questionX = (screenW / 1.7f) - (question.getWrappedBounds(QUESTION, questionWidth).width / 2);
                questionY = (screenH - (screenH / 11)) - ((question.getMultiLineBounds(QUESTION).height / 2));

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
                balloonSprite.setSize((balloonSprite.getWidth() * getButtonScale()) * 2, (balloonSprite.getHeight() * getButtonScale()) * 2);
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
                break;
        }
    }

    @Override
    public void display(Batch batch) {
        switch (chapter) {
            case 1:
                if (characterIsTouched) chapter1AssetManager();
                chapter1Display(batch);
                break;
        }
    }

    @Override
    public void dispose() {
        switch (chapter) {
            case 1:
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
                break;
        }
    }

    /**
     * If android's back key is pressed, return 1 to Student class
     * to give a signal to go back to Chapter Select
     *
     * @param keycode the keycode of the pressed button
     * @return int
     */
    public int keydown(int keycode) {
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

        switch (chapterSection) {
            case 8:
                if (startQuiz.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    characterIsTouched = true;
                }
                if (backToChapters.getBoundingRectangle().contains(x, y))
                    return 50;
                break;
            case 9:
                if (ans1.getBoundingRectangle().contains(x, y)) {
                    Log.i("Touched", "Baybayin");
                    chapterSection++;
                    characterIsTouched = true;
                }
                else if (ans2.getBoundingRectangle().contains(x, y)) {
                    Log.i("Touched", "Kabundukan");
                    chapterSection++;
                    characterIsTouched = true;
                }
                else if (ans3.getBoundingRectangle().contains(x, y)) {
                    Log.i("Touched", "Lungsod");
                    chapterSection++;
                    characterIsTouched = true;
                }
                else if (ans4.getBoundingRectangle().contains(x, y)) {
                    Log.i("Touched", "Bukirin");
                    correctAnswers++;
                    chapterSection++;
                    characterIsTouched = true;
                }
                break;
            case 10:
                if (ans1.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    characterIsTouched = true;
                }
                else if (ans2.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    characterIsTouched = true;
                }
                else if (ans3.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    correctAnswers++;
                    characterIsTouched = true;
                }
                else if (ans4.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    characterIsTouched = true;
                }
                break;
            case 11:
                if (ans1.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    correctAnswers++;
                    characterIsTouched = true;
                }
                else if (ans2.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    characterIsTouched = true;
                }
                else if (ans3.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    characterIsTouched = true;
                }
                else if (ans4.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    characterIsTouched = true;
                }
                break;
            case 12:
                if (ans1.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    characterIsTouched = true;
                }
                else if (ans2.getBoundingRectangle().contains(x, y)) {
                    correctAnswers++;
                    chapterSection++;
                    characterIsTouched = true;
                }
                else if (ans3.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    characterIsTouched = true;
                }
                else if (ans4.getBoundingRectangle().contains(x, y)) {
                    chapterSection++;
                    characterIsTouched = true;
                }
                break;
            case 13:
                return correctAnswers;
        }
        return 100;
    }

    public void touchDragged(int x) {
        float slide = touchX - x;
        Log.i("debug", "chapterSection = " + chapterSection);
        if (chapterSection < 9 && lectureStarted && !isDragging) {
            if (chapterSection > 0 && slide <= screenWidth * -0.20f) {
                chapterSection--;
                isDragging = true;
                characterIsTouched = true;
            } else if (chapterSection < 8 && slide >= screenWidth * 0.20f) {
                chapterSection++;
                isDragging = true;
                characterIsTouched = true;
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
                intro1sound.play();
                balloonSprite.setTexture(intro1balloonTexture);
                break;
            case 1:
                if (backgroundSprite.getTexture() != introBg)
                    backgroundSprite.setTexture(introBg);
                balloonSprite.setTexture(intro2balloonTexture);
                intro1sound.stop();
                intro2sound.play();
                break;
            case 2:
                backgroundSprite.setTexture(baybayinBg);
                balloonSprite.setTexture(baybayin1Texture);
                intro2sound.stop();
                baybayin1sound.play();
                break;
            case 3:
                balloonSprite.setTexture(baybayin2Texture);
                baybayin1sound.stop();
                baybayin2sound.play();
                break;
            case 4:
                if (backgroundSprite.getTexture() != baybayinBg)
                    backgroundSprite.setTexture(baybayinBg);
                balloonSprite.setTexture(baybayin3Texture);
                baybayin2sound.stop();
                baybayin3sound.play();
                break;
            case 5:
                backgroundSprite.setTexture(kabukirinBg);
                balloonSprite.setTexture(bukid1Texture);
                baybayin3sound.stop();
                bukid1sound.play();
                break;
            case 6:
                if (backgroundSprite.getTexture() != kabukirinBg)
                    backgroundSprite.setTexture(kabukirinBg);
                balloonSprite.setTexture(bukid2Texture);
                bukid1sound.stop();
                bukid2sound.play();
                break;
            case 7:
                backgroundSprite.setTexture(lungsodBg);
                balloonSprite.setTexture(lungsod1Texture);
                bukid2sound.stop();
                lungsod1sound.play();
                break;
            case 8:
                if (backgroundSprite.getTexture() != lungsodBg)
                    backgroundSprite.setTexture(lungsodBg);
                balloonSprite.setTexture(lungsod2Texture);
                lungsod1sound.stop();
                lungsod2sound.play();
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
        }
        characterIsTouched = false;
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
                if (!lectureStarted)
                    intro1sound.play();
                lectureStarted = true;
                animationCounter += Gdx.graphics.getDeltaTime();
                girl.setRegion(girlAnimation.getKeyFrame(animationCounter, true));
                balloonSprite.draw(batch);
            }
            girl.draw(batch);
            if (chapterSection == 8) {
                startQuiz.draw(batch);
                backToChapters.draw(batch);
            }
        } else if (chapterSection >= 9) {
            question.drawWrapped(batch, QUESTION, questionX, questionY, questionWidth);
            answer1.draw(batch, LUNGSOD, answerX, answerY);
            answer2.draw(batch, BUKIRIN, answer2X, answer2Y);
            answer3.draw(batch, BAYBAYIN, answer3X, answer3Y);
            answer4.draw(batch, KABUNDUKAN, answer4X, answer4Y);
            imageQuestion.draw(batch);
            ans1.draw(batch);
        }
    }
}
