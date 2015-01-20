package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.example.aralingpanlipunan.android.AndroidInterface;

public class ChapterThree extends ChapterCore {
	
	private Texture introBg, introBalloon, alituntunin1Bg, alituntunin2Bg, alituntunin3Bg, alituntunin4Bg, alituntunin5Bg, a1B1, a1B2, a2B1, a3B1, a3B2, a4B1, a4B2, a5B1, a5B2;
	
	public ChapterThree(AndroidInterface androidInterface, String studName) {
        super(androidInterface, studName);
    }

	@Override
	public void setUp(int screenW, int screenH){
		
		super.setUp(screenW, screenH);
		introBg = new Texture("chapters/chapter3/backgrounds/IntroForChapter3.png");
		introBalloon = new Texture("chapters/chapter3/balloons/intro.png");
		alituntunin1Bg = new Texture("chapters/chapter3/backgrounds/Alituntunin1.png");
		alituntunin2Bg = new Texture("chapters/chapter3/backgrounds/Alituntunin2.png");
		alituntunin3Bg = new Texture("chapters/chapter3/backgrounds/Alituntunin3.png");
		alituntunin4Bg = new Texture("chapters/chapter3/backgrounds/Alituntunin4.png");
		alituntunin5Bg = new Texture("chapters/chapter3/backgrounds/Alituntunin5.png");
		a1B1 = new Texture("chapters/chapter3/balloons/Alituntunin1.1.png");
		a1B2 = new Texture("chapters/chapter3/balloons/Alituntunin1.2.png");
		a2B1 = new Texture("chapters/chapter3/balloons/Alituntunin2.1.png");
		a3B1 = new Texture("chapters/chapter3/balloons/Alituntunin3.1.png");
		a3B2 = new Texture("chapters/chapter3/balloons/Alituntunin3.2.png");
		a4B1 = new Texture("chapters/chapter3/balloons/Alituntunin4.1.png");
		a4B2 = new Texture("chapters/chapter3/balloons/Alituntunin4.2.png");
		a5B1 = new Texture("chapters/chapter3/balloons/Alituntunin5.1.png");
		a5B2 = new Texture("chapters/chapter3/balloons/Alituntunin5.2.png");
		
	}
	
	@Override
	public void display(Batch batch){
		if (assetNeedUpdate) assetManager();
        renderSharedAssets(batch);
	}

	private void assetManager(){
		
	}

	@Override
	public void dispose(){
		super.dispose();
		introBg.dispose();
		introBalloon.dispose();
		alituntunin1Bg.dispose();
		alituntunin2Bg.dispose();
		alituntunin3Bg.dispose();
		alituntunin4Bg.dispose();
		alituntunin5Bg.dispose();
		a1B1.dispose();
		a1B2.dispose();
		a2B1.dispose();
		a3B1.dispose();
		a3B2.dispose();
		a4B1.dispose();
		a4B2.dispose();
		a5B1.dispose();
		a5B2.dispose();
		
	}
}
