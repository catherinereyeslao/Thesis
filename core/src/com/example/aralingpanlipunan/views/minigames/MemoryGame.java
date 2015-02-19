package com.example.aralingpanlipunan.views.minigames;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.views.AppView;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The Memory Game. Can be played in 3 difficulties. Easy mode is 3x2
 * memory game. Average mode is 3x4. Difficult is 4x4
 */
public class MemoryGame extends AppView {
    public static final byte EASY = 0;
    public static final byte MEDIUM = 1;
    public static final byte HARD = 2;
    private byte difficulty;
    private byte touchedIcon1, touchedIcon2;
    private Texture backgroundTexture, questionTexture, easyTexture1, easyTexture2, easyTexture3, medTexture1, medTexture2, medTexture3, medTexture4, medTexture5, medTexture6;
    private Sprite questionIcon1, questionIcon2, questionIcon3, questionIcon4, questionIcon5, questionIcon6, questionIcon7, questionIcon8, questionIcon9, questionIcon10, questionIcon11, questionIcon12, icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8, icon9, icon10, icon11, icon12;
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
        questionTexture = new Texture("minigames/memory/question.png");

        switch (difficulty) {
            case EASY:
                loadEasy();
                break;
            case MEDIUM:
                loadMedium();
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
            case MEDIUM:
                icon1.draw(batch);
                icon2.draw(batch);
                icon3.draw(batch);
                icon4.draw(batch);
                icon5.draw(batch);
                icon6.draw(batch);
                icon7.draw(batch);
                icon8.draw(batch);
                icon9.draw(batch);
                icon10.draw(batch);
                icon11.draw(batch);
                icon12.draw(batch);
                questionIcon1.draw(batch);
                questionIcon2.draw(batch);
                questionIcon3.draw(batch);
                questionIcon4.draw(batch);
                questionIcon5.draw(batch);
                questionIcon6.draw(batch);
                questionIcon7.draw(batch);
                questionIcon8.draw(batch);
                questionIcon9.draw(batch);
                questionIcon10.draw(batch);
                questionIcon11.draw(batch);
                questionIcon12.draw(batch);
                break;
        }
    }

    @Override
    public void dispose() {
        backgroundTexture.dispose();
        questionTexture.dispose();
        switch (difficulty) {
            case EASY:
                easyTexture1.dispose();
                easyTexture2.dispose();
                easyTexture3.dispose();
                break;
            case MEDIUM:
                medTexture1.dispose();
                medTexture2.dispose();
                medTexture3.dispose();
                medTexture4.dispose();
                medTexture5.dispose();
                medTexture6.dispose();
                break;
        }
    }

    /**
     * Detect touch down listener for the Memory Game
     * @param x X coordinate of touched screen
     * @param y Y coordinate of touched screen
     */
    public void touchDown(float x, float y) {
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

        if (difficulty == MEDIUM || difficulty == HARD) {
            if (questionIcon7.getBoundingRectangle().contains(x, y)) {
                questionIcon7.setAlpha(0);

                if (touchedIcon1 == 0)
                    touchedIcon1 = 7;
                else
                    touchedIcon2 = 7;
            } else if (questionIcon8.getBoundingRectangle().contains(x, y)) {
                questionIcon8.setAlpha(0);

                if (touchedIcon1 == 0)
                    touchedIcon1 = 8;
                else
                    touchedIcon2 = 8;
            } else if (questionIcon9.getBoundingRectangle().contains(x, y)) {
                questionIcon9.setAlpha(0);

                if (touchedIcon1 == 0)
                    touchedIcon1 = 9;
                else
                    touchedIcon2 = 9;
            } else if (questionIcon10.getBoundingRectangle().contains(x, y)) {
                questionIcon10.setAlpha(0);

                if (touchedIcon1 == 0)
                    touchedIcon1 = 10;
                else
                    touchedIcon2 = 10;
            } else if (questionIcon11.getBoundingRectangle().contains(x, y)) {
                questionIcon11.setAlpha(0);

                if (touchedIcon1 == 0)
                    touchedIcon1 = 11;
                else
                    touchedIcon2 = 11;
            } else if (questionIcon12.getBoundingRectangle().contains(x, y)) {
                questionIcon12.setAlpha(0);

                if (touchedIcon1 == 0)
                    touchedIcon1 = 12;
                else
                    touchedIcon2 = 12;
            }
        }

        if (touchedIcon1 != 0 && touchedIcon2 != 0)
            checkIconMatch();
    }

    /**
     * Loads a memory game in easy level and randomises
     * the icon positions of a 3x2 memory game
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
     * Loads a memory game in average level and randomises
     * the icon positions of a 3x4 memory game
     */
    private void loadMedium() {
        medTexture1 = new Texture("minigames/memory/medium/average1.png");
        medTexture2 = new Texture("minigames/memory/medium/average2.png");
        medTexture3 = new Texture("minigames/memory/medium/average3.png");
        medTexture4 = new Texture("minigames/memory/medium/average4.png");
        medTexture5 = new Texture("minigames/memory/medium/average5.png");
        medTexture6 = new Texture("minigames/memory/medium/average6.png");

        clearedIcons = new ArrayList<Sprite>(12);

        // Set the positions of 6 icons in the game
        final float col1 = screenWidth / 3.2f;
        final float col2 = screenWidth / 2.3f;
        final float col3 = screenWidth / 1.8f;
        final float row1 = screenHeight / 1.4f;
        final float row2 = screenHeight / 1.95f;
        final float row3 = screenHeight / 3.2f;
        final float row4 = screenHeight / 8;

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
        float pos7[] = new float[2];
        pos7[0] = col1;
        pos7[1] = row3;
        float pos8[] = new float[2];
        pos8[0] = col2;
        pos8[1] = row3;
        float pos9[] = new float[2];
        pos9[0] = col3;
        pos9[1] = row3;
        float pos10[] = new float[2];
        pos10[0] = col1;
        pos10[1] = row4;
        float pos11[] = new float[2];
        pos11[0] = col2;
        pos11[1] = row4;
        float pos12[] = new float[2];
        pos12[0] = col3;
        pos12[1] = row4;

        // Create a placeholder for all array positions
        ArrayList<float[]> positions = new ArrayList<float[]>(12);
        positions.add(pos1);
        positions.add(pos2);
        positions.add(pos3);
        positions.add(pos4);
        positions.add(pos5);
        positions.add(pos6);
        positions.add(pos7);
        positions.add(pos8);
        positions.add(pos9);
        positions.add(pos10);
        positions.add(pos11);
        positions.add(pos12);

        // Shuffle the positions in random order
        Collections.shuffle(positions);

        icon1 = new Sprite(medTexture1);
        icon1.setSize((icon1.getWidth() * getButtonScale()) * 1.5f, (icon1.getHeight() * getButtonScale()) * 1.5f);
        icon1.setPosition(positions.get(0)[0], positions.get(0)[1]);

        icon2 = new Sprite(medTexture1);
        icon2.setSize(icon1.getWidth(), icon1.getHeight());
        icon2.setPosition(positions.get(1)[0], positions.get(1)[1]);

        icon3 = new Sprite(medTexture2);
        icon3.setSize(icon1.getWidth(), icon1.getHeight());
        icon3.setPosition(positions.get(2)[0], positions.get(2)[1]);

        icon4 = new Sprite(medTexture2);
        icon4.setSize(icon1.getWidth(), icon1.getHeight());
        icon4.setPosition(positions.get(3)[0], positions.get(3)[1]);

        icon5 = new Sprite(medTexture3);
        icon5.setSize(icon1.getWidth(), icon1.getHeight());
        icon5.setPosition(positions.get(4)[0], positions.get(4)[1]);

        icon6 = new Sprite(medTexture3);
        icon6.setSize(icon1.getWidth(), icon1.getHeight());
        icon6.setPosition(positions.get(5)[0], positions.get(5)[1]);


        icon7 = new Sprite(medTexture4);
        icon7.setSize(icon1.getWidth(), icon1.getHeight());
        icon7.setPosition(positions.get(6)[0], positions.get(6)[1]);

        icon8 = new Sprite(medTexture4);
        icon8.setSize(icon1.getWidth(), icon1.getHeight());
        icon8.setPosition(positions.get(7)[0], positions.get(7)[1]);

        icon9 = new Sprite(medTexture5);
        icon9.setSize(icon1.getWidth(), icon1.getHeight());
        icon9.setPosition(positions.get(8)[0], positions.get(8)[1]);

        icon10 = new Sprite(medTexture5);
        icon10.setSize(icon1.getWidth(), icon1.getHeight());
        icon10.setPosition(positions.get(9)[0], positions.get(9)[1]);

        icon11 = new Sprite(medTexture6);
        icon11.setSize(icon1.getWidth(), icon1.getHeight());
        icon11.setPosition(positions.get(10)[0], positions.get(10)[1]);

        icon12 = new Sprite(medTexture6);
        icon12.setSize(icon1.getWidth(), icon1.getHeight());
        icon12.setPosition(positions.get(11)[0], positions.get(11)[1]);
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

        questionIcon7 = new Sprite(questionTexture);
        questionIcon7.setSize(icon7.getWidth(), icon7.getHeight());
        questionIcon7.setPosition(icon7.getX(), icon7.getY());
        questionIcon7.setBounds(questionIcon7.getX(), questionIcon7.getY(), questionIcon7.getWidth(), questionIcon7.getHeight());

        questionIcon8 = new Sprite(questionTexture);
        questionIcon8.setSize(icon8.getWidth(), icon8.getHeight());
        questionIcon8.setPosition(icon8.getX(), icon8.getY());
        questionIcon8.setBounds(questionIcon8.getX(), questionIcon8.getY(), questionIcon8.getWidth(), questionIcon8.getHeight());

        questionIcon9 = new Sprite(questionTexture);
        questionIcon9.setSize(icon9.getWidth(), icon9.getHeight());
        questionIcon9.setPosition(icon9.getX(), icon9.getY());
        questionIcon9.setBounds(questionIcon9.getX(), questionIcon9.getY(), questionIcon9.getWidth(), questionIcon9.getHeight());

        questionIcon10 = new Sprite(questionTexture);
        questionIcon10.setSize(icon10.getWidth(), icon10.getHeight());
        questionIcon10.setPosition(icon10.getX(), icon10.getY());
        questionIcon10.setBounds(questionIcon10.getX(), questionIcon10.getY(), questionIcon10.getWidth(), questionIcon10.getHeight());

        questionIcon11 = new Sprite(questionTexture);
        questionIcon11.setSize(icon11.getWidth(), icon11.getHeight());
        questionIcon11.setPosition(icon11.getX(), icon11.getY());
        questionIcon11.setBounds(questionIcon11.getX(), questionIcon11.getY(), questionIcon11.getWidth(), questionIcon11.getHeight());

        questionIcon12 = new Sprite(questionTexture);
        questionIcon12.setSize(icon12.getWidth(), icon12.getHeight());
        questionIcon12.setPosition(icon12.getX(), icon12.getY());
        questionIcon12.setBounds(questionIcon12.getX(), questionIcon12.getY(), questionIcon12.getWidth(), questionIcon12.getHeight());

        positions.clear();
    }

    /**
     * Checks if the 2 clicked icons are a match. If match, the icons
     * will no longer be question marked. Otherwise, they will be question
     * marked
     */
    private void checkIconMatch() {
        if (!clearedIcons.contains(questionIcon1)) {
            if (touchedIcon1 == 1 && touchedIcon2 == 2 || touchedIcon1 == 2 && touchedIcon2 == 1) {
                clearedIcons.add(questionIcon1);
                clearedIcons.add(questionIcon2);
                questionIcon1.setBounds(0, 0, 0, 0);
                questionIcon2.setBounds(0, 0, 0, 0);
            } else {
                questionIcon1.setAlpha(1);
                questionIcon2.setAlpha(1);
            }
        }
        if (!clearedIcons.contains(questionIcon3)) {
            if (touchedIcon1 == 3 && touchedIcon2 == 4 || touchedIcon1 == 4 && touchedIcon2 == 3) {
                clearedIcons.add(questionIcon3);
                clearedIcons.add(questionIcon4);
                questionIcon3.setBounds(0, 0, 0, 0);
                questionIcon4.setBounds(0, 0, 0, 0);
            } else {
                questionIcon3.setAlpha(1);
                questionIcon4.setAlpha(1);
            }
        }
        if (!clearedIcons.contains(questionIcon5)) {
            if (touchedIcon1 == 5 && touchedIcon2 == 6 || touchedIcon1 == 6 && touchedIcon2 == 5) {
                clearedIcons.add(questionIcon5);
                clearedIcons.add(questionIcon6);
                questionIcon5.setBounds(0, 0, 0, 0);
                questionIcon6.setBounds(0, 0, 0, 0);
            } else {
                questionIcon5.setAlpha(1);
                questionIcon6.setAlpha(1);
            }
        }

        if (difficulty == MEDIUM || difficulty == HARD) {
            if (!clearedIcons.contains(questionIcon7)) {
                if (touchedIcon1 == 7 && touchedIcon2 == 8 || touchedIcon1 == 8 && touchedIcon2 == 7) {
                    clearedIcons.add(questionIcon7);
                    clearedIcons.add(questionIcon8);
                    questionIcon7.setBounds(0, 0, 0, 0);
                    questionIcon8.setBounds(0, 0, 0, 0);
                } else {
                    questionIcon7.setAlpha(1);
                    questionIcon8.setAlpha(1);
                }
            }
            if (!clearedIcons.contains(questionIcon9)) {
                if (touchedIcon1 == 9 && touchedIcon2 == 10 || touchedIcon1 == 10 && touchedIcon2 == 9) {
                    clearedIcons.add(questionIcon9);
                    clearedIcons.add(questionIcon10);
                    questionIcon9.setBounds(0, 0, 0, 0);
                    questionIcon10.setBounds(0, 0, 0, 0);
                } else {
                    questionIcon9.setAlpha(1);
                    questionIcon10.setAlpha(1);
                }
            }
            if (!clearedIcons.contains(questionIcon11)) {
                if (touchedIcon1 == 11 && touchedIcon2 == 12 || touchedIcon1 == 12 && touchedIcon2 == 11) {
                    clearedIcons.add(questionIcon11);
                    clearedIcons.add(questionIcon12);
                    questionIcon11.setBounds(0, 0, 0, 0);
                    questionIcon11.setBounds(0, 0, 0, 0);
                } else {
                    questionIcon11.setAlpha(1);
                    questionIcon12.setAlpha(1);
                }
            }
        }

        touchedIcon1 = touchedIcon2 = 0;
    }
}
