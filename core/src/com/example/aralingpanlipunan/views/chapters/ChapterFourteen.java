package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.example.aralingpanlipunan.android.AndroidInterface;

public class ChapterFourteen extends ChapterCore {

	Texture introBg, lupaBg1, lupaBg2, lupaBg3, tubigBg1, tubigBg2, tubigBg3, introBalloon1, introBalloon2, 
			bukalBalloon1, bukalBalloon2, bulkanBalloon1, bulkanBalloon2, bundokBalloon1, bundokBalloon2,
			burolBalloon1, burolBalloon2, burolBalloon3, dagatBalloon1, dagatBalloon2, ilogBalloon1,
			ilogBalloon2, ilogBalloon3, kapataganBalloon1, kapataganBalloon2, karagatanBalloon1, karagatanBalloon2, 
			lambakBalloon1, lambakBalloon2, lawaBalloon1, lawaBalloon2, talampasBalloon1, talampasBalloon2, talonBalloon1, 
			talonBalloon2, question1Bg, question2Bg, question3Bg;
	public ChapterFourteen(AndroidInterface androidInterface, boolean isTeacher) {
		super(androidInterface, isTeacher);
		// TODO Auto-generated constructor stub
	}
	public ChapterFourteen(AndroidInterface androidInterface, String studentName) {
		super(androidInterface, studentName);
	}

	@Override
	public void setUp(int screenW, int screenH) {
		super.setUp(screenW, screenH);
		// startOfQuestionSection = 31;
		// lastChapterSection = 36;
		// assetNeedUpdate = true;
		
		//backgrounds
		
	introBg = new Texture("chapters/chapter14/backgrounds/IntroForChapter14.png");
	lupaBg1 = new Texture("chapters/chapter14/backgrounds/Lupa1.png");
	lupaBg2 = new Texture("chapters/chapter14/backgrounds/Lupa2.png");
	lupaBg3 = new Texture("chapters/chapter14/backgrounds/Lupa3.png");
	tubigBg1 = new Texture("chapters/chapter14/backgrounds/Tubig1.png");
	tubigBg2 = new Texture("chapters/chapter14/backgrounds/Tubig2.png");
	tubigBg3 = new Texture("chapters/chapter14/backgrounds/Tubig3.png");
	
	// Question/game backgrounds
    if (isTeacher) {
        question1Bg = new Texture("chapters/chapter14/answerkeys/answer1.jpg");
        question2Bg = new Texture("chapters/chapter14/answerkeys/answer2.jpg");
        question3Bg = new Texture("chapters/chapter14/answerkeys/answer3.jpg");
       
        correctAnswers = 6;
    } else {
        question1Bg = new Texture("chapters/chapter14/backgrounds/question1.jpg");
        question2Bg = new Texture("chapters/chapter14/backgrounds/question2.jpg");
        question3Bg = new Texture("chapters/chapter14/backgrounds/question3.jpg");
    }
	
	//balloons
	introBalloon1 = new Texture("chapters/chapter14/balloons/Intro1.png");
	introBalloon2 = new Texture("chapters/chapter14/balloons/Intro2.png");
	bukalBalloon1 = new Texture("chapters/chapter14/balloons/Bukal1.png");
	bukalBalloon2 = new Texture("chapters/chapter14/balloons/Bukal2.png");
	bulkanBalloon1 = new Texture("chapters/chapter14/balloons/Bulkan1.png");
	bulkanBalloon2 = new Texture("chapters/chapter14/balloons/Bulkan2.png");
	bundokBalloon1 = new Texture("chapters/chapter14/balloons/Bundok1.png");
	bundokBalloon2 = new Texture("chapters/chapter14/balloons/Bundok2.png");
	burolBalloon1 = new Texture("chapters/chapter14/balloons/Burol1.png");
	burolBalloon2 = new Texture("chapters/chapter14/balloons/Burol2.png");
	burolBalloon3 = new Texture("chapters/chapter14/balloons/Burol3.png");
	dagatBalloon1 = new Texture("chapters/chapter14/balloons/Dagat1.png");
	dagatBalloon2 = new Texture("chapters/chapter14/balloons/Dagat2.png");
	ilogBalloon1 = new Texture("chapters/chapter14/balloons/Ilog1.png");
	ilogBalloon2 = new Texture("chapters/chapter14/balloons/Ilog2.png");
	ilogBalloon3 = new Texture("chapters/chapter14/balloons/Ilog3.png");
	kapataganBalloon1 = new Texture("chapters/chapter14/balloons/Kapatagan1.png");
	kapataganBalloon2 = new Texture("chapters/chapter14/balloons/Kapatagan2.png");
	karagatanBalloon1 = new Texture("chapters/chapter14/balloons/Karagatan1.png");
	karagatanBalloon2 = new Texture("chapters/chapter14/balloons/Karagatan2.png");
	lambakBalloon1 = new Texture("chapters/chapter14/balloons/Lambak1.png");
	lambakBalloon2 = new Texture("chapters/chapter14/balloons/Lambak2.png");
	lawaBalloon1 = new Texture("chapters/chapter14/balloons/Lawa1.png");
	lawaBalloon2 = new Texture("chapters/chapter14/balloons/Lawa2.png");
	talampasBalloon1 = new Texture("chapters/chapter14/balloons/Talampas1.png");
	talampasBalloon2 = new Texture("chapters/chapter14/balloons/Talampas2.png");
	talonBalloon1 = new Texture("chapters/chapter14/balloons/Talon1.png");
	talonBalloon2 = new Texture("chapters/chapter14/balloons/Talon2.png");
	
	
	
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
