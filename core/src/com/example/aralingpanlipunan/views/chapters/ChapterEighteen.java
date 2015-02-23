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
    private Music intro1S, intro2S, malinis1S, malinis2S, malinis3S, malinis4S, puno1S, puno2S, puno3S, puno4S,
    			  tanim1S, tanim2S, tanim3S, tanim4S, basura1S, basura2S, basura3S, basura4S, basura5S, basura6S, basura7S,
    			  kalikasan1S, kalikasan2S, kalikasan3S, kalikasan4S;
    private boolean ans1Correct, ans2Correct, ans3Correct, ans4Correct, ans5Correct;

    public ChapterEighteen(AndroidInterface androidInterface, String studentName) {
        super(androidInterface, studentName);
    }

    public ChapterEighteen(AndroidInterface androidInterface, boolean isTeacher) {
        super(androidInterface, isTeacher);
    }

    @Override
    public void setUp(int screenW, int screenH) {
        super.setUp(screenW, screenH);
        startOfQuestionSection = 25;
        lastChapterSection = 27;
        //sounds
        intro1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/intro1chap18.m4a"));
        intro2S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/intro2chap18.m4a"));
        malinis1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/malinis1.m4a"));
        malinis2S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/malinis2.m4a"));
        malinis3S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/malinis3.m4a"));
        malinis4S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/malinis4.m4a"));
        puno1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/puno1.m4a"));
        puno2S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/puno2.m4a"));
        puno3S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/puno3.m4a"));
        puno4S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/puno4.m4a"));
        tanim1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/tanim1.m4a"));
        tanim2S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/tanim2.m4a"));
        tanim3S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/tanim3.m4a"));
        tanim4S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/tanim4.m4a"));
        basura1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/basura1.m4a"));
        basura2S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/basura2.m4a"));
        basura3S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/basura3.m4a"));
        basura4S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/basura4.m4a"));
        basura5S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/basura5.m4a"));
        basura6S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/basura6.m4a"));
        basura7S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/basura7.m4a"));
        kalikasan1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/kalikasan1.m4a"));
        kalikasan2S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/kalikasan2.m4a"));
        kalikasan3S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/kalikasan3.m4a"));
        kalikasan4S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter18/sounds/kalikasan4.m4a"));

        // backgrounds
        introBg = new Texture("chapters/chapter18/backgrounds/intro.png");
        alagaBg = new Texture("chapters/chapter18/backgrounds/alaga.png");
        paligidBg = new Texture("chapters/chapter18/backgrounds/paligid.png");
        putolBg = new Texture("chapters/chapter18/backgrounds/putol.png");
        tanimBg = new Texture("chapters/chapter18/backgrounds/tanim.png");
        taponBg = new Texture("chapters/chapter18/backgrounds/tapon.png");

        // balloons
        intro1Balloon = new Texture("chapters/chapter18/balloons/intro1.png");
        intro2Balloon = new Texture("chapters/chapter18/balloons/intro2.png");
        alaga1Balloon = new Texture("chapters/chapter18/balloons/alaga1.png");
        alaga2Balloon = new Texture("chapters/chapter18/balloons/alaga2.png");
        alaga3Balloon = new Texture("chapters/chapter18/balloons/alaga3.png");
        alaga4Balloon = new Texture("chapters/chapter18/balloons/alaga4.png");
        paligid1Balloon = new Texture("chapters/chapter18/balloons/paligid1.png");
        paligid2Balloon = new Texture("chapters/chapter18/balloons/paligid2.png");
        paligid3Balloon = new Texture("chapters/chapter18/balloons/paligid3.png");
        paligid4Balloon = new Texture("chapters/chapter18/balloons/paligid4.png");
        putol1Balloon = new Texture("chapters/chapter18/balloons/putol1.png");
        putol2Balloon = new Texture("chapters/chapter18/balloons/putol2.png");
        putol3Balloon = new Texture("chapters/chapter18/balloons/putol3.png");
        putol4Balloon = new Texture("chapters/chapter18/balloons/putol4.png");
        tanim1Balloon = new Texture("chapters/chapter18/balloons/tanim1.png");
        tanim2Balloon = new Texture("chapters/chapter18/balloons/tanim2.png");
        tanim3Balloon = new Texture("chapters/chapter18/balloons/tanim3.png");
        tanim4Balloon = new Texture("chapters/chapter18/balloons/tanim4.png");
        tapon1Balloon = new Texture("chapters/chapter18/balloons/tapon1.png");
        tapon2Balloon = new Texture("chapters/chapter18/balloons/tapon2.png");
        tapon3Balloon = new Texture("chapters/chapter18/balloons/tapon3.png");
        tapon4Balloon = new Texture("chapters/chapter18/balloons/tapon4.png");
        tapon5Balloon = new Texture("chapters/chapter18/balloons/tapon5.png");
        tapon6Balloon = new Texture("chapters/chapter18/balloons/tapon6.png");
        tapon7Balloon = new Texture("chapters/chapter18/balloons/tapon7.png");

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
    	if (soundSprite.getBoundingRectangle().contains(x, y)) {
			playSoundForSection();
		}
        switch (chapterSection) {
            case 25:
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
            case 26:
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
            case 27:
                return displayLastSectionButtons(18, 5, x, y);
        }
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
    		basura1S.stop();
    		basura1S.play();
    		break;
    	case 3:
    		basura2S.stop();
    		basura2S.play();
    		break;
    	case 4:
    		basura3S.stop();
    		basura3S.play();
    		break;
    	case 5:
    		basura4S.stop();
    		basura4S.play();
    		break;
    	case 6:
    		basura5S.stop();
    		basura5S.play();
    		break;
    	case 7:
    		basura6S.stop();
    		basura6S.play();
    		break;
    	case 8:
    		basura7S.stop();
    		basura7S.play();
    		break;
    	case 9:
    		puno1S.stop();
    		puno1S.play();
    		break;
    	case 10:
    		puno2S.stop();
    		puno2S.play();
    		break;
    	case 11:
    		puno3S.stop();
    		puno3S.play();
    		break;
    	case 12:
    		puno4S.stop();
    		puno4S.play();
    		break;
    	case 13:
    		kalikasan1S.stop();
    		kalikasan1S.play();
    		break;
    	case 14:
    		kalikasan2S.stop();
    		kalikasan2S.play();
    		break;
    	case 15:
    		kalikasan3S.stop();
    		kalikasan3S.play();
    		break;
    	case 16:
    		kalikasan4S.stop();
    		kalikasan4S.play();
    		break;
    	case 17:
    		malinis1S.stop();
    		malinis1S.play();
    		break;
    	case 18:
    		malinis2S.stop();
    		malinis2S.play();
    		break;
    	case 19:
    		malinis3S.stop();
    		malinis3S.play();
    		break;
    	case 20:
    		malinis4S.stop();
    		malinis4S.play();
    		break;
    	case 21:
    		tanim1S.stop();
    		tanim1S.play();
    		break;
    	case 22:
    		tanim2S.stop();
    		tanim2S.play();
    		break;
    	case 23:
    		tanim3S.stop();
    		tanim3S.play();
    		break;
    	case 24:
    		tanim4S.stop();
    		tanim4S.play();
    		break;
    		
    	}
		
	}

	@Override
    public void dispose() {
        super.dispose();
        intro1S.stop();
        intro2S.stop();
        malinis1S.stop();
        malinis2S.stop();
        malinis3S.stop();
        malinis4S.stop();
        puno1S.stop();
        puno2S.stop();
        puno3S.stop();
        puno4S.stop();
        tanim1S.stop();
        tanim2S.stop();
        tanim3S.stop();
        tanim4S.stop();
        basura1S.stop();
        basura2S.stop();
        basura3S.stop();
        basura4S.stop();
        basura5S.stop();
        basura6S.stop();
        basura7S.stop();
        kalikasan1S.stop();
        kalikasan2S.stop();
        kalikasan3S.stop();
        kalikasan4S.stop();
        
        intro1S.dispose();
        intro2S.dispose();
        malinis1S.dispose();
        malinis2S.dispose();
        malinis3S.dispose();
        malinis4S.dispose();
        puno1S.dispose();
        puno2S.dispose();
        puno3S.dispose();
        puno4S.dispose();
        tanim1S.dispose();
        tanim2S.dispose();
        tanim3S.dispose();
        tanim4S.dispose();
        basura1S.dispose();
        basura2S.dispose();
        basura3S.dispose();
        basura4S.dispose();
        basura5S.dispose();
        basura6S.dispose();
        basura7S.dispose();
        kalikasan1S.dispose();
        kalikasan2S.dispose();
        kalikasan3S.dispose();
        kalikasan4S.dispose();
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
                balloonSprite.setTexture(intro1Balloon);
                intro2S.stop();
                break;
            case 1:
                backgroundSprite.setTexture(introBg);
                balloonSprite.setTexture(intro2Balloon);
                intro1S.stop();
                basura1S.stop();
                break;
            case 2:
                backgroundSprite.setTexture(taponBg);
                balloonSprite.setTexture(tapon1Balloon);
                intro2S.stop();
                basura2S.stop();
                break;
            case 3:
                balloonSprite.setTexture(tapon2Balloon);
                basura1S.stop();
                basura3S.stop();
                break;
            case 4:
                balloonSprite.setTexture(tapon3Balloon);
                basura2S.stop();
                basura4S.stop();
                break;
            case 5:
                balloonSprite.setTexture(tapon4Balloon);
                basura3S.stop();
                basura5S.stop();
                break;
            case 6:
                balloonSprite.setTexture(tapon5Balloon);
                basura4S.stop();
                basura6S.stop();
                break;
            case 7:
                balloonSprite.setTexture(tapon6Balloon);
                basura5S.stop();
                basura7S.stop();
                break;
            case 8:
                backgroundSprite.setTexture(taponBg);
                balloonSprite.setTexture(tapon7Balloon);
                basura6S.stop();
                puno1S.stop();
                break;
            case 9:
                backgroundSprite.setTexture(putolBg);
                balloonSprite.setTexture(putol1Balloon);
                basura7S.stop();
                puno2S.stop();
                break;
            case 10:
                balloonSprite.setTexture(putol2Balloon);
                puno1S.stop();
                puno3S.stop();
                break;
            case 11:
                balloonSprite.setTexture(putol3Balloon);
                puno2S.stop();
                puno4S.stop();
                break;
            case 12:
                backgroundSprite.setTexture(putolBg);
                balloonSprite.setTexture(putol4Balloon);
                puno3S.stop();
                kalikasan1S.stop();
                break;
            case 13:
                backgroundSprite.setTexture(alagaBg);
                balloonSprite.setTexture(alaga1Balloon);
                puno4S.stop();
                kalikasan2S.stop();
                break;
            case 14:
                balloonSprite.setTexture(alaga2Balloon);
                kalikasan1S.stop();
                kalikasan3S.stop();
                break;
            case 15:
                balloonSprite.setTexture(alaga3Balloon);
                kalikasan2S.stop();
                kalikasan4S.stop();
                break;
            case 16:
                backgroundSprite.setTexture(alagaBg);
                balloonSprite.setTexture(alaga4Balloon);
                kalikasan3S.stop();
                malinis1S.stop();
                break;
            case 17:
                backgroundSprite.setTexture(paligidBg);
                balloonSprite.setTexture(paligid1Balloon);
                kalikasan4S.stop();
                malinis2S.stop();
                break;
            case 18:
                balloonSprite.setTexture(paligid2Balloon);
                malinis1S.stop();
                malinis3S.stop();
                break;
            case 19:
                balloonSprite.setTexture(paligid3Balloon);
                malinis2S.stop();
                malinis4S.stop();
                break;
            case 20:
                backgroundSprite.setTexture(paligidBg);
                balloonSprite.setTexture(paligid4Balloon);
                malinis3S.stop();
                tanim1S.stop();
                break;
            case 21:
                backgroundSprite.setTexture(tanimBg);
                balloonSprite.setTexture(tanim1Balloon);
                malinis4S.stop();
                tanim2S.stop();
                break;
            case 22:
                balloonSprite.setTexture(tanim2Balloon);
                tanim1S.stop();
                tanim3S.stop();
                break;
            case 23:
                balloonSprite.setTexture(tanim3Balloon);
                tanim2S.stop();
                tanim4S.stop();
                break;
            case 24:
                backgroundSprite.setTexture(tanimBg);
                balloonSprite.setTexture(tanim4Balloon);
                tanim3S.stop();
                break;
            case 25: // start of game
            	tanim4S.stop();
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
            case 26:
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
            case 27:
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
