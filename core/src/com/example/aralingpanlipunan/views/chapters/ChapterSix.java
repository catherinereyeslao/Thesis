package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import com.example.aralingpanlipunan.android.database.DatabaseSetup;

public class ChapterSix extends ChapterCore {
    private Texture question1Bg, question2Bg, question3Bg, question4Bg, question5Bg, question6Bg, answerMarker;
    private Sprite ans1, ans2;
    private float ans1X, ans1Y, ans2Y;

    public ChapterSix(AndroidInterface androidInterface, String studentName, String password) {
        super(androidInterface, studentName, password);
    }

    public ChapterSix(AndroidInterface androidInterface, boolean isTeacher) {
        super(androidInterface, isTeacher);
    }

    @Override
    public void setUp(int screenW, int screenH) {
        super.setUp(screenW, screenH);
        
        startOfQuestionSection = 0;
        lastChapterSection = 7;
        passedQuestionSection = true;
        chapterSection = 1;
        if (isTeacher) {
            question1Bg = new Texture("chapters/chapter6/answerkeys/answer1.jpg");
            question2Bg = new Texture("chapters/chapter6/answerkeys/answer2.jpg");
            question3Bg = new Texture("chapters/chapter6/answerkeys/answer3.jpg");
            question4Bg = new Texture("chapters/chapter6/answerkeys/answer4.jpg");
            question5Bg = new Texture("chapters/chapter6/answerkeys/answer5.jpg");
            question6Bg = new Texture("chapters/chapter6/answerkeys/answer6.jpg");
        } else {
            answerMarker = new Texture("encircle.png");
            question1Bg = new Texture("chapters/chapter6/backgrounds/question1.jpg");
            question2Bg = new Texture("chapters/chapter6/backgrounds/question2.jpg");
            question3Bg = new Texture("chapters/chapter6/backgrounds/question3.jpg");
            question4Bg = new Texture("chapters/chapter6/backgrounds/question4.jpg");
            question5Bg = new Texture("chapters/chapter6/backgrounds/question5.jpg");
            question6Bg = new Texture("chapters/chapter6/backgrounds/question6.jpg");

            ans1 = new Sprite(answerMarker);
            ans1.setSize((ans1.getWidth() * getButtonScale()) * 1.2f, (ans1.getHeight() * getButtonScale()) * 0.85f);
            ans1.setAlpha(0);

            ans2 = new Sprite(answerMarker);
            ans2.setSize((ans2.getWidth() * getButtonScale() * 1.4f), (ans2.getHeight() * getButtonScale()) * 0.85f);
            ans2.setAlpha(0);
        }

        assetNeedUpdate = true;
    }

    @Override
    public void display(Batch batch) {
        if (assetNeedUpdate) assetManager();
        renderSharedAssets(batch);
        if (chapterSection == lastChapterSection) {
            if (!isTeacher) question.drawMultiLine(batch, tanong, questionX, questionY);
            startQuiz.draw(batch);
            backToChapters.draw(batch);
        } else if (!isTeacher) {
            ans1.draw(batch);
            ans2.draw(batch);
        }
    }

    private void assetManager() {
        switch (chapterSection) {
        	case 0: 
        		android.playChap6Video();
        		break;
            case 1:
            	
                backgroundSprite.setTexture(question1Bg);

                if (!isTeacher) {
                    ans1X = (screenWidth / 1.17f) - (ans1.getWidth() / 2);
                    ans1Y = (screenHeight / 2.275f) - (ans1.getHeight() / 2);
                    ans1.setPosition(ans1X, ans1Y);
                    ans1.setBounds(ans1X, ans1Y, ans1.getWidth(), ans1.getHeight());

                    ans2Y = (screenHeight / 2.825f) - (ans1.getHeight() / 2);
                    ans2.setPosition(ans1X, ans2Y);
                    ans2.setBounds(ans1X, ans2Y, ans2.getWidth(), ans2.getHeight());
                }
                break;
            case 2:
                backgroundSprite.setTexture(question2Bg);

                if (!isTeacher) {
                    ans1Y = (screenHeight / 1.99f) - (ans1.getHeight() / 2);
                    ans1.setPosition(ans1X, ans1Y);
                    ans1.setBounds(ans1X, ans1Y, ans1.getWidth(), ans1.getHeight());

                    ans2Y = (screenHeight / 2.31f) - (ans1.getHeight() / 2);
                    ans2.setPosition(ans1X, ans2Y);
                    ans2.setBounds(ans1X, ans2Y, ans2.getWidth(), ans2.getHeight());
                }
                break;
            case 3:
                backgroundSprite.setTexture(question3Bg);

                if (!isTeacher) {
                    ans1X = (screenWidth / 1.3f) - (ans1.getWidth() / 2);
                    ans1.setPosition(ans1X, ans1Y);
                    ans1.setBounds(ans1X, ans1Y, ans1.getWidth(), ans1.getHeight());

                    ans2.setPosition(ans1X, ans2Y);
                    ans2.setBounds(ans1X, ans2Y, ans2.getWidth(), ans2.getHeight());
                }
                break;
            case 4:
                backgroundSprite.setTexture(question4Bg);

                if (!isTeacher) {
                    ans1X = (screenWidth / 1.15f) - (ans1.getWidth() / 2);
                    ans1.setPosition(ans1X, ans1Y);
                    ans1.setBounds(ans1X, ans1Y, ans1.getWidth(), ans1.getHeight());

                    ans2.setPosition(ans1X, ans2Y);
                    ans2.setBounds(ans1X, ans2Y, ans2.getWidth(), ans2.getHeight());
                }
                break;
            case 5:
                backgroundSprite.setTexture(question5Bg);
                break;
            case 6:
                backgroundSprite.setTexture(question6Bg);
                break;
            case 7:
                if (isTeacher) correctAnswers = 6;
                displayQuizResult(DatabaseSetup.CHAPTER_SIX_SCORE, 3);
                break;
        }
        assetNeedUpdate = false;
    }

    @Override
    public int touchDown(float x, float y) {
        if (!isTeacher) {
            switch (chapterSection) {
                case 1:
                    if (ans1.getBoundingRectangle().contains(x, y)) {
                        correctAnswers++;
                        chapterSection++;
                        assetNeedUpdate = true;
                    } else if (ans2.getBoundingRectangle().contains(x, y)) {
                        chapterSection++;
                        assetNeedUpdate = true;
                    }
                    break;
                case 2:
                    if (ans1.getBoundingRectangle().contains(x, y)) {
                        chapterSection++;
                        assetNeedUpdate = true;
                    } else if (ans2.getBoundingRectangle().contains(x, y)) {
                        correctAnswers++;
                        chapterSection++;
                        assetNeedUpdate = true;
                    }
                    break;
                case 3:
                    if (ans1.getBoundingRectangle().contains(x, y)) {
                        correctAnswers++;
                        chapterSection++;
                        assetNeedUpdate = true;
                    } else if (ans2.getBoundingRectangle().contains(x, y)) {
                        chapterSection++;
                        assetNeedUpdate = true;
                    }
                    break;
                case 4:
                    if (ans1.getBoundingRectangle().contains(x, y)) {
                        correctAnswers++;
                        chapterSection++;
                        assetNeedUpdate = true;
                    } else if (ans2.getBoundingRectangle().contains(x, y)) {
                        chapterSection++;
                        assetNeedUpdate = true;
                    }
                    break;
                case 5:
                    if (ans1.getBoundingRectangle().contains(x, y)) {
                        chapterSection++;
                        assetNeedUpdate = true;
                    } else if (ans2.getBoundingRectangle().contains(x, y)) {
                        correctAnswers++;
                        chapterSection++;
                        assetNeedUpdate = true;
                    }
                    break;
                case 6:
                    if (ans1.getBoundingRectangle().contains(x, y)) {
                        chapterSection++;
                        assetNeedUpdate = true;
                    } else if (ans2.getBoundingRectangle().contains(x, y)) {
                        correctAnswers++;
                        chapterSection++;
                        assetNeedUpdate = true;
                    }
                    break;
            }
        }
        if (chapterSection == lastChapterSection) {
            return displayLastSectionButtons(6, 3, x, y);
        }
        return super.touchDown(x, y);
    }

    @Override
    protected void toggleSoundVolume() {
        // This is blank. No sounds to mute in chapter six
    }

    @Override
    public void dispose() {
        super.dispose();
        question1Bg.dispose();
        question2Bg.dispose();
        question3Bg.dispose();
        question4Bg.dispose();
        question5Bg.dispose();
        question6Bg.dispose();
        if (!isTeacher) answerMarker.dispose();
    }
}
