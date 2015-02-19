package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import com.example.aralingpanlipunan.android.database.DatabaseSetup;

public class ChapterFour extends ChapterCore {
    private Texture introBg, libanganBg, pabahayBg, pangEdukasyonBg, pangKalusuganBg, pagkainBg, game1Bg, game2Bg, game3Bg,
    				intro1Balloon, intro2Balloon, kaligtasan1Balloon, kaligtasan2Balloon, libangan1Balloon, libangan2Balloon, 
    				pagaaral1Balloon, pagaaral2Balloon, pagkainBalloon, answerMarker, nextTexture,
    				question1Bg, question2Bg, question3Bg;
    private Sprite ans1True, ans1False, ans2True, ans2False, ans3True, ans3False, ans4True, ans4False, ans5True, ans5False, next;
    private Sound intro1S, intro2S, kaligtasan1S, kaligtasan2S, libangan1S, libangan2S, pagaaral1S, pagaaral2S, pagkain;
    private boolean ans1TrueTouched, ans1FalseTouched, ans2TrueTouched, ans2FalseTouched, ans3TrueTouched, ans3FalseTouched, ans4TrueTouched, ans4FalseTouched, ans5TrueTouched, ans5FalseTouched =false;

    public ChapterFour(AndroidInterface androidInterface, String studentName) {
        super(androidInterface, studentName);
    }

    public ChapterFour(AndroidInterface androidInterface, boolean isTeacher) {
        super(androidInterface, isTeacher);
    }

    @Override
    public void setUp(int screenW, int screenH) {
        super.setUp(screenW, screenH);
        startOfQuestionSection = 9;
        lastChapterSection = 12;

        introBg = new Texture("chapters/chapter4/backgrounds/intro.png");
        libanganBg = new Texture("chapters/chapter4/backgrounds/Libangan.png");
        pabahayBg = new Texture("chapters/chapter4/backgrounds/Pabahay.png");
        pangEdukasyonBg = new Texture("chapters/chapter4/backgrounds/tulong-pang-edukasyon.png");
        pangKalusuganBg = new Texture("chapters/chapter4/backgrounds/tulong-pangkalusugan.png");
        pagkainBg = new Texture("chapters/chapter4/backgrounds/tulong-pagkain.png");

        intro1Balloon = new Texture("chapters/chapter4/balloons/intro1.png");
        intro2Balloon = new Texture("chapters/chapter4/balloons/intro2.png");
        kaligtasan1Balloon = new Texture("chapters/chapter4/balloons/Kaligtasan1.png");
        kaligtasan2Balloon = new Texture("chapters/chapter4/balloons/Kaligtasan2.png");
        libangan1Balloon = new Texture("chapters/chapter4/balloons/Libangan1.png");
        libangan2Balloon = new Texture("chapters/chapter4/balloons/Libangan2.png");
        pagaaral1Balloon = new Texture("chapters/chapter4/balloons/Pagaaral1.png");
        pagaaral2Balloon = new Texture("chapters/chapter4/balloons/Pagaaral2.png");
        pagkainBalloon = new Texture("chapters/chapter4/balloons/Pagkain.png");
        
        intro1S = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter4/sounds/intro1.amr"));
        intro2S = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter4/sounds/intro2.amr"));
        kaligtasan1S = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter4/sounds/kaligtasan1.amr"));
        kaligtasan2S = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter4/sounds/kaligtasan2.amr"));
        libangan1S = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter4/sounds/libangan1.amr"));
        libangan2S = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter4/sounds/libangan2.amr"));
        pagaaral1S = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter4/sounds/pagaaral1.amr"));
        pagaaral2S = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter4/sounds/pagaaral 2.amr"));
        pagkain = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter4/sounds/pagkain.amr"));
        
        if (isTeacher) {
			question1Bg = new Texture(
					"chapters/chapter4/answerkeys/answer1.jpg");
			question2Bg = new Texture(
					"chapters/chapter4/answerkeys/answer2.jpg");
			question3Bg = new Texture(
					"chapters/chapter4/answerkeys/answer3.jpg");

			correctAnswers = 10;
		} else {
			question1Bg = new Texture(
					"chapters/chapter4/backgrounds/question1.jpg");
			question2Bg = new Texture(
					"chapters/chapter4/backgrounds/question2.jpg");
			question3Bg = new Texture(
					"chapters/chapter4/backgrounds/question3.jpg");
		}

        assetNeedUpdate = true;
    }

    @Override
    public void display(Batch batch) {
        if (assetNeedUpdate) assetManager();
        renderSharedAssets(batch);
        switch (chapterSection) {
            case 9:
                ans1True.draw(batch);
                ans1False.draw(batch);
                ans2True.draw(batch);
                ans2False.draw(batch);
                ans3True.draw(batch);
                ans3False.draw(batch);
                next.draw(batch);
                break;
            case 10:
                ans1True.draw(batch);
                ans1False.draw(batch);
                ans2True.draw(batch);
                ans2False.draw(batch);
                ans3True.draw(batch);
                ans3False.draw(batch);
                ans4True.draw(batch);
                ans4False.draw(batch);
                ans5True.draw(batch);
                ans5False.draw(batch);
                next.draw(batch);
                break;
            case 11:
                ans1True.draw(batch);
                ans1False.draw(batch);
                ans2True.draw(batch);
                ans2False.draw(batch);
                next.draw(batch);
                break;
            case 12:
                question.drawMultiLine(batch, tanong, questionX, questionY);
                startQuiz.draw(batch);
                backToChapters.draw(batch);
                break;
        }
    }

    private void assetManager() {
        switch (chapterSection) {
            case 0:
                backgroundSprite.setTexture(introBg);
                balloonSprite.setTexture(intro1Balloon);
                
                break;
            case 1:
                backgroundSprite.setTexture(introBg);
                balloonSprite.setTexture(intro2Balloon);
                intro1S.stop();
                kaligtasan1S.stop();
                
                break;
            case 2:
                backgroundSprite.setTexture(pangKalusuganBg);
                balloonSprite.setTexture(kaligtasan1Balloon);
                intro2S.stop();
                kaligtasan2S.stop();
                
                break;
            case 3:
                backgroundSprite.setTexture(pangKalusuganBg);
                balloonSprite.setTexture(kaligtasan2Balloon);
                kaligtasan1S.stop();
                libangan1S.stop();
                
                break;
            case 4:
                backgroundSprite.setTexture(libanganBg);
                balloonSprite.setTexture(libangan1Balloon);
                kaligtasan2S.stop();
                libangan2S.stop();
               
                break;
            case 5:
                backgroundSprite.setTexture(libanganBg);
                balloonSprite.setTexture(libangan2Balloon);
                libangan1S.stop();
                pagaaral1S.stop();
                
                break;
            case 6:
                backgroundSprite.setTexture(pangEdukasyonBg);
                balloonSprite.setTexture(pagaaral1Balloon);
                libangan2S.stop();
                pagaaral2S.stop();
               
                break;
            case 7:
                backgroundSprite.setTexture(pangEdukasyonBg);
                balloonSprite.setTexture(pagaaral2Balloon);
                pagaaral1S.stop();
                pagkain.stop();
               
                break;
            case 8:
                backgroundSprite.setTexture(pagkainBg);
                balloonSprite.setTexture(pagkainBalloon);
                pagaaral2S.stop();
                //pagkain.stop();
                break;
            case 9: // Start of Game
                correctAnswers = 0;
                setUpGame();
                backgroundSprite.setTexture(game1Bg);
                break;
            case 10:
                if (ans1TrueTouched) correctAnswers++;
                if (ans2TrueTouched) correctAnswers++;
                if (ans3FalseTouched) correctAnswers++;
                backgroundSprite.setTexture(game2Bg);
                float ans1Y = (screenHeight / 1.22f) - (ans1True.getHeight() / 2);
                ans1True.setAlpha(0);
                ans1True.setY(ans1Y);
                ans1True.setBounds(ans1True.getX(), ans1Y, ans1True.getWidth(), ans1True.getHeight());

                ans1False.setAlpha(0);
                ans1False.setY(ans1Y);
                ans1False.setBounds(ans1False.getX(), ans1Y, ans1False.getWidth(), ans1False.getHeight());

                float ans2Y = (screenHeight / 1.44f) - (ans2True.getHeight() / 2);
                ans2True.setAlpha(0);
                ans2True.setY(ans2Y);
                ans2True.setBounds(ans2True.getX(), ans2Y, ans2True.getWidth(), ans2True.getHeight());

                ans2False.setAlpha(0);
                ans2False.setY(ans2Y);
                ans2False.setBounds(ans2False.getX(), ans2Y, ans2False.getWidth(), ans2False.getHeight());

                float ans3Y = (screenHeight / 1.75f) - (ans3True.getHeight() / 2);
                ans3True.setAlpha(0);
                ans3True.setY(ans3Y);
                ans3True.setBounds(ans3True.getX(), ans3Y, ans3True.getWidth(), ans3True.getHeight());

                ans3False.setAlpha(0);
                ans3False.setY(ans3Y);
                ans3False.setBounds(ans3False.getX(), ans3Y, ans3False.getWidth(), ans3False.getHeight());
                break;
            case 11:
                if (ans1TrueTouched) correctAnswers++;
                if (ans2TrueTouched) correctAnswers++;
                if (ans3TrueTouched) correctAnswers++;
                if (ans4TrueTouched) correctAnswers++;
                if (ans5TrueTouched) correctAnswers++;

                ans1TrueTouched = ans1FalseTouched = ans2TrueTouched = ans2FalseTouched = false;
                ans1Y = (screenHeight / 1.28f) - (ans1True.getHeight() / 2);
                ans1True.setAlpha(0);
                ans1True.setY(ans1Y);
                ans1True.setBounds(ans1True.getX(), ans1Y, ans1True.getWidth(), ans1True.getHeight());

                ans1False.setAlpha(0);
                ans1False.setY(ans1Y);
                ans1False.setBounds(ans1False.getX(), ans1Y, ans1False.getWidth(), ans1False.getHeight());

                ans2Y = (screenHeight / 1.49f) - (ans2True.getHeight() / 2);
                ans2True.setAlpha(0);
                ans2True.setY(ans2Y);
                ans2True.setBounds(ans2True.getX(), ans2Y, ans2True.getWidth(), ans2True.getHeight());

                ans2False.setAlpha(0);
                ans2False.setY(ans2Y);
                ans2False.setBounds(ans2False.getX(), ans2Y, ans2False.getWidth(), ans2False.getHeight());

                backgroundSprite.setTexture(game3Bg);
                break;
            case 12:
                if (ans1TrueTouched) correctAnswers++;
                if (ans2TrueTouched) correctAnswers++;
                displayQuizResult(DatabaseSetup.CHAPTER_FOUR_SCORE, 5);
                break;
        }
        assetNeedUpdate = false;
    }

    /**
     * Sets up the assets for the game/quiz
     */
    private void setUpGame() {
        backToChapters.setBounds(0, 0, 0, 0);
        answerMarker = new Texture("encircle.png");
        game1Bg = new Texture("chapters/chapter4/backgrounds/game1Bg.jpg");
        game2Bg = new Texture("chapters/chapter4/backgrounds/game2Bg.jpg");
        game3Bg = new Texture("chapters/chapter4/backgrounds/game3Bg.jpg");

        ans1True = new Sprite(answerMarker);
        ans1True.setSize(ans1True.getWidth() * getButtonScale(), ans1True.getHeight() * getButtonScale());
        final float ans1TrueX = (screenWidth / 2.2f) - (ans1True.getWidth() / 2);
        final float ans1TrueY = (screenHeight / 1.53f) - (ans1True.getHeight() / 2);
        ans1True.setPosition(ans1TrueX, ans1TrueY);
        ans1True.setAlpha(0);
        ans1True.setBounds(ans1TrueX, ans1TrueY, ans1True.getWidth(), ans1True.getHeight());

        ans1False = new Sprite(answerMarker);
        ans1False.setSize(ans1False.getWidth() * getButtonScale(), ans1False.getHeight() * getButtonScale());
        final float ans1FalseX = (screenWidth / 1.48f) - (ans1False.getWidth() / 2);
        ans1False.setPosition(ans1FalseX, ans1TrueY);
        ans1False.setAlpha(0);
        ans1False.setBounds(ans1FalseX, ans1TrueY, ans1False.getWidth(), ans1False.getHeight());

        ans2True = new Sprite(answerMarker);
        ans2True.setSize(ans2True.getWidth() * getButtonScale(), ans2True.getHeight() * getButtonScale());
        final float ans2TrueY = (screenHeight / 2.1f) - (ans1True.getHeight() / 2);
        ans2True.setPosition(ans1TrueX, ans2TrueY);
        ans2True.setAlpha(0);
        ans2True.setBounds(ans1TrueX, ans2TrueY, ans2True.getWidth(), ans2True.getHeight());

        ans2False = new Sprite(answerMarker);
        ans2False.setSize(ans2False.getWidth() * getButtonScale(), ans2False.getHeight() * getButtonScale());
        ans2False.setPosition(ans1FalseX, ans2TrueY);
        ans2False.setAlpha(0);
        ans2False.setBounds(ans1FalseX, ans2TrueY, ans2False.getWidth(), ans2False.getHeight());

        ans3True = new Sprite(answerMarker);
        ans3True.setSize(ans3True.getWidth() * getButtonScale(), ans3True.getHeight() * getButtonScale());
        final float ans3TrueY = (screenHeight / 3.2f) - (ans1True.getHeight() / 2);
        ans3True.setAlpha(0);
        ans3True.setPosition(ans1TrueX, ans3TrueY);
        ans3True.setBounds(ans1TrueX, ans3TrueY, ans3True.getWidth(), ans3True.getHeight());

        ans3False = new Sprite(answerMarker);
        ans3False.setSize(ans3False.getWidth() * getButtonScale(), ans3False.getHeight() * getButtonScale());
        ans3False.setAlpha(0);
        ans3False.setPosition(ans1FalseX, ans3TrueY);
        ans3False.setBounds(ans1FalseX, ans3TrueY, ans3False.getWidth(), ans3False.getHeight());

        ans4True = new Sprite(answerMarker);
        ans4True.setSize(ans4True.getWidth() * getButtonScale(), ans4True.getHeight() * getButtonScale());
        final float ans4TrueY = (screenHeight / 2.39f) - (ans1True.getHeight() / 2);
        ans4True.setAlpha(0);
        ans4True.setPosition(ans1TrueX, ans4TrueY);
        ans4True.setBounds(ans1TrueX, ans4TrueY, ans4True.getWidth(), ans4True.getHeight());

        ans4False = new Sprite(answerMarker);
        ans4False.setSize(ans4False.getWidth() * getButtonScale(), ans4False.getHeight() * getButtonScale());
        ans4False.setAlpha(0);
        ans4False.setPosition(ans1FalseX, ans4TrueY);
        ans4False.setBounds(ans1FalseX, ans4TrueY, ans4False.getWidth(), ans4False.getHeight());

        ans5True = new Sprite(answerMarker);
        ans5True.setSize(ans5True.getWidth() * getButtonScale(), ans5True.getHeight() * getButtonScale());
        final float ans5TrueY = (screenHeight / 3.43f) - (ans1True.getHeight() / 2);
        ans5True.setAlpha(0);
        ans5True.setPosition(ans1TrueX, ans5TrueY);
        ans5True.setBounds(ans1TrueX, ans5TrueY, ans5True.getWidth(), ans5True.getHeight());

        ans5False = new Sprite(answerMarker);
        ans5False.setSize(ans5False.getWidth() * getButtonScale(), ans5False.getHeight() * getButtonScale());
        ans5False.setAlpha(0);
        ans5False.setPosition(ans1FalseX, ans5TrueY);
        ans5False.setBounds(ans1FalseX, ans5TrueY, ans5False.getWidth(), ans5False.getHeight());

        nextTexture = new Texture("buttons/enter.png");
        next = new Sprite(nextTexture);
        next.setSize(next.getWidth() * getButtonScale(), next.getHeight() * getButtonScale());
        final float nextX = (screenWidth / 1.4f);
        final float nextY = next.getHeight() / 10;
        next.setPosition(nextX, nextY);
        next.setBounds(nextX, nextY, next.getWidth(), next.getHeight());
    }

    @Override
    public int touchDown(float x, float y) {
    	 super.touchDown(x, y);
         if (soundSprite.getBoundingRectangle().contains(x, y)) {
             playSoundForSection();
         }
        if (chapterSection >= startOfQuestionSection) {
        	if(!isTeacher){
            if (next.getBoundingRectangle().contains(x, y)) {
                chapterSection++;
                assetNeedUpdate = true;
            }
            if (ans1True.getBoundingRectangle().contains(x, y)) {
                ans1TrueTouched = !ans1TrueTouched;
                if (ans1TrueTouched) {
                    ans1True.setAlpha(1);
                    ans1False.setAlpha(0);
                    ans1FalseTouched = false;
                } else
                    ans1True.setAlpha(0);
            }
            if (ans1False.getBoundingRectangle().contains(x, y)) {
                ans1FalseTouched = !ans1FalseTouched;
                if (ans1FalseTouched) {
                    ans1False.setAlpha(1);
                    ans1True.setAlpha(0);
                    ans1TrueTouched = false;
                } else
                    ans1False.setAlpha(0);
            }
            if (ans2True.getBoundingRectangle().contains(x, y)) {
                ans2TrueTouched = !ans2TrueTouched;
                if (ans2TrueTouched) {
                    ans2True.setAlpha(1);
                    ans2False.setAlpha(0);
                    ans2FalseTouched = false;
                } else
                    ans2True.setAlpha(0);
            }
            if (ans2False.getBoundingRectangle().contains(x, y)) {
                ans2FalseTouched = !ans2FalseTouched;
                if (ans2FalseTouched) {
                    ans2False.setAlpha(1);
                    ans2True.setAlpha(0);
                    ans2TrueTouched = false;
                } else
                    ans2False.setAlpha(0);
            }
            if (ans3True.getBoundingRectangle().contains(x, y) && chapterSection < 12) {
                ans3TrueTouched = !ans3TrueTouched;
                if (ans3TrueTouched) {
                    ans3True.setAlpha(1);
                    ans3False.setAlpha(0);
                    ans3FalseTouched = false;
                } else
                    ans3True.setAlpha(0);
            }
            if (ans3False.getBoundingRectangle().contains(x, y) && chapterSection < 12) {
                ans3FalseTouched = !ans3FalseTouched;
                if (ans3FalseTouched) {
                    ans3False.setAlpha(1);
                    ans3True.setAlpha(0);
                    ans3TrueTouched = false;
                } else
                    ans3False.setAlpha(0);
            }
            if (ans4True.getBoundingRectangle().contains(x, y) && chapterSection == 10) {
                ans4TrueTouched = !ans4TrueTouched;
                if (ans4TrueTouched) {
                    ans4True.setAlpha(1);
                    ans4False.setAlpha(0);
                    ans4FalseTouched = false;
                } else
                    ans4True.setAlpha(0);
            }
            if (ans4False.getBoundingRectangle().contains(x, y) && chapterSection == 10) {
                ans4FalseTouched = !ans4FalseTouched;
                if (ans4FalseTouched) {
                    ans4False.setAlpha(1);
                    ans4True.setAlpha(0);
                    ans4TrueTouched = false;
                } else
                    ans4False.setAlpha(0);
            }
            if (ans5True.getBoundingRectangle().contains(x, y) && chapterSection == 10) {
                ans5TrueTouched = !ans5TrueTouched;
                if (ans5TrueTouched) {
                    ans5True.setAlpha(1);
                    ans5False.setAlpha(0);
                    ans5FalseTouched = false;
                } else
                    ans5True.setAlpha(0);
            }
            if (ans5False.getBoundingRectangle().contains(x, y) && chapterSection == 10) {
                ans5FalseTouched = !ans5FalseTouched;
                if (ans5FalseTouched) {
                    ans5False.setAlpha(1);
                    ans5True.setAlpha(0);
                    ans5TrueTouched = false;
                } else
                    ans5False.setAlpha(0);
            }
            
        }
            return displayLastSectionButtons(4, 5, x,y);
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
        	 
        	 kaligtasan1S.stop();
        	 kaligtasan1S.play();
        	 break;
         case 3:
        	 
        	 kaligtasan2S.stop();
             kaligtasan2S.play();
             break;
         case 4:
        	
        	 libangan1S.stop();
        	 libangan1S.play();
             break;
         case 5:
        	 
        	 libangan2S.stop();
        	 libangan2S.play();
             break;
         case 6:
        	 
        	 pagaaral1S.stop();
        	 pagaaral1S.play();
             break;
         case 7:
        	 
        	 pagaaral2S.stop();
        	 pagaaral2S.play();
             break;
         case 8:
        	 
        	 pagkain.stop();
        	 pagkain.play();
             break;
    	 }
		
	}

	@Override
    public void dispose() {
        super.dispose();
        intro1S.stop();
        intro2S.stop();
        kaligtasan1S.stop();
        kaligtasan2S.stop();
        libangan1S.stop(); 
        libangan2S.stop(); 
        pagaaral1S.stop();
        pagaaral2S.stop();
        pagkain.stop();
        introBg.dispose();
        libanganBg.dispose();
        pabahayBg.dispose();
        pagkainBg.dispose();
        pangEdukasyonBg.dispose();
        pangKalusuganBg.dispose();
        intro1Balloon.dispose();
        intro2Balloon.dispose();
        intro1S.dispose();
        intro2S.dispose();
        kaligtasan1S.dispose();
        kaligtasan2S.dispose();
        libangan1S.dispose(); 
        libangan2S.dispose(); 
        pagaaral1S.dispose();
        pagaaral2S.dispose();
        pagkain.dispose();
        question1Bg.dispose();
        question2Bg.dispose();
        question3Bg.dispose();
        
        
        

        // If user entered the game, dispose these loaded game assets
        if (chapterSection >= startOfQuestionSection) {
            answerMarker.dispose();
            nextTexture.dispose();
            game1Bg.dispose();
            game2Bg.dispose();
            game3Bg.dispose();
        }
    }
}
