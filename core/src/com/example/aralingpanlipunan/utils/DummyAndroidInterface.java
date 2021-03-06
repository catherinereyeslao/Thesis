package com.example.aralingpanlipunan.utils;

import com.example.aralingpanlipunan.android.AndroidInterface;

import java.util.ArrayList;

/**
 * If we're running on desktop, this is a dummy android interface so we can simulate
 * and return what a real android device would do. Teachers also are always able to
 * access all chapters, so they have a perfect score in all chapters declared in
 * {@link #getScoresByStudent(String, String)}
 */
public class DummyAndroidInterface implements AndroidInterface {
    @Override
    public void exit() {
        System.out.println("exit");
    }

    @Override
    public boolean studentExists(String studentName, String password) {
        return true;
    }

    @Override
    public boolean registerNewStudent(String studentName, String password) {
        return true;
    }

    @Override
    public ArrayList<Integer> getScoresByStudent(String studName, String password) {
        ArrayList<Integer> array = new ArrayList<Integer>(17);
        for (int c = 0; c < 18; c++) {
            array.add(100);
        }
        return array;
    }

    @Override
    public boolean showAlertDialog(String title, String message, String yesButton, String noButton) {
        return true;
    }

    @Override
    public void showToast(String message, int length) {
        System.out.println("Toast");
    }

    @Override
    public void setStudentScore(String studName, String password, String chapter, int studScore) {
        System.out.println("New student score");
    }

    @Override
    public void playChap6Video() {
        // We will not support video playing in Desktop
    }
}
