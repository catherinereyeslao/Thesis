package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;

import static com.example.aralingpanlipunan.android.database.DatabaseSetup.CHAPTER_NINE_SCORE;

public class ChapterNine extends ChapterCore {

	private Texture introBg, blaanBg, bontocBg, ifugaoBg, itaBg, sulodBg, tboliBg,
			introBalloon1, introBalloon2, 
			atiBalloon1, atiBalloon2, atiBalloon3, blaanBalloon1, blaanBalloon2,
			blaanBalloon3, blaanBalloon4, bontocBalloon1, bontocBalloon2,
			bontocBalloon3, ifugaoBalloon1, ifugaoBalloon2, ifugaoBalloon3,
			sulodBalloon1, sulodBalloon2, sulodBalloon3, sulodBalloon4, 
			tboliBalloon1, tboliBalloon2, tboliBalloon3, tboliBalloon4, question1Bg,
            question2Bg, question3Bg, ansMarkerTexture;
	private Music introS, atiS, blaanS, bontocS, ifugaoS, sulodS, tboliS;
    private Sprite ansMarker, ansMarker2, ansMarker3, ansMarker4, ansMarker5, ansMarker6, ansMarker7, ansMarker8;
    private boolean ansMarkerTouched, ansMarker6Touched, ansMarker7Touched;


	public ChapterNine(AndroidInterface androidInterface, String studName, String password) {
		super(androidInterface, studName, password);
	}

    public ChapterNine(AndroidInterface androidInterface, boolean isTeacher) {
        super(androidInterface, isTeacher);
    }

	@Override
	public void setUp(int screenW, int screenH) {
		super.setUp(screenW, screenH);
		startOfQuestionSection = 7;
		lastChapterSection = 10;
		 
		titleBgTexture = new Texture("titlepages/chapter9.png");

        //sounds
        introS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter9/sound2/intro1chap9.mp3"));
        atiS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter9/sound2/ati1.mp3"));
        blaanS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter9/sound2/blaan1.mp3"));
        bontocS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter9/sound2/bontoc1.mp3"));
        ifugaoS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter9/sound2/ifugao1.mp3"));
        sulodS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter9/sound2/sulod1.mp3"));
		tboliS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter9/sound2/tboli1.mp3"));		  
		//backgrounds
		introBg = new Texture("chapters/chapter9/backgrounds/IntroForChapter9.png");
		blaanBg = new Texture("chapters/chapter9/backgrounds/Blaan.png");
		bontocBg = new Texture("chapters/chapter9/backgrounds/Bontoc.png");
		ifugaoBg = new Texture("chapters/chapter9/backgrounds/Ifugao.png");
		itaBg = new Texture("chapters/chapter9/backgrounds/Ita.png");
		sulodBg = new Texture("chapters/chapter9/backgrounds/Sulod.png");
		tboliBg = new Texture("chapters/chapter9/backgrounds/Tboli.png");
		

        // If user type is teacher, Load answer keys backgrounds & set their score to be perfect
        if (isTeacher) {
            question1Bg = new Texture("chapters/chapter9/answerkeys/answer1.jpg");
            question2Bg = new Texture("chapters/chapter9/answerkeys/answer2.jpg");
            question3Bg = new Texture("chapters/chapter9/answerkeys/answer3.jpg");
            correctAnswers = 10;
            currentRecordedScore = 10;
        } else {
            question1Bg = new Texture("chapters/chapter9/backgrounds/question1.jpg");
            question2Bg = new Texture("chapters/chapter9/backgrounds/question2.jpg");
            question3Bg = new Texture("chapters/chapter9/backgrounds/question3.jpg");
            ansMarkerTexture = new Texture("box.png");

            ansMarker = new Sprite(ansMarkerTexture);
            ansMarker.setSize(ansMarker.getWidth() * getButtonScale(), ansMarker.getHeight() * getButtonScale() / 3.2f);
            final float ansMarkerX = (screenWidth / 1.5f) - (ansMarker.getWidth() / 2);
            final float ansMarkerY = (screenHeight / 1.55f) - (ansMarker.getHeight() / 2);
            ansMarker.setPosition(ansMarkerX, ansMarkerY);
            ansMarker.setBounds(ansMarkerX, ansMarkerY, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker.setAlpha(0);

            ansMarker2 = new Sprite(ansMarkerTexture);
            ansMarker2.setSize(ansMarker.getWidth(), ansMarker.getHeight());
            final float ansMarker2Y = (screenHeight / 1.6f) - (ansMarker2.getHeight() / 2);
            ansMarker2.setPosition(ansMarkerX, ansMarker2Y);
            ansMarker2.setBounds(ansMarkerX, ansMarker2Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker2.setAlpha(0);

            ansMarker3 = new Sprite(ansMarkerTexture);
            ansMarker3.setSize(ansMarker.getWidth(), ansMarker.getHeight());
            final float ansMarker3Y = (screenHeight / 1.75f) - (ansMarker3.getHeight() / 2);
            ansMarker3.setPosition(ansMarkerX, ansMarker3Y);
            ansMarker3.setBounds(ansMarkerX, ansMarker3Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker3.setAlpha(0);

            ansMarker4 = new Sprite(ansMarkerTexture);
            ansMarker4.setSize(ansMarker.getWidth(), ansMarker.getHeight());
            final float ansMarker4Y = (screenHeight / 1.9f) - (ansMarker4.getHeight() / 2);
            ansMarker4.setPosition(ansMarkerX, ansMarker4Y);
            ansMarker4.setBounds(ansMarkerX, ansMarker4Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker4.setAlpha(0);

            ansMarker5 = new Sprite(ansMarkerTexture);
            ansMarker5.setSize(ansMarker.getWidth(), ansMarker.getHeight());
            final float ansMarker5Y = (screenHeight / 2.15f) - (ansMarker5.getHeight() / 2);
            ansMarker5.setPosition(ansMarkerX, ansMarker5Y);
            ansMarker5.setBounds(ansMarkerX, ansMarker5Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker5.setAlpha(0);

            ansMarker6 = new Sprite(ansMarkerTexture);
            ansMarker6.setSize(ansMarker.getWidth(), ansMarker.getHeight());
            final float ansMarker6Y = (screenHeight / 2.3f) - (ansMarker6.getHeight() / 2);
            ansMarker6.setPosition(ansMarkerX, ansMarker6Y);
            ansMarker6.setBounds(ansMarkerX, ansMarker6Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker6.setAlpha(0);

            ansMarker7 = new Sprite(ansMarkerTexture);
            ansMarker7.setSize(ansMarker.getWidth(), ansMarker.getHeight());
            final float ansMarker7Y = (screenHeight / 2.45f) - (ansMarker7.getHeight() / 2);
            ansMarker7.setPosition(ansMarkerX, ansMarker7Y);
            ansMarker7.setBounds(ansMarkerX, ansMarker7Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker7.setAlpha(0);

            ansMarker8 = new Sprite(ansMarkerTexture);
            ansMarker8.setSize(ansMarker.getWidth(), ansMarker.getHeight());
            final float ansMarker8Y = (screenHeight / 2.6f) - (ansMarker8.getHeight() / 2);
            ansMarker8.setPosition(ansMarkerX, ansMarker8Y);
            ansMarker8.setBounds(ansMarkerX, ansMarker8Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker8.setAlpha(0);

            loadNextButton();

            currentRecordedScore = android.getScoresByStudent(loggedInStudent, studentPassword).get(8); // Get Chapter9 score from db
        }
		
		backgroundSprite.setTexture(introBg);
		balloonSprite.setTexture(introBalloon1);

        toggleSoundVolume();
	}

	@Override
	public void display(Batch batch) {
		if (assetNeedUpdate)
			assetManager();
		renderSharedAssets(batch);

        if (!isTeacher && chapterSection >= startOfQuestionSection && chapterSection != lastChapterSection) {
            ansMarker.draw(batch);
            ansMarker2.draw(batch);
            ansMarker3.draw(batch);
            ansMarker4.draw(batch);
            ansMarker5.draw(batch);
            ansMarker6.draw(batch);
            ansMarker7.draw(batch);
            ansMarker8.draw(batch);
            next.draw(batch);
        }

        if (chapterSection == lastChapterSection) {
            if (!isTeacher) question.drawMultiLine(batch, tanong, questionX, questionY);
            startQuiz.draw(batch);
            backToChapters.draw(batch);
        }
	}

	private void assetManager() {
        float ansMarkerX, ansMarkerY, ansMarker2Y, ansMarker3Y, ansMarker4Y, ansMarker5Y, ansMarker6Y, ansMarker7Y, ansMarker8Y;
		switch (chapterSection) {
		case 0:
			backgroundSprite.setTexture(introBg);
			introS.play();
			atiS.stop();
			break;
			
		
		case 1:
			backgroundSprite.setTexture(itaBg);
			introS.stop();
			atiS.play();
			blaanS.stop();
			break;
		case 2:
			backgroundSprite.setTexture(blaanBg);
			atiS.stop();
			blaanS.play();
			bontocS.stop();
			break;
		case 3:
			backgroundSprite.setTexture(bontocBg);
			blaanS.stop();
			bontocS.play();
			ifugaoS.stop();
			break;
		case 4:
			backgroundSprite.setTexture(ifugaoBg);
			bontocS.stop();
			ifugaoS.play();
			sulodS.stop();
			break;
		case 5:
			backgroundSprite.setTexture(sulodBg);
			ifugaoS.stop();
			sulodS.play();
			tboliS.stop();
			break;
		
		case 6:
			backgroundSprite.setTexture(tboliBg);
			sulodS.stop();
			tboliS.play();
			break;
        case 7: // Start of question
        	introS.stop();
        	atiS.stop();
        	blaanS.stop();
        	bontocS.stop();
        	ifugaoS.stop();
        	sulodS.stop();
        	tboliS.stop();
            if (!isTeacher) {
                ansMarkerX = (screenWidth / 1.5f) - (ansMarker.getWidth() / 2);
                ansMarkerY = (screenHeight / 1.43f) - (ansMarker.getHeight() / 2);
                ansMarker.setPosition(ansMarkerX, ansMarkerY);
                ansMarker.setBounds(ansMarkerX, ansMarkerY, ansMarker.getWidth(), ansMarker.getHeight());

                ansMarker2Y = (screenHeight / 1.537f) - (ansMarker.getHeight() / 2);
                ansMarker2.setPosition(ansMarkerX, ansMarker2Y);
                ansMarker2.setBounds(ansMarkerX, ansMarker2Y, ansMarker.getWidth(), ansMarker.getHeight());

                ansMarker3Y = (screenHeight / 1.69f) - (ansMarker.getHeight() / 2);
                ansMarker3.setPosition(ansMarkerX, ansMarker3Y);
                ansMarker3.setBounds(ansMarkerX, ansMarker3Y, ansMarker.getWidth(), ansMarker.getHeight());

                ansMarker4Y = (screenHeight / 1.855f) - (ansMarker.getHeight() / 2);
                ansMarker4.setPosition(ansMarkerX, ansMarker4Y);
                ansMarker4.setBounds(ansMarkerX, ansMarker4Y, ansMarker.getWidth(), ansMarker.getHeight());

                ansMarker5Y = (screenHeight / 2.345f) - (ansMarker.getHeight() / 2);
                ansMarker5.setPosition(ansMarkerX, ansMarker5Y);
                ansMarker5.setBounds(ansMarkerX, ansMarker5Y, ansMarker.getWidth(), ansMarker.getHeight());

                ansMarker6Y = (screenHeight / 2.62f) - (ansMarker.getHeight() / 2);
                ansMarker6.setPosition(ansMarkerX, ansMarker6Y);
                ansMarker6.setBounds(ansMarkerX, ansMarker6Y, ansMarker.getWidth(), ansMarker.getHeight());

                ansMarker7Y = (screenHeight / 3.1f) - (ansMarker.getHeight() / 2);
                ansMarker7.setPosition(ansMarkerX, ansMarker7Y);
                ansMarker7.setBounds(ansMarkerX, ansMarker7Y, ansMarker.getWidth(), ansMarker.getHeight());

                ansMarker8Y = (screenHeight / 3.645f) - (ansMarker.getHeight() / 2);
                ansMarker8.setPosition(ansMarkerX, ansMarker8Y);
                ansMarker8.setBounds(ansMarkerX, ansMarker8Y, ansMarker.getWidth(), ansMarker.getHeight());
            }

            backgroundSprite.setTexture(question1Bg);
            break;
        case 8:
            if (!isTeacher) {
                if (ansMarkerTouched)
                    correctAnswers++;
                if (ansMarker6Touched)
                    correctAnswers++;

                ansMarkerX = (screenWidth / 1.4f) - (ansMarker.getWidth() / 2);
                ansMarkerY = (screenHeight / 1.182f) - (ansMarker.getHeight() / 2);
                ansMarker.setPosition(ansMarkerX, ansMarkerY);
                ansMarker.setBounds(ansMarkerX, ansMarkerY, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker.setAlpha(0);

                ansMarker2Y = (screenHeight / 1.255f) - (ansMarker.getHeight() / 2);
                ansMarker2.setPosition(ansMarkerX, ansMarker2Y);
                ansMarker2.setBounds(ansMarkerX, ansMarker2Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker2.setAlpha(0);

                ansMarker3Y = (screenHeight / 1.3681f) - (ansMarker.getHeight() / 2);
                ansMarker3.setPosition(ansMarkerX, ansMarker3Y);
                ansMarker3.setBounds(ansMarkerX, ansMarker3Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker3.setAlpha(0);

                ansMarker4Y = (screenHeight / 1.4545f) - (ansMarker.getHeight() / 2);
                ansMarker4.setPosition(ansMarkerX, ansMarker4Y);
                ansMarker4.setBounds(ansMarkerX, ansMarker4Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker4.setAlpha(0);

                ansMarker5Y = (screenHeight / 1.9f) - (ansMarker.getHeight() / 2);
                ansMarker5.setPosition(ansMarkerX, ansMarker5Y);
                ansMarker5.setBounds(ansMarkerX, ansMarker5Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker5.setAlpha(0);

                ansMarker6Y = (screenHeight / 2.11f) - (ansMarker.getHeight() / 2);
                ansMarker6.setPosition(ansMarkerX, ansMarker6Y);
                ansMarker6.setBounds(ansMarkerX, ansMarker6Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker6.setAlpha(0);

                ansMarker7Y = (screenHeight / 2.36f) - (ansMarker.getHeight() / 2);
                ansMarker7.setPosition(ansMarkerX, ansMarker7Y);
                ansMarker7.setBounds(ansMarkerX, ansMarker7Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker7.setAlpha(0);

                ansMarker8Y = (screenHeight / 2.78f) - (ansMarker.getHeight() / 2);
                ansMarker8.setPosition(ansMarkerX, ansMarker8Y);
                ansMarker8.setBounds(ansMarkerX, ansMarker8Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker8.setAlpha(0);
            }

            backgroundSprite.setTexture(question2Bg);
            break;
        case 9:
            if (!isTeacher) {
                if (ansMarkerTouched)
                    correctAnswers++;
                if (ansMarker7Touched)
                    correctAnswers++;

                ansMarkerX = (screenWidth / 1.427f) - (ansMarker.getWidth() / 2);
                ansMarkerY = (screenHeight / 1.182f) - (ansMarker.getHeight() / 2);
                ansMarker.setPosition(ansMarkerX, ansMarkerY);
                ansMarker.setBounds(ansMarkerX, ansMarkerY, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker.setAlpha(0);

                ansMarker2Y = (screenHeight / 1.255f) - (ansMarker.getHeight() / 2);
                ansMarker2.setPosition(ansMarkerX, ansMarker2Y);
                ansMarker2.setBounds(ansMarkerX, ansMarker2Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker2.setAlpha(0);

                ansMarker3Y = (screenHeight / 1.3681f) - (ansMarker.getHeight() / 2);
                ansMarker3.setPosition(ansMarkerX, ansMarker3Y);
                ansMarker3.setBounds(ansMarkerX, ansMarker3Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker3.setAlpha(0);

                ansMarker4Y = (screenHeight / 1.4545f) - (ansMarker.getHeight() / 2);
                ansMarker4.setPosition(ansMarkerX, ansMarker4Y);
                ansMarker4.setBounds(ansMarkerX, ansMarker4Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker4.setAlpha(0);

                ansMarker5Y = (screenHeight / 2.11f) - (ansMarker.getHeight() / 2);
                ansMarker5.setPosition(ansMarkerX, ansMarker5Y);
                ansMarker5.setBounds(ansMarkerX, ansMarker5Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker5.setAlpha(0);

                ansMarker6Y = (screenHeight / 2.36f) - (ansMarker.getHeight() / 2);
                ansMarker6.setPosition(ansMarkerX, ansMarker6Y);
                ansMarker6.setBounds(ansMarkerX, ansMarker6Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker6.setAlpha(0);

                ansMarker7Y = (screenHeight / 2.78f) - (ansMarker.getHeight() / 2);
                ansMarker7.setPosition(ansMarkerX, ansMarker7Y);
                ansMarker7.setBounds(ansMarkerX, ansMarker7Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker7.setAlpha(0);

                ansMarker8Y = (screenHeight / 3.227f) - (ansMarker.getHeight() / 2);
                ansMarker8.setPosition(ansMarkerX, ansMarker8Y);
                ansMarker8.setBounds(ansMarkerX, ansMarker8Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker8.setAlpha(0);
            }

            backgroundSprite.setTexture(question3Bg);
            break;
        case 10:
            displayQuizResult(CHAPTER_NINE_SCORE, 3);
            break;
		}
		assetNeedUpdate = false;
	}

    @Override
    public int touchDown(float x, float y) {
        if (chapterSection >= lastChapterSection)
            return displayLastSectionButtons(9, 3, x, y);

        if (chapterSection >= startOfQuestionSection && !isTeacher) {
            if (ansMarker.getBoundingRectangle().contains(x, y)) {
                ansMarker.setAlpha(1);
                ansMarker2.setAlpha(0);
                ansMarker3.setAlpha(0);
                ansMarker4.setAlpha(0);
                ansMarkerTouched = true;
            } else if (ansMarker2.getBoundingRectangle().contains(x, y)) {
                ansMarker.setAlpha(0);
                ansMarker2.setAlpha(1);
                ansMarker3.setAlpha(0);
                ansMarker4.setAlpha(0);
                ansMarkerTouched = false;
            } else if (ansMarker3.getBoundingRectangle().contains(x, y)) {
                ansMarker.setAlpha(0);
                ansMarker2.setAlpha(0);
                ansMarker3.setAlpha(1);
                ansMarker4.setAlpha(0);
                ansMarkerTouched = false;
            } else if (ansMarker4.getBoundingRectangle().contains(x, y)) {
                ansMarker.setAlpha(0);
                ansMarker2.setAlpha(0);
                ansMarker3.setAlpha(0);
                ansMarker4.setAlpha(1);
                ansMarkerTouched = false;
            }

            if (ansMarker5.getBoundingRectangle().contains(x, y)) {
                ansMarker5.setAlpha(1);
                ansMarker6.setAlpha(0);
                ansMarker7.setAlpha(0);
                ansMarker8.setAlpha(0);
                ansMarker6Touched = false;
                ansMarker7Touched = false;
            } else if (ansMarker6.getBoundingRectangle().contains(x, y)) {
                ansMarker5.setAlpha(0);
                ansMarker6.setAlpha(1);
                ansMarker7.setAlpha(0);
                ansMarker8.setAlpha(0);
                ansMarker6Touched = true;
                ansMarker7Touched = false;
            } else if (ansMarker7.getBoundingRectangle().contains(x, y)) {
                ansMarker5.setAlpha(0);
                ansMarker6.setAlpha(0);
                ansMarker7.setAlpha(1);
                ansMarker8.setAlpha(0);
                ansMarker6Touched = false;
                ansMarker7Touched = true;
            } else if (ansMarker8.getBoundingRectangle().contains(x, y)) {
                ansMarker5.setAlpha(0);
                ansMarker6.setAlpha(0);
                ansMarker7.setAlpha(0);
                ansMarker8.setAlpha(1);
                ansMarker6Touched = false;
                ansMarker7Touched = false;
            }
        }

        return super.touchDown(x, y);
    }

    @Override
    protected void toggleSoundVolume() {
       
        introS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        atiS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        blaanS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        bontocS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        ifugaoS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        sulodS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		tboliS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
    }

    @Override
	public void dispose() {
		//sounds
    	introS.stop();
        atiS.stop();
        blaanS.stop();
        bontocS.stop();
        ifugaoS.stop();
        sulodS.stop();
		tboliS.stop();
		introS.dispose();
        atiS.dispose();
        blaanS.dispose();
        bontocS.dispose();
        ifugaoS.dispose();
        sulodS.dispose();
		tboliS.dispose();
		//backgrounds
        introBg.dispose();
        blaanBg.dispose();
        bontocBg.dispose();
        ifugaoBg.dispose();
        itaBg.dispose();
        sulodBg.dispose();
        tboliBg.dispose();
        //balloons


        question1Bg.dispose();
        question2Bg.dispose();
        question3Bg.dispose();
        if (!isTeacher) {
            ansMarkerTexture.dispose();
        }
	}

}
