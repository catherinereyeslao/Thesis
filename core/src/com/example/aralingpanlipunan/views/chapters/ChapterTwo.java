package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.example.aralingpanlipunan.android.AndroidInterface;

public class ChapterTwo extends ChapterCore {
    private Texture introBgTexture, introBalloonTexture, directionTexture, mapTexture, direction1BalloonTexture, direction2BalloonTexture, direction3BalloonTexture, direction4BalloonTexture, direction5BalloonTexture, map1BalloonTexture, map2BalloonTexture, map3BalloonTexture, map4BalloonTexture;
    private Sound tingSound;

    public ChapterTwo(AndroidInterface androidInterface, String studName) {
        super(androidInterface, studName);
    }

    @Override
    public void setUp(int screenW, int screenH) {
        screenWidth = screenW;
        screenHeight = screenH;
        startOfQuestionSection = 11;
        setUpDefaultAssets();

        introBgTexture = new Texture("chapters/chapter2/backgrounds/intro.png");
        introBalloonTexture = new Texture("chapters/chapter2/balloons/intro.png");
        directionTexture = new Texture("chapters/chapter2/backgrounds/direksyon.png");
        mapTexture = new Texture("chapters/chapter2/backgrounds/mapa.png");
        direction1BalloonTexture = new Texture("chapters/chapter2/balloons/direction1.png");
        direction2BalloonTexture = new Texture("chapters/chapter2/balloons/direction2.png");
        direction3BalloonTexture = new Texture("chapters/chapter2/balloons/direction3.png");
        direction4BalloonTexture = new Texture("chapters/chapter2/balloons/direction4.png");
        direction5BalloonTexture = new Texture("chapters/chapter2/balloons/direction5.png");
        map1BalloonTexture = new Texture("chapters/chapter2/balloons/map1.png");
        map2BalloonTexture = new Texture("chapters/chapter2/balloons/map2.png");
        map3BalloonTexture = new Texture("chapters/chapter2/balloons/map3.png");
        map4BalloonTexture = new Texture("chapters/chapter2/balloons/map4.png");
        tingSound = Gdx.audio.newSound(Gdx.files.internal("chapters/chapter2/sounds/ting.mp3"));

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
        direction1BalloonTexture.dispose();
        direction2BalloonTexture.dispose();
        direction3BalloonTexture.dispose();
        direction4BalloonTexture.dispose();
        direction5BalloonTexture.dispose();
        map1BalloonTexture.dispose();
        map2BalloonTexture.dispose();
        map3BalloonTexture.dispose();
        map4BalloonTexture.dispose();
        disposeSharedAssets();
    }

    @Override
    public int touchDown(float x, float y) {
        super.touchDown(x, y);
        if (soundSprite.getBoundingRectangle().contains(x, y)) {
            switch (chapterSection) {
                case 1:
                    tingSound.play();
                    break;
                case 2:
                    tingSound.stop();

                    break;
            }
        }
        return 100;
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
                backgroundSprite.setTexture(directionTexture);
                balloonSprite.setAlpha(0);
                break;
            case 2:
                balloonSprite.setTexture(direction1BalloonTexture);
                balloonSprite.setAlpha(1);
                break;
            case 3:
                balloonSprite.setTexture(direction2BalloonTexture);
                break;
            case 4:
                balloonSprite.setTexture(direction3BalloonTexture);
                break;
            case 5:
                balloonSprite.setTexture(direction4BalloonTexture);
                break;
            case 6:
                backgroundSprite.setTexture(directionTexture);
                balloonSprite.setTexture(direction5BalloonTexture);
                break;
            case 7:
                backgroundSprite.setTexture(mapTexture);
                balloonSprite.setTexture(map1BalloonTexture);
                break;
            case 8:
                balloonSprite.setTexture(map2BalloonTexture);
                break;
            case 9:
                balloonSprite.setTexture(map3BalloonTexture);
                break;
            case 10:
                balloonSprite.setTexture(map4BalloonTexture);
                break;
            case 11:
                //TODO: Create the Question/game view here
                break;
        }
        assetNeedUpdate = false;
    }
}
