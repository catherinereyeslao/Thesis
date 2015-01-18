package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.example.aralingpanlipunan.android.AndroidInterface;

public class ChapterTwo extends ChapterCore {
    private Texture introBgTexture, introBalloonTexture, directionTexture, mapTexture;

    public ChapterTwo(AndroidInterface androidInterface, String studName) {
        super(androidInterface, studName);
    }

    @Override
    public void setUp(int screenW, int screenH) {
        screenWidth = screenW;
        screenHeight = screenH;
        setUpDefaultAssets();

        introBgTexture = new Texture("chapters/chapter2/backgrounds/intro.png");
        introBalloonTexture = new Texture("chapters/chapter2/balloons/intro.png");
        directionTexture = new Texture("chapters/chapter2/backgrounds/direksyon.png");
        mapTexture = new Texture("chapters/chapter2/backgrounds/mapa.png");

        backgroundSprite.setTexture(introBgTexture);
        balloonSprite.setTexture(introBalloonTexture);
    }

    @Override
    public void display(Batch batch) {
        if (assetNeedUpdate) assetManager();
        renderSharedAssets(batch);
    }

    @Override
    public void dispose() {
        introBgTexture.dispose();
        introBalloonTexture.dispose();
        directionTexture.dispose();
        mapTexture.dispose();
        disposeSharedAssets();
    }

    /**
     * This assetManager manages asset on Demand (assetNeedUpdate = true)
     * This is where we put calls when we need to change the bg,
     * balloon, display or hide assets. These mentioned tasks should
     * only be called on demand, otherwise, we risk having a slow
     * performance app due to running unnecessary tasks
     */
    private void assetManager() {
        switch (chapterSection) {
            case 1:
                break;
        }
        assetNeedUpdate = false;
    }
}
