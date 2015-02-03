package com.example.aralingpanlipunan.views;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Disposable;
import com.example.aralingpanlipunan.AppFragment;
import com.example.aralingpanlipunan.android.AndroidInterface;
import com.example.aralingpanlipunan.views.chapters.*;

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
    private ChapterOne chapterOne;
    private ChapterTwo chapterTwo;
    private ChapterThree chapterThree;
    private ChapterFour chapterFour;
    private ChapterFive chapterFive;
    private ChapterSix chapterSix;
    private ChapterSeven chapterSeven;
    private ChapterEight chapterEight;
    private ChapterNine chapterNine;
    private ChapterTen chapterTen;
    private ChapterEleven chapterEleven;

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
                renderChapter(selectedChapter, batch);
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
                    chapterSelect = new ChapterSelect(ChapterSelect.STUDENT, loggedInStudentName, android);
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
                    chapterSelect = new ChapterSelect(ChapterSelect.STUDENT, loggedInStudentName, android);
                    chapterSelect.setUp(screenWidth, screenHeight);
                    triage = CHAPTER_SELECT;
                }
                break;
        }
        return 0;
    }

    private void disposeChapter(int chapNum) {
        switch (chapNum) {
            case 1:
                chapterOne.dispose();
                break;
            case 2:
                chapterTwo.dispose();
                break;
            case 3:
                chapterThree.dispose();
                break;
            case 4:
                chapterFour.dispose();
                break;
            case 5:
                chapterFive.dispose();
                break;
            case 6:
                chapterSix.dispose();
                break;
            case 7:
                chapterSeven.dispose();
                break;
            case 8:
                chapterEight.dispose();
                break;
            case 9:
                chapterNine.dispose();
                break;
            case 10:
                chapterTen.dispose();
                break;
            case 11:
                chapterEleven.dispose();
                break;
            
        }
    }

    private int chapterTouchDown(int chapNum, float x, float y) {
        switch (chapNum) {
            case 1:
                return chapterOne.touchDown(x, y);
            case 2:
                return chapterTwo.touchDown(x, y);
            case 3:
            	return chapterThree.touchDown(x, y);
            case 4:
                return chapterFour.touchDown(x, y);
            case 5:
                return chapterFive.touchDown(x, y);
            case 6:
                return chapterSix.touchDown(x, y);
            case 7:
                return chapterSeven.touchDown(x, y);
            case 8:
            	return chapterEight.touchDown(x, y);
            case 9:
            	return chapterNine.touchDown(x, y);
            case 10:
            	return chapterTen.touchDown(x, y);
            case 11:
            	return chapterEleven.touchDown(x, y);
           
        }
        return 100;
    }

    public void touchDragged(int x) {
        switch (triage) {
            case CHAPTER_SELECT:
                chapterSelect.touchDragged(x);
                break;
            case CHAPTER_VIEW:
                chapterTouchDrag(selectedChapter, x);
                break;
        }
    }

    public void touchUp() {
        switch (triage) {
            case CHAPTER_VIEW:
                chapterTouchUp(selectedChapter);
                break;
        }
    }

    private void chapterTouchUp(int chapNum) {
        switch (chapNum) {
            case 1:
                chapterOne.touchUp();
                break;
            case 2:
                chapterTwo.touchUp();
                break;
            case 3:
                chapterThree.touchUp();
                break;
            case 4:
                chapterFour.touchUp();
                break;
            case 5:
                chapterFive.touchUp();
                break;
            case 6:
                chapterSix.touchUp();
                break;
            case 7:
                chapterSeven.touchUp();
                break;
            case 8:
                chapterEight.touchUp();
                break;
            case 9:
            	chapterNine.touchUp();
                break;
            case 10:
            	chapterTen.touchUp();
                break;
            case 11:
            	chapterEleven.touchUp();
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
                return studentProfile.keyDown(keycode);
            case CHAPTER_VIEW:
                chapterKeyDown(selectedChapter, keycode);
                break;
        }
        return 0;
    }

    public void keyTyped(char character) {
        if (triage == STUDENT_PROFILE)
            studentProfile.keyTyped(character);
    }

    /**
     * Opens the Chapter lecture
     * @param chapNum The chapter number to open
     */
    private void openChapter(int chapNum) {
        try {
            chapterSelect.dispose();
        } catch (NullPointerException e) {
            // Do nothing, user probably didn't open a chapter from Chapter select menu (e.g. Chapter 1)
        }
        switch (chapNum) {
            case 1:
                chapterOne = new ChapterOne(android, loggedInStudentName);
                chapterOne.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 2:
                chapterTwo = new ChapterTwo(android, loggedInStudentName);
                chapterTwo.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 3:
                chapterThree = new ChapterThree(android, loggedInStudentName);
                chapterThree.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 4:
                chapterFour = new ChapterFour(android, loggedInStudentName);
                chapterFour.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 5:
                chapterFive = new ChapterFive(android, loggedInStudentName);
                chapterFive.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 6:
                chapterSix = new ChapterSix(android, loggedInStudentName);
                chapterSix.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 7:
                chapterSeven = new ChapterSeven(android, loggedInStudentName);
                chapterSeven.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 8:
                chapterEight = new ChapterEight(android, loggedInStudentName);
                chapterEight.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 9:
                chapterNine = new ChapterNine(android, loggedInStudentName);
                chapterNine.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 10:
                chapterTen = new ChapterTen(android, loggedInStudentName);
                chapterTen.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 11:
                chapterEleven = new ChapterEleven(android, loggedInStudentName);
                chapterEleven.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
           
        }
    }

    /**
     * Renders the correct chapter class
     * @param chapNum Chapter number to render
     * @param batch batch where we will draw the chapter class
     */
    private void renderChapter(int chapNum, Batch batch) {
        switch (chapNum) {
            case 1:
                chapterOne.display(batch);
                break;
            case 2:
                chapterTwo.display(batch);
                break;
            case 3:
                chapterThree.display(batch);
                break;
            case 4:
                chapterFour.display(batch);
                break;
            case 5:
                chapterFive.display(batch);
                break;
            case 6:
                chapterSix.display(batch);
                break;
            case 7:
                chapterSeven.display(batch);
                break;
            case 8:
                chapterEight.display(batch);
                break;
            case 9:
                chapterNine.display(batch);
                break;
            case 10:
                chapterTen.display(batch);
                break;
            case 11:
                chapterEleven.display(batch);
                break;
          
        }
    }

    /**
     * Set Key down listener
     * @param chapNum Chapter number to render
     * @param keycode number of keycode pressed in android device
     * @return int
     */
    private int chapterKeyDown(int chapNum, int keycode) {
        boolean backPressed = false;
        switch (chapNum) {
            case 1:
                if (chapterOne.keyDown(keycode) == 1) {
                    chapterOne.dispose();
                    backPressed = true;
                }
                break;
            case 2:
                if (chapterTwo.keyDown(keycode) == 1) {
                    chapterTwo.dispose();
                    backPressed = true;
                }
                break;
            case 3:
                if (chapterThree.keyDown(keycode) == 1) {
                    chapterThree.dispose();
                    backPressed = true;
                }
                break;
            case 4:
                if (chapterFour.keyDown(keycode) == 1) {
                    chapterFour.dispose();
                    backPressed = true;
                }
                break;
            case 5:
                if (chapterFive.keyDown(keycode) == 1) {
                    chapterFive.dispose();
                    backPressed = true;
                }
                break;
            case 6:
                if (chapterSix.keyDown(keycode) == 1) {
                    chapterSix.dispose();
                    backPressed = true;
                }
                break;
            case 7:
                if (chapterSeven.keyDown(keycode) == 1) {
                    chapterSeven.dispose();
                    backPressed = true;
                }
                break;
            case 8:
                if (chapterEight.keyDown(keycode) == 1) {
                    chapterEight.dispose();
                    backPressed = true;
                }
                break;
            case 9:
                if (chapterNine.keyDown(keycode) == 1) {
                    chapterNine.dispose();
                    backPressed = true;
                }
                break;
            case 10:
                if (chapterTen.keyDown(keycode) == 1) {
                    chapterTen.dispose();
                    backPressed = true;
                }
                break;
            case 11:
                if (chapterEleven.keyDown(keycode) == 1) {
                    chapterEleven.dispose();
                    backPressed = true;
                }
                break;
           
        }
        if (backPressed) {
            chapterSelect = new ChapterSelect(ChapterSelect.STUDENT, loggedInStudentName, android);
            chapterSelect.setUp(screenWidth, screenHeight);
            triage = CHAPTER_SELECT;
            return 0;
        }
        return 100;
    }

    private void chapterTouchDrag(int chapNum, int x) {
        switch (chapNum) {
            case 1:
                chapterOne.touchDragged(x);
                break;
            case 2:
                chapterTwo.touchDragged(x);
                break;
            case 3:
                chapterThree.touchDragged(x);
                break;
            case 4:
                chapterFour.touchDragged(x);
                break;
            case 5:
                chapterFive.touchDragged(x);
                break;
            case 6:
                chapterSix.touchDragged(x);
                break;
            case 7:
                chapterSeven.touchDragged(x);
                break;
            case 8:
                chapterEight.touchDragged(x);
                break;
            case 9:
                chapterNine.touchDragged(x);
                break;
            case 10:
                chapterTen.touchDragged(x);
                break;
            case 11:
                chapterEleven.touchDragged(x);
                break;
            
        }
    }
}
