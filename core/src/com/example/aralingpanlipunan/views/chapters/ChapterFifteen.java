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
		
		
		introBalloon1 = new Texture("chapters/chapter15/assets/EpektoNgPagtutulungan1.png");
		introBalloon2 = new Texture("chapters/chapter15/assets/EpektoNgPagtutulungan2.png");
		epektoTulunganBalloon1 = new Texture("chapters/chapter15/assets/EpektoNgPagtutulungan1.png");
		epektoTulunganBalloon2 = new Texture("chapters/chapter15/assets/EpektoNgPagtutulungan1.png");
		epektoTulunganBalloon3 = new Texture("chapters/chapter15/assets/EpektoNgPagtutulungan1.png");
		gawainTulunganBalloon1  = new Texture("chapters/chapter15/assets/GawainSaPagtutulungan1.png");
		gawainTulunganBalloon2 = new Texture("chapters/chapter15/assets/GawainSaPagtutulungan2.png");
		gawainTulunganBalloon3 = new Texture("chapters/chapter15/assets/GawainSaPagtutulungan3.png");
		pangangailanganBalloon1 = new Texture("chapters/chapter15/assets/Pangangailangan1.png");
		pangangailanganBalloon2 = new Texture("chapters/chapter15/assets/Pangangailangan2.png");
		pangangailanganBalloon3 = new Texture("chapters/chapter15/assets/Pangangailangan3.png");
		pangangailanganBalloon4 = new Texture("chapters/chapter15/assets/Pangangailangan4.png");
		tulongPangangailanganBalloon1 = new Texture("chapters/chapter15/assets/TaongKatulongSaPangangailangan1.png");
		tulongPangangailanganBalloon2 = new Texture("chapters/chapter15/assets/TaongKatulongSaPangangailangan2.png");
		tulongPangangailanganBalloon3 = new Texture("chapters/chapter15/assets/TaongKatulongSaPangangailangan3.png");
	}

	@Override
	public void display(Batch batch) {
		if (assetNeedUpdate)
			assetManager();
		renderSharedAssets(batch);

	}

	private void assetManager() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
	}

}
