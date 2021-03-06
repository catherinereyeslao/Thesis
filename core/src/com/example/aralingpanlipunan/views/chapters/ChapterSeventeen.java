package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import static com.example.aralingpanlipunan.android.database.DatabaseSetup.CHAPTER_SEVENTEEN_SCORE;

public class ChapterSeventeen extends ChapterCore {
	private Texture introBg, epektoBagyoBg, epektoKabuhayanBg, uriBg,
			question1Bg, question2Bg, question3Bg, intro1Balloon,
			intro2Balloon, epektoBagyo1Balloon,
			epektoBagyo2Balloon, epektoBagyo3Balloon, epektoBagyo4Balloon,
			epektoPanahon1Balloon, epektoPanahon2Balloon,
			epektoPanahon3Balloon, epektoPanahon4Balloon, uri1Balloon,
			uri2Balloon, uri3Balloon, uri4Balloon, ansMarkerTexture;
	private Sprite ans1True, ans1False, ans2True, ans2False, ans3True,
			ans3False, ans4True, ans4False, ans5True, ans5False;
	private Music introS, bagyoS, panahonS, uriS;
	private boolean ans1Correct, ans2Correct, ans3Correct, ans4Correct,
			ans5Correct;

	public ChapterSeventeen(AndroidInterface androidInterface,
			String studentName, String password) {
		super(androidInterface, studentName, password);
	}

	public ChapterSeventeen(AndroidInterface androidInterface, boolean isTeacher) {
		super(androidInterface, isTeacher);
	}

	@Override
	public void setUp(int screenW, int screenH) {
		super.setUp(screenW, screenH);
		startOfQuestionSection = 4;
		lastChapterSection = 7;
		titleBgTexture = new Texture("titlepages/chatper17.png");
		// sounds
		introS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter17/sound2/intro1chap17.mp3"));
		bagyoS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter17/sound2/bagyo1.mp3"));
		panahonS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter17/sound2/panahon1.mp3"));
		uriS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter17/sound2/uri1.mp3"));
		

		// backgrounds
		introBg = new Texture("chapters/chapter17/backgrounds/intro.png");
		epektoBagyoBg = new Texture(
				"chapters/chapter17/backgrounds/epekto-ng-bagyo.png");
		epektoKabuhayanBg = new Texture(
				"chapters/chapter17/backgrounds/epekto-sa-kabuhayan.png");
		uriBg = new Texture("chapters/chapter17/backgrounds/uri-ng-panahon.png");

		

		// questions
		if (isTeacher) {
			question1Bg = new Texture(
					"chapters/chapter17/answerkeys/answer1.jpg");
			question2Bg = new Texture(
					"chapters/chapter17/answerkeys/answer2.jpg");
			question3Bg = new Texture(
					"chapters/chapter17/answerkeys/answer3.jpg");
		} else {
			question1Bg = new Texture(
					"chapters/chapter17/backgrounds/question1.jpg");
			question2Bg = new Texture(
					"chapters/chapter17/backgrounds/question2.jpg");
			question3Bg = new Texture(
					"chapters/chapter17/backgrounds/question3.jpg");

			ansMarkerTexture = new Texture("box.png");
			ans1True = new Sprite(ansMarkerTexture);
			ans1True.setSize((ans1True.getWidth() * getButtonScale()) / 1.8f,
					(ans1True.getHeight() * getButtonScale()) / 3.397f);

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

			ans5True = new Sprite(ansMarkerTexture);
			ans5True.setSize(ans1True.getWidth(), ans1True.getHeight());

			ans5False = new Sprite(ansMarkerTexture);
			ans5False.setSize(ans1True.getWidth(), ans1True.getHeight());

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
			ans1True.draw(batch);
			ans1False.draw(batch);
			ans2True.draw(batch);
			ans2False.draw(batch);
			ans3True.draw(batch);
			ans3False.draw(batch);
			ans4True.draw(batch);
			ans4False.draw(batch);
			ans5True.draw(batch);
			ans5False.draw(batch);

			next.draw(batch);
		}

		drawQuizResult(batch);
	}

	@Override
	public void dispose() {
		super.dispose();
		introS.stop();
		panahonS.stop();
		bagyoS.stop();
		uriS.stop();
		
		introS.dispose();
		panahonS.dispose();
		bagyoS.dispose();
		uriS.dispose();
		introBg.dispose();
		epektoBagyoBg.dispose();
		epektoKabuhayanBg.dispose();
		uriBg.dispose();
		intro1Balloon.dispose();
		intro2Balloon.dispose();
		epektoBagyo1Balloon.dispose();
		epektoBagyo2Balloon.dispose();
		epektoBagyo3Balloon.dispose();
		epektoBagyo4Balloon.dispose();
		epektoPanahon1Balloon.dispose();
		epektoPanahon2Balloon.dispose();
		epektoPanahon3Balloon.dispose();
		epektoPanahon4Balloon.dispose();
		uri1Balloon.dispose();
		uri2Balloon.dispose();
		uri3Balloon.dispose();
		uri4Balloon.dispose();
		question1Bg.dispose();
		question2Bg.dispose();
		question3Bg.dispose();
		if (!isTeacher)
			ansMarkerTexture.dispose();
	}

	@Override
	public int touchDown(float x, float y) {
		switch (chapterSection) {
		case 4:
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
					ans4Correct = true;
				} else if (ans4False.getBoundingRectangle().contains(x, y)) {
					ans4True.setAlpha(0);
					ans4False.setAlpha(1);
					ans4Correct = false;
				}

				if (ans5True.getBoundingRectangle().contains(x, y)) {
					ans5True.setAlpha(1);
					ans5False.setAlpha(0);
					ans5Correct = false;
				} else if (ans5False.getBoundingRectangle().contains(x, y)) {
					ans5True.setAlpha(0);
					ans5False.setAlpha(1);
					ans5Correct = true;
				}
			}
			break;
		case 5:
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
					ans2Correct = true;
				} else if (ans2False.getBoundingRectangle().contains(x, y)) {
					ans2True.setAlpha(0);
					ans2False.setAlpha(1);
					ans2Correct = false;
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
		case 6:
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
			}
			break;
		case 7:
			return displayLastSectionButtons(17, 5, x, y);
		}
		return super.touchDown(x, y);
	}

    @Override
    protected void toggleSoundVolume() {
        introS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        bagyoS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        panahonS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        uriS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        
    }

    private void assetManager() {
		float row1, row2, row3, row4, row5, leftCol, rightCol;
		switch (chapterSection) {
		case 0:
			backgroundSprite.setTexture(introBg);
			introS.play();
			bagyoS.stop();
			break;
		
		case 1://bagyo
			backgroundSprite.setTexture(epektoBagyoBg);
			introS.stop();
			bagyoS.play();
			uriS.stop();
			break;
		case 2:// uri1
			backgroundSprite.setTexture(epektoKabuhayanBg);
			bagyoS.stop();
			uriS.play();
			panahonS.stop();
			break;
		case 3:// panahon1
			backgroundSprite.setTexture(uriBg);
			uriS.stop();
			panahonS.play();
			break;
		case 4: // Start of game
			introS.stop();
			panahonS.stop();
			bagyoS.stop();
			uriS.stop();
			backgroundSprite.setTexture(question1Bg);
			if (!isTeacher) {
				ans1Correct = ans2Correct = ans3Correct = ans4Correct = ans5Correct = false;
				leftCol = screenWidth / 3;
				rightCol = screenWidth / 1.53f;
				row1 = screenHeight / 1.48f;
				row2 = screenHeight / 1.7f;
				row3 = screenHeight / 2.06f;
				row4 = screenHeight / 2.88f;
				row5 = screenHeight / 3.9f;

				ans1True.setPosition(leftCol, row1);
				ans1True.setBounds(leftCol, row1, ans1True.getWidth(),
						ans1True.getHeight());
				ans1True.setAlpha(0);

				ans1False.setPosition(rightCol, row1);
				ans1False.setBounds(rightCol, row1, ans1False.getWidth(),
						ans1False.getHeight());
				ans1False.setAlpha(0);

				ans2True.setPosition(leftCol, row2);
				ans2True.setBounds(leftCol, row2, ans2True.getWidth(),
						ans2True.getHeight());
				ans2True.setAlpha(0);

				ans2False.setPosition(rightCol, row2);
				ans2False.setBounds(rightCol, row2, ans2False.getWidth(),
						ans2False.getHeight());
				ans2False.setAlpha(0);

				ans3True.setPosition(leftCol, row3);
				ans3True.setBounds(leftCol, row3, ans3True.getWidth(),
						ans3True.getHeight());
				ans3True.setAlpha(0);

				ans3False.setPosition(rightCol, row3);
				ans3False.setBounds(rightCol, row3, ans3False.getWidth(),
						ans3False.getHeight());
				ans3False.setAlpha(0);

				ans4True.setPosition(leftCol, row4);
				ans4True.setBounds(leftCol, row4, ans4True.getWidth(),
						ans4True.getHeight());
				ans4True.setAlpha(0);

				ans4False.setPosition(rightCol, row4);
				ans4False.setBounds(rightCol, row4, ans4False.getWidth(),
						ans4False.getHeight());
				ans4False.setAlpha(0);

				ans5True.setPosition(leftCol, row5);
				ans5True.setBounds(leftCol, row5, ans5True.getWidth(),
						ans5True.getHeight());
				ans5True.setAlpha(0);

				ans5False.setPosition(rightCol, row5);
				ans5False.setBounds(rightCol, row5, ans5False.getWidth(),
						ans5False.getHeight());
				ans5False.setAlpha(0);
			}
			break;
		case 5:
			backgroundSprite.setTexture(question2Bg);
			if (!isTeacher) {
				if (ans1Correct)
					correctAnswers++;
				if (ans2Correct)
					correctAnswers++;
				if (ans3Correct)
					correctAnswers++;
				if (ans4Correct)
					correctAnswers++;
				if (ans5Correct)
					correctAnswers++;
				ans1Correct = ans2Correct = ans3Correct = ans4Correct = ans5Correct = false;

				leftCol = screenWidth / 2.9f;
				rightCol = screenWidth / 1.53f;
				row1 = screenHeight / 1.33f;
				row2 = screenHeight / 1.8f;
				row3 = screenHeight / 2.475f;
				row4 = screenHeight / 3.7f;

				ans1True.setPosition(leftCol, row1);
				ans1True.setBounds(leftCol, row1, ans1True.getWidth(),
						ans1True.getHeight());
				ans1True.setAlpha(0);

				ans1False.setPosition(rightCol, row1);
				ans1False.setBounds(rightCol, row1, ans1False.getWidth(),
						ans1False.getHeight());
				ans1False.setAlpha(0);

				ans2True.setPosition(leftCol, row2);
				ans2True.setBounds(leftCol, row2, ans2True.getWidth(),
						ans2True.getHeight());
				ans2True.setAlpha(0);

				ans2False.setPosition(rightCol, row2);
				ans2False.setBounds(rightCol, row2, ans2False.getWidth(),
						ans2False.getHeight());
				ans2False.setAlpha(0);

				ans3True.setPosition(leftCol, row3);
				ans3True.setBounds(leftCol, row3, ans3True.getWidth(),
						ans3True.getHeight());
				ans3True.setAlpha(0);

				ans3False.setPosition(rightCol, row3);
				ans3False.setBounds(rightCol, row3, ans3False.getWidth(),
						ans3False.getHeight());
				ans3False.setAlpha(0);

				ans4True.setPosition(leftCol, row4);
				ans4True.setBounds(leftCol, row4, ans4True.getWidth(),
						ans4True.getHeight());
				ans4True.setAlpha(0);

				ans4False.setPosition(rightCol, row4);
				ans4False.setBounds(rightCol, row4, ans4False.getWidth(),
						ans4False.getHeight());
				ans4False.setAlpha(0);

				ans5True.setAlpha(0);
				ans5False.setAlpha(0);
			}
			break;
		case 6:
			backgroundSprite.setTexture(question3Bg);
			if (!isTeacher) {
				if (ans1Correct)
					correctAnswers++;
				if (ans2Correct)
					correctAnswers++;
				if (ans3Correct)
					correctAnswers++;
				if (ans4Correct)
					correctAnswers++;
				ans1Correct = ans2Correct = ans3Correct = ans4Correct = false;

				leftCol = screenWidth / 2.7f;
				rightCol = screenWidth / 1.6f;
				row1 = screenHeight / 1.5f;

				ans1True.setPosition(leftCol, row1);
				ans1True.setBounds(leftCol, row1, ans1True.getWidth(),
						ans1True.getHeight());
				ans1True.setAlpha(0);

				ans1False.setPosition(rightCol, row1);
				ans1False.setBounds(rightCol, row1, ans1False.getWidth(),
						ans1False.getHeight());
				ans1False.setAlpha(0);

				ans2True.setAlpha(0);
				ans2False.setAlpha(0);
				ans3True.setAlpha(0);
				ans3False.setAlpha(0);
				ans4True.setAlpha(0);
				ans4False.setAlpha(0);
				ans5True.setAlpha(0);
				ans5False.setAlpha(0);
			}
			break;
		case 7:
			if (isTeacher) {
				correctAnswers = 10;
			} else {
				if (ans1Correct)
					correctAnswers++;
				ans1Correct = false;
			}
			displayQuizResult(CHAPTER_SEVENTEEN_SCORE, 5);
			break;
		}
		assetNeedUpdate = false;
	}
}
