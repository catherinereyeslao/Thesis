package com.example.aralingpanlipunan.android.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;

import static com.example.aralingpanlipunan.android.database.DatabaseSetup.*;

import java.util.ArrayList;

/**
 * Access the Student Data. Includes every student's scores in all chapters they finished.
 * Student Table consists of student's name and scores for all 19 chapters.
 * A specific chapter score is null if they haven't yet answered the questions after the
 * chapter's lecture
 */
public class StudentData {
    private Context context;
    private SQLiteDatabase db;

    public StudentData(Context c) {
        context = c;
    }

    /**
     * Opens a connection to android's SQLite database
     */
    public void open() {
        DatabaseSetup dbSetup;
        dbSetup = new DatabaseSetup(context);
        db = dbSetup.getWritableDatabase();
    }

    /**
     * Closes active connection to android's SQLite database
     */
    public void close() {
        db.close();
    }

    /**
     * Checks data if there is already an existing student with the given user name
     * @param studName name of student to search for
     * @param password password to match for the student
     * @return boolean
     */
    public boolean studentExists(String studName, String password) {
        String[] columns = {STUDENT_NAME, STUDENT_PASSWORD};
        String [] bindParam = {studName, password};
        String whereClause = STUDENT_NAME + " = ? AND " + STUDENT_PASSWORD + " = ?";
        Cursor c = db.query(DatabaseSetup.STUDENT_TABLE, columns, whereClause, bindParam, null, null, null);
        try {
            if (c.moveToFirst())
                return c.getString(0).length() > 0;
        } catch (CursorIndexOutOfBoundsException e) {
            // Exception occurs if the name doesn't exist, so we return false
            return false;
        }
        return false;
    }

    /**
     * Register a new user to the database
     * @param studName name of the new student user
     * @param password the password for the newly registered student
     * @return long
     */
    public long registerStudent(String studName, String password) {
        ContentValues cv = new ContentValues();
        cv.put(STUDENT_NAME, studName);
        cv.put(STUDENT_PASSWORD, password);
        return db.insert(STUDENT_TABLE, null, cv);
    }

    /**
     * Retrieve the record of a student
     * @param studName name of student
     * @param password password of a student
     * @return ArrayList of scores for each 19 chapters
     */
    public ArrayList<Integer> getScoresByStudent(String studName, String password) {
        ArrayList<Integer> scores = new ArrayList<Integer>(19);
        String whereClause = STUDENT_NAME + " = ? AND " + STUDENT_PASSWORD + " = ?";
        String[] bindParams = {studName, password};
        String[] columns = {CHAPTER_ONE_SCORE, CHAPTER_TWO_SCORE, CHAPTER_THREE_SCORE, CHAPTER_FOUR_SCORE, CHAPTER_FIVE_SCORE, CHAPTER_SIX_SCORE, CHAPTER_SEVEN_SCORE, CHAPTER_EIGHT_SCORE, CHAPTER_NINE_SCORE, CHAPTER_TEN_SCORE, CHAPTER_ELEVEN_SCORE, CHAPTER_TWELVE_SCORE, CHAPTER_THIRTEEN_SCORE, CHAPTER_FOURTEEN_SCORE, CHAPTER_FIFTEEN_SCORE, CHAPTER_SIXTEEN_SCORE, CHAPTER_SEVENTEEN_SCORE, CHAPTER_EIGHTEEN_SCORE, CHAPTER_NINETEEN_SCORE};

        Cursor c = db.query(STUDENT_TABLE, columns, whereClause, bindParams, null, null, null, null);
        if (c.moveToFirst()) {
            for (int i = 0; i < 19; i++) {
                scores.add(i, c.getInt(i));
            }
        }
        return scores;
    }

    /**
     * Set a new record for student's score in a specific chapter
     * @param studName name of student
     * @param password password of student
     * @param chapter which chapter among the 19
     * @param score new score for the chapter entered in 2nd parameter
     * @return long
     */
    public int setStudentScore(String studName, String password, String chapter, int score) {
        ContentValues cv = new ContentValues();
        String bindParams[] = {studName, password};
        String whereClause = STUDENT_NAME + " = ? AND " + STUDENT_PASSWORD + " = ?";
        cv.put(chapter, score);
        return db.update(STUDENT_TABLE, cv, whereClause, bindParams);
    }
}
