package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import static com.example.aralingpanlipunan.android.database.DatabaseSetup.CHAPTER_EIGHTEEN_SCORE;

public class ChapterEighteen extends ChapterCore {
    private Texture question1Bg, question2Bg, introBg, paligidBg, putolBg, tanimBg, taponBg, alagaBg, 
    				intro1Balloon, intro2Balloon, paligid1Balloon, paligid2Balloon, paligid3Balloon, 
    				paligid4Balloon, putol1Balloon, putol2Balloon, putol3Balloon, putol4Balloon, tanim1Balloon, 
    				tanim2Balloon, tanim3Balloon, tanim4Balloon, tapon1Balloon, tapon2Balloon, tapon3Balloon, 
    				tapon4Balloon, tapon5Balloon, tapon6Balloon, tapon7Balloon, alaga1Balloon, alaga2Balloon, 
    				alaga3Balloon, alaga4Balloon, ansMarkerTexture;
    private Sprite ans1A, ans1B, ans2A, ans2B, ans3A, ans3B, ans4A, ans4B, ans5A, ans5B;
    private Music introS, malinisS, punoS, tanimS, basuraS, kalikasanS;
    private boolean ans1Correct, ans2Correct, ans3Correct, ans4Correct, ans5Correct;

    public ChapterEighteen(AndroidInterface androidInterface, String studentName, String password) {
        super(androidInterface, studentName, password);
    }

    public ChapterEighteen(AndroidInterface androidInterface, boolean isTeacher) {
        super(androidInterface, isTeacher);
    }

    @Override
    public void setUp(int screenW, int screenH) {
        super.setUp(screenW, screenH);
        startOfQuestionSection = 6;
        lastChapterSection = 8;
        
        titleBgTexture = new Texture("titlepages/chatper18.png");
        //sounds
        introS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sound2/intro1chap18.mp3"));
        malinisS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sound2/malinis1.mp3"));
        basuraS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sound2/basura1.mp3"));
        kalikasanS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sound2/kalikasan1.mp3"));
        punoS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sound2/puno1.mp3"));
        tanimS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sound2/tanim1.mp3"));
        

        // backgrounds
        introBg = new Texture("chapters/chapter18/backgrounds/intro.png");
        alagaBg = new Texture("chapters/chapter18/backgrounds/alaga.png");
        paligidBg = new Texture("chapters/chapter18/backgrounds/paligid.png");
        putolBg = new Texture("chapters/chapter18/backgrounds/putol.png");
        tanimBg = new Texture("chapters/chapter18/backgrounds/tanim.png");
        taponBg = new Texture("chapters/chapter18/backgrounds/tapon.png");

      
        // questions
        if (isTeacher) {
            question1Bg = new Texture("chapters/chapter18/answerkeys/answer1.jpg");
            question2Bg = new Texture("chapters/chapter18/answerkeys/answer2.jpg");
        } else {
            question1Bg = new Texture("chapters/chapter18/backgrounds/question1.jpg");
            question2Bg = new Texture("chapters/chapter18/backgrounds/question2.jpg");

            ansMarkerTexture = new Texture("box.png");
            ans1A = new Sprite(ansMarkerTexture);
            ans1A.setSize((ans1A.getWidth() * getButtonScale()) / 1.05f, (ans1A.getHeight() * getButtonScale()) / 3.397f);

            ans1B = new Sprite(ansMarkerTexture);
            ans1B.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans2A = new Sprite(ansMarkerTexture);
            ans2A.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans2B = new Sprite(ansMarkerTexture);
            ans2B.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans3A = new Sprite(ansMarkerTexture);
            ans3A.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans3B = new Sprite(ansMarkerTexture);
            ans3B.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans4A = new Sprite(ansMarkerTexture);
            ans4A.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans4B = new Sprite(ansMarkerTexture);
            ans4B.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans5A = new Sprite(ansMarkerTexture);
            ans5A.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans5B = new Sprite(ansMarkerTexture);
            ans5B.setSize(ans1A.getWidth(), ans1A.getHeight());

            loadNextButton();
        }
        toggleSoundVolume();
    }

    @Override
    public void display(Batch batch) {
        if (assetNeedUpdate) assetManager();
        renderSharedAssets(batch);

        if (!isTeacher && chapterSection >= startOfQuestionSection && chapterSection < lastChapterSection) {
            ans1A.draw(batch);
            ans1B.draw(batch);
            ans2A.draw(batch);
            ans2B.draw(batch);
            ans3A.draw(batch);
            ans3B.draw(batch);
            ans4A.draw(batch);
            ans4B.draw(batch);
            ans5A.draw(batch);
            ans5B.draw(batch);
            next.draw(batch);
        }

        drawQuizResult(batch);
    }

    @Override
    public int touchDown(float x, float y) {
        switch (chapterSection) {
            case 6:
                if (!isTeacher) {
                    if (ans1A.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(1);
                        ans1B.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans1B.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(1);
                        ans1Correct = true;
                    }

                    if (ans2A.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(1);
                        ans2B.setAlpha(0);
                        ans2Correct = true;
                    } else if (ans2B.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(0);
                        ans2B.setAlpha(1);
                        ans2Correct = false;
                    }

                    if (ans3A.getBoundingRectangle().contains(x, y)) {
                        ans3A.setAlpha(1);
                        ans3B.setAlpha(0);
                        ans3Correct = false;
                    } else if (ans3B.getBoundingRectangle().contains(x, y)) {
                        ans3A.setAlpha(0);
                        ans3B.setAlpha(1);
                        ans3Correct = true;
                    }

                    if (ans4A.getBoundingRectangle().contains(x, y)) {
                        ans4A.setAlpha(1);
                        ans4B.setAlpha(0);
                        ans4Correct = true;
                    } else if (ans4B.getBoundingRectangle().contains(x, y)) {
                        ans4A.setAlpha(0);
                        ans4B.setAlpha(1);
                        ans4Correct = false;
                    }

                    if (ans5A.getBoundingRectangle().contains(x, y)) {
                        ans5A.setAlpha(1);
                        ans5B.setAlpha(0);
                        ans5Correct = false;
                    } else if (ans5B.getBoundingRectangle().contains(x, y)) {
                        ans5A.setAlpha(0);
                        ans5B.setAlpha(1);
                        ans5Correct = true;
                    }
                }
                break;
            case 7:
                if (!isTeacher) {
                    if (ans1A.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(1);
                        ans1B.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans1B.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(1);
                        ans1Correct = true;
                    }

                    if (ans2A.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(1);
                        ans2B.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans2B.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(0);
                        ans2B.setAlpha(1);
                        ans2Correct = true;
                    }

                    if (ans3A.getBoundingRectangle().contains(x, y)) {
                        ans3A.setAlpha(1);
                        ans3B.setAlpha(0);
                        ans3Correct = false;
                    } else if (ans3B.getBoundingRectangle().contains(x, y)) {
                        ans3A.setAlpha(0);
                        ans3B.setAlpha(1);
                        ans3Correct = true;
                    }

                    if (ans4A.getBoundingRectangle().contains(x, y)) {
                        ans4A.setAlpha(1);
                        ans4B.setAlpha(0);
                        ans4Correct = false;
                    } else if (ans4B.getBoundingRectangle().contains(x, y)) {
                        ans4A.setAlpha(0);
                        ans4B.setAlpha(1);
                        ans4Correct = true;
                    }

                    if (ans5A.getBoundingRectangle().contains(x, y)) {
                        ans5A.setAlpha(1);
                        ans5B.setAlpha(0);
                        ans5Correct = true;
                    } else if (ans5B.getBoundingRectangle().contains(x, y)) {
                        ans5A.setAlpha(0);
                        ans5B.setAlpha(1);
                        ans5Correct = false;
                    }
                }
                break;
            case 8:
                return displayLastSectionButtons(18, 5, x, y);
        }
        return super.touchDown(x, y);
    }

    @Override
    protected void toggleSoundVolume() {
        introS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        malinisS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        punoS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        tanimS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        basuraS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        kalikasanS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
       
    }

    @Override
    public void dispose() {
        super.dispose();
        introS.stop();
        malinisS.stop();
        basuraS.stop();
        punoS.stop();
        tanimS.stop();
        kalikasanS.stop();
        introS.dispose();
        malinisS.dispose();
        basuraS.dispose();
        punoS.dispose();
        tanimS.dispose();
        kalikasanS.dispose();
        
        question1Bg.dispose();
        question2Bg.dispose();
        introBg.dispose();
        paligidBg.dispose();
        putolBg.dispose();
        tanimBg.dispose();
        taponBg.dispose();
        alagaBg.dispose();
        intro1Balloon.dispose();
        intro2Balloon.dispose();
        paligid1Balloon.dispose();
        paligid2Balloon.dispose();
        paligid3Balloon.dispose();
        paligid4Balloon.dispose();
        putol1Balloon.dispose();
        putol2Balloon.dispose();
        putol3Balloon.dispose();
        putol4Balloon.dispose();
        tanim1Balloon.dispose();
        tanim2Balloon.dispose();
        tanim3Balloon.dispose();
        tanim4Balloon.dispose();
        tapon1Balloon.dispose();
        tapon2Balloon.dispose();
        tapon3Balloon.dispose();
        tapon4Balloon.dispose();
        tapon5Balloon.dispose();
        tapon6Balloon.dispose();
        tapon7Balloon.dispose();
        alaga1Balloon.dispose();
        alaga2Balloon.dispose();
        alaga3Balloon.dispose();
        alaga4Balloon.dispose();
        if (!isTeacher) ansMarkerTexture.dispose();
    }

    private void assetManager() {
        float leftCol, rightCol, row1, row2, row3, row4, row5;
        switch (chapterSection) {
            case 0:
                backgroundSprite.setTexture(introBg);
                introS.play();
                basuraS.stop();
                break;
           
            case 1://basura
                backgroundSprite.setTexture(taponBg);
                introS.stop();
                basuraS.play();
                punoS.stop();
                break;
           
            case 2://puno
                backgroundSprite.setTexture(putolBg);
                basuraS.stop();
                punoS.play();
                kalikasanS.stop();
                break;
            case 3://kalikasan
                backgroundSprite.setTexture(alagaBg);
                punoS.stop();
                kalikasanS.play();
                malinisS.stop();
                break;
            case 4://malinis
                backgroundSprite.setTexture(paligidBg);
                kalikasanS.stop();
                malinisS.play();
                tanimS.stop();
                break;
            case 5://tanim
                backgroundSprite.setTexture(tanimBg);
                malinisS.stop();
                tanimS.play();
                break;
            case 6: // start of game
            	introS.stop();
            	basuraS.stop();
            	kalikasanS.stop();
            	malinisS.stop();
            	punoS.stop();
            	tanimS.stop();
                backgroundSprite.setTexture(question1Bg);
                if (!isTeacher) {
                    ans1Correct = ans2Correct = ans3Correct = ans4Correct = ans5Correct = false;
                    leftCol = screenWidth / 3.22f;
                    rightCol = screenWidth / 1.63f;
                    row1 = screenHeight / 1.6f;
                    row2 = screenHeight / 1.883f;
                    row3 = screenHeight / 2.28f;
                    row4 = screenHeight / 2.935f;
                    row5 = screenHeight / 3.98f;

                    ans1A.setPosition(leftCol, row1);
                    ans1A.setBounds(leftCol, row1, ans1A.getWidth(), ans1A.getHeight());
                    ans1A.setAlpha(0);

                    ans1B.setPosition(rightCol, row1);
                    ans1B.setBounds(rightCol, row1, ans1B.getWidth(), ans1B.getHeight());
                    ans1B.setAlpha(0);

                    ans2A.setPosition(leftCol, row2);
                    ans2A.setBounds(leftCol, row2, ans2A.getWidth(), ans2B.getHeight());
                    ans2A.setAlpha(0);

                    ans2B.setPosition(rightCol, row2);
                    ans2B.setBounds(rightCol, row2, ans2B.getWidth(), ans2B.getHeight());
                    ans2B.setAlpha(0);

                    ans3A.setPosition(leftCol, row3);
                    ans3A.setBounds(leftCol, row3, ans3A.getWidth(), ans3A.getHeight());
                    ans3A.setAlpha(0);

                    ans3B.setPosition(rightCol, row3);
                    ans3B.setBounds(rightCol, row3, ans3B.getWidth(), ans3B.getHeight());
                    ans3B.setAlpha(0);

                    ans4A.setPosition(leftCol, row4);
                    ans4A.setBounds(leftCol, row4, ans4A.getWidth(), ans4A.getHeight());
                    ans4A.setAlpha(0);

                    ans4B.setPosition(rightCol, row4);
                    ans4B.setBounds(rightCol, row4, ans4B.getWidth(), ans4B.getHeight());
                    ans4B.setAlpha(0);

                    ans5A.setPosition(leftCol, row5);
                    ans5A.setBounds(leftCol, row5, ans5A.getWidth(), ans5A.getHeight());
                    ans5A.setAlpha(0);

                    ans5B.setPosition(rightCol, row5);
                    ans5B.setBounds(rightCol, row5, ans5B.getWidth(), ans5B.getHeight());
                    ans5B.setAlpha(0);
                }
                break;
            case 7:
                backgroundSprite.setTexture(question2Bg);
                if (!isTeacher) {
                    if (ans1Correct) correctAnswers++;
                    if (ans2Correct) correctAnswers++;
                    if (ans3Correct) correctAnswers++;
                    if (ans4Correct) correctAnswers++;
                    if (ans5Correct) correctAnswers++;
                    ans1Correct = ans2Correct = ans3Correct = ans4Correct = ans5Correct = false;

                    leftCol = screenWidth / 3;
                    rightCol = screenWidth / 1.54f;
                    row1 = screenHeight / 1.35f;
                    row2 = screenHeight / 1.57f;
                    row3 = screenHeight / 2;
                    row4 = screenHeight / 2.49f;
                    row5 = screenHeight / 3.7f;

                    ans1A.setPosition(leftCol, row1);
                    ans1A.setBounds(leftCol, row1, ans1A.getWidth(), ans1A.getHeight());
                    ans1A.setAlpha(0);

                    ans1B.setPosition(rightCol, row1);
                    ans1B.setBounds(rightCol, row1, ans1B.getWidth(), ans1B.getHeight());
                    ans1B.setAlpha(0);

                    ans2A.setPosition(leftCol, row2);
                    ans2A.setBounds(leftCol, row2, ans2A.getWidth(), ans2B.getHeight());
                    ans2A.setAlpha(0);

                    ans2B.setPosition(rightCol, row2);
                    ans2B.setBounds(rightCol, row2, ans2B.getWidth(), ans2B.getHeight());
                    ans2B.setAlpha(0);

                    ans3A.setPosition(leftCol, row3);
                    ans3A.setBounds(leftCol, row3, ans3A.getWidth(), ans3A.getHeight());
                    ans3A.setAlpha(0);

                    ans3B.setPosition(rightCol, row3);
                    ans3B.setBounds(rightCol, row3, ans3B.getWidth(), ans3B.getHeight());
                    ans3B.setAlpha(0);

                    ans4A.setPosition(leftCol, row4);
                    ans4A.setBounds(leftCol, row4, ans4A.getWidth(), ans4A.getHeight());
                    ans4A.setAlpha(0);

                    ans4B.setPosition(rightCol, row4);
                    ans4B.setBounds(rightCol, row4, ans4B.getWidth(), ans4B.getHeight());
                    ans4B.setAlpha(0);

                    ans5A.setPosition(leftCol, row5);
                    ans5A.setBounds(leftCol, row5, ans5A.getWidth(), ans5A.getHeight());
                    ans5A.setAlpha(0);

                    ans5B.setPosition(rightCol, row5);
                    ans5B.setBounds(rightCol, row5, ans5B.getWidth(), ans5B.getHeight());
                    ans5B.setAlpha(0);
                }
                break;
            case 8:
                if (isTeacher) {
                    correctAnswers = 10;
                } else {
                    if (ans1Correct) correctAnswers++;
                    if (ans2Correct) correctAnswers++;
                    if (ans3Correct) correctAnswers++;
                    if (ans4Correct) correctAnswers++;
                    if (ans5Correct) correctAnswers++;
                    ans1Correct = ans2Correct = ans3Correct = ans4Correct = ans5Correct = false;
                }
                displayQuizResult(CHAPTER_EIGHTEEN_SCORE, 5);
                break;
        }
        assetNeedUpdate = false;
    }
}
