package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import static com.example.aralingpanlipunan.android.database.DatabaseSetup.CHAPTER_FOURTEEN_SCORE;

public class ChapterFourteen extends ChapterCore {

	private Texture introBg, lupaBg1, lupaBg2, lupaBg3, tubigBg1, tubigBg2, tubigBg3,
			introBalloon1, introBalloon2, bukalBalloon1, bukalBalloon2,
			bulkanBalloon1, bulkanBalloon2, bundokBalloon1, bundokBalloon2,
			burolBalloon1, burolBalloon2, burolBalloon3, dagatBalloon1,
			dagatBalloon2, ilogBalloon1, ilogBalloon2, ilogBalloon3,
			kapataganBalloon1, kapataganBalloon2, karagatanBalloon1,
			karagatanBalloon2, lambakBalloon1, lambakBalloon2, lawaBalloon1,
			lawaBalloon2, talampasBalloon1, talampasBalloon2, talonBalloon1,
			talonBalloon2, question1Bg, question2Bg, question3Bg, ansMarkerTexture;
    private Sprite ans1A, ans1B, ans2A, ans2B;
    private boolean ans1Correct, ans2Correct;

	public ChapterFourteen(AndroidInterface androidInterface, boolean isTeacher) {
		super(androidInterface, isTeacher);
	}

	public ChapterFourteen(AndroidInterface androidInterface, String studentName) {
		super(androidInterface, studentName);
	}

	@Override
	public void setUp(int screenW, int screenH) {
		super.setUp(screenW, screenH);
		startOfQuestionSection = 28;
		lastChapterSection = 31;

		// backgrounds

		introBg = new Texture(
				"chapters/chapter14/backgrounds/IntroForChapter14.png");
		lupaBg1 = new Texture("chapters/chapter14/backgrounds/Lupa1.png");
		lupaBg2 = new Texture("chapters/chapter14/backgrounds/Lupa2.png");
		lupaBg3 = new Texture("chapters/chapter14/backgrounds/Lupa3.png");
		tubigBg1 = new Texture("chapters/chapter14/backgrounds/Tubig1.png");
		tubigBg2 = new Texture("chapters/chapter14/backgrounds/Tubig2.png");
		tubigBg3 = new Texture("chapters/chapter14/backgrounds/Tubig3.png");

		// Question/game backgrounds
		if (isTeacher) {
			question1Bg = new Texture(
					"chapters/chapter14/answerkeys/answer1.jpg");
			question2Bg = new Texture(
					"chapters/chapter14/answerkeys/answer2.jpg");
			question3Bg = new Texture(
					"chapters/chapter14/answerkeys/answer3.jpg");

		} else {
			question1Bg = new Texture(
					"chapters/chapter14/backgrounds/question1.jpg");
			question2Bg = new Texture(
					"chapters/chapter14/backgrounds/question2.jpg");
			question3Bg = new Texture(
					"chapters/chapter14/backgrounds/question3.jpg");

            ansMarkerTexture = new Texture("box.png");
            ans1A = new Sprite(ansMarkerTexture);
            ans1A.setSize((ans1A.getWidth() * getButtonScale()) / 1.1f, (ans1A.getHeight() * getButtonScale()) / 3.397f);

            ans1B = new Sprite(ansMarkerTexture);
            ans1B.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans2A = new Sprite(ansMarkerTexture);
            ans2A.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans2B = new Sprite(ansMarkerTexture);
            ans2B.setSize(ans1A.getWidth(), ans1A.getHeight());

            loadNextButton();
		}

		// balloons
		introBalloon1 = new Texture("chapters/chapter14/balloons/Intro1.png");
		introBalloon2 = new Texture("chapters/chapter14/balloons/Intro2.png");
		bukalBalloon1 = new Texture("chapters/chapter14/balloons/Bukal1.png");
		bukalBalloon2 = new Texture("chapters/chapter14/balloons/Bukal2.png");
		bulkanBalloon1 = new Texture("chapters/chapter14/balloons/Bulkan1.png");
		bulkanBalloon2 = new Texture("chapters/chapter14/balloons/Bulkan2.png");
		bundokBalloon1 = new Texture("chapters/chapter14/balloons/Bundok1.png");
		bundokBalloon2 = new Texture("chapters/chapter14/balloons/Bundok2.png");
		burolBalloon1 = new Texture("chapters/chapter14/balloons/Burol1.png");
		burolBalloon2 = new Texture("chapters/chapter14/balloons/Burol2.png");
		burolBalloon3 = new Texture("chapters/chapter14/balloons/Burol3.png");
		dagatBalloon1 = new Texture("chapters/chapter14/balloons/Dagat1.png");
		dagatBalloon2 = new Texture("chapters/chapter14/balloons/Dagat2.png");
		ilogBalloon1 = new Texture("chapters/chapter14/balloons/Ilog1.png");
		ilogBalloon2 = new Texture("chapters/chapter14/balloons/Ilog2.png");
		ilogBalloon3 = new Texture("chapters/chapter14/balloons/Ilog3.png");
		kapataganBalloon1 = new Texture(
				"chapters/chapter14/balloons/Kapatagan1.png");
		kapataganBalloon2 = new Texture(
				"chapters/chapter14/balloons/Kapatagan2.png");
		karagatanBalloon1 = new Texture(
				"chapters/chapter14/balloons/karagatan1.png");
		karagatanBalloon2 = new Texture(
				"chapters/chapter14/balloons/karagatan2.png");
		lambakBalloon1 = new Texture("chapters/chapter14/balloons/Lambak1.png");
		lambakBalloon2 = new Texture("chapters/chapter14/balloons/Lambak2.png");
		lawaBalloon1 = new Texture("chapters/chapter14/balloons/Lawa1.png");
		lawaBalloon2 = new Texture("chapters/chapter14/balloons/Lawa2.png");
		talampasBalloon1 = new Texture(
				"chapters/chapter14/balloons/Talampas1.png");
		talampasBalloon2 = new Texture(
				"chapters/chapter14/balloons/Talampas2.png");
		talonBalloon1 = new Texture("chapters/chapter14/balloons/Talon1.png");
		talonBalloon2 = new Texture("chapters/chapter14/balloons/Talon2.png");

	}

	@Override
	public void display(Batch batch) {
		if (assetNeedUpdate)
			assetManager();
		renderSharedAssets(batch);

        if (!isTeacher && chapterSection >= startOfQuestionSection && chapterSection < lastChapterSection) {
            ans1A.draw(batch);
            ans1B.draw(batch);
            ans2A.draw(batch);
            ans2B.draw(batch);
            next.draw(batch);
        }

        drawQuizResult(batch);
	}

	private void assetManager() {
        float ansXPos, row1, row2, row3, row4;
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
			backgroundSprite.setTexture(lupaBg1);
			balloonSprite.setTexture(kapataganBalloon1);
			break;
		case 3:
			balloonSprite.setTexture(kapataganBalloon2);
			break;
		case 4:
			balloonSprite.setTexture(bundokBalloon1);
			break;
		case 5:
			balloonSprite.setTexture(bundokBalloon2);
			break;
		case 6:
			backgroundSprite.setTexture(lupaBg2);
			balloonSprite.setTexture(burolBalloon1);
			break;
		case 7:
			balloonSprite.setTexture(burolBalloon2);
			break;
		case 8:
			balloonSprite.setTexture(burolBalloon3);
			break;
		case 9:
			balloonSprite.setTexture(talampasBalloon1);
			break;
		case 10:
			balloonSprite.setTexture(talampasBalloon2);
			break;
		case 11:
			backgroundSprite.setTexture(lupaBg3);
			balloonSprite.setTexture(lambakBalloon1);
			break;
		case 12:
			balloonSprite.setTexture(lambakBalloon2);
			break;
		case 13:
			balloonSprite.setTexture(bulkanBalloon1);
			break;
		case 14:
			balloonSprite.setTexture(bulkanBalloon2);
			break;
		case 15:
			backgroundSprite.setTexture(tubigBg1);
			balloonSprite.setTexture(karagatanBalloon1);
			break;
		case 16:
			balloonSprite.setTexture(karagatanBalloon2);
			break;
		case 17:
			balloonSprite.setTexture(dagatBalloon1);
			break;
		case 18:
			balloonSprite.setTexture(dagatBalloon2);
			break;
		case 19:
			backgroundSprite.setTexture(tubigBg2);
			balloonSprite.setTexture(ilogBalloon1);
			break;
		case 20:
			balloonSprite.setTexture(ilogBalloon2);
			break;
		case 21:
			balloonSprite.setTexture(ilogBalloon3);
			break;
		case 22:
			balloonSprite.setTexture(talonBalloon1);
			break;
		case 23:
			balloonSprite.setTexture(talonBalloon2);
			break;
		case 24:
			backgroundSprite.setTexture(tubigBg3);
			balloonSprite.setTexture(lawaBalloon1);
			break;
		case 25:
			balloonSprite.setTexture(lawaBalloon2);
			break;
		case 26:
			balloonSprite.setTexture(bukalBalloon1);
			break;
		case 27:
			balloonSprite.setTexture(bukalBalloon2);
			break;
        case 28: // Start of game
            backgroundSprite.setTexture(question1Bg);
            if (!isTeacher) {
                ans1Correct = ans2Correct = false;
                ansXPos = screenWidth / 1.615f;
                row1 = screenHeight / 1.69f;
                row2 = screenHeight / 1.88f;
                row3 = screenHeight / 2.9f;
                row4 = screenHeight / 3.27f;

                ans1A.setPosition(ansXPos, row1);
                ans1A.setBounds(ansXPos, row1, ans1A.getWidth(), ans1A.getHeight());
                ans1A.setAlpha(0);

                ans1B.setPosition(ansXPos, row2);
                ans1B.setBounds(ansXPos, row2, ans1B.getWidth(), ans1B.getHeight());
                ans1B.setAlpha(0);

                ans2A.setPosition(ansXPos, row3);
                ans2A.setBounds(ansXPos, row3, ans2A.getWidth(), ans2A.getHeight());
                ans2A.setAlpha(0);

                ans2B.setPosition(ansXPos, row4);
                ans2B.setBounds(ansXPos, row4, ans2B.getWidth(), ans2B.getHeight());
                ans2B.setAlpha(0);
            }
            break;
        case 29:
            backgroundSprite.setTexture(question2Bg);
            if (!isTeacher) {
                if (ans1Correct) correctAnswers++;
                if (ans2Correct) correctAnswers++;
                ans1Correct = ans2Correct = false;

                ansXPos = screenWidth / 1.5f;
                row1 = screenHeight / 1.5f;
                row2 = screenHeight / 1.62f;
                row3 = screenHeight / 2.82f;
                row4 = screenHeight / 3.25f;

                ans1A.setPosition(ansXPos, row1);
                ans1A.setBounds(ansXPos, row1, ans1A.getWidth(), ans1A.getHeight());
                ans1A.setAlpha(0);

                ans1B.setPosition(ansXPos, row2);
                ans1B.setBounds(ansXPos, row2, ans1B.getWidth(), ans1B.getHeight());
                ans1B.setAlpha(0);

                ans2A.setPosition(ansXPos, row3);
                ans2A.setBounds(ansXPos, row3, ans2A.getWidth(), ans2A.getHeight());
                ans2A.setAlpha(0);

                ans2B.setPosition(ansXPos, row4);
                ans2B.setBounds(ansXPos, row4, ans2B.getWidth(), ans2B.getHeight());
                ans2B.setAlpha(0);
            }
            break;
        case 30:
            backgroundSprite.setTexture(question3Bg);
            if (!isTeacher) {
                if (ans1Correct) correctAnswers++;
                if (ans2Correct) correctAnswers++;
                ans1Correct = ans2Correct = false;

                ansXPos = screenWidth / 1.46f;
                row1 = screenHeight / 1.5f;
                row2 = screenHeight / 1.62f;
                row3 = screenHeight / 2.905f;
                row4 = screenHeight / 3.357f;

                ans1A.setPosition(ansXPos, row1);
                ans1A.setBounds(ansXPos, row1, ans1A.getWidth(), ans1A.getHeight());
                ans1A.setAlpha(0);

                ans1B.setPosition(ansXPos, row2);
                ans1B.setBounds(ansXPos, row2, ans1B.getWidth(), ans1B.getHeight());
                ans1B.setAlpha(0);

                ans2A.setPosition(ansXPos, row3);
                ans2A.setBounds(ansXPos, row3, ans2A.getWidth(), ans2A.getHeight());
                ans2A.setAlpha(0);

                ans2B.setPosition(ansXPos, row4);
                ans2B.setBounds(ansXPos, row4, ans2B.getWidth(), ans2B.getHeight());
                ans2B.setAlpha(0);
            }
            break;
        case 31:
            if (isTeacher) {
                correctAnswers = 6;
            } else {
                if (ans1Correct) correctAnswers++;
                if (ans2Correct) correctAnswers++;
            }

            displayQuizResult(CHAPTER_FOURTEEN_SCORE, 3);
            break;
		}
        assetNeedUpdate = false;
	}

    @Override
    public int touchDown(float x, float y) {
        switch (chapterSection) {
            case 28:
                if (!isTeacher) {
                    if (ans1A.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(1);
                        ans1B.setAlpha(0);
                        ans1Correct = true;
                    } else if (ans1B.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(1);
                        ans1Correct = false;
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
                }
                break;
            case 29:
                if (!isTeacher) {
                    if (ans1A.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(1);
                        ans1B.setAlpha(0);
                        ans1Correct = true;
                    } else if (ans1B.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(1);
                        ans1Correct = false;
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
                }
                break;
            case 30:
                if (!isTeacher) {
                    if (ans1A.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(1);
                        ans1B.setAlpha(0);
                        ans1Correct = true;
                    } else if (ans1B.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(1);
                        ans1Correct = false;
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
                }
                break;
            case 31:
                return displayLastSectionButtons(14, 3, x, y);
        }
        return super.touchDown(x, y);
    }

    @Override
	public void dispose() {
        super.dispose();
		introBg.dispose();
		lupaBg1.dispose();
		lupaBg2.dispose();
		lupaBg3.dispose();
		tubigBg1.dispose();
		tubigBg2.dispose();
		tubigBg3.dispose();
        question1Bg.dispose();
        question2Bg.dispose();
        question3Bg.dispose();

		// balloons
		introBalloon1.dispose();
		introBalloon2.dispose();
		bukalBalloon1.dispose();
		bukalBalloon2.dispose();
		bulkanBalloon1.dispose();
		bulkanBalloon2.dispose();
		bundokBalloon1.dispose();
		bundokBalloon2.dispose();
		burolBalloon1.dispose();
		burolBalloon2.dispose();
		burolBalloon3.dispose();
		dagatBalloon1.dispose();
		dagatBalloon2.dispose();
		ilogBalloon1.dispose();
		ilogBalloon2.dispose();
		ilogBalloon3.dispose();
		kapataganBalloon1.dispose();
		kapataganBalloon2.dispose();
		karagatanBalloon1.dispose();
		karagatanBalloon2.dispose();
		lambakBalloon1.dispose();
		lambakBalloon2.dispose();
		lawaBalloon1.dispose();
		lawaBalloon2.dispose();
		talampasBalloon1.dispose();
		talampasBalloon2.dispose();
		talonBalloon1.dispose();
		talonBalloon2.dispose();
        if (!isTeacher) ansMarkerTexture.dispose();
	}
}
