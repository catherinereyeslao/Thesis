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
	private Music introS, bagongtaonS, pagdiriwangS, paggalangS, tanggapS, undasS;
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

		startOfQuestionSection = 6;
		lastChapterSection = 8;
		
		titleBgTexture = new Texture("titlepages/chapter10.png");
		introS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sounds/introchap10.m4a"));
		bagongtaonS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sound2/bagongtaon1.mp3"));
		pagdiriwangS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sound2/pagdiriwang1.mp3"));
		paggalangS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sound2/paggalang1.mp3"));
		tanggapS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sound2/pagtanggap1.mp3"));
		undasS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter10/sound2/undas1.mp3"));
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

		
        toggleSoundVolume();
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
        if (!isTeacher && (chapterSection == 6 || chapterSection == 7)) {
            // Detect answer in question 1
            if (ansMarker.getBoundingRectangle().contains(x, y)) {
                ansMarker.setAlpha(1);
                ansMarker2.setAlpha(0);
                ansMarker3.setAlpha(0);
                ansMarker4.setAlpha(0);
                if (chapterSection == 6)
                    ans1Correct = false;
                if (chapterSection == 7)
                    ans4Correct = true;
            } else if (ansMarker2.getBoundingRectangle().contains(x, y)) {
                ansMarker.setAlpha(0);
                ansMarker2.setAlpha(1);
                ansMarker3.setAlpha(0);
                ansMarker4.setAlpha(0);
                if (chapterSection == 6)
                    ans1Correct = true;
                if (chapterSection == 7)
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
                if (chapterSection == 6)
                    ans2Correct = false;
                if (chapterSection == 7)
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
                if (chapterSection == 6)
                    ans2Correct = true;
                if (chapterSection == 7)
                    ans5Correct = false;
            }

            if (chapterSection == 6) {
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

    @Override
    protected void toggleSoundVolume() {
    	introS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		bagongtaonS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		pagdiriwangS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		paggalangS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		tanggapS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		undasS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        
    }

    private void assetManager() {
        float ansMarkerX, ansMarker2X, ansMarkerY, ansMarker3Y, ansMarker5Y, ansMarker7Y, ansMarker9Y, ansMarker11Y;
		switch (chapterSection) {
		case 0:
			backgroundSprite.setTexture(introBg);
			introS.play();
			bagongtaonS.stop();
			break;
		case 1:
			backgroundSprite.setTexture(bagongTaonBg);
			introS.stop();
			bagongtaonS.play();
			paggalangS.stop();
			break;
		case 2:
			backgroundSprite.setTexture(paggalangBg);
			bagongtaonS.stop();
			paggalangS.play();
			pagdiriwangS.stop();
			break;
		
		case 3:
			backgroundSprite.setTexture(salosaloBg);
			paggalangS.stop();
			pagdiriwangS.play();
			tanggapS.stop();
			break;
		case 4:
			backgroundSprite.setTexture(bisitaBg);
			pagdiriwangS.stop();
			tanggapS.play();
			undasS.stop();
			break;
		case 5:
			backgroundSprite.setTexture(undasBg);
			tanggapS.stop();
			undasS.play();
			break;
        case 6: // Start of game
        	introS.stop();
        	bagongtaonS.stop();
        	paggalangS.stop();
        	pagdiriwangS.stop();
        	tanggapS.stop();
        	undasS.stop();
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
        case 7:
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
        case 8:
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
		introS.stop();
		bagongtaonS.stop();
		paggalangS.stop();
	    pagdiriwangS.stop();
		tanggapS.stop();
		undasS.stop();
		introS.dispose();
		bagongtaonS.dispose();
		paggalangS.dispose();
		pagdiriwangS.dispose();
		tanggapS.dispose();
		undasS.dispose();
		introBg.dispose();
		bagongTaonBg.dispose();
		paggalangBg.dispose();
		salosaloBg.dispose();
		bisitaBg.dispose();
		undasBg.dispose();

        question1Texture.dispose();
        question2Texture.dispose();
        if (!isTeacher) {
            markerTexture.dispose();
            nextTexture.dispose();
        }
	}

}
