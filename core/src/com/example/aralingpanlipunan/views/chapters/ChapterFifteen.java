package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import static com.example.aralingpanlipunan.android.database.DatabaseSetup.CHAPTER_FIFTEEN_SCORE;

public class ChapterFifteen extends ChapterCore {
	private Texture introBg, epektoTulunganBg, gawainTulunganBg,
			tulongPangangailanganBg, pangangailanganNatinBg, introBalloon1,
			introBalloon2, epektoTulunganBalloon1, epektoTulunganBalloon2,
			epektoTulunganBalloon3, gawainTulunganBalloon1,
			gawainTulunganBalloon2, gawainTulunganBalloon3,
			gawainTulunganBalloon4, pangangailanganBalloon1,
			pangangailanganBalloon2, pangangailanganBalloon3,
			pangangailanganBalloon4, tulongPangangailanganBalloon1,
			tulongPangangailanganBalloon2, tulongPangangailanganBalloon3,
			question1Bg, question2Bg, question3Bg, ansMarkerTexture;
	private Music intro1S, intro2S, epekto1S, epekto2S, epekto3S, gawain1S, gawain2S, 
				  gawain3S, gawain4S, kailangan1S, kailangan2S, kailangan3S, kailangan4S, 
				  katulong1S, katulong2S, katulong3S;
    private Sprite ans1True, ans1False, ans2True, ans2False, ans3True, ans3False, ans4True, ans4False;
    private boolean ans1Correct, ans2Correct, ans3Correct, ans4Correct;

	public ChapterFifteen(AndroidInterface androidInterface, boolean isTeacher) {
		super(androidInterface, isTeacher);
	}
	public ChapterFifteen(AndroidInterface androidInterface, String studentName, String password) {
		super(androidInterface, studentName, password);
	}

	@Override
	public void setUp(int screenW, int screenH) {
		super.setUp(screenW, screenH);
		
		startOfQuestionSection = 16;
		lastChapterSection = 19;
		
		//sounds
		intro1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter15/sounds/intro1chap15.m4a"));
		intro2S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter15/sounds/intro2chap15.m4a"));
		epekto1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter15/sounds/epekto1.m4a"));
		epekto2S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter15/sounds/epekto2.m4a"));
		epekto3S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter15/sounds/epekto3.m4a"));
		gawain1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter15/sounds/gawain1.m4a"));
		gawain2S  = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter15/sounds/gawain2.m4a"));
		gawain3S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter15/sounds/gawain3.m4a"));
		gawain4S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter15/sounds/gawain4.m4a"));
		kailangan1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter15/sounds/kailangan1.m4a"));
		kailangan2S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter15/sounds/kailangan2.m4a"));
		kailangan3S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter15/sounds/kailangan3.m4a"));
		kailangan4S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter15/sounds/kailangan4.m4a"));
		katulong1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter15/sounds/katulong1.m4a"));
		katulong2S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter15/sounds/katulong2.m4a"));
		katulong3S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter15/sounds/katulong1.m4a"));

		// backgrounds
		introBg = new Texture(
				"chapters/chapter15/backgrounds/IntroForChapter15.png");
		epektoTulunganBg = new Texture("chapters/chapter15/backgrounds/EpektoNgPagtutulungan.png");
		gawainTulunganBg = new Texture("chapters/chapter15/backgrounds/GawainSaPagtutulungan.png");
		tulongPangangailanganBg = new Texture("chapters/chapter15/backgrounds/KatulongSaPangangailangan.png");
		pangangailanganNatinBg = new Texture("chapters/chapter15/backgrounds/PangangailanganNatin.png");
		
		if (isTeacher) {
			question1Bg = new Texture(
					"chapters/chapter15/answerkeys/answer1.jpg");
			question2Bg = new Texture(
					"chapters/chapter15/answerkeys/answer2.jpg");
			question3Bg = new Texture(
					"chapters/chapter15/answerkeys/answer3.jpg");
		} else {
			question1Bg = new Texture(
					"chapters/chapter15/backgrounds/question1.jpg");
			question2Bg = new Texture(
					"chapters/chapter15/backgrounds/question2.jpg");
			question3Bg = new Texture(
					"chapters/chapter15/backgrounds/question3.jpg");

            ansMarkerTexture = new Texture("box.png");
            ans1True = new Sprite(ansMarkerTexture);
            ans1True.setSize((ans1True.getWidth() * getButtonScale()) / 1.35f, (ans1True.getHeight() * getButtonScale()) / 3.397f);

            ans1False = new Sprite(ansMarkerTexture);
            ans1False.setSize(ans1True.getWidth(), ans1True.getHeight());

            ans2True = new Sprite(ansMarkerTexture);
            ans2True.setSize(ans1True.getWidth(), ans1True.getHeight());

            ans2False = new Sprite(ansMarkerTexture);
            ans2False.setSize(ans1True.getWidth(), ans1True.getHeight());

            ans3True = new Sprite(ansMarkerTexture);
            ans3True.setSize(ans1True.getWidth(), ans1True.getHeight());

            ans3False = new Sprite(ansMarkerTexture);
            ans3False.setSize(ans1True.getWidth(), ans1True.getHeight());

            ans4True = new Sprite(ansMarkerTexture);
            ans4True.setSize(ans1True.getWidth(), ans1True.getHeight());

            ans4False = new Sprite(ansMarkerTexture);
            ans4False.setSize(ans1True.getWidth(), ans1True.getHeight());

            loadNextButton();
		}
		
		
		introBalloon1 = new Texture("chapters/chapter15/balloons/EpektoNgPagtutulungan1.png");
		introBalloon2 = new Texture("chapters/chapter15/balloons/EpektoNgPagtutulungan2.png");
		epektoTulunganBalloon1 = new Texture("chapters/chapter15/balloons/EpektoNgPagtutulungan1.png");
		epektoTulunganBalloon2 = new Texture("chapters/chapter15/balloons/EpektoNgPagtutulungan2.png");
		epektoTulunganBalloon3 = new Texture("chapters/chapter15/balloons/EpektoNgPagtutulungan3.png");
		gawainTulunganBalloon1  = new Texture("chapters/chapter15/balloons/GawainSaPagtutulungan1.png");
		gawainTulunganBalloon2 = new Texture("chapters/chapter15/balloons/GawainSaPagtutulungan2.png");
		gawainTulunganBalloon3 = new Texture("chapters/chapter15/balloons/GawainSaPagtutulungan3.png");
        gawainTulunganBalloon4 = new Texture("chapters/chapter15/balloons/GawainSaPagtutulungan4.png");
		pangangailanganBalloon1 = new Texture("chapters/chapter15/balloons/Pangangailangan1.png");
		pangangailanganBalloon2 = new Texture("chapters/chapter15/balloons/Pangangailangan2.png");
		pangangailanganBalloon3 = new Texture("chapters/chapter15/balloons/Pangangailangan3.png");
		pangangailanganBalloon4 = new Texture("chapters/chapter15/balloons/Pangangailangan4.png");
		tulongPangangailanganBalloon1 = new Texture("chapters/chapter15/balloons/TaongKatulongSaPangangailangan1.png");
		tulongPangangailanganBalloon2 = new Texture("chapters/chapter15/balloons/TaongKatulongSaPangangailangan2.png");
		tulongPangangailanganBalloon3 = new Texture("chapters/chapter15/balloons/TaongKatulongSaPangangailangan3.png");
		
	}

	@Override
	public void display(Batch batch) {
		if (assetNeedUpdate)
			assetManager();
		renderSharedAssets(batch);

        if (!isTeacher && chapterSection >= startOfQuestionSection && chapterSection < lastChapterSection) {
            ans1True.draw(batch);
            ans1False.draw(batch);
            ans2True.draw(batch);
            ans2False.draw(batch);
            ans3True.draw(batch);
            ans3False.draw(batch);
            ans4True.draw(batch);
            ans4False.draw(batch);
            next.draw(batch);
        }

        drawQuizResult(batch);
	}

	private void assetManager() {
        float leftCol, rightCol, row1, row2, row3, row4;
		switch (chapterSection) {
		case 0:
			backgroundSprite.setTexture(introBg);
			balloonSprite.setTexture(introBalloon1);
			intro2S.stop();
			break;
		case 1:
			backgroundSprite.setTexture(introBg);
			balloonSprite.setTexture(introBalloon2);
			intro1S.stop();
			epekto1S.stop();
			break;
		case 2:
			backgroundSprite.setTexture(epektoTulunganBg);
			balloonSprite.setTexture(epektoTulunganBalloon1);
			intro2S.stop();
			epekto2S.stop();
			break;
		case 3:
			balloonSprite.setTexture(epektoTulunganBalloon2);
			epekto1S.stop();
			epekto3S.stop();
			break;
		case 4:
            backgroundSprite.setTexture(epektoTulunganBg);
			balloonSprite.setTexture(epektoTulunganBalloon3);
			epekto2S.stop();
			gawain1S.stop();
			break;
		case 5:
			backgroundSprite.setTexture(gawainTulunganBg);
			balloonSprite.setTexture(gawainTulunganBalloon1);
			epekto3S.stop();
			gawain2S.stop();
			break;
		case 6:
			balloonSprite.setTexture(gawainTulunganBalloon2);
			gawain1S.stop();
			gawain3S.stop();
			break;
		case 7:
			balloonSprite.setTexture(gawainTulunganBalloon3);
			gawain2S.stop();
			gawain4S.stop();
			break;
		case 8:
            backgroundSprite.setTexture(gawainTulunganBg);
			balloonSprite.setTexture(gawainTulunganBalloon4);
			gawain3S.stop();
			kailangan1S.stop();
			break;
		case 9:
			backgroundSprite.setTexture(pangangailanganNatinBg);
			balloonSprite.setTexture(pangangailanganBalloon1);
			gawain4S.stop();
			kailangan2S.stop();
			break;
		case 10:
			balloonSprite.setTexture(pangangailanganBalloon2);
			kailangan1S.stop();
			kailangan3S.stop();
			break;
		case 11:
			balloonSprite.setTexture(pangangailanganBalloon3);
			kailangan2S.stop();
			kailangan4S.stop();
			break;
		case 12:
            backgroundSprite.setTexture(pangangailanganNatinBg);
			balloonSprite.setTexture(pangangailanganBalloon4);
			kailangan3S.stop();
			katulong1S.stop();
			break;
		case 13:
			backgroundSprite.setTexture(tulongPangangailanganBg);
			balloonSprite.setTexture(tulongPangangailanganBalloon1);
			kailangan4S.stop();
			katulong2S.stop();
			break;
		case 14:
			balloonSprite.setTexture(tulongPangangailanganBalloon2);
			katulong1S.stop();
			katulong3S.stop();
			break;
		case 15:
            backgroundSprite.setTexture(tulongPangangailanganBg);
			balloonSprite.setTexture(tulongPangangailanganBalloon3);
			katulong2S.stop();
			break;
        case 16: // Start of game
        	katulong3S.stop();
            backgroundSprite.setTexture(question1Bg);
            if (!isTeacher) {
                ans1Correct = ans2Correct = ans3Correct = ans4Correct = false;
                leftCol = screenWidth / 3;
                rightCol = screenWidth / 1.62f;
                row1 = screenHeight / 1.6f;
                row2 = screenHeight / 2.1f;
                row3 = screenHeight / 2.91f;
                row4 = screenHeight / 4.2f;

                positionMarkers(leftCol, rightCol, row1, row2, row3, row4);
            }
            break;
        case 17:
            backgroundSprite.setTexture(question2Bg);
            if (!isTeacher) {
                if (ans1Correct) correctAnswers++;
                if (ans2Correct) correctAnswers++;
                if (ans3Correct) correctAnswers++;
                if (ans4Correct) correctAnswers++;
                ans1Correct = ans2Correct = ans3Correct = ans4Correct = false;

                leftCol = screenWidth / 2.94f;
                rightCol = screenWidth / 1.5f;
                row1 = screenHeight / 1.351f;
                row2 = screenHeight / 1.682f;
                row3 = screenHeight / 2.17f;
                row4 = screenHeight / 3.21f;

                positionMarkers(leftCol, rightCol, row1, row2, row3, row4);
            }
            break;
        case 18:
            backgroundSprite.setTexture(question3Bg);
            if (!isTeacher) {
                if (ans1Correct) correctAnswers++;
                if (ans2Correct) correctAnswers++;
                if (ans3Correct) correctAnswers++;
                if (ans4Correct) correctAnswers++;
                ans1Correct = ans2Correct = ans3Correct = ans4Correct = false;

                leftCol = screenWidth / 3;
                rightCol = screenWidth / 1.515f;
                row1 = screenHeight / 1.4f;
                row2 = screenHeight / 1.785f;
                row3 = screenHeight / 2.8f;
                row4 = screenHeight / 3.6f;

                positionMarkers(leftCol, rightCol, row1, row2, row3, row4);
            }
            break;
        case 19:
            if (isTeacher) {
                correctAnswers = 10;
            } else {
                if (ans1Correct) correctAnswers++;
                if (ans2Correct) correctAnswers++;
            }
            displayQuizResult(CHAPTER_FIFTEEN_SCORE, 5);
            break;
		}
        assetNeedUpdate = false;
	}

    @Override
    public int touchDown(float x, float y) {
    	if (soundSprite.getBoundingRectangle().contains(x, y)) {
            playSoundForSection();
        }
        switch (chapterSection) {
            case 16:
                if (!isTeacher) {
                    if (ans1True.getBoundingRectangle().contains(x, y)) {
                        ans1True.setAlpha(1);
                        ans1False.setAlpha(0);
                        ans1Correct = true;
                    } else if (ans1False.getBoundingRectangle().contains(x, y)) {
                        ans1True.setAlpha(0);
                        ans1False.setAlpha(1);
                        ans1Correct = false;
                    }

                    if (ans2True.getBoundingRectangle().contains(x, y)) {
                        ans2True.setAlpha(1);
                        ans2False.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans2False.getBoundingRectangle().contains(x, y)) {
                        ans2True.setAlpha(0);
                        ans2False.setAlpha(1);
                        ans2Correct = true;
                    }

                    if (ans3True.getBoundingRectangle().contains(x, y)) {
                        ans3True.setAlpha(1);
                        ans3False.setAlpha(0);
                        ans3Correct = true;
                    } else if (ans3False.getBoundingRectangle().contains(x, y)) {
                        ans3True.setAlpha(0);
                        ans3False.setAlpha(1);
                        ans3Correct = false;
                    }

                    if (ans4True.getBoundingRectangle().contains(x, y)) {
                        ans4True.setAlpha(1);
                        ans4False.setAlpha(0);
                        ans4Correct = false;
                    } else if (ans4False.getBoundingRectangle().contains(x, y)) {
                        ans4True.setAlpha(0);
                        ans4False.setAlpha(1);
                        ans4Correct = true;
                    }
                }
                break;
            case 17:
                if (!isTeacher) {
                    if (ans1True.getBoundingRectangle().contains(x, y)) {
                        ans1True.setAlpha(1);
                        ans1False.setAlpha(0);
                        ans1Correct = false;
                    } else if (ans1False.getBoundingRectangle().contains(x, y)) {
                        ans1True.setAlpha(0);
                        ans1False.setAlpha(1);
                        ans1Correct = true;
                    }

                    if (ans2True.getBoundingRectangle().contains(x, y)) {
                        ans2True.setAlpha(1);
                        ans2False.setAlpha(0);
                        ans2Correct = true;
                    } else if (ans2False.getBoundingRectangle().contains(x, y)) {
                        ans2True.setAlpha(0);
                        ans2False.setAlpha(1);
                        ans2Correct = false;
                    }

                    if (ans3True.getBoundingRectangle().contains(x, y)) {
                        ans3True.setAlpha(1);
                        ans3False.setAlpha(0);
                        ans3Correct = false;
                    } else if (ans3False.getBoundingRectangle().contains(x, y)) {
                        ans3True.setAlpha(0);
                        ans3False.setAlpha(1);
                        ans3Correct = true;
                    }

                    if (ans4True.getBoundingRectangle().contains(x, y)) {
                        ans4True.setAlpha(1);
                        ans4False.setAlpha(0);
                        ans4Correct = false;
                    } else if (ans4False.getBoundingRectangle().contains(x, y)) {
                        ans4True.setAlpha(0);
                        ans4False.setAlpha(1);
                        ans4Correct = true;
                    }
                }
                break;
            case 18:
                if (!isTeacher) {
                    if (ans1True.getBoundingRectangle().contains(x, y)) {
                        ans1True.setAlpha(1);
                        ans1False.setAlpha(0);
                        ans1Correct = true;
                    } else if (ans1False.getBoundingRectangle().contains(x, y)) {
                        ans1True.setAlpha(0);
                        ans1False.setAlpha(1);
                        ans1Correct = false;
                    }

                    if (ans2True.getBoundingRectangle().contains(x, y)) {
                        ans2True.setAlpha(1);
                        ans2False.setAlpha(0);
                        ans2Correct = false;
                    } else if (ans2False.getBoundingRectangle().contains(x, y)) {
                        ans2True.setAlpha(0);
                        ans2False.setAlpha(1);
                        ans2Correct = true;
                    }
                }
                break;
            case 19:
                return displayLastSectionButtons(15, 5, x, y);
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
    		epekto1S.stop();
    		epekto1S.play();
    		break;
    	case 3:
    		epekto2S.stop();
    		epekto2S.play();
    		break;
    	case 4:
    		epekto3S.stop();
    		epekto3S.play();
    		break;
    	case 5:
    		gawain1S.stop();
    		gawain1S.play();
    		break;
    	case 6:
    		gawain2S.stop();
    		gawain2S.play();
    		break;
    	case 7:
    		gawain3S.stop();
    		gawain3S.play();
    		break;
    	case 8:
    		gawain4S.stop();
    		gawain4S.play();
    		break;
    	case 9:
    		kailangan1S.stop();
    		kailangan1S.play();
    		break;
    	case 10:
    		kailangan2S.stop();
    		kailangan2S.play();
    		break;
    	case 11:
    		kailangan3S.stop();
    		kailangan3S.play();
    		break;
    	case 12:
    		kailangan4S.stop();
    		kailangan4S.play();
    		break;
    	case 13:
    		katulong1S.stop();
    		katulong1S.play();
    		break;
    	case 14:
    		katulong2S.stop();
    		katulong2S.play();
    		break;
    	case 15:
    		katulong3S.stop();
    		katulong3S.play();
    		break;
    	
    	}
		
	}
	@Override
	public void dispose() {
		intro1S.stop();
		intro2S.stop();
		epekto1S.stop();
		epekto2S.stop();
		epekto3S.stop();
		gawain1S.stop();
		gawain2S.stop();
		gawain3S.stop();
		gawain4S.stop();
		kailangan1S.stop();
		kailangan2S.stop();
		kailangan3S.stop();
		kailangan4S.stop();
		katulong1S.stop();
		katulong2S.stop();
		katulong3S.stop();
		
		intro1S.dispose();
		intro2S.dispose();
		epekto1S.dispose();
		epekto2S.dispose();
		epekto3S.dispose();
		gawain1S.dispose();
		gawain2S.dispose();
		gawain3S.dispose();
		gawain4S.dispose();
		kailangan1S.dispose();
		kailangan2S.dispose();
		kailangan3S.dispose();
		kailangan4S.dispose();
		katulong1S.dispose();
		katulong2S.dispose();
		katulong3S.dispose();
		
		introBg.dispose();
		epektoTulunganBg.dispose();
		gawainTulunganBg.dispose();
		tulongPangangailanganBg.dispose();
		pangangailanganNatinBg.dispose();
		introBalloon1.dispose();
		introBalloon2.dispose();
		epektoTulunganBalloon1.dispose();
		epektoTulunganBalloon2.dispose();
		epektoTulunganBalloon3.dispose();
		gawainTulunganBalloon1.dispose();
		gawainTulunganBalloon2.dispose();
		gawainTulunganBalloon3.dispose();
		pangangailanganBalloon1.dispose();
		pangangailanganBalloon2.dispose();
		pangangailanganBalloon3.dispose();
		pangangailanganBalloon4.dispose();
		tulongPangangailanganBalloon1.dispose();
		tulongPangangailanganBalloon2.dispose();
		tulongPangangailanganBalloon3.dispose();
        if (!isTeacher) ansMarkerTexture.dispose();
	}

    /**
     * Position the answer markers & touch listeners to match
     * the choices in the game
     * @param leftCol The left column
     * @param rightCol The right column
     * @param row1 First row
     * @param row2 Second row
     * @param row3 Third row
     * @param row4 Fourth row
     */
    private void positionMarkers(float leftCol, float rightCol, float row1, float row2, float row3, float row4) {
        ans1True.setPosition(leftCol, row1);
        ans1True.setBounds(leftCol, row1, ans1True.getWidth(), ans1True.getHeight());
        ans1True.setAlpha(0);

        ans1False.setPosition(rightCol, row1);
        ans1False.setBounds(rightCol, row1, ans1False.getWidth(), ans1False.getHeight());
        ans1False.setAlpha(0);

        ans2True.setPosition(leftCol, row2);
        ans2True.setBounds(leftCol, row2, ans2True.getWidth(), ans2True.getHeight());
        ans2True.setAlpha(0);

        ans2False.setPosition(rightCol, row2);
        ans2False.setBounds(rightCol, row2, ans2False.getWidth(), ans2False.getHeight());
        ans2False.setAlpha(0);

        ans3True.setPosition(leftCol, row3);
        ans3True.setBounds(leftCol, row3, ans3True.getWidth(), ans3True.getHeight());
        ans3True.setAlpha(0);

        ans3False.setPosition(rightCol, row3);
        ans3False.setBounds(rightCol, row3, ans3False.getWidth(), ans3False.getHeight());
        ans3False.setAlpha(0);

        ans4True.setPosition(leftCol, row4);
        ans4True.setBounds(leftCol, row4, ans4True.getWidth(), ans4True.getHeight());
        ans4True.setAlpha(0);

        ans4False.setPosition(rightCol, row4);
        ans4False.setBounds(rightCol, row4, ans4False.getWidth(), ans4False.getHeight());
        ans4False.setAlpha(0);
    }

}
