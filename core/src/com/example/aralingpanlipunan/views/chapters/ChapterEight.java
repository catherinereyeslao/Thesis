package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.example.aralingpanlipunan.android.AndroidInterface;
import com.example.aralingpanlipunan.android.database.DatabaseSetup;

public class ChapterEight extends ChapterCore {

	private Texture introBg, paghahabiBg, pagpintaBg, panitikanBg, sayawBg,
			introBalloon1, introBalloon2, paghahabiBalloon1, paghahabiBalloon2,
			paghahabiBalloon3, paghahabiBalloon4, pagpintaBalloon1,
			pagpintaBalloon2, pagpintaBalloon3, panitikanBalloon1,
			panitikanBalloon2, panitikanBalloon3, pagsayawBalloon1,
			pagsayawBalloon2, pagsayawBalloon3, boxTexture, gameBg,
			habi1Texture, habi2Texture, painter1Texture,
			painter2Texture;
	private Music intro1S, intro2S, paghahabi1S, paghahabi2S, paghahabi3S,
			paghahabi4S, pagpinta1S, pagpinta2S, pagpinta3S, panitikan1S,
			panitikan2S, panitikan3S, pagsayaw1S, pagsayaw2S, pagsayaw3S;
	private TextureAtlas dancerAtlas, readerAtlas;
	private Animation dancerAnimation, readerAnimation;
	private Sprite box, box2, box3, box4, character, dancer, reader;
	private boolean boxTouched, box2Touched, box3Touched, box4Touched,
			renderedDancer = false;
	private float characterX, characterY, animationCounter;

	public ChapterEight(AndroidInterface androidInterface, String studName) {
		super(androidInterface, studName);
	}

	public ChapterEight(AndroidInterface androidInterface, boolean isTeacher) {
		super(androidInterface, isTeacher);
	}

	@Override
	public void setUp(int screenW, int screenH) {
		super.setUp(screenW, screenH);
		startOfQuestionSection = 15;
		lastChapterSection = 21;

		// sounds
		intro1S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter8/sounds/introchap8.m4a"));
		intro2S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter8/sounds/intro2chap8.m4a"));
		paghahabi1S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter8/sounds/paghahabi.m4a"));
		paghahabi2S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter8/sounds/paghahabi2.m4a"));
		paghahabi3S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter8/sounds/paghahabi3.m4a"));
		paghahabi4S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter8/sounds/paghahabi4.m4a"));
		pagpinta1S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter8/sounds/pagpinta1.m4a"));
		pagpinta2S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter8/sounds/pagpinta2.m4a"));
		pagpinta3S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter8/sounds/pagpinta3.m4a"));
		panitikan1S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter8/sounds/panitikan.m4a"));
		panitikan2S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter8/sounds/panitikan2.m4a"));
		panitikan3S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter8/sounds/panitikan3.m4a"));
		pagsayaw1S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter8/sounds/pagsayaw1.m4a"));
		pagsayaw2S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter8/sounds/pagsayaw2.m4a"));
		pagsayaw3S = Gdx.audio.newMusic(Gdx.files
				.internal("chapters/chapter8/sounds/pagsayaw3.m4a"));

		// backgrounds
        introBg = new Texture("chapters/chapter8/backgrounds/IntroForChapter8.png");
        if (isTeacher) {
            gameBg = new Texture("chapters/chapter8/answerkeys/answer.jpg");
        } else {
            gameBg = new Texture("chapters/chapter8/backgrounds/game.jpg");
            boxTexture = new Texture("box.png");

            box = new Sprite(boxTexture);
            box.setSize((box.getWidth() * getButtonScale()) / 1.12f,
                    (box.getWidth() * getButtonScale()) / 1.8f);
            final float boxX = (screenWidth / 2.6f) - (box.getWidth() / 2);
            final float boxY = (screenHeight / 1.6f) - (box.getHeight() / 2);
            box.setPosition(boxX, boxY);
            box.setBounds(boxX, boxY, box.getWidth(), box.getHeight());
            box.setAlpha(0);

            box2 = new Sprite(boxTexture);
            box2.setSize((box2.getWidth() * getButtonScale()) / 1.292f,
                    (box2.getWidth() * getButtonScale()) / 1.48f);
            final float box2X = (screenWidth / 1.45f) - (box2.getWidth() / 2);
            final float box2Y = (screenHeight / 1.6f) - (box2.getHeight() / 2);
            box2.setPosition(box2X, box2Y);
            box2.setBounds(box2X, box2Y, box2.getWidth(), box2.getHeight());
            box2.setAlpha(0);

            box3 = new Sprite(boxTexture);
            box3.setSize((box3.getWidth() * getButtonScale()) / 1.12f,
                    (box3.getWidth() * getButtonScale()) / 1.418f);
            final float box3X = (screenWidth / 1.81f) - (box3.getWidth() / 2);
            final float box3Y = (screenHeight / 2.7f) - (box3.getHeight() / 2);
            box3.setPosition(box3X, box3Y);
            box3.setBounds(box3X, box3Y, box3.getWidth(), box3.getHeight());
            box3.setAlpha(0);

            box4 = new Sprite(boxTexture);
            box4.setSize((box4.getWidth() * getButtonScale()) / 1.32f,
                    (box4.getWidth() * getButtonScale()) / 1.31f);
            final float box4X = (screenWidth / 1.172f) - (box4.getWidth() / 2);
            final float box4Y = (screenHeight / 2.483f) - (box4.getHeight() / 2);
            box4.setPosition(box4X, box4Y);
            box4.setBounds(box4X, box4Y, box4.getWidth(), box4.getHeight());
            box4.setAlpha(0);
        }
		paghahabiBg = new Texture(
				"chapters/chapter8/backgrounds/Background sa Paghahabi.png");
		pagpintaBg = new Texture(
				"chapters/chapter8/backgrounds/Background sa Pagpinta.png");
		panitikanBg = new Texture(
				"chapters/chapter8/backgrounds/Background sa Panitikan.png");
		sayawBg = new Texture(
				"chapters/chapter8/backgrounds/Background sa Sayaw.png");

		// balloons
		introBalloon1 = new Texture("chapters/chapter8/balloons/Intro1.png");
		introBalloon2 = new Texture("chapters/chapter8/balloons/Intro2.png");
		paghahabiBalloon1 = new Texture(
				"chapters/chapter8/balloons/Paghahabi1.png");
		paghahabiBalloon2 = new Texture(
				"chapters/chapter8/balloons/Paghahabi2.png");
		paghahabiBalloon3 = new Texture(
				"chapters/chapter8/balloons/Paghahabi3.png");
		paghahabiBalloon4 = new Texture(
				"chapters/chapter8/balloons/Paghahabi4.png");
		pagpintaBalloon1 = new Texture(
				"chapters/chapter8/balloons/Pagpinta1.png");
		pagpintaBalloon2 = new Texture(
				"chapters/chapter8/balloons/Pagpinta2.png");
		pagpintaBalloon3 = new Texture(
				"chapters/chapter8/balloons/Pagpinta3.png");
		panitikanBalloon1 = new Texture(
				"chapters/chapter8/balloons/Panitikan1.png");
		panitikanBalloon2 = new Texture(
				"chapters/chapter8/balloons/Panitikan2.png");
		panitikanBalloon3 = new Texture(
				"chapters/chapter8/balloons/Panitikan3.png");
		pagsayawBalloon1 = new Texture(
				"chapters/chapter8/balloons/Pagsayaw1.png");
		pagsayawBalloon2 = new Texture(
				"chapters/chapter8/balloons/Pagsayaw2.png");
		pagsayawBalloon3 = new Texture(
				"chapters/chapter8/balloons/Pagsayaw3.png");

		// characters
		habi1Texture = new Texture("chapters/chapter8/characters/habi1.png");
		habi2Texture = new Texture("chapters/chapter8/characters/habi2.png");
		painter1Texture = new Texture("chapters/chapter8/characters/Painter1.png");
		painter2Texture = new Texture("chapters/chapter8/characters/Painter2.png");

		character = new Sprite(habi2Texture);
		character.setSize((character.getWidth() * getButtonScale() * 1.75f),
				(character.getHeight() * getButtonScale()) * 1.75f);

		dancerAtlas = new TextureAtlas(
				"chapters/chapter8/characters/dancer.atlas");
		dancerAnimation = new Animation(0.5f, dancerAtlas.getRegions());
		dancer = new Sprite(dancerAnimation.getKeyFrames()[0]);
		dancer.setSize((dancer.getWidth() * getButtonScale()) * 1.8f,
				(dancer.getHeight() * getButtonScale()) * 1.8f);

		readerAtlas = new TextureAtlas(
				"chapters/chapter8/characters/reader.atlas");
		readerAnimation = new Animation(0.5f, readerAtlas.getRegions());
		reader = new Sprite(readerAnimation.getKeyFrames()[0]);
		reader.setSize((reader.getWidth() * getButtonScale()) * 1.3f,
				(reader.getHeight() * getButtonScale()) * 1.3f);

        loadNextButton();

		backgroundSprite.setTexture(introBg);
		balloonSprite.setTexture(introBalloon1);

	}

	@Override
	public void display(Batch batch) {
		if (assetNeedUpdate)
			assetManager();
		renderSharedAssets(batch);

        if (!viewingHelp) {
            switch (chapterSection) {
                case 2:
                    drawHabi(batch);
                    break;
                case 3:
                    drawHabi(batch);
                    break;
                case 4:
                    drawHabi(batch);
                    break;
                case 5:
                    drawHabi(batch);
                    break;
                case 6:
                    drawPainter(batch);
                    break;
                case 7:
                    drawPainter(batch);
                    break;
                case 8:
                    drawPainter(batch);
                    break;
                case 9:
                    drawDancer(batch);
                    break;
                case 10:
                    drawDancer(batch);
                    break;
                case 11:
                    drawDancer(batch);
                    break;
                case 12:
                    drawReader(batch);
                    break;
                case 13:
                    drawReader(batch);
                    break;
                case 14:
                    drawReader(batch);
                    break;
                case 15:
                    if (!isTeacher) {
                        box.draw(batch);
                        box2.draw(batch);
                        box3.draw(batch);
                        box4.draw(batch);
                        next.draw(batch);
                    }
                    break;
                case 16:
                    if (!isTeacher) question.drawMultiLine(batch, tanong, questionX, questionY);
                    startQuiz.draw(batch);
                    backToChapters.draw(batch);
                    break;
            }
        }
	}

	private void drawReader(Batch batch) {
		animationCounter += Gdx.graphics.getDeltaTime();
		reader.setRegion(readerAnimation.getKeyFrame(animationCounter, true));
		reader.draw(batch);
	}

	/**
	 * Draw a painter in the middle which will face front after few seconds
	 * 
	 * @param batch
	 *            Batch
	 */
	private void drawPainter(Batch batch) {
		if (animationCounter < 100)
			animationCounter++;
		else if (character.getTexture() == painter2Texture)
			character.setTexture(painter1Texture);

		character.draw(batch);
	}

	/**
	 * Draw naghahabi character, which will face front after few seconds
	 * 
	 * @param batch
	 *            Batch
	 */
	private void drawHabi(Batch batch) {
		if (animationCounter < 100)
			animationCounter++;
		else if (character.getTexture() == habi2Texture)
			character.setTexture(habi1Texture);

		character.draw(batch);
	}

	/**
	 * Draw an animating character moving from left until the spotlight
	 * 
	 * @param batch
	 *            Batch
	 */
	private void drawDancer(Batch batch) {
		if (characterX < screenWidth / 1.785f)
			characterX += 3;
		animationCounter += Gdx.graphics.getDeltaTime();
		dancer.setRegion(dancerAnimation.getKeyFrame(animationCounter, true));
		dancer.setPosition(characterX, characterY);
		dancer.draw(batch);

		// Always make sure girl & balloon are not covered
		girl.draw(batch);
		balloonSprite.draw(batch);
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
			paghahabi1S.stop();
			break;
		case 2:
			animationCounter = 0;
			backgroundSprite.setTexture(paghahabiBg);
			balloonSprite.setTexture(paghahabiBalloon1);
			characterX = (screenWidth / 2) - (character.getWidth() / 2);
			characterY = (screenHeight / 4) - (character.getHeight() / 2);
			character.setPosition(characterX, characterY);
			intro2S.stop();
			paghahabi2S.stop();
			break;
		case 3:
			balloonSprite.setTexture(paghahabiBalloon2);
			paghahabi1S.stop();
			paghahabi3S.stop();
			break;
		case 4:
			balloonSprite.setTexture(paghahabiBalloon3);
			paghahabi2S.stop();
			paghahabi4S.stop();
			break;
		case 5:
			backgroundSprite.setTexture(paghahabiBg);
			balloonSprite.setTexture(paghahabiBalloon4);
			character.setTexture(habi1Texture);
			characterX = (screenWidth / 2) - (character.getWidth() / 2);
			character.setPosition(characterX, characterY);
			paghahabi3S.stop();
			pagpinta1S.stop();
			break;
		case 6:
			animationCounter = 0;
			backgroundSprite.setTexture(pagpintaBg);
			balloonSprite.setTexture(pagpintaBalloon1);
			character.setTexture(painter2Texture);
			paghahabi4S.stop();
			pagpinta2S.stop();
			break;
		case 7:
			balloonSprite.setTexture(pagpintaBalloon2);
			pagpinta1S.stop();
			pagpinta3S.stop();
			break;
		case 8:
			characterY = (screenHeight / 4) - (character.getHeight() / 2);
			backgroundSprite.setTexture(pagpintaBg);
			balloonSprite.setTexture(pagpintaBalloon3);
			character.setTexture(painter2Texture);
			pagpinta2S.stop();
			pagsayaw1S.stop();
			break;
		case 9:
			if (!renderedDancer) {
				characterX = -character.getWidth();
				characterY = (screenHeight / 3) - (character.getHeight() / 2);
				renderedDancer = true;
			}
			backgroundSprite.setTexture(sayawBg);
			balloonSprite.setTexture(pagsayawBalloon1);
			pagpinta3S.stop();
			pagsayaw2S.stop();
			break;
		case 10:
			balloonSprite.setTexture(pagsayawBalloon2);
			pagsayaw1S.stop();
			pagsayaw3S.stop();
			break;
		case 11:
			backgroundSprite.setTexture(sayawBg);
			balloonSprite.setTexture(pagsayawBalloon3);
			pagsayaw2S.stop();
			panitikan1S.stop();
			break;
		case 12:
			characterX = (screenWidth / 1.5f) - (reader.getWidth() / 2);
			characterY = (screenHeight / 3) - (reader.getHeight() / 2);
			reader.setPosition(characterX, characterY);
			backgroundSprite.setTexture(panitikanBg);
			balloonSprite.setTexture(panitikanBalloon1);
			pagsayaw3S.stop();
			panitikan2S.stop();
			break;
		case 13:
			balloonSprite.setTexture(panitikanBalloon2);
			panitikan1S.stop();
			panitikan3S.stop();
			break;
		case 14:
            backgroundSprite.setTexture(panitikanBg);
			balloonSprite.setTexture(panitikanBalloon3);
			panitikan2S.stop();
			break;
		case 15:
			backgroundSprite.setTexture(gameBg);
			panitikan3S.stop();
			break;
		case 16:
            if (isTeacher) {
                correctAnswers = 4;
            } else {
                if (boxTouched)
                    correctAnswers++;
                if (box2Touched)
                    correctAnswers++;
                if (box3Touched)
                    correctAnswers++;
                if (box4Touched)
                    correctAnswers++;
            }

			displayQuizResult(DatabaseSetup.CHAPTER_EIGHT_SCORE, 2);
			break;
		}
		assetNeedUpdate = false;
	}

	@Override
	public int touchDown(float x, float y) {
		if (soundSprite.getBoundingRectangle().contains(x, y)) {
            playSoundForSection();
        }
		if (chapterSection == lastChapterSection)
			return displayLastSectionButtons(8, 2, x, y);

		if (!isTeacher && chapterSection == startOfQuestionSection) {
			if (next.getBoundingRectangle().contains(x, y)) {
				chapterSection++;
				assetNeedUpdate = true;
			}
			if (box.getBoundingRectangle().contains(x, y)) {
				boxTouched = !boxTouched;
				box.setAlpha(boxTouched ? 1 : 0);
			}
			if (box2.getBoundingRectangle().contains(x, y)) {
				box2Touched = !box2Touched;
				box2.setAlpha(box2Touched ? 1 : 0);
			}
			if (box3.getBoundingRectangle().contains(x, y)) {
				box3Touched = !box3Touched;
				box3.setAlpha(box3Touched ? 1 : 0);
			}
			if (box4.getBoundingRectangle().contains(x, y)) {
				box4Touched = !box4Touched;
				box4.setAlpha(box4Touched ? 1 : 0);
			}
		}
		return super.touchDown(x, y);
	}

	private void playSoundForSection() {
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
        	paghahabi1S.stop();
        	paghahabi1S.play();
        	break;
        case 3:
        	paghahabi2S.stop();
        	paghahabi2S.play();
        	break;
        case 4:
        	paghahabi3S.stop();
        	paghahabi3S.play();
        	break;
        case 5:
        	paghahabi4S.stop();
        	paghahabi4S.play();
        	break;
        case 6:
        	pagpinta1S.stop();
        	pagpinta1S.play();
        	break;
        case 7:
        	pagpinta2S.stop();
        	pagpinta2S.play();
        	break;
        case 8:
        	pagpinta3S.stop();
        	pagpinta3S.play();
        	break;
        case 9:
        	pagsayaw1S.stop();
        	pagsayaw1S.play();
        	break;
        case 10:
        	pagsayaw2S.stop();
        	pagsayaw2S.play();
        	break;
        case 11:
        	pagsayaw3S.stop();
        	pagsayaw3S.play();
        	break;
        case 12:
        	panitikan1S.stop();
        	panitikan1S.play();
        	break;
        case 13:
        	panitikan2S.stop();
        	panitikan2S.play();
        	break;
        case 14:
        	panitikan3S.stop();
        	panitikan3S.play();
        	break;
		}
		
	}

	@Override
	public void dispose() {
		//sounds
		intro1S.stop();
		intro2S.stop();
		paghahabi1S.stop();
		paghahabi2S.stop();
		paghahabi3S.stop();
		paghahabi4S.stop();
		pagpinta1S.stop();
		pagpinta2S.stop();
		pagpinta3S.stop();
		panitikan1S.stop();
		panitikan2S.stop();
		panitikan3S.stop();
		pagsayaw1S.stop();
		pagsayaw2S.stop();
		pagsayaw3S.stop();
		
		intro1S.dispose();
		intro2S.dispose();
		paghahabi1S.dispose();
		paghahabi2S.dispose();
		paghahabi3S.dispose();
		paghahabi4S.dispose();
		pagpinta1S.dispose();
		pagpinta2S.dispose();
		pagpinta3S.dispose();
		panitikan1S.dispose();
		panitikan2S.dispose();
		panitikan3S.dispose();
		pagsayaw1S.dispose();
		pagsayaw2S.dispose();
		pagsayaw3S.dispose();
		
		introBg.dispose();
		paghahabiBg.dispose();
		pagpintaBg.dispose();
		panitikanBg.dispose();
		sayawBg.dispose();
		gameBg.dispose();
		if (!isTeacher) boxTexture.dispose();

		// balloons
		introBalloon1.dispose();
		introBalloon2.dispose();
		paghahabiBalloon1.dispose();
		paghahabiBalloon2.dispose();
		paghahabiBalloon3.dispose();
		paghahabiBalloon4.dispose();
		pagpintaBalloon1.dispose();
		pagpintaBalloon2.dispose();
		pagpintaBalloon3.dispose();
		panitikanBalloon1.dispose();
		panitikanBalloon2.dispose();
		panitikanBalloon3.dispose();
		pagsayawBalloon1.dispose();
		pagsayawBalloon2.dispose();
		pagsayawBalloon3.dispose();

		dancerAtlas.dispose();
		readerAtlas.dispose();
	}
}
