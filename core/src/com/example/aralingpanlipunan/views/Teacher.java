package com.example.aralingpanlipunan.views;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.example.aralingpanlipunan.android.AndroidInterface;

public class Teacher extends UserType {
    public Teacher(AndroidInterface androidInterface, boolean isTeacher) {
        super(androidInterface, isTeacher);
    }

    @Override
    public void setUp(int screenW, int screenH) {
        super.setUp(screenW, screenH);
        chapterSelect = new ChapterSelect(ChapterSelect.TEACHER, "Teacher", null, android);
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
                int score = chapterTouchDown(selectedChapter, x, y);
                if (score > 500) {
                    selectedChapter = score - 500;
                    disposeChapter(selectedChapter - 1);
                    openChapter(selectedChapter);
                } else if (score != 100) {
                    disposeChapter(selectedChapter);
                    chapterSelect = new ChapterSelect(ChapterSelect.TEACHER, null, null, android);
                    chapterSelect.setUp(screenWidth, screenHeight);
                    triage = CHAPTER_SELECT;
                }
                break;
        }
    }
}
