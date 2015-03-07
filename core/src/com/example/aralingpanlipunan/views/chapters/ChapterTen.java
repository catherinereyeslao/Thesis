package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import static com.example.aralingpanlipunan.android.database.DatabaseSetup.CHAPTER_TEN_SCORE;

public class ChapterTen extends ChapterCore {

	private Texture introBg, bagongTaonBg, paggalangBg, salosaloBg, bisitaBg, undasBg,
			introBalloon1, bagongTaonBalloon1, bagongTaonBalloon2,
			bagongTaonBalloon3, salosaloBalloon1, salosaloBalloon2,
			salosaloBalloon3, paggalangBalloon1, paggalangBalloon2,
			paggalangBalloon3, paggalangBalloon4, pagtanggapBalloon1,
			pagtanggapBalloon2, pagtanggapBalloon3, undasBalloon1,
			undasBalloon2, undasBalloon3, undasBalloon4, undasBalloon5,
            question1Texture, question2Texture, markerTexture;
	private Music intro1S, bagongTaon1S, bagongTaon2S, bagongTaon3S, salo1S, salo2S, salo3S, galang1S, galang2S,
				  galang3S, galang4S, tanggap1S, tanggap2S, tanggap3S, undas1S, undas2S, undas3S, undas4S, undas5S;
    private Sprite ansMarker, ansMarker2, ansMarker3, ansMarker4, ansMarker5, ansMarker6, ansMarker7, ansMarker8, ansMarker9, ansMarker10, ansMarker11, ansMarker12;
    private boolean ans1Correct, ans2Correct, ans3Correct, ans4Correct, ans5Correct = false;

	public ChapterTen(AndroidInterface androidInterface, String studName, String password) {
		super(androidInterface, studName, password);
	}

    public ChapterTen(AndroidInterface androidInterface, boolean isTeacher) {
        super(androidInterface, isTeacher);
    }

	@Override
	public void setUp(int screenW, int screenH) {
		super.setUp(screenW, screenH);

		startOfQuestionSection = 19;
		lastChapterSection = 21;
		
		//sounds
		intro1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sounds/introchap10.m4a"));
		bagongTaon1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sounds/bagongtaon1.m4a"));
		bagongTaon2S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sounds/bagongtaon2.m4a"));
		bagongTaon3S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sounds/bagongtaon3.m4a"));
		salo1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sounds/pagdiriwang1.m4a"));
		salo2S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sounds/pagdiriwang2.m4a"));
		salo3S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sounds/pagdiriwang3.m4a"));
		galang1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sounds/paggalang1.m4a"));
		galang2S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sounds/paggalang2.m4a"));
		galang3S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sounds/paggalang3.m4a"));
		galang4S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sounds/paggalang4.m4a"));
		tanggap1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sounds/pagtanggap1.m4a"));
		tanggap2S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sounds/pagtanggap2.m4a"));
		tanggap3S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sounds/pagtanggap3.m4a"));
		undas1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sounds/undas1.m4a"));
		undas2S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sounds/undas2.m4a"));
		undas3S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sounds/undas3.m4a"));
		undas4S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sounds/undas4.m4a"));
		undas5S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sounds/undas5.m4a"));
		// background
		introBg = new Texture(
				"chapters/chapter10/backgrounds/IntroForChapter10.png");
		bagongTaonBg = new Texture(
				"chapters/chapter10/backgrounds/Bagong Taon.png");
		paggalangBg = new Texture(
				"chapters/chapter10/backgrounds/Paggalang.png");
		salosaloBg = new Texture(
				"chapters/chapter10/backgrounds/Pagsasalo salo.png");
		bisitaBg = new Texture(
				"chapters/chapter10/backgrounds/Pagtanggap sa bisita.png");
		undasBg = new Texture("chapters/chapter10/backgrounds/Undas.png");

        if (isTeacher) {
            question1Texture = new Texture("chapters/chapter10/answerkeys/answer1.jpg");
            question2Texture = new Texture("chapters/chapter10/answerkeys/answer2.jpg");
            correctAnswers = currentRecordedScore = 10;
        } else {
            question1Texture = new Texture("chapters/chapter10/backgrounds/question1.jpg");
            question2Texture = new Texture("chapters/chapter10/backgrounds/question2.jpg");
            markerTexture = new Texture("box.png");
            ansMarker = new Sprite(markerTexture);
            ansMarker.setSize(ansMarker.getWidth() * getButtonScale(), (ansMarker.getHeight() * getButtonScale()) / 3.397f);

            ansMarker2 = new Sprite(markerTexture);
            ansMarker2.setSize(ansMarker.getWidth(), ansMarker.getHeight());

            ansMarker3 = new Sprite(markerTexture);
            ansMarker3.setSize(ansMarker.getWidth(), ansMarker.getHeight());

            ansMarker4 = new Sprite(markerTexture);
            ansMarker4.setSize(ansMarker.getWidth(), ansMarker.getHeight());

            ansMarker5 = new Sprite(markerTexture);
            ansMarker5.setSize(ansMarker.getWidth(), ansMarker.getHeight());

            ansMarker6 = new Sprite(markerTexture);
            ansMarker6.setSize(ansMarker.getWidth(), ansMarker.getHeight());

            ansMarker7 = new Sprite(markerTexture);
            ansMarker7.setSize(ansMarker.getWidth(), ansMarker.getHeight());

            ansMarker8 = new Sprite(markerTexture);
            ansMarker8.setSize(ansMarker.getWidth(), ansMarker.getHeight());

            ansMarker9 = new Sprite(markerTexture);
            ansMarker9.setSize(ansMarker.getWidth(), ansMarker.getHeight());

            ansMarker10 = new Sprite(markerTexture);
            ansMarker10.setSize(ansMarker.getWidth(), ansMarker.getHeight());

            ansMarker11 = new Sprite(markerTexture);
            ansMarker11.setSize(ansMarker.getWidth(), ansMarker.getHeight());

            ansMarker12 = new Sprite(markerTexture);
            ansMarker12.setSize(ansMarker.getWidth(), ansMarker.getHeight());

            loadNextButton();
        }

		// balloons
		introBalloon1 = new Texture("chapters/chapter10/balloons/Intro.png");
		bagongTaonBalloon1 = new Texture(
				"chapters/chapter10/balloons/BagongTaon1.png");
		bagongTaonBalloon2 = new Texture(
				"chapters/chapter10/balloons/BagongTaon2.png");
		bagongTaonBalloon3 = new Texture(
				"chapters/chapter10/balloons/BagongTaon3.png");
		salosaloBalloon1 = new Texture(
				"chapters/chapter10/balloons/Pagdiriwang1.png");
		salosaloBalloon2 = new Texture(
				"chapters/chapter10/balloons/Pagdiriwang2.png");
		salosaloBalloon3 = new Texture(
				"chapters/chapter10/balloons/Pagdiriwang3.png");
		paggalangBalloon1 = new Texture(
				"chapters/chapter10/balloons/Paggalang1.png");
		paggalangBalloon2 = new Texture(
				"chapters/chapter10/balloons/Paggalang2.png");
		paggalangBalloon3 = new Texture(
				"chapters/chapter10/balloons/Paggalang3.png");
		paggalangBalloon4 = new Texture(
				"chapters/chapter10/balloons/Paggalang4.png");
		pagtanggapBalloon1 = new Texture(
				"chapters/chapter10/balloons/Pagtanggap1.png");
		pagtanggapBalloon2 = new Texture(
				"chapters/chapter10/balloons/Pagtanggap2.png");
		pagtanggapBalloon3 = new Texture(
				"chapters/chapter10/balloons/Pagtanggap3.png");
		undasBalloon1 = new Texture("chapters/chapter10/balloons/Undas1.png");
		undasBalloon2 = new Texture("chapters/chapter10/balloons/Undas2.png");
		undasBalloon3 = new Texture("chapters/chapter10/balloons/Undas3.png");
		undasBalloon4 = new Texture("chapters/chapter10/balloons/Undas4.png");
		undasBalloon5 = new Texture("chapters/chapter10/balloons/Undas5.png");

        assetNeedUpdate = true;
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
            ansMarker9.draw(batch);
            ansMarker10.draw(batch);
            ansMarker11.draw(batch);
            ansMarker12.draw(batch);
            next.draw(batch);
        }

        if (chapterSection == lastChapterSection) {
            if (!isTeacher) question.drawMultiLine(batch, tanong, questionX, questionY);
            startQuiz.draw(batch);
            backToChapters.draw(batch);
        }
	}

    @Override
    public int touchDown(float x, float y) {
    	if (soundSprite.getBoundingRectangle().contains(x, y)) {
            playSoundForSection();
        }
        if (!isTeacher && (chapterSection == 19 || chapterSection == 20)) {
            // Detect answer in question 1
            if (ansMarker.getBoundingRectangle().contains(x, y)) {
                ansMarker.setAlpha(1);
                ansMarker2.setAlpha(0);
                ansMarker3.setAlpha(0);
                ansMarker4.setAlpha(0);
                if (chapterSection == 19)
                    ans1Correct = false;
                if (chapterSection == 20)
                    ans4Correct = true;
            } else if (ansMarker2.getBoundingRectangle().contains(x, y)) {
                ansMarker.setAlpha(0);
                ansMarker2.setAlpha(1);
                ansMarker3.setAlpha(0);
                ansMarker4.setAlpha(0);
                if (chapterSection == 19)
                    ans1Correct = true;
                if (chapterSection == 20)
                    ans4Correct = false;
            } else if (ansMarker3.getBoundingRectangle().contains(x, y)) {
                ansMarker.setAlpha(0);
                ansMarker2.setAlpha(0);
                ansMarker3.setAlpha(1);
                ansMarker4.setAlpha(0);
                ans1Correct = false;
            } else if (ansMarker4.getBoundingRectangle().contains(x, y)) {
                ansMarker.setAlpha(0);
                ansMarker2.setAlpha(0);
                ansMarker3.setAlpha(0);
                ansMarker4.setAlpha(1);
                ans1Correct = false;
            }

            // Detect answer in question 12
            if (ansMarker5.getBoundingRectangle().contains(x, y)) {
                ansMarker5.setAlpha(1);
                ansMarker6.setAlpha(0);
                ansMarker7.setAlpha(0);
                ansMarker8.setAlpha(0);
                if (chapterSection == 19)
                    ans2Correct = false;
                if (chapterSection == 20)
                    ans5Correct = true;
            } else if (ansMarker6.getBoundingRectangle().contains(x, y)) {
                ansMarker5.setAlpha(0);
                ansMarker6.setAlpha(1);
                ansMarker7.setAlpha(0);
                ansMarker8.setAlpha(0);
                ans2Correct = false;
            } else if (ansMarker7.getBoundingRectangle().contains(x, y)) {
                ansMarker5.setAlpha(0);
                ansMarker6.setAlpha(0);
                ansMarker7.setAlpha(1);
                ansMarker8.setAlpha(0);
                ans2Correct = false;
            } else if (ansMarker8.getBoundingRectangle().contains(x, y)) {
                ansMarker5.setAlpha(0);
                ansMarker6.setAlpha(0);
                ansMarker7.setAlpha(0);
                ansMarker8.setAlpha(1);
                if (chapterSection == 19)
                    ans2Correct = true;
                if (chapterSection == 20)
                    ans5Correct = false;
            }

            if (chapterSection == 19) {
                // Detect answer in question 3
                if (ansMarker9.getBoundingRectangle().contains(x, y)) {
                    ansMarker9.setAlpha(1);
                    ansMarker10.setAlpha(0);
                    ansMarker11.setAlpha(0);
                    ansMarker12.setAlpha(0);
                    ans3Correct = true;
                } else if (ansMarker10.getBoundingRectangle().contains(x, y)) {
                    ansMarker9.setAlpha(0);
                    ansMarker10.setAlpha(1);
                    ansMarker11.setAlpha(0);
                    ansMarker12.setAlpha(0);
                    ans3Correct = false;
                } else if (ansMarker11.getBoundingRectangle().contains(x, y)) {
                    ansMarker9.setAlpha(0);
                    ansMarker10.setAlpha(0);
                    ansMarker11.setAlpha(1);
                    ansMarker12.setAlpha(0);
                    ans3Correct = false;
                } else if (ansMarker12.getBoundingRectangle().contains(x, y)) {
                    ansMarker9.setAlpha(0);
                    ansMarker10.setAlpha(0);
                    ansMarker11.setAlpha(0);
                    ansMarker12.setAlpha(1);
                    ans3Correct = false;
                }
            }
        }

        if (chapterSection == lastChapterSection)
            return displayLastSectionButtons(10, 3, x, y);
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
        	bagongTaon1S.stop();
        	bagongTaon1S.play();
        	break;
        case 2:
        	bagongTaon2S.stop();
        	bagongTaon2S.play();
        	break;
        case 3:
        	bagongTaon3S.stop();
           	bagongTaon3S.play();
           	break;
        case 4:
        	salo1S.stop();
        	salo1S.play();
        	break;
        case 5:
        	salo2S.stop();
        	salo2S.play();
        	break;
        case 6:
        	salo3S.stop();
        	salo3S.play();
        	break;
        case 7:
        	galang1S.stop();
        	galang1S.play();
        	break;
        case 8:
        	galang2S.stop();
        	galang2S.play();
        	break;
        case 9:
        	galang3S.stop();
        	galang3S.play();
        	break;
        case 10:       	
        	galang4S.stop();
        	galang4S.play();
        	break;
        case 11:
        	tanggap1S.stop();
        	tanggap1S.play();
        	break;
        case 12:
        	tanggap2S.stop();
        	tanggap2S.play();
        	break;
        case 13:
        	tanggap3S.stop();
        	tanggap3S.play();
        	break;
        case 14:
        	undas1S.stop();
        	undas1S.play();
        	break;
        case 15:
        	undas2S.stop();
        	undas2S.play();
        	break;
        case 16:
        	undas3S.stop();
        	undas3S.play();
        	break;
        case 17:
        	undas4S.stop();
        	undas4S.play();
        	break;
        case 18:
        	undas5S.stop();
        	undas5S.play();
        	break;
		}
		
	}

	private void assetManager() {
        float ansMarkerX, ansMarker2X, ansMarkerY, ansMarker3Y, ansMarker5Y, ansMarker7Y, ansMarker9Y, ansMarker11Y;
		switch (chapterSection) {
		case 0:
			backgroundSprite.setTexture(introBg);
			balloonSprite.setTexture(introBalloon1);
			bagongTaon1S.stop();
			break;
		case 1:
			backgroundSprite.setTexture(bagongTaonBg);
			balloonSprite.setTexture(bagongTaonBalloon1);
			intro1S.stop();
			bagongTaon2S.stop();
			break;
		case 2:
			balloonSprite.setTexture(bagongTaonBalloon2);
			bagongTaon1S.stop();
			bagongTaon3S.stop();
			break;
		case 3:
            backgroundSprite.setTexture(bagongTaonBg);
			balloonSprite.setTexture(bagongTaonBalloon3);
			bagongTaon2S.stop();
			galang1S.stop();
			break;
		case 4:
			backgroundSprite.setTexture(paggalangBg);
			balloonSprite.setTexture(paggalangBalloon1);
			bagongTaon3S.stop();
			galang2S.stop();
			break;
		case 5:
			balloonSprite.setTexture(paggalangBalloon2);
			galang1S.stop();
			galang3S.stop();
			break;
		case 6:
			balloonSprite.setTexture(paggalangBalloon3);
			galang2S.stop();
			galang4S.stop();
			break;
		case 7:
            backgroundSprite.setTexture(paggalangBg);
			balloonSprite.setTexture(paggalangBalloon4);
			galang3S.stop();
			salo1S.stop();
			break;
		case 8:
			backgroundSprite.setTexture(salosaloBg);
			balloonSprite.setTexture(salosaloBalloon1);
			galang4S.stop();
			salo2S.stop();
			break;
		case 9:
			balloonSprite.setTexture(salosaloBalloon2);
			salo1S.stop();
			salo3S.stop();
			break;
		case 10:
            backgroundSprite.setTexture(salosaloBg);
			balloonSprite.setTexture(salosaloBalloon3);
			salo2S.stop();
			tanggap1S.stop();
			break;
		case 11:
			backgroundSprite.setTexture(bisitaBg);
			balloonSprite.setTexture(pagtanggapBalloon1);
			salo3S.stop();
			tanggap2S.stop();
			break;
		case 12:
			balloonSprite.setTexture(pagtanggapBalloon2);
			tanggap1S.stop();
			tanggap3S.stop();
			break;
		case 13:
            backgroundSprite.setTexture(bisitaBg);
			balloonSprite.setTexture(pagtanggapBalloon3);
			tanggap2S.stop();
			undas1S.stop();
			break;
		case 14:
			backgroundSprite.setTexture(undasBg);
			balloonSprite.setTexture(undasBalloon1);
			tanggap3S.stop();
			undas2S.stop();
			break;
		case 15:
			balloonSprite.setTexture(undasBalloon2);
			undas1S.stop();
			undas3S.stop();
			break;
		case 16:
			balloonSprite.setTexture(undasBalloon3);
			undas2S.stop();
			undas4S.stop();
			break;
		case 17:
			balloonSprite.setTexture(undasBalloon4);
			undas3S.stop();
			undas5S.stop();
			break;
		case 18:
            backgroundSprite.setTexture(undasBg);
			balloonSprite.setTexture(undasBalloon5);
			undas4S.stop();
            break;
        case 19: // Start of game
        	undas5S.stop();
            backgroundSprite.setTexture(question1Texture);
            ans1Correct = ans2Correct = ans3Correct = false;

            if (!isTeacher) {
                correctAnswers = 0;
                ansMarkerX = screenWidth / 3.2f;
                ansMarkerY = screenHeight / 1.488f;
                ansMarker.setPosition(ansMarkerX, ansMarkerY);
                ansMarker.setBounds(ansMarkerX, ansMarkerY, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker.setAlpha(0);

                ansMarker2X = screenWidth / 1.775f;
                ansMarker2.setPosition(ansMarker2X, ansMarkerY);
                ansMarker2.setBounds(ansMarker2X, ansMarkerY, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker2.setAlpha(0);

                ansMarker3Y = screenHeight / 1.59f;
                ansMarker3.setPosition(ansMarkerX, ansMarker3Y);
                ansMarker3.setBounds(ansMarkerX, ansMarker3Y, ansMarker3.getWidth(), ansMarker3.getHeight());
                ansMarker3.setAlpha(0);

                ansMarker4.setPosition(ansMarker2X, ansMarker3Y);
                ansMarker4.setBounds(ansMarker2X, ansMarker3Y, ansMarker4.getWidth(), ansMarker4.getHeight());
                ansMarker4.setAlpha(0);

                ansMarker5Y = screenHeight / 1.9f;
                ansMarker5.setPosition(ansMarkerX, ansMarker5Y);
                ansMarker5.setBounds(ansMarkerX, ansMarker5Y, ansMarker5.getWidth(), ansMarker5.getHeight());
                ansMarker5.setAlpha(0);

                ansMarker6.setPosition(ansMarker2X, ansMarker5Y);
                ansMarker6.setBounds(ansMarker2X, ansMarker5Y, ansMarker6.getWidth(), ansMarker6.getHeight());
                ansMarker6.setAlpha(0);

                ansMarker7Y = screenHeight / 2.045f;
                ansMarker7.setPosition(ansMarkerX, ansMarker7Y);
                ansMarker7.setBounds(ansMarkerX, ansMarker7Y, ansMarker7.getWidth(), ansMarker7.getHeight());
                ansMarker7.setAlpha(0);

                ansMarker8.setPosition(ansMarker2X, ansMarker7Y);
                ansMarker8.setBounds(ansMarker2X, ansMarker7Y, ansMarker8.getWidth(), ansMarker8.getHeight());
                ansMarker8.setAlpha(0);

                ansMarker9Y = screenHeight / 2.602f;
                ansMarker9.setPosition(ansMarkerX, ansMarker9Y);
                ansMarker9.setBounds(ansMarkerX, ansMarker9Y, ansMarker9.getWidth(), ansMarker9.getHeight());
                ansMarker9.setAlpha(0);

                ansMarker10.setPosition(ansMarker2X, ansMarker9Y);
                ansMarker10.setBounds(ansMarker2X, ansMarker9Y, ansMarker10.getWidth(), ansMarker10.getHeight());
                ansMarker10.setAlpha(0);

                ansMarker11Y = screenHeight / 2.96f;
                ansMarker11.setPosition(ansMarkerX, ansMarker11Y);
                ansMarker11.setBounds(ansMarkerX, ansMarker11Y, ansMarker11.getWidth(), ansMarker11.getHeight());
                ansMarker11.setAlpha(0);

                ansMarker12.setPosition(ansMarker2X, ansMarker11Y);
                ansMarker12.setBounds(ansMarker2X, ansMarker11Y, ansMarker12.getWidth(), ansMarker12.getHeight());
                ansMarker12.setAlpha(0);
            }
            break;
        case 20:
            if (!isTeacher) {
                if (ans1Correct) correctAnswers++;
                if (ans2Correct) correctAnswers++;
                if (ans3Correct) correctAnswers++;
                ans4Correct = ans5Correct = false;

                ansMarkerX = screenWidth / 3.2f;
                ansMarkerY = screenHeight / 1.37f;
                ansMarker.setPosition(ansMarkerX, ansMarkerY);
                ansMarker.setBounds(ansMarkerX, ansMarkerY, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker.setAlpha(0);

                ansMarker2X = screenWidth / 1.694f;
                ansMarker2.setPosition(ansMarker2X, ansMarkerY);
                ansMarker2.setBounds(ansMarker2X, ansMarkerY, ansMarker.getWidth(), ansMarker.getHeight());
                ansMarker2.setAlpha(0);

                ansMarker3Y = screenHeight / 1.49f;
                ansMarker3.setPosition(ansMarkerX, ansMarker3Y);
                ansMarker3.setBounds(ansMarkerX, ansMarker3Y, ansMarker3.getWidth(), ansMarker3.getHeight());
                ansMarker3.setAlpha(0);

                ansMarker4.setPosition(ansMarker2X, ansMarker3Y);
                ansMarker4.setBounds(ansMarker2X, ansMarker3Y, ansMarker4.getWidth(), ansMarker4.getHeight());
                ansMarker4.setAlpha(0);

                ansMarker5Y = screenHeight / 1.9f;
                ansMarker5.setPosition(ansMarkerX, ansMarker5Y);
                ansMarker5.setBounds(ansMarkerX, ansMarker5Y, ansMarker5.getWidth(), ansMarker5.getHeight());
                ansMarker5.setAlpha(0);

                ansMarker6.setPosition(ansMarker2X, ansMarker5Y);
                ansMarker6.setBounds(ansMarker2X, ansMarker5Y, ansMarker6.getWidth(), ansMarker6.getHeight());
                ansMarker6.setAlpha(0);

                ansMarker7Y = screenHeight / 2.045f;
                ansMarker7.setPosition(ansMarkerX, ansMarker7Y);
                ansMarker7.setBounds(ansMarkerX, ansMarker7Y, ansMarker7.getWidth(), ansMarker7.getHeight());
                ansMarker7.setAlpha(0);

                ansMarker8.setPosition(ansMarker2X, ansMarker7Y);
                ansMarker8.setBounds(ansMarker2X, ansMarker7Y, ansMarker8.getWidth(), ansMarker8.getHeight());
                ansMarker8.setAlpha(0);

                ansMarker9.setAlpha(0);
                ansMarker10.setAlpha(0);
                ansMarker11.setAlpha(0);
                ansMarker12.setAlpha(0);
            }

            backgroundSprite.setTexture(question2Texture);
            break;
        case 21:
            if (!isTeacher) {
                if (ans4Correct) correctAnswers++;
                if (ans5Correct) correctAnswers++;
            }
            displayQuizResult(CHAPTER_TEN_SCORE, 3);
            break;
		}
        assetNeedUpdate = false;
	}

	@Override
	public void dispose() {
		intro1S.stop();
		bagongTaon1S.stop();
		bagongTaon2S.stop();
		bagongTaon3S.stop();
		salo1S.stop();
		salo2S.stop();
		salo3S.stop();
		galang1S.stop();
		galang2S.stop();
		galang3S.stop();
		galang4S.stop();
		tanggap1S.stop();
		tanggap2S.stop();
		tanggap3S.stop();
		undas1S.stop();
		undas2S.stop();
		undas3S.stop();
		undas4S.stop();
		undas5S.stop();
		
		intro1S.dispose();
		bagongTaon1S.dispose();
		bagongTaon2S.dispose();
		bagongTaon3S.dispose();
		salo1S.dispose();
		salo2S.dispose();
		salo3S.dispose();
		galang1S.dispose();
		galang2S.dispose();
		galang3S.dispose();
		galang4S.dispose();
		tanggap1S.dispose();
		tanggap2S.dispose();
		tanggap3S.dispose();
		undas1S.dispose();
		undas2S.dispose();
		undas3S.dispose();
		undas4S.dispose();
		undas5S.dispose();
		introBg.dispose();
		bagongTaonBg.dispose();
		paggalangBg.dispose();
		salosaloBg.dispose();
		bisitaBg.dispose();
		undasBg.dispose();
		introBalloon1.dispose();
		bagongTaonBalloon1.dispose();
		bagongTaonBalloon2.dispose();
		bagongTaonBalloon3.dispose();
		salosaloBalloon1.dispose();
		salosaloBalloon2.dispose();
		salosaloBalloon3.dispose();
		paggalangBalloon1.dispose();
		paggalangBalloon2.dispose();
		paggalangBalloon3.dispose();
		paggalangBalloon4.dispose();
		pagtanggapBalloon1.dispose();
		pagtanggapBalloon2.dispose();
		pagtanggapBalloon3.dispose();
		undasBalloon1.dispose();
		undasBalloon2.dispose();
		undasBalloon3.dispose();
		undasBalloon4.dispose();
		undasBalloon5.dispose();
        question1Texture.dispose();
        question2Texture.dispose();
        if (!isTeacher) {
            markerTexture.dispose();
            nextTexture.dispose();
        }
	}

}
