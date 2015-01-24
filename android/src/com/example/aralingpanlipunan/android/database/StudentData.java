package com.example.aralingpanlipunan.android.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Access the Student Data. Includes every student's scores in all chapters they finished.
 * Student Table consists of student's name and scores for all 19 chapters.
 * A specific chapter score is null if they haven't yet answered the questions after the
 * chapter's lecture
 */
public class StudentData {
    private Context context;
    private DatabaseSetup dbSetup;
    private SQLiteDatabase db;

    public StudentData(Context c) {
        context = c;
    }

    /**
     * Opens a connection to android's SQLite database
     */
    public void open() {
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
     * @return boolean
     */
    public boolean studentExists(String studName) {
        String[] columns = {DatabaseSetup.STUDENT_NAME};
        String [] bindParam = {studName};
        Cursor c = db.query(DatabaseSetup.STUDENT_TABLE, columns, DatabaseSetup.STUDENT_NAME + " = ?", bindParam, null, null, null);
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
     * @return long
     */
    public long registerStudent(String studName) {
        ContentValues cv = new ContentValues();
        cv.put(DatabaseSetup.STUDENT_NAME, studName);
        return db.insert(DatabaseSetup.STUDENT_TABLE, null, cv);
    }

    /**
     * Retrieve the record of a student
     * @param studName name of student
     * @return ArrayList of scores for each 19 chapters
     */
    public ArrayList<Integer> getScoresByStudent(String studName) {
        ArrayList<Integer> scores = new ArrayList<Integer>(19);
        String[] bindParams = {studName};
        String[] columns = {DatabaseSetup.CHAPTER_ONE_SCORE, DatabaseSetup.CHAPTER_TWO_SCORE, DatabaseSetup.CHAPTER_THREE_SCORE, DatabaseSetup.CHAPTER_FOUR_SCORE, DatabaseSetup.CHAPTER_FIVE_SCORE, DatabaseSetup.CHAPTER_SIX_SCORE, DatabaseSetup.CHAPTER_SEVEN_SCORE, DatabaseSetup.CHAPTER_EIGHT_SCORE, DatabaseSetup.CHAPTER_NINE_SCORE, DatabaseSetup.CHAPTER_TEN_SCORE, DatabaseSetup.CHAPTER_ELEVEN_SCORE, DatabaseSetup.CHAPTER_TWELVE_SCORE, DatabaseSetup.CHAPTER_THIRTEEN_SCORE, DatabaseSetup.CHAPTER_FOURTEEN_SCORE, DatabaseSetup.CHAPTER_FIFTEEN_SCORE, DatabaseSetup.CHAPTER_SIXTEEN_SCORE, DatabaseSetup.CHAPTER_SEVENTEEN_SCORE, DatabaseSetup.CHAPTER_EIGHTEEN_SCORE, DatabaseSetup.CHAPTER_NINETEEN_SCORE};
        Cursor c = db.query(DatabaseSetup.STUDENT_TABLE, columns, DatabaseSetup.STUDENT_NAME + " = ?", bindParams, null, null, null, null);
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
     * @param chapter which chapter among the 19
     * @param score new score for the chapter entered in 2nd parameter
     * @return long
     */
    public int setStudentScore(String studName, String chapter, int score) {
        ContentValues cv = new ContentValues();
        String bindParams[] = {studName};
        cv.put(chapter, score);
        return db.update(DatabaseSetup.STUDENT_TABLE, cv, DatabaseSetup.STUDENT_NAME + " = ?", bindParams);
    }
}
