package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import com.example.aralingpanlipunan.utils.ScreenSizeUtil;
import static com.example.aralingpanlipunan.android.database.DatabaseSetup.CHAPTER_TWO_SCORE;

public class ChapterTwo extends ChapterCore {
    private Texture introBgTexture, introBalloonTexture, directionTexture, mapTexture,
    				direction1BalloonTexture, direction2BalloonTexture, direction3BalloonTexture, 
    				direction4BalloonTexture, direction5BalloonTexture, map1BalloonTexture, map2BalloonTexture,
    				map3BalloonTexture, map4BalloonTexture, 
    				question1Bg, ansKey1Texture, ansKey2Texture, ansKey3Texture, ansKey4Texture;
    private Music introS, d,m;
    private Sprite ans1, ans2, ans3, ans4;
    private BitmapFont answer1, answer2, answer3, answer4;
    private float answerX, answerY, answer2X, answer2Y, answer3X, answer3Y, answer4X, answer4Y;
    private String ans1Char = "a. Hilaga";
    private String ans2Char = "b. Silangan";
    private String ans3Char = "c. Timog";
    private String ans4Char = "d. Kanluran";

    public ChapterTwo(AndroidInterface androidInterface, String studName, String password) {
        super(androidInterface, studName, password);
    }

    public ChapterTwo(AndroidInterface androidInterface, boolean isTeacher) {
        super(androidInterface, isTeacher);
    }

    @Override
    public void setUp(int screenW, int screenH) {
        super.setUp(screenW, screenH);

        titleBgTexture = new Texture("titlepages/chapter2.png");
        if (!isTeacher)
            currentRecordedScore = android.getScoresByStudent(loggedInStudent, studentPassword).get(1); // Get Chapter 2 score
        else
            currentRecordedScore = correctAnswers = 10; // If teacher, no need to count score, they are always perfect!

        startOfQuestionSection = 3;
        lastChapterSection = isTeacher ? 9 : 11; // If teacher, last section is 16, 20 if student
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
        ansKey1Texture = new Texture("chapters/chapter2/answerkeys/anskey1.jpg");
        ansKey2Texture = new Texture("chapters/chapter2/answerkeys/anskey2.jpg");
        ansKey3Texture = new Texture("chapters/chapter2/answerkeys/anskey3.jpg");
        ansKey4Texture = new Texture("chapters/chapter2/answerkeys/anskey4.jpg");

       
        introS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter2/sounds/b-intro.amr"));
        d = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter2/sound2/g-dir1.mp3"));
        m= Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter2/sound2/g-mapa1.mp3"));
        backgroundSprite.setTexture(introBgTexture);
        balloonSprite.setTexture(introBalloonTexture);

        answer1 = new BitmapFont(screenSizeUtil.fontAsset(screenW));
        answer1.setScale(getAnswerFontScale());
        answer1.setColor(1, 1, 1, 1);
        answerX = (screenW - (screenW / 1.75f)) - (answer1.getBounds(ans1Char).width / 2);
        answerY = (screenH / 1.65f) + (answer1.getBounds(ans1Char).height / 2);
        // These ansBounds are invisible sprites so we can listen which answer did the user touch
        // Set an invisible sprite to detect touch on answer fonts
        ans1 = new Sprite(startQuiz.getTexture());
        ans1.setSize(answer1.getBounds(ans1Char).width, answer1.getBounds(ans1Char).height);
        ans1.setPosition(answerX, answerY - answer1.getBounds(ans1Char).height);

        answer2 = new BitmapFont(screenSizeUtil.fontAsset(screenW));
        answer2.setScale(getAnswerFontScale());
        answer2.setColor(1, 1, 1, 1);
        answer2X = answerX;
        answer2Y = answerY - (answer2.getBounds(ans2Char).height * 3);
        // Set an invisible sprite to detect touch on answer fonts
        ans2 = new Sprite(startQuiz.getTexture());
        ans2.setSize(answer2.getBounds(ans2Char).width, answer2.getBounds(ans2Char).height);
        ans2.setPosition(answer2X, answer2Y - answer2.getBounds(ans2Char).height);

        answer3 = new BitmapFont(screenSizeUtil.fontAsset(screenW));
        answer3.setScale(getAnswerFontScale());
        answer3.setColor(1, 1, 1, 1);
        answer3X = (screenW - (screenW / 4.8f)) - (answer1.getBounds(ans1Char).width / 2);
        answer3Y = answerY;
        // Set an invisible sprite to detect touch on answer fonts
        ans3 = new Sprite(startQuiz.getTexture());
        ans3.setSize(answer3.getBounds(ans3Char).width, answer3.getBounds(ans3Char).height);
        ans3.setPosition(answer3X, answer3Y - answer3.getBounds(ans3Char).height);

        answer4 = new BitmapFont(screenSizeUtil.fontAsset(screenW));
        answer4.setScale(getAnswerFontScale());
        answer4.setColor(1, 1, 1, 1);
        answer4X = answer3X;
        answer4Y = answer2Y;
        // Set an invisible sprite to detect touch on answer fonts
        ans4 = new Sprite(startQuiz.getTexture());
        ans4.setSize(answer4.getBounds(ans4Char).width, answer4.getBounds(ans4Char).height);
        ans4.setPosition(answer4X, answer4Y - answer4.getBounds(ans4Char).height);
        toggleSoundVolume();
    }

    @Override
    public void display(Batch batch) {
        if (assetNeedUpdate) assetManager();
        renderSharedAssets(batch);

        if (!isTeacher && chapterSection > 12) {
            question.drawWrapped(batch, tanong, questionX, questionY, questionWidth);
            answer1.draw(batch, ans1Char, answerX, answerY);
            answer2.draw(batch, ans2Char, answer2X, answer2Y);
            answer3.draw(batch, ans3Char, answer3X, answer3Y);
            answer4.draw(batch, ans4Char, answer4X, answer4Y);
        }
        if (chapterSection == lastChapterSection) {
            startQuiz.draw(batch);
            backToChapters.draw(batch);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        introS.stop();
        d.stop();
        m.stop();
        introS.dispose();
        d.dispose();
        m.dispose();
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
        ansKey1Texture.dispose();
        ansKey2Texture.dispose();
        ansKey3Texture.dispose();
        ansKey4Texture.dispose();
        introS.dispose();
       
    }

    @Override
    public int touchDown(float x, float y) {
        super.touchDown(x, y);
        int touched;
        switch (chapterSection) {
            
            case 3:
                if (backToChapters.getBoundingRectangle().contains(x, y))
                    return 50;
                break;
            case 4:
                touched = answerTouchListener(x, y);
                if (touched != 0) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                break;
            case 5:
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
            case 6:
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
            case 7:
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
            case 8:
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
            case 9:
                touched = answerTouchListener(x, y);
                if (touched == 1) {
                    correctAnswers++;
                    chapterSection++;
                    assetNeedUpdate = true;
                } else if (touched != 0 && touched != 4) {
                    chapterSection++;
                    assetNeedUpdate = true;
                }
                if (isTeacher)
                    return displayLastSectionButtons(2, 4, x, y);
                break;
            case 10:
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
            case 11:
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
            case 12:
                return displayLastSectionButtons(2, 4, x, y);
        }
        return 100;
    }

    @Override
    protected void toggleSoundVolume() {
        introS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        d.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        m.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
       
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
              
                introS.play();
                d.stop();
                break;
            case 1:
                backgroundSprite.setTexture(directionTexture);
               
                introS.stop();
                d.play();
                m.stop();
                break;
            case 2:
                backgroundSprite.setTexture(mapTexture);
               
                d.stop();
                m.play();
               
                break;
            case 3: // This is now the game/question area, hide girl & balloon
            	introS.stop();
            	d.stop();
            	m.stop();
                question.setScale(getQuestionFontScale());
                questionX = (screenWidth / 1.7f) - (question.getWrappedBounds(tanong, questionWidth).width / 2);
                questionY = (screenHeight - (screenHeight / 11)) - ((question.getMultiLineBounds(tanong).height / 2));
                ans2Char = "b. Silangan";
                backgroundSprite.setTexture(question1Bg);
                answer1.setColor(1, 1, 1, 1);
                answer2.setColor(1, 1, 1, 1);
                answer3.setColor(1, 1, 1, 1);
                answer4.setColor(1, 1, 1, 1);
                break;
            case 4:
                if (isTeacher)
                    backgroundSprite.setTexture(ansKey1Texture);
                else
                    backgroundSprite.setTexture(questionBg);
                tanong = "SAANG DAKO NG PILIPINAS MATAGTAGPUAN ANG BATANES?";
                break;
            case 5:
                if (isTeacher)
                    backgroundSprite.setTexture(ansKey2Texture);
                tanong = "SAANG DAKO NG PILIPINAS MATATAGPUAN ANG SULU?";
                break;
            case 6:
                if (isTeacher)
                    backgroundSprite.setTexture(ansKey3Texture);
                tanong = "SAANG DAKO NG PILIPINAS MATATAGPUAN ANG DAGAT NG PILIPINAS?";
                break;
            case 7:
                if (isTeacher)
                    backgroundSprite.setTexture(ansKey4Texture);
                tanong = "SAANG DAKO NG PILIPINAS MATATAGPUAN ANG KARAGATANG PASIPIKO?";
                break;
            case 8:
                if (isTeacher)
                    displayQuizResult(CHAPTER_TWO_SCORE, 4);
                tanong = "SAANG DAKO NG PILIPINAS MATATAGPUAN ANG LUZON?";
                ans2Char = "b. Gitnang Bahagi";
                ans2.setSize(answer2.getBounds(ans2Char).width, answer2.getBounds(ans2Char).height);
                answer4.setColor(1, 1, 1, 0); // Hide the 4th choice
                break;
            case 9:
                tanong = "SAANG DAKO NG PILIPINAS MATATAGPUAN ANG VISAYAS?";
                break;
            case 10:
                tanong = "SAANG DAKO NG PILIPINAS MATATAGPUAN ANG MINDANAO?";
                break;
            case 11:
                tanong = correctAnswers >= 4 ? "CONGRATULATIONS!\n You're Passed!\nScore: " + correctAnswers : "YOU'RE FAILED!\nScore: " + correctAnswers;
                answer1.setColor(1, 1, 1, 0);
                answer2.setColor(1, 1, 1, 0);
                answer3.setColor(1, 1, 1, 0);
                backToChapters.setPosition(
                        screenWidth - (screenWidth / 6) - startQuiz.getWidth() / 2,
                        screenHeight / 4.2f
                );
                // If student fails the test
                if (correctAnswers < 4) {
                    startQuiz.setTexture(retakeTexture);
                } else {
                    startQuiz.setTexture(nextChapTexture);
                }
                startQuiz.setPosition(backToChapters.getX(), backToChapters.getY() + startQuiz.getHeight());
                backToChapters.setSize(startQuiz.getWidth(), startQuiz.getHeight());
                saveProgress(CHAPTER_TWO_SCORE);
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

    private float getAnswerFontScale() {
        ScreenSizeUtil screenSizeUtil = new ScreenSizeUtil();
        switch (screenSizeUtil.getScreenCategory(screenWidth)) {
            case ScreenSizeUtil.LDPI:
                return 1.6f;
            case ScreenSizeUtil.MDPI:
                return 1.8f;
            case ScreenSizeUtil.HDPI:
                return 2;
            default:
                return 2.2f;
        }
    }
}
