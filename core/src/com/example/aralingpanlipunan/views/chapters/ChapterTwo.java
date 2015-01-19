package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import com.example.aralingpanlipunan.utils.ScreenSizeUtil;

public class ChapterTwo extends ChapterCore {
    private Texture introBgTexture, introBalloonTexture, directionTexture, mapTexture, direction1BalloonTexture, direction2BalloonTexture, direction3BalloonTexture, direction4BalloonTexture, direction5BalloonTexture, map1BalloonTexture, map2BalloonTexture, map3BalloonTexture, map4BalloonTexture, question1Bg;
    private Sound tingSound;
    private Sprite ans1, ans2, ans3, ans4;
    private BitmapFont answer1, answer2, answer3, answer4;
    private float answerX, answerY, answer2X, answer2Y, answer3X, answer3Y, answer4X, answer4Y;
    private String ans1Char = "a. Hilaga";
    private String ans2Char = "b. Silangan";
    private String ans3Char = "c. Timog";
    private String ans4Char = "d. Kanluran";

    public ChapterTwo(AndroidInterface androidInterface, String studName) {
        super(androidInterface, studName);
    }

    @Override
    public void setUp(int screenW, int screenH) {
        super.setUp(screenW, screenH);
        startOfQuestionSection = 12;
        lastChapterSection = 19;
        tanong = "SAANG DAKO NG PILIPINAS MATAGTAGPUAN ANG SULU?";

        ScreenSizeUtil screenSizeUtil = new ScreenSizeUtil();
        introBgTexture = new Texture("chapters/chapter2/backgrounds/intro.png");
        introBalloonTexture = new Texture("chapters/chapter2/balloons/intro.png");
        directionTexture = new Texture("chapters/chapter2/backgrounds/direksyon.png");
        mapTexture = new Texture("chapters/chapter2/backgrounds/mapa.png");
        direction1BalloonTexture = new Texture("chapters/chapter2/balloons/direction1.png");
        direction2BalloonTexture = new Texture("chapters/chapter2/balloons/direction2.png");
        direction3BalloonTexture = new Texture("chapters/chapter2/balloons/direction3.png");
        direction4BalloonTexture = new Texture("chapters/chapter2/balloons/direction4.png");
        direction5BalloonTexture = new Texture("chapters/chapter2/balloons/direction5.png");
        map1BalloonTexture = new Texture("chapters/chapter2/balloons/map1.png");
        map2BalloonTexture = new Texture("chapters/chapter2/balloons/map2.png");
        map3BalloonTexture = new Texture("chapters/chapter2/balloons/map3.png");
        map4BalloonTexture = new Texture("chapters/chapter2/balloons/map4.png");
        question1Bg = new Texture("chapters/chapter2/backgrounds/game1.jpg");

        tingSound = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter2/sounds/ting.mp3"));

        backgroundSprite.setTexture(introBgTexture);
        balloonSprite.setTexture(introBalloonTexture);

        answer1 = new BitmapFont(screenSizeUtil.fontAsset(screenW));
        answer1.setScale(2.2f);
        answer1.setColor(1, 1, 1, 1);
        answerX = (screenW - (screenW / 1.75f)) - (answer1.getBounds(ans1Char).width / 2);
        answerY = (screenH / 1.65f) + (answer1.getBounds(ans1Char).height / 2);
        // These ansBounds are invisible sprites so we can listen which answer did the user touch
        // Set an invisible sprite to detect touch on answer fonts
        ans1 = new Sprite(startQuiz.getTexture());
        ans1.setSize(answer1.getBounds(ans1Char).width, answer1.getBounds(ans1Char).height);
        ans1.setPosition(answerX, answerY - answer1.getBounds(ans1Char).height);

        answer2 = new BitmapFont(screenSizeUtil.fontAsset(screenW));
        answer2.setScale(2.2f);
        answer2.setColor(1, 1, 1, 1);
        answer2X = answerX;
        answer2Y = answerY - (answer2.getBounds(ans2Char).height * 3);
        // Set an invisible sprite to detect touch on answer fonts
        ans2 = new Sprite(startQuiz.getTexture());
        ans2.setSize(answer2.getBounds(ans2Char).width, answer2.getBounds(ans2Char).height);
        ans2.setPosition(answer2X, answer2Y - answer2.getBounds(ans2Char).height);

        answer3 = new BitmapFont(screenSizeUtil.fontAsset(screenW));
        answer3.setScale(2.2f);
        answer3.setColor(1, 1, 1, 1);
        answer3X = (screenW - (screenW / 4.8f)) - (answer1.getBounds(ans1Char).width / 2);
        answer3Y = answerY;
        // Set an invisible sprite to detect touch on answer fonts
        ans3 = new Sprite(startQuiz.getTexture());
        ans3.setSize(answer3.getBounds(ans3Char).width, answer3.getBounds(ans3Char).height);
        ans3.setPosition(answer3X, answer3Y - answer3.getBounds(ans3Char).height);

        answer4 = new BitmapFont(screenSizeUtil.fontAsset(screenW));
        answer4.setScale(2.2f);
        answer4.setColor(1, 1, 1, 1);
        answer4X = answer3X;
        answer4Y = answer2Y;
        // Set an invisible sprite to detect touch on answer fonts
        ans4 = new Sprite(startQuiz.getTexture());
        ans4.setSize(answer4.getBounds(ans4Char).width, answer4.getBounds(ans4Char).height);
        ans4.setPosition(answer4X, answer4Y - answer4.getBounds(ans4Char).height);
    }

    @Override
    public void display(Batch batch) {
        if (assetNeedUpdate) assetManager();
        renderSharedAssets(batch);

        if (chapterSection > 12) {
            question.drawWrapped(batch, tanong, questionX, questionY, questionWidth);
            answer1.draw(batch, ans1Char, answerX, answerY);
            answer2.draw(batch, ans2Char, answer2X, answer2Y);
            answer3.draw(batch, ans3Char, answer3X, answer3Y);
            answer4.draw(batch, ans4Char, answer4X, answer4Y);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        introBgTexture.dispose();
        introBalloonTexture.dispose();
        directionTexture.dispose();
        mapTexture.dispose();
        direction1BalloonTexture.dispose();
        direction2BalloonTexture.dispose();
        direction3BalloonTexture.dispose();
        direction4BalloonTexture.dispose();
        direction5BalloonTexture.dispose();
        map1BalloonTexture.dispose();
        map2BalloonTexture.dispose();
        map3BalloonTexture.dispose();
        map4BalloonTexture.dispose();
    }

    @Override
    public int touchDown(float x, float y) {
        super.touchDown(x, y);
        int touched;
        switch (chapterSection) {
            case 1:
                //TODO: Play the correct voice over here in 1 & 2
                if (soundSprite.getBoundingRectangle().contains(x, y))
                    tingSound.play();
                break;
            case 2:
                tingSound.stop();
                break;
            case 11:
                if (backToChapters.getBoundingRectangle().contains(x, y))
                    return 50;
                break;
            case 12:
                touched = answerTouchListener(x, y);
                if (touched != 0) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                break;
            case 13:
                touched = answerTouchListener(x, y);
                if (touched == 3) {
                    correctAnswers++;
                    chapterSection++;
                    assetNeedUpdate = true;
                } else if (touched != 0) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                break;
            case 14:
                touched = answerTouchListener(x, y);
                if (touched == 1) {
                    correctAnswers++;
                    chapterSection++;
                    assetNeedUpdate = true;
                } else if (touched != 0) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                break;
            case 15:
                touched = answerTouchListener(x, y);
                if (touched == 4) {
                    correctAnswers++;
                    chapterSection++;
                    assetNeedUpdate = true;
                } else if (touched != 0) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                break;
            case 16:
                touched = answerTouchListener(x, y);
                if (touched == 2) {
                    correctAnswers++;
                    chapterSection++;
                    assetNeedUpdate = true;
                } else if (touched != 0) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                break;
            case 17:
                touched = answerTouchListener(x, y);
                if (touched == 1) {
                    correctAnswers++;
                    chapterSection++;
                    assetNeedUpdate = true;
                } else if (touched != 0 && touched != 4) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                break;
            case 18:
                touched = answerTouchListener(x, y);
                if (touched == 2) {
                    correctAnswers++;
                    chapterSection++;
                    assetNeedUpdate = true;
                } else if (touched != 0 && touched != 4) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                break;
            case 19:
                touched = answerTouchListener(x, y);
                if (touched == 3) {
                    correctAnswers++;
                    chapterSection++;
                    assetNeedUpdate = true;
                } else if (touched != 0 && touched != 4) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                break;
        }
        return 100;
    }

    /**
     * This assetManager manages asset on Demand (assetNeedUpdate = true)
     * This is where we put calls when we need to change the bg,
     * balloon, display or hide assets. These mentioned tasks should
     * only be called on demand, otherwise, we risk having a slow
     * performance app due to running unnecessary tasks
     */
    private void assetManager() {
        switch (chapterSection) {
            case 0:
                backgroundSprite.setTexture(introBgTexture);
                balloonSprite.setTexture(introBalloonTexture);
                balloonSprite.setAlpha(1);
                break;
            case 1:
                backgroundSprite.setTexture(directionTexture);
                balloonSprite.setAlpha(0);
                break;
            case 2:
                balloonSprite.setTexture(direction1BalloonTexture);
                balloonSprite.setAlpha(1);
                break;
            case 3:
                balloonSprite.setTexture(direction2BalloonTexture);
                break;
            case 4:
                balloonSprite.setTexture(direction3BalloonTexture);
                break;
            case 5:
                balloonSprite.setTexture(direction4BalloonTexture);
                break;
            case 6:
                backgroundSprite.setTexture(directionTexture);
                balloonSprite.setTexture(direction5BalloonTexture);
                break;
            case 7:
                backgroundSprite.setTexture(mapTexture);
                balloonSprite.setAlpha(0);
                balloonSprite.setTexture(map1BalloonTexture);
                break;
            case 8:
                balloonSprite.setAlpha(1);
                break;
            case 9:
                balloonSprite.setTexture(map2BalloonTexture);
                break;
            case 10:
                balloonSprite.setTexture(map3BalloonTexture);
                break;
            case 11:
                balloonSprite.setTexture(map4BalloonTexture);
                break;
            case 12: // This is now the game/question area, hide girl & balloon
                backgroundSprite.setTexture(question1Bg);
                break;
            case 13:
                backgroundSprite.setTexture(questionBg);
                tanong = "SAANG DAKO NG PILIPINAS MATAGTAGPUAN ANG BATANES?";
                break;
            case 14:
                tanong = "SAANG DAKO NG PILIPINAS MATATAGPUAN ANG SULU?";
                break;
            case 15:
                tanong = "SAANG DAKO NG PILIPINAS MATATAGPUAN ANG DAGAT NG PILIPINAS?";
                break;
            case 16:
                tanong = "SAANG DAKO NG PILIPINAS MATATAGPUAN ANG KARAGATANG PASIPIKO?";
                break;
            case 17:
                tanong = "SAANG DAKO NG PILIPINAS MATATAGPUAN ANG LUZON?";
                ans2Char = "b. Gitnang Bahagi";
                ans2.setSize(answer2.getBounds(ans2Char).width, answer2.getBounds(ans2Char).height);
                answer4.setColor(1, 1, 1, 0); // Hide the 4th choice
                break;
            case 18:
                tanong = "SAANG DAKO NG PILIPINAS MATATAGPUAN ANG VISAYAS?";
                break;
            case 19:
                tanong = "SAANG DAKO NG PILIPINAS MATATAGPUAN ANG MINDANAO?";
                break;
            case 20:
                tanong = "You Scored " + correctAnswers + "! Will improve this later";
                break;
        }
        assetNeedUpdate = false;
    }

    /**
     * Detects which among the 4 answer choices is touched
     * @param x The x coordinate of touched screen
     * @param y The y coordinate of touched screen
     * @return int The number representing which ans is touched
     */
    private int answerTouchListener(float x, float y) {
        if (ans1.getBoundingRectangle().contains(x, y))
            return 1;
        else if (ans2.getBoundingRectangle().contains(x, y))
            return 2;
        else if (ans3.getBoundingRectangle().contains(x, y))
            return 3;
        else if (ans4.getBoundingRectangle().contains(x, y))
            return 4;
        else
            return 0;
    }
}
