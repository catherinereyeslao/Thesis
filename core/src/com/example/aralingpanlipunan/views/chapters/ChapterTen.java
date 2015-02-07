package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.example.aralingpanlipunan.android.AndroidInterface;

public class ChapterTen extends ChapterCore {

	Texture introBg, bagongTaonBg, paggalangBg, salosaloBg, bisitaBg, undasBg,
			introBalloon1, bagongTaonBalloon1, bagongTaonBalloon2,
			bagongTaonBalloon3, salosaloBalloon1, salosaloBalloon2,
			salosaloBalloon3, paggalangBalloon1, paggalangBalloon2,
			paggalangBalloon3, paggalangBalloon4, pagtanggapBalloon1,
			pagtanggapBalloon2, pagtanggapBalloon3, undasBalloon1,
			undasBalloon2, undasBalloon3, undasBalloon4, undasBalloon5;

	public ChapterTen(AndroidInterface androidInterface, String studName) {
		super(androidInterface, studName);
	}

    public ChapterTen(AndroidInterface androidInterface, boolean isTeacher) {
        super(androidInterface, isTeacher);
    }

	@Override
	public void setUp(int screenW, int screenH) {
		super.setUp(screenW, screenH);

		startOfQuestionSection = 19;
		lastChapterSection = 26;
		// background
		introBg = new Texture(
				"chapters/chapter10/backgrounds/IntroForChapter10.png");
		bagongTaonBg = new Texture(
				"chapters/chapter10/backgrounds/Bagong Taon.png");
		paggalangBg = new Texture(
				"chapters/chapter10/backgrounds/Paggalang.png");
		salosaloBg = new Texture(
				"chapters/chapter10/backgrounds/Pagsasalo salo.png");
		bisitaBg = new Texture(
				"chapters/chapter10/backgrounds/Pagtanggap sa bisita.png");
		undasBg = new Texture("chapters/chapter10/backgrounds/Undas.png");

		// balloons
		introBalloon1 = new Texture("chapters/chapter10/balloons/Intro.png");
		bagongTaonBalloon1 = new Texture(
				"chapters/chapter10/balloons/BagongTaon1.png");
		bagongTaonBalloon2 = new Texture(
				"chapters/chapter10/balloons/BagongTaon2.png");
		bagongTaonBalloon3 = new Texture(
				"chapters/chapter10/balloons/BagingTaon3.png");
		salosaloBalloon1 = new Texture(
				"chapters/chapter10/balloons/Pagdiriwang1.png");
		salosaloBalloon2 = new Texture(
				"chapters/chapter10/balloons/Pagdiriwang2.png");
		salosaloBalloon3 = new Texture(
				"chapters/chapter10/balloons/Pagdirirwang3.png");
		paggalangBalloon1 = new Texture(
				"chapters/chapter10/balloons/Paggalang1.png");
		paggalangBalloon2 = new Texture(
				"chapters/chapter10/balloons/Paggalang2.png");
		paggalangBalloon3 = new Texture(
				"chapters/chapter10/balloons/Paggalang3.png");
		paggalangBalloon4 = new Texture(
				"chapters/chapter10/balloons/Paggalang4.png");
		pagtanggapBalloon1 = new Texture(
				"chapters/chapter10/balloons/Pagtanggap1.png");
		pagtanggapBalloon2 = new Texture(
				"chapters/chapter10/balloons/Pagtanggap2.png");
		pagtanggapBalloon3 = new Texture(
				"chapters/chapter10/balloons/Pagtanggap3.png");
		undasBalloon1 = new Texture("chapters/chapter10/balloons/Undas1.png");
		undasBalloon2 = new Texture("chapters/chapter10/balloons/Undas2.png");
		undasBalloon3 = new Texture("chapters/chapter10/balloons/Undas3.png");
		undasBalloon4 = new Texture("chapters/chapter10/balloons/Undas4.png");
		undasBalloon5 = new Texture("chapters/chapter10/balloons/Undas5.png");
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
			backgroundSprite.setTexture(bagongTaonBg);
			balloonSprite.setTexture(bagongTaonBalloon1);
			break;
		case 2:
			balloonSprite.setTexture(bagongTaonBalloon2);
			break;
		case 3:
			balloonSprite.setTexture(bagongTaonBalloon3);
			break;
		case 4:
			backgroundSprite.setTexture(paggalangBg);
			balloonSprite.setTexture(paggalangBalloon1);
			break;
		case 5:
			balloonSprite.setTexture(paggalangBalloon2);
			break;
		case 6:
			balloonSprite.setTexture(paggalangBalloon3);
			break;
		case 7:
			balloonSprite.setTexture(paggalangBalloon4);
			break;
		case 8:
			backgroundSprite.setTexture(salosaloBg);
			balloonSprite.setTexture(salosaloBalloon1);
			break;
		case 9:
			balloonSprite.setTexture(salosaloBalloon2);
			break;
		case 10:
			balloonSprite.setTexture(salosaloBalloon3);
			break;
		case 11:
			backgroundSprite.setTexture(bisitaBg);
			balloonSprite.setTexture(pagtanggapBalloon1);
			break;
		case 12:
			balloonSprite.setTexture(pagtanggapBalloon2);
			break;
		case 13:
			balloonSprite.setTexture(pagtanggapBalloon3);
			break;
		case 14:
			backgroundSprite.setTexture(undasBg);
			balloonSprite.setTexture(undasBalloon1);
			break;
		case 15:
			balloonSprite.setTexture(undasBalloon2);
			break;
		case 16:
			balloonSprite.setTexture(undasBalloon3);
			break;
		case 17:
			balloonSprite.setTexture(undasBalloon4);
			break;
		case 18:
			balloonSprite.setTexture(undasBalloon5);
		}

	}

	@Override
	public void dispose() {
		
		introBg.dispose();
		bagongTaonBg.dispose();
		paggalangBg.dispose();
		salosaloBg.dispose();
		bisitaBg.dispose();
		undasBg.dispose();
		introBalloon1.dispose();
		bagongTaonBalloon1.dispose();
		bagongTaonBalloon2.dispose();
		bagongTaonBalloon3.dispose();
		salosaloBalloon1.dispose();
		salosaloBalloon2.dispose();
		salosaloBalloon3.dispose();
		paggalangBalloon1.dispose();
		paggalangBalloon2.dispose();
		paggalangBalloon3.dispose();
		paggalangBalloon4.dispose();
		pagtanggapBalloon1.dispose();
		pagtanggapBalloon2.dispose();
		pagtanggapBalloon3.dispose();
		undasBalloon1.dispose();
		undasBalloon2.dispose();
		undasBalloon3.dispose();
		undasBalloon4.dispose();
		undasBalloon5.dispose();
	}

}
