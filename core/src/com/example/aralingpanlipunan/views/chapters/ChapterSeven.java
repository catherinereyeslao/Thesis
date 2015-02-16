package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import com.example.aralingpanlipunan.android.database.DatabaseSetup;

public class ChapterSeven extends ChapterCore {

	private Texture introBg, erectusBg, habilisBg, sapiensBg,
					introBalloon1, introBalloon2, erectusBalloon1, erectusBalloon2, erectusBalloon3, 
					habilisBalloon1, habilisBalloon2, sapiensBalloon1, 
					sapiensBalloon2, sapiensBalloon3, question1Bg, question2Bg, selectedAnsTexture, nextTexture;
	private Sound intro1S, intro2S, erectus1S, erectus2S, erectus3S, habilis1S, habilis2S, sapiens1S, sapiens2S, sapiens3S;
    private Sprite ans, ans2, ans3, ans4, ans5, ans6, next;
    private boolean ansTouched, ans2Touched, ans3Touched, ans4Touched, ans5Touched, ans6Touched = false;

	public ChapterSeven(AndroidInterface androidInterface, String studName) {
		super(androidInterface, studName);
	}

    public ChapterSeven(AndroidInterface androidInterface, boolean isTeacher) {
        super(androidInterface, isTeacher);
    }
	
	@Override
	public void setUp(int screenW, int screenH){
		super.setUp(screenW, screenH);
		startOfQuestionSection = 10;
        lastChapterSection = 12;
        
        //sounds
        intro1S = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter7/sounds/intro1chap7.m4a"));
        intro2S = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter7/sounds/intro2chap7.m4a"));
        erectus1S = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter7/sounds/homoerectus1.m4a"));
        erectus2S = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter7/sounds/homorectus2.m4a"));
        erectus3S = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter7/sounds/homoerectus3.m4a"));
        habilis1S = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter7/sounds/habilis1.m4a"));
        habilis2S = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter7/sounds/habilis2.m4a"));
        sapiens1S = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter7/sounds/sapiens1.m4a"));
        sapiens2S = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter7/sounds/sapiens2.m4a"));
        sapiens3S = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter7/sounds/sapiens3.m4a"));
        

		//backgrounds
		introBg = new Texture("chapters/chapter7/backgrounds/IntroForChapter7.png");
		erectusBg = new Texture("chapters/chapter7/backgrounds/ChapterSevenBackgroundErectus.png");
		habilisBg = new Texture("chapters/chapter7/backgrounds/ChapterSevenBackgroundHabilis.png");
		sapiensBg = new Texture("chapters/chapter7/backgrounds/ChapterSevenBackgroundSapiens.png");
        question1Bg = new Texture("chapters/chapter7/backgrounds/question1bg.jpg");
        question2Bg = new Texture("chapters/chapter7/backgrounds/question2bg.jpg");
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
			
		}
		
		//balloons
		introBalloon1 = new Texture("chapters/chapter7/balloons/Intro1.png");
		introBalloon2 = new Texture("chapters/chapter7/balloons/Intro2.png");
		erectusBalloon1 = new Texture("chapters/chapter7/balloons/Homoerectus1.png");
		erectusBalloon2 = new Texture("chapters/chapter7/balloons/Homoerectus2.png");
		erectusBalloon3 = new Texture("chapters/chapter7/balloons/Homoerectus3.png");
		habilisBalloon1 = new Texture("chapters/chapter7/balloons/Habilis1.png");
		habilisBalloon2 = new Texture("chapters/chapter7/balloons/Habilis2.png");
		sapiensBalloon1 = new Texture("chapters/chapter7/balloons/Sapiens1.png");
		sapiensBalloon2 = new Texture("chapters/chapter7/balloons/Sapiens2.png");
		sapiensBalloon3 = new Texture("chapters/chapter7/balloons/Sapiens3.png");

        selectedAnsTexture = new Texture("box.png");

        ans = new Sprite(selectedAnsTexture);
        ans.setSize((ans.getWidth() * getButtonScale()) * 2, (ans.getHeight() * getButtonScale()) / 3.32f);
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

        nextTexture = new Texture("buttons/enter.png");
        next = new Sprite(nextTexture);
        next.setSize(next.getWidth() * getButtonScale(), next.getHeight() * getButtonScale());
        final float nextX = (screenWidth / 1.4f);
        final float nextY = next.getHeight() / 10;
        next.setPosition(nextX, nextY);
        next.setBounds(nextX, nextY, next.getWidth(), next.getHeight());
		
		backgroundSprite.setTexture(introBg);
		balloonSprite.setTexture(introBalloon1);
	}
	
	@Override
	public void display(Batch batch){
		if (assetNeedUpdate) assetManager();
		renderSharedAssets(batch);

        switch (chapterSection) {
            case 10:
                ans.draw(batch);
                ans2.draw(batch);
                ans3.draw(batch);
                ans4.draw(batch);
                ans5.draw(batch);
                ans6.draw(batch);
                next.draw(batch);
                break;
            case 11:
                ans.draw(batch);
                ans2.draw(batch);
                ans3.draw(batch);
                ans4.draw(batch);
                next.draw(batch);
                break;
            case 12:
                question.drawMultiLine(batch, tanong, questionX, questionY);
                startQuiz.draw(batch);
                backToChapters.draw(batch);
                break;
        }
	}
	
	private void assetManager() {
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
			erectus1S.stop();
			break;
		case 2:
			backgroundSprite.setTexture(erectusBg);
			balloonSprite.setTexture(erectusBalloon1);
			intro2S.stop();
			erectus2S.stop();
			break;
		case 3:
			balloonSprite.setTexture(erectusBalloon2);
			erectus1S.stop();
			erectus3S.stop();
			break;
		case 4:
			balloonSprite.setTexture(erectusBalloon3);
			erectus2S.stop();
			habilis1S.stop();
			break;
		case 5:
			backgroundSprite.setTexture(habilisBg);
			balloonSprite.setTexture(habilisBalloon1);
			erectus3S.stop();
			habilis2S.stop();
			break;
		case 6:
			balloonSprite.setTexture(habilisBalloon2);
			habilis1S.stop();
			sapiens1S.stop();
			break;
		case 7:
			backgroundSprite.setTexture(sapiensBg);
			balloonSprite.setTexture(sapiensBalloon1);
			habilis2S.stop();
			sapiens2S.stop();
			break;
		case 8:
			balloonSprite.setTexture(sapiensBalloon2);
			sapiens1S.stop();
			sapiens3S.stop();
			break;
		case 9:
			balloonSprite.setTexture(sapiensBalloon3);
			sapiens2S.stop();
			break;
        case 10:
            backgroundSprite.setTexture(question1Bg);
            break;
        case 11:
            // Count correct answers from the first 3 questions, then hide all box markers
            if (ansTouched) correctAnswers++;
            if (ans3Touched) correctAnswers++;
            if (ans6Touched) correctAnswers++;
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
            ans2.setBounds(ans2.getX(), ans2Y, ans2.getWidth(), ans2.getHeight());

            final float ans3Y = screenHeight / 1.75f;
            ans3.setSize(ans3.getWidth() * 1.2f, ans3.getHeight());
            ans3.setY(ans3Y);
            ans3.setBounds(ans3.getX(), ans3Y, ans3.getWidth(), ans3.getHeight());

            final float ans4Y = screenHeight / 1.99f;
            ans4.setSize(ans.getWidth(), ans4.getHeight());
            ans4.setY(ans4Y);
            ans4.setBounds(ans4.getX(), ans4Y, ans4.getWidth(), ans4.getHeight());

            backgroundSprite.setTexture(question2Bg);
            break;
        case 12:
            if (ansTouched) correctAnswers++;
            if (ans3Touched) correctAnswers++;
            ansTouched = ans2Touched = ans3Touched = ans4Touched = false;
            ans.setAlpha(0);
            ans2.setAlpha(0);
            ans3.setAlpha(0);
            ans4.setAlpha(0);

            displayQuizResult(DatabaseSetup.CHAPTER_SEVEN_SCORE, 3);
            break;
		}
        assetNeedUpdate = false;
	}

    @Override
    public int touchDown(float x, float y) {
        if (chapterSection == lastChapterSection)
            return displayLastSectionButtons(7, 3, x, y);

        if (chapterSection >= startOfQuestionSection) {
            if (next.getBoundingRectangle().contains(x, y)) {
                chapterSection++;
                assetNeedUpdate = true;
            }
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
	public void dispose(){
		intro1S.stop();
        intro2S.stop();
        erectus1S.stop();
        erectus2S.stop();
        erectus3S.stop();
        habilis1S.stop();
        habilis2S.stop();
        sapiens1S.stop();
        sapiens2S.stop();
        sapiens3S.stop();
        
        intro1S.dispose();
        intro2S.dispose();
        erectus1S.dispose();
        erectus2S.dispose();
        erectus3S.dispose();
        habilis1S.dispose();
        habilis2S.dispose();
        sapiens1S.dispose();
        sapiens2S.dispose();
        sapiens3S.dispose();
		introBg.dispose();
		erectusBg.dispose();
		habilisBg.dispose();
		sapiensBg.dispose();
		introBalloon1.dispose();
		introBalloon2.dispose();
		erectusBalloon1.dispose();
		erectusBalloon2.dispose();
		erectusBalloon3.dispose();
		habilisBalloon1.dispose();
		habilisBalloon2.dispose();
		sapiensBalloon1.dispose();
		sapiensBalloon2.dispose();
		sapiensBalloon3.dispose();
		question1Bg.dispose();
        question2Bg.dispose();
        selectedAnsTexture.dispose();
        nextTexture.dispose();
	}

}
