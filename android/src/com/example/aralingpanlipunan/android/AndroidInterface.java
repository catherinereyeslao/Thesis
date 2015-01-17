package com.example.aralingpanlipunan.android;

import java.util.ArrayList;

/**
 * This interface allows the game core to access android's native functions
 */
public interface AndroidInterface {
    /**
     * Disposes all stuff running within the app then close the app completely
     */
    public void exit();

    /**
     * Check the database if a given student name is registered
     * @param studentName name of the student to search
     * @return boolean
     */
    public boolean studentExists(String studentName);

    /**
     * Register a new Student in the database
     * @param studentName name of the student to register
     * @return boolean to indicate success or failure
     */
    public boolean registerNewStudent(String studentName);

    /**
     * Retrieve the record of a student
     * @param studName name of student
     * @return ArrayList of scores for each 19 chapters
     */
    public ArrayList<Integer> getScoresByStudent(String studName);

    /**
     * Displays an Alert dialog with yes / no buttons
     * @param title This text is displayed above the alert dialog
     * @param message This is displayed in the Alert Dialog box
     * @param yesButton This string will be displayed in the left button, which indicates a positive response
     * @param noButton This string will be displayed in the right button, which indicates a negative response
     * @return boolean whether the user clicked yes or no
     */
    public boolean showAlertDialog(String title, String message, String yesButton, String noButton);

    public void showToast(String message, int length);

    public void setStudentScore(String studName, String chapter, int studScore);
}
