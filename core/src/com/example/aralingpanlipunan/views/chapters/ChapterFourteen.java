package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import static com.example.aralingpanlipunan.android.database.DatabaseSetup.CHAPTER_FOURTEEN_SCORE;

public class ChapterFourteen extends ChapterCore {

	private Texture introBg, lupaBg1, lupaBg2, lupaBg3, tubigBg1, tubigBg2,
			tubigBg3, introBalloon1, introBalloon2, bukalBalloon1,
			bukalBalloon2, bulkanBalloon1, bulkanBalloon2, bundokBalloon1,
			bundokBalloon2, burolBalloon1, burolBalloon2, burolBalloon3,
			dagatBalloon1, dagatBalloon2, ilogBalloon1, ilogBalloon2,
			ilogBalloon3, kapataganBalloon1, kapataganBalloon2,
			karagatanBalloon1, karagatanBalloon2, lambakBalloon1,
			lambakBalloon2, lawaBalloon1, lawaBalloon2, talampasBalloon1,
			talampasBalloon2, talonBalloon1, talonBalloon2, question1Bg,
			question2Bg, question3Bg, ansMarkerTexture,lupa, kapatagan, kabundukan, burol, talampas, lambak, bulkan , tubig, karagatan,
			dagat, ilog, talon,lawa, bukal;
	private Music introS, bukalS, bulkanS, bundokS, burolS, dagatS, ilogS, patagS, karagatanS, lambakS, lawaS, talampasS, talonS;
	private Sprite ans1A, ans1B, ans2A, ans2B;
	private boolean ans1Correct, ans2Correct;

	public ChapterFourteen(AndroidInterface androidInterface, boolean isTeacher) {
		super(androidInterface, isTeacher);
	}

	public ChapterFourteen(AndroidInterface androidInterface, String studentName, String password) {
		super(androidInterface, studentName, password);
	}

	@Override
	public void setUp(int screenW, int screenH) {
		super.setUp(screenW, screenH);
		startOfQuestionSection = 15;
		lastChapterSection = 18;
		
		titleBgTexture = new Texture("titlepages/chatper14.png");

		// sounds
		introS = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter14/sounds/intro1chap14.m4a"));
		bukalS = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter14/sounds/bukal1.m4a"));
		bulkanS = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter14/sounds/bulkan1.m4a"));
		bundokS = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter14/sounds/bundok1.m4a"));
		burolS = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter14/sounds/burol1.m4a"));
		dagatS = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter14/sounds/dagat1.m4a"));
		ilogS = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter14/sounds/ilog1.m4a"));
		patagS = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter14/sounds/kapatagan1.m4a"));
		karagatanS = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter14/sounds/karagatan1.m4a"));
		lambakS = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter14/sounds/lambak1.m4a"));
		lawaS = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter14/sounds/lawa1.m4a"));
		talampasS = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter14/sounds/talampas1.m4a"));
		talonS = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter14/sounds/talon1.m4a"));
		
		// backgrounds
		introBg = new Texture(
				"chapters/chapter14/backgrounds/IntroForChapter14.png");
		lupa = new Texture(
				"chapters/chapter14/backgrounds/lupa.png");
		kapatagan = new Texture("chapters/chapter14/backgrounds/kapatagan.png");
		kabundukan = new Texture("chapters/chapter14/backgrounds/kabundukan.png");
		burol  = new Texture("chapters/chapter14/backgrounds/burol.png");
		talampas = new Texture("chapters/chapter14/backgrounds/talampas.png");
		lambak = new Texture("chapters/chapter14/backgrounds/lambak.png");
		bulkan = new Texture("chapters/chapter14/backgrounds/bulkan.png");
		lupaBg1 = new Texture("chapters/chapter14/backgrounds/Lupa1.png");
		lupaBg2 = new Texture("chapters/chapter14/backgrounds/Lupa2.png");
		lupaBg3 = new Texture("chapters/chapter14/backgrounds/Lupa3.png");
		tubigBg1 = new Texture("chapters/chapter14/backgrounds/Tubig1.png");
		tubigBg2 = new Texture("chapters/chapter14/backgrounds/Tubig2.png");
		tubigBg3 = new Texture("chapters/chapter14/backgrounds/Tubig3.png");
		tubig  = new Texture("chapters/chapter14/backgrounds/tubig.png");
		karagatan = new Texture("chapters/chapter14/backgrounds/karagatan.png");
		dagat = new Texture("chapters/chapter14/backgrounds/dagat.png");
		ilog = new Texture("chapters/chapter14/backgrounds/ilog.png");
		talon = new Texture("chapters/chapter14/backgrounds/talon.png");
		lawa = new Texture("chapters/chapter14/backgrounds/lawa.png");
		bukal = new Texture("chapters/chapter14/backgrounds/bukal.png");

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
			ans1A.setSize((ans1A.getWidth() * getButtonScale()) / 1.1f,
					(ans1A.getHeight() * getButtonScale()) / 3.397f);

			ans1B = new Sprite(ansMarkerTexture);
			ans1B.setSize(ans1A.getWidth(), ans1A.getHeight());

			ans2A = new Sprite(ansMarkerTexture);
			ans2A.setSize(ans1A.getWidth(), ans1A.getHeight());

			ans2B = new Sprite(ansMarkerTexture);
			ans2B.setSize(ans1A.getWidth(), ans1A.getHeight());

			loadNextButton();
		}

		
        toggleSoundVolume();
	}

	@Override
	public void display(Batch batch) {
		if (assetNeedUpdate)
			assetManager();
		renderSharedAssets(batch);

		if (!isTeacher && chapterSection >= startOfQuestionSection
				&& chapterSection < lastChapterSection) {
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
			introS.play();
			
			break;
		case 1:
			backgroundSprite.setTexture(lupa);
			introS.stop();
			patagS.stop();
			break;
		case 2:
			backgroundSprite.setTexture(kapatagan);
			patagS.play();
			bundokS.stop();
			break;
		case 3:
			backgroundSprite.setTexture(kabundukan);
			patagS.stop();
			bundokS.play();
			burolS.stop();
			break;
		case 4:
			backgroundSprite.setTexture(burol);
			bundokS.stop();
			burolS.play();
			talampasS.stop();
			break;
		case 5:
            backgroundSprite.setTexture(talampas);
			burolS.stop();
			talampasS.play();
			lambakS.stop();
			break;
		case 6:
			backgroundSprite.setTexture(lambak);
			talampasS.stop();
			lambakS.play();
			bulkanS.stop();
			break;
		case 7:
            backgroundSprite.setTexture(bulkan);
			lambakS.stop();
			bulkanS.play();
			break;
		case 8:
			backgroundSprite.setTexture(tubig);
			bulkanS.stop();
			karagatanS.stop();
			break;
		case 9:
			backgroundSprite.setTexture(karagatan);
			karagatanS.play();
			dagatS.stop();
			break;
		case 10:
			backgroundSprite.setTexture(dagat);
			karagatanS.stop();
			dagatS.play();
			ilogS.stop();
			break;
		case 11:
			backgroundSprite.setTexture(ilog);
			dagatS.stop();
			ilogS.play();
			talonS.stop();
			break;
		
		case 12:
			backgroundSprite.setTexture(talon);
			ilogS.stop();
			talonS.play();
			lawaS.stop();
			break;
		case 13:
			backgroundSprite.setTexture(lawa);
			talonS.stop();
			lawaS.play();
			bukalS.stop();
			break;
		
		case 14:
            backgroundSprite.setTexture(bukal);
            lawaS.stop();
            bukalS.play();
			break;
		case 15: // Start of game
			introS.stop();
			bukalS.stop();
			bulkanS.stop();
			bundokS.stop();
			burolS.stop();
			dagatS.stop();
			ilogS.stop();
			patagS.stop();
			karagatanS.stop();
			lambakS.stop();
			lawaS.stop();
			talampasS.stop();
			talonS.stop();
			backgroundSprite.setTexture(question1Bg);
			if (!isTeacher) {
				ans1Correct = ans2Correct = false;
				ansXPos = screenWidth / 1.615f;
				row1 = screenHeight / 1.69f;
				row2 = screenHeight / 1.88f;
				row3 = screenHeight / 2.9f;
				row4 = screenHeight / 3.27f;

				ans1A.setPosition(ansXPos, row1);
				ans1A.setBounds(ansXPos, row1, ans1A.getWidth(),
						ans1A.getHeight());
				ans1A.setAlpha(0);

				ans1B.setPosition(ansXPos, row2);
				ans1B.setBounds(ansXPos, row2, ans1B.getWidth(),
						ans1B.getHeight());
				ans1B.setAlpha(0);

				ans2A.setPosition(ansXPos, row3);
				ans2A.setBounds(ansXPos, row3, ans2A.getWidth(),
						ans2A.getHeight());
				ans2A.setAlpha(0);

				ans2B.setPosition(ansXPos, row4);
				ans2B.setBounds(ansXPos, row4, ans2B.getWidth(),
						ans2B.getHeight());
				ans2B.setAlpha(0);
			}
			break;
		case 16:
			backgroundSprite.setTexture(question2Bg);
			if (!isTeacher) {
				if (ans1Correct)
					correctAnswers++;
				if (ans2Correct)
					correctAnswers++;
				ans1Correct = ans2Correct = false;

				ansXPos = screenWidth / 1.5f;
				row1 = screenHeight / 1.5f;
				row2 = screenHeight / 1.62f;
				row3 = screenHeight / 2.82f;
				row4 = screenHeight / 3.25f;

				ans1A.setPosition(ansXPos, row1);
				ans1A.setBounds(ansXPos, row1, ans1A.getWidth(),
						ans1A.getHeight());
				ans1A.setAlpha(0);

				ans1B.setPosition(ansXPos, row2);
				ans1B.setBounds(ansXPos, row2, ans1B.getWidth(),
						ans1B.getHeight());
				ans1B.setAlpha(0);

				ans2A.setPosition(ansXPos, row3);
				ans2A.setBounds(ansXPos, row3, ans2A.getWidth(),
						ans2A.getHeight());
				ans2A.setAlpha(0);

				ans2B.setPosition(ansXPos, row4);
				ans2B.setBounds(ansXPos, row4, ans2B.getWidth(),
						ans2B.getHeight());
				ans2B.setAlpha(0);
			}
			break;
		case 17:
			backgroundSprite.setTexture(question3Bg);
			if (!isTeacher) {
				if (ans1Correct)
					correctAnswers++;
				if (ans2Correct)
					correctAnswers++;
				ans1Correct = ans2Correct = false;

				ansXPos = screenWidth / 1.46f;
				row1 = screenHeight / 1.5f;
				row2 = screenHeight / 1.62f;
				row3 = screenHeight / 2.905f;
				row4 = screenHeight / 3.357f;

				ans1A.setPosition(ansXPos, row1);
				ans1A.setBounds(ansXPos, row1, ans1A.getWidth(),
						ans1A.getHeight());
				ans1A.setAlpha(0);

				ans1B.setPosition(ansXPos, row2);
				ans1B.setBounds(ansXPos, row2, ans1B.getWidth(),
						ans1B.getHeight());
				ans1B.setAlpha(0);

				ans2A.setPosition(ansXPos, row3);
				ans2A.setBounds(ansXPos, row3, ans2A.getWidth(),
						ans2A.getHeight());
				ans2A.setAlpha(0);

				ans2B.setPosition(ansXPos, row4);
				ans2B.setBounds(ansXPos, row4, ans2B.getWidth(),
						ans2B.getHeight());
				ans2B.setAlpha(0);
			}
			break;
		case 18:
			if (isTeacher) {
				correctAnswers = 6;
			} else {
				if (ans1Correct)
					correctAnswers++;
				if (ans2Correct)
					correctAnswers++;
			}

			displayQuizResult(CHAPTER_FOURTEEN_SCORE, 3);
			break;
		}
		assetNeedUpdate = false;
	}

	@Override
	public int touchDown(float x, float y) {
		switch (chapterSection) {
		case 15:
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
		case 16:
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
		case 17:
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
		case 18:
			return displayLastSectionButtons(14, 3, x, y);
		}
		return super.touchDown(x, y);
	}

    @Override
    protected void toggleSoundVolume() {
      
        introS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		bukalS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		bulkanS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		bundokS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		burolS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		dagatS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		ilogS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		patagS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		karagatanS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		lambakS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		lawaS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		talampasS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
		talonS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
    }

    @Override
	public void dispose() {
		super.dispose();
		introS.stop();
		bukalS.stop();
		bulkanS.stop();
		bundokS.stop();
		burolS.stop();
		dagatS.stop();
		ilogS.stop();
		patagS.stop();
		karagatanS.stop();
		lambakS.stop();
		lawaS.stop();
		talampasS.stop();
		talonS.stop();

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
		
		
		lupa.dispose();
		tubig.dispose();
		kapatagan.dispose();
		kabundukan.dispose();
		burol.dispose();
		talampas.dispose();
		lambak.dispose();
		bulkan.dispose();
		karagatan.dispose();
		dagat.dispose();
		talon.dispose();
		lawa.dispose();
		bukal.dispose();
		
		
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
		if (!isTeacher)
			ansMarkerTexture.dispose();
	}
}
