package com.example.mobilestudentschedule.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public final class TermContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private TermContract() {}

    /* Inner class that defines the table contents */
    public static class TermEntry implements BaseColumns {
        public static final String TABLE_NAME = "term";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_START_DATE = "start_date";
        public static final String COLUMN_NAME_END_DATE = "end_date";
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TermEntry.TABLE_NAME + " (" +
                    TermEntry._ID + " INTEGER PRIMARY KEY," +
                    TermEntry.COLUMN_NAME_TITLE + " TEXT," +
                    TermEntry.COLUMN_NAME_START_DATE + " TEXT," +
                    TermEntry.COLUMN_NAME_END_DATE + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TermEntry.TABLE_NAME;

    public static class TermReaderDbHelper extends SQLiteOpenHelper {

        public TermReaderDbHelper(Context context) {
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
