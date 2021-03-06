package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import com.example.aralingpanlipunan.android.database.DatabaseSetup;

public class ChapterSeven extends ChapterCore {

	private Texture introBg, erectusBg, habilisBg, sapiensBg, introBalloon1,
			introBalloon2, erectusBalloon1, erectusBalloon2, erectusBalloon3,
			habilisBalloon1, habilisBalloon2, sapiensBalloon1, sapiensBalloon2,
			sapiensBalloon3, question1Bg, question2Bg, selectedAnsTexture,
			erectusTexture, habilisTexture, sapiensTexture;
	private Music introS, erectusS, habilisS, sapiensS;
	private Sprite ans, ans2, ans3, ans4, ans5, ans6, extraCharacterSprite;
	private boolean ansTouched, ans2Touched, ans3Touched, ans4Touched,
			ans5Touched, ans6Touched = false;

	public ChapterSeven(AndroidInterface androidInterface, String studentName, String password) {
        super(androidInterface, studentName, password);
	}

	public ChapterSeven(AndroidInterface androidInterface, boolean isTeacher) {
		super(androidInterface, isTeacher);
	}

	@Override
	public void setUp(int screenW, int screenH) {
		super.setUp(screenW, screenH);
		startOfQuestionSection = 4;
		lastChapterSection = 6;
		
		titleBgTexture = new Texture("titlepages/chapter7.png");
		// sounds
		introS = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter7/sound2/intro1chap7.mp3"));
		habilisS = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter7/sound2/habilis1.mp3"));
		erectusS = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter7/sound2/homoerectus1.mp3"));
		sapiensS = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter7/sound2/sapiens1.mp3"));

		// backgrounds
		introBg = new Texture(
				"chapters/chapter7/backgrounds/IntroForChapter7.png");
		erectusBg = new Texture(
				"chapters/chapter7/backgrounds/ChapterSevenBackgroundErectus.png");
		habilisBg = new Texture(
				"chapters/chapter7/backgrounds/ChapterSevenBackgroundHabilis.png");
		sapiensBg = new Texture(
				"chapters/chapter7/backgrounds/ChapterSevenBackgroundSapiens.png");
		if (isTeacher) {
			question1Bg = new Texture(
					"chapters/chapter7/answerkeys/answer1.jpg");
			question2Bg = new Texture(
					"chapters/chapter7/answerkeys/answer2.jpg");

			correctAnswers = 5;
		} else {
			question1Bg = new Texture(
					"chapters/chapter7/backgrounds/question1bg.jpg");
			question2Bg = new Texture(
					"chapters/chapter7/backgrounds/question2bg.jpg");

            selectedAnsTexture = new Texture("box.png");

            ans = new Sprite(selectedAnsTexture);
            ans.setSize((ans.getWidth() * getButtonScale()) * 2,
                    (ans.getHeight() * getButtonScale()) / 3.32f);
            final float ansX = (screenWidth / 3.2f);
            final float ansY = screenHeight / 1.5f;
            ans.setPosition(ansX, ansY);
            ans.setBounds(ansX, ansY, ans.getWidth(), ans.getHeight());
            ans.setAlpha(0);

            ans2 = new Sprite(selectedAnsTexture);
            ans2.setSize(ans.getWidth(), ans.getHeight());
            final float ans2Y = screenHeight / 1.65f;
            ans2.setPosition(ansX, ans2Y);
            ans2.setBounds(ansX, ans2Y, ans2.getWidth(), ans2.getHeight());
            ans2.setAlpha(0);

            ans3 = new Sprite(selectedAnsTexture);
            ans3.setSize(ans.getWidth() * 1.08f, ans.getHeight());
            final float ans3Y = screenHeight / 2f;
            ans3.setPosition(ansX, ans3Y);
            ans3.setBounds(ansX, ans3Y, ans3.getWidth(), ans3.getHeight());
            ans3.setAlpha(0);

            ans4 = new Sprite(selectedAnsTexture);
            ans4.setSize(ans.getWidth() * 1.18f, ans.getHeight());
            final float ans4Y = screenHeight / 2.24f;
            ans4.setPosition(ansX, ans4Y);
            ans4.setBounds(ansX, ans4Y, ans4.getWidth(), ans4.getHeight());
            ans4.setAlpha(0);

            ans5 = new Sprite(selectedAnsTexture);
            ans5.setSize(ans.getWidth() * 1.35f, ans.getHeight());
            final float ans5Y = screenHeight / 2.93f;
            ans5.setPosition(ansX, ans5Y);
            ans5.setBounds(ansX, ans5Y, ans5.getWidth(), ans5.getHeight());
            ans5.setAlpha(0);

            ans6 = new Sprite(selectedAnsTexture);
            ans6.setSize(ans.getWidth() * 1.24f, ans.getHeight() * 2);
            final float ans6Y = screenHeight / 4.19f;
            ans6.setPosition(ansX, ans6Y);
            ans6.setBounds(ansX, ans6Y, ans6.getWidth(), ans6.getHeight());
            ans6.setAlpha(0);

            toggleSoundVolume();
		}

		

        // characters
        erectusTexture = new Texture("chapters/chapter7/characters/erectus.png");
        habilisTexture = new Texture("chapters/chapter7/characters/habilis.png");
        sapiensTexture = new Texture("chapters/chapter7/characters/sapiens.png");
        extraCharacterSprite = new Sprite(erectusTexture);
        extraCharacterSprite.setSize(girl.getWidth(), girl.getHeight());
        extraCharacterSprite.setPosition(screenWidth / 1.5f, screenH / 5);

		loadNextButton();

		backgroundSprite.setTexture(introBg);
		balloonSprite.setTexture(introBalloon1);
	}

	@Override
	public void display(Batch batch) {
		if (assetNeedUpdate)
			assetManager();
		renderSharedAssets(batch);

        if (chapterSection > 1 && chapterSection < startOfQuestionSection)
            extraCharacterSprite.draw(batch);

		switch (chapterSection) {
		case 4:
            if (!isTeacher) {
                ans.draw(batch);
                ans2.draw(batch);
                ans3.draw(batch);
                ans4.draw(batch);
                ans5.draw(batch);
                ans6.draw(batch);
                next.draw(batch);
            }
			break;
		case 5:
            if (!isTeacher) {
                ans.draw(batch);
                ans2.draw(batch);
                ans3.draw(batch);
                ans4.draw(batch);
                next.draw(batch);
            }
			break;
		case 6:
			if (!isTeacher) question.drawMultiLine(batch, tanong, questionX, questionY);
			startQuiz.draw(batch);
			backToChapters.draw(batch);
			break;
		}
	}

	private void assetManager() {
		switch (chapterSection) {
		case 0:
			backgroundSprite.setTexture(introBg);
			introS.play();
			erectusS.stop();
			break;

		
		case 1:
			backgroundSprite.setTexture(erectusBg);
            extraCharacterSprite.setTexture(erectusTexture);
            introS.stop();
            erectusS.play();
            habilisS.stop();
			break;
	
		case 2:
			backgroundSprite.setTexture(habilisBg);
            extraCharacterSprite.setTexture(habilisTexture);
            erectusS.stop();
           habilisS.play();
           sapiensS.stop();
			break;
		
			
		case 3:
			backgroundSprite.setTexture(sapiensBg);
            extraCharacterSprite.setTexture(sapiensTexture);
            habilisS.stop();
            sapiensS.play();
			break;
	
		case 4://game
			introS.stop();
			erectusS.stop();
			habilisS.stop();
			sapiensS.stop();
            backgroundSprite.setTexture(question1Bg);
            if (!isTeacher) {
                ansTouched = ans2Touched = ans3Touched = ans4Touched = ans5Touched = ans6Touched = false;
                ans.setAlpha(0);
                ans2.setAlpha(0);
                ans3.setAlpha(0);
                ans4.setAlpha(0);
                ans5.setAlpha(0);
                ans6.setAlpha(0);
            }
			break;
		case 5:
            if (!isTeacher) {
                // Count correct answers from the first 3 questions, then hide all
                // box markers
                if (ansTouched)
                    correctAnswers++;
                if (ans3Touched)
                    correctAnswers++;
                if (ans6Touched)
                    correctAnswers++;
                ansTouched = ans2Touched = ans3Touched = ans4Touched = ans5Touched = ans6Touched = false;
                ans.setAlpha(0);
                ans2.setAlpha(0);
                ans3.setAlpha(0);
                ans4.setAlpha(0);
                ans5.setAlpha(0);
                ans6.setAlpha(0);

                // Reposition box markers
                final float ansY = screenHeight / 1.375f;
                ans.setY(ansY);
                ans.setBounds(ans.getX(), ansY, ans.getWidth(), ans.getHeight());

                final float ans2Y = screenHeight / 1.5f;
                ans2.setSize(ans.getWidth(), ans2.getHeight());
                ans2.setY(ans2Y);
                ans2.setBounds(ans2.getX(), ans2Y, ans2.getWidth(),
                        ans2.getHeight());

                final float ans3Y = screenHeight / 1.75f;
                ans3.setSize(ans3.getWidth() * 1.2f, ans3.getHeight());
                ans3.setY(ans3Y);
                ans3.setBounds(ans3.getX(), ans3Y, ans3.getWidth(),
                        ans3.getHeight());

                final float ans4Y = screenHeight / 1.99f;
                ans4.setSize(ans.getWidth(), ans4.getHeight());
                ans4.setY(ans4Y);
                ans4.setBounds(ans4.getX(), ans4Y, ans4.getWidth(),
                        ans4.getHeight());
            }

			backgroundSprite.setTexture(question2Bg);
			break;
		case 6:
            if (!isTeacher) {
                if (ansTouched)
                    correctAnswers++;
                if (ans3Touched)
                    correctAnswers++;
                ansTouched = ans2Touched = ans3Touched = ans4Touched = false;
                ans.setAlpha(0);
                ans2.setAlpha(0);
                ans3.setAlpha(0);
                ans4.setAlpha(0);
            } else {
                correctAnswers = 6;
            }

			displayQuizResult(DatabaseSetup.CHAPTER_SEVEN_SCORE, 3);
			break;
		}
		assetNeedUpdate = false;
	}

	@Override
	public int touchDown(float x, float y) {
		if (chapterSection == lastChapterSection)
			return displayLastSectionButtons(7, 3, x, y);

		if (!isTeacher && chapterSection >= startOfQuestionSection) {
			if (ans.getBoundingRectangle().contains(x, y)) {
				ansTouched = !ansTouched;
				ans.setAlpha(ansTouched ? 1 : 0);
				ans2Touched = false;
				ans2.setAlpha(0);
			} else if (ans2.getBoundingRectangle().contains(x, y)) {
				ans2Touched = !ans2Touched;
				ans2.setAlpha(ans2Touched ? 1 : 0);
				ansTouched = false;
				ans.setAlpha(0);
			} else if (ans3.getBoundingRectangle().contains(x, y)) {
				ans3Touched = !ans3Touched;
				ans3.setAlpha(ans3Touched ? 1 : 0);
				ans4Touched = false;
				ans4.setAlpha(0);
			} else if (ans4.getBoundingRectangle().contains(x, y)) {
				ans4Touched = !ans4Touched;
				ans4.setAlpha(ans4Touched ? 1 : 0);
				ans3Touched = false;
				ans3.setAlpha(0);
			} else if (ans5.getBoundingRectangle().contains(x, y)) {
				ans5Touched = !ans5Touched;
				ans5.setAlpha(ans5Touched ? 1 : 0);
				ans6Touched = false;
				ans6.setAlpha(0);
			} else if (ans6.getBoundingRectangle().contains(x, y)) {
				ans6Touched = !ans6Touched;
				ans6.setAlpha(ans6Touched ? 1 : 0);
				ans5Touched = false;
				ans5.setAlpha(0);
			}
		}
		return super.touchDown(x, y);
	}

    @Override
    protected void toggleSoundVolume() {
        introS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        erectusS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        habilisS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        sapiensS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        
    }

    @Override
	public void dispose() {
        super.dispose();
        introS.stop();
        erectusS.stop();
        habilisS.stop();
        sapiensS.stop();
        introS.dispose();
        erectusS.dispose();
        habilisS.dispose();
        sapiensS.dispose();
		introBg.dispose();
		erectusBg.dispose();
		habilisBg.dispose();
		sapiensBg.dispose();
		question1Bg.dispose();
		question2Bg.dispose();
		if (!isTeacher) selectedAnsTexture.dispose();
	}

}
