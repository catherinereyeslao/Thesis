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
    private static final byte MEMORY_MENU = 1;
    private static final byte MEMORY_GAME = 2;
    private static final byte FOUR_PICS = 3;
    private byte selectedMenu = MINI_GAME_MENU;
    private Texture menuBgTexture, memoryMenuBgTexture;
    private Sprite memory, fourPics, easyMemory, medMemory, hardMemory;
    private MemoryGame memoryGame;
    private FourPics fourPicsGame;

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

        fourPics = new Sprite(menuBgTexture);
        fourPics.setSize(memory.getWidth(), memory.getHeight());
        fourPics.setBounds(fourPicX, optionY, fourPics.getWidth(), fourPics.getHeight());

        // Set touch listeners for Memory Game Menu
        float easyX = screenWidth / 4.69f;
        float mediumX = screenWidth / 2.455f;
        float hardX = screenWidth / 1.63f;
        float memoryMenuY = screenHeight / 2.75f;

        easyMemory = new Sprite(menuBgTexture);
        easyMemory.setSize(memory.getWidth() / 1.188f, memory.getHeight() / 1.3f);
        easyMemory.setPosition(easyX, memoryMenuY);
        easyMemory.setBounds(easyX, memoryMenuY, easyMemory.getWidth(), easyMemory.getHeight());

        medMemory = new Sprite(menuBgTexture);
        medMemory.setSize(easyMemory.getWidth(), easyMemory.getHeight());
        medMemory.setPosition(mediumX, memoryMenuY);
        medMemory.setBounds(mediumX, memoryMenuY, medMemory.getWidth(), medMemory.getHeight());

        hardMemory = new Sprite(menuBgTexture);
        hardMemory.setSize(easyMemory.getWidth(), easyMemory.getHeight());
        hardMemory.setPosition(hardX, memoryMenuY);
        hardMemory.setBounds(hardX, memoryMenuY, easyMemory.getWidth(), easyMemory.getHeight());
    }

    @Override
    public void display(Batch batch) {
        switch (selectedMenu) {
            case MINI_GAME_MENU:
                batch.draw(menuBgTexture, 0, 0, screenWidth, screenHeight);
                break;
            case MEMORY_MENU:
                batch.draw(memoryMenuBgTexture, 0, 0, screenWidth, screenHeight);
                break;
            case MEMORY_GAME:
                memoryGame.display(batch);
                break;
            case FOUR_PICS:
                fourPicsGame.display(batch);
                break;
        }
    }

    @Override
    public void dispose() {
        menuBgTexture.dispose();
        switch (selectedMenu) {
            case MEMORY_GAME:
                memoryGame.dispose();
                break;
        }
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
                    selectedMenu = MEMORY_MENU;
                } else if (fourPics.getBoundingRectangle().contains(x, y)) {
                    fourPicsGame = new FourPics();
                    fourPicsGame.setUp(screenWidth, screenHeight);
                    selectedMenu = FOUR_PICS;
                }
                break;
            case MEMORY_MENU:
                if (easyMemory.getBoundingRectangle().contains(x, y)) {
                    memoryGame = new MemoryGame(MemoryGame.EASY);
                } else if (medMemory.getBoundingRectangle().contains(x, y)) {
                    memoryGame = new MemoryGame(MemoryGame.MEDIUM);
                } else if (hardMemory.getBoundingRectangle().contains(x, y)) {
                    memoryGame = new MemoryGame(MemoryGame.HARD);
                }

                memoryGame.setUp(screenWidth, screenHeight);
                selectedMenu = MEMORY_GAME;
                break;
            case MEMORY_GAME:
                memoryGame.touchDown(x, y);
                break;
            case FOUR_PICS:
                fourPicsGame.touchDown();
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
            case MEMORY_MENU:
                if (keycode == 4) selectedMenu = MINI_GAME_MENU;
                break;
            case MEMORY_GAME:
                if (keycode == 4) {
                    memoryGame.dispose();
                    memoryGame = null;
                    selectedMenu = MINI_GAME_MENU;
                }
                break;
            case FOUR_PICS:
                if (keycode == 4) {
                    fourPicsGame.dispose();
                    fourPicsGame = null;
                    selectedMenu = MINI_GAME_MENU;
                } else {
                    fourPicsGame.keyDown(keycode);
                }
                break;
        }
        return 0;
    }

    /**
     * Listen to keyboard typing so user can enter the correct
     * answer in 4pics1word
     * @param character Character typed by user
     */
    public void keyTyped(char character) {
        switch (selectedMenu) {
            case FOUR_PICS:
                fourPicsGame.keyTyped(character);
                break;
        }
    }
}
