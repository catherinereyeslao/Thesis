package com.example.aralingpanlipunan.views;

import android.util.Log;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Disposable;
import com.example.aralingpanlipunan.AppFragment;
import com.example.aralingpanlipunan.android.AndroidInterface;

/**
 * This is called when selecting "Student" from the Menu.
 */
public class Student extends AppView implements AppFragment, Disposable {
    private static final int STUDENT_PROFILE = 0;
    private static final int CHAPTER_SELECT = 1;
    private static final int CHAPTER_VIEW = 2;
    private int selectedChapter;
    private int triage = STUDENT_PROFILE;
    private String loggedInStudentName;
    private StudentProfile studentProfile;
    private ChapterSelect chapterSelect;
    private ChapterView chapterView;
    private AndroidInterface android;

    /**
     * If we are running in android, give Student view access to android interface
     * so we can manage its database
     * @param androidInterface android interface to interact with native android functions
     */
    public Student(AndroidInterface androidInterface) {
        android = androidInterface;
    }

    @Override
    public void setUp(int screenW, int screenH) {
        screenWidth = screenW;
        screenHeight = screenH;
        studentProfile = new StudentProfile(android);
        studentProfile.setUp(screenW, screenH);
    }

    @Override
    public void display(Batch batch) {
        switch (triage) {
            case STUDENT_PROFILE:
                studentProfile.display(batch);
                break;
            case CHAPTER_SELECT:
                chapterSelect.display(batch);
                break;
            case CHAPTER_VIEW:
                chapterView.display(batch);
                break;
        }
    }

    @Override
    public void dispose() {
        switch (triage) {
            case STUDENT_PROFILE:
                studentProfile.dispose();
                break;
            case CHAPTER_SELECT:
                chapterSelect.dispose();
                break;
            case CHAPTER_VIEW:
                chapterView.dispose();
                break;
        }
    }

    public int touchDown(float x, float y) {
        switch (triage) {
            case STUDENT_PROFILE:
                loggedInStudentName = studentProfile.touchDown(x, y);
                if (loggedInStudentName != null) {
                    studentProfile.dispose();
                    chapterSelect = new ChapterSelect(ChapterSelect.STUDENT, loggedInStudentName, android);
                    chapterSelect.setUp(screenWidth, screenHeight);
                    triage = CHAPTER_SELECT;
                }
                break;
            case CHAPTER_SELECT:
                selectedChapter = chapterSelect.touchDown(x, y);
                if (selectedChapter != 0) {
                    chapterSelect.dispose();
                    chapterView = new ChapterView(selectedChapter);
                    chapterView.setUp(screenWidth, screenHeight);
                    triage = CHAPTER_VIEW;
                }
                break;
            case CHAPTER_VIEW:
                int score = chapterView.touchDown(x, y);
                if (score != 100) {
                    if (score != 50) {
                        android.showToast("You scored " + score, 1);
                        android.setStudentScore(loggedInStudentName, "1", score);
                    }
                    chapterView.dispose();
                    chapterSelect = new ChapterSelect(ChapterSelect.STUDENT, loggedInStudentName, android);
                    chapterSelect.setUp(screenWidth, screenHeight);
                    triage = CHAPTER_SELECT;
                }
                break;
        }
        return 0;
    }

    public void touchDragged(int x, int y) {
        switch (triage) {
            case STUDENT_PROFILE:
                //TODO: Maybe completely remove this if not needed?
                break;
            case CHAPTER_SELECT:
                chapterSelect.touchDragged(x, y);
                break;
            case CHAPTER_VIEW:
                chapterView.touchDragged(x);
                break;
        }
    }

    public void touchUp(int x, int y) {
        switch (triage) {
            case CHAPTER_VIEW:
                chapterView.touchUp();
                break;
        }
    }

    /**
     * If android's back key is pressed, return 1 to Main class to give a signal to go back
     * to Start
     * @param keycode the keycode of the pressed button
     * @return int
     */
    public int keyDown(int keycode) {
        switch (triage) {
            case CHAPTER_SELECT:
                return keycode == 4 && chapterSelect.isSetUp() ? 1 : 0;
            case STUDENT_PROFILE:
                studentProfile.keyDown(keycode);
                break;
            case CHAPTER_VIEW:
                if (chapterView.keydown(keycode) == 1) {
                    chapterView.dispose();
                    chapterSelect = new ChapterSelect(ChapterSelect.STUDENT, loggedInStudentName, android);
                    chapterSelect.setUp(screenWidth, screenHeight);
                    triage = CHAPTER_SELECT;
                    return 0;
                }
                break;
        }
        return 0;
    }

    public void keyTyped(char character) {
        if (triage == STUDENT_PROFILE)
            studentProfile.keyTyped(character);
    }
}
