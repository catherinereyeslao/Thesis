package com.example.aralingpanlipunan.views.minigames;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.views.AppView;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.Collections;

public class MemoryGame extends AppView {
    public static final byte EASY = 0;
    public static final byte MEDIUM = 1;
    public static final byte HARD = 2;
    private byte difficulty;
    private byte touchedIcon1, touchedIcon2;
    private Texture backgroundTexture, questionTexture, easyTexture1, easyTexture2, easyTexture3;
    private Sprite questionIcon1, questionIcon2, questionIcon3, questionIcon4, questionIcon5, questionIcon6, icon1, icon2, icon3, icon4, icon5, icon6;
    private ArrayList<Sprite> clearedIcons;

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
        touchedIcon1 = touchedIcon2 = 0;

        backgroundTexture = new Texture("minigames/background.png");
        questionTexture = new Texture("minigames/memory/easy/question.png");

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
                questionIcon1.draw(batch);
                questionIcon2.draw(batch);
                questionIcon3.draw(batch);
                questionIcon4.draw(batch);
                questionIcon5.draw(batch);
                questionIcon6.draw(batch);
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
        switch (difficulty) {
            case EASY:
                if (questionIcon1.getBoundingRectangle().contains(x, y)) {
                    questionIcon1.setAlpha(0);

                    if (touchedIcon1 == 0)
                        touchedIcon1 = 1;
                    else
                        touchedIcon2 = 1;
                } else if (questionIcon2.getBoundingRectangle().contains(x, y)) {
                    questionIcon2.setAlpha(0);

                    if (touchedIcon1 == 0)
                        touchedIcon1 = 2;
                    else
                        touchedIcon2 = 2;
                } else if (questionIcon3.getBoundingRectangle().contains(x, y)) {
                    questionIcon3.setAlpha(0);

                    if (touchedIcon1 == 0)
                        touchedIcon1 = 3;
                    else
                        touchedIcon2 = 3;
                } else if (questionIcon4.getBoundingRectangle().contains(x, y)) {
                    questionIcon4.setAlpha(0);

                    if (touchedIcon1 == 0)
                        touchedIcon1 = 4;
                    else
                        touchedIcon2 = 4;
                } else if (questionIcon5.getBoundingRectangle().contains(x, y)) {
                    questionIcon5.setAlpha(0);

                    if (touchedIcon1 == 0)
                        touchedIcon1 = 5;
                    else
                        touchedIcon2 = 5;
                } else if (questionIcon6.getBoundingRectangle().contains(x, y)) {
                    questionIcon6.setAlpha(0);

                    if (touchedIcon1 == 0)
                        touchedIcon1 = 6;
                    else
                        touchedIcon2 = 6;
                }

                if (touchedIcon1 != 0 && touchedIcon2 != 0)
                    checkIconMatch();
                break;
        }
    }

    /**
     * Loads a memory game in easy level and randomises
     * the positions of a 3x2 memory game
     */
    private void loadEasy() {
        easyTexture1 = new Texture("minigames/memory/easy/easy1.png");
        easyTexture2 = new Texture("minigames/memory/easy/easy2.png");
        easyTexture3 = new Texture("minigames/memory/easy/easy3.png");

        clearedIcons = new ArrayList<Sprite>(6);

        // Set the positions of 6 icons in the game
        final float col1 = screenWidth / 3.2f;
        final float col2 = screenWidth / 2.3f;
        final float col3 = screenWidth / 1.8f;
        final float row1 = screenHeight / 1.8f;
        final float row2 = screenHeight / 3;

        // Create a fixed array length, containing x (col) & y (row) positions
        float pos1[] = new float[2];
        pos1[0] = col1;
        pos1[1] = row1;
        float pos2[] = new float[2];
        pos2[0] = col2;
        pos2[1] = row1;
        float pos3[] = new float[2];
        pos3[0] = col3;
        pos3[1] = row1;
        float pos4[] = new float[2];
        pos4[0] = col1;
        pos4[1] = row2;
        float pos5[] = new float[2];
        pos5[0] = col2;
        pos5[1] = row2;
        float pos6[] = new float[2];
        pos6[0] = col3;
        pos6[1] = row2;

        // Create a placeholder for all array positions
        ArrayList<float[]> positions = new ArrayList<float[]>(6);
        positions.add(pos1);
        positions.add(pos2);
        positions.add(pos3);
        positions.add(pos4);
        positions.add(pos5);
        positions.add(pos6);

        // Shuffle the positions in random order
        Collections.shuffle(positions);

        icon1 = new Sprite(easyTexture1);
        icon1.setSize((icon1.getWidth() * getButtonScale()) * 1.5f, (icon1.getHeight() * getButtonScale()) * 1.5f);
        icon1.setPosition(positions.get(0)[0], positions.get(0)[1]);

        icon2 = new Sprite(easyTexture1);
        icon2.setSize(icon1.getWidth(), icon1.getHeight());
        icon2.setPosition(positions.get(1)[0], positions.get(1)[1]);

        icon3 = new Sprite(easyTexture2);
        icon3.setSize(icon1.getWidth(), icon1.getHeight());
        icon3.setPosition(positions.get(2)[0], positions.get(2)[1]);

        icon4 = new Sprite(easyTexture2);
        icon4.setSize(icon1.getWidth(), icon1.getHeight());
        icon4.setPosition(positions.get(3)[0], positions.get(3)[1]);

        icon5 = new Sprite(easyTexture3);
        icon5.setSize(icon1.getWidth(), icon1.getHeight());
        icon5.setPosition(positions.get(4)[0], positions.get(4)[1]);

        icon6 = new Sprite(easyTexture3);
        icon6.setSize(icon1.getWidth(), icon1.getHeight());
        icon6.setPosition(positions.get(5)[0], positions.get(5)[1]);

        questionIcon1 = new Sprite(questionTexture);
        questionIcon1.setSize(icon1.getWidth(), icon1.getHeight());
        questionIcon1.setPosition(icon1.getX(), icon1.getY());
        questionIcon1.setBounds(questionIcon1.getX(), questionIcon1.getY(), questionIcon1.getWidth(), questionIcon1.getHeight());

        questionIcon2 = new Sprite(questionTexture);
        questionIcon2.setSize(icon2.getWidth(), icon2.getHeight());
        questionIcon2.setPosition(icon2.getX(), icon2.getY());
        questionIcon2.setBounds(questionIcon2.getX(), questionIcon2.getY(), questionIcon2.getWidth(), questionIcon2.getHeight());

        questionIcon3 = new Sprite(questionTexture);
        questionIcon3.setSize(icon3.getWidth(), icon3.getHeight());
        questionIcon3.setPosition(icon3.getX(), icon3.getY());
        questionIcon3.setBounds(questionIcon3.getX(), questionIcon3.getY(), questionIcon3.getWidth(), questionIcon3.getHeight());

        questionIcon4 = new Sprite(questionTexture);
        questionIcon4.setSize(icon4.getWidth(), icon4.getHeight());
        questionIcon4.setPosition(icon4.getX(), icon4.getY());
        questionIcon4.setBounds(questionIcon4.getX(), questionIcon4.getY(), questionIcon4.getWidth(), questionIcon4.getHeight());

        questionIcon5 = new Sprite(questionTexture);
        questionIcon5.setSize(icon5.getWidth(), icon5.getHeight());
        questionIcon5.setPosition(icon5.getX(), icon5.getY());
        questionIcon5.setBounds(questionIcon5.getX(), questionIcon5.getY(), questionIcon5.getWidth(), questionIcon5.getHeight());

        questionIcon6 = new Sprite(questionTexture);
        questionIcon6.setSize(icon6.getWidth(), icon6.getHeight());
        questionIcon6.setPosition(icon6.getX(), icon6.getY());
        questionIcon6.setBounds(questionIcon6.getX(), questionIcon6.getY(), questionIcon6.getWidth(), questionIcon6.getHeight());

        positions.clear();
    }

    /**
     * Checks if the 2 clicked icons are a match. If match, the icons
     * will no longer be question marked. Otherwise, they will be question
     * marked
     */
    private void checkIconMatch() {
        boolean isDoneChecking = false;
        switch (difficulty) {
            case EASY:
                if (!clearedIcons.contains(questionIcon1)) {
                    if (touchedIcon1 == 1 && touchedIcon2 == 2 || touchedIcon1 == 2 && touchedIcon2 == 1) {
                        clearedIcons.add(questionIcon1);
                        clearedIcons.add(questionIcon2);
                        questionIcon1.setBounds(0, 0, 0, 0);
                        questionIcon2.setBounds(0, 0, 0, 0);
                        isDoneChecking = true;
                    }
                }
                if (!clearedIcons.contains(questionIcon3)) {
                    if (touchedIcon1 == 3 && touchedIcon2 == 4 || touchedIcon1 == 4 && touchedIcon2 == 3) {
                        clearedIcons.add(questionIcon3);
                        clearedIcons.add(questionIcon4);
                        questionIcon3.setBounds(0, 0, 0, 0);
                        questionIcon4.setBounds(0, 0, 0, 0);
                        isDoneChecking = true;
                    }
                }
                if (!clearedIcons.contains(questionIcon5)) {
                    if (touchedIcon1 == 5 && touchedIcon2 == 6 || touchedIcon1 == 6 && touchedIcon2 == 5) {
                        clearedIcons.add(questionIcon5);
                        clearedIcons.add(questionIcon6);
                        questionIcon5.setBounds(0, 0, 0, 0);
                        questionIcon6.setBounds(0, 0, 0, 0);
                        isDoneChecking = true;
                    }
                }

                touchedIcon1 = touchedIcon2 = 0;
                if (isDoneChecking) break;

                questionIcon1.setAlpha(1);
                questionIcon2.setAlpha(1);
                questionIcon3.setAlpha(1);
                questionIcon4.setAlpha(1);
                questionIcon5.setAlpha(1);
                questionIcon6.setAlpha(1);
                break;
        }
    }
}
