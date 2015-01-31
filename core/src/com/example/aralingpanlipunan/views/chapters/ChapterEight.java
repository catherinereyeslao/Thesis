package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.example.aralingpanlipunan.android.AndroidInterface;

public class ChapterEight extends ChapterCore{

	Texture introBg, paghahabiBg, pagpintaBg, panitikanBg, sayawBg,
			introBalloon1, introBalloon2, paghahabiBalloon1, paghahabiBalloon2,
			paghahabiBalloon3, paghahabiBalloon4, pagpintaBalloon1, pagpintaBalloon2,
			pagpintaBalloon3, panitikanBalloon1, panitikanBalloon2, panitikanBalloon3,
			pagsayawBalloon1, pagsayawBalloon2, pagsayawBalloon3;
	
	public ChapterEight(AndroidInterface androidInterface, String studName) {
		super(androidInterface, studName);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void setUp(int screenW, int screenH){
		super.setUp(screenW, screenH);
		startOfQuestionSection = 15;
        lastChapterSection = 21;
		
		//backgrounds
		introBg = new Texture("chapters/chapter8/backgrounds/IntroForChapter8.png");
		paghahabiBg = new Texture("chapters/chapter8/backgrounds/Background sa Paghahabi.png");
		pagpintaBg = new Texture("chapters/chapter8/backgrounds/Background sa Pagpinta.png");
		panitikanBg = new Texture("chapters/chapter8/backgrounds/Background sa Panitikan.png");
		sayawBg = new Texture("chapters/chapter8/backgrounds/Background sa Sayaw.png");
		
		//balloons
		introBalloon1 = new Texture("chapters/chapter8/balloons/Intro1.png");
		introBalloon2 = new Texture("chapters/chapter8/balloons/Intro2.png");
		paghahabiBalloon1 = new Texture("chapters/chapter8/balloons/Paghahabi1.png");
		paghahabiBalloon2 = new Texture("chapters/chapter8/balloons/Paghahabi2.png");
		paghahabiBalloon3 = new Texture("chapters/chapter8/balloons/Paghahabi3.png");
		paghahabiBalloon4 = new Texture("chapters/chapter8/balloons/Paghahabi4.png");
		pagpintaBalloon1 = new Texture("chapters/chapter8/balloons/Pagpinta1.png");
		pagpintaBalloon2 = new Texture("chapters/chapter8/balloons/Pagpinta2.png");
		pagpintaBalloon3 = new Texture("chapters/chapter8/balloons/Pagpinta3.png");
		panitikanBalloon1 = new Texture("chapters/chapter8/balloons/Panitikan1.png");
		panitikanBalloon2 = new Texture("chapters/chapter8/balloons/Panitikan2.png");
		panitikanBalloon3 = new Texture("chapters/chapter8/balloons/Panitikan3.png");
		pagsayawBalloon1 = new Texture("chapters/chapter8/balloons/Pagsayaw1.png");
		pagsayawBalloon2 = new Texture("chapters/chapter8/balloons/Pagsayaw2.png");
		pagsayawBalloon3 = new Texture("chapters/chapter8/balloons/Pagsayaw3.png");
		
		
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
			backgroundSprite.setTexture(paghahabiBg);
			balloonSprite.setTexture(paghahabiBalloon1);
			break;
		case 3:
			balloonSprite.setTexture(paghahabiBalloon2);
			break;
		case 4:
			balloonSprite.setTexture(paghahabiBalloon3);
			break;
		case 5:
			balloonSprite.setTexture(paghahabiBalloon4);
			break;
		case 6:
			backgroundSprite.setTexture(pagpintaBg);
			balloonSprite.setTexture(pagpintaBalloon1);
			break;
		case 7:
			balloonSprite.setTexture(pagpintaBalloon2);
			break;
		case 8:
			balloonSprite.setTexture(pagpintaBalloon3);
			break;
		case 9:
			backgroundSprite.setTexture(sayawBg);
			balloonSprite.setTexture(pagsayawBalloon1);
			break;
		case 10:
			balloonSprite.setTexture(pagsayawBalloon2);
			break;
		case 11:
			balloonSprite.setTexture(pagsayawBalloon3);
			break;
		case 12:
			backgroundSprite.setTexture(panitikanBg);
			balloonSprite.setTexture(panitikanBalloon1);
			break;
		case 13:
			balloonSprite.setTexture(panitikanBalloon2);
			break;
		case 14:
			balloonSprite.setTexture(panitikanBalloon3);
			break;
		}
	}
	
	@Override
	public void dispose(){
		
		introBg.dispose(); 
		paghahabiBg.dispose();
		pagpintaBg.dispose();
		panitikanBg.dispose();
		sayawBg .dispose();
		
		//balloons
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
		
	}
}
