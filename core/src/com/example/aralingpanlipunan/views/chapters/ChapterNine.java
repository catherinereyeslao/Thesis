package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.example.aralingpanlipunan.android.AndroidInterface;

public class ChapterNine extends ChapterCore {
	
	Texture introBg, blaanBg, bontocBg, ifugaoBg, itaBg, sulodBg, tboliBg,
			introBalloon1, introBalloon2, 
			atiBalloon1, atiBalloon2, atiBalloon3, blaanBalloon1, blaanBalloon2,
			blaanBalloon3, blaanBalloon4, bontocBalloon1, bontocBalloon2,
			bontocBalloon3, ifugaoBalloon1, ifugaoBalloon2, ifugaoBalloon3,
			sulodBalloon1, sulodBalloon2, sulodBalloon3, sulodBalloon4, 
			tboliBalloon1, tboliBalloon2, tboliBalloon3, tboliBalloon4;
			

	public ChapterNine(AndroidInterface androidInterface, String studName) {
		super(androidInterface, studName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setUp(int screenW, int screenH) {
		super.setUp(screenW, screenH);
		//cases +1 
		startOfQuestionSection = 24;
		
        lastChapterSection = 31;
		
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
		
		backgroundSprite.setTexture(introBg);
		balloonSprite.setTexture(introBalloon1);
	}

	@Override
	public void display(Batch batch) {
		if (assetNeedUpdate)
			assetManager();
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
		}
		
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
	}

}
