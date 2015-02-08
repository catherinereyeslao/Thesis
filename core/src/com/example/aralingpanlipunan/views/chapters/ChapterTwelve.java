package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import static com.example.aralingpanlipunan.android.database.DatabaseSetup.CHAPTER_TWELVE_SCORE;

public class ChapterTwelve extends ChapterCore {
    private Texture pagPintaTexture, panitikanTexture, sayawTexture, introTexture, musikaTexture, question1Texture, question2Texture, intro1Balloon, intro2Balloon, musika1Balloon, musika2Balloon, musika3Balloon, musika4Balloon, pagpinta1Balloon, pagpinta2Balloon, panitikan1Balloon, panitikan2Balloon, panitikan3Balloon, panitikan4Balloon, panitikan5Balloon, panitikan6Balloon, sayaw1Balloon, sayaw2Balloon, sayaw3Balloon, ansMarkerTexture;
    private Sprite ans1A, ans1B, ans1C, ans1D, ans2A, ans2B, ans2C, ans2D, ans3A, ans3B, ans3C, ans3D, ans4A, ans4B, ans4C, ans4D;

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
            question1Texture = new Texture("chapters/chapter12/answerleys/answer1.jpg");
            question2Texture = new Texture("chapters/chapter12/answerleys/answer2.jpg");
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
        }
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
        }
    }

    private void assetManager() {
        float leftCol, rightCol, row1, row2, row3, row4, row5, row6, row7, row8;
        switch (chapterSection) {
            case 0:
                backgroundSprite.setTexture(introTexture);
                balloonSprite.setTexture(intro1Balloon);
                break;
            case 1:
                backgroundSprite.setTexture(introTexture);
                balloonSprite.setTexture(intro2Balloon);
                break;
            case 2:
                backgroundSprite.setTexture(musikaTexture);
                balloonSprite.setTexture(musika1Balloon);
                break;
            case 3:
                balloonSprite.setTexture(musika2Balloon);
                break;
            case 4:
                balloonSprite.setTexture(musika3Balloon);
                break;
            case 5:
                backgroundSprite.setTexture(musikaTexture);
                balloonSprite.setTexture(musika4Balloon);
                break;
            case 6:
                backgroundSprite.setTexture(pagPintaTexture);
                balloonSprite.setTexture(pagpinta1Balloon);
                break;
            case 7:
                backgroundSprite.setTexture(pagPintaTexture);
                balloonSprite.setTexture(pagpinta2Balloon);
                break;
            case 8:
                backgroundSprite.setTexture(panitikanTexture);
                balloonSprite.setTexture(panitikan1Balloon);
                break;
            case 9:
                balloonSprite.setTexture(panitikan2Balloon);
                break;
            case 10:
                balloonSprite.setTexture(panitikan3Balloon);
                break;
            case 11:
                balloonSprite.setTexture(panitikan4Balloon);
                break;
            case 12:
                balloonSprite.setTexture(panitikan5Balloon);
                break;
            case 13:
                backgroundSprite.setTexture(panitikanTexture);
                balloonSprite.setTexture(panitikan6Balloon);
                break;
            case 14:
                backgroundSprite.setTexture(sayawTexture);
                balloonSprite.setTexture(sayaw1Balloon);
                break;
            case 15:
                balloonSprite.setTexture(sayaw2Balloon);
                break;
            case 16:
                balloonSprite.setTexture(sayaw3Balloon);
                break;
            case 17: // Start of game/quiz
                backgroundSprite.setTexture(question1Texture);
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

                ans1B.setPosition(leftCol, row2);
                ans1B.setBounds(leftCol, row2, ans1B.getWidth(), ans1B.getHeight());

                ans1C.setPosition(rightCol, row1);
                ans1C.setBounds(rightCol, row1, ans1A.getWidth(), ans1A.getHeight());

                ans1D.setPosition(rightCol, row2);
                ans1D.setBounds(rightCol, row2, ans1B.getWidth(), ans1B.getHeight());

                ans2A.setPosition(leftCol, row3);
                ans2A.setBounds(leftCol, row3, ans2A.getWidth(), ans2A.getHeight());

                ans2B.setPosition(leftCol, row4);
                ans2B.setBounds(leftCol, row4, ans2B.getWidth(), ans2B.getHeight());

                ans2C.setPosition(rightCol, row3);
                ans2C.setBounds(rightCol, row3, ans2A.getWidth(), ans2A.getHeight());

                ans2D.setPosition(rightCol, row4);
                ans2D.setBounds(rightCol, row4, ans2B.getWidth(), ans2B.getHeight());

                ans3A.setPosition(leftCol, row5);
                ans3A.setBounds(leftCol, row5, ans3A.getWidth(), ans3A.getHeight());

                ans3B.setPosition(leftCol, row6);
                ans3B.setBounds(leftCol, row6, ans3B.getWidth(), ans3B.getHeight());

                ans3C.setPosition(rightCol, row5);
                ans3C.setBounds(rightCol, row5, ans3A.getWidth(), ans3A.getHeight());

                ans3D.setPosition(rightCol, row6);
                ans3D.setBounds(rightCol, row6, ans3B.getWidth(), ans3B.getHeight());

                ans4A.setPosition(leftCol, row7);
                ans4A.setBounds(leftCol, row7, ans4A.getWidth(), ans4A.getHeight());

                ans4B.setPosition(leftCol, row8);
                ans4B.setBounds(leftCol, row8, ans4B.getWidth(), ans4B.getHeight());

                ans4C.setPosition(rightCol, row7);
                ans4C.setBounds(rightCol, row7, ans4A.getWidth(), ans4A.getHeight());

                ans4D.setPosition(rightCol, row8);
                ans4D.setBounds(rightCol, row8, ans4B.getWidth(), ans4B.getHeight());
                break;
            case 18:
                backgroundSprite.setTexture(question2Texture);
                break;
            case 19:
                displayQuizResult(CHAPTER_TWELVE_SCORE, 4);
                break;
        }
        assetNeedUpdate = false;
    }

    @Override
    public int touchDown(float x, float y) {
        //TODO: apply touch listeners for the answers here
        return super.touchDown(x, y);
    }

    @Override
    public void dispose() {
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
