package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import static com.example.aralingpanlipunan.android.database.DatabaseSetup.CHAPTER_TWELVE_SCORE;

public class ChapterTwelve extends ChapterCore {
    private Texture pagPintaTexture, panitikanTexture, sayawTexture, introTexture, musikaTexture, question1Texture, question2Texture, intro1Balloon, intro2Balloon, musika1Balloon, musika2Balloon, musika3Balloon, musika4Balloon, pagpinta1Balloon, pagpinta2Balloon, panitikan1Balloon, panitikan2Balloon, panitikan3Balloon, panitikan4Balloon, panitikan5Balloon, panitikan6Balloon, sayaw1Balloon, sayaw2Balloon, sayaw3Balloon, ansMarkerTexture;
    private Sprite ans1A, ans1B, ans1C, ans1D, ans2A, ans2B, ans2C, ans2D, ans3A, ans3B, ans3C, ans3D, ans4A, ans4B, ans4C, ans4D;
    private Music intro1S, intro2S, musika1S, musika2S, musika3S, musika4S, panitikan1S, panitikan2S, panitikan3S, panitikan4S,
    			  panitikan5S, panitikan6S, pinta1S, pinta2S, sayaw1S, sayaw2S, sayaw3S;
    private boolean ans1Correct, ans2Correct, ans3Correct, ans4Correct, ans5Correct, ans6Correct, ans7Correct;

    public ChapterTwelve(AndroidInterface androidInterface, String studentName) {
        super(androidInterface, studentName);
    }

    public ChapterTwelve(AndroidInterface androidInterface, boolean isTeacher) {
        super(androidInterface, isTeacher);
    }

    @Override
    public void setUp(int screenW, int screenH) {
        super.setUp(screenW, screenH);
        startOfQuestionSection = 17;
        lastChapterSection = 19;
        
        //sounds
        intro1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter12/sounds/intro1chap12.m4a"));
        intro2S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter12/sounds/intro2chap12.m4a"));
        musika1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter12/sounds/musika1.m4a"));
        musika2S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter12/sounds/musika2.m4a"));
        musika3S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter12/sounds/musika3.m4a"));
        musika4S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter12/sounds/musika4.m4a"));
        panitikan1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter12/sounds/panitikan1.m4a"));
        panitikan2S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter12/sounds/panitikan2.m4a"));
        panitikan3S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter12/sounds/panitikan3.m4a"));
        panitikan4S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter12/sounds/panitikan4.m4a"));
        panitikan5S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter12/sounds/panitikan5.m4a"));
        panitikan6S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter12/sounds/panitikan6.m4a"));
        pinta1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter12/sounds/pinta1.m4a"));
        pinta2S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter12/sounds/pinta2.m4a"));
        sayaw1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter12/sounds/sayaw1.m4a"));
        sayaw2S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter12/sounds/sayaw2.m4a"));
        sayaw3S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter12/sounds/sayaw3.m4a"));

        // backgrounds
        introTexture = new Texture("chapters/chapter12/backgrounds/intro.png");
        pagPintaTexture = new Texture("chapters/chapter8/backgrounds/Background sa Pagpinta.png");
        sayawTexture = new Texture("chapters/chapter8/backgrounds/Background sa Sayaw.png");
        panitikanTexture = new Texture("chapters/chapter8/backgrounds/Background sa Panitikan.png");
        musikaTexture = new Texture("chapters/chapter12/backgrounds/Musika.jpg");

        // balloons
        intro1Balloon = new Texture("chapters/chapter12/balloons/intro1.png");
        intro2Balloon = new Texture("chapters/chapter12/balloons/intro2.png");
        musika1Balloon = new Texture("chapters/chapter12/balloons/musika1.png");
        musika2Balloon = new Texture("chapters/chapter12/balloons/musika2.png");
        musika3Balloon = new Texture("chapters/chapter12/balloons/musika3.png");
        musika4Balloon = new Texture("chapters/chapter12/balloons/musika4.png");
        pagpinta1Balloon = new Texture("chapters/chapter12/balloons/pagpinta1.png");
        pagpinta2Balloon = new Texture("chapters/chapter12/balloons/pagpinta2.png");
        panitikan1Balloon = new Texture("chapters/chapter12/balloons/panitikan1.png");
        panitikan2Balloon = new Texture("chapters/chapter12/balloons/panitikan2.png");
        panitikan3Balloon = new Texture("chapters/chapter12/balloons/panitikan3.png");
        panitikan4Balloon = new Texture("chapters/chapter12/balloons/panitikan4.png");
        panitikan5Balloon = new Texture("chapters/chapter12/balloons/panitikan5.png");
        panitikan6Balloon = new Texture("chapters/chapter12/balloons/panitikan6.png");
        sayaw1Balloon = new Texture("chapters/chapter12/balloons/sayaw1.png");
        sayaw2Balloon = new Texture("chapters/chapter12/balloons/sayaw2.png");
        sayaw3Balloon = new Texture("chapters/chapter12/balloons/sayaw3.png");

        if (isTeacher) {
            question1Texture = new Texture("chapters/chapter12/answerkeys/answer1.jpg");
            question2Texture = new Texture("chapters/chapter12/answerkeys/answer2.jpg");
            correctAnswers = currentRecordedScore = 7;
        } else {
            question1Texture = new Texture("chapters/chapter12/backgrounds/question1.jpg");
            question2Texture = new Texture("chapters/chapter12/backgrounds/question2.jpg");

            ansMarkerTexture = new Texture("box.png");
            ans1A = new Sprite(ansMarkerTexture);
            ans1A.setSize((ans1A.getWidth() * getButtonScale()) / 1.1345f, (ans1A.getHeight() * getButtonScale()) / 3.397f);

            ans1B = new Sprite(ansMarkerTexture);
            ans1B.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans1C = new Sprite(ansMarkerTexture);
            ans1C.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans1D = new Sprite(ansMarkerTexture);
            ans1D.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans2A = new Sprite(ansMarkerTexture);
            ans2A.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans2B = new Sprite(ansMarkerTexture);
            ans2B.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans2C = new Sprite(ansMarkerTexture);
            ans2C.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans2D = new Sprite(ansMarkerTexture);
            ans2D.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans3A = new Sprite(ansMarkerTexture);
            ans3A.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans3B = new Sprite(ansMarkerTexture);
            ans3B.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans3C = new Sprite(ansMarkerTexture);
            ans3C.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans3D = new Sprite(ansMarkerTexture);
            ans3D.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans4A = new Sprite(ansMarkerTexture);
            ans4A.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans4B = new Sprite(ansMarkerTexture);
            ans4B.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans4C = new Sprite(ansMarkerTexture);
            ans4C.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans4D = new Sprite(ansMarkerTexture);
            ans4D.setSize(ans1A.getWidth(), ans1A.getHeight());
            loadNextButton();
        }
        assetNeedUpdate = true;
    }

    @Override
    public void display(Batch batch) {
        if (assetNeedUpdate)
            assetManager();
        renderSharedAssets(batch);

        if (!isTeacher && chapterSection >= startOfQuestionSection && chapterSection < lastChapterSection) {
            ans1A.draw(batch);
            ans1B.draw(batch);
            ans1C.draw(batch);
            ans1D.draw(batch);
            ans2A.draw(batch);
            ans2B.draw(batch);
            ans2C.draw(batch);
            ans2D.draw(batch);
            ans3A.draw(batch);
            ans3B.draw(batch);
            ans3C.draw(batch);
            ans3D.draw(batch);
            ans4A.draw(batch);
            ans4B.draw(batch);
            ans4C.draw(batch);
            ans4D.draw(batch);
            next.draw(batch);
        }

        drawQuizResult(batch);
    }

    private void assetManager() {
        float leftCol, rightCol, row1, row2, row3, row4, row5, row6, row7, row8;
        switch (chapterSection) {
            case 0:
                backgroundSprite.setTexture(introTexture);
                balloonSprite.setTexture(intro1Balloon);
                intro2S.stop();
                break;
            case 1:
                backgroundSprite.setTexture(introTexture);
                balloonSprite.setTexture(intro2Balloon);
                intro1S.stop();
                musika1S.stop();
                break;
            case 2:
                backgroundSprite.setTexture(musikaTexture);
                balloonSprite.setTexture(musika1Balloon);
                intro2S.stop();
                musika2S.stop();
                break;
            case 3:
                balloonSprite.setTexture(musika2Balloon);
                musika1S.stop();
                musika3S.stop();
                break;
            case 4:
                balloonSprite.setTexture(musika3Balloon);
                musika2S.stop();
                musika4S.stop();
                break;
            case 5:
                backgroundSprite.setTexture(musikaTexture);
                backgroundSprite.setTexture(musikaTexture);
                balloonSprite.setTexture(musika4Balloon);
                musika3S.stop();
                pinta1S.stop();
                break;
            case 6:
                backgroundSprite.setTexture(pagPintaTexture);
                balloonSprite.setTexture(pagpinta1Balloon);
                musika4S.stop();
                pinta2S.stop();
                break;
            case 7:
                backgroundSprite.setTexture(pagPintaTexture);
                balloonSprite.setTexture(pagpinta2Balloon);
                panitikan1S.stop();
                pinta1S.stop();
                break;
            case 8:
                backgroundSprite.setTexture(panitikanTexture);
                balloonSprite.setTexture(panitikan1Balloon);
                pinta2S.stop();
                panitikan2S.stop();
                break;
            case 9:
                balloonSprite.setTexture(panitikan2Balloon);
                panitikan1S.stop();
                panitikan3S.stop();
                break;
            case 10:
                balloonSprite.setTexture(panitikan3Balloon);
                panitikan2S.stop();
                panitikan4S.stop();
                break;
            case 11:
                balloonSprite.setTexture(panitikan4Balloon);
                panitikan3S.stop();
                panitikan5S.stop();
                break;
            case 12:
                balloonSprite.setTexture(panitikan5Balloon);
                panitikan4S.stop();
                panitikan6S.stop();
                break;
            case 13:
                backgroundSprite.setTexture(panitikanTexture);
                balloonSprite.setTexture(panitikan6Balloon);
                panitikan5S.stop();
                sayaw1S.stop();
                break;
            case 14:
                backgroundSprite.setTexture(sayawTexture);
                balloonSprite.setTexture(sayaw1Balloon);
                panitikan6S.stop();
                sayaw2S.stop();
                break;
            case 15:
                balloonSprite.setTexture(sayaw2Balloon);
                sayaw1S.stop();
                sayaw3S.stop();
                break;
            case 16:
                backgroundSprite.setTexture(sayawTexture);
                balloonSprite.setTexture(sayaw3Balloon);
                sayaw2S.stop();
                break;
            case 17: // Start of game/quiz
            	sayaw3S.stop();
                backgroundSprite.setTexture(question1Texture);

                if (!isTeacher) {
                    ans1Correct = ans2Correct = ans3Correct = ans4Correct = false;
                    leftCol = screenWidth / 3.1f;
                    rightCol = screenWidth / 1.66f;
                    row1 = screenHeight / 1.41f;
                    row2 = screenHeight / 1.51f;
                    row3 = screenHeight / 1.75f;
                    row4 = screenHeight / 1.93f;
                    row5 = screenHeight / 2.37f;
                    row6 = screenHeight / 2.65f;
                    row7 = screenHeight / 3.618f;
                    row8 = screenHeight / 4.3f;

                    ans1A.setPosition(leftCol, row1);
                    ans1A.setBounds(leftCol, row1, ans1A.getWidth(), ans1A.getHeight());
                    ans1A.setAlpha(0);

                    ans1B.setPosition(leftCol, row2);
                    ans1B.setBounds(leftCol, row2, ans1B.getWidth(), ans1B.getHeight());
                    ans1B.setAlpha(0);

                    ans1C.setPosition(rightCol, row1);
                    ans1C.setBounds(rightCol, row1, ans1A.getWidth(), ans1A.getHeight());
                    ans1C.setAlpha(0);

                    ans1D.setPosition(rightCol, row2);
                    ans1D.setBounds(rightCol, row2, ans1B.getWidth(), ans1B.getHeight());
                    ans1D.setAlpha(0);

                    ans2A.setPosition(leftCol, row3);
                    ans2A.setBounds(leftCol, row3, ans2A.getWidth(), ans2A.getHeight());
                    ans2A.setAlpha(0);

                    ans2B.setPosition(leftCol, row4);
                    ans2B.setBounds(leftCol, row4, ans2B.getWidth(), ans2B.getHeight());
                    ans2B.setAlpha(0);

                    ans2C.setPosition(rightCol, row3);
                    ans2C.setBounds(rightCol, row3, ans2A.getWidth(), ans2A.getHeight());
                    ans2C.setAlpha(0);

                    ans2D.setPosition(rightCol, row4);
                    ans2D.setBounds(rightCol, row4, ans2B.getWidth(), ans2B.getHeight());
                    ans2D.setAlpha(0);

                    ans3A.setSize(ans1A.getWidth(), ans1A.getHeight());
                    ans3A.setPosition(leftCol, row5);
                    ans3A.setBounds(leftCol, row5, ans3A.getWidth(), ans3A.getHeight());
                    ans3A.setAlpha(0);

                    ans3B.setSize(ans1A.getWidth(), ans1A.getHeight());
                    ans3B.setPosition(leftCol, row6);
                    ans3B.setBounds(leftCol, row6, ans3B.getWidth(), ans3B.getHeight());
                    ans3B.setAlpha(0);

                    ans3C.setPosition(rightCol, row5);
                    ans3C.setBounds(rightCol, row5, ans3A.getWidth(), ans3A.getHeight());
                    ans3C.setAlpha(0);

                    ans3D.setPosition(rightCol, row6);
                    ans3D.setBounds(rightCol, row6, ans3B.getWidth(), ans3B.getHeight());
                    ans3D.setAlpha(0);

                    ans4A.setPosition(leftCol, row7);
                    ans4A.setBounds(leftCol, row7, ans4A.getWidth(), ans4A.getHeight());
                    ans4A.setAlpha(0);

                    ans4B.setPosition(leftCol, row8);
                    ans4B.setBounds(leftCol, row8, ans4B.getWidth(), ans4B.getHeight());
                    ans4B.setAlpha(0);

                    ans4C.setPosition(rightCol, row7);
                    ans4C.setBounds(rightCol, row7, ans4A.getWidth(), ans4A.getHeight());
                    ans4C.setAlpha(0);

                    ans4D.setPosition(rightCol, row8);
                    ans4D.setBounds(rightCol, row8, ans4B.getWidth(), ans4B.getHeight());
                    ans4D.setAlpha(0);
                }
                break;
            case 18:
                backgroundSprite.setTexture(question2Texture);

                if (!isTeacher) {
                    if (ans1Correct) correctAnswers++;
                    if (ans2Correct) correctAnswers++;
                    if (ans3Correct) correctAnswers++;
                    if (ans4Correct) correctAnswers++;

                    ans5Correct = ans6Correct = ans7Correct = false;
                    leftCol = screenWidth / 2.95f;
                    rightCol = screenWidth / 1.59f;
                    row1 = screenHeight / 1.33f;
                    row2 = screenHeight / 1.43f;
                    row3 = screenHeight / 1.64f;
                    row4 = screenHeight / 1.8f;
                    row5 = screenHeight / 2.41f;
                    row6 = screenHeight / 2.68f;
                    row7 = screenHeight / 3.12f;
                    row8 = screenHeight / 3.75f;

                    ans1A.setPosition(leftCol, row1);
                    ans1A.setBounds(leftCol, row1, ans1A.getWidth(), ans1A.getHeight());
                    ans1A.setAlpha(0);

                    ans1B.setPosition(leftCol, row2);
                    ans1B.setBounds(leftCol, row2, ans1B.getWidth(), ans1B.getHeight());
                    ans1B.setAlpha(0);

                    ans1C.setPosition(rightCol, row1);
                    ans1C.setBounds(rightCol, row1, ans1A.getWidth(), ans1A.getHeight());
                    ans1C.setAlpha(0);

                    ans1D.setPosition(rightCol, row2);
                    ans1D.setBounds(rightCol, row2, ans1B.getWidth(), ans1B.getHeight());
                    ans1D.setAlpha(0);

                    ans2A.setPosition(leftCol, row3);
                    ans2A.setBounds(leftCol, row3, ans2A.getWidth(), ans2A.getHeight());
                    ans2A.setAlpha(0);

                    ans2B.setPosition(leftCol, row4);
                    ans2B.setBounds(leftCol, row4, ans2B.getWidth(), ans2B.getHeight());
                    ans2B.setAlpha(0);

                    ans2C.setPosition(rightCol, row3);
                    ans2C.setBounds(rightCol, row3, ans2A.getWidth(), ans2A.getHeight());
                    ans2C.setAlpha(0);

                    ans2D.setPosition(rightCol, row4);
                    ans2D.setBounds(rightCol, row4, ans2B.getWidth(), ans2B.getHeight());
                    ans2D.setAlpha(0);

                    ans3A.setSize(ans3A.getWidth() * 1.6f, ans3A.getHeight());
                    ans3A.setPosition(leftCol, row5);
                    ans3A.setBounds(leftCol, row5, ans3A.getWidth(), ans3A.getHeight());
                    ans3A.setAlpha(0);

                    ans3B.setSize(ans3B.getWidth() * 1.6f, ans3B.getHeight());
                    ans3B.setPosition(leftCol, row6);
                    ans3B.setBounds(leftCol, row6, ans3B.getWidth(), ans3B.getHeight());
                    ans3B.setAlpha(0);

                    ans3C.setPosition(leftCol, row7);
                    ans3C.setBounds(leftCol, row7, ans3C.getWidth(), ans3C.getHeight());
                    ans3C.setAlpha(0);

                    ans3D.setPosition(leftCol, row8);
                    ans3D.setBounds(leftCol, row8, ans3D.getWidth(), ans3D.getHeight());
                    ans3D.setAlpha(0);

                    ans4A.setAlpha(0);
                    ans4B.setAlpha(0);
                    ans4C.setAlpha(0);
                    ans4D.setAlpha(0);
                }
                break;
            case 19:
                if (!isTeacher && ans5Correct) correctAnswers++;
                if (!isTeacher && ans6Correct) correctAnswers++;
                if (!isTeacher && ans7Correct) correctAnswers++;

                displayQuizResult(CHAPTER_TWELVE_SCORE, 4);
                break;
        }
        assetNeedUpdate = false;
    }

    @Override
    public int touchDown(float x, float y) {
    	if (soundSprite.getBoundingRectangle().contains(x, y)) {
            playSoundForSection();
        }
        if (!isTeacher) {
            switch (chapterSection) {
                case 17:
                    if (ans1A.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(1);
                        ans1B.setAlpha(0);
                        ans1C.setAlpha(0);
                        ans1D.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans1B.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(1);
                        ans1C.setAlpha(0);
                        ans1D.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans1C.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(0);
                        ans1C.setAlpha(1);
                        ans1D.setAlpha(0);
                        ans1Correct = true;
                    } else if (ans1D.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(0);
                        ans1C.setAlpha(0);
                        ans1D.setAlpha(1);
                        ans1Correct = false;
                    }

                    if (ans2A.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(1);
                        ans2B.setAlpha(0);
                        ans2C.setAlpha(0);
                        ans2D.setAlpha(0);
                        ans2Correct = true;
                    } else if (ans2B.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(0);
                        ans2B.setAlpha(1);
                        ans2C.setAlpha(0);
                        ans2D.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans2C.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(0);
                        ans2B.setAlpha(0);
                        ans2C.setAlpha(1);
                        ans2D.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans2D.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(0);
                        ans2B.setAlpha(0);
                        ans2C.setAlpha(0);
                        ans2D.setAlpha(1);
                        ans2Correct = false;
                    }

                    if (ans3A.getBoundingRectangle().contains(x, y)) {
                        ans3A.setAlpha(1);
                        ans3B.setAlpha(0);
                        ans3C.setAlpha(0);
                        ans3D.setAlpha(0);
                        ans3Correct = false;
                    } else if (ans3B.getBoundingRectangle().contains(x, y)) {
                        ans3A.setAlpha(0);
                        ans3B.setAlpha(1);
                        ans3C.setAlpha(0);
                        ans3D.setAlpha(0);
                        ans3Correct = true;
                    } else if (ans3C.getBoundingRectangle().contains(x, y)) {
                        ans3A.setAlpha(0);
                        ans3B.setAlpha(0);
                        ans3C.setAlpha(1);
                        ans3D.setAlpha(0);
                        ans3Correct = false;
                    } else if (ans3D.getBoundingRectangle().contains(x, y)) {
                        ans3A.setAlpha(0);
                        ans3B.setAlpha(0);
                        ans3C.setAlpha(0);
                        ans3D.setAlpha(1);
                        ans3Correct = false;
                    }

                    if (ans4A.getBoundingRectangle().contains(x, y)) {
                        ans4A.setAlpha(1);
                        ans4B.setAlpha(0);
                        ans4C.setAlpha(0);
                        ans4D.setAlpha(0);
                        ans4Correct = true;
                    } else if (ans4B.getBoundingRectangle().contains(x, y)) {
                        ans4A.setAlpha(0);
                        ans4B.setAlpha(1);
                        ans4C.setAlpha(0);
                        ans4D.setAlpha(0);
                        ans4Correct = false;
                    } else if (ans4C.getBoundingRectangle().contains(x, y)) {
                        ans4A.setAlpha(0);
                        ans4B.setAlpha(0);
                        ans4C.setAlpha(1);
                        ans4D.setAlpha(0);
                        ans4Correct = false;
                    } else if (ans4D.getBoundingRectangle().contains(x, y)) {
                        ans4A.setAlpha(0);
                        ans4B.setAlpha(0);
                        ans4C.setAlpha(0);
                        ans4D.setAlpha(1);
                        ans4Correct = false;
                    }
                    break;
                case 18:
                    if (ans1A.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(1);
                        ans1B.setAlpha(0);
                        ans1C.setAlpha(0);
                        ans1D.setAlpha(0);
                        ans5Correct = false;
                    } else if (ans1B.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(1);
                        ans1C.setAlpha(0);
                        ans1D.setAlpha(0);
                        ans5Correct = true;
                    } else if (ans1C.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(0);
                        ans1C.setAlpha(1);
                        ans1D.setAlpha(0);
                        ans5Correct = false;
                    } else if (ans1D.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(0);
                        ans1C.setAlpha(0);
                        ans1D.setAlpha(1);
                        ans5Correct = false;
                    }

                    if (ans2A.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(1);
                        ans2B.setAlpha(0);
                        ans2C.setAlpha(0);
                        ans2D.setAlpha(0);
                        ans6Correct = false;
                    } else if (ans2B.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(0);
                        ans2B.setAlpha(1);
                        ans2C.setAlpha(0);
                        ans2D.setAlpha(0);
                        ans6Correct = false;
                    } else if (ans2C.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(0);
                        ans2B.setAlpha(0);
                        ans2C.setAlpha(1);
                        ans2D.setAlpha(0);
                        ans6Correct = true;
                    } else if (ans2D.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(0);
                        ans2B.setAlpha(0);
                        ans2C.setAlpha(0);
                        ans2D.setAlpha(1);
                        ans6Correct = false;
                    }

                    if (ans3A.getBoundingRectangle().contains(x, y)) {
                        ans3A.setAlpha(1);
                        ans3B.setAlpha(0);
                        ans3C.setAlpha(0);
                        ans3D.setAlpha(0);
                        ans7Correct = true;
                    } else if (ans3B.getBoundingRectangle().contains(x, y)) {
                        ans3A.setAlpha(0);
                        ans3B.setAlpha(1);
                        ans3C.setAlpha(0);
                        ans3D.setAlpha(0);
                        ans7Correct = false;
                    } else if (ans3C.getBoundingRectangle().contains(x, y)) {
                        ans3A.setAlpha(0);
                        ans3B.setAlpha(0);
                        ans3C.setAlpha(1);
                        ans3D.setAlpha(0);
                        ans7Correct = false;
                    } else if (ans3D.getBoundingRectangle().contains(x, y)) {
                        ans3A.setAlpha(0);
                        ans3B.setAlpha(0);
                        ans3C.setAlpha(0);
                        ans3D.setAlpha(1);
                        ans7Correct = false;
                    }
                    break;
            }
        }

        if (chapterSection == lastChapterSection)
            return displayLastSectionButtons(12, 4, x, y);
        return super.touchDown(x, y);
    }

    private void playSoundForSection() {
		// TODO Auto-generated method stub
    	switch (chapterSection) {
        case 0:
            intro1S.stop();
            intro1S.play();
            break;
        case 1:
       	 	intro2S.stop();
       	 	intro2S.play();
       	 	break;
        case 2:
    	 	musika1S.stop();
    	 	musika1S.play();
    	 	break;
        case 3:
	    	musika2S.stop();
	    	musika2S.play();
        case 4:
	    	musika3S.stop();
	    	musika3S.play();
	    	break;
        case 5:
	    	musika4S.stop();
	    	musika4S.play();
	    	break;
        case 6:
	    	panitikan1S.stop();
	    	panitikan1S.play();
	    	break;
       case 7:
	    	panitikan2S.stop();
	    	panitikan2S.play();
	    	break;
       case 8:
	    	panitikan3S.stop();
	    	panitikan3S.play();
	    	break;
       case 9:
	    	panitikan4S.stop();
	    	panitikan4S.play();
	    	break;
       case 10:
	    	panitikan5S.stop();
	    	panitikan5S.play();
	    	break;
       case 11:
	    	panitikan6S.stop();
	    	panitikan6S.play();
	    	break;
       case 12:
	    	pinta1S.stop();
	    	pinta1S.play();
	    	break;
       case 13:	    	
	    	pinta2S.stop();
	    	pinta2S.play();
	    	break;
       case 14:
	    	sayaw1S.stop();
	    	sayaw1S.play();
	    	break;
       case 15:
	    	sayaw2S.stop();
	    	sayaw2S.play();
	    	break;
        case 16:
	    	sayaw3S.stop();
	    	sayaw3S.play();
	    	break;
    	}
		
	}

	@Override
    public void dispose() {
		intro1S.stop();
		intro2S.stop();
		musika1S.stop();
		musika2S.stop();
		musika3S.stop();
		musika4S.stop();
		panitikan1S.stop();
		panitikan2S.stop();
		panitikan3S.stop();
		panitikan4S.stop();
		panitikan5S.stop();
		panitikan6S.stop();
		pinta1S.stop();
		pinta2S.stop();
		sayaw1S.stop();
		sayaw2S.stop();
		sayaw3S.stop();
		
		intro1S.dispose();
		intro2S.dispose();
		musika1S.dispose();
		musika2S.dispose();
		musika3S.dispose();
		musika4S.dispose();
		panitikan1S.dispose();
		panitikan2S.dispose();
		panitikan3S.dispose();
		panitikan4S.dispose();
		panitikan5S.dispose();
		panitikan6S.dispose();
		pinta1S.dispose();
		pinta2S.dispose();
		sayaw1S.dispose();
		sayaw2S.dispose();
		sayaw3S.dispose();
		
        introTexture.dispose();
        pagPintaTexture.dispose();
        sayawTexture.dispose();
        panitikanTexture.dispose();
        musikaTexture.dispose();
        question1Texture.dispose();
        question2Texture.dispose();

        intro1Balloon.dispose();
        intro2Balloon.dispose();
        musika1Balloon.dispose();
        musika2Balloon.dispose();
        musika3Balloon.dispose();
        musika4Balloon.dispose();
        pagpinta1Balloon.dispose();
        pagpinta2Balloon.dispose();
        panitikan1Balloon.dispose();
        panitikan2Balloon.dispose();
        panitikan3Balloon.dispose();
        panitikan4Balloon.dispose();
        panitikan5Balloon.dispose();
        panitikan6Balloon.dispose();
        sayaw1Balloon.dispose();
        sayaw2Balloon.dispose();
        sayaw3Balloon.dispose();
        if (!isTeacher)
            ansMarkerTexture.dispose();
    }
}
