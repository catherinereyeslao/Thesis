package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import static com.example.aralingpanlipunan.android.database.DatabaseSetup.CHAPTER_ELEVEN_SCORE;

public class ChapterEleven extends ChapterCore {
	private Texture introBg, kalayaanBg, amaBg, guroBg, inaBg, pusoBg,
			mahalNaArawBg, paskoBg, pistaBg, santacruzanBg, introBalloon1,
			kalayaanBalloon1, kalayaanBalloon2, valentinesChar1, valentinesChar2,
			kalayaanBalloon3, kalayaanBalloon4, amaBalloon1, amaBalloon2,
			amaBalloon3, amaBalloon4, guroBalloon1, guroBalloon2, guroBalloon3,
			guroBalloon4, guroBalloon5, inaBalloon1, inaBalloon2, inaBalloon3,
			pusoBalloon1, pusoBalloon2, mahalNaArawBalloon1,
			mahalNaArawBalloon2, mahalNaArawBalloon3, paskoBalloon1,
			paskoBalloon2, paskoBalloon3, pistaBalloon1, pistaBalloon2,
			santacruzanBalloon1, santacruzanBalloon2, question1Bg, question2Bg,
			question3Bg, question4Bg, question5Bg, ansMarkerTexture;
	private Music introS, kalayaanS, amaS, guroS,inaS,pusoS,mahalnaarawS,paskoS,pistaS, santaS;
	private Sprite ansMarker, ansMarker2, ansMarker3, ansMarker4, ansMarker5,
			ansMarker6, ansMarker7, ansMarker8, extraCharacterSprite;
    private short valentineElapsed = 0;
	private boolean ans1Correct, ans2Correct;

	public ChapterEleven(AndroidInterface androidInterface, String studentName, String password) {
		super(androidInterface, studentName, password);
	}

	public ChapterEleven(AndroidInterface androidInterface, boolean isTeacher) {
		super(androidInterface, isTeacher);
	}

	@Override
	public void setUp(int screenW, int screenH) {
		super.setUp(screenW, screenH);
		startOfQuestionSection = 10;
		lastChapterSection = 15;
		assetNeedUpdate = true;

		// sound
		introS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter11/sounds/introchap11.m4a"));
		kalayaanS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter11/sound2/kalayaan1.mp3"));
		amaS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter11/sound2/ama1.mp3"));
		guroS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter11/sound2/guro1.mp3"));
		inaS  = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter11/sound2/ina1.mp3"));
		pusoS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter11/sound2/puso1.mp3"));
		mahalnaarawS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter11/sound2/mahalnaaraw1.mp3"));
		paskoS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter11/sound2/pasko1.mp3"));
		pistaS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter11/sound2/pista1.mp3"));
		santaS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter11/sound2/santacruzan1.mp3"));

		// background
		introBg = new Texture(
				"chapters/chapter11/backgrounds/IntroForChapter11.png");
		kalayaanBg = new Texture(
				"chapters/chapter11/backgrounds/Araw ng kalayaan.png");
		amaBg = new Texture(
				"chapters/chapter11/backgrounds/Araw ng mga ama.png");
		guroBg = new Texture(
				"chapters/chapter11/backgrounds/Araw ng mga guro.png");
		inaBg = new Texture(
				"chapters/chapter11/backgrounds/Araw ng mga ina.png");
		pusoBg = new Texture(
				"chapters/chapter11/backgrounds/Araw ng mga puso.png");
		mahalNaArawBg = new Texture(
				"chapters/chapter11/backgrounds/Mahal na araw.png");
		paskoBg = new Texture("chapters/chapter11/backgrounds/Pasko.png");
		pistaBg = new Texture("chapters/chapter11/backgrounds/Pista.png");
		santacruzanBg = new Texture(
				"chapters/chapter11/backgrounds/Santacruzan.png");

		// Question/game backgrounds
		if (isTeacher) {
			question1Bg = new Texture(
					"chapters/chapter11/answerkeys/answer1.jpg");
			question2Bg = new Texture(
					"chapters/chapter11/answerkeys/answer2.jpg");
			question3Bg = new Texture(
					"chapters/chapter11/answerkeys/answer3.jpg");
			question4Bg = new Texture(
					"chapters/chapter11/answerkeys/answer4.jpg");
			question5Bg = new Texture(
					"chapters/chapter11/answerkeys/answer5.jpg");
			correctAnswers = 9;
		} else {
			question1Bg = new Texture(
					"chapters/chapter11/backgrounds/question1.jpg");
			question2Bg = new Texture(
					"chapters/chapter11/backgrounds/question2.jpg");
			question3Bg = new Texture(
					"chapters/chapter11/backgrounds/question3.jpg");
			question4Bg = new Texture(
					"chapters/chapter11/backgrounds/question4.jpg");
			question5Bg = new Texture(
					"chapters/chapter11/backgrounds/question5.jpg");

			ansMarkerTexture = new Texture("box.png");
			ansMarker = new Sprite(ansMarkerTexture);
			ansMarker.setSize(
					(ansMarker.getWidth() * getButtonScale()) * 1.156f,
					(ansMarker.getHeight() * getButtonScale()) / 3.397f);

			ansMarker2 = new Sprite(ansMarkerTexture);
			ansMarker2.setSize(ansMarker.getWidth(), ansMarker.getHeight());

			ansMarker3 = new Sprite(ansMarkerTexture);
			ansMarker3.setSize(ansMarker.getWidth(), ansMarker.getHeight());

			ansMarker4 = new Sprite(ansMarkerTexture);
			ansMarker4.setSize(ansMarker.getWidth(), ansMarker.getHeight());

			ansMarker5 = new Sprite(ansMarkerTexture);
			ansMarker5.setSize(ansMarker.getWidth(), ansMarker.getHeight());

			ansMarker6 = new Sprite(ansMarkerTexture);
			ansMarker6.setSize(ansMarker.getWidth(), ansMarker.getHeight());

			ansMarker7 = new Sprite(ansMarkerTexture);
			ansMarker7.setSize(ansMarker.getWidth(), ansMarker.getHeight());

			ansMarker8 = new Sprite(ansMarkerTexture);
			ansMarker8.setSize(ansMarker.getWidth(), ansMarker.getHeight());

			loadNextButton();
		}

        valentinesChar1 = new Texture("chapters/chapter11/characters/valentines1.png");
        valentinesChar2 = new Texture("chapters/chapter11/characters/valentines2.png");
        extraCharacterSprite = new Sprite(valentinesChar1);
        extraCharacterSprite.setSize(girl.getWidth(), girl.getHeight());
        extraCharacterSprite.setPosition(screenWidth / 1.4f, 0);

		
        toggleSoundVolume();
	}

	@Override
	public void display(Batch batch) {
		if (assetNeedUpdate)
			assetManager();
		renderSharedAssets(batch);

        if (chapterSection == 17 ) {
            if (valentineElapsed < 160)
                valentineElapsed++;
            else if (!extraCharacterSprite.getTexture().equals(valentinesChar2))
                extraCharacterSprite.setTexture(valentinesChar2);
            extraCharacterSprite.draw(batch);
        }

		if (!isTeacher && chapterSection >= startOfQuestionSection
				&& chapterSection < lastChapterSection) {
			ansMarker.draw(batch);
			ansMarker2.draw(batch);
			ansMarker3.draw(batch);
			ansMarker4.draw(batch);
			ansMarker5.draw(batch);
			ansMarker6.draw(batch);
			ansMarker7.draw(batch);
			ansMarker8.draw(batch);
		}

		if (!isTeacher && next != null
				&& chapterSection >= startOfQuestionSection
				&& chapterSection < lastChapterSection)
			next.draw(batch);

		drawQuizResult(batch);
	}

	private void assetManager() {
		float ansX, ansY, ans2Y, ans3Y, ans4Y, ans5Y, ans6Y, ans7Y, ans8Y;
		switch (chapterSection) {
		case 0:
			backgroundSprite.setTexture(introBg);
			introS.play();
			kalayaanS.stop();
			break;
		case 1:
			backgroundSprite.setTexture(kalayaanBg);
			introS.stop();
			kalayaanS.play();
			amaS.stop();
			break;
		case 2://2
			backgroundSprite.setTexture(amaBg);
			kalayaanS.stop();
			amaS.play();
			guroS.stop();
			break;
		case 3://3
			backgroundSprite.setTexture(guroBg);
			amaS.stop();
			guroS.play();
			inaS.stop();
			break;
		case 4://4
			backgroundSprite.setTexture(inaBg);
			guroS.stop();
			inaS.play();
			pusoS.stop();
			break;
		case 5://5
			backgroundSprite.setTexture(pusoBg);
			inaS.stop();
			pusoS.play();
			mahalnaarawS.stop();
			break;
		
		case 6://6
			backgroundSprite.setTexture(mahalNaArawBg);
			pusoS.stop();
			mahalnaarawS.play();
			paskoS.stop();
			break;
		case 7://7
			backgroundSprite.setTexture(paskoBg);
			mahalnaarawS.stop();
			paskoS.play();
			pistaS.stop();
			break;
		
		case 8://8
			backgroundSprite.setTexture(pistaBg);
			paskoS.stop();
			pistaS.play();
			santaS.stop();
			break;
		
		case 9://9
			backgroundSprite.setTexture(santacruzanBg);
			pistaS.stop();
			santaS.play();
		
		case 10: // Start of game section 10
			introS.stop();
			kalayaanS.stop();
			amaS.stop();
			guroS.stop();
			inaS.stop();
			pusoS.stop();
			mahalnaarawS.stop();
			paskoS.stop();
			pistaS.stop();
			santaS.stop();
			if (!isTeacher) {
				correctAnswers = 0;
				ans1Correct = ans2Correct = false;

				ansX = screenWidth / 1.7f;
				ansY = screenHeight / 1.4f;
				ansMarker.setPosition(ansX, ansY);
				ansMarker.setBounds(ansX, ansY, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker.setAlpha(0);

				ans2Y = screenHeight / 1.51f;
				ansMarker2.setPosition(ansX, ans2Y);
				ansMarker2.setBounds(ansX, ans2Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker2.setAlpha(0);

				ans3Y = screenHeight / 1.62f;
				ansMarker3.setPosition(ansX, ans3Y);
				ansMarker3.setBounds(ansX, ans3Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker3.setAlpha(0);

				ans4Y = screenHeight / 1.75f;
				ansMarker4.setPosition(ansX, ans4Y);
				ansMarker4.setBounds(ansX, ans4Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker4.setAlpha(0);

				ans5Y = screenHeight / 2.4f;
				ansMarker5.setPosition(ansX, ans5Y);
				ansMarker5.setBounds(ansX, ans5Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker5.setAlpha(0);

				ans6Y = screenHeight / 2.615f;
				ansMarker6.setPosition(ansX, ans6Y);
				ansMarker6.setBounds(ansX, ans6Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker6.setAlpha(0);

				ans7Y = screenHeight / 3.1f;
				ansMarker7.setPosition(ansX, ans7Y);
				ansMarker7.setBounds(ansX, ans7Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker7.setAlpha(0);

				ans8Y = screenHeight / 3.6f;
				ansMarker8.setPosition(ansX, ans8Y);
				ansMarker8.setBounds(ansX, ans8Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker8.setAlpha(0);
			}

			backgroundSprite.setTexture(question1Bg);
			break;
		case 11://11
			if (!isTeacher) {
				if (ans1Correct)
					correctAnswers++;
				if (ans2Correct)
					correctAnswers++;
				ans1Correct = ans2Correct = false;

				ansX = screenWidth / 1.59f;
				ansY = screenHeight / 1.26f;
				ansMarker.setPosition(ansX, ansY);
				ansMarker.setBounds(ansX, ansY, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker.setAlpha(0);

				ans2Y = screenHeight / 1.34f;
				ansMarker2.setPosition(ansX, ans2Y);
				ansMarker2.setBounds(ansX, ans2Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker2.setAlpha(0);

				ans3Y = screenHeight / 1.45f;
				ansMarker3.setPosition(ansX, ans3Y);
				ansMarker3.setBounds(ansX, ans3Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker3.setAlpha(0);

				ans4Y = screenHeight / 1.56f; // 1.75
				ansMarker4.setPosition(ansX, ans4Y);
				ansMarker4.setBounds(ansX, ans4Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker4.setAlpha(0);

				ans5Y = screenHeight / 2.2f;
				ansMarker5.setPosition(ansX, ans5Y);
				ansMarker5.setBounds(ansX, ans5Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker5.setAlpha(0);

				ans6Y = screenHeight / 2.415f;
				ansMarker6.setPosition(ansX, ans6Y);
				ansMarker6.setBounds(ansX, ans6Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker6.setAlpha(0);

				ans7Y = screenHeight / 2.86f;
				ansMarker7.setPosition(ansX, ans7Y);
				ansMarker7.setBounds(ansX, ans7Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker7.setAlpha(0);

				ans8Y = screenHeight / 3.36f;
				ansMarker8.setPosition(ansX, ans8Y);
				ansMarker8.setBounds(ansX, ans8Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker8.setAlpha(0);
			}

			backgroundSprite.setTexture(question2Bg);
			break;
		case 12://12
			if (!isTeacher) {
				if (ans1Correct)
					correctAnswers++;
				if (ans2Correct)
					correctAnswers++;
				ans1Correct = ans2Correct = false;

				ansX = screenWidth / 1.58f;
				ansY = screenHeight / 1.31f;
				ansMarker.setPosition(ansX, ansY);
				ansMarker.setBounds(ansX, ansY, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker.setAlpha(0);

				ans2Y = screenHeight / 1.42f;
				ansMarker2.setPosition(ansX, ans2Y);
				ansMarker2.setBounds(ansX, ans2Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker2.setAlpha(0);

				ans3Y = screenHeight / 1.53f;
				ansMarker3.setPosition(ansX, ans3Y);
				ansMarker3.setBounds(ansX, ans3Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker3.setAlpha(0);

				ans4Y = screenHeight / 1.64f;
				ansMarker4.setPosition(ansX, ans4Y);
				ansMarker4.setBounds(ansX, ans4Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker4.setAlpha(0);

				ans5Y = screenHeight / 2.09f;
				ansMarker5.setPosition(ansX, ans5Y);
				ansMarker5.setBounds(ansX, ans5Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker5.setAlpha(0);

				ans6Y = screenHeight / 2.41f;
				ansMarker6.setPosition(ansX, ans6Y);
				ansMarker6.setBounds(ansX, ans6Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker6.setAlpha(0);

				ans7Y = screenHeight / 2.62f;
				ansMarker7.setPosition(ansX, ans7Y);
				ansMarker7.setBounds(ansX, ans7Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker7.setAlpha(0);

				ans8Y = screenHeight / 3;
				ansMarker8.setPosition(ansX, ans8Y);
				ansMarker8.setBounds(ansX, ans8Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker8.setAlpha(0);
			}

			backgroundSprite.setTexture(question3Bg);
			break;
		case 13://13
			if (!isTeacher) {
				if (ans1Correct)
					correctAnswers++;
				if (ans2Correct)
					correctAnswers++;
				ans1Correct = ans2Correct = false;

				ansX = screenWidth / 1.59f;
				ansY = screenHeight / 1.31f;
				ansMarker.setPosition(ansX, ansY);
				ansMarker.setBounds(ansX, ansY, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker.setAlpha(0);

				ans2Y = screenHeight / 1.42f;
				ansMarker2.setPosition(ansX, ans2Y);
				ansMarker2.setBounds(ansX, ans2Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker2.setAlpha(0);

				ans3Y = screenHeight / 1.53f;
				ansMarker3.setPosition(ansX, ans3Y);
				ansMarker3.setBounds(ansX, ans3Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker3.setAlpha(0);

				ans4Y = screenHeight / 1.64f;
				ansMarker4.setPosition(ansX, ans4Y);
				ansMarker4.setBounds(ansX, ans4Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker4.setAlpha(0);

				ans5Y = screenHeight / 2.4075f;
				ansMarker5.setPosition(ansX, ans5Y);
				ansMarker5.setBounds(ansX, ans5Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker5.setAlpha(0);

				ans6Y = screenHeight / 2.624f;
				ansMarker6.setPosition(ansX, ans6Y);
				ansMarker6.setBounds(ansX, ans6Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker6.setAlpha(0);

				ans7Y = screenHeight / 3.08f;
				ansMarker7.setPosition(ansX, ans7Y);
				ansMarker7.setBounds(ansX, ans7Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker7.setAlpha(0);

				ans8Y = screenHeight / 3.7f;
				ansMarker8.setPosition(ansX, ans8Y);
				ansMarker8.setBounds(ansX, ans8Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker8.setAlpha(0);
			}

			backgroundSprite.setTexture(question4Bg);
			break;
		case 14://14
			if (!isTeacher) {
				if (ans1Correct)
					correctAnswers++;
				if (ans2Correct)
					correctAnswers++;
				ans1Correct = ans2Correct = false;

				ansX = screenWidth / 1.5f;
				ansY = screenHeight / 1.59f;
				ansMarker.setPosition(ansX, ansY);
				ansMarker.setBounds(ansX, ansY, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker.setAlpha(0);

				ans2Y = screenHeight / 1.7f;
				ansMarker2.setPosition(ansX, ans2Y);
				ansMarker2.setBounds(ansX, ans2Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker2.setAlpha(0);

				ans3Y = screenHeight / 1.855f;
				ansMarker3.setPosition(ansX, ans3Y);
				ansMarker3.setBounds(ansX, ans3Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker3.setAlpha(0);

				ans4Y = screenHeight / 2.08f;
				ansMarker4.setPosition(ansX, ans4Y);
				ansMarker4.setBounds(ansX, ans4Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker4.setAlpha(0);

				ans5Y = screenHeight / 2.09f;
				ansMarker5.setPosition(ansX, ans5Y);
				ansMarker5.setBounds(ansX, ans5Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker5.setAlpha(0);

				ans6Y = screenHeight / 2.41f;
				ansMarker6.setPosition(ansX, ans6Y);
				ansMarker6.setBounds(ansX, ans6Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker6.setAlpha(0);

				ans7Y = screenHeight / 2.62f;
				ansMarker7.setPosition(ansX, ans7Y);
				ansMarker7.setBounds(ansX, ans7Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker7.setAlpha(0);

				ans8Y = screenHeight / 3;
				ansMarker8.setPosition(ansX, ans8Y);
				ansMarker8.setBounds(ansX, ans8Y, ansMarker.getWidth(),
						ansMarker.getHeight());
				ansMarker8.setAlpha(0);
			}

			backgroundSprite.setTexture(question5Bg);
			break;
		case 15://15
			displayQuizResult(CHAPTER_ELEVEN_SCORE, 5);
			break;
		}
		assetNeedUpdate = false;
	}

	@Override
	public int touchDown(float x, float y) {
		if (!isTeacher && chapterSection >= startOfQuestionSection
				&& chapterSection < lastChapterSection) {
			if (ansMarker.getBoundingRectangle().contains(x, y)) {
				ansMarker.setAlpha(1);
				ansMarker2.setAlpha(0);
				ansMarker3.setAlpha(0);
				ansMarker4.setAlpha(0);
				// answer a is correct only for chapSection 31 / question 5
				ans1Correct = chapterSection == 12;
			} else if (ansMarker2.getBoundingRectangle().contains(x, y)) {
				ansMarker.setAlpha(0);
				ansMarker2.setAlpha(1);
				ansMarker3.setAlpha(0);
				ansMarker4.setAlpha(0);
				// answer b is correct only for chapSection 29 / question 1
				ans1Correct = chapterSection == 10 || chapterSection == 12;
			} else if (ansMarker3.getBoundingRectangle().contains(x, y)) {
				ansMarker.setAlpha(0);
				ansMarker2.setAlpha(0);
				ansMarker3.setAlpha(1);
				ansMarker4.setAlpha(0);
				// answer c is correct only for chapSection 30 & 32 / question 3
				// & 7
				ans1Correct = chapterSection == 11 || chapterSection == 13 || chapterSection == 14;
			} else if (ansMarker4.getBoundingRectangle().contains(x, y)) {
				ansMarker.setAlpha(0);
				ansMarker2.setAlpha(0);
				ansMarker3.setAlpha(0);
				ansMarker4.setAlpha(1);
				ans1Correct = false; // This is never a correct answer
			}

			if (chapterSection != 33) {
				if (ansMarker5.getBoundingRectangle().contains(x, y)) {
					ansMarker5.setAlpha(1);
					ansMarker6.setAlpha(0);
					ansMarker7.setAlpha(0);
					ansMarker8.setAlpha(0);
					ans2Correct = chapterSection == 10 || chapterSection == 13;
				} else if (ansMarker6.getBoundingRectangle().contains(x, y)) {
					ansMarker5.setAlpha(0);
					ansMarker6.setAlpha(1);
					ansMarker7.setAlpha(0);
					ansMarker8.setAlpha(0);
					ans2Correct = chapterSection == 11 || chapterSection == 12;
				} else if (ansMarker7.getBoundingRectangle().contains(x, y)) {
					ansMarker5.setAlpha(0);
					ansMarker6.setAlpha(0);
					ansMarker7.setAlpha(1);
					ansMarker8.setAlpha(0);
					ans2Correct = chapterSection == 16;
				} else if (ansMarker8.getBoundingRectangle().contains(x, y)) {
					ansMarker5.setAlpha(0);
					ansMarker6.setAlpha(0);
					ansMarker7.setAlpha(0);
					ansMarker8.setAlpha(1);
					ans2Correct = false;
				}
			}
		}
		if (chapterSection == lastChapterSection)
			return displayLastSectionButtons(11, 5, x, y);

		return super.touchDown(x, y);
	}

    /**
     * Toggles volumes of all music in the chapter. This is where you should
     * set the volume to mute or max depending on how the user set their sounds
     * in the settings menu
     */
    @Override
    protected void toggleSoundVolume() {
    	introS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		kalayaanS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		amaS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		guroS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		inaS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		pusoS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		mahalnaarawS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		paskoS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		pistaS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		santaS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
       
    }

    @Override
	public void dispose() {
    	introS.stop();
		kalayaanS.stop();
		amaS.stop();
		guroS.stop();
		inaS.stop();
		pusoS.stop();
		mahalnaarawS.stop();
		paskoS.stop();
		pistaS.stop();
		santaS.stop();
		
		introS.dispose();
		kalayaanS.dispose();
		amaS.dispose();
		guroS.dispose();
		inaS.dispose();
		pusoS.dispose();
		mahalnaarawS.dispose();
		paskoS.dispose();
		pistaS.dispose();
		santaS.dispose();
		
		introBg.dispose();
		kalayaanBg.dispose();
		amaBg.dispose();
		guroBg.dispose();
		inaBg.dispose();
		pusoBg.dispose();
		mahalNaArawBg.dispose();
		paskoBg.dispose();
		pistaBg.dispose();
		santacruzanBg.dispose();
		
		
        valentinesChar1.dispose();
        valentinesChar2.dispose();
        if (!isTeacher)
            ansMarkerTexture.dispose();
	}
}
