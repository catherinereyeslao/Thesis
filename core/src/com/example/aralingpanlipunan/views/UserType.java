package com.example.aralingpanlipunan.views;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Disposable;
import com.example.aralingpanlipunan.AppFragment;
import com.example.aralingpanlipunan.android.AndroidInterface;
import com.example.aralingpanlipunan.views.chapters.*;

import java.security.InvalidParameterException;

/**
 * This abstract class is extended by Student & Teacher views, which share many common properties and methods.
 */
abstract class UserType extends AppView implements AppFragment, Disposable {
    protected static final int STUDENT_PROFILE = 0;
    protected static final int CHAPTER_SELECT = 1;
    protected static final int CHAPTER_VIEW = 2;

    protected int selectedChapter, triage = 0;
    protected String loggedInStudentName;

    protected StudentProfile studentProfile;
    protected ChapterSelect chapterSelect;
    protected ChapterOne chapterOne;
    protected ChapterTwo chapterTwo;
    protected ChapterThree chapterThree;
    protected ChapterFour chapterFour;
    protected ChapterFive chapterFive;
    protected ChapterSix chapterSix;
    protected ChapterSeven chapterSeven;
    protected ChapterEight chapterEight;
    protected ChapterNine chapterNine;
    protected ChapterTen chapterTen;
    protected ChapterEleven chapterEleven;
    protected ChapterTwelve chapterTwelve;
    protected ChapterThirteen chapterThirteen;
    protected ChapterFourteen chapterFourteen;
    protected ChapterFifteen chapterFifteen;
    protected ChapterSixteen chapterSixteen;
    protected ChapterSeventeen chapterSeventeen;
    protected ChapterEighteen chapterEighteen;
    protected ChapterNineteen chapterNineteen;
    protected AndroidInterface android;

    private boolean isTeacher = false;

    /**
     * If we are running in android, give Student view access to android interface
     * so we can manage its database
     * @param androidInterface android interface to interact with native android functions
     */
    public UserType(AndroidInterface androidInterface) {
        android = androidInterface;
    }

    public UserType(AndroidInterface androidInterface, boolean isTeacher) {
        if (!isTeacher)
            throw new InvalidParameterException("isTeacher can either be true or student name");
        this.android = androidInterface;
        this.isTeacher = true;
        this.triage = CHAPTER_SELECT;
    }

    @Override
    public void setUp(int screenW, int screenH) {
        screenWidth = screenW;
        screenHeight = screenH;
    }

    /**
     * Dispose a chapter based on the passed argument
     * @param chapNum The chapter number to dispose
     */
    protected void disposeChapter(int chapNum) {
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
            case 12:
                chapterTwelve.dispose();
                break;
            case 13:
                chapterThirteen.dispose();
                break;
            case 14:
                chapterFourteen.dispose();
                break;
            case 15:
                chapterFifteen.dispose();
                break;
            case 16:
                chapterSixteen.dispose();
                break;
            case 17:
                chapterSeventeen.dispose();
                break;
            case 18:
                chapterEighteen.dispose();
                break;
            case 19:
                chapterNineteen.dispose();
                break;
        }
    }

    /**
     * Listen to a touch down event depending on what current chapter
     * being accessed
     * @param chapNum The chapter number in integer format
     * @param x The x coordinate of touched screen
     * @param y The y coordinate of touched screen
     * @return int to signify whether the app should go to next chapter, exit or do nothing
     */
    protected int chapterTouchDown(int chapNum, float x, float y) {
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
            case 12:
                return chapterTwelve.touchDown(x, y);
            case 13:
                return chapterThirteen.touchDown(x, y);
            case 14:
                return chapterFourteen.touchDown(x, y);
            case 15:
                return chapterFifteen.touchDown(x, y);
            case 16:
                return chapterSixteen.touchDown(x, y);
            case 17:
                return chapterSeventeen.touchDown(x, y);
            case 18:
                return chapterEighteen.touchDown(x, y);
            case 19:
                return chapterNineteen.touchDown(x, y);
        }
        return 100;
    }

    /**
     * Listen to touch drag event. This is used to slide in
     * chapter select & lectures
     * @param x The x coordinate of currently touched screen
     */
    public void touchDragged(int x) {
        switch (triage) {
            case CHAPTER_SELECT:
                chapterSelect.touchDragged(x);
                break;
        }
    }

    /**
     * Opens the Chapter lecture
     * @param chapNum The chapter number to open
     */
    protected void openChapter(int chapNum) {
        try {
            chapterSelect.dispose();
        } catch (NullPointerException e) {
            // Do nothing, user probably didn't open a chapter from Chapter select menu (e.g. Chapter 1)
        }
        switch (chapNum) {
            case 1:
                if (isTeacher)
                    chapterOne = new ChapterOne(android, true);
                else
                    chapterOne = new ChapterOne(android, loggedInStudentName, StudentProfile.getTypedPassword());
                chapterOne.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 2:
                if (isTeacher)
                    chapterTwo = new ChapterTwo(android, true);
                else
                    chapterTwo = new ChapterTwo(android, loggedInStudentName, StudentProfile.getTypedPassword());
                chapterTwo.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 3:
                if (isTeacher)
                    chapterThree = new ChapterThree(android, true);
                else
                    chapterThree = new ChapterThree(android, loggedInStudentName, StudentProfile.getTypedPassword());
                chapterThree.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 4:
                if (isTeacher)
                    chapterFour = new ChapterFour(android, true);
                else
                    chapterFour = new ChapterFour(android, loggedInStudentName, StudentProfile.getTypedPassword());
                chapterFour.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 5:
                if (isTeacher)
                    chapterFive = new ChapterFive(android, true);
                else
                    chapterFive = new ChapterFive(android, loggedInStudentName, StudentProfile.getTypedPassword());
                chapterFive.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 6:
                if (isTeacher)
                    chapterSix = new ChapterSix(android, true);
                else
                    chapterSix = new ChapterSix(android, loggedInStudentName, StudentProfile.getTypedPassword());
                chapterSix.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 7:
                if (isTeacher)
                    chapterSeven = new ChapterSeven(android, true);
                else
                    chapterSeven = new ChapterSeven(android, loggedInStudentName, StudentProfile.getTypedPassword());
                chapterSeven.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 8:
                if (isTeacher)
                    chapterEight = new ChapterEight(android, true);
                else
                    chapterEight = new ChapterEight(android, loggedInStudentName, StudentProfile.getTypedPassword());
                chapterEight.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 9:
                if (isTeacher)
                    chapterNine = new ChapterNine(android, true);
                else
                    chapterNine = new ChapterNine(android, loggedInStudentName, StudentProfile.getTypedPassword());
                chapterNine.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 10:
                if (isTeacher)
                    chapterTen = new ChapterTen(android, true);
                else
                    chapterTen = new ChapterTen(android, loggedInStudentName, StudentProfile.getTypedPassword());
                chapterTen.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 11:
                if (isTeacher)
                    chapterEleven = new ChapterEleven(android, true);
                else
                    chapterEleven = new ChapterEleven(android, loggedInStudentName, StudentProfile.getTypedPassword());
                chapterEleven.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 12:
                if (isTeacher)
                    chapterTwelve = new ChapterTwelve(android, true);
                else
                    chapterTwelve = new ChapterTwelve(android, loggedInStudentName, StudentProfile.getTypedPassword());
                chapterTwelve.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 13:
                if (isTeacher)
                    chapterThirteen = new ChapterThirteen(android, true);
                else
                    chapterThirteen = new ChapterThirteen(android, loggedInStudentName, StudentProfile.getTypedPassword());
                chapterThirteen.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;

            case 14:
                if (isTeacher)
                    chapterFourteen = new ChapterFourteen(android, true);
                else
                    chapterFourteen = new ChapterFourteen(android, loggedInStudentName, StudentProfile.getTypedPassword());
                chapterFourteen.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 15:
                if (isTeacher)
                    chapterFifteen= new ChapterFifteen(android, true);
                else
                    chapterFifteen= new ChapterFifteen(android, loggedInStudentName, StudentProfile.getTypedPassword());
                chapterFifteen.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 16:
                if (isTeacher)
                    chapterSixteen= new ChapterSixteen(android, true);
                else
                    chapterSixteen= new ChapterSixteen(android, loggedInStudentName, StudentProfile.getTypedPassword());
                chapterSixteen.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 17:
                if (isTeacher)
                    chapterSeventeen= new ChapterSeventeen(android, true);
                else
                    chapterSeventeen= new ChapterSeventeen(android, loggedInStudentName, StudentProfile.getTypedPassword());
                chapterSeventeen.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 18:
                if (isTeacher)
                    chapterEighteen= new ChapterEighteen(android, true);
                else
                    chapterEighteen= new ChapterEighteen(android, loggedInStudentName, StudentProfile.getTypedPassword());
                chapterEighteen.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
                break;
            case 19:
                if (isTeacher)
                    chapterNineteen= new ChapterNineteen(android, true);
                else
                    chapterNineteen= new ChapterNineteen(android, loggedInStudentName, StudentProfile.getTypedPassword());
                chapterNineteen.setUp(screenWidth, screenHeight);
                triage = CHAPTER_VIEW;
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

    /**
     * Set Key down listener
     * @param chapNum Chapter number to render
     * @param keycode number of keycode pressed in android device
     * @return int
     */
    protected int chapterKeyDown(int chapNum, int keycode) {
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
            case 12:
                if (chapterTwelve.keyDown(keycode) == 1) {
                    chapterTwelve.dispose();
                    backPressed = true;
                }
                break;
            case 13:
                if (chapterThirteen.keyDown(keycode) == 1) {
                    chapterThirteen.dispose();
                    backPressed = true;
                }
                break;

            case 14:
                if (chapterFourteen.keyDown(keycode) == 1) {
                	chapterFourteen.dispose();
                    backPressed = true;
                }
                break;
            case 15:
                if (chapterFifteen.keyDown(keycode) == 1) {
                	chapterFifteen.dispose();
                    backPressed = true;
                }
                break;
            case 16:
                if (chapterSixteen.keyDown(keycode) == 1) {
                    chapterSixteen.dispose();
                    backPressed = true;
                }
                break;
            case 17:
                if (chapterSeventeen.keyDown(keycode) == 1) {
                    chapterSeventeen.dispose();
                    backPressed = true;
                }
                break;
            case 18:
                if (chapterEighteen.keyDown(keycode) == 1) {
                    chapterEighteen.dispose();
                    backPressed = true;
                }
                break;
            case 19:
                if (chapterNineteen.keyDown(keycode) == 1) {
                    chapterNineteen.dispose();
                    backPressed = true;
                }
                break;
        }
        if (backPressed) {
            if (isTeacher)
                chapterSelect = new ChapterSelect(ChapterSelect.TEACHER, null, null, android);
            else
                chapterSelect = new ChapterSelect(ChapterSelect.STUDENT, loggedInStudentName, StudentProfile.getTypedPassword(), android);
            chapterSelect.setUp(screenWidth, screenHeight);
            triage = CHAPTER_SELECT;
            return 0;
        }
        return 100;
    }

    /**
     * Renders the correct chapter class
     * @param chapNum Chapter number to render
     * @param batch batch where we will draw the chapter class
     */
    protected void renderChapter(int chapNum, Batch batch) {
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
            case 12:
                chapterTwelve.display(batch);
                break;
            case 13:
                chapterThirteen.display(batch);
                break;
            case 14:
                chapterFourteen.display(batch);
                break;
            case 15:
                chapterFifteen.display(batch);
                break;
            case 16:
                chapterSixteen.display(batch);
                break;
            case 17:
                chapterSeventeen.display(batch);
                break;
            case 18:
                chapterEighteen.display(batch);
                break;
            case 19:
                chapterNineteen.display(batch);
                break;
        }
    }
}
