package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import com.example.aralingpanlipunan.android.database.DatabaseSetup;
import com.example.aralingpanlipunan.utils.ScreenSizeUtil;

public class ChapterThree extends ChapterCore {

	private Texture titleBg, introBg, introBalloon, alituntunin1Bg, alituntunin2Bg, alituntunin3Bg, alituntunin4Bg, alituntunin5Bg, gameBg, answerMarker, submitTexture;
	private Sprite  ans1, ans2, ans3, ans4, ans5, ans6, ans7, ans8, ans9, submit;
	private Music introS, a1s, a2s, a3s, a4s, a5s;
	boolean ans1Touched, ans2Touched, ans3Touched, ans4Touched, ans5Touched, ans6Touched, ans7Touched, ans8Touched, ans9Touched = false;

	public ChapterThree(AndroidInterface androidInterface, String studName, String password) {
		super(androidInterface, studName, password);
	}

    public ChapterThree(AndroidInterface androidInterface, boolean isTeacher) {
        super(androidInterface, isTeacher);
    }

	@Override
	public void setUp(int screenW, int screenH){

		super.setUp(screenW, screenH);
		startOfQuestionSection = 6;
		lastChapterSection = 7;
        if (isTeacher)
            currentRecordedScore = 100;
        else
		    currentRecordedScore = android.getScoresByStudent(loggedInStudent, studentPassword).get(2); // Get Chapter 3 current score

        
        titleBgTexture = new Texture("titlepages/chapter3.png");
        
       
		introBg = new Texture("chapters/chapter3/backgrounds/IntroForChapter3.png");
		submitTexture = new Texture("buttons/enter.png");
		introBalloon = new Texture("chapters/chapter3/balloons/Intro.png");
		alituntunin1Bg = new Texture("chapters/chapter3/backgrounds/Alituntunin1.png");
		alituntunin2Bg = new Texture("chapters/chapter3/backgrounds/Alituntunin2.png");
		alituntunin3Bg = new Texture("chapters/chapter3/backgrounds/Alituntunin3.png");
		alituntunin4Bg = new Texture("chapters/chapter3/backgrounds/Alituntunin4.png");
		alituntunin5Bg = new Texture("chapters/chapter3/backgrounds/Alituntunin5.png");
		answerMarker = new Texture("mark.png");
        if (isTeacher)
            gameBg = new Texture("chapters/chapter3/answerkeys/answer.jpg");
        else
		    gameBg = new Texture("chapters/chapter3/backgrounds/gameBg.jpg");
		introS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter3/sounds/intro.amr"));
		a1s = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter3/sound2/alin1.mp3"));
		a2s = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter3/sound2/alin2.mp3"));
		a3s = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter3/sound2/alin3.mp3"));
		a4s = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter3/sound2/alin4.mp3"));
		a5s = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter3/sound2/alintuntunin5.mp3"));
		backgroundSprite.setTexture(introBg);
		balloonSprite.setTexture(introBalloon);
        setUpGame();
        toggleSoundVolume();
	}

	@Override
	public void display(Batch batch){
		if (assetNeedUpdate) assetManager();
		renderSharedAssets(batch);
		if (!isTeacher && chapterSection == startOfQuestionSection) {
			ans1.draw(batch);
			ans2.draw(batch);
			ans3.draw(batch);
			ans4.draw(batch);
			ans5.draw(batch);
			ans6.draw(batch);
			ans7.draw(batch);
			ans8.draw(batch);
			ans9.draw(batch);
			submit.draw(batch);
		}
		if (chapterSection == lastChapterSection) {
            if (!isTeacher) question.drawMultiLine(batch, tanong, questionX, questionY);
			backToChapters.draw(batch);
			startQuiz.draw(batch);
		}
	}

	private void assetManager(){
		switch (chapterSection) {
			case 0:
				backgroundSprite.setTexture(introBg);
				introS.play();
				a1s.stop();
				break;
			case 1:
				backgroundSprite.setTexture(alituntunin1Bg);
				introS.stop();
				a1s.play();
				a2s.stop();
				break;
			case 2:
				backgroundSprite.setTexture(alituntunin2Bg);
				a1s.stop();
				a2s.play();
				a3s.stop();
				break;
			case 3:
				backgroundSprite.setTexture(alituntunin3Bg);
				a2s.stop();
				a3s.play();
				a4s.stop();
				break;
			case 4:
				backgroundSprite.setTexture(alituntunin4Bg);
				a3s.stop();
				a4s.play();
				a5s.stop();
				break;
			case 5:
				backgroundSprite.setTexture(alituntunin5Bg);
				a4s.stop();
				a5s.play();
                break;
			case 6: // Start of game
                introS.stop();
				a1s.stop();
				a2s.stop();
				a3s.stop();
				a4s.stop();
				a5s.stop();
				correctAnswers = 0;
				backgroundSprite.setTexture(gameBg);
				backToChapters.setBounds(0, 0, 0, 0);
				break;
			case 7:
				if (isTeacher) {
                    correctAnswers = 6;
                } else {
                    if (ans1Touched) correctAnswers--;
                    if (ans2Touched) correctAnswers++;
                    if (ans3Touched) correctAnswers++;
                    if (ans4Touched) correctAnswers--;
                    if (ans5Touched) correctAnswers++;
                    if (ans6Touched) correctAnswers--;
                    if (ans7Touched) correctAnswers++;
                    if (ans8Touched) correctAnswers++;
                    if (ans9Touched) correctAnswers++;
                    if (correctAnswers < 0) correctAnswers = 0; // Make sure score is not negative
                }
				displayQuizResult(DatabaseSetup.CHAPTER_THREE_SCORE, 5);
				break;
		}
		assetNeedUpdate = false;
	}

	private void setUpGame() {
		ans1 = new Sprite(answerMarker);
		ans1.setSize((ans1.getWidth() * getButtonScale() * 1.17f), ans1.getHeight() * getButtonScale());
		final float ans1X = screenWidth / 3.3f;
		final float ans1Y = (screenHeight / 1.48f) - (ans1.getHeight() / 2);
		ans1.setPosition(ans1X, ans1Y);
		ans1.setAlpha(0);
		ans1.setBounds(ans1X, ans1Y, ans1.getWidth(), ans1.getHeight());

		ans2 = new Sprite(answerMarker);
		ans2.setSize((ans2.getWidth() * getButtonScale()), ans2.getHeight() * getButtonScale());
		final float ans2Y = (ans1Y - ans2.getHeight() - getAnswerSpacing());
		ans2.setPosition(ans1X, ans2Y);
		ans2.setAlpha(0);
		ans2.setBounds(ans1X, ans2Y, ans2.getWidth(), ans2.getHeight());

		ans3 = new Sprite(answerMarker);
		ans3.setSize(ans1.getWidth(), ans3.getHeight() * getButtonScale());
		final float ans3Y = (ans2Y - (ans3.getHeight() * 1.18f) - getAnswerSpacing());
		ans3.setPosition(ans1X, ans3Y);
		ans3.setAlpha(0);
		ans3.setBounds(ans1X, ans3Y, ans3.getWidth(), ans3.getHeight());

		ans4 = new Sprite(answerMarker);
		ans4.setSize(ans2.getWidth(), ans4.getHeight() * getButtonScale());
		final float ans4Y = (ans3Y - ans4.getHeight() - getAnswerSpacing());
		ans4.setPosition(ans1X, ans4Y);
		ans4.setAlpha(0);
		ans4.setBounds(ans1X, ans4Y, ans4.getWidth(), ans4.getHeight());

		ans5 = new Sprite(answerMarker);
		ans5.setSize((ans5.getWidth() * getButtonScale() * 1.7f), ans5.getHeight() * getButtonScale());
		final float ans5Y = (ans4Y - ans5.getHeight() - getAnswerSpacing());
		ans5.setPosition(ans1X, ans5Y);
		ans5.setAlpha(0);
		ans5.setBounds(ans1X, ans5Y, ans5.getWidth(), ans5.getHeight());

		ans6 = new Sprite(answerMarker);
		ans6.setSize((ans6.getWidth() * getButtonScale() * 1.17f), ans6.getHeight() * getButtonScale());
		final float ans6X = screenWidth / 1.525f;
		ans6.setPosition(ans6X, ans1Y);
		ans6.setAlpha(0);
		ans6.setBounds(ans6X, ans1Y, ans6.getWidth(), ans6.getHeight());

		ans7 = new Sprite(answerMarker);
		ans7.setSize(ans7.getWidth() * getButtonScale() * 1.32f, ans7.getHeight() * getButtonScale());
		final float ans7X = screenWidth / 1.65f;
		ans7.setPosition(ans7X, ans2Y);
		ans7.setAlpha(0);
		ans7.setBounds(ans7X, ans2Y, ans7.getWidth(), ans7.getHeight());

		ans8 = new Sprite(answerMarker);
		ans8.setSize(ans8.getWidth() * getButtonScale(), ans8.getHeight() * getButtonScale());
		final float ans8X = screenWidth / 1.435f;
		ans8.setPosition(ans8X, ans3Y);
		ans8.setAlpha(0);
		ans8.setBounds(ans8X, ans3Y, ans8.getWidth(), ans8.getHeight());

		ans9 = new Sprite(answerMarker);
		ans9.setSize(ans9.getWidth() * getButtonScale() * 1.41f, ans9.getHeight() * getButtonScale());
		final float ans9X = screenWidth / 1.72f;
		ans9.setPosition(ans9X, ans4Y);
		ans9.setAlpha(0);
		ans9.setBounds(ans9X, ans4Y, ans9.getWidth(), ans9.getHeight());

		submit = new Sprite(submitTexture);
		submit.setSize(submit.getWidth() * getButtonScale(), submit.getHeight() * getButtonScale());
		final float submitX = (screenWidth / 1.4f);
		final float submitY = submit.getHeight() / 10;
		submit.setPosition(submitX, submitY);
		submit.setBounds(submitX, submitY, submit.getWidth(), submit.getHeight());
	}

	@Override
	public int touchDown(float x, float y) {
		if (chapterSection == lastChapterSection) {
			return displayLastSectionButtons(3, 6, x, y);
		}
		if (!isTeacher && chapterSection == 6) {
			if (ans1.getBoundingRectangle().contains(x, y)) {
				ans1Touched = !ans1Touched;
				ans1.setAlpha(ans1Touched ? 0.8f : 0);
			}
			if (ans2.getBoundingRectangle().contains(x, y)) {
				ans2Touched = !ans2Touched;
				ans2.setAlpha(ans2Touched ? 0.8f : 0);
			}
			if (ans3.getBoundingRectangle().contains(x, y)) {
				ans3Touched = !ans3Touched;
				ans3.setAlpha(ans3Touched ? 0.8f : 0);
			}
			if (ans4.getBoundingRectangle().contains(x, y)) {
				ans4Touched = !ans4Touched;
				ans4.setAlpha(ans4Touched ? 0.8f : 0);
			}
			if (ans5.getBoundingRectangle().contains(x, y)) {
				ans5Touched = !ans5Touched;
				ans5.setAlpha(ans5Touched ? 0.8f : 0);
			}
			if (ans6.getBoundingRectangle().contains(x, y)) {
				ans6Touched = !ans6Touched;
				ans6.setAlpha(ans6Touched ? 0.8f : 0);
			}
			if (ans7.getBoundingRectangle().contains(x, y)) {
				ans7Touched = !ans7Touched;
				ans7.setAlpha(ans7Touched ? 0.8f : 0);
			}
			if (ans8.getBoundingRectangle().contains(x, y)) {
				ans8Touched = !ans8Touched;
				ans8.setAlpha(ans8Touched ? 0.8f : 0);
			}
			if (ans9.getBoundingRectangle().contains(x, y)) {
				ans9Touched = !ans9Touched;
				ans9.setAlpha(ans9Touched ? 0.8f : 0);
			}
			if (submit.getBoundingRectangle().contains(x, y)) {
				chapterSection++;
				assetNeedUpdate = true;
			}
			if (chapterSection == lastChapterSection) {
				displayLastSectionButtons(3, 5, x, y);
			}
		}
		return super.touchDown(x, y);
	}

    @Override
    protected void toggleSoundVolume() {
        introS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        a1s.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        a2s.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        a3s.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        a4s.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        a5s.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
    }

    @Override
	public void dispose(){
		super.dispose();
		introS.stop();
		a1s.stop();
		a2s.stop();
		a3s.stop();
		a4s.stop();
		a5s.stop();
		introBg.dispose();
		introBalloon.dispose();
		alituntunin1Bg.dispose();
		alituntunin2Bg.dispose();
		alituntunin3Bg.dispose();
		alituntunin4Bg.dispose();
		alituntunin5Bg.dispose();
		gameBg.dispose();
		answerMarker.dispose();
		submitTexture.dispose();
		introS.dispose();
		a1s.dispose();
		a2s.dispose();
		a3s.dispose();
		a4s.dispose();
		a5s.dispose();

	}

	private int getAnswerSpacing() {
		ScreenSizeUtil screenSizeUtil = new ScreenSizeUtil();
		switch (screenSizeUtil.getScreenCategory(screenWidth)) {
			case ScreenSizeUtil.LDPI:
				return -10;
			case ScreenSizeUtil.MDPI:
				return 0;
			case ScreenSizeUtil.HDPI:
				return 10;
			case ScreenSizeUtil.XHDPI:
				return 20;
			case ScreenSizeUtil.XXHDPI:
				return 25;
			default:
				return 0;
		}
	}
}
