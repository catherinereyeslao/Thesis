package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import static com.example.aralingpanlipunan.android.database.DatabaseSetup.CHAPTER_NINETEEN_SCORE;

public class ChapterNineteen extends ChapterCore {
    private Texture question1Texture, question2Texture, question3Texture, question4Texture, question5Texture, question6Texture, question7Texture, question8Texture, question9Texture, question10Texture, question11Texture, ansMarkerTexture;
    private Sprite ans1Sprite, ans2Sprite, ans3Sprite, ans4Sprite, ans5Sprite, ans6Sprite, ans7Sprite, ans8Sprite, ans9Sprite, ans10Sprite, ans11Sprite, ans12Sprite;
    private boolean ans1Correct, ans2Correct, ans3Correct, ans4Correct;

    public ChapterNineteen(AndroidInterface androidInterface, String studentName, String password) {
        super(androidInterface, studentName, password);
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

        if (!isTeacher && chapterSection < lastChapterSection) {
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
        if (!isTeacher) {
            switch (chapterSection) {
                case 0:
                    if (ans1Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(1);
                        ans2Sprite.setAlpha(0);
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans2Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(1);
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(0);
                        ans1Correct = true;
                    } else if (ans3Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(0);
                        ans3Sprite.setAlpha(1);
                        ans4Sprite.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans4Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(0);
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(1);
                        ans1Correct = false;
                    }

                    if (ans5Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(1);
                        ans6Sprite.setAlpha(0);
                        ans7Sprite.setAlpha(0);
                        ans8Sprite.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans6Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(1);
                        ans7Sprite.setAlpha(0);
                        ans8Sprite.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans7Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(0);
                        ans7Sprite.setAlpha(1);
                        ans8Sprite.setAlpha(0);
                        ans2Correct = true;
                    } else if (ans8Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(0);
                        ans7Sprite.setAlpha(0);
                        ans8Sprite.setAlpha(1);
                        ans2Correct = false;
                    }
                    break;
                case 1:
                    if (ans1Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(1);
                        ans2Sprite.setAlpha(0);
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(0);
                        ans1Correct = true;
                    } else if (ans2Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(1);
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans3Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(0);
                        ans3Sprite.setAlpha(1);
                        ans4Sprite.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans4Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(0);
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(1);
                        ans1Correct = false;
                    }

                    if (ans5Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(1);
                        ans6Sprite.setAlpha(0);
                        ans7Sprite.setAlpha(0);
                        ans8Sprite.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans6Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(1);
                        ans7Sprite.setAlpha(0);
                        ans8Sprite.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans7Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(0);
                        ans7Sprite.setAlpha(1);
                        ans8Sprite.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans8Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(0);
                        ans7Sprite.setAlpha(0);
                        ans8Sprite.setAlpha(1);
                        ans2Correct = true;
                    }

                    if (ans9Sprite.getBoundingRectangle().contains(x, y)) {
                        ans9Sprite.setAlpha(1);
                        ans10Sprite.setAlpha(0);
                        ans3Correct = true;
                    } else if (ans10Sprite.getBoundingRectangle().contains(x, y)) {
                        ans9Sprite.setAlpha(0);
                        ans10Sprite.setAlpha(1);
                        ans3Correct = false;
                    }

                    if (ans11Sprite.getBoundingRectangle().contains(x, y)) {
                        ans11Sprite.setAlpha(1);
                        ans12Sprite.setAlpha(0);
                        ans4Correct = true;
                    } else if (ans12Sprite.getBoundingRectangle().contains(x, y)) {
                        ans11Sprite.setAlpha(0);
                        ans12Sprite.setAlpha(1);
                        ans4Correct = false;
                    }
                    break;
                case 2:
                    if (ans1Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(1);
                        ans2Sprite.setAlpha(0);
                        ans1Correct = true;
                    } else if (ans2Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(1);
                        ans1Correct = false;
                    }

                    if (ans3Sprite.getBoundingRectangle().contains(x, y)) {
                        ans3Sprite.setAlpha(1);
                        ans4Sprite.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans4Sprite.getBoundingRectangle().contains(x, y)) {
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(1);
                        ans2Correct = true;
                    }
                    break;
                case 3:
                    if (ans1Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(1);
                        ans2Sprite.setAlpha(0);
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans2Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(1);
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans3Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(0);
                        ans3Sprite.setAlpha(1);
                        ans4Sprite.setAlpha(0);
                        ans1Correct = true;
                    } else if (ans4Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(0);
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(1);
                        ans1Correct = false;
                    }

                    if (ans5Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(1);
                        ans6Sprite.setAlpha(0);
                        ans7Sprite.setAlpha(0);
                        ans8Sprite.setAlpha(0);
                        ans2Correct = true;
                    } else if (ans6Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(1);
                        ans7Sprite.setAlpha(0);
                        ans8Sprite.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans7Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(0);
                        ans7Sprite.setAlpha(1);
                        ans8Sprite.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans8Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(0);
                        ans7Sprite.setAlpha(0);
                        ans8Sprite.setAlpha(1);
                        ans2Correct = false;
                    }
                    break;
                case 4:
                    if (ans1Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(1);
                        ans2Sprite.setAlpha(0);
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans2Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(1);
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans3Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(0);
                        ans3Sprite.setAlpha(1);
                        ans4Sprite.setAlpha(0);
                        ans1Correct = true;
                    } else if (ans4Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(0);
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(1);
                        ans1Correct = false;
                    }

                    if (ans5Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(1);
                        ans6Sprite.setAlpha(0);
                        ans7Sprite.setAlpha(0);
                        ans8Sprite.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans6Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(1);
                        ans7Sprite.setAlpha(0);
                        ans8Sprite.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans7Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(0);
                        ans7Sprite.setAlpha(1);
                        ans8Sprite.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans8Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(0);
                        ans7Sprite.setAlpha(0);
                        ans8Sprite.setAlpha(1);
                        ans2Correct = true;
                    }
                    break;
                case 5:
                    if (ans1Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(1);
                        ans2Sprite.setAlpha(0);
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans2Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(1);
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans3Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(0);
                        ans3Sprite.setAlpha(1);
                        ans4Sprite.setAlpha(0);
                        ans1Correct = true;
                    } else if (ans4Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(0);
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(1);
                        ans1Correct = false;
                    }

                    if (ans5Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(1);
                        ans6Sprite.setAlpha(0);
                        ans7Sprite.setAlpha(0);
                        ans8Sprite.setAlpha(0);
                        ans2Correct = true;
                    } else if (ans6Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(1);
                        ans7Sprite.setAlpha(0);
                        ans8Sprite.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans7Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(0);
                        ans7Sprite.setAlpha(1);
                        ans8Sprite.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans8Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(0);
                        ans7Sprite.setAlpha(0);
                        ans8Sprite.setAlpha(1);
                        ans2Correct = false;
                    }

                    if (ans9Sprite.getBoundingRectangle().contains(x, y)) {
                        ans9Sprite.setAlpha(1);
                        ans10Sprite.setAlpha(0);
                        ans11Sprite.setAlpha(0);
                        ans12Sprite.setAlpha(0);
                        ans3Correct = true;
                    } else if (ans10Sprite.getBoundingRectangle().contains(x, y)) {
                        ans9Sprite.setAlpha(0);
                        ans10Sprite.setAlpha(1);
                        ans11Sprite.setAlpha(0);
                        ans12Sprite.setAlpha(0);
                        ans3Correct = false;
                    } else if (ans11Sprite.getBoundingRectangle().contains(x, y)) {
                        ans11Sprite.setAlpha(0);
                        ans12Sprite.setAlpha(0);
                        ans11Sprite.setAlpha(1);
                        ans12Sprite.setAlpha(0);
                        ans3Correct = false;
                    } else if (ans12Sprite.getBoundingRectangle().contains(x, y)) {
                        ans11Sprite.setAlpha(0);
                        ans12Sprite.setAlpha(1);
                        ans11Sprite.setAlpha(0);
                        ans12Sprite.setAlpha(1);
                        ans3Correct = false;
                    }
                    break;
                case 6:
                    if (ans1Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(1);
                        ans2Sprite.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans2Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(1);
                        ans1Correct = true;
                    }

                    if (ans3Sprite.getBoundingRectangle().contains(x, y)) {
                        ans3Sprite.setAlpha(1);
                        ans4Sprite.setAlpha(0);
                        ans2Correct = true;
                    } else if (ans4Sprite.getBoundingRectangle().contains(x, y)) {
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(1);
                        ans2Correct = false;
                    }
                    break;
                case 7:
                    if (ans1Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(1);
                        ans2Sprite.setAlpha(0);
                        ans1Correct = true;
                    } else if (ans2Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(1);
                        ans1Correct = false;
                    }

                    if (ans3Sprite.getBoundingRectangle().contains(x, y)) {
                        ans3Sprite.setAlpha(1);
                        ans4Sprite.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans4Sprite.getBoundingRectangle().contains(x, y)) {
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(1);
                        ans2Correct = true;
                    }

                    if (ans5Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(1);
                        ans6Sprite.setAlpha(0);
                        ans3Correct = true;
                    } else if (ans6Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(1);
                        ans3Correct = false;
                    }
                    break;
                case 8:
                    if (ans1Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(1);
                        ans2Sprite.setAlpha(0);
                        ans1Correct = true;
                    } else if (ans2Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(1);
                        ans1Correct = false;
                    }

                    if (ans3Sprite.getBoundingRectangle().contains(x, y)) {
                        ans3Sprite.setAlpha(1);
                        ans4Sprite.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans4Sprite.getBoundingRectangle().contains(x, y)) {
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(1);
                        ans2Correct = true;
                    }

                    if (ans5Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(1);
                        ans6Sprite.setAlpha(0);
                        ans3Correct = true;
                    } else if (ans6Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(1);
                        ans3Correct = false;
                    }

                    if (ans7Sprite.getBoundingRectangle().contains(x, y)) {
                        ans7Sprite.setAlpha(1);
                        ans8Sprite.setAlpha(0);
                        ans4Correct = false;
                    } else if (ans8Sprite.getBoundingRectangle().contains(x, y)) {
                        ans7Sprite.setAlpha(0);
                        ans8Sprite.setAlpha(1);
                        ans4Correct = true;
                    }
                    break;
                case 9:
                    if (ans1Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(1);
                        ans2Sprite.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans2Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(1);
                        ans1Correct = true;
                    }

                    if (ans3Sprite.getBoundingRectangle().contains(x, y)) {
                        ans3Sprite.setAlpha(1);
                        ans4Sprite.setAlpha(0);
                        ans2Correct = true;
                    } else if (ans4Sprite.getBoundingRectangle().contains(x, y)) {
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(1);
                        ans2Correct = false;
                    }

                    if (ans5Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(1);
                        ans6Sprite.setAlpha(0);
                        ans7Sprite.setAlpha(0);
                        ans8Sprite.setAlpha(0);
                        ans3Correct = false;
                    } else if (ans6Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(1);
                        ans7Sprite.setAlpha(0);
                        ans8Sprite.setAlpha(0);
                        ans3Correct = true;
                    } else if (ans7Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(0);
                        ans7Sprite.setAlpha(1);
                        ans8Sprite.setAlpha(0);
                        ans3Correct = false;
                    } else if (ans8Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(0);
                        ans7Sprite.setAlpha(0);
                        ans8Sprite.setAlpha(1);
                        ans3Correct = false;
                    }
                    break;
                case 10:
                    if (ans1Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(1);
                        ans2Sprite.setAlpha(0);
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans2Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(1);
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans3Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(0);
                        ans3Sprite.setAlpha(1);
                        ans4Sprite.setAlpha(0);
                        ans1Correct = true;
                    } else if (ans4Sprite.getBoundingRectangle().contains(x, y)) {
                        ans1Sprite.setAlpha(0);
                        ans2Sprite.setAlpha(0);
                        ans3Sprite.setAlpha(0);
                        ans4Sprite.setAlpha(1);
                        ans1Correct = false;
                    }

                    if (ans5Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(1);
                        ans6Sprite.setAlpha(0);
                        ans7Sprite.setAlpha(0);
                        ans8Sprite.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans6Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(1);
                        ans7Sprite.setAlpha(0);
                        ans8Sprite.setAlpha(0);
                        ans2Correct = true;
                    } else if (ans7Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(0);
                        ans7Sprite.setAlpha(1);
                        ans8Sprite.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans8Sprite.getBoundingRectangle().contains(x, y)) {
                        ans5Sprite.setAlpha(0);
                        ans6Sprite.setAlpha(0);
                        ans7Sprite.setAlpha(0);
                        ans8Sprite.setAlpha(1);
                        ans2Correct = false;
                    }

                    if (ans9Sprite.getBoundingRectangle().contains(x, y)) {
                        ans9Sprite.setAlpha(1);
                        ans10Sprite.setAlpha(0);
                        ans11Sprite.setAlpha(0);
                        ans12Sprite.setAlpha(0);
                        ans3Correct = true;
                    } else if (ans10Sprite.getBoundingRectangle().contains(x, y)) {
                        ans9Sprite.setAlpha(0);
                        ans10Sprite.setAlpha(1);
                        ans11Sprite.setAlpha(0);
                        ans12Sprite.setAlpha(0);
                        ans3Correct = false;
                    } else if (ans11Sprite.getBoundingRectangle().contains(x, y)) {
                        ans11Sprite.setAlpha(0);
                        ans12Sprite.setAlpha(0);
                        ans11Sprite.setAlpha(1);
                        ans12Sprite.setAlpha(0);
                        ans3Correct = true;
                    } else if (ans12Sprite.getBoundingRectangle().contains(x, y)) {
                        ans11Sprite.setAlpha(0);
                        ans12Sprite.setAlpha(0);
                        ans11Sprite.setAlpha(0);
                        ans12Sprite.setAlpha(1);
                        ans3Correct = false;
                    }
                    break;
            }
        }
        if (chapterSection == lastChapterSection)
            return displayLastSectionButtons(19, 15, x, y);
        return super.touchDown(x, y);
    }

    private void assetManager() {
        float col1, col2, row1, row2, row3, row4, row5, row6, row7, row8;
        switch (chapterSection) {
            case 0:
                backgroundSprite.setTexture(question1Texture);

                if (!isTeacher) {
                    col1 = screenWidth / 2.2f;
                    row1 = screenHeight / 1.61f;
                    row2 = screenHeight / 1.73f;
                    row3 = screenHeight / 1.91f;
                    row4 = screenHeight / 2.1f;
                    row5 = screenHeight / 3.18f;
                    row6 = screenHeight / 3.67f;
                    row7 = screenHeight / 4.55f;
                    row8 = screenHeight / 5.9f;

                    clearAnsMarkers();

                    ans1Sprite.setBounds(col1, row1, ans1Sprite.getWidth(), ans1Sprite.getHeight());
                    ans2Sprite.setBounds(col1, row2, ans2Sprite.getWidth(), ans2Sprite.getHeight());
                    ans3Sprite.setBounds(col1, row3, ans3Sprite.getWidth(), ans3Sprite.getHeight());
                    ans4Sprite.setBounds(col1, row4, ans4Sprite.getWidth(), ans4Sprite.getHeight());
                    ans5Sprite.setBounds(col1, row5, ans5Sprite.getWidth(), ans5Sprite.getHeight());
                    ans6Sprite.setBounds(col1, row6, ans6Sprite.getWidth(), ans6Sprite.getHeight());
                    ans7Sprite.setBounds(col1, row7, ans7Sprite.getWidth(), ans7Sprite.getHeight());
                    ans8Sprite.setBounds(col1, row8, ans8Sprite.getWidth(), ans8Sprite.getHeight());
                }
                break;
            case 1:
                backgroundSprite.setTexture(question2Texture);

                if (!isTeacher) {
                    if (ans1Correct) correctAnswers++;
                    if (ans2Correct) correctAnswers++;

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

                    clearAnsMarkers();

                    ans9Sprite.setSize(ans1Sprite.getWidth() * 2.1f, ans1Sprite.getHeight());
                    ans10Sprite.setSize(ans1Sprite.getWidth() * 2.1f, ans1Sprite.getHeight());
                    ans11Sprite.setSize(ans1Sprite.getWidth() * 2.1f, ans1Sprite.getHeight());
                    ans12Sprite.setSize(ans1Sprite.getWidth() * 2.1f, ans1Sprite.getHeight());

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
                }
                break;
            case 2:
                backgroundSprite.setTexture(question3Texture);

                if (!isTeacher) {
                    if (ans1Correct) correctAnswers++;
                    if (ans2Correct) correctAnswers++;
                    if (ans3Correct) correctAnswers++;
                    if (ans4Correct) correctAnswers++;

                    col1 = screenWidth / 2.2f;
                    row1 = screenHeight / 1.8f;
                    row2 = screenHeight / 2;
                    row3 = screenHeight / 4;
                    row4 = screenHeight / 5;

                    clearAnsMarkers();

                    // Put the last 4 answer sprites to normal size
                    ans9Sprite.setSize(ans1Sprite.getWidth(), ans9Sprite.getHeight());
                    ans10Sprite.setSize(ans1Sprite.getWidth(), ans10Sprite.getHeight());
                    ans11Sprite.setSize(ans1Sprite.getWidth(), ans11Sprite.getHeight());
                    ans12Sprite.setSize(ans1Sprite.getWidth(), ans12Sprite.getHeight());

                    ans1Sprite.setBounds(col1, row1, ans1Sprite.getWidth(), ans1Sprite.getHeight());
                    ans2Sprite.setBounds(col1, row2, ans2Sprite.getWidth(), ans2Sprite.getHeight());
                    ans3Sprite.setBounds(col1, row3, ans3Sprite.getWidth(), ans3Sprite.getHeight());
                    ans4Sprite.setBounds(col1, row4, ans4Sprite.getWidth(), ans4Sprite.getHeight());
                }
                break;
            case 3:
                backgroundSprite.setTexture(question4Texture);

                if (!isTeacher) {
                    if (ans1Correct) correctAnswers++;
                    if (ans2Correct) correctAnswers++;

                    col1 = screenWidth / 2;
                    row1 = screenHeight / 1.6f;
                    row2 = screenHeight / 1.72f;
                    row3 = screenHeight / 1.89f;
                    row4 = screenHeight / 2.1f;
                    row5 = screenHeight / 3.15f;
                    row6 = screenHeight / 3.8f;
                    row7 = screenHeight / 4.6f;
                    row8 = screenHeight / 5.5f;

                    clearAnsMarkers();

                    ans1Sprite.setBounds(col1, row1, ans1Sprite.getWidth(), ans1Sprite.getHeight());
                    ans2Sprite.setBounds(col1, row2, ans2Sprite.getWidth(), ans2Sprite.getHeight());
                    ans3Sprite.setBounds(col1, row3, ans3Sprite.getWidth(), ans3Sprite.getHeight());
                    ans4Sprite.setBounds(col1, row4, ans4Sprite.getWidth(), ans4Sprite.getHeight());
                    ans5Sprite.setBounds(col1, row5, ans5Sprite.getWidth(), ans5Sprite.getHeight());
                    ans6Sprite.setBounds(col1, row6, ans6Sprite.getWidth(), ans6Sprite.getHeight());
                    ans7Sprite.setBounds(col1, row7, ans7Sprite.getWidth(), ans7Sprite.getHeight());
                    ans8Sprite.setBounds(col1, row8, ans8Sprite.getWidth(), ans8Sprite.getHeight());
                }
                break;
            case 4:
                backgroundSprite.setTexture(question5Texture);

                if (!isTeacher) {
                    if (ans1Correct) correctAnswers++;
                    if (ans2Correct) correctAnswers++;

                    col1 = screenWidth / 1.9f;
                    row1 = screenHeight / 1.55f;
                    row2 = screenHeight / 1.65f;
                    row3 = screenHeight / 1.84f;
                    row4 = screenHeight / 2;
                    row5 = screenHeight / 2.91f;
                    row6 = screenHeight / 3.485f;
                    row7 = screenHeight / 4.19f;
                    row8 = screenHeight / 5.2f;

                    clearAnsMarkers();

                    ans1Sprite.setSize(ans10Sprite.getWidth() * 1.5f, ans10Sprite.getHeight());
                    ans2Sprite.setSize(ans10Sprite.getWidth() * 1.5f, ans10Sprite.getHeight());
                    ans3Sprite.setSize(ans10Sprite.getWidth() * 1.5f, ans10Sprite.getHeight());
                    ans4Sprite.setSize(ans10Sprite.getWidth() * 1.5f, ans10Sprite.getHeight());
                    ans5Sprite.setSize(ans10Sprite.getWidth() * 1.5f, ans10Sprite.getHeight());
                    ans6Sprite.setSize(ans10Sprite.getWidth() * 1.5f, ans10Sprite.getHeight());
                    ans7Sprite.setSize(ans10Sprite.getWidth() * 1.5f, ans10Sprite.getHeight());
                    ans8Sprite.setSize(ans10Sprite.getWidth() * 1.5f, ans10Sprite.getHeight());

                    ans1Sprite.setBounds(col1, row1, ans1Sprite.getWidth(), ans1Sprite.getHeight());
                    ans2Sprite.setBounds(col1, row2, ans2Sprite.getWidth(), ans2Sprite.getHeight());
                    ans3Sprite.setBounds(col1, row3, ans3Sprite.getWidth(), ans3Sprite.getHeight());
                    ans4Sprite.setBounds(col1, row4, ans4Sprite.getWidth(), ans4Sprite.getHeight());
                    ans5Sprite.setBounds(col1, row5, ans5Sprite.getWidth(), ans5Sprite.getHeight());
                    ans6Sprite.setBounds(col1, row6, ans6Sprite.getWidth(), ans6Sprite.getHeight());
                    ans7Sprite.setBounds(col1, row7, ans7Sprite.getWidth(), ans7Sprite.getHeight());
                    ans8Sprite.setBounds(col1, row8, ans8Sprite.getWidth(), ans8Sprite.getHeight());
                }
                break;
            case 5:
                backgroundSprite.setTexture(question6Texture);

                if (!isTeacher) {
                    if (ans1Correct) correctAnswers++;
                    if (ans2Correct) correctAnswers++;

                    col1 = screenWidth / 6.3f;
                    col2 = screenWidth / 1.77f;
                    row1 = screenHeight / 1.67f;
                    row2 = screenHeight / 1.82f;
                    row3 = screenHeight / 2.6f;
                    row4 = screenHeight / 2.95f;
                    row5 = screenHeight / 5.1f;
                    row6 = screenHeight / 7;

                    clearAnsMarkers();

                    ans1Sprite.setSize(ans10Sprite.getWidth(), ans10Sprite.getHeight());
                    ans2Sprite.setSize(ans10Sprite.getWidth(), ans10Sprite.getHeight());
                    ans3Sprite.setSize(ans10Sprite.getWidth(), ans10Sprite.getHeight());
                    ans4Sprite.setSize(ans10Sprite.getWidth(), ans10Sprite.getHeight());
                    ans5Sprite.setSize(ans10Sprite.getWidth(), ans10Sprite.getHeight());
                    ans6Sprite.setSize(ans10Sprite.getWidth(), ans10Sprite.getHeight());
                    ans7Sprite.setSize(ans10Sprite.getWidth(), ans10Sprite.getHeight());
                    ans8Sprite.setSize(ans10Sprite.getWidth(), ans10Sprite.getHeight());

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
                }
                break;
            case 6:
                backgroundSprite.setTexture(question7Texture);

                if (!isTeacher) {
                    if (ans1Correct) correctAnswers++;
                    if (ans2Correct) correctAnswers++;
                    if (ans3Correct) correctAnswers++;

                    col1 = screenWidth / 2;
                    row1 = screenHeight / 1.65f;
                    row2 = screenHeight / 1.83f;
                    row3 = screenHeight / 3.45f;
                    row4 = screenHeight / 4.1f;

                    clearAnsMarkers();

                    ans1Sprite.setSize(ans12Sprite.getWidth() * 1.1f, ans12Sprite.getHeight());
                    ans2Sprite.setSize(ans12Sprite.getWidth() * 1.1f, ans12Sprite.getHeight());
                    ans3Sprite.setSize(ans12Sprite.getWidth() * 1.1f, ans12Sprite.getHeight());
                    ans4Sprite.setSize(ans12Sprite.getWidth() * 1.1f, ans12Sprite.getHeight());

                    ans1Sprite.setBounds(col1, row1, ans1Sprite.getWidth(), ans1Sprite.getHeight());
                    ans2Sprite.setBounds(col1, row2, ans2Sprite.getWidth(), ans2Sprite.getHeight());
                    ans3Sprite.setBounds(col1, row3, ans3Sprite.getWidth(), ans3Sprite.getHeight());
                    ans4Sprite.setBounds(col1, row4, ans4Sprite.getWidth(), ans4Sprite.getHeight());

                    ans5Sprite.setSize(ans12Sprite.getWidth(), ans12Sprite.getHeight());
                    ans10Sprite.setSize(ans12Sprite.getWidth(), ans12Sprite.getHeight());
                }
                break;
            case 7:
                backgroundSprite.setTexture(question8Texture);

                if (!isTeacher) {
                    if (ans1Correct) correctAnswers++;
                    if (ans2Correct) correctAnswers++;
                    col1 = screenWidth / 4.46f;
                    col2 = screenWidth / 1.96f;
                    row1 = screenHeight / 1.871f;
                    row2 = screenHeight / 2.63f;
                    row3 = screenHeight / 4.45f;

                    clearAnsMarkers();

                    ans1Sprite.setSize(ans12Sprite.getWidth(), ans12Sprite.getHeight());
                    ans2Sprite.setSize(ans12Sprite.getWidth(), ans12Sprite.getHeight());
                    ans3Sprite.setSize(ans12Sprite.getWidth(), ans12Sprite.getHeight());
                    ans4Sprite.setSize(ans12Sprite.getWidth(), ans12Sprite.getHeight());

                    ans1Sprite.setBounds(col1, row1, ans1Sprite.getWidth(), ans1Sprite.getHeight());
                    ans2Sprite.setBounds(col2, row1, ans2Sprite.getWidth(), ans2Sprite.getHeight());
                    ans3Sprite.setBounds(col1, row2, ans3Sprite.getWidth(), ans3Sprite.getHeight());
                    ans4Sprite.setBounds(col2, row2, ans4Sprite.getWidth(), ans4Sprite.getHeight());
                    ans5Sprite.setBounds(col1, row3, ans5Sprite.getWidth(), ans5Sprite.getHeight());
                    ans6Sprite.setBounds(col2, row3, ans6Sprite.getWidth(), ans6Sprite.getHeight());
                }
                break;
            case 8:
                backgroundSprite.setTexture(question9Texture);

                if (!isTeacher) {
                    if (ans1Correct) correctAnswers++;
                    if (ans2Correct) correctAnswers++;
                    if (ans3Correct) correctAnswers++;
                    col1 = screenWidth / 4.735f;
                    col2 = screenWidth / 1.75f;
                    row1 = screenHeight / 1.7f;
                    row2 = screenHeight / 2.3f;
                    row3 = screenHeight / 3.535f;
                    row4 = screenHeight / 5.6f;

                    clearAnsMarkers();

                    ans7Sprite.setSize(ans12Sprite.getWidth() * 1.1f, ans12Sprite.getHeight());
                    ans8Sprite.setSize(ans12Sprite.getWidth() * 1.2f, ans12Sprite.getHeight());

                    ans1Sprite.setBounds(col1, row1, ans1Sprite.getWidth(), ans1Sprite.getHeight());
                    ans2Sprite.setBounds(col2, row1, ans2Sprite.getWidth(), ans2Sprite.getHeight());
                    ans3Sprite.setBounds(col1, row2, ans3Sprite.getWidth(), ans3Sprite.getHeight());
                    ans4Sprite.setBounds(col2, row2, ans4Sprite.getWidth(), ans4Sprite.getHeight());
                    ans5Sprite.setBounds(col1, row3, ans5Sprite.getWidth(), ans5Sprite.getHeight());
                    ans6Sprite.setBounds(col2, row3, ans6Sprite.getWidth(), ans6Sprite.getHeight());
                    ans7Sprite.setBounds(col1, row4, ans7Sprite.getWidth(), ans7Sprite.getHeight());
                    ans8Sprite.setBounds(col2, row4, ans8Sprite.getWidth(), ans8Sprite.getHeight());
                }
                break;
            case 9:
                backgroundSprite.setTexture(question10Texture);

                if (!isTeacher) {
                    if (ans1Correct) correctAnswers++;
                    if (ans2Correct) correctAnswers++;
                    if (ans3Correct) correctAnswers++;
                    if (ans4Correct) correctAnswers++;

                    col1 = screenWidth / 5;
                    col2 = screenWidth / 1.8f;
                    row1 = screenHeight / 1.69f;
                    row2 = screenHeight / 2.3f;
                    row3 = screenHeight / 3.59f;
                    row4 = screenHeight / 4.3f;

                    clearAnsMarkers();

                    ans1Sprite.setSize(ans12Sprite.getWidth() * 1.2f, ans12Sprite.getHeight());
                    ans2Sprite.setSize(ans12Sprite.getWidth() * 1.2f, ans12Sprite.getHeight());
                    ans3Sprite.setSize(ans12Sprite.getWidth() * 1.2f, ans12Sprite.getHeight());
                    ans4Sprite.setSize(ans12Sprite.getWidth() * 1.2f, ans12Sprite.getHeight());
                    ans7Sprite.setSize(ans12Sprite.getWidth(), ans12Sprite.getHeight());
                    ans8Sprite.setSize(ans12Sprite.getWidth(), ans12Sprite.getHeight());

                    ans1Sprite.setBounds(col1, row1, ans1Sprite.getWidth(), ans1Sprite.getHeight());
                    ans2Sprite.setBounds(col2, row1, ans2Sprite.getWidth(), ans2Sprite.getHeight());
                    ans3Sprite.setBounds(col1, row2, ans3Sprite.getWidth(), ans3Sprite.getHeight());
                    ans4Sprite.setBounds(col2, row2, ans4Sprite.getWidth(), ans4Sprite.getHeight());
                    ans5Sprite.setBounds(col1, row3, ans5Sprite.getWidth(), ans5Sprite.getHeight());
                    ans6Sprite.setBounds(col2, row3, ans6Sprite.getWidth(), ans6Sprite.getHeight());
                    ans7Sprite.setBounds(col1, row4, ans7Sprite.getWidth(), ans7Sprite.getHeight());
                    ans8Sprite.setBounds(col2, row4, ans8Sprite.getWidth(), ans8Sprite.getHeight());
                }
                break;
            case 10:
                backgroundSprite.setTexture(question11Texture);

                if (!isTeacher) {
                    if (ans1Correct) correctAnswers++;
                    if (ans2Correct) correctAnswers++;
                    if (ans3Correct) correctAnswers++;

                    col1 = screenWidth / 5;
                    col2 = screenWidth / 1.9f;
                    row1 = screenHeight / 1.675f;
                    row2 = screenHeight / 1.83f;
                    row3 = screenHeight / 2.25f;
                    row4 = screenHeight / 2.5f;
                    row5 = screenHeight / 3.61f;
                    row6 = screenHeight / 4.1f;

                    clearAnsMarkers();

                    ans1Sprite.setSize(ans12Sprite.getWidth(), ans12Sprite.getHeight());
                    ans2Sprite.setSize(ans12Sprite.getWidth(), ans12Sprite.getHeight());
                    ans3Sprite.setSize(ans12Sprite.getWidth(), ans12Sprite.getHeight());
                    ans4Sprite.setSize(ans12Sprite.getWidth(), ans12Sprite.getHeight());

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
                }
                break;
            case 11:
                if (isTeacher) {
                    correctAnswers = 30;
                } else {
                    if (ans1Correct) correctAnswers++;
                    if (ans2Correct) correctAnswers++;
                    if (ans3Correct) correctAnswers++;
                    clearAnsMarkers();
                }
                displayQuizResult(CHAPTER_NINETEEN_SCORE, 15);
        }
        assetNeedUpdate = false;
    }

    /**
     * Clears all answer markers to be invisible
     */
    private void clearAnsMarkers() {
        ans1Correct = ans2Correct = ans3Correct = ans4Correct = false;
        ans1Sprite.setAlpha(0);
        ans2Sprite.setAlpha(0);
        ans3Sprite.setAlpha(0);
        ans4Sprite.setAlpha(0);
        ans5Sprite.setAlpha(0);
        ans6Sprite.setAlpha(0);
        ans7Sprite.setAlpha(0);
        ans8Sprite.setAlpha(0);
        ans9Sprite.setAlpha(0);
        ans10Sprite.setAlpha(0);
        ans11Sprite.setAlpha(0);
        ans12Sprite.setAlpha(0);
    }
}
