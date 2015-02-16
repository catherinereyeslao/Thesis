package com.example.aralingpanlipunan.views.minigames;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.views.AppView;
import java.lang.IllegalArgumentException;
import java.util.HashMap;

public class MemoryGame extends AppView {
    public static final byte EASY = 0;
    public static final byte MEDIUM = 1;
    public static final byte HARD = 2;
    private byte difficulty;
    private Texture backgroundTexture, questionTexture, easyTexture1, easyTexture2, easyTexture3;
    private Sprite icon1, icon2, icon3, icon4, icon5, icon6;

    /**
     * Creates a new Memory game
     * @param difficulty Select from MemoryGame.EASY, MemoryGame.MEDIUM, or MemoryGame.HARD to indicate difficulty
     */
    public MemoryGame(byte difficulty) {
        if (difficulty < 0 || difficulty > 2)
            throw new IllegalArgumentException("Invalid Parameter used for indicating Memory Game level. Select from MemoryGame.EASY, MemoryGame.MEDIUM, or MemoryGame.HARD");
        this.difficulty = difficulty;
    }

    @Override
    public void setUp(int screenW, int screenH) {
        screenWidth = screenW;
        screenHeight = screenH;

        backgroundTexture = new Texture("minigames/background.png");
        questionTexture = new Texture("minigames/memory/easy/question.png");
        easyTexture1 = new Texture("minigames/memory/easy/easy1.png");
        easyTexture2 = new Texture("minigames/memory/easy/easy2.png");
        easyTexture3 = new Texture("minigames/memory/easy/easy3.png");

        switch (difficulty) {
            case EASY:
                loadEasy();
                break;
        }
    }

    @Override
    public void display(Batch batch) {
        batch.draw(backgroundTexture, 0, 0, screenWidth, screenHeight);
        switch (difficulty) {
            case EASY:
                icon1.draw(batch);
                icon2.draw(batch);
                icon3.draw(batch);
                icon4.draw(batch);
                icon5.draw(batch);
                icon6.draw(batch);
                break;
        }
    }

    @Override
    public void dispose() {
        backgroundTexture.dispose();
        questionTexture.dispose();
        easyTexture1.dispose();
        easyTexture2.dispose();
        easyTexture3.dispose();
    }

    /**
     * Detect touch down listener for the Memory Game
     * @param x X coordinate of touched screen
     * @param y Y coordinate of touched screen
     */
    public void touchDown(float x, float y) {

    }

    /**
     * Loads a memory game in easy level
     */
    private void loadEasy() {
        final float col1 = screenWidth / 3.2f;
        final float col2 = screenWidth / 2.3f;
        final float col3 = screenWidth / 1.8f;
        final float row1 = screenHeight / 1.8f;
        final float row2 = screenHeight / 3;

        float pos1[] = {col1, row1};
        float pos2[] = {col2, row1};
        float pos3[] = {col3, row1};
        float pos4[] = {col1, row2};
        float pos5[] = {col2, row2};
        float pos6[] = {col3, row2};

        icon1 = new Sprite(easyTexture1);
        icon1.setSize((icon1.getWidth() * getButtonScale()) * 1.5f, (icon1.getHeight() * getButtonScale()) * 1.5f);
        icon1.setPosition(col1, row1);

        icon2 = new Sprite(easyTexture1);
        icon2.setSize(icon1.getWidth(), icon1.getHeight());
        icon2.setPosition(col2, row1);

        icon3 = new Sprite(easyTexture1);
        icon3.setSize(icon1.getWidth(), icon1.getHeight());
        icon3.setPosition(col3, row1);

        icon4 = new Sprite(easyTexture1);
        icon4.setSize(icon1.getWidth(), icon1.getHeight());
        icon4.setPosition(col1, row2);

        icon5 = new Sprite(easyTexture1);
        icon5.setSize(icon1.getWidth(), icon1.getHeight());
        icon5.setPosition(col2, row2);

        icon6 = new Sprite(easyTexture1);
        icon6.setSize(icon1.getWidth(), icon1.getHeight());
        icon6.setPosition(col3, row2);
    }
}
