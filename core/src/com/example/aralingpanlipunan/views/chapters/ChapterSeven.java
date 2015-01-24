package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.example.aralingpanlipunan.android.AndroidInterface;

public class ChapterSeven extends ChapterCore {

	private Texture introBg, erectusBg, habilisBg, sapiensBg,
					introBalloon1, introBalloon2, erectusBalloon1, erectusBalloon2, 
					habilisBalloon1, habilisBalloon2, sapiensBalloon1, sapiensBalloon2, sapiensBalloon3;
	public ChapterSeven(AndroidInterface androidInterface, String studName) {
		super(androidInterface, studName);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setUp(int screenW, int screenH){
		
	}
	
	@Override
	public void display(Batch batch){
		if (assetNeedUpdate) assetManager();
		renderSharedAssets(batch);
		
	}
	
	private void assetManager() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose(){
		
	}

}
