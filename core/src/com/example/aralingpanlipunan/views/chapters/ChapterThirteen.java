package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader.Setter;
import com.example.aralingpanlipunan.android.AndroidInterface;

public class ChapterThirteen extends ChapterCore {
	Texture introBg, bonifacioBg, watawatBg, aguinaldoBg, rizalBg, lapuBg,
			simboloBg, aquinoBg, introBalloon1, introBalloon2,
			bonifacioBalloon1, bonifacioBalloon2, bonifacioBalloon3,
			watawatBalloon1, watawatBalloon2, watawatBalloon3,
			aguinaldoBalloon1, aguinaldoBalloon2, aguinaldoBalloon3,
			rizalBalloon1, rizalBalloon2, rizalBalloon3, rizalBalloon4,
			lapuBalloon1, lapuBalloon2, lapuBalloon3, lapuBalloon4,
			simboloBalloon1, simboloBalloon2, aquinoBalloon1, aquinoBalloon2,
			aquinoBalloon3, question1Bg, question2Bg, question3Bg;

	public ChapterThirteen(AndroidInterface androidInterface, String studentName) {
		super(androidInterface, studentName);
	}

	public ChapterThirteen(AndroidInterface androidInterface, boolean isTeacher) {
		super(androidInterface, isTeacher);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setUp(int screenW, int screenH) {
		super.setUp(screenW, screenH);
		// startOfQuestionSection = 31;
		// lastChapterSection = 36;
		// assetNeedUpdate = true;

		// backgrounds
		introBg = new Texture(
				"chapters/chapter13/backgrounds/BackgroundIntro.png");
		bonifacioBg = new Texture(
				"chapters/chapter13/backgrounds/AndresBonifacio.png");
		watawatBg = new Texture("chapters/chapter13/backgrounds/AngWatawat.png");
		aguinaldoBg = new Texture(
				"chapters/chapter13/backgrounds/EmilioAguinaldo.png");
		rizalBg = new Texture("chapters/chapter13/backgrounds/JoseRizal.png");
		lapuBg = new Texture("chapters/chapter13/backgrounds/LapuLapu.png");
		simboloBg = new Texture("chapters/chapter13/backgrounds/MgaSimbolo.png");
		aquinoBg = new Texture("chapters/chapter13/backgrounds/NinoyAquino.png");
		if (isTeacher) {
			question1Bg = new Texture(
					"chapters/chapter13/answerkeys/answer1.jpg");
			question2Bg = new Texture(
					"chapters/chapter13/answerkeys/answer2.jpg");
			question3Bg = new Texture(
					"chapters/chapter13/answerkeys/answer3.jpg");

			correctAnswers = 5;
		} else {
			question1Bg = new Texture(
					"chapters/chapter13/backgrounds/question1.jpg");
			question2Bg = new Texture(
					"chapters/chapter13/backgrounds/question2.jpg");
			question3Bg = new Texture(
					"chapters/chapter13/backgrounds/question3.jpg");
			// insert ansmarker

			loadNextButton();
		}
		// balloons
		introBalloon1 = new Texture("chapters/chapter13/balloons/Intro1.png");
		introBalloon2 = new Texture("chapters/chapter13/balloons/Intro2.png");
		bonifacioBalloon1 = new Texture(
				"chapters/chapter13/balloons/Bonifacio1.png");
		bonifacioBalloon2 = new Texture(
				"chapters/chapter13/balloons/Bonifacio2.png");
		bonifacioBalloon3 = new Texture(
				"chapters/chapter13/balloons/Bonifacio3.png");
		watawatBalloon1 = new Texture(
				"chapters/chapter13/balloons/Watawat1.png");
		watawatBalloon2 = new Texture("chapters/chapter13/balloons/Watawat.png");
		watawatBalloon3 = new Texture(
				"chapters/chapter13/balloons/Watawat3.png");
		aguinaldoBalloon1 = new Texture(
				"chapters/chapter13/balloons/EmilioAguinaldo1.png");
		aguinaldoBalloon2 = new Texture(
				"chapters/chapter13/balloons/EmilioAguinaldo2.png");
		aguinaldoBalloon3 = new Texture(
				"chapters/chapter13/balloons/EmilioAguinaldo3.png");
		rizalBalloon1 = new Texture(
				"chapters/chapter13/balloons/JoseRizal1.png");
		rizalBalloon2 = new Texture(
				"chapters/chapter13/balloons/JoseRizal2.png");
		rizalBalloon3 = new Texture(
				"chapters/chapter13/balloons/JoseRizal3.png");
		rizalBalloon4 = new Texture(
				"chapters/chapter13/balloons/JoseRizal4.png");
		lapuBalloon1 = new Texture("chapters/chapter13/balloons/Lapu-Lapu1.png");
		lapuBalloon2 = new Texture("chapters/chapter13/balloons/Lapu-Lapu2.png");
		lapuBalloon3 = new Texture("chapters/chapter13/balloons/Lapu-Lapu3.png");
		lapuBalloon4 = new Texture("chapters/chapter13/balloons/Lapu-Lapu4.png");
		simboloBalloon1 = new Texture(
				"chapters/chapter13/balloons/Simbolo1.png");
		simboloBalloon2 = new Texture(
				"chapters/chapter13/balloons/Simbolo2.png");
		aquinoBalloon1 = new Texture(
				"chapters/chapter13/balloons/NinoyAquino1.png");
		aquinoBalloon2 = new Texture(
				"chapters/chapter13/balloons/NinoyAquino2.png");
		aquinoBalloon3 = new Texture(
				"chapters/chapter13/balloons/NinoyAquino3.png");

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
			backgroundSprite.setTexture(watawatBg);
			balloonSprite.setTexture(watawatBalloon1);
			break;
		case 3:
			balloonSprite.setTexture(watawatBalloon2);
			break;
		case 4:
			balloonSprite.setTexture(watawatBalloon3);
			break;
		case 5:
			backgroundSprite.setTexture(simboloBg);
			balloonSprite.setTexture(simboloBalloon1);
			break;
		case 6:
			balloonSprite.setTexture(simboloBalloon2);
			break;
		case 7:
			backgroundSprite.setTexture(bonifacioBg);
			balloonSprite.setTexture(bonifacioBalloon1);
			break;
		case 8: 
			balloonSprite.setTexture(bonifacioBalloon2);
			break;
		case 9:
			backgroundSprite.setTexture(bonifacioBalloon2);
			break;
		case 10:
			backgroundSprite.setTexture(bonifacioBalloon3);
			break;
		case 11:
			backgroundSprite.setTexture(aguinaldoBg);
			balloonSprite.setTexture(aguinaldoBalloon1);
			break;
		case 12:
			balloonSprite.setTexture(aguinaldoBalloon2);
			break;
		case 13:
			balloonSprite.setTexture(aguinaldoBalloon3);
			break;
		case 14:
			backgroundSprite.setTexture(rizalBg);
			balloonSprite.setTexture(rizalBalloon1);
			break;
		case 15:
			balloonSprite.setTexture(rizalBalloon2);
			break;
		case 16:
			balloonSprite.setTexture(rizalBalloon3);
			break;
		case 17:
			balloonSprite.setTexture(rizalBalloon4);
			break;
		case 18:
			backgroundSprite.setTexture(lapuBg);
			balloonSprite.setTexture(lapuBalloon1);
			break;
		case 19:
			balloonSprite.setTexture(lapuBalloon2);
			break;
		case 20:
			balloonSprite.setTexture(lapuBalloon3);
			break;
		case 21:
			balloonSprite.setTexture(lapuBalloon4);
			break;
		
			
		}
		

	}

	@Override
	public void dispose() {
	
		introBg.dispose();
		bonifacioBg.dispose(); 
		watawatBg.dispose();
		aguinaldoBg.dispose();
		rizalBg.dispose();
		lapuBg.dispose();
		simboloBg.dispose();
		aquinoBg.dispose();
		introBalloon1.dispose();
		introBalloon2.dispose();
		bonifacioBalloon1.dispose();
		bonifacioBalloon2.dispose();
		bonifacioBalloon3.dispose();
		watawatBalloon1.dispose();
		watawatBalloon2.dispose();
		watawatBalloon3.dispose();
		aguinaldoBalloon1.dispose();
		aguinaldoBalloon2.dispose();
		aguinaldoBalloon3.dispose();
		rizalBalloon1.dispose();
		rizalBalloon2.dispose();
		rizalBalloon3.dispose();
		rizalBalloon4.dispose();
		lapuBalloon1.dispose();
		lapuBalloon2.dispose();
		lapuBalloon3.dispose();
		lapuBalloon4.dispose();
		simboloBalloon1.dispose();
		simboloBalloon2.dispose();
		aquinoBalloon1.dispose();
		aquinoBalloon2.dispose();
		aquinoBalloon3.dispose();
		question1Bg.dispose();
		question2Bg.dispose();
		question3Bg.dispose();
	}

}
