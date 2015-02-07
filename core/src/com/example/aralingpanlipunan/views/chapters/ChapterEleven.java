package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.example.aralingpanlipunan.android.AndroidInterface;

public class ChapterEleven extends ChapterCore {
	Texture introBg, kalayaanBg, amaBg, guroBg, inaBg, pusoBg, mahalNaArawBg,
			paskoBg, pistaBg, santacruzanBg, introBalloon1, introBalloon2,
			kalayaanBalloon1, kalayaanBalloon2, kalayaanBalloon3,
			kalayaanBalloon4, amaBalloon1, amaBalloon2, amaBalloon3,
			amaBalloon4, guroBalloon1, guroBalloon2, guroBalloon3,
			guroBalloon4, guroBalloon5, inaBalloon1, inaBalloon2, inaBalloon3,
			pusoBalloon1, pusoBalloon2, mahalNaArawBalloon1,
			mahalNaArawBalloon2, mahalNaArawBalloon3, paskoBalloon1,
			paskoBalloon2, paskoBalloon3, pistaBalloon1, pistaBalloon2,
			pistaBalloon3, santacruzanBalloon1, santacruzanBalloon2;

	public ChapterEleven(AndroidInterface androidInterface, String studentName) {
		super(androidInterface, studentName);
	}

    public ChapterEleven(AndroidInterface androidInterface, boolean isTeacher) {
        super(androidInterface, isTeacher);
    }

	@Override
	public void setUp(int screenW, int screenH) {
		super.setUp(screenW, screenH);
		// background
		introBg = new Texture(
				"chapters/chapter11/backgrounds/IntroForChapter11.png");
		kalayaanBg = new Texture(
				"chapters/chapter11/backgrounds/Araw ng kalayaan.png");
		amaBg = new Texture(
				"chapters/chapter11/backgrounds/Araw ng mga ama.png");
		guroBg = new Texture(
				"chapters/chapter11/backgrounds/Araw ng mga guro.png");
		inaBg = new Texture(
				"chapters/chapter11/backgrounds/Araw ng mga ina.png");
		pusoBg = new Texture(
				"chapters/chapter11/backgrounds/Araw ng mga puso.png");
		mahalNaArawBg = new Texture(
				"chapters/chapter11/backgrounds/Mahal na araw.png");
		paskoBg = new Texture(
				"chapters/chapter11/backgrounds/Pasko.png");
		pistaBg = new Texture(
				"chapters/chapter11/backgrounds/Pista.png");
		santacruzanBg = new Texture(
				"chapters/chapter11/backgrounds/Santacruzan.png");
		
		//balloons
		introBalloon1 = new Texture("chapters/chapter11/balloons/Intro.png");
		introBalloon2 = new Texture("chapters/chapter11/balloons/Intro.png");
		kalayaanBalloon1 = new Texture("chapters/chapter11/balloons/Kalayaan1.png");
		kalayaanBalloon2 = new Texture("chapters/chapter11/balloons/Kalayaan2.png");
		kalayaanBalloon3 = new Texture("chapters/chapter11/balloons/Kalayaan3.png");
		kalayaanBalloon4 = new Texture("chapters/chapter11/balloons/Kalayaan4.png");
		amaBalloon1 = new Texture("chapters/chapter11/balloons/ArawNgAma1.png");
		amaBalloon2 = new Texture("chapters/chapter11/balloons/ArawNgAma2.png");
		amaBalloon3 = new Texture("chapters/chapter11/balloons/ArawNgAma3.png");
		amaBalloon4 = new Texture("chapters/chapter11/balloons/ArawNgAma4.png");
		guroBalloon1 = new Texture("chapters/chapter11/balloons/ArawNgGuro1.png");
		guroBalloon2 = new Texture("chapters/chapter11/balloons/ArawNgGuro2.png");
		guroBalloon3 = new Texture("chapters/chapter11/balloons/ArawNgGuro3.png");
		guroBalloon4 = new Texture("chapters/chapter11/balloons/ArawNgGuro4.png");
		guroBalloon5 = new Texture("chapters/chapter11/balloons/ArawNgGuro5.png");
		inaBalloon1 = new Texture("chapters/chapter11/balloons/ArawNgIna1.png");
		inaBalloon2 = new Texture("chapters/chapter11/balloons/ArawNgIna2.png");
		inaBalloon3 = new Texture("chapters/chapter11/balloons/ArawNgIna3.png");
		pusoBalloon1 = new Texture("chapters/chapter11/balloons/ArawNgPuso1.png");
		pusoBalloon2 = new Texture("chapters/chapter11/balloons/ArawNgPuso2.png");
		mahalNaArawBalloon1 = new Texture("chapters/chapter11/balloons/MahalNaAraw1.png");
		mahalNaArawBalloon2 = new Texture("chapters/chapter11/balloons/MahalNaAraw2.png");
		mahalNaArawBalloon3 = new Texture("chapters/chapter11/balloons/MahalNaAraw3.png");
		paskoBalloon1 = new Texture("chapters/chapter11/balloons/Pasko1.png");
		paskoBalloon2 = new Texture("chapters/chapter11/balloons/Pasko2.png");
		paskoBalloon3 = new Texture("chapters/chapter11/balloons/Pasko3.png");
		pistaBalloon1 = new Texture("chapters/chapter11/balloons/Pista1.png");
		pistaBalloon2 = new Texture("chapters/chapter11/balloons/Pista2.png");
		pistaBalloon3 = new Texture("chapters/chapter11/balloons/Pista3.png");
		santacruzanBalloon1 = new Texture("chapters/chapter11/balloons/Santacruzan1.png");
		santacruzanBalloon2 = new Texture("chapters/chapter11/balloons/Santacruzan2.png");
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
			backgroundSprite.setTexture(kalayaanBg);
			balloonSprite.setTexture(kalayaanBalloon1);
			break;
		case 3:
			balloonSprite.setTexture(kalayaanBalloon2);
			break;
		case 4: 
			balloonSprite.setTexture(kalayaanBalloon2);
			break;
		case 5:
			balloonSprite.setTexture(kalayaanBalloon3);
			break;
		case 6:
			balloonSprite.setTexture(kalayaanBalloon4);
			break;
		case 7:
			backgroundSprite.setTexture(amaBg);
			balloonSprite.setTexture(amaBalloon1);
			break;
		case 8:
			balloonSprite.setTexture(amaBalloon2);
			break;
		case 9:
			balloonSprite.setTexture(amaBalloon3);
			break;
		case 10:
			balloonSprite.setTexture(amaBalloon4);
			break;
		case 11:
			backgroundSprite.setTexture(guroBg);
			balloonSprite.setTexture(guroBalloon2);
			break;
		case 12:
			balloonSprite.setTexture(guroBalloon2);
			break;
		case 13:
			balloonSprite.setTexture(guroBalloon3);
			break;
		case 14:
			balloonSprite.setTexture(guroBalloon4);
			break;
		case 15:
			balloonSprite.setTexture(guroBalloon5);
			break;
		case 16: 
			backgroundSprite.setTexture(inaBg);
			balloonSprite.setTexture(inaBalloon1);
			break;
		case 17:
			balloonSprite.setTexture(inaBalloon2);
			break;
		case 18:
			balloonSprite.setTexture(inaBalloon3);
			break;
		case 19:
			backgroundSprite.setTexture(pusoBg);
			balloonSprite.setTexture(pusoBalloon1);
			break;
		case 20:
			balloonSprite.setTexture(pusoBalloon2);
			break;
		case 21:
			backgroundSprite.setTexture(mahalNaArawBg);
			balloonSprite.setTexture(mahalNaArawBalloon1);
			break;
		case 22:
			balloonSprite.setTexture(mahalNaArawBalloon2);
			break;
		case 23:
			balloonSprite.setTexture(mahalNaArawBalloon3);
			break;
		case 24:
			backgroundSprite.setTexture(paskoBg);
			balloonSprite.setTexture(paskoBalloon1);
			break;
		case 25:
			balloonSprite.setTexture(paskoBalloon2);
			break;
		case 26:
			balloonSprite.setTexture(paskoBalloon3);
			break;
		case 27:
			backgroundSprite.setTexture(pistaBg);
			balloonSprite.setTexture(pistaBalloon1);
			break;
		case 28:
			balloonSprite.setTexture(pistaBalloon2);
			break;
		case 29:
			balloonSprite.setTexture(pistaBalloon3);
			break;
		case 30:
			backgroundSprite.setTexture(santacruzanBg);
			balloonSprite.setTexture(santacruzanBalloon1);
			break;
		case 31:
			balloonSprite.setTexture(santacruzanBalloon2);
			break;
			}

	}

	@Override
	public void dispose() {
		
		introBg.dispose();
		kalayaanBg.dispose();
		amaBg.dispose();
		guroBg.dispose();
		inaBg.dispose();
		pusoBg.dispose();
		mahalNaArawBg.dispose();
		paskoBg.dispose();
		pistaBg.dispose();
		santacruzanBg.dispose();
		
		//balloons
		introBalloon1.dispose();
		introBalloon2.dispose();
		kalayaanBalloon1.dispose();
		kalayaanBalloon2.dispose();
		kalayaanBalloon3.dispose();
		kalayaanBalloon4.dispose();
		amaBalloon1.dispose();
		amaBalloon2.dispose();
		amaBalloon3.dispose();
		amaBalloon4.dispose();
		guroBalloon1.dispose();
		guroBalloon2.dispose();
		guroBalloon3.dispose();
		guroBalloon4.dispose();
		guroBalloon5.dispose();
		inaBalloon1.dispose();
		inaBalloon2.dispose();
		inaBalloon3.dispose();
		pusoBalloon1.dispose();
		pusoBalloon2.dispose();
		mahalNaArawBalloon1.dispose();
		mahalNaArawBalloon2.dispose();
		mahalNaArawBalloon3.dispose();
		paskoBalloon1.dispose();
		paskoBalloon2.dispose();
		paskoBalloon3.dispose();
		pistaBalloon1.dispose();
		pistaBalloon2.dispose();
		pistaBalloon3.dispose();
		santacruzanBalloon1.dispose();
		santacruzanBalloon2.dispose();
	}
}
