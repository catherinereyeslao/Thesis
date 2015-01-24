package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.example.aralingpanlipunan.android.AndroidInterface;

public class ChapterFour extends ChapterCore {
    private Texture introBg, intro1Balloon, intro2Balloon;
    public ChapterFour(AndroidInterface androidInterface, String studentName) {
        super(androidInterface, studentName);
    }

    @Override
    public void setUp(int screenW, int screenH) {
        super.setUp(screenW, screenH);
        startOfQuestionSection = 12;
        lastChapterSection = 15;

        introBg = new Texture("chapters/chapter4/backgrounds/intro.png");
        intro1Balloon = new Texture("chapters/chapter4/balloons/intro1.png");
        intro2Balloon = new Texture("chapters/chapter4/balloons/intro2.png");

        assetNeedUpdate = true;
    }

    @Override
    public void display(Batch batch) {
        if (assetNeedUpdate) assetManager();
        renderSharedAssets(batch);
    }

    private void assetManager() {
        switch (chapterSection) {
            case 0:
                backgroundSprite.setTexture(introBg);
                balloonSprite.setTexture(intro1Balloon);
                break;
            case 1:
                backgroundSprite.setTexture(introBg);
                balloonSprite.setTexture(intro2Balloon);
                break;
        }
        assetNeedUpdate = false;
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
