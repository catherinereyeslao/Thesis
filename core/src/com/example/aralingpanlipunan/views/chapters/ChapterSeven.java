package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.example.aralingpanlipunan.android.AndroidInterface;

public class ChapterSeven extends ChapterCore {

	private Texture introBg, erectusBg, habilisBg, sapiensBg,
					introBalloon1, introBalloon2, erectusBalloon1, erectusBalloon2, erectusBalloon3, 
					habilisBalloon1, habilisBalloon2, sapiensBalloon1, 
					sapiensBalloon2, sapiensBalloon3;
	public ChapterSeven(AndroidInterface androidInterface, String studName) {
		super(androidInterface, studName);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setUp(int screenW, int screenH){
		super.setUp(screenW, screenH);
		startOfQuestionSection = 10;
        lastChapterSection = 15;

		//backgrounds
		introBg = new Texture("chapters/chapter7/backgrounds/IntroForChapter7.png");
		erectusBg = new Texture("chapters/chapter7/backgrounds/ChapterSevenBackgroundErectus.png");
		habilisBg = new Texture("chapters/chapter7/backgrounds/ChapterSevenBackgroundHabilis.png");
		sapiensBg = new Texture("chapters/chapter7/backgrounds/ChapterSevenBackgroundSapiens.png");
		
		//balloons
		introBalloon1 = new Texture("chapters/chapter7/balloons/Intro1.png");
		introBalloon2 = new Texture("chapters/chapter7/balloons/Intro2.png");
		erectusBalloon1 = new Texture("chapters/chapter7/balloons/Homoerectus1.png");
		erectusBalloon2 = new Texture("chapters/chapter7/balloons/Homoerectus2.png");
		erectusBalloon3 = new Texture("chapters/chapter7/balloons/Homoerectus3.png");
		habilisBalloon1 = new Texture("chapters/chapter7/balloons/Habilis1.png");
		habilisBalloon2 = new Texture("chapters/chapter7/balloons/Habilis2.png");
		sapiensBalloon1 = new Texture("chapters/chapter7/balloons/Sapiens1.png");
		sapiensBalloon2 = new Texture("chapters/chapter7/balloons/Sapiens2.png");
		sapiensBalloon3 = new Texture("chapters/chapter7/balloons/Sapiens3.png");
		
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
			backgroundSprite.setTexture(erectusBg);
			balloonSprite.setTexture(erectusBalloon1);
			break;
		case 3:
			balloonSprite.setTexture(erectusBalloon2);
			break;
		case 4:
			balloonSprite.setTexture(erectusBalloon3);
			break;
		case 5:
			backgroundSprite.setTexture(habilisBg);
			balloonSprite.setTexture(habilisBalloon1);
			break;
		case 6:
			balloonSprite.setTexture(habilisBalloon2);
			break;
		case 7:
			backgroundSprite.setTexture(sapiensBg);
			balloonSprite.setTexture(sapiensBalloon1);
			break;
		case 8:
			balloonSprite.setTexture(sapiensBalloon2);
			break;
		case 9:
			balloonSprite.setTexture(sapiensBalloon3);
			break;
		
		}
	}

	@Override
	public void dispose(){
		
		introBg.dispose();
		erectusBg.dispose();
		habilisBg.dispose();
		sapiensBg.dispose();
		introBalloon1.dispose();
		introBalloon2.dispose();
		erectusBalloon1.dispose();
		erectusBalloon2.dispose();
		erectusBalloon3.dispose();
		habilisBalloon1.dispose();
		habilisBalloon2.dispose();
		sapiensBalloon1.dispose();
		sapiensBalloon2.dispose();
		sapiensBalloon3.dispose();
		
		
	}

}
