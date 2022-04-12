package com.example.mobilestudentschedule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.mobilestudentschedule.Database.AssessmentContract;
import com.example.mobilestudentschedule.Database.CourseContract;
import com.example.mobilestudentschedule.Database.TermContract;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boostrapDb();
        setContentView(R.layout.activity_main);
        // assigning ID of the toolbar to a variable
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // using toolbar as ActionBar
        setSupportActionBar(toolbar);
    }

    // setup the database
    private void boostrapDb() {
        TermContract.TermReaderDbHelper termDb = new TermContract.TermReaderDbHelper(getBaseContext());
        CourseContract.CourseReaderDbHelper courseDb = new CourseContract.CourseReaderDbHelper(getBaseContext());
        AssessmentContract.AssessmentReaderDbHelper assessmentDb = new AssessmentContract.AssessmentReaderDbHelper(getBaseContext());
    }
}