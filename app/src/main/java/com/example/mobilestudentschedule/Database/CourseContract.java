package com.example.mobilestudentschedule.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class CourseContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private CourseContract() {}

    /* Inner class that defines the table contents */
    public static class CourseEntry implements BaseColumns {
        public static final String TABLE_NAME = "course";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_START_DATE = "start_date";
        public static final String COLUMN_END_DATE = "end_date";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_INSTRUCTOR_NAME = "instrutor_name";
        public static final String COLUMN_INSTRUCTOR_PHONE = "instructor_phone";
        public static final String COLUMN_INSTRUCTOR_EMAIL = "instructor_email";
        public static final String COLUMN_NOTE = "note";
        public static final String COLUMN_TERM_ID = "term_id";
        public enum STATUS_TYPES {
            IN_PROGRESS,
            COMPLETED,
            DROPPED,
            FUTURE
        }
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + CourseEntry.TABLE_NAME + " (" +
                    CourseEntry._ID + " INTEGER PRIMARY KEY, " +
                    CourseEntry.COLUMN_NAME + " TEXT NOT NULL," +
                    CourseEntry.COLUMN_START_DATE + " TEXT NOT NULL," +
                    CourseEntry.COLUMN_END_DATE + " TEXT NOT NULL," +
                    CourseEntry.COLUMN_STATUS + " TEXT NOT NULL," +
                    CourseEntry.COLUMN_INSTRUCTOR_NAME + " TEXT NOT NULL," +
                    CourseEntry.COLUMN_INSTRUCTOR_PHONE + " TEXT NOT NULL," +
                    CourseEntry.COLUMN_INSTRUCTOR_EMAIL + " TEXT NOT NULL," +
                    CourseEntry.COLUMN_NOTE + " TEXT," +
                    CourseEntry.COLUMN_TERM_ID + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + CourseEntry.TABLE_NAME;

    public static class CourseReaderDbHelper extends SQLiteOpenHelper {

        public CourseReaderDbHelper(Context context) {
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