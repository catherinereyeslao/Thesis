package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import static com.example.aralingpanlipunan.android.database.DatabaseSetup.CHAPTER_SIXTEEN_SCORE;

public class ChapterSixteen extends ChapterCore {
    private Texture intro, job1, job2, job3, product1, product2, product3, product4, service1, service2, service3, service4, introBg, jobsBg, productBg, serviceBg, gameBg, ansMarkerTexture;
    private Sprite ans1A, ans1B, ans1C, ans2A, ans2B, ans2C, ans3A, ans3B, ans3C, ans4A, ans4B, ans4C, ans5A, ans5B, ans5C;
    private boolean ans1Correct, ans2Correct, ans3Correct, ans4Correct, ans5Correct;


    public ChapterSixteen(AndroidInterface androidInterface, String studentName) {
        super(androidInterface, studentName);
    }

    public ChapterSixteen(AndroidInterface androidInterface, boolean isTeacher) {
        super(androidInterface, isTeacher);
    }

    @Override
    public void setUp(int screenW, int screenH) {
        super.setUp(screenW, screenH);
        startOfQuestionSection = 12;
        lastChapterSection = 13;

        //backgrounds
        introBg = new Texture("chapters/chapter16/backgrounds/intro.png");
        jobsBg = new Texture("chapters/chapter16/backgrounds/jobs.png");
        productBg = new Texture("chapters/chapter16/backgrounds/product-provider.png");
        serviceBg = new Texture("chapters/chapter16/backgrounds/service-provider.png");

        //balloons
        intro = new Texture("chapters/chapter16/balloons/intro.png");
        job1 = new Texture("chapters/chapter16/balloons/job1.png");
        job2 = new Texture("chapters/chapter16/balloons/job2.png");
        job3 = new Texture("chapters/chapter16/balloons/job3.png");
        product1 = new Texture("chapters/chapter16/balloons/product1.png");
        product2 = new Texture("chapters/chapter16/balloons/product2.png");
        product3 = new Texture("chapters/chapter16/balloons/product3.png");
        product4 = new Texture("chapters/chapter16/balloons/product4.png");
        service1 = new Texture("chapters/chapter16/balloons/service1.png");
        service2 = new Texture("chapters/chapter16/balloons/service2.png");
        service3 = new Texture("chapters/chapter16/balloons/service3.png");
        service4 = new Texture("chapters/chapter16/balloons/service4.png");

        //questions
        if (isTeacher) {
            gameBg = new Texture("chapters/chapter16/answerkeys/answer.jpg");
        } else {
            gameBg = new Texture("chapters/chapter16/backgrounds/question.jpg");
            ansMarkerTexture = new Texture("box.png");
            ans1A = new Sprite(ansMarkerTexture);
            ans1A.setSize((ans1A.getWidth() * getButtonScale()) / 1.2f, (ans1A.getHeight() * getButtonScale()) / 3.397f);

            ans1B = new Sprite(ansMarkerTexture);
            ans1B.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans1C = new Sprite(ansMarkerTexture);
            ans1C.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans2A = new Sprite(ansMarkerTexture);
            ans2A.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans2B = new Sprite(ansMarkerTexture);
            ans2B.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans2C = new Sprite(ansMarkerTexture);
            ans2C.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans3A = new Sprite(ansMarkerTexture);
            ans3A.setSize(ans1A.getWidth() / 1.25f, ans1A.getHeight());

            ans3B = new Sprite(ansMarkerTexture);
            ans3B.setSize(ans1A.getWidth() / 1.25f, ans1A.getHeight());

            ans3C = new Sprite(ansMarkerTexture);
            ans3C.setSize(ans1A.getWidth() / 1.25f, ans1A.getHeight());

            ans4A = new Sprite(ansMarkerTexture);
            ans4A.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans4B = new Sprite(ansMarkerTexture);
            ans4B.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans4C = new Sprite(ansMarkerTexture);
            ans4C.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans5A = new Sprite(ansMarkerTexture);
            ans5A.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans5B = new Sprite(ansMarkerTexture);
            ans5B.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans5C = new Sprite(ansMarkerTexture);
            ans5C.setSize(ans1A.getWidth(), ans1A.getHeight());

            loadNextButton();
        }
    }

    @Override
    public void display(Batch batch) {
        if (assetNeedUpdate) assetManager();
        renderSharedAssets(batch);

        if (!isTeacher && chapterSection == 12) {
            ans1A.draw(batch);
            ans1B.draw(batch);
            ans1C.draw(batch);
            ans2A.draw(batch);
            ans2B.draw(batch);
            ans2C.draw(batch);
            ans3A.draw(batch);
            ans3B.draw(batch);
            ans3C.draw(batch);
            ans4A.draw(batch);
            ans4B.draw(batch);
            ans4C.draw(batch);
            ans5A.draw(batch);
            ans5B.draw(batch);
            ans5C.draw(batch);
            next.draw(batch);
        }

        drawQuizResult(batch);
    }

    @Override
    public void dispose() {
        super.dispose();
        introBg.dispose();
        jobsBg.dispose();
        productBg.dispose();
        serviceBg.dispose();
        intro.dispose();
        job1.dispose();
        job2.dispose();
        job3.dispose();
        product1.dispose();
        product2.dispose();
        product3.dispose();
        product4.dispose();
        service1.dispose();
        service2.dispose();
        service3.dispose();
        service4.dispose();
        if (!isTeacher) ansMarkerTexture.dispose();
    }

    @Override
    public int touchDown(float x, float y) {
        switch (chapterSection) {
            case 12:
                if (!isTeacher) {
                    if (ans1A.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(1);
                        ans1B.setAlpha(0);
                        ans1C.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans1B.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(1);
                        ans1C.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans1C.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(0);
                        ans1C.setAlpha(1);
                        ans1Correct = true;
                    }

                    if (ans2A.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(1);
                        ans2B.setAlpha(0);
                        ans2C.setAlpha(0);
                        ans2Correct = true;
                    } else if (ans2B.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(0);
                        ans2B.setAlpha(1);
                        ans2C.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans2C.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(0);
                        ans2B.setAlpha(0);
                        ans2C.setAlpha(1);
                        ans2Correct = false;
                    }

                    if (ans3A.getBoundingRectangle().contains(x, y)) {
                        ans3A.setAlpha(1);
                        ans3B.setAlpha(0);
                        ans3C.setAlpha(0);
                        ans3Correct = true;
                    } else if (ans3B.getBoundingRectangle().contains(x, y)) {
                        ans3A.setAlpha(0);
                        ans3B.setAlpha(1);
                        ans3C.setAlpha(0);
                        ans3Correct = false;
                    } else if (ans3C.getBoundingRectangle().contains(x, y)) {
                        ans3A.setAlpha(0);
                        ans3B.setAlpha(0);
                        ans3C.setAlpha(1);
                        ans3Correct = false;
                    }

                    if (ans4A.getBoundingRectangle().contains(x, y)) {
                        ans4A.setAlpha(1);
                        ans4B.setAlpha(0);
                        ans4C.setAlpha(0);
                        ans4Correct = false;
                    } else if (ans4B.getBoundingRectangle().contains(x, y)) {
                        ans4A.setAlpha(0);
                        ans4B.setAlpha(1);
                        ans4C.setAlpha(0);
                        ans4Correct = true;
                    } else if (ans4C.getBoundingRectangle().contains(x, y)) {
                        ans4A.setAlpha(0);
                        ans4B.setAlpha(0);
                        ans4C.setAlpha(1);
                        ans4Correct = false;
                    }

                    if (ans5A.getBoundingRectangle().contains(x, y)) {
                        ans5A.setAlpha(1);
                        ans5B.setAlpha(0);
                        ans5C.setAlpha(0);
                        ans5Correct = true;
                    } else if (ans5B.getBoundingRectangle().contains(x, y)) {
                        ans5A.setAlpha(0);
                        ans5B.setAlpha(1);
                        ans5C.setAlpha(0);
                        ans5Correct = false;
                    } else if (ans5C.getBoundingRectangle().contains(x, y)) {
                        ans5A.setAlpha(0);
                        ans5B.setAlpha(0);
                        ans5C.setAlpha(1);
                        ans5Correct = false;
                    }
                }
                break;
            case 13:
                return displayLastSectionButtons(16, 3, x, y);
        }
        return super.touchDown(x, y);
    }

    private void assetManager() {
        float row1, row2, row3, row4, row5, row6, ans1Col, ans2Col, ans3Col, ans4Col, ans5Col;
        switch (chapterSection) {
            case 0:
                backgroundSprite.setTexture(introBg);
                balloonSprite.setTexture(intro);
                break;
            case 1:
                backgroundSprite.setTexture(jobsBg);
                balloonSprite.setTexture(job1);
                break;
            case 2:
                balloonSprite.setTexture(job2);
                break;
            case 3:
                backgroundSprite.setTexture(jobsBg);
                balloonSprite.setTexture(job3);
                break;
            case 4:
                backgroundSprite.setTexture(productBg);
                balloonSprite.setTexture(product1);
                break;
            case 5:
                balloonSprite.setTexture(product2);
                break;
            case 6:
                balloonSprite.setTexture(product3);
                break;
            case 7:
                backgroundSprite.setTexture(productBg);
                balloonSprite.setTexture(product4);
                break;
            case 8:
                backgroundSprite.setTexture(serviceBg);
                balloonSprite.setTexture(service1);
                break;
            case 9:
                balloonSprite.setTexture(service2);
                break;
            case 10:
                balloonSprite.setTexture(service3);
                break;
            case 11:
                balloonSprite.setTexture(service4);
                break;
            case 12: // Start of game
                backgroundSprite.setTexture(gameBg);
                if (!isTeacher) {
                    ans1Correct = ans2Correct = ans3Correct = ans4Correct = ans5Correct = false;
                    ans1Col = screenWidth / 3.2f;
                    ans2Col = screenWidth / 1.82f;
                    ans3Col = screenWidth / 1.29f;
                    ans4Col = screenWidth / 2.5f;
                    ans5Col = screenWidth / 1.55f;

                    row1 = screenHeight / 1.6f;
                    row2 = screenHeight / 1.75f;
                    row3 = screenHeight / 1.9f;
                    row4 = screenHeight / 2.63f;
                    row5 = screenHeight / 2.99f;
                    row6 = screenHeight / 3.52f;

                    ans1A.setPosition(ans1Col, row1);
                    ans1A.setBounds(ans1Col, row1, ans1A.getWidth(), ans1A.getHeight());
                    ans1A.setAlpha(0);

                    ans1B.setPosition(ans1Col, row2);
                    ans1B.setBounds(ans1Col, row2, ans1B.getWidth(), ans1B.getHeight());
                    ans1B.setAlpha(0);

                    ans1C.setPosition(ans1Col, row3);
                    ans1C.setBounds(ans1Col, row3, ans1C.getWidth(), ans1C.getHeight());
                    ans1C.setAlpha(0);

                    ans2A.setPosition(ans2Col, row1);
                    ans2A.setBounds(ans2Col, row1, ans2A.getWidth(), ans2A.getHeight());
                    ans2A.setAlpha(0);

                    ans2B.setPosition(ans2Col, row2);
                    ans2B.setBounds(ans2Col, row2, ans2B.getWidth(), ans2B.getHeight());
                    ans2B.setAlpha(0);

                    ans2C.setPosition(ans2Col, row3);
                    ans2C.setBounds(ans2Col, row3, ans2C.getWidth(), ans2C.getHeight());
                    ans2C.setAlpha(0);

                    ans3A.setPosition(ans3Col, row1);
                    ans3A.setBounds(ans3Col, row1, ans3A.getWidth(), ans3A.getHeight());
                    ans3A.setAlpha(0);

                    ans3B.setPosition(ans3Col, row2);
                    ans3B.setBounds(ans3Col, row2, ans3B.getWidth(), ans3B.getHeight());
                    ans3B.setAlpha(0);

                    ans3C.setPosition(ans3Col, row3);
                    ans3C.setBounds(ans3Col, row3, ans3C.getWidth(), ans3C.getHeight());
                    ans3C.setAlpha(0);

                    ans4A.setPosition(ans4Col, row4);
                    ans4A.setBounds(ans4Col, row4, ans4A.getWidth(), ans4A.getHeight());
                    ans4A.setAlpha(0);

                    ans4B.setPosition(ans4Col, row5);
                    ans4B.setBounds(ans4Col, row5, ans4B.getWidth(), ans4B.getHeight());
                    ans4B.setAlpha(0);

                    ans4C.setPosition(ans4Col, row6);
                    ans4C.setBounds(ans4Col, row6, ans4C.getWidth(), ans4C.getHeight());
                    ans4C.setAlpha(0);

                    ans5A.setPosition(ans5Col, row4);
                    ans5A.setBounds(ans5Col, row4, ans5A.getWidth(), ans5A.getHeight());
                    ans5A.setAlpha(0);

                    ans5B.setPosition(ans5Col, row5);
                    ans5B.setBounds(ans5Col, row5, ans5B.getWidth(), ans5B.getHeight());
                    ans5B.setAlpha(0);

                    ans5C.setPosition(ans5Col, row6);
                    ans5C.setBounds(ans5Col, row6, ans5C.getWidth(), ans5C.getHeight());
                    ans5C.setAlpha(0);
                } else {
                    correctAnswers = 5;
                }
                break;
            case 13:
                if (ans1Correct) correctAnswers++;
                if (ans2Correct) correctAnswers++;
                if (ans3Correct) correctAnswers++;
                if (ans4Correct) correctAnswers++;
                if (ans5Correct) correctAnswers++;
                displayQuizResult(CHAPTER_SIXTEEN_SCORE, 3);
                break;
        }
        assetNeedUpdate = false;
    }
}
