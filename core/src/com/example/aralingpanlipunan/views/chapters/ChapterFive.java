package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.example.aralingpanlipunan.android.AndroidInterface;

public class ChapterFive extends ChapterCore {
	
	private Texture introBg, mangangalakalBg, pagmiminaBg, pagsasakaBg, pangingisdaBg,
					introBalloon1, introBalloon2, mangangalakalBalloon1, mangangalakalBalloon2,
					pagmiminaBalloon, pagsasakaBalloon1, pagsasakaBalloon2, 
					pangingisdaBalloon1, pangingisdaBalloon2, gameBg; //still no manggagawa balloon, removed manggagawa bg
	
	public ChapterFive(AndroidInterface androidInterface, String studName) {
		super(androidInterface, studName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setUp(int screenW, int screenH){
		super.setUp(screenW, screenH);
		
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
		
		backgroundSprite.setTexture(introBg);
		balloonSprite.setTexture(introBalloon1);
		
	
	}

	@Override
	public void display(Batch batch){
		if (assetNeedUpdate) assetManager();
		renderSharedAssets(batch);
		
	}
	
	private void assetManager() {
		// TODO Auto-generated method stub
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
			balloonSprite.setTexture(mangangalakalBalloon2);
			break;
		case 4:
			backgroundSprite.setTexture(pagmiminaBg);
			balloonSprite.setTexture(pagmiminaBalloon);
			break;
		case 5:
			backgroundSprite.setTexture(pagsasakaBg);
			balloonSprite.setTexture(pagsasakaBalloon1);
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
		
	}

	private void setUpGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose(){
		
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
		
		
	}
}
