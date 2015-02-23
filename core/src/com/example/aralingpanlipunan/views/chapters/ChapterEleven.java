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
	private Music intro1S, kalayaan1S, kalayaan2S, kalayaan3S, kalayaan4S,
			ama1S, ama2S, ama3S, ama4S, guro1S, guro2S, guro3S, guro4S, guro5S,
			ina1S, ina2S, ina3S, puso1S, puso2S, mahalNaAraw1S, mahalNaAraw2S,
			mahalNaAraw3S, pasko1S, pasko2S, pasko3S, pista1S, pista2S,
			santa1S, santa2S;
	private Sprite ansMarker, ansMarker2, ansMarker3, ansMarker4, ansMarker5,
			ansMarker6, ansMarker7, ansMarker8, extraCharacterSprite;
    private short valentineElapsed = 0;
	private boolean ans1Correct, ans2Correct;

	public ChapterEleven(AndroidInterface androidInterface, String studentName) {
		super(androidInterface, studentName);
	}

	public ChapterEleven(AndroidInterface androidInterface, boolean isTeacher) {
		super(androidInterface, isTeacher);
	}

	@Override
	public void setUp(int screenW, int screenH) {
		super.setUp(screenW, screenH);
		startOfQuestionSection = 29;
		lastChapterSection = 34;
		assetNeedUpdate = true;

		// sound
		intro1S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/introchap11.m4a"));
		kalayaan1S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/kalayaan1.m4a"));
		kalayaan2S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/kalayaan2.m4a"));
		kalayaan3S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/kalayaan3.m4a"));
		kalayaan4S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/kalayaan4.m4a"));
		ama1S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/ama1.m4a"));
		ama2S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/ama2.m4a"));
		ama3S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/ama3.m4a"));
		ama4S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/ama4.m4a"));
		guro1S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/guro1.m4a"));
		guro2S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/guro2.m4a"));
		guro3S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/guro3.m4a"));
		guro4S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/guro4.m4a"));
		guro5S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/guro5.m4a"));
		ina1S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/ina1.m4a"));
		ina2S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/ina2.m4a"));
		ina3S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/ina3.m4a"));
		puso1S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/puso1.m4a"));
		puso2S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/puso2.m4a"));
		mahalNaAraw1S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/mahalnaaraw1.m4a"));
		mahalNaAraw2S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/mahalnaaraw2.m4a"));
		mahalNaAraw3S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/mahalnaaraw3.m4a"));
		pasko1S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/pasko1.m4a"));
		pasko2S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/pasko2.m4a"));
		pasko3S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/pasko3.m4a"));
		pista1S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/pista1.m4a"));
		pista2S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/pista2.m4a"));
		santa1S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/santacruzan1.m4a"));
		santa2S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter11/sounds/santacruzan2.m4a"));

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

		// balloons
		introBalloon1 = new Texture("chapters/chapter11/balloons/Intro.png");
		kalayaanBalloon1 = new Texture(
				"chapters/chapter11/balloons/Kalayaan1.png");
		kalayaanBalloon2 = new Texture(
				"chapters/chapter11/balloons/Kalayaan2.png");
		kalayaanBalloon3 = new Texture(
				"chapters/chapter11/balloons/Kalayaan3.png");
		kalayaanBalloon4 = new Texture(
				"chapters/chapter11/balloons/Kalayaan4.png");
		amaBalloon1 = new Texture("chapters/chapter11/balloons/ArawNgAma1.png");
		amaBalloon2 = new Texture("chapters/chapter11/balloons/ArawNgAma2.png");
		amaBalloon3 = new Texture("chapters/chapter11/balloons/ArawNgAma3.png");
		amaBalloon4 = new Texture("chapters/chapter11/balloons/ArawNgAma4.png");
		guroBalloon1 = new Texture(
				"chapters/chapter11/balloons/ArawNgGuro1.png");
		guroBalloon2 = new Texture(
				"chapters/chapter11/balloons/ArawNgGuro2.png");
		guroBalloon3 = new Texture(
				"chapters/chapter11/balloons/ArawNgGuro3.png");
		guroBalloon4 = new Texture(
				"chapters/chapter11/balloons/ArawNgGuro4.png");
		guroBalloon5 = new Texture(
				"chapters/chapter11/balloons/ArawNgGuro5.png");
		inaBalloon1 = new Texture("chapters/chapter11/balloons/ArawNgIna1.png");
		inaBalloon2 = new Texture("chapters/chapter11/balloons/ArawNgIna2.png");
		inaBalloon3 = new Texture("chapters/chapter11/balloons/ArawNgIna3.png");
		pusoBalloon1 = new Texture(
				"chapters/chapter11/balloons/ArawNgPuso1.png");
		pusoBalloon2 = new Texture(
				"chapters/chapter11/balloons/ArawNgPuso2.png");
		mahalNaArawBalloon1 = new Texture(
				"chapters/chapter11/balloons/MahalNaAraw1.png");
		mahalNaArawBalloon2 = new Texture(
				"chapters/chapter11/balloons/MahalNaAraw2.png");
		mahalNaArawBalloon3 = new Texture(
				"chapters/chapter11/balloons/MahalNaAraw3.png");
		paskoBalloon1 = new Texture("chapters/chapter11/balloons/Pasko1.png");
		paskoBalloon2 = new Texture("chapters/chapter11/balloons/Pasko2.png");
		paskoBalloon3 = new Texture("chapters/chapter11/balloons/Pasko3.png");
		pistaBalloon1 = new Texture("chapters/chapter11/balloons/Pista1.png");
		pistaBalloon2 = new Texture("chapters/chapter11/balloons/Pista2.png");
		santacruzanBalloon1 = new Texture(
				"chapters/chapter11/balloons/Santacruzan1.png");
		santacruzanBalloon2 = new Texture(
				"chapters/chapter11/balloons/Santacruzan2.png");
	}

	@Override
	public void display(Batch batch) {
		if (assetNeedUpdate)
			assetManager();
		renderSharedAssets(batch);

        if (chapterSection == 17 || chapterSection == 18) {
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
			balloonSprite.setTexture(introBalloon1);
			kalayaan1S.stop();
			break;
		case 1:
			backgroundSprite.setTexture(kalayaanBg);
			balloonSprite.setTexture(kalayaanBalloon1);
			intro1S.stop();
			kalayaan2S.stop();
			break;
		case 2:
			balloonSprite.setTexture(kalayaanBalloon2);
			kalayaan1S.stop();
			kalayaan3S.stop();
			break;
		case 3:
			balloonSprite.setTexture(kalayaanBalloon3);
			kalayaan2S.stop();
			kalayaan4S.stop();
			break;
		case 4:
            backgroundSprite.setTexture(kalayaanBg);
			balloonSprite.setTexture(kalayaanBalloon4);
			kalayaan3S.stop();
			ama1S.stop();
			break;
		case 5:
			backgroundSprite.setTexture(amaBg);
			balloonSprite.setTexture(amaBalloon1);
			kalayaan4S.stop();
			ama2S.stop();
			break;
		case 6:
			balloonSprite.setTexture(amaBalloon2);
			ama1S.stop();
			ama3S.stop();
			break;
		case 7:
			balloonSprite.setTexture(amaBalloon3);
			ama2S.stop();
			ama4S.stop();
			break;
		case 8:
            backgroundSprite.setTexture(amaBg);
			balloonSprite.setTexture(amaBalloon4);
			ama3S.stop();
			guro1S.stop();
			break;
		case 9:
			backgroundSprite.setTexture(guroBg);
			balloonSprite.setTexture(guroBalloon1);
			ama4S.stop();
			guro2S.stop();
			break;
		case 10:
			balloonSprite.setTexture(guroBalloon2);
			guro1S.stop();
			guro3S.stop();
			break;
		case 11:
			balloonSprite.setTexture(guroBalloon3);
			guro2S.stop();
			guro4S.stop();
			break;
		case 12:
			balloonSprite.setTexture(guroBalloon4);
			guro3S.stop();
			guro5S.stop();
			break;
		case 13:
            backgroundSprite.setTexture(guroBg);
			balloonSprite.setTexture(guroBalloon5);
			guro4S.stop();
			ina1S.stop();
			break;
		case 14:
			backgroundSprite.setTexture(inaBg);
			balloonSprite.setTexture(inaBalloon1);
			guro5S.stop();
			ina2S.stop();
			break;
		case 15:
			balloonSprite.setTexture(inaBalloon2);
			ina1S.stop();
			ina3S.stop();
			break;
		case 16:
            backgroundSprite.setTexture(inaBg);
			balloonSprite.setTexture(inaBalloon3);
			ina2S.stop();
			puso1S.stop();
			break;
		case 17:
			backgroundSprite.setTexture(pusoBg);
			balloonSprite.setTexture(pusoBalloon1);
			ina3S.stop();
			puso2S.stop();
			break;
		case 18:
            backgroundSprite.setTexture(pusoBg);
			balloonSprite.setTexture(pusoBalloon2);
			puso1S.stop();
			mahalNaAraw1S.stop();
			break;
		case 19:
			backgroundSprite.setTexture(mahalNaArawBg);
			balloonSprite.setTexture(mahalNaArawBalloon1);
			puso2S.stop();
			mahalNaAraw2S.stop();
			break;
		case 20:
			balloonSprite.setTexture(mahalNaArawBalloon2);
			mahalNaAraw1S.stop();
			mahalNaAraw3S.stop();
			break;
		case 21:
            backgroundSprite.setTexture(mahalNaArawBg);
			balloonSprite.setTexture(mahalNaArawBalloon3);
			mahalNaAraw2S.stop();
			pasko1S.stop();
			break;
		case 22:
			backgroundSprite.setTexture(paskoBg);
			balloonSprite.setTexture(paskoBalloon1);
			mahalNaAraw3S.stop();
			pasko2S.stop();
			break;
		case 23:
			balloonSprite.setTexture(paskoBalloon2);
			pasko1S.stop();
			pasko3S.stop();
			break;
		case 24:
            backgroundSprite.setTexture(paskoBg);
			balloonSprite.setTexture(paskoBalloon3);
			pasko2S.stop();
			pista1S.stop();
			break;
		case 25:
			backgroundSprite.setTexture(pistaBg);
			balloonSprite.setTexture(pistaBalloon1);
			pasko3S.stop();
			pista2S.stop();
			break;
		case 26:
            backgroundSprite.setTexture(pistaBg);
			balloonSprite.setTexture(pistaBalloon2);
			pista1S.stop();
			santa1S.stop();
			break;
		case 27:
			backgroundSprite.setTexture(santacruzanBg);
			balloonSprite.setTexture(santacruzanBalloon1);
			pista2S.stop();
			santa2S.stop();
			break;
		case 28:
            backgroundSprite.setTexture(santacruzanBg);
			balloonSprite.setTexture(santacruzanBalloon2);
			santa1S.stop();
			break;
		case 29: // Start of game section
			santa2S.stop();
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
		case 30:
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
		case 31:
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
		case 32:
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
		case 33:
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
		case 34:
			displayQuizResult(CHAPTER_ELEVEN_SCORE, 5);
			break;
		}
		assetNeedUpdate = false;
	}

	@Override
	public int touchDown(float x, float y) {
		if (soundSprite.getBoundingRectangle().contains(x, y)) {
			playSoundForSection();
		}
		if (!isTeacher && chapterSection >= startOfQuestionSection
				&& chapterSection < lastChapterSection) {
			if (ansMarker.getBoundingRectangle().contains(x, y)) {
				ansMarker.setAlpha(1);
				ansMarker2.setAlpha(0);
				ansMarker3.setAlpha(0);
				ansMarker4.setAlpha(0);
				// answer a is correct only for chapSection 31 / question 5
				ans1Correct = chapterSection == 31;
			} else if (ansMarker2.getBoundingRectangle().contains(x, y)) {
				ansMarker.setAlpha(0);
				ansMarker2.setAlpha(1);
				ansMarker3.setAlpha(0);
				ansMarker4.setAlpha(0);
				// answer b is correct only for chapSection 29 / question 1
				ans1Correct = chapterSection == 29 || chapterSection == 31;
			} else if (ansMarker3.getBoundingRectangle().contains(x, y)) {
				ansMarker.setAlpha(0);
				ansMarker2.setAlpha(0);
				ansMarker3.setAlpha(1);
				ansMarker4.setAlpha(0);
				// answer c is correct only for chapSection 30 & 32 / question 3
				// & 7
				ans1Correct = chapterSection == 30 || chapterSection == 32 || chapterSection == 33;
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
					ans2Correct = chapterSection == 29 || chapterSection == 32;
				} else if (ansMarker6.getBoundingRectangle().contains(x, y)) {
					ansMarker5.setAlpha(0);
					ansMarker6.setAlpha(1);
					ansMarker7.setAlpha(0);
					ansMarker8.setAlpha(0);
					ans2Correct = chapterSection == 30 || chapterSection == 31;
				} else if (ansMarker7.getBoundingRectangle().contains(x, y)) {
					ansMarker5.setAlpha(0);
					ansMarker6.setAlpha(0);
					ansMarker7.setAlpha(1);
					ansMarker8.setAlpha(0);
					ans2Correct = chapterSection == 35;
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

	private void playSoundForSection() {
		switch (chapterSection) {
		case 0:
			intro1S.stop();
			intro1S.play();
			break;
		case 1:
			kalayaan1S.stop();
			kalayaan1S.play();
			break;
		case 2:
			kalayaan2S.stop();
			kalayaan2S.play();
			break;
		case 3:
			kalayaan3S.stop();
			kalayaan3S.play();
			break;
		case 4:
			kalayaan4S.stop();
			kalayaan4S.play();
			break;
		case 5:
			ama1S.stop();
			ama1S.play();
			break;
		case 6:
			ama2S.stop();
			ama2S.play();
			break;
		case 7:
			ama3S.stop();
			ama3S.play();
			break;
		case 8:
			ama4S.stop();
			ama4S.play();
			break;
		case 9:
			guro1S.stop();
			guro1S.play();
			break;
		case 10:
			guro2S.stop();
			guro2S.play();
			break;
		case 11:
			guro3S.stop();
			guro3S.play();
			break;
		case 12:
			guro4S.stop();
			guro4S.play();
			break;
		case 13:
			guro5S.stop();
			guro5S.play();
			break;
		case 14:
			ina1S.stop();
			ina1S.play();
			break;
		case 15:
			ina2S.stop();
			ina2S.play();
			break;
		case 16:
			ina3S.stop();
			ina3S.play();
			break;
		case 17:
			puso1S.stop();
			puso1S.play();
			break;
		case 18:
			puso2S.stop();
			puso2S.play();
			break;
		case 19:
			mahalNaAraw1S.stop();
			mahalNaAraw1S.play();
			break;
		case 20:
			mahalNaAraw2S.stop();
			mahalNaAraw2S.play();
			break;
		case 21:
			mahalNaAraw3S.stop();
			mahalNaAraw3S.play();
			break;
		case 22:
			pasko1S.stop();
			pasko1S.play();
			break;
		case 23:
			pasko2S.stop();
			pasko2S.play();
			break;
		case 24:
			pasko3S.stop();
			pasko3S.play();
			break;
		case 25:
			pista1S.stop();
			pista1S.play();
			break;
		case 26:
			pista2S.stop();
			pista2S.play();
			break;
		case 27:
			santa1S.stop();
			santa1S.play();
			break;
		case 28:
			santa2S.stop();
			santa2S.play();
			break;
		}

	}

	@Override
	public void dispose() {
			intro1S.stop();
			
	        kalayaan1S.stop();
	        kalayaan2S.stop();
	        kalayaan3S.stop();
	        kalayaan4S.stop();
	        ama1S.stop();
	        ama2S.stop();
	        ama3S.stop();
	        ama4S.stop();
	        guro1S.stop();
	        guro2S.stop();
	        guro3S.stop();
	        guro4S.stop();
	        guro5S.stop();
	        ina1S.stop();
	        ina2S.stop();
	        ina3S.stop();
	        puso1S.stop();
	        puso2S.stop();
	        mahalNaAraw1S.stop();
	        mahalNaAraw2S.stop();
	        mahalNaAraw3S.stop();
	        pasko1S.stop();
	        pasko2S.stop();
	        pasko3S.stop();
	        pista1S.stop();
	        pista2S.stop();
	        santa1S.stop();
	        santa2S.stop();
		
	        intro1S.dispose();
	        kalayaan1S.dispose();
	        kalayaan2S.dispose();
	        kalayaan3S.dispose();
	        kalayaan4S.dispose();
	        ama1S.dispose();
	        ama2S.dispose();
	        ama3S.dispose();
	        ama4S.dispose();
	        guro1S.dispose();
	        guro2S.dispose();
	        guro3S.dispose();
	        guro4S.dispose();
	        guro5S.dispose();
	        ina1S.dispose();
	        ina2S.dispose();
	        ina3S.dispose();
	        puso1S.dispose();
	        puso2S.dispose();
	        mahalNaAraw1S.dispose();
	        mahalNaAraw2S.dispose();
	        mahalNaAraw3S.dispose();
	        pasko1S.dispose();
	        pasko2S.dispose();
	        pasko3S.dispose();
	        pista1S.dispose();
	        pista2S.dispose();
	        santa1S.dispose();
	        santa2S.dispose();
		
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
		
		//balloons
		introBalloon1.dispose();
		
		kalayaanBalloon1.dispose();
		kalayaanBalloon2.dispose();
		kalayaanBalloon3.dispose();
		kalayaanBalloon4.dispose();
		amaBalloon1.dispose();
		amaBalloon2.dispose();
		amaBalloon3.dispose();
		amaBalloon4.dispose();
		guroBalloon1.dispose();
		guroBalloon2.dispose();
		guroBalloon3.dispose();
		guroBalloon4.dispose();
		guroBalloon5.dispose();
		inaBalloon1.dispose();
		inaBalloon2.dispose();
		inaBalloon3.dispose();
		pusoBalloon1.dispose();
		pusoBalloon2.dispose();
		mahalNaArawBalloon1.dispose();
		mahalNaArawBalloon2.dispose();
		mahalNaArawBalloon3.dispose();
		paskoBalloon1.dispose();
		paskoBalloon2.dispose();
		paskoBalloon3.dispose();
		pistaBalloon1.dispose();
		pistaBalloon2.dispose();
		santacruzanBalloon1.dispose();
		santacruzanBalloon2.dispose();
        valentinesChar1.dispose();
        valentinesChar2.dispose();
        if (!isTeacher)
            ansMarkerTexture.dispose();
	}
}
