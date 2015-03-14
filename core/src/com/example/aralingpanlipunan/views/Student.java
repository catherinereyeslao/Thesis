package com.example.aralingpanlipunan.views;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.example.aralingpanlipunan.android.AndroidInterface;

/**
 * This is called when selecting "Student" from the Menu.
 */
public class Student extends UserType {
    private boolean registeringNewStudent = false;

    public Student(AndroidInterface androidInterface) {
        super(androidInterface);
    }

    @Override
    public void setUp(int screenW, int screenH) {
        super.setUp(screenW, screenH);
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
                renderChapter(selectedChapter, batch);
                break;
        }

        if (!registeringNewStudent && StudentProfile.isAlertYesTouched() && StudentProfile.getTypedName().length() > 1)
            registerAndLoginStudent();
    }

    /**
     * If the "yes" in alert box is student registration is touched,
     * register the student then log in
     */
    private void registerAndLoginStudent() {
        android.registerNewStudent(StudentProfile.getTypedName(), StudentProfile.getTypedPassword());
        studentProfile.dispose();
        studentProfile = null;
        chapterSelect = new ChapterSelect(ChapterSelect.STUDENT, StudentProfile.getTypedName(), StudentProfile.getTypedPassword(), android);
        chapterSelect.setUp(screenWidth, screenHeight);
        registeringNewStudent = true;
        StudentProfile.setAlertYesTouched(false);
        triage = CHAPTER_SELECT;
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
                disposeChapter(selectedChapter);
                break;
        }
    }

    public int touchDown(float x, float y) {
        switch (triage) {
            case STUDENT_PROFILE:
                loggedInStudentName = studentProfile.touchDown(x, y);
                if (loggedInStudentName != null) {
                    studentProfile.dispose();
                    chapterSelect = new ChapterSelect(ChapterSelect.STUDENT, loggedInStudentName, StudentProfile.getTypedPassword(), android);
                    chapterSelect.setUp(screenWidth, screenHeight);
                    triage = CHAPTER_SELECT;
                }
                break;
            case CHAPTER_SELECT:
                selectedChapter = chapterSelect.touchDown(x, y);
                if (selectedChapter != 0)
                    openChapter(selectedChapter);
                break;
            case CHAPTER_VIEW:
                int score = chapterTouchDown(selectedChapter, x, y);
                if (score > 500) {
                    selectedChapter = score - 500;
                    disposeChapter(selectedChapter - 1);
                    openChapter(selectedChapter);
                } else if (score != 100) {
                    disposeChapter(selectedChapter);
                    chapterSelect = new ChapterSelect(ChapterSelect.STUDENT, StudentProfile.getTypedName(), StudentProfile.getTypedPassword(), android);
                    chapterSelect.setUp(screenWidth, screenHeight);
                    triage = CHAPTER_SELECT;
                }
                break;
        }
        return 0;
    }

    public void keyTyped(char character) {
        switch (triage) {
            case STUDENT_PROFILE:
                studentProfile.keyTyped(character);
                break;
            case CHAPTER_VIEW:
                setKeyPressForChapter(character);
                break;
        }
    }

    private void setKeyPressForChapter(char character) {
        switch (selectedChapter) {
            case 1:
                chapterOne.keyPressed(character);
                break;
        }
    }
}
