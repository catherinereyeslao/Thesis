package com.example.aralingpanlipunan.views;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Disposable;
import com.example.aralingpanlipunan.AppFragment;
import com.example.aralingpanlipunan.android.AndroidInterface;
import com.example.aralingpanlipunan.views.chapters.*;

public class Teacher extends AppView implements AppFragment, Disposable {
    private static final int CHAPTER_SELECT = 0;
    private static final int CHAPTER_VIEW = 1;

    private int selectedChapter, triage = 0;
    private int screenWidth, screenHeight;
    private AndroidInterface android;
    private ChapterSelect chapterSelect;
    private ChapterOne chapterOne;
    private ChapterTwo chapterTwo;
    private ChapterThree chapterThree;
    private ChapterFour chapterFour;
    private ChapterFive chapterFive;
    private ChapterSix chapterSix;
    private ChapterSeven chapterSeven;
    private ChapterEight chapterEight;

    public Teacher(AndroidInterface androidInterface) {
        android = androidInterface;
    }

    @Override
    public void setUp(int screenW, int screenH) {
        screenWidth = screenW;
        screenHeight = screenH;

        chapterSelect = new ChapterSelect(ChapterSelect.TEACHER, "Teacher", null);
        chapterSelect.setUp(screenW, screenH);
    }

    @Override
    public void display(Batch batch) {
        switch (triage) {
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
        chapterSelect.dispose();
        disposeChapter(selectedChapter);
    }

    public void touchDown(float x, float y) {
        switch (triage) {
            case CHAPTER_SELECT:
                selectedChapter = chapterSelect.touchDown(x, y);
                if (selectedChapter != 0)
                    openChapter(selectedChapter);
                break;
            case CHAPTER_VIEW:
                chapterTouchDown(selectedChapter, x, y);
                break;
        }
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
                chapterOne = new ChapterOne(android, true);
                chapterOne.setUp(screenWidth, screenHeight);
                break;
        }
        triage = CHAPTER_VIEW;
    }

    /**
     * Dispose a chapter based on the passed argument
     * @param chapNum The chapter number to dispose
     */
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
        }
    }
}
