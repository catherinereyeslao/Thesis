package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import static com.example.aralingpanlipunan.android.database.DatabaseSetup.CHAPTER_THIRTEEN_SCORE;

public class ChapterThirteen extends ChapterCore {
	private Texture introBg, bonifacioBg, watawatBg, aguinaldoBg, rizalBg, lapuBg,
			simboloBg, aquinoBg, introBalloon1, introBalloon2,
			bonifacioBalloon1, bonifacioBalloon2, bonifacioBalloon3,
			watawatBalloon1, watawatBalloon2, watawatBalloon3,
			aguinaldoBalloon1, aguinaldoBalloon2, aguinaldoBalloon3,
			rizalBalloon1, rizalBalloon2, rizalBalloon3, rizalBalloon4,
			lapuBalloon1, lapuBalloon2, lapuBalloon3, lapuBalloon4,
			simboloBalloon1, simboloBalloon2, aquinoBalloon1, aquinoBalloon2,
			aquinoBalloon3, question1Bg, question2Bg, question3Bg, ansMarkerTexture;
    private Sprite ans1A, ans1B, ans1C, ans1D, ans1E, ans2A, ans2B, ans2C, ans2D, ans2E;
    private boolean ans1Correct, ans2Correct;

	public ChapterThirteen(AndroidInterface androidInterface, String studentName) {
		super(androidInterface, studentName);
	}

	public ChapterThirteen(AndroidInterface androidInterface, boolean isTeacher) {
		super(androidInterface, isTeacher);
	}

	@Override
	public void setUp(int screenW, int screenH) {
		super.setUp(screenW, screenH);
		startOfQuestionSection = 22;
		lastChapterSection = 25;
		assetNeedUpdate = true;

		// backgrounds
		introBg = new Texture(
				"chapters/chapter13/backgrounds/BackgroundIntro.png");
		bonifacioBg = new Texture(
				"chapters/chapter13/backgrounds/AndresBonifacio.png");
		watawatBg = new Texture("chapters/chapter13/backgrounds/AngWatawat.png");
		aguinaldoBg = new Texture(
				"chapters/chapter13/backgrounds/EmilioAguinaldo.png");
		rizalBg = new Texture("chapters/chapter13/backgrounds/JoseRizal.png");
		lapuBg = new Texture("chapters/chapter13/backgrounds/LapuLapu.png");
		simboloBg = new Texture("chapters/chapter13/backgrounds/MgaSimbolo.png");
		aquinoBg = new Texture("chapters/chapter13/backgrounds/NinoyAquino.png");
		if (isTeacher) {
			question1Bg = new Texture(
					"chapters/chapter13/answerkeys/answer1.jpg");
			question2Bg = new Texture(
					"chapters/chapter13/answerkeys/answer2.jpg");
			question3Bg = new Texture(
					"chapters/chapter13/answerkeys/answer3.jpg");

			correctAnswers = 5;
		} else {
			question1Bg = new Texture(
					"chapters/chapter13/backgrounds/question1.jpg");
			question2Bg = new Texture(
					"chapters/chapter13/backgrounds/question2.jpg");
			question3Bg = new Texture(
					"chapters/chapter13/backgrounds/question3.jpg");

            ansMarkerTexture = new Texture("box.png");
            ans1A = new Sprite(ansMarkerTexture);
            ans1A.setSize((ans1A.getWidth() * getButtonScale()) * 1.18f, (ans1A.getHeight() * getButtonScale()) / 3.397f);

            ans1B = new Sprite(ansMarkerTexture);
            ans1B.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans1C = new Sprite(ansMarkerTexture);
            ans1C.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans1D = new Sprite(ansMarkerTexture);
            ans1D.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans1E = new Sprite(ansMarkerTexture);
            ans1E.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans2A = new Sprite(ansMarkerTexture);
            ans2A.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans2B = new Sprite(ansMarkerTexture);
            ans2B.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans2C = new Sprite(ansMarkerTexture);
            ans2C.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans2D = new Sprite(ansMarkerTexture);
            ans2D.setSize(ans1A.getWidth(), ans1A.getHeight());

            ans2E = new Sprite(ansMarkerTexture);
            ans2E.setSize(ans1A.getWidth(), ans1A.getHeight());

            loadNextButton();
		}
		// balloons
		introBalloon1 = new Texture("chapters/chapter13/balloons/Intro1.png");
		introBalloon2 = new Texture("chapters/chapter13/balloons/Intro2.png");
		bonifacioBalloon1 = new Texture(
				"chapters/chapter13/balloons/Bonifacio1.png");
		bonifacioBalloon2 = new Texture(
				"chapters/chapter13/balloons/Bonifacio2.png");
		bonifacioBalloon3 = new Texture(
				"chapters/chapter13/balloons/Bonifacio3.png");
		watawatBalloon1 = new Texture(
				"chapters/chapter13/balloons/Watawat1.png");
		watawatBalloon2 = new Texture("chapters/chapter13/balloons/Watawat2.png");
		watawatBalloon3 = new Texture(
				"chapters/chapter13/balloons/Watawat3.png");
		aguinaldoBalloon1 = new Texture(
				"chapters/chapter13/balloons/EmilioAguinaldo1.png");
		aguinaldoBalloon2 = new Texture(
				"chapters/chapter13/balloons/EmilioAguinaldo2.png");
		aguinaldoBalloon3 = new Texture(
				"chapters/chapter13/balloons/EmilioAguinaldo3.png");
		rizalBalloon1 = new Texture(
				"chapters/chapter13/balloons/JoseRizal1.png");
		rizalBalloon2 = new Texture(
				"chapters/chapter13/balloons/JoseRizal2.png");
		rizalBalloon3 = new Texture(
				"chapters/chapter13/balloons/JoseRizal3.png");
		rizalBalloon4 = new Texture(
				"chapters/chapter13/balloons/JoseRizal4.png");
		lapuBalloon1 = new Texture("chapters/chapter13/balloons/Lapu-Lapu1.png");
		lapuBalloon2 = new Texture("chapters/chapter13/balloons/Lapu-Lapu2.png");
		lapuBalloon3 = new Texture("chapters/chapter13/balloons/Lapu-Lapu3.png");
		lapuBalloon4 = new Texture("chapters/chapter13/balloons/Lapu-Lapu4.png");
		simboloBalloon1 = new Texture(
				"chapters/chapter13/balloons/Simbolo1.png");
		simboloBalloon2 = new Texture(
				"chapters/chapter13/balloons/Simbolo2.png");
		aquinoBalloon1 = new Texture(
				"chapters/chapter13/balloons/NinoyAquino1.png");
		aquinoBalloon2 = new Texture(
				"chapters/chapter13/balloons/NinoyAquino2.png");
		aquinoBalloon3 = new Texture(
				"chapters/chapter13/balloons/NinoyAquino3.png");

	}

	@Override
	public void display(Batch batch) {
		if (assetNeedUpdate)
			assetManager();
		renderSharedAssets(batch);

        if (!isTeacher && chapterSection >= startOfQuestionSection && chapterSection < lastChapterSection) {
            ans1A.draw(batch);
            ans1B.draw(batch);
            ans1C.draw(batch);
            ans1D.draw(batch);
            ans1E.draw(batch);
            ans2A.draw(batch);
            ans2B.draw(batch);
            ans2C.draw(batch);
            ans2D.draw(batch);
            ans2E.draw(batch);
            next.draw(batch);
        }

        drawQuizResult(batch);
	}

	private void assetManager() {
        float ansX, ans1APos, ans1BPos, ans1CPos, ans1DPos, ans1EPos, ans2APos, ans2BPos, ans2CPos, ans2DPos, ans2EPos;
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
			backgroundSprite.setTexture(watawatBg);
			balloonSprite.setTexture(watawatBalloon1);
			break;
		case 3:
			balloonSprite.setTexture(watawatBalloon2);
			break;
		case 4:
			balloonSprite.setTexture(watawatBalloon3);
			break;
		case 5:
			backgroundSprite.setTexture(simboloBg);
			balloonSprite.setTexture(simboloBalloon1);
			break;
		case 6:
			balloonSprite.setTexture(simboloBalloon2);
			break;
		case 7:
			backgroundSprite.setTexture(bonifacioBg);
			balloonSprite.setTexture(bonifacioBalloon1);
			break;
		case 8: 
			balloonSprite.setTexture(bonifacioBalloon2);
			break;
		case 9:
			balloonSprite.setTexture(bonifacioBalloon2);
			break;
		case 10:
			balloonSprite.setTexture(bonifacioBalloon3);
			break;
		case 11:
			backgroundSprite.setTexture(aguinaldoBg);
			balloonSprite.setTexture(aguinaldoBalloon1);
			break;
		case 12:
			balloonSprite.setTexture(aguinaldoBalloon2);
			break;
		case 13:
			balloonSprite.setTexture(aguinaldoBalloon3);
			break;
		case 14:
			backgroundSprite.setTexture(rizalBg);
			balloonSprite.setTexture(rizalBalloon1);
			break;
		case 15:
			balloonSprite.setTexture(rizalBalloon2);
			break;
		case 16:
			balloonSprite.setTexture(rizalBalloon3);
			break;
		case 17:
			balloonSprite.setTexture(rizalBalloon4);
			break;
		case 18:
			backgroundSprite.setTexture(lapuBg);
			balloonSprite.setTexture(lapuBalloon1);
			break;
		case 19:
			balloonSprite.setTexture(lapuBalloon2);
			break;
		case 20:
			balloonSprite.setTexture(lapuBalloon3);
			break;
		case 21:
			balloonSprite.setTexture(lapuBalloon4);
			break;
        case 22: // Start of game
            backgroundSprite.setTexture(question1Bg);

            if (!isTeacher) {
                ans1Correct = ans2Correct = false;
                ansX = screenWidth / 1.83f;
                ans1APos = screenHeight / 1.66f;
                ans1BPos = screenHeight / 1.8f;
                ans1CPos = screenHeight / 1.97f;
                ans1DPos = screenHeight / 2.18f;
                ans1EPos = screenHeight / 2.43f;

                ans1A.setPosition(ansX, ans1APos);
                ans1A.setBounds(ansX, ans1APos, ans1A.getWidth(), ans1A.getHeight());
                ans1A.setAlpha(0);

                ans1B.setPosition(ansX, ans1BPos);
                ans1B.setBounds(ansX, ans1BPos, ans1A.getWidth(), ans1A.getHeight());
                ans1B.setAlpha(0);

                ans1C.setPosition(ansX, ans1CPos);
                ans1C.setBounds(ansX, ans1CPos, ans1A.getWidth(), ans1A.getHeight());
                ans1C.setAlpha(0);

                ans1D.setPosition(ansX, ans1DPos);
                ans1D.setBounds(ansX, ans1DPos, ans1A.getWidth(), ans1A.getHeight());
                ans1D.setAlpha(0);

                ans1E.setPosition(ansX, ans1EPos);
                ans1E.setBounds(ansX, ans1EPos, ans1A.getWidth(), ans1A.getHeight());
                ans1E.setAlpha(0);

                ans2A.setAlpha(0);
                ans2B.setAlpha(0);
                ans2C.setAlpha(0);
                ans2D.setAlpha(0);
                ans2E.setAlpha(0);
            }
            break;
        case 23:
            backgroundSprite.setTexture(question2Bg);

            if (!isTeacher) {
                if (ans1Correct) correctAnswers++;
                ans1Correct = ans2Correct = false;

                ansX = screenWidth / 1.86f;
                ans1APos = screenHeight / 1.23f;
                ans1BPos = screenHeight / 1.33f;
                ans1CPos = screenHeight / 1.43f;
                ans1DPos = screenHeight / 1.53f;
                ans1EPos = screenHeight / 1.63f;

                ans2APos = screenHeight / 2.18f;
                ans2BPos = screenHeight / 2.479f;
                ans2CPos = screenHeight / 2.8f;
                ans2DPos = screenHeight / 3.275f;
                ans2EPos = screenHeight / 3.71f;

                ans1A.setPosition(ansX, ans1APos);
                ans1A.setBounds(ansX, ans1APos, ans1A.getWidth(), ans1A.getHeight());
                ans1A.setAlpha(0);

                ans1B.setPosition(ansX, ans1BPos);
                ans1B.setBounds(ansX, ans1BPos, ans1A.getWidth(), ans1A.getHeight());
                ans1B.setAlpha(0);

                ans1C.setPosition(ansX, ans1CPos);
                ans1C.setBounds(ansX, ans1CPos, ans1A.getWidth(), ans1A.getHeight());
                ans1C.setAlpha(0);

                ans1D.setPosition(ansX, ans1DPos);
                ans1D.setBounds(ansX, ans1DPos, ans1A.getWidth(), ans1A.getHeight());
                ans1D.setAlpha(0);

                ans1E.setPosition(ansX, ans1EPos);
                ans1E.setBounds(ansX, ans1EPos, ans1A.getWidth(), ans1A.getHeight());
                ans1E.setAlpha(0);

                ans2A.setPosition(ansX, ans2APos);
                ans2A.setBounds(ansX, ans2APos, ans1A.getWidth(), ans1A.getHeight());
                ans2A.setAlpha(0);

                ans2B.setPosition(ansX, ans2BPos);
                ans2B.setBounds(ansX, ans2BPos, ans1A.getWidth(), ans1A.getHeight());
                ans2B.setAlpha(0);

                ans2C.setPosition(ansX, ans2CPos);
                ans2C.setBounds(ansX, ans2CPos, ans1A.getWidth(), ans1A.getHeight());
                ans2C.setAlpha(0);

                ans2D.setPosition(ansX, ans2DPos);
                ans2D.setBounds(ansX, ans2DPos, ans1A.getWidth(), ans1A.getHeight());
                ans2D.setAlpha(0);

                ans2E.setPosition(ansX, ans2EPos);
                ans2E.setBounds(ansX, ans2EPos, ans1A.getWidth(), ans1A.getHeight());
                ans2E.setAlpha(0);
            }
            break;
        case 24:
            backgroundSprite.setTexture(question3Bg);

            if (!isTeacher) {
                if (ans1Correct) correctAnswers++;
                if (ans2Correct) correctAnswers++;
                ans1Correct = ans2Correct = false;

                ansX = screenWidth / 1.7f;
                ans1APos = screenHeight / 1.3f;
                ans1BPos = screenHeight / 1.4f;
                ans1CPos = screenHeight / 1.5f;
                ans1DPos = screenHeight / 1.6f;
                ans1EPos = screenHeight / 1.725f;

                ans2APos = screenHeight / 2.18f;
                ans2BPos = screenHeight / 2.479f;
                ans2CPos = screenHeight / 2.79f;
                ans2DPos = screenHeight / 3.275f;
                ans2EPos = screenHeight / 3.75f;

                ans1A.setPosition(ansX, ans1APos);
                ans1A.setBounds(ansX, ans1APos, ans1A.getWidth(), ans1A.getHeight());
                ans1A.setAlpha(0);

                ans1B.setPosition(ansX, ans1BPos);
                ans1B.setBounds(ansX, ans1BPos, ans1A.getWidth(), ans1A.getHeight());
                ans1B.setAlpha(0);

                ans1C.setPosition(ansX, ans1CPos);
                ans1C.setBounds(ansX, ans1CPos, ans1A.getWidth(), ans1A.getHeight());
                ans1C.setAlpha(0);

                ans1D.setPosition(ansX, ans1DPos);
                ans1D.setBounds(ansX, ans1DPos, ans1A.getWidth(), ans1A.getHeight());
                ans1D.setAlpha(0);

                ans1E.setPosition(ansX, ans1EPos);
                ans1E.setBounds(ansX, ans1EPos, ans1A.getWidth(), ans1A.getHeight());
                ans1E.setAlpha(0);

                ans2A.setPosition(ansX, ans2APos);
                ans2A.setBounds(ansX, ans2APos, ans1A.getWidth(), ans1A.getHeight());
                ans2A.setAlpha(0);

                ans2B.setPosition(ansX, ans2BPos);
                ans2B.setBounds(ansX, ans2BPos, ans1A.getWidth(), ans1A.getHeight());
                ans2B.setAlpha(0);

                ans2C.setPosition(ansX, ans2CPos);
                ans2C.setBounds(ansX, ans2CPos, ans1A.getWidth(), ans1A.getHeight());
                ans2C.setAlpha(0);

                ans2D.setPosition(ansX, ans2DPos);
                ans2D.setBounds(ansX, ans2DPos, ans1A.getWidth(), ans1A.getHeight());
                ans2D.setAlpha(0);

                ans2E.setPosition(ansX, ans2EPos);
                ans2E.setBounds(ansX, ans2EPos, ans1A.getWidth(), ans1A.getHeight());
                ans2E.setAlpha(0);
            }
            break;
        case 25:
            backgroundSprite.setTexture(questionBg);
            if (ans1Correct) correctAnswers++;
            if (ans2Correct) correctAnswers++;
            if (isTeacher) correctAnswers = 5;
            displayQuizResult(CHAPTER_THIRTEEN_SCORE, 3);
            break;
		}
        assetNeedUpdate = false;
	}

    @Override
    public int touchDown(float x, float y) {
        switch (chapterSection) {
            case 22:
                if (!isTeacher) {
                    if (ans1A.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(1);
                        ans1B.setAlpha(0);
                        ans1C.setAlpha(0);
                        ans1D.setAlpha(0);
                        ans1E.setAlpha(0);
                        ans1Correct = true;
                    } else if (ans1B.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(1);
                        ans1C.setAlpha(0);
                        ans1D.setAlpha(0);
                        ans1E.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans1C.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(0);
                        ans1C.setAlpha(1);
                        ans1D.setAlpha(0);
                        ans1E.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans1D.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(0);
                        ans1C.setAlpha(0);
                        ans1D.setAlpha(1);
                        ans1E.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans1E.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(0);
                        ans1C.setAlpha(0);
                        ans1D.setAlpha(0);
                        ans1E.setAlpha(1);
                        ans1Correct = false;
                    }
                }
                break;
            case 23:
                if (!isTeacher) {
                    if (ans1A.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(1);
                        ans1B.setAlpha(0);
                        ans1C.setAlpha(0);
                        ans1D.setAlpha(0);
                        ans1E.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans1B.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(1);
                        ans1C.setAlpha(0);
                        ans1D.setAlpha(0);
                        ans1E.setAlpha(0);
                        ans1Correct = true;
                    } else if (ans1C.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(0);
                        ans1C.setAlpha(1);
                        ans1D.setAlpha(0);
                        ans1E.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans1D.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(0);
                        ans1C.setAlpha(0);
                        ans1D.setAlpha(1);
                        ans1E.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans1E.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(0);
                        ans1C.setAlpha(0);
                        ans1D.setAlpha(0);
                        ans1E.setAlpha(1);
                        ans1Correct = false;
                    }

                    if (ans2A.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(1);
                        ans2B.setAlpha(0);
                        ans2C.setAlpha(0);
                        ans2D.setAlpha(0);
                        ans2E.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans2B.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(0);
                        ans2B.setAlpha(1);
                        ans2C.setAlpha(0);
                        ans2D.setAlpha(0);
                        ans2E.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans2C.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(0);
                        ans2B.setAlpha(0);
                        ans2C.setAlpha(1);
                        ans2D.setAlpha(0);
                        ans2E.setAlpha(0);
                        ans2Correct = true;
                    } else if (ans2D.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(0);
                        ans2B.setAlpha(0);
                        ans2C.setAlpha(0);
                        ans2D.setAlpha(1);
                        ans2E.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans2E.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(0);
                        ans2B.setAlpha(0);
                        ans2C.setAlpha(0);
                        ans2D.setAlpha(0);
                        ans2E.setAlpha(1);
                        ans2Correct = false;
                    }
                }
                break;
            case 24:
                if (!isTeacher) {
                    if (ans1A.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(1);
                        ans1B.setAlpha(0);
                        ans1C.setAlpha(0);
                        ans1D.setAlpha(0);
                        ans1E.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans1B.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(1);
                        ans1C.setAlpha(0);
                        ans1D.setAlpha(0);
                        ans1E.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans1C.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(0);
                        ans1C.setAlpha(1);
                        ans1D.setAlpha(0);
                        ans1E.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans1D.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(0);
                        ans1C.setAlpha(0);
                        ans1D.setAlpha(1);
                        ans1E.setAlpha(0);
                        ans1Correct = true;
                    } else if (ans1E.getBoundingRectangle().contains(x, y)) {
                        ans1A.setAlpha(0);
                        ans1B.setAlpha(0);
                        ans1C.setAlpha(0);
                        ans1D.setAlpha(0);
                        ans1E.setAlpha(1);
                        ans1Correct = false;
                    }

                    if (ans2A.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(1);
                        ans2B.setAlpha(0);
                        ans2C.setAlpha(0);
                        ans2D.setAlpha(0);
                        ans2E.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans2B.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(0);
                        ans2B.setAlpha(1);
                        ans2C.setAlpha(0);
                        ans2D.setAlpha(0);
                        ans2E.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans2C.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(0);
                        ans2B.setAlpha(0);
                        ans2C.setAlpha(1);
                        ans2D.setAlpha(0);
                        ans2E.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans2D.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(0);
                        ans2B.setAlpha(0);
                        ans2C.setAlpha(0);
                        ans2D.setAlpha(1);
                        ans2E.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans2E.getBoundingRectangle().contains(x, y)) {
                        ans2A.setAlpha(0);
                        ans2B.setAlpha(0);
                        ans2C.setAlpha(0);
                        ans2D.setAlpha(0);
                        ans2E.setAlpha(1);
                        ans2Correct = true;
                    }
                }
                break;
            case 25:
                return displayLastSectionButtons(13, 3, x, y);
        }
        return super.touchDown(x, y);
    }

    @Override
	public void dispose() {
		introBg.dispose();
		bonifacioBg.dispose(); 
		watawatBg.dispose();
		aguinaldoBg.dispose();
		rizalBg.dispose();
		lapuBg.dispose();
		simboloBg.dispose();
		aquinoBg.dispose();
		introBalloon1.dispose();
		introBalloon2.dispose();
		bonifacioBalloon1.dispose();
		bonifacioBalloon2.dispose();
		bonifacioBalloon3.dispose();
		watawatBalloon1.dispose();
		watawatBalloon2.dispose();
		watawatBalloon3.dispose();
		aguinaldoBalloon1.dispose();
		aguinaldoBalloon2.dispose();
		aguinaldoBalloon3.dispose();
		rizalBalloon1.dispose();
		rizalBalloon2.dispose();
		rizalBalloon3.dispose();
		rizalBalloon4.dispose();
		lapuBalloon1.dispose();
		lapuBalloon2.dispose();
		lapuBalloon3.dispose();
		lapuBalloon4.dispose();
		simboloBalloon1.dispose();
		simboloBalloon2.dispose();
		aquinoBalloon1.dispose();
		aquinoBalloon2.dispose();
		aquinoBalloon3.dispose();
		question1Bg.dispose();
		question2Bg.dispose();
		question3Bg.dispose();
        if (!isTeacher) ansMarkerTexture.dispose();
	}
}
