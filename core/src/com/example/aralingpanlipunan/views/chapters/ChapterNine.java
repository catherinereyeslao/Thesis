package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;

import static com.example.aralingpanlipunan.android.database.DatabaseSetup.CHAPTER_NINE_SCORE;

public class ChapterNine extends ChapterCore {

	private Texture introBg, blaanBg, bontocBg, ifugaoBg, itaBg, sulodBg, tboliBg,
			introBalloon1, introBalloon2, 
			atiBalloon1, atiBalloon2, atiBalloon3, blaanBalloon1, blaanBalloon2,
			blaanBalloon3, blaanBalloon4, bontocBalloon1, bontocBalloon2,
			bontocBalloon3, ifugaoBalloon1, ifugaoBalloon2, ifugaoBalloon3,
			sulodBalloon1, sulodBalloon2, sulodBalloon3, sulodBalloon4, 
			tboliBalloon1, tboliBalloon2, tboliBalloon3, tboliBalloon4, question1Bg,
            question2Bg, question3Bg, ansMarkerTexture, nextTexture;
    private Sprite ansMarker, ansMarker2, ansMarker3, ansMarker4, ansMarker5, ansMarker6, ansMarker7, ansMarker8, next;
    private boolean ansMarkerTouched, ansMarker6Touched, ansMarker7Touched;


	public ChapterNine(AndroidInterface androidInterface, String studName) {
		super(androidInterface, studName);
	}

    public ChapterNine(AndroidInterface androidInterface, boolean isTeacher) {
        super(androidInterface, isTeacher);
    }

	@Override
	public void setUp(int screenW, int screenH) {
		super.setUp(screenW, screenH);
		startOfQuestionSection = 24;
        lastChapterSection = 27;
		
		//backgrounds
		introBg = new Texture("chapters/chapter9/backgrounds/IntroForChapter9.png");
		blaanBg = new Texture("chapters/chapter9/backgrounds/Blaan.png");
		bontocBg = new Texture("chapters/chapter9/backgrounds/Bontoc.png");
		ifugaoBg = new Texture("chapters/chapter9/backgrounds/Ifugao.png");
		itaBg = new Texture("chapters/chapter9/backgrounds/Ita.png");
		sulodBg = new Texture("chapters/chapter9/backgrounds/Sulod.png");
		tboliBg = new Texture("chapters/chapter9/backgrounds/Tboli.png");
		//balloons
		introBalloon1 = new Texture("chapters/chapter9/balloons/Intro1.png");
		introBalloon2 = new Texture("chapters/chapter9/balloons/Intro2.png");
		atiBalloon1 = new Texture("chapters/chapter9/balloons/Ati1.png");
		atiBalloon2 = new Texture("chapters/chapter9/balloons/Ati2.png");
		atiBalloon3 = new Texture("chapters/chapter9/balloons/Ati3.png");
		blaanBalloon1 = new Texture("chapters/chapter9/balloons/Blaan1.png");
		blaanBalloon2 = new Texture("chapters/chapter9/balloons/Blaan2.png");
		blaanBalloon3 = new Texture("chapters/chapter9/balloons/Blaan3.png");
		blaanBalloon4 = new Texture("chapters/chapter9/balloons/Blaan4.png");
		bontocBalloon1 = new Texture("chapters/chapter9/balloons/Bontoc1.png");
		bontocBalloon2 = new Texture("chapters/chapter9/balloons/Bontoc2.png");
		bontocBalloon3 = new Texture("chapters/chapter9/balloons/Bontoc3.png");
		ifugaoBalloon1 = new Texture("chapters/chapter9/balloons/Ifugao1.png");
		ifugaoBalloon2 = new Texture("chapters/chapter9/balloons/Ifugao2.png");
		ifugaoBalloon3 = new Texture("chapters/chapter9/balloons/Ifugao3.png");
		sulodBalloon1 = new Texture("chapters/chapter9/balloons/Sulod1.png");
		sulodBalloon2 = new Texture("chapters/chapter9/balloons/Sulod2.png");
		sulodBalloon3 = new Texture("chapters/chapter9/balloons/Sulod3.png");
		sulodBalloon4  = new Texture("chapters/chapter9/balloons/Sulod4.png");
		tboliBalloon1 = new Texture("chapters/chapter9/balloons/Tboli1.png");
		tboliBalloon2 = new Texture("chapters/chapter9/balloons/Tboli2.png");
		tboliBalloon3 = new Texture("chapters/chapter9/balloons/Tboli3.png");
		tboliBalloon4 = new Texture("chapters/chapter9/balloons/Tboli4.png");

        // If user type is teacher, Load answer keys backgrounds & set their score to be perfect
        if (isTeacher) {
            question1Bg = new Texture("chapters/chapter9/answerkeys/answer1.jpg");
            question2Bg = new Texture("chapters/chapter9/answerkeys/answer2.jpg");
            question3Bg = new Texture("chapters/chapter9/answerkeys/answer3.jpg");
            correctAnswers = 10;
            currentRecordedScore = 10;
        } else {
            question1Bg = new Texture("chapters/chapter9/backgrounds/question1.jpg");
            question2Bg = new Texture("chapters/chapter9/backgrounds/question2.jpg");
            question3Bg = new Texture("chapters/chapter9/backgrounds/question3.jpg");
            ansMarkerTexture = new Texture("box.png");

            ansMarker = new Sprite(ansMarkerTexture);
            ansMarker.setSize(ansMarker.getWidth() * getButtonScale(), ansMarker.getHeight() * getButtonScale() / 3.2f);
            final float ansMarkerX = (screenWidth / 1.5f) - (ansMarker.getWidth() / 2);
            final float ansMarkerY = (screenHeight / 1.55f) - (ansMarker.getHeight() / 2);
            ansMarker.setPosition(ansMarkerX, ansMarkerY);
            ansMarker.setBounds(ansMarkerX, ansMarkerY, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker.setAlpha(0);

            ansMarker2 = new Sprite(ansMarkerTexture);
            ansMarker2.setSize(ansMarker.getWidth(), ansMarker.getHeight());
            final float ansMarker2Y = (screenHeight / 1.6f) - (ansMarker2.getHeight() / 2);
            ansMarker2.setPosition(ansMarkerX, ansMarker2Y);
            ansMarker2.setBounds(ansMarkerX, ansMarker2Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker2.setAlpha(0);

            ansMarker3 = new Sprite(ansMarkerTexture);
            ansMarker3.setSize(ansMarker.getWidth(), ansMarker.getHeight());
            final float ansMarker3Y = (screenHeight / 1.75f) - (ansMarker3.getHeight() / 2);
            ansMarker3.setPosition(ansMarkerX, ansMarker3Y);
            ansMarker3.setBounds(ansMarkerX, ansMarker3Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker3.setAlpha(0);

            ansMarker4 = new Sprite(ansMarkerTexture);
            ansMarker4.setSize(ansMarker.getWidth(), ansMarker.getHeight());
            final float ansMarker4Y = (screenHeight / 1.9f) - (ansMarker4.getHeight() / 2);
            ansMarker4.setPosition(ansMarkerX, ansMarker4Y);
            ansMarker4.setBounds(ansMarkerX, ansMarker4Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker4.setAlpha(0);

            ansMarker5 = new Sprite(ansMarkerTexture);
            ansMarker5.setSize(ansMarker.getWidth(), ansMarker.getHeight());
            final float ansMarker5Y = (screenHeight / 2.15f) - (ansMarker5.getHeight() / 2);
            ansMarker5.setPosition(ansMarkerX, ansMarker5Y);
            ansMarker5.setBounds(ansMarkerX, ansMarker5Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker5.setAlpha(0);

            ansMarker6 = new Sprite(ansMarkerTexture);
            ansMarker6.setSize(ansMarker.getWidth(), ansMarker.getHeight());
            final float ansMarker6Y = (screenHeight / 2.3f) - (ansMarker6.getHeight() / 2);
            ansMarker6.setPosition(ansMarkerX, ansMarker6Y);
            ansMarker6.setBounds(ansMarkerX, ansMarker6Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker6.setAlpha(0);

            ansMarker7 = new Sprite(ansMarkerTexture);
            ansMarker7.setSize(ansMarker.getWidth(), ansMarker.getHeight());
            final float ansMarker7Y = (screenHeight / 2.45f) - (ansMarker7.getHeight() / 2);
            ansMarker7.setPosition(ansMarkerX, ansMarker7Y);
            ansMarker7.setBounds(ansMarkerX, ansMarker7Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker7.setAlpha(0);

            ansMarker8 = new Sprite(ansMarkerTexture);
            ansMarker8.setSize(ansMarker.getWidth(), ansMarker.getHeight());
            final float ansMarker8Y = (screenHeight / 2.6f) - (ansMarker8.getHeight() / 2);
            ansMarker8.setPosition(ansMarkerX, ansMarker8Y);
            ansMarker8.setBounds(ansMarkerX, ansMarker8Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker8.setAlpha(0);

            nextTexture = new Texture("buttons/enter.png");
            next = new Sprite(nextTexture);
            next.setSize(next.getWidth() * getButtonScale(), next.getHeight() * getButtonScale());
            final float nextX = (screenWidth / 1.4f);
            final float nextY = next.getHeight() / 10;
            next.setPosition(nextX, nextY);
            next.setBounds(nextX, nextY, next.getWidth(), next.getHeight());

            currentRecordedScore = android.getScoresByStudent(loggedInStudent).get(8); // Get Chapter9 score from db
        }
		
		backgroundSprite.setTexture(introBg);
		balloonSprite.setTexture(introBalloon1);
	}

	@Override
	public void display(Batch batch) {
		if (assetNeedUpdate)
			assetManager();
		renderSharedAssets(batch);

        if (chapterSection >= startOfQuestionSection && chapterSection != lastChapterSection) {
            ansMarker.draw(batch);
            ansMarker2.draw(batch);
            ansMarker3.draw(batch);
            ansMarker4.draw(batch);
            ansMarker5.draw(batch);
            ansMarker6.draw(batch);
            ansMarker7.draw(batch);
            ansMarker8.draw(batch);
            next.draw(batch);
        }

        if (chapterSection == lastChapterSection) {
            question.drawMultiLine(batch, tanong, questionX, questionY);
            startQuiz.draw(batch);
            backToChapters.draw(batch);
        }
	}

	private void assetManager() {
        float ansMarkerX, ansMarkerY, ansMarker2Y, ansMarker3Y, ansMarker4Y, ansMarker5Y, ansMarker6Y, ansMarker7Y, ansMarker8Y;
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
			backgroundSprite.setTexture(itaBg);
			balloonSprite.setTexture(atiBalloon1);
			break;
		case 3:
			
			balloonSprite.setTexture(atiBalloon2);
			break;
		case 4:
			
			balloonSprite.setTexture(atiBalloon3);
			break;
		case 5:
			backgroundSprite.setTexture(blaanBg);
			balloonSprite.setTexture(blaanBalloon1);
			break;
		case 6:
			balloonSprite.setTexture(blaanBalloon2);
			break;
		case 7:
			balloonSprite.setTexture(blaanBalloon3);
			break;
		case 8:
			balloonSprite.setTexture(blaanBalloon4);
			break;
		case 9:
			backgroundSprite.setTexture(bontocBg);
			balloonSprite.setTexture(bontocBalloon1);
			break;
		case 10:
			balloonSprite.setTexture(bontocBalloon2);
			break;
		case 11:
			balloonSprite.setTexture(bontocBalloon3);
			break;
		case 12:
			backgroundSprite.setTexture(ifugaoBg);
			balloonSprite.setTexture(ifugaoBalloon1);
			break;
		case 13:
			balloonSprite.setTexture(ifugaoBalloon2);
			break;
		case 14:
			balloonSprite.setTexture(ifugaoBalloon3);
			break;
		case 15:
			backgroundSprite.setTexture(sulodBg);
			balloonSprite.setTexture(sulodBalloon1);
			break;
		case 16:
			balloonSprite.setTexture(sulodBalloon2);
			break;
		case 17:
			balloonSprite.setTexture(sulodBalloon2);
			break;
		case 18:
			balloonSprite.setTexture(sulodBalloon3);
			break;
		case 19:
			balloonSprite.setTexture(sulodBalloon4);
			break;
		case 20:
			backgroundSprite.setTexture(tboliBg);
			balloonSprite.setTexture(tboliBalloon1);
			break;
		case 21:
			balloonSprite.setTexture(tboliBalloon2);
			break;
		case 22:
			balloonSprite.setTexture(tboliBalloon3);
			break;
		case 23:
			balloonSprite.setTexture(tboliBalloon4);
			break;
        case 24: // Start of question
            ansMarkerX = (screenWidth / 1.5f) - (ansMarker.getWidth() / 2);
            ansMarkerY = (screenHeight / 1.43f) - (ansMarker.getHeight() / 2);
            ansMarker.setPosition(ansMarkerX, ansMarkerY);
            ansMarker.setBounds(ansMarkerX, ansMarkerY, ansMarker.getWidth(), ansMarker.getHeight());

            ansMarker2Y = (screenHeight / 1.537f) - (ansMarker.getHeight() / 2);
            ansMarker2.setPosition(ansMarkerX, ansMarker2Y);
            ansMarker2.setBounds(ansMarkerX, ansMarker2Y, ansMarker.getWidth(), ansMarker.getHeight());

            ansMarker3Y = (screenHeight / 1.69f) - (ansMarker.getHeight() / 2);
            ansMarker3.setPosition(ansMarkerX, ansMarker3Y);
            ansMarker3.setBounds(ansMarkerX, ansMarker3Y, ansMarker.getWidth(), ansMarker.getHeight());

            ansMarker4Y = (screenHeight / 1.855f) - (ansMarker.getHeight() / 2);
            ansMarker4.setPosition(ansMarkerX, ansMarker4Y);
            ansMarker4.setBounds(ansMarkerX, ansMarker4Y, ansMarker.getWidth(), ansMarker.getHeight());

            ansMarker5Y = (screenHeight / 2.345f) - (ansMarker.getHeight() / 2);
            ansMarker5.setPosition(ansMarkerX, ansMarker5Y);
            ansMarker5.setBounds(ansMarkerX, ansMarker5Y, ansMarker.getWidth(), ansMarker.getHeight());

            ansMarker6Y = (screenHeight / 2.62f) - (ansMarker.getHeight() / 2);
            ansMarker6.setPosition(ansMarkerX, ansMarker6Y);
            ansMarker6.setBounds(ansMarkerX, ansMarker6Y, ansMarker.getWidth(), ansMarker.getHeight());

            ansMarker7Y = (screenHeight / 3.1f) - (ansMarker.getHeight() / 2);
            ansMarker7.setPosition(ansMarkerX, ansMarker7Y);
            ansMarker7.setBounds(ansMarkerX, ansMarker7Y, ansMarker.getWidth(), ansMarker.getHeight());

            ansMarker8Y = (screenHeight / 3.645f) - (ansMarker.getHeight() / 2);
            ansMarker8.setPosition(ansMarkerX, ansMarker8Y);
            ansMarker8.setBounds(ansMarkerX, ansMarker8Y, ansMarker.getWidth(), ansMarker.getHeight());

            backgroundSprite.setTexture(question1Bg);
            break;
        case 25:
            if (ansMarkerTouched)
                correctAnswers++;
            if (ansMarker6Touched)
                correctAnswers++;

            ansMarkerX = (screenWidth / 1.4f) - (ansMarker.getWidth() / 2);
            ansMarkerY = (screenHeight / 1.182f) - (ansMarker.getHeight() / 2);
            ansMarker.setPosition(ansMarkerX, ansMarkerY);
            ansMarker.setBounds(ansMarkerX, ansMarkerY, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker.setAlpha(0);

            ansMarker2Y = (screenHeight / 1.255f) - (ansMarker.getHeight() / 2);
            ansMarker2.setPosition(ansMarkerX, ansMarker2Y);
            ansMarker2.setBounds(ansMarkerX, ansMarker2Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker2.setAlpha(0);

            ansMarker3Y = (screenHeight / 1.3681f) - (ansMarker.getHeight() / 2);
            ansMarker3.setPosition(ansMarkerX, ansMarker3Y);
            ansMarker3.setBounds(ansMarkerX, ansMarker3Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker3.setAlpha(0);

            ansMarker4Y = (screenHeight / 1.4545f) - (ansMarker.getHeight() / 2);
            ansMarker4.setPosition(ansMarkerX, ansMarker4Y);
            ansMarker4.setBounds(ansMarkerX, ansMarker4Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker4.setAlpha(0);

            ansMarker5Y = (screenHeight / 1.9f) - (ansMarker.getHeight() / 2);
            ansMarker5.setPosition(ansMarkerX, ansMarker5Y);
            ansMarker5.setBounds(ansMarkerX, ansMarker5Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker5.setAlpha(0);

            ansMarker6Y = (screenHeight / 2.11f) - (ansMarker.getHeight() / 2);
            ansMarker6.setPosition(ansMarkerX, ansMarker6Y);
            ansMarker6.setBounds(ansMarkerX, ansMarker6Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker6.setAlpha(0);

            ansMarker7Y = (screenHeight / 2.36f) - (ansMarker.getHeight() / 2);
            ansMarker7.setPosition(ansMarkerX, ansMarker7Y);
            ansMarker7.setBounds(ansMarkerX, ansMarker7Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker7.setAlpha(0);

            ansMarker8Y = (screenHeight / 2.78f) - (ansMarker.getHeight() / 2);
            ansMarker8.setPosition(ansMarkerX, ansMarker8Y);
            ansMarker8.setBounds(ansMarkerX, ansMarker8Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker8.setAlpha(0);

            backgroundSprite.setTexture(question2Bg);
            break;
        case 26:
            if (ansMarkerTouched)
                correctAnswers++;
            if (ansMarker7Touched)
                correctAnswers++;

            ansMarkerX = (screenWidth / 1.427f) - (ansMarker.getWidth() / 2);
            ansMarkerY = (screenHeight / 1.182f) - (ansMarker.getHeight() / 2);
            ansMarker.setPosition(ansMarkerX, ansMarkerY);
            ansMarker.setBounds(ansMarkerX, ansMarkerY, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker.setAlpha(0);

            ansMarker2Y = (screenHeight / 1.255f) - (ansMarker.getHeight() / 2);
            ansMarker2.setPosition(ansMarkerX, ansMarker2Y);
            ansMarker2.setBounds(ansMarkerX, ansMarker2Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker2.setAlpha(0);

            ansMarker3Y = (screenHeight / 1.3681f) - (ansMarker.getHeight() / 2);
            ansMarker3.setPosition(ansMarkerX, ansMarker3Y);
            ansMarker3.setBounds(ansMarkerX, ansMarker3Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker3.setAlpha(0);

            ansMarker4Y = (screenHeight / 1.4545f) - (ansMarker.getHeight() / 2);
            ansMarker4.setPosition(ansMarkerX, ansMarker4Y);
            ansMarker4.setBounds(ansMarkerX, ansMarker4Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker4.setAlpha(0);

            ansMarker5Y = (screenHeight / 2.11f) - (ansMarker.getHeight() / 2);
            ansMarker5.setPosition(ansMarkerX, ansMarker5Y);
            ansMarker5.setBounds(ansMarkerX, ansMarker5Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker5.setAlpha(0);

            ansMarker6Y = (screenHeight / 2.36f) - (ansMarker.getHeight() / 2);
            ansMarker6.setPosition(ansMarkerX, ansMarker6Y);
            ansMarker6.setBounds(ansMarkerX, ansMarker6Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker6.setAlpha(0);

            ansMarker7Y = (screenHeight / 2.78f) - (ansMarker.getHeight() / 2);
            ansMarker7.setPosition(ansMarkerX, ansMarker7Y);
            ansMarker7.setBounds(ansMarkerX, ansMarker7Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker7.setAlpha(0);

            ansMarker8Y = (screenHeight / 3.227f) - (ansMarker.getHeight() / 2);
            ansMarker8.setPosition(ansMarkerX, ansMarker8Y);
            ansMarker8.setBounds(ansMarkerX, ansMarker8Y, ansMarker.getWidth(), ansMarker.getHeight());
            ansMarker8.setAlpha(0);

            backgroundSprite.setTexture(question3Bg);
            break;
        case 27:
            displayQuizResult(CHAPTER_NINE_SCORE, 3);
            break;
		}
		assetNeedUpdate = false;
	}

    @Override
    public int touchDown(float x, float y) {
        if (chapterSection >= lastChapterSection)
            return displayLastSectionButtons(9, 3, x, y);

        if (chapterSection >= startOfQuestionSection && !isTeacher) {
            if (next.getBoundingRectangle().contains(x, y)) {
                chapterSection++;
                assetNeedUpdate = true;
            }

            if (ansMarker.getBoundingRectangle().contains(x, y)) {
                ansMarker.setAlpha(1);
                ansMarker2.setAlpha(0);
                ansMarker3.setAlpha(0);
                ansMarker4.setAlpha(0);
                ansMarkerTouched = true;
            } else if (ansMarker2.getBoundingRectangle().contains(x, y)) {
                ansMarker.setAlpha(0);
                ansMarker2.setAlpha(1);
                ansMarker3.setAlpha(0);
                ansMarker4.setAlpha(0);
                ansMarkerTouched = false;
            } else if (ansMarker3.getBoundingRectangle().contains(x, y)) {
                ansMarker.setAlpha(0);
                ansMarker2.setAlpha(0);
                ansMarker3.setAlpha(1);
                ansMarker4.setAlpha(0);
                ansMarkerTouched = false;
            } else if (ansMarker4.getBoundingRectangle().contains(x, y)) {
                ansMarker.setAlpha(0);
                ansMarker2.setAlpha(0);
                ansMarker3.setAlpha(0);
                ansMarker4.setAlpha(1);
                ansMarkerTouched = false;
            }

            if (ansMarker5.getBoundingRectangle().contains(x, y)) {
                ansMarker5.setAlpha(1);
                ansMarker6.setAlpha(0);
                ansMarker7.setAlpha(0);
                ansMarker8.setAlpha(0);
                ansMarker6Touched = false;
                ansMarker7Touched = false;
            } else if (ansMarker6.getBoundingRectangle().contains(x, y)) {
                ansMarker5.setAlpha(0);
                ansMarker6.setAlpha(1);
                ansMarker7.setAlpha(0);
                ansMarker8.setAlpha(0);
                ansMarker6Touched = true;
                ansMarker7Touched = false;
            } else if (ansMarker7.getBoundingRectangle().contains(x, y)) {
                ansMarker5.setAlpha(0);
                ansMarker6.setAlpha(0);
                ansMarker7.setAlpha(1);
                ansMarker8.setAlpha(0);
                ansMarker6Touched = false;
                ansMarker7Touched = true;
            } else if (ansMarker8.getBoundingRectangle().contains(x, y)) {
                ansMarker5.setAlpha(0);
                ansMarker6.setAlpha(0);
                ansMarker7.setAlpha(0);
                ansMarker8.setAlpha(1);
                ansMarker6Touched = false;
                ansMarker7Touched = false;
            }
        }

        return super.touchDown(x, y);
    }

	@Override
	public void dispose() {
		//backgrounds
        introBg.dispose();
        blaanBg.dispose();
        bontocBg.dispose();
        ifugaoBg.dispose();
        itaBg.dispose();
        sulodBg.dispose();
        tboliBg.dispose();
        //balloons
        introBalloon1.dispose();
        introBalloon2.dispose();
        atiBalloon1.dispose();
        atiBalloon2.dispose();
        atiBalloon3.dispose();
        blaanBalloon1.dispose();
        blaanBalloon2.dispose();
        blaanBalloon3.dispose();
        blaanBalloon4.dispose();
        bontocBalloon1.dispose();
        bontocBalloon2.dispose();
        bontocBalloon3.dispose();
        ifugaoBalloon1.dispose();
        ifugaoBalloon2.dispose();
        ifugaoBalloon3.dispose();
        sulodBalloon1.dispose();
        sulodBalloon2.dispose();
        sulodBalloon3.dispose();
        sulodBalloon4.dispose();
        tboliBalloon1.dispose();
        tboliBalloon2.dispose();
        tboliBalloon3.dispose();
        tboliBalloon4.dispose();
        question1Bg.dispose();
        question2Bg.dispose();
        question3Bg.dispose();
        ansMarkerTexture.dispose();
        nextTexture.dispose();
	}

}
