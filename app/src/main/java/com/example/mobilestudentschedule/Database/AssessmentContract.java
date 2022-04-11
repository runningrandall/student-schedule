package com.example.mobilestudentschedule.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class AssessmentContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private AssessmentContract() {}

    /* Inner class that defines the table contents */
    public static class AssessmentEntry implements BaseColumns {
        public static final String TABLE_NAME = "assessment";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_DUE_DATE = "due_date";
        public enum ASSESSMENT_TYPES {
            PERFORMANCE,
            OBJECTIVE
        }
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + AssessmentEntry.TABLE_NAME + " (" +
                    AssessmentEntry._ID + " INTEGER PRIMARY KEY, " +
                    AssessmentEntry.COLUMN_TITLE + " TEXT NOT NULL," +
                    AssessmentEntry.COLUMN_TYPE + " TEXT NOT NULL, " +
                    AssessmentEntry.COLUMN_DUE_DATE + " TEXT NOT NULL)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + AssessmentEntry.TABLE_NAME;

    public static class AssessmentReaderDbHelper extends SQLiteOpenHelper {


        public AssessmentReaderDbHelper(Context context) {
            super(context, StudentSchedule.DATABASE_NAME, null, StudentSchedule.DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }
    }
}
