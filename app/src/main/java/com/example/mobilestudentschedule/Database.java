package com.example.mobilestudentschedule;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private static final String DB_NAME = "student_schedule";
    private static final int DB_VERSION = 1;
    private static final String TERM_TABLE = "term";
    private static final String COURSE_TABLE = "course";
    private static final String ASSESSMENT_TABLE = "assessment";

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTermTableQuery = "CREATE TABLE " + TERM_TABLE + " ("
                + "ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "TITLE TEXT,"
                + "START_DATE TEXT,"
                + "END_DATE TEXT,"
                + "CREATE_DATE TEXT)";
        db.execSQL(createTermTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
