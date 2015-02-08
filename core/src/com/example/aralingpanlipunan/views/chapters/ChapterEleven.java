package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import static com.example.aralingpanlipunan.android.database.DatabaseSetup.CHAPTER_ELEVEN_SCORE;

public class ChapterEleven extends ChapterCore {
	private Texture introBg, kalayaanBg, amaBg, guroBg, inaBg, pusoBg, mahalNaArawBg,
			paskoBg, pistaBg, santacruzanBg, introBalloon1, introBalloon2,
			kalayaanBalloon1, kalayaanBalloon2, kalayaanBalloon3,
			kalayaanBalloon4, amaBalloon1, amaBalloon2, amaBalloon3,
			amaBalloon4, guroBalloon1, guroBalloon2, guroBalloon3,
			guroBalloon4, guroBalloon5, inaBalloon1, inaBalloon2, inaBalloon3,
			pusoBalloon1, pusoBalloon2, mahalNaArawBalloon1,
			mahalNaArawBalloon2, mahalNaArawBalloon3, paskoBalloon1,
			paskoBalloon2, paskoBalloon3, pistaBalloon1, pistaBalloon2,
            santacruzanBalloon1, santacruzanBalloon2, question1Bg, question2Bg,
            question3Bg, question4Bg, question5Bg, ansMarkerTexture;
    private Sprite ansMarker, ansMarker2, ansMarker3, ansMarker4, ansMarker5,
            ansMarker6, ansMarker7, ansMarker8;
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
        startOfQuestionSection = 31;
        lastChapterSection = 36;
        assetNeedUpdate = true;

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
		paskoBg = new Texture(
				"chapters/chapter11/backgrounds/Pasko.png");
		pistaBg = new Texture(
				"chapters/chapter11/backgrounds/Pista.png");
		santacruzanBg = new Texture(
				"chapters/chapter11/backgrounds/Santacruzan.png");

        // Question/game backgrounds
        if (isTeacher) {
            question1Bg = new Texture("chapters/chapter11/answerkeys/answer1.jpg");
            question2Bg = new Texture("chapters/chapter11/answerkeys/answer2.jpg");
            question3Bg = new Texture("chapters/chapter11/answerkeys/answer3.jpg");
            question4Bg = new Texture("chapters/chapter11/answerkeys/answer4.jpg");
            question5Bg = new Texture("chapters/chapter11/answerkeys/answer5.jpg");
            correctAnswers = 9;
        } else {
            question1Bg = new Texture("chapters/chapter11/backgrounds/question1.jpg");
            question2Bg = new Texture("chapters/chapter11/backgrounds/question2.jpg");
            question3Bg = new Texture("chapters/chapter11/backgrounds/question3.jpg");
            question4Bg = new Texture("chapters/chapter11/backgrounds/question4.jpg");
            question5Bg = new Texture("chapters/chapter11/backgrounds/question5.jpg");

            ansMarkerTexture = new Texture("box.png");
            ansMarker = new Sprite(ansMarkerTexture);
            ansMarker.setSize((ansMarker.getWidth() * getButtonScale()) * 1.156f, (ansMarker.getHeight() * getButtonScale()) / 3.397f);

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
		
		//balloons
		introBalloon1 = new Texture("chapters/chapter11/balloons/Intro.png");
		introBalloon2 = new Texture("chapters/chapter11/balloons/Intro.png");
		kalayaanBalloon1 = new Texture("chapters/chapter11/balloons/Kalayaan1.png");
		kalayaanBalloon2 = new Texture("chapters/chapter11/balloons/Kalayaan2.png");
		kalayaanBalloon3 = new Texture("chapters/chapter11/balloons/Kalayaan3.png");
		kalayaanBalloon4 = new Texture("chapters/chapter11/balloons/Kalayaan4.png");
		amaBalloon1 = new Texture("chapters/chapter11/balloons/ArawNgAma1.png");
		amaBalloon2 = new Texture("chapters/chapter11/balloons/ArawNgAma2.png");
		amaBalloon3 = new Texture("chapters/chapter11/balloons/ArawNgAma3.png");
		amaBalloon4 = new Texture("chapters/chapter11/balloons/ArawNgAma4.png");
		guroBalloon1 = new Texture("chapters/chapter11/balloons/ArawNgGuro1.png");
		guroBalloon2 = new Texture("chapters/chapter11/balloons/ArawNgGuro2.png");
		guroBalloon3 = new Texture("chapters/chapter11/balloons/ArawNgGuro3.png");
		guroBalloon4 = new Texture("chapters/chapter11/balloons/ArawNgGuro4.png");
		guroBalloon5 = new Texture("chapters/chapter11/balloons/ArawNgGuro5.png");
		inaBalloon1 = new Texture("chapters/chapter11/balloons/ArawNgIna1.png");
		inaBalloon2 = new Texture("chapters/chapter11/balloons/ArawNgIna2.png");
		inaBalloon3 = new Texture("chapters/chapter11/balloons/ArawNgIna3.png");
		pusoBalloon1 = new Texture("chapters/chapter11/balloons/ArawNgPuso1.png");
		pusoBalloon2 = new Texture("chapters/chapter11/balloons/ArawNgPuso2.png");
		mahalNaArawBalloon1 = new Texture("chapters/chapter11/balloons/MahalNaAraw1.png");
		mahalNaArawBalloon2 = new Texture("chapters/chapter11/balloons/MahalNaAraw2.png");
		mahalNaArawBalloon3 = new Texture("chapters/chapter11/balloons/MahalNaAraw3.png");
		paskoBalloon1 = new Texture("chapters/chapter11/balloons/Pasko1.png");
		paskoBalloon2 = new Texture("chapters/chapter11/balloons/Pasko2.png");
		paskoBalloon3 = new Texture("chapters/chapter11/balloons/Pasko3.png");
		pistaBalloon1 = new Texture("chapters/chapter11/balloons/Pista1.png");
		pistaBalloon2 = new Texture("chapters/chapter11/balloons/Pista2.png");
		santacruzanBalloon1 = new Texture("chapters/chapter11/balloons/Santacruzan1.png");
		santacruzanBalloon2 = new Texture("chapters/chapter11/balloons/Santacruzan2.png");
	}

	@Override
	public void display(Batch batch) {
		if (assetNeedUpdate)
			assetManager();
		renderSharedAssets(batch);

        if (!isTeacher && chapterSection >= startOfQuestionSection && chapterSection < lastChapterSection) {
            ansMarker.draw(batch);
            ansMarker2.draw(batch);
            ansMarker3.draw(batch);
            ansMarker4.draw(batch);
            ansMarker5.draw(batch);
            ansMarker6.draw(batch);
            ansMarker7.draw(batch);
            ansMarker8.draw(batch);
        }

        if (!isTeacher && next != null && chapterSection >= startOfQuestionSection && chapterSection < lastChapterSection)
            next.draw(batch);

        if (chapterSection == lastChapterSection) {
            question.drawMultiLine(batch, tanong, questionX, questionY);
            startQuiz.draw(batch);
            backToChapters.draw(batch);
        }
	}

	private void assetManager() {
        float ansX, ansY, ans2Y, ans3Y, ans4Y, ans5Y, ans6Y, ans7Y, ans8Y;
		switch (chapterSection) {
		case 0:
			backgroundSprite.setTexture(introBg);
			balloonSprite.setTexture(introBalloon1);
			break;
		case 1:
			backgroundSprite.setTexture(introBg);
			balloonSprite.setTexture(introBalloon2);
			break;
		case 2:
			backgroundSprite.setTexture(kalayaanBg);
			balloonSprite.setTexture(kalayaanBalloon1);
			break;
		case 3:
			balloonSprite.setTexture(kalayaanBalloon2);
			break;
		case 4: 
			balloonSprite.setTexture(kalayaanBalloon2);
			break;
		case 5:
			balloonSprite.setTexture(kalayaanBalloon3);
			break;
		case 6:
			balloonSprite.setTexture(kalayaanBalloon4);
			break;
		case 7:
			backgroundSprite.setTexture(amaBg);
			balloonSprite.setTexture(amaBalloon1);
			break;
		case 8:
			balloonSprite.setTexture(amaBalloon2);
			break;
		case 9:
			balloonSprite.setTexture(amaBalloon3);
			break;
		case 10:
			balloonSprite.setTexture(amaBalloon4);
			break;
		case 11:
			backgroundSprite.setTexture(guroBg);
			balloonSprite.setTexture(guroBalloon2);
			break;
		case 12:
			balloonSprite.setTexture(guroBalloon2);
			break;
		case 13:
			balloonSprite.setTexture(guroBalloon3);
			break;
		case 14:
			balloonSprite.setTexture(guroBalloon4);
			break;
		case 15:
			balloonSprite.setTexture(guroBalloon5);
			break;
		case 16: 
			backgroundSprite.setTexture(inaBg);
			balloonSprite.setTexture(inaBalloon1);
			break;
		case 17:
			balloonSprite.setTexture(inaBalloon2);
			break;
		case 18:
			balloonSprite.setTexture(inaBalloon3);
			break;
		case 19:
			backgroundSprite.setTexture(pusoBg);
			balloonSprite.setTexture(pusoBalloon1);
			break;
		case 20:
			balloonSprite.setTexture(pusoBalloon2);
			break;
		case 21:
			backgroundSprite.setTexture(mahalNaArawBg);
			balloonSprite.setTexture(mahalNaArawBalloon1);
			break;
		case 22:
			balloonSprite.setTexture(mahalNaArawBalloon2);
			break;
		case 23:
			balloonSprite.setTexture(mahalNaArawBalloon3);
			break;
		case 24:
			backgroundSprite.setTexture(paskoBg);
			balloonSprite.setTexture(paskoBalloon1);
			break;
		case 25:
			balloonSprite.setTexture(paskoBalloon2);
			break;
		case 26:
			balloonSprite.setTexture(paskoBalloon3);
			break;
		case 27:
			backgroundSprite.setTexture(pistaBg);
			balloonSprite.setTexture(pistaBalloon1);
			break;
		case 28:
			balloonSprite.setTexture(pistaBalloon2);
			break;
		case 29:
			backgroundSprite.setTexture(santacruzanBg);
			balloonSprite.setTexture(santacruzanBalloon1);
			break;
		case 30:
			balloonSprite.setTexture(santacruzanBalloon2);
			break;
        case 31: // Start of game section
            if (!isTeacher) {
                correctAnswers = 0;
                ans1Correct = ans2Correct = false;

                ansX = screenWidth / 1.7f;
                ansY = screenHeight / 1.4f;
                ansMarker.setPosition(ansX, ansY);
                ansMarker.setBounds(ansX, ansY, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker.setAlpha(0);

                ans2Y = screenHeight / 1.51f;
                ansMarker2.setPosition(ansX, ans2Y);
                ansMarker2.setBounds(ansX, ans2Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker2.setAlpha(0);

                ans3Y = screenHeight / 1.62f;
                ansMarker3.setPosition(ansX, ans3Y);
                ansMarker3.setBounds(ansX, ans3Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker3.setAlpha(0);

                ans4Y = screenHeight / 1.75f;
                ansMarker4.setPosition(ansX, ans4Y);
                ansMarker4.setBounds(ansX, ans4Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker4.setAlpha(0);

                ans5Y = screenHeight / 2.4f;
                ansMarker5.setPosition(ansX, ans5Y);
                ansMarker5.setBounds(ansX, ans5Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker5.setAlpha(0);

                ans6Y = screenHeight / 2.615f;
                ansMarker6.setPosition(ansX, ans6Y);
                ansMarker6.setBounds(ansX, ans6Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker6.setAlpha(0);

                ans7Y = screenHeight / 3.1f;
                ansMarker7.setPosition(ansX, ans7Y);
                ansMarker7.setBounds(ansX, ans7Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker7.setAlpha(0);

                ans8Y = screenHeight / 3.6f;
                ansMarker8.setPosition(ansX, ans8Y);
                ansMarker8.setBounds(ansX, ans8Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker8.setAlpha(0);
            }

            backgroundSprite.setTexture(question1Bg);
            break;
        case 32:
            if (!isTeacher) {
                if (ans1Correct) correctAnswers++;
                if (ans2Correct) correctAnswers++;
                ans1Correct = ans2Correct = false;

                ansX = screenWidth / 1.59f;
                ansY = screenHeight / 1.26f;
                ansMarker.setPosition(ansX, ansY);
                ansMarker.setBounds(ansX, ansY, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker.setAlpha(0);

                ans2Y = screenHeight / 1.34f;
                ansMarker2.setPosition(ansX, ans2Y);
                ansMarker2.setBounds(ansX, ans2Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker2.setAlpha(0);

                ans3Y = screenHeight / 1.45f;
                ansMarker3.setPosition(ansX, ans3Y);
                ansMarker3.setBounds(ansX, ans3Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker3.setAlpha(0);

                ans4Y = screenHeight / 1.56f; //1.75
                ansMarker4.setPosition(ansX, ans4Y);
                ansMarker4.setBounds(ansX, ans4Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker4.setAlpha(0);

                ans5Y = screenHeight / 2.2f;
                ansMarker5.setPosition(ansX, ans5Y);
                ansMarker5.setBounds(ansX, ans5Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker5.setAlpha(0);

                ans6Y = screenHeight / 2.415f;
                ansMarker6.setPosition(ansX, ans6Y);
                ansMarker6.setBounds(ansX, ans6Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker6.setAlpha(0);

                ans7Y = screenHeight / 2.86f;
                ansMarker7.setPosition(ansX, ans7Y);
                ansMarker7.setBounds(ansX, ans7Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker7.setAlpha(0);

                ans8Y = screenHeight / 3.36f;
                ansMarker8.setPosition(ansX, ans8Y);
                ansMarker8.setBounds(ansX, ans8Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker8.setAlpha(0);
            }

            backgroundSprite.setTexture(question2Bg);
            break;
        case 33:
            if (!isTeacher) {
                if (ans1Correct) correctAnswers++;
                if (ans2Correct) correctAnswers++;
                ans1Correct = ans2Correct = false;

                ansX = screenWidth / 1.58f;
                ansY = screenHeight / 1.31f;
                ansMarker.setPosition(ansX, ansY);
                ansMarker.setBounds(ansX, ansY, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker.setAlpha(0);

                ans2Y = screenHeight / 1.42f;
                ansMarker2.setPosition(ansX, ans2Y);
                ansMarker2.setBounds(ansX, ans2Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker2.setAlpha(0);

                ans3Y = screenHeight / 1.53f;
                ansMarker3.setPosition(ansX, ans3Y);
                ansMarker3.setBounds(ansX, ans3Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker3.setAlpha(0);

                ans4Y = screenHeight / 1.64f;
                ansMarker4.setPosition(ansX, ans4Y);
                ansMarker4.setBounds(ansX, ans4Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker4.setAlpha(0);

                ans5Y = screenHeight / 2.09f;
                ansMarker5.setPosition(ansX, ans5Y);
                ansMarker5.setBounds(ansX, ans5Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker5.setAlpha(0);

                ans6Y = screenHeight / 2.41f;
                ansMarker6.setPosition(ansX, ans6Y);
                ansMarker6.setBounds(ansX, ans6Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker6.setAlpha(0);

                ans7Y = screenHeight / 2.62f;
                ansMarker7.setPosition(ansX, ans7Y);
                ansMarker7.setBounds(ansX, ans7Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker7.setAlpha(0);

                ans8Y = screenHeight / 3;
                ansMarker8.setPosition(ansX, ans8Y);
                ansMarker8.setBounds(ansX, ans8Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker8.setAlpha(0);
            }

            backgroundSprite.setTexture(question3Bg);
            break;
        case 34:
            if (!isTeacher) {
                if (ans1Correct) correctAnswers++;
                if (ans2Correct) correctAnswers++;
                ans1Correct = ans2Correct = false;

                ansX = screenWidth / 1.59f;
                ansY = screenHeight / 1.31f;
                ansMarker.setPosition(ansX, ansY);
                ansMarker.setBounds(ansX, ansY, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker.setAlpha(0);

                ans2Y = screenHeight / 1.42f;
                ansMarker2.setPosition(ansX, ans2Y);
                ansMarker2.setBounds(ansX, ans2Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker2.setAlpha(0);

                ans3Y = screenHeight / 1.53f;
                ansMarker3.setPosition(ansX, ans3Y);
                ansMarker3.setBounds(ansX, ans3Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker3.setAlpha(0);

                ans4Y = screenHeight / 1.64f;
                ansMarker4.setPosition(ansX, ans4Y);
                ansMarker4.setBounds(ansX, ans4Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker4.setAlpha(0);

                ans5Y = screenHeight / 2.4075f;
                ansMarker5.setPosition(ansX, ans5Y);
                ansMarker5.setBounds(ansX, ans5Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker5.setAlpha(0);

                ans6Y = screenHeight / 2.624f;
                ansMarker6.setPosition(ansX, ans6Y);
                ansMarker6.setBounds(ansX, ans6Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker6.setAlpha(0);

                ans7Y = screenHeight / 3.08f;
                ansMarker7.setPosition(ansX, ans7Y);
                ansMarker7.setBounds(ansX, ans7Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker7.setAlpha(0);

                ans8Y = screenHeight / 3.7f;
                ansMarker8.setPosition(ansX, ans8Y);
                ansMarker8.setBounds(ansX, ans8Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker8.setAlpha(0);
            }

            backgroundSprite.setTexture(question4Bg);
            break;
        case 35:
            if (!isTeacher) {
                if (ans1Correct) correctAnswers++;
                if (ans2Correct) correctAnswers++;
                ans1Correct = ans2Correct = false;

                ansX = screenWidth / 1.5f;
                ansY = screenHeight / 1.59f;
                ansMarker.setPosition(ansX, ansY);
                ansMarker.setBounds(ansX, ansY, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker.setAlpha(0);

                ans2Y = screenHeight / 1.7f;
                ansMarker2.setPosition(ansX, ans2Y);
                ansMarker2.setBounds(ansX, ans2Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker2.setAlpha(0);

                ans3Y = screenHeight / 1.855f;
                ansMarker3.setPosition(ansX, ans3Y);
                ansMarker3.setBounds(ansX, ans3Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker3.setAlpha(0);

                ans4Y = screenHeight / 2.08f;
                ansMarker4.setPosition(ansX, ans4Y);
                ansMarker4.setBounds(ansX, ans4Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker4.setAlpha(0);

                ans5Y = screenHeight / 2.09f;
                ansMarker5.setPosition(ansX, ans5Y);
                ansMarker5.setBounds(ansX, ans5Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker5.setAlpha(0);

                ans6Y = screenHeight / 2.41f;
                ansMarker6.setPosition(ansX, ans6Y);
                ansMarker6.setBounds(ansX, ans6Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker6.setAlpha(0);

                ans7Y = screenHeight / 2.62f;
                ansMarker7.setPosition(ansX, ans7Y);
                ansMarker7.setBounds(ansX, ans7Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker7.setAlpha(0);

                ans8Y = screenHeight / 3;
                ansMarker8.setPosition(ansX, ans8Y);
                ansMarker8.setBounds(ansX, ans8Y, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker8.setAlpha(0);
            }

            backgroundSprite.setTexture(question5Bg);
            break;
        case 36:
            displayQuizResult(CHAPTER_ELEVEN_SCORE, 5);
            break;
        }
        assetNeedUpdate = false;
	}

    @Override
    public int touchDown(float x, float y) {
        if (!isTeacher && chapterSection >= startOfQuestionSection && chapterSection < lastChapterSection) {
            if (ansMarker.getBoundingRectangle().contains(x, y)) {
                ansMarker.setAlpha(1);
                ansMarker2.setAlpha(0);
                ansMarker3.setAlpha(0);
                ansMarker4.setAlpha(0);
                // answer a is correct only for chapSection 33 / question 5
                ans1Correct = chapterSection == 33;
            } else if (ansMarker2.getBoundingRectangle().contains(x, y)) {
                ansMarker.setAlpha(0);
                ansMarker2.setAlpha(1);
                ansMarker3.setAlpha(0);
                ansMarker4.setAlpha(0);
                // answer b is correct only for chapSection 31 / question 1
                ans1Correct = chapterSection == 31;
            } else if (ansMarker3.getBoundingRectangle().contains(x, y)) {
                ansMarker.setAlpha(0);
                ansMarker2.setAlpha(0);
                ansMarker3.setAlpha(1);
                ansMarker4.setAlpha(0);
                // answer c is correct only for chapSection 32 & 34 / question 3 & 7
                ans1Correct = chapterSection == 32 || chapterSection == 34;
            } else if (ansMarker4.getBoundingRectangle().contains(x, y)) {
                ansMarker.setAlpha(0);
                ansMarker2.setAlpha(0);
                ansMarker3.setAlpha(0);
                ansMarker4.setAlpha(1);
                ans1Correct = false; // This is never a correct answer
            }

            if (chapterSection != 35) {
                if (ansMarker5.getBoundingRectangle().contains(x, y)) {
                    ansMarker5.setAlpha(1);
                    ansMarker6.setAlpha(0);
                    ansMarker7.setAlpha(0);
                    ansMarker8.setAlpha(0);
                    ans2Correct = chapterSection == 31 || chapterSection == 34;
                } else if (ansMarker6.getBoundingRectangle().contains(x, y)) {
                    ansMarker5.setAlpha(0);
                    ansMarker6.setAlpha(1);
                    ansMarker7.setAlpha(0);
                    ansMarker8.setAlpha(0);
                    ans2Correct = chapterSection == 32 || chapterSection == 33;
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

	@Override
	public void dispose() {
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
		introBalloon2.dispose();
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
        if (!isTeacher)
            ansMarkerTexture.dispose();
	}
}
