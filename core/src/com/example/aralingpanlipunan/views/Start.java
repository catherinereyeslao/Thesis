package com.example.aralingpanlipunan.views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Disposable;
import com.example.aralingpanlipunan.AppFragment;

public class Start extends AppView implements AppFragment, Disposable {
    public static final int STUDENT = 1;
    public static final int TEACHER = 2;
    public static final int MINI_GAMES = 3;
    public static final int EXIT = 5;

    private Texture background, exitTexture, studentTexture, teacherTexture, miniGamesTexture;
    private Sprite exit, student, teacher, miniGames;
    private int touchedOption = 0;

    @Override
    public void setUp(int screenW, int screenH) {
        screenWidth = screenW;
        screenHeight = screenH;
        background = new Texture("backgrounds/start-background.jpg");
        exitTexture = new Texture("buttons/exit.png");
        studentTexture = new Texture("buttons/start/stud.png");
        teacherTexture = new Texture("buttons/start/teacher.png");
        miniGamesTexture = new Texture("buttons/start/mini.png");

        student = new Sprite(studentTexture);
        student.setSize(student.getWidth() * getButtonScale(), student.getHeight() * getButtonScale());
        final float studentX = (screenW / 2) - (student.getWidth() / 2);
        final float studentY = screenH - (screenH / 4);
        student.setPosition(studentX, studentY);
        student.setBounds(studentX, studentY, student.getWidth(), student.getHeight());

        teacher = new Sprite(teacherTexture);
        teacher.setSize(teacher.getWidth() * getButtonScale(), teacher.getHeight() * getButtonScale());
        final float teacherX = (screenW / 2) - (teacher.getWidth() / 2);
        final float teacherY = studentY - (teacher.getHeight() * 1.1f);
        teacher.setPosition(teacherX, teacherY);
        teacher.setBounds(teacherX, teacherY, teacher.getWidth(), teacher.getHeight());

        miniGames = new Sprite(miniGamesTexture);
        miniGames.setSize(miniGames.getWidth() * getButtonScale(), miniGames.getHeight() * getButtonScale());
        final float miniGamesX = (screenW / 2) - (miniGames.getWidth() / 2);
        final float miniGamesY = teacherY - (miniGames.getHeight() * 1.1f);
        miniGames.setPosition(miniGamesX, miniGamesY);
        miniGames.setBounds(miniGamesX, miniGamesY, miniGames.getWidth(), miniGames.getHeight());

        exit = new Sprite(exitTexture);
        exit.setSize(exit.getWidth() * getButtonScale(), exit.getHeight() * getButtonScale());
        final float exitX = (screenW / 2) - (exit.getWidth() / 2);
        final float exitY = miniGamesY - (exit.getHeight() * 1.1f);
        exit.setPosition(exitX, exitY);
        exit.setBounds(exitX, exitY, exit.getWidth(), exit.getHeight());
    }

    @Override
    public void display(Batch batch) {
        batch.draw(background, 0, 0, screenWidth, screenHeight);
        student.draw(batch);
        teacher.draw(batch);
        miniGames.draw(batch);
        exit.draw(batch);
    }

    @Override
    public void dispose() {
        exitTexture.dispose();
        studentTexture.dispose();
        teacherTexture.dispose();
        miniGamesTexture.dispose();
        background.dispose();
    }

    /**
     * Detect touch event within the Start view
     * @param x the x coordinate of touched screen
     * @param y the y coordinate of touched screen
     */
    public void touchDown(float x, float y) {
        if (student.getBoundingRectangle().contains(x, y)) {
            touchedOption = STUDENT;
        } else if (exit.getBoundingRectangle().contains(x, y)) {
            touchedOption = EXIT;
        }
    }

    public int touchUp(int x, int y) {
        if (student.getBoundingRectangle().contains(x, y) && touchedOption == STUDENT) {
            return STUDENT;
        } else if (exit.getBoundingRectangle().contains(x, y) && touchedOption == EXIT) {
            return EXIT;
        } else {
            touchedOption = 0;
            return 0;
        }
    }
}
