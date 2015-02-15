package com.example.aralingpanlipunan.views.minigames;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.views.AppView;

/**
 * Menu for Mini Games selection. 4pics1word or memory game
 */
public class MiniGamesMenu extends AppView {
    private static final byte MINI_GAME_MENU = 0;
    private static final byte MEMORY_GAME = 1;
    private byte selectedMenu = MINI_GAME_MENU;
    private Texture menuBgTexture, memoryMenuBgTexture;
    private Sprite memory, fourPics;

    @Override
    public void setUp(int screenW, int screenH) {
        screenWidth = screenW;
        screenHeight = screenH;
        float optionY = screenHeight / 3.24f;
        float memoryX = screenWidth / 3.86f;
        float fourPicX = screenWidth / 1.82f;

        menuBgTexture = new Texture("minigames/minigame-menu.jpg");
        memoryMenuBgTexture = new Texture("minigames/memory-select.jpg");
        memory = new Sprite(menuBgTexture);
        memory.setSize(memory.getWidth() * getButtonScale() / 1.85f, memory.getHeight() * getButtonScale() / 1.75f);
        memory.setPosition(memoryX, optionY);
        memory.setBounds(memoryX, optionY, memory.getWidth(), memory.getHeight());
        memory.setAlpha(0);

        fourPics = new Sprite(menuBgTexture);
        fourPics.setSize(memory.getWidth(), memory.getHeight());
        fourPics.setBounds(fourPicX, optionY, fourPics.getWidth(), fourPics.getHeight());
        fourPics.setAlpha(0);
    }

    @Override
    public void display(Batch batch) {
        switch (selectedMenu) {
            case MINI_GAME_MENU:
                batch.draw(menuBgTexture, 0, 0, screenWidth, screenHeight);
                memory.draw(batch);
                fourPics.draw(batch);
                break;
            case MEMORY_GAME:
                batch.draw(memoryMenuBgTexture, 0, 0, screenWidth, screenHeight);
                break;
        }
        memory.draw(batch);
        fourPics.draw(batch);
    }

    @Override
    public void dispose() {
        menuBgTexture.dispose();
    }

    /**
     * Listen for screen touches
     * @param x X coordinate of touched screen
     * @param y Y coordinate of touched screen
     */
    public void touchDown(float x, float y) {
        switch (selectedMenu) {
            case MINI_GAME_MENU:
                if (memory.getBoundingRectangle().contains(x, y)) {
                    selectedMenu = MEMORY_GAME;
                } else if (fourPics.getBoundingRectangle().contains(x, y)) {
                    //TODO: Place logic here to open fourpics game
                }
                break;
            case MEMORY_GAME:
                //TODO: Put touch listeners here to select memory game level
                break;
        }
    }

    /**
     * If android's back key is pressed, return 1 to Main class to give a
     * signal to go back to Start
     * @param keycode the keycode of the pressed button
     * @return int
     */
    public int keyDown(int keycode) {
        switch (selectedMenu) {
            case MINI_GAME_MENU:
                return keycode == 4 ? 1 : 0;
            case MEMORY_GAME:
                if (keycode == 4) selectedMenu = MINI_GAME_MENU;
                break;
        }
        return 0;
    }
}
