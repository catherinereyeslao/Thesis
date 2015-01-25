package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import com.example.aralingpanlipunan.utils.ScreenSizeUtil;

public class ChapterFive extends ChapterCore {
	
	private Texture introBg, mangangalakalBg, pagmiminaBg, pagsasakaBg, pangingisdaBg,
					introBalloon1, introBalloon2, mangangalakalBalloon1, mangangalakalBalloon2,
					pagmiminaBalloon, pagsasakaBalloon1, pagsasakaBalloon2, 
					pangingisdaBalloon1, pangingisdaBalloon2, gameBg, truckTexture, minerTexture, farmerTexture; //still no manggagawa balloon, removed manggagawa bg
	private Sprite truck, miner, farmer;
	private float characterX, characterY;
	
	public ChapterFive(AndroidInterface androidInterface, String studName) {
		super(androidInterface, studName);
	}

	@Override
	public void setUp(int screenW, int screenH){
		super.setUp(screenW, screenH);
		startOfQuestionSection = 9;
		lastChapterSection = 12;
		gameBg = new Texture("chapters/chapter5/backgrounds/gameBg.jpg");
		
		//backgrounds
		introBg = new Texture("chapters/chapter5/backgrounds/IntroForChapter5.png");
		mangangalakalBg = new Texture("chapters/chapter5/backgrounds/Mangagalakal.png");
		pagmiminaBg = new Texture("chapters/chapter5/backgrounds/Pagmimina.png");
		pagsasakaBg = new Texture("chapters/chapter5/backgrounds/Pagsasaka.png");
		pangingisdaBg = new Texture("chapters/chapter5/backgrounds/Pangingisda.png");
		
		//balloons
		introBalloon1 = new Texture("chapters/chapter5/balloons/Intro1.png");
		introBalloon2 = new Texture("chapters/chapter5/balloons/Intro2.png");
		mangangalakalBalloon1 = new Texture("chapters/chapter5/balloons/Mangangalakal1.png");
		mangangalakalBalloon2 = new Texture("chapters/chapter5/balloons/Mangangalakal2.png");
		pagmiminaBalloon = new Texture("chapters/chapter5/balloons/Pagmimina.png");
		pagsasakaBalloon1 = new Texture("chapters/chapter5/balloons/Magsasaka1.png");
		pagsasakaBalloon2 = new Texture("chapters/chapter5/balloons/Magsasaka2.png");
		pangingisdaBalloon1 = new Texture("chapters/chapter5/balloons/Pangingisda1.png");
		pangingisdaBalloon2 = new Texture("chapters/chapter5/balloons/Pangingisda2.png");

		truckTexture = new Texture("chapters/chapter5/characters/truck.png");
		truck = new Sprite(truckTexture);
		truck.setSize((truck.getWidth() * getButtonScale() * 1.3f), (truck.getHeight() * getButtonScale()) * 1.3f);

		minerTexture = new Texture("chapters/chapter5/characters/miner.png");
		miner = new Sprite(minerTexture);
		miner.setSize(miner.getWidth() * getButtonScale() * 1.3f, miner.getHeight() * getButtonScale() * 1.3f);

		farmerTexture = new Texture("chapters/chapter5/characters/farmer.png");
		farmer = new Sprite(farmerTexture);
		farmer.setSize(farmer.getWidth() * getButtonScale(), farmer.getHeight() * getButtonScale());

		characterX = truck.getWidth() * -1.25f; // Start truck from outer left portion of screen
		characterY = (screenHeight / 3) - (truck.getHeight() / 2);

		backgroundSprite.setTexture(introBg);
		balloonSprite.setTexture(introBalloon1);
	}

	@Override
	public void display(Batch batch){
		if (assetNeedUpdate) assetManager();
		renderSharedAssets(batch);

		switch (chapterSection) {
			case 2:
				drawMovingTruck(batch);
				break;
			case 3:
				drawMovingTruck(batch);
				break;
			case 4:
				drawMiner(batch);
				break;
		}

		// Make sure no other characters are blocking the talkative girl and balloon
		if (chapterSection > 1 && chapterSection < startOfQuestionSection) {
			girl.draw(batch);
			balloonSprite.draw(batch);
		}
	}

	private void assetManager() {
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
			backgroundSprite.setTexture(mangangalakalBg);
			balloonSprite.setTexture(mangangalakalBalloon1);
			break;
		case 3:
			backgroundSprite.setTexture(mangangalakalBg);
			balloonSprite.setTexture(mangangalakalBalloon2);
			break;
		case 4:
			backgroundSprite.setTexture(pagmiminaBg);
			balloonSprite.setTexture(pagmiminaBalloon);
			characterX = miner.getWidth() * -1.15f;
			characterY = 0;
			break;
		case 5:
			backgroundSprite.setTexture(pagsasakaBg);
			balloonSprite.setTexture(pagsasakaBalloon1);
			characterX = farmer.getWidth() * -1.15f;
			characterY = (screenHeight / 2) - (farmer.getHeight());
			break;
		case 6:
			balloonSprite.setTexture(pagsasakaBalloon2);
			break;
		case 7:
			backgroundSprite.setTexture(pangingisdaBg);
			balloonSprite.setTexture(pangingisdaBalloon1);
			break;
		case 8:
			balloonSprite.setTexture(pangingisdaBalloon2);
			break;
		//game
		case 9:
			backgroundSprite.setTexture(gameBg);
			setUpGame();
			break;
		}
		assetNeedUpdate = false;
	}

	private void setUpGame() {

	}

	@Override
	public void dispose(){
		super.dispose();
		introBg.dispose();
		mangangalakalBg.dispose();
		pagmiminaBg.dispose();
		pagsasakaBg.dispose();
		pangingisdaBg.dispose();
		introBalloon1.dispose();
		introBalloon2.dispose();
		mangangalakalBalloon1.dispose();
		mangangalakalBalloon2.dispose();
		pagmiminaBalloon.dispose();
		pagsasakaBalloon1.dispose();
		pagsasakaBalloon2.dispose();
		pangingisdaBalloon1.dispose();
		pangingisdaBalloon2.dispose();
		gameBg.dispose();
		truckTexture.dispose();
		minerTexture.dispose();
	}

	/**
	 * Draws the moving truck from left to right. If it goes
	 * beyond the outer right screen, start it over from the left
	 * @param batch Batch
	 */
	private void drawMovingTruck(Batch batch) {
		truck.setPosition(characterX, characterY);
		truck.draw(batch);

		if (characterX > screenWidth + truck.getWidth() * 1.1f)
			truck.flip(true, false);
		if (characterX < truck.getWidth() * -1.1f) {
			truck.setFlip(false, false);
		}

		if (truck.isFlipX()) {
			characterX -= getCharacterVelocityByScreen();
			characterY = (screenHeight / 2) - (truck.getHeight() / 2);
		} else {
			characterX += getCharacterVelocityByScreen();
			characterY = (screenHeight / 3) - (truck.getHeight() / 2);
		}
	}

	/**
	 * Draw a moving miner until it reaches the right portion
	 * of the screen
	 * @param batch Batch
	 */
	private void drawMiner(Batch batch) {
		miner.setPosition(characterX, characterY);
		miner.draw(batch);

		if (characterX < screenWidth / 1.5f)
			characterX += getCharacterVelocityByScreen();
	}

	/**
	 * Get the speed of moving characters based on device's screen size
	 * @return float
	 */
	private float getCharacterVelocityByScreen() {
		ScreenSizeUtil screenSizeUtil = new ScreenSizeUtil();
		switch (screenSizeUtil.getScreenCategory(screenWidth)) {
			case ScreenSizeUtil.LDPI:
				return 2;
			case ScreenSizeUtil.MDPI:
				return 3;
			case ScreenSizeUtil.HDPI:
				return 4;
			case ScreenSizeUtil.XHDPI:
				return 4.75f;
			default:
				return 5.2f;
		}
	}
}
