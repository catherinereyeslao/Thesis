package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import static com.example.aralingpanlipunan.android.database.DatabaseSetup.CHAPTER_NINETEEN_SCORE;

public class ChapterNineteen extends ChapterCore {
    private Texture question1Texture, question2Texture, question3Texture, question4Texture, question5Texture, question6Texture, question7Texture, question8Texture, question9Texture, question10Texture, question11Texture, ansMarkerTexture;
    private Sprite ans1Sprite, ans2Sprite, ans3Sprite, ans4Sprite, ans5Sprite, ans6Sprite, ans7Sprite, ans8Sprite, ans9Sprite, ans10Sprite, ans11Sprite, ans12Sprite;

    public ChapterNineteen(AndroidInterface androidInterface, String studentName) {
        super(androidInterface, studentName);
    }

    public ChapterNineteen(AndroidInterface androidInterface, boolean isTeacher) {
        super(androidInterface, isTeacher);
    }

    @Override
    public void setUp(int screenW, int screenH) {
        super.setUp(screenW, screenH);
        startOfQuestionSection = 0;
        lastChapterSection = 11;

        if (isTeacher) {
            question1Texture = new Texture("chapters/chapter19/answers/1.png");
            question2Texture = new Texture("chapters/chapter19/answers/2.png");
            question3Texture = new Texture("chapters/chapter19/answers/3.png");
            question4Texture = new Texture("chapters/chapter19/answers/4.png");
            question5Texture = new Texture("chapters/chapter19/answers/5.png");
            question6Texture = new Texture("chapters/chapter19/answers/6.png");
            question7Texture = new Texture("chapters/chapter19/answers/7.png");
            question8Texture = new Texture("chapters/chapter19/answers/8.png");
            question9Texture = new Texture("chapters/chapter19/answers/9.png");
            question10Texture = new Texture("chapters/chapter19/answers/10.png");
            question11Texture = new Texture("chapters/chapter19/answers/11.png");
        } else {
            question1Texture = new Texture("chapters/chapter19/questions/1.png");
            question2Texture = new Texture("chapters/chapter19/questions/2.png");
            question3Texture = new Texture("chapters/chapter19/questions/3.png");
            question4Texture = new Texture("chapters/chapter19/questions/4.png");
            question5Texture = new Texture("chapters/chapter19/questions/5.png");
            question6Texture = new Texture("chapters/chapter19/questions/6.png");
            question7Texture = new Texture("chapters/chapter19/questions/7.png");
            question8Texture = new Texture("chapters/chapter19/questions/8.png");
            question9Texture = new Texture("chapters/chapter19/questions/9.png");
            question10Texture = new Texture("chapters/chapter19/questions/10.png");
            question11Texture = new Texture("chapters/chapter19/questions/11.png");

            ansMarkerTexture = new Texture("box.png");
            ans1Sprite = new Sprite(ansMarkerTexture);
            ans1Sprite.setSize((ans1Sprite.getWidth() * getButtonScale()) / 1.05f, (ans1Sprite.getHeight() * getButtonScale()) / 3.397f);

            ans2Sprite = new Sprite(ansMarkerTexture);
            ans2Sprite.setSize(ans1Sprite.getWidth(), ans1Sprite.getHeight());

            ans3Sprite = new Sprite(ansMarkerTexture);
            ans3Sprite.setSize(ans1Sprite.getWidth(), ans1Sprite.getHeight());

            ans4Sprite = new Sprite(ansMarkerTexture);
            ans4Sprite.setSize(ans1Sprite.getWidth(), ans1Sprite.getHeight());

            ans5Sprite = new Sprite(ansMarkerTexture);
            ans5Sprite.setSize(ans1Sprite.getWidth(), ans1Sprite.getHeight());

            ans6Sprite = new Sprite(ansMarkerTexture);
            ans6Sprite.setSize(ans1Sprite.getWidth(), ans1Sprite.getHeight());

            ans7Sprite = new Sprite(ansMarkerTexture);
            ans7Sprite.setSize(ans1Sprite.getWidth(), ans1Sprite.getHeight());

            ans8Sprite = new Sprite(ansMarkerTexture);
            ans8Sprite.setSize(ans1Sprite.getWidth(), ans1Sprite.getHeight());

            ans9Sprite = new Sprite(ansMarkerTexture);
            ans9Sprite.setSize(ans1Sprite.getWidth(), ans1Sprite.getHeight());

            ans10Sprite = new Sprite(ansMarkerTexture);
            ans10Sprite.setSize(ans1Sprite.getWidth(), ans1Sprite.getHeight());

            ans11Sprite = new Sprite(ansMarkerTexture);
            ans11Sprite.setSize(ans1Sprite.getWidth(), ans1Sprite.getHeight());

            ans12Sprite = new Sprite(ansMarkerTexture);
            ans12Sprite.setSize(ans1Sprite.getWidth(), ans1Sprite.getHeight());

            loadNextButton();
        }
    }

    @Override
    public void display(Batch batch) {
        if (assetNeedUpdate) assetManager();
        renderSharedAssets(batch);

        if (!isTeacher) {
            ans1Sprite.draw(batch);
            ans2Sprite.draw(batch);
            ans3Sprite.draw(batch);
            ans4Sprite.draw(batch);
            ans5Sprite.draw(batch);
            ans6Sprite.draw(batch);
            ans7Sprite.draw(batch);
            ans8Sprite.draw(batch);
            ans9Sprite.draw(batch);
            ans10Sprite.draw(batch);
            ans11Sprite.draw(batch);
            ans12Sprite.draw(batch);
            next.draw(batch);
        }


        if (chapterSection == lastChapterSection)
            drawQuizResult(batch);
    }

    @Override
    public void dispose() {
        super.dispose();
        question1Texture.dispose();
        question2Texture.dispose();
        question3Texture.dispose();
        question4Texture.dispose();
        question5Texture.dispose();
        question6Texture.dispose();
        question7Texture.dispose();
        question8Texture.dispose();
        question9Texture.dispose();
        question10Texture.dispose();
        question11Texture.dispose();
        if (!isTeacher) ansMarkerTexture.dispose();
    }

    @Override
    public int touchDown(float x, float y) {
        if (chapterSection == lastChapterSection)
            return displayLastSectionButtons(19, 15, x, y);
        return super.touchDown(x, y);
    }

    private void assetManager() {
        float col1, col2, row1, row2, row3, row4, row5, row6, row7, row8;
        switch (chapterSection) {
            case 0:
                col1= screenWidth / 2.2f;
                row1 = screenHeight / 1.61f;
                row2 = screenHeight / 1.73f;
                row3 = screenHeight / 1.91f;
                row4 = screenHeight / 2.1f;
                row5 = screenHeight / 3.18f;
                row6 = screenHeight / 3.67f;
                row7 = screenHeight / 4.55f;
                row8 = screenHeight / 5.9f;

                ans1Sprite.setBounds(col1, row1, ans1Sprite.getWidth(), ans1Sprite.getHeight());
                ans2Sprite.setBounds(col1, row2, ans2Sprite.getWidth(), ans2Sprite.getHeight());
                ans3Sprite.setBounds(col1, row3, ans3Sprite.getWidth(), ans3Sprite.getHeight());
                ans4Sprite.setBounds(col1, row4, ans4Sprite.getWidth(), ans4Sprite.getHeight());
                ans5Sprite.setBounds(col1, row5, ans5Sprite.getWidth(), ans5Sprite.getHeight());
                ans6Sprite.setBounds(col1, row6, ans6Sprite.getWidth(), ans6Sprite.getHeight());
                ans7Sprite.setBounds(col1, row7, ans7Sprite.getWidth(), ans7Sprite.getHeight());
                ans8Sprite.setBounds(col1, row8, ans8Sprite.getWidth(), ans8Sprite.getHeight());

                backgroundSprite.setTexture(question1Texture);
                break;
            case 1:
                col1 = screenWidth / 7;
                col2 = screenWidth / 1.97f;
                row1 = screenHeight / 1.575f;
                row2 = screenHeight / 1.685f;
                row3 = screenHeight / 2f;
                row4 = screenHeight / 2.3f;
                row5 = screenHeight / 3;
                row6 = screenHeight / 3.5f;
                row7 = screenHeight / 5.4f;
                row8 = screenHeight / 7.3f;

                ans9Sprite.setSize(ans1Sprite.getWidth() * 2, ans1Sprite.getHeight());
                ans10Sprite.setSize(ans1Sprite.getWidth() * 2, ans1Sprite.getHeight());
                ans11Sprite.setSize(ans1Sprite.getWidth() * 2, ans1Sprite.getHeight());
                ans12Sprite.setSize(ans1Sprite.getWidth() * 2, ans1Sprite.getHeight());

                ans1Sprite.setBounds(col1, row1, ans1Sprite.getWidth(), ans1Sprite.getHeight()); // 1a
                ans2Sprite.setBounds(col1, row2, ans2Sprite.getWidth(), ans2Sprite.getHeight()); // 1b
                ans3Sprite.setBounds(col2, row1, ans3Sprite.getWidth(), ans3Sprite.getHeight()); // 1c
                ans4Sprite.setBounds(col2, row2, ans4Sprite.getWidth(), ans4Sprite.getHeight()); // 1d
                ans5Sprite.setBounds(col1, row3, ans5Sprite.getWidth(), ans5Sprite.getHeight()); // 2a
                ans6Sprite.setBounds(col1, row4, ans6Sprite.getWidth(), ans6Sprite.getHeight()); // 2b
                ans7Sprite.setBounds(col2, row3, ans7Sprite.getWidth(), ans7Sprite.getHeight()); // 2c
                ans8Sprite.setBounds(col2, row4, ans8Sprite.getWidth(), ans8Sprite.getHeight()); // 2d
                ans9Sprite.setBounds(col1, row5, ans9Sprite.getWidth(), ans9Sprite.getHeight()); // 3a
                ans10Sprite.setBounds(col1, row6, ans10Sprite.getWidth(), ans10Sprite.getHeight()); // 3b
                ans11Sprite.setBounds(col1, row7, ans11Sprite.getWidth(), ans11Sprite.getHeight()); // 4a
                ans12Sprite.setBounds(col1, row8, ans12Sprite.getWidth(), ans12Sprite.getHeight()); // 4b

                backgroundSprite.setTexture(question2Texture);
                break;
            case 2:
                col1 = screenWidth / 2.2f;
                row1 = screenHeight / 1.85f;
                row2 = screenHeight / 1.95f;
                row3 = screenHeight / 3;
                row4 = screenHeight / 3.7f;

                // Put the last 4 answer sprites to normal size
                ans9Sprite.setSize(ans1Sprite.getWidth(), ans9Sprite.getHeight());
                ans10Sprite.setSize(ans1Sprite.getWidth(), ans10Sprite.getHeight());
                ans11Sprite.setSize(ans1Sprite.getWidth(), ans11Sprite.getHeight());
                ans12Sprite.setSize(ans1Sprite.getWidth(), ans12Sprite.getHeight());

                ans1Sprite.setBounds(col1, row1, ans1Sprite.getWidth(), ans1Sprite.getHeight());
                ans2Sprite.setBounds(col1, row2, ans2Sprite.getWidth(), ans2Sprite.getHeight());
                ans3Sprite.setBounds(col1, row3, ans3Sprite.getWidth(), ans3Sprite.getHeight());
                ans4Sprite.setBounds(col1, row4, ans4Sprite.getWidth(), ans4Sprite.getHeight());

                backgroundSprite.setTexture(question3Texture);
                break;
            case 3:
                col1 = screenWidth / 2;
                row1 = screenHeight / 1.6f;
                row2 = screenHeight / 1.72f;
                row3 = screenHeight / 1.89f;
                row4 = screenHeight / 2.1f;
                row5 = screenHeight / 3.15f;
                row6 = screenHeight / 3.8f;
                row7 = screenHeight / 4.6f;
                row8 = screenHeight / 5.5f;

                ans1Sprite.setBounds(col1, row1, ans1Sprite.getWidth(), ans1Sprite.getHeight());
                ans2Sprite.setBounds(col1, row2, ans2Sprite.getWidth(), ans2Sprite.getHeight());
                ans3Sprite.setBounds(col1, row3, ans3Sprite.getWidth(), ans3Sprite.getHeight());
                ans4Sprite.setBounds(col1, row4, ans4Sprite.getWidth(), ans4Sprite.getHeight());
                ans5Sprite.setBounds(col1, row5, ans5Sprite.getWidth(), ans5Sprite.getHeight());
                ans6Sprite.setBounds(col1, row6, ans6Sprite.getWidth(), ans6Sprite.getHeight());
                ans7Sprite.setBounds(col1, row7, ans7Sprite.getWidth(), ans7Sprite.getHeight());
                ans8Sprite.setBounds(col1, row8, ans8Sprite.getWidth(), ans8Sprite.getHeight());

                backgroundSprite.setTexture(question4Texture);
                break;
            case 4:
                col1 = screenWidth / 1.9f;
                row1 = screenHeight / 1.55f;
                row2 = screenHeight / 1.65f;
                row3 = screenHeight / 1.84f;
                row4 = screenHeight / 2;
                row5 = screenHeight / 2.91f;
                row6 = screenHeight / 3.485f;
                row7 = screenHeight / 4.19f;
                row8 = screenHeight / 5.2f;

                ans1Sprite.setBounds(col1, row1, ans1Sprite.getWidth(), ans1Sprite.getHeight());
                ans2Sprite.setBounds(col1, row2, ans2Sprite.getWidth(), ans2Sprite.getHeight());
                ans3Sprite.setBounds(col1, row3, ans3Sprite.getWidth(), ans3Sprite.getHeight());
                ans4Sprite.setBounds(col1, row4, ans4Sprite.getWidth(), ans4Sprite.getHeight());
                ans5Sprite.setBounds(col1, row5, ans5Sprite.getWidth(), ans5Sprite.getHeight());
                ans6Sprite.setBounds(col1, row6, ans6Sprite.getWidth(), ans6Sprite.getHeight());
                ans7Sprite.setBounds(col1, row7, ans7Sprite.getWidth(), ans7Sprite.getHeight());
                ans8Sprite.setBounds(col1, row8, ans8Sprite.getWidth(), ans8Sprite.getHeight());

                backgroundSprite.setTexture(question5Texture);
                break;
            case 5:
                col1 = screenWidth / 6.3f;
                col2 = screenWidth / 1.77f;
                row1 = screenHeight / 1.67f;
                row2 = screenHeight / 1.82f;
                row3 = screenHeight / 2.6f;
                row4 = screenHeight / 2.95f;
                row5 = screenHeight / 5.1f;
                row6 = screenHeight / 7;

                ans5Sprite.setSize(ans1Sprite.getWidth() * 1.2f, ans1Sprite.getHeight());
                ans10Sprite.setSize(ans1Sprite.getWidth() * 1.2f, ans1Sprite.getHeight());

                ans1Sprite.setBounds(col1, row1, ans1Sprite.getWidth(), ans1Sprite.getHeight()); // 1a
                ans2Sprite.setBounds(col1, row2, ans2Sprite.getWidth(), ans2Sprite.getHeight()); // 1b
                ans3Sprite.setBounds(col2, row1, ans3Sprite.getWidth(), ans3Sprite.getHeight()); // 1c
                ans4Sprite.setBounds(col2, row2, ans4Sprite.getWidth(), ans4Sprite.getHeight()); // 1d
                ans5Sprite.setBounds(col1, row3, ans5Sprite.getWidth(), ans5Sprite.getHeight()); // 2a
                ans6Sprite.setBounds(col1, row4, ans6Sprite.getWidth(), ans6Sprite.getHeight()); // 2b
                ans7Sprite.setBounds(col2, row3, ans7Sprite.getWidth(), ans7Sprite.getHeight()); // 2c
                ans8Sprite.setBounds(col2, row4, ans8Sprite.getWidth(), ans8Sprite.getHeight()); // 2d
                ans9Sprite.setBounds(col1, row5, ans9Sprite.getWidth(), ans9Sprite.getHeight()); // 3a
                ans10Sprite.setBounds(col1, row6, ans10Sprite.getWidth(), ans10Sprite.getHeight()); // 3b
                ans11Sprite.setBounds(col2, row5, ans11Sprite.getWidth(), ans11Sprite.getHeight()); // 3c
                ans12Sprite.setBounds(col2, row6, ans12Sprite.getWidth(), ans12Sprite.getHeight()); // 3d

                backgroundSprite.setTexture(question6Texture);
                break;
            case 6:
                //todo: putangina neto!!
                col1 = screenWidth / 4;
                row1 = screenHeight / 1.58f;
                row2 = screenHeight / 1.83f;
                row3 = screenHeight / 3.9f;
                row4 = screenHeight / 4.2f;

                ans1Sprite.setBounds(col1, row1, ans1Sprite.getWidth(), ans1Sprite.getHeight());
                ans2Sprite.setBounds(col1, row2, ans2Sprite.getWidth(), ans2Sprite.getHeight());
                ans3Sprite.setBounds(col1, row3, ans3Sprite.getWidth(), ans3Sprite.getHeight());
                ans4Sprite.setBounds(col1, row4, ans4Sprite.getWidth(), ans4Sprite.getHeight());

                ans5Sprite.setSize(ans1Sprite.getWidth(), ans1Sprite.getHeight());
                ans10Sprite.setSize(ans1Sprite.getWidth(), ans1Sprite.getHeight());

                backgroundSprite.setTexture(question7Texture);
                break;
            case 7:
                col1 = screenWidth / 3.8f;
                col2 = screenWidth / 1.9f;
                row1 = screenHeight / 1.8f;
                row2 = screenHeight / 2.4f;
                row3 = screenHeight / 3;

                ans1Sprite.setBounds(col1, row1, ans1Sprite.getWidth(), ans1Sprite.getHeight());
                ans2Sprite.setBounds(col2, row1, ans2Sprite.getWidth(), ans2Sprite.getHeight());
                ans3Sprite.setBounds(col1, row2, ans3Sprite.getWidth(), ans3Sprite.getHeight());
                ans4Sprite.setBounds(col2, row2, ans4Sprite.getWidth(), ans4Sprite.getHeight());
                ans5Sprite.setBounds(col1, row3, ans5Sprite.getWidth(), ans5Sprite.getHeight());
                ans6Sprite.setBounds(col2, row3, ans6Sprite.getWidth(), ans6Sprite.getHeight());

                backgroundSprite.setTexture(question8Texture);
                break;
            case 8:
                col1 = screenWidth / 3.8f;
                col2 = screenWidth / 1.9f;
                row1 = screenHeight / 1.8f;
                row2 = screenHeight / 2.4f;
                row3 = screenHeight / 3;
                row4 = screenHeight / 3.5f;

                ans1Sprite.setBounds(col1, row1, ans1Sprite.getWidth(), ans1Sprite.getHeight());
                ans2Sprite.setBounds(col2, row1, ans2Sprite.getWidth(), ans2Sprite.getHeight());
                ans3Sprite.setBounds(col1, row2, ans3Sprite.getWidth(), ans3Sprite.getHeight());
                ans4Sprite.setBounds(col2, row2, ans4Sprite.getWidth(), ans4Sprite.getHeight());
                ans5Sprite.setBounds(col1, row3, ans5Sprite.getWidth(), ans5Sprite.getHeight());
                ans6Sprite.setBounds(col2, row3, ans6Sprite.getWidth(), ans6Sprite.getHeight());
                ans7Sprite.setBounds(col1, row4, ans7Sprite.getWidth(), ans7Sprite.getHeight());
                ans8Sprite.setBounds(col2, row4, ans8Sprite.getWidth(), ans8Sprite.getHeight());

                backgroundSprite.setTexture(question9Texture);
                break;
            case 9:
                col1 = screenWidth / 3.8f;
                col2 = screenWidth / 1.9f;
                row1 = screenHeight / 1.8f;
                row2 = screenHeight / 2.4f;
                row3 = screenHeight / 3;
                row4 = screenHeight / 3.2f;

                ans1Sprite.setBounds(col1, row1, ans1Sprite.getWidth(), ans1Sprite.getHeight());
                ans2Sprite.setBounds(col2, row1, ans2Sprite.getWidth(), ans2Sprite.getHeight());
                ans3Sprite.setBounds(col1, row2, ans3Sprite.getWidth(), ans3Sprite.getHeight());
                ans4Sprite.setBounds(col2, row2, ans4Sprite.getWidth(), ans4Sprite.getHeight());
                ans5Sprite.setBounds(col1, row3, ans5Sprite.getWidth(), ans5Sprite.getHeight());
                ans6Sprite.setBounds(col2, row3, ans6Sprite.getWidth(), ans6Sprite.getHeight());
                ans7Sprite.setBounds(col1, row4, ans7Sprite.getWidth(), ans7Sprite.getHeight());
                ans8Sprite.setBounds(col2, row4, ans8Sprite.getWidth(), ans8Sprite.getHeight());

                backgroundSprite.setTexture(question10Texture);
                break;
            case 10:
                col1 = screenWidth / 5;
                col2 = screenWidth / 1.8f;
                row1 = screenHeight / 1.65f;
                row2 = screenHeight / 1.77f;
                row3 = screenHeight / 1.89f;
                row4 = screenHeight / 2;
                row5 = screenHeight / 2.8f;
                row6 = screenHeight / 3.1f;

                ans1Sprite.setBounds(col1, row1, ans1Sprite.getWidth(), ans1Sprite.getHeight()); // 1a
                ans2Sprite.setBounds(col1, row2, ans2Sprite.getWidth(), ans2Sprite.getHeight()); // 1b
                ans3Sprite.setBounds(col2, row1, ans3Sprite.getWidth(), ans3Sprite.getHeight()); // 1c
                ans4Sprite.setBounds(col2, row2, ans4Sprite.getWidth(), ans4Sprite.getHeight()); // 1d
                ans5Sprite.setBounds(col1, row3, ans5Sprite.getWidth(), ans5Sprite.getHeight()); // 2a
                ans6Sprite.setBounds(col1, row4, ans6Sprite.getWidth(), ans6Sprite.getHeight()); // 2b
                ans7Sprite.setBounds(col2, row3, ans7Sprite.getWidth(), ans7Sprite.getHeight()); // 2c
                ans8Sprite.setBounds(col2, row4, ans8Sprite.getWidth(), ans8Sprite.getHeight()); // 2d
                ans9Sprite.setBounds(col1, row5, ans9Sprite.getWidth(), ans9Sprite.getHeight()); // 3a
                ans10Sprite.setBounds(col1, row6, ans10Sprite.getWidth(), ans10Sprite.getHeight()); // 3b
                ans11Sprite.setBounds(col2, row5, ans11Sprite.getWidth(), ans11Sprite.getHeight()); // 3c
                ans12Sprite.setBounds(col2, row6, ans12Sprite.getWidth(), ans12Sprite.getHeight()); // 3d

                backgroundSprite.setTexture(question11Texture);
                break;
            case 11:
                if (isTeacher) correctAnswers = 30;
                displayQuizResult(CHAPTER_NINETEEN_SCORE, 15);
        }
        assetNeedUpdate = false;
    }
}
