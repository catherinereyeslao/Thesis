package com.example.aralingpanlipunan.android.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Sets up the database upon installation / application update
 */
public class DatabaseSetup extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "SocialStudiesDb";
    private static final int DATABASE_VERSION = 1;

    // STUDENT FIELDS
    public static final String STUDENT_TABLE = "StudentTable";
    public static final String STUDENT_ID = "_id";
    public static final String STUDENT_NAME = "student_name";
    public static final String CHAPTER_ONE_SCORE = "chap_one_score";
    public static final String CHAPTER_TWO_SCORE = "chap_two_score";
    public static final String CHAPTER_THREE_SCORE = "chap_three_score";
    public static final String CHAPTER_FOUR_SCORE = "chap_four_score";
    public static final String CHAPTER_FIVE_SCORE = "chap_five_score";
    public static final String CHAPTER_SIX_SCORE = "chap_six_score";
    public static final String CHAPTER_SEVEN_SCORE = "chap_seven_score";
    public static final String CHAPTER_EIGHT_SCORE = "chap_eight_score";
    public static final String CHAPTER_NINE_SCORE = "chap_nine_score";
    public static final String CHAPTER_TEN_SCORE = "chap_ten_score";
    public static final String CHAPTER_ELEVEN_SCORE = "chap_eleven_score";
    public static final String CHAPTER_TWELVE_SCORE = "chap_twelve_score";
    public static final String CHAPTER_THIRTEEN_SCORE = "chap_thirteen_score";
    public static final String CHAPTER_FOURTEEN_SCORE = "chap_fourteen_score";
    public static final String CHAPTER_FIFTEEN_SCORE = "chap_fifteen_score";
    public static final String CHAPTER_SIXTEEN_SCORE = "chap_sixteen_score";
    public static final String CHAPTER_SEVENTEEN_SCORE = "chap_seventeen_score";
    public static final String CHAPTER_EIGHTEEN_SCORE = "chap_eighteen_score";
    public static final String CHAPTER_NINETEEN_SCORE = "chap_nineteen_score";

    public DatabaseSetup(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create table structure for Student
        db.execSQL("CREATE TABLE " + STUDENT_TABLE + " (" +
            STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            STUDENT_NAME + " TEXT UNIQUE NOT NULL, " +
            CHAPTER_ONE_SCORE + " INTEGER, " +
            CHAPTER_TWO_SCORE + " INTEGER, " +
            CHAPTER_THREE_SCORE + " INTEGER, " +
            CHAPTER_FOUR_SCORE + " INTEGER, " +
            CHAPTER_FIVE_SCORE + " INTEGER, " +
            CHAPTER_SIX_SCORE + " INTEGER, " +
            CHAPTER_SEVEN_SCORE + " INTEGER, " +
            CHAPTER_EIGHT_SCORE + " INTEGER, " +
            CHAPTER_NINE_SCORE + " INTEGER, " +
            CHAPTER_TEN_SCORE + " INTEGER, " +
            CHAPTER_ELEVEN_SCORE + " INTEGER, " +
            CHAPTER_TWELVE_SCORE + " INTEGER, " +
            CHAPTER_THIRTEEN_SCORE + " INTEGER, " +
            CHAPTER_FOURTEEN_SCORE + " INTEGER, " +
            CHAPTER_FIFTEEN_SCORE + " INTEGER, " +
            CHAPTER_SIXTEEN_SCORE + " INTEGER, " +
            CHAPTER_SEVENTEEN_SCORE + " INTEGER, " +
            CHAPTER_EIGHTEEN_SCORE + " INTEGER, " +
            CHAPTER_NINETEEN_SCORE + " INTEGER);"
        );
        // Create index on student's name column, because we'll commonly use it for searching, hence,
        // will slightly improve db performance
        db.execSQL("CREATE INDEX student_name_index ON " + STUDENT_TABLE + " (" + STUDENT_NAME + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
        onCreate(db);
    }
}
