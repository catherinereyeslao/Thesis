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
	private Music introS, paghahabiS, pagpintaS, panitikanS, pagsayawS;
	private TextureAtlas dancerAtlas, readerAtlas;
	private Animation dancerAnimation, readerAnimation;
	private Sprite box, box2, box3, box4, character, dancer, reader;
	private boolean boxTouched, box2Touched, box3Touched, box4Touched,
			renderedDancer = false;
	private float characterX, characterY, animationCounter;

	public ChapterEight(AndroidInterface androidInterface, String studName, String password) {
		super(androidInterface, studName, password);
	}

	public ChapterEight(AndroidInterface androidInterface, boolean isTeacher) {
		super(androidInterface, isTeacher);
	}

	@Override
	public void setUp(int screenW, int screenH) {
		super.setUp(screenW, screenH);
		startOfQuestionSection = 7;
		lastChapterSection = 8;
		titleBgTexture = new Texture("titlepages/chapter8.png");

		// sounds
		introS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter8/sound2/introchap8.mp3"));
		paghahabiS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter8/sound2/paghahabi.mp3"));
		pagpintaS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter8/sound2/pagpinta1.mp3"));
		pagsayawS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter8/sound2/pagsayaw1.mp3"));
		panitikanS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter8/sound2/panitikan.mp3"));

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
        toggleSoundVolume();

		backgroundSprite.setTexture(introBg);
		balloonSprite.setTexture(introBalloon1);

	}

	@Override
	public void display(Batch batch) {
		if (assetNeedUpdate)
			assetManager();
		renderSharedAssets(batch);

        if (!viewingSettings) {
            switch (chapterSection) {
                case 1:
                    drawHabi(batch);
                    break;
                case 2:
                    drawHabi(batch);
                    break;
                case 3:
                    drawPainter(batch);
                    break;
                case 4:
                    drawPainter(batch);
                    break;
                case 5:
                    drawDancer(batch);
                    break;
                case 6:
                    drawReader(batch);
                    break;
                case 7:
                    if (!isTeacher) {
                        box.draw(batch);
                        box2.draw(batch);
                        box3.draw(batch);
                        box4.draw(batch);
                        next.draw(batch);
                    }
                    break;
                case 8:
                    drawQuizResult(batch);
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
	 * @param batch Batch
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

	}

	private void assetManager() {
		switch (chapterSection) {
		case 0:
			backgroundSprite.setTexture(introBg);
			introS.play();
			paghahabiS.stop();
			break;
		
		case 1:
			introS.stop();
			paghahabiS.play();
			
			animationCounter = 0;
			backgroundSprite.setTexture(paghahabiBg);
			
			characterX = (screenWidth / 2) - (character.getWidth() / 2);
			characterY = (screenHeight / 4) - (character.getHeight() / 2);
			character.setPosition(characterX, characterY);
			
			break;
		
		case 2:
			pagpintaS.stop();
			backgroundSprite.setTexture(paghahabiBg);
			
			character.setTexture(habi1Texture);
			characterX = (screenWidth / 2) - (character.getWidth() / 2);
			character.setPosition(characterX, characterY);
			
			break;
		case 3:
			paghahabiS.stop();
			pagpintaS.play();
			animationCounter = 0;
			backgroundSprite.setTexture(pagpintaBg);
			
			character.setTexture(painter2Texture);
			
			break;
		
		case 4:
			pagsayawS.stop();
			characterY = (screenHeight / 4) - (character.getHeight() / 2);
			backgroundSprite.setTexture(pagpintaBg);
			
			character.setTexture(painter2Texture);
			
			break;
		case 5:
			pagpintaS.stop();
			pagsayawS.play();
			panitikanS.stop();
			if (!renderedDancer) {
				characterX = -character.getWidth();
				characterY = (screenHeight / 3) - (character.getHeight() / 2);
				renderedDancer = true;
			}
			backgroundSprite.setTexture(sayawBg);
			
			break;
		
		case 6:
			pagsayawS.stop();
			panitikanS.play();
			characterX = (screenWidth / 1.5f) - (reader.getWidth() / 2);
			characterY = (screenHeight / 3) - (reader.getHeight() / 2);
			reader.setPosition(characterX, characterY);
			backgroundSprite.setTexture(panitikanBg);
			
			break;
		
		case 7://game
			backgroundSprite.setTexture(gameBg);
			introS.stop();
			panitikanS.stop();
			pagsayawS.stop();
			pagpintaS.stop();
			paghahabiS.stop();
			break;
		case 8:
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

    @Override
    protected void toggleSoundVolume() {
       introS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        paghahabiS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        pagsayawS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        panitikanS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        pagpintaS.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
    }

    @Override
	public void dispose() {
		//sounds
    	introS.stop();
        paghahabiS.stop();
        pagsayawS.stop();
        panitikanS.stop();
        pagpintaS.stop();
        introS.dispose();
        paghahabiS.dispose();
        pagsayawS.dispose();
        panitikanS.dispose();
        pagpintaS.dispose();
		
		introBg.dispose();
		paghahabiBg.dispose();
		pagpintaBg.dispose();
		panitikanBg.dispose();
		sayawBg.dispose();
		gameBg.dispose();
		if (!isTeacher) boxTexture.dispose();

		// balloons


		dancerAtlas.dispose();
		readerAtlas.dispose();
	}
}
