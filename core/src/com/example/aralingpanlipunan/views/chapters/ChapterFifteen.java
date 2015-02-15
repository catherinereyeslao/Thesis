package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.example.aralingpanlipunan.android.AndroidInterface;

public class ChapterFifteen extends ChapterCore {

	Texture introBg, epektoTulunganBg, gawainTulunganBg,
			tulongPangangailanganBg, pangangailanganNatinBg, introBalloon1,
			introBalloon2, epektoTulunganBalloon1, epektoTulunganBalloon2,
			epektoTulunganBalloon3, gawainTulunganBalloon1,
			gawainTulunganBalloon2, gawainTulunganBalloon3,
			gawainTulunganBalloon4, pangangailanganBalloon1,
			pangangailanganBalloon2, pangangailanganBalloon3,
			pangangailanganBalloon4, tulongPangangailanganBalloon1,
			tulongPangangailanganBalloon2, tulongPangangailanganBalloon3,
			question1Bg, question2Bg, question3Bg;

	public ChapterFifteen(AndroidInterface androidInterface, boolean isTeacher) {
		super(androidInterface, isTeacher);
		// TODO Auto-generated constructor stub
	}
	public ChapterFifteen(AndroidInterface androidInterface, String studentName) {
		super(androidInterface, studentName);
	}

	@Override
	public void setUp(int screenW, int screenH) {
		super.setUp(screenW, screenH);
		
//		startOfQuestionSection = 22;
//		lastChapterSection = 25;
//		assetNeedUpdate = true;

		// backgrounds
		introBg = new Texture(
				"chapters/chapter15/backgrounds/IntroForChapter15.png");
		epektoTulunganBg = new Texture("chapters/chapter15/backgrounds/EpektoNgPagtutulungan.png");
		gawainTulunganBg = new Texture("chapters/chapter15/backgrounds/GawainSaPagtutulungan.png");
		tulongPangangailanganBg = new Texture("chapters/chapter15/backgrounds/KatulongSaPangangailangan.png");
		pangangailanganNatinBg = new Texture("chapters/chapter15/backgrounds/PangangailanganNatin.png");
		
		if (isTeacher) {
			question1Bg = new Texture(
					"chapters/chapter15/answerkeys/answer1.jpg");
			question2Bg = new Texture(
					"chapters/chapter15/answerkeys/answer2.jpg");
			question3Bg = new Texture(
					"chapters/chapter15/answerkeys/answer3.jpg");

			correctAnswers = 5;
		} else {
			question1Bg = new Texture(
					"chapters/chapter15/backgrounds/question1.jpg");
			question2Bg = new Texture(
					"chapters/chapter15/backgrounds/question2.jpg");
			question3Bg = new Texture(
					"chapters/chapter15/backgrounds/question3.jpg");
		}
		
		
		introBalloon1 = new Texture("chapters/chapter15/balloons/EpektoNgPagtutulungan1.png");
		introBalloon2 = new Texture("chapters/chapter15/balloons/EpektoNgPagtutulungan2.png");
		epektoTulunganBalloon1 = new Texture("chapters/chapter15/balloons/EpektoNgPagtutulungan1.png");
		epektoTulunganBalloon2 = new Texture("chapters/chapter15/balloons/EpektoNgPagtutulungan2.png");
		epektoTulunganBalloon3 = new Texture("chapters/chapter15/balloons/EpektoNgPagtutulungan3.png");
		gawainTulunganBalloon1  = new Texture("chapters/chapter15/balloons/GawainSaPagtutulungan1.png");
		gawainTulunganBalloon2 = new Texture("chapters/chapter15/balloons/GawainSaPagtutulungan2.png");
		gawainTulunganBalloon3 = new Texture("chapters/chapter15/balloons/GawainSaPagtutulungan3.png");
		pangangailanganBalloon1 = new Texture("chapters/chapter15/balloons/Pangangailangan1.png");
		pangangailanganBalloon2 = new Texture("chapters/chapter15/balloons/Pangangailangan2.png");
		pangangailanganBalloon3 = new Texture("chapters/chapter15/balloons/Pangangailangan3.png");
		pangangailanganBalloon4 = new Texture("chapters/chapter15/balloons/Pangangailangan4.png");
		tulongPangangailanganBalloon1 = new Texture("chapters/chapter15/balloons/TaongKatulongSaPangangailangan1.png");
		tulongPangangailanganBalloon2 = new Texture("chapters/chapter15/balloons/TaongKatulongSaPangangailangan2.png");
		tulongPangangailanganBalloon3 = new Texture("chapters/chapter15/balloons/TaongKatulongSaPangangailangan3.png");
		
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
			backgroundSprite.setTexture(epektoTulunganBg);
			balloonSprite.setTexture(epektoTulunganBalloon1);
			break;
		case 3:
			balloonSprite.setTexture(epektoTulunganBalloon2);
			break;
		case 4:
			balloonSprite.setTexture(epektoTulunganBalloon3);
			break;
		case 5:
			backgroundSprite.setTexture(gawainTulunganBg);
			balloonSprite.setTexture(gawainTulunganBalloon1);
			break;
		case 6:
			balloonSprite.setTexture(gawainTulunganBalloon2);
			break;
		case 7:
			balloonSprite.setTexture(gawainTulunganBalloon3);
			break;
		case 8:
			balloonSprite.setTexture(gawainTulunganBalloon4);
			break;
		case 9:
			backgroundSprite.setTexture(pangangailanganNatinBg);
			balloonSprite.setTexture(pangangailanganBalloon1);
			break;
		case 10:
			balloonSprite.setTexture(pangangailanganBalloon2);
			break;
		case 11:
			balloonSprite.setTexture(pangangailanganBalloon3);
			break;
		case 12:
			balloonSprite.setTexture(pangangailanganBalloon4);
			break;
		case 13:
			backgroundSprite.setTexture(tulongPangangailanganBg);
			balloonSprite.setTexture(tulongPangangailanganBalloon1);
			break;
		case 14:
			balloonSprite.setTexture(tulongPangangailanganBalloon2);
			break;
		case 15:
			balloonSprite.setTexture(tulongPangangailanganBalloon3);
			break;
			
		}
		

	}

	@Override
	public void dispose() {
		
		introBg.dispose();
		epektoTulunganBg.dispose();
		gawainTulunganBg.dispose();
		tulongPangangailanganBg.dispose();
		pangangailanganNatinBg.dispose();
		introBalloon1.dispose();
		introBalloon2.dispose();
		epektoTulunganBalloon1.dispose();
		epektoTulunganBalloon2.dispose();
		epektoTulunganBalloon3.dispose();
		gawainTulunganBalloon1.dispose();
		gawainTulunganBalloon2.dispose();
		gawainTulunganBalloon3.dispose();
		pangangailanganBalloon1.dispose();
		pangangailanganBalloon2.dispose();
		pangangailanganBalloon3.dispose();
		pangangailanganBalloon4.dispose();
		tulongPangangailanganBalloon1.dispose();
		tulongPangangailanganBalloon2.dispose();
		tulongPangangailanganBalloon3.dispose();
	}

}
