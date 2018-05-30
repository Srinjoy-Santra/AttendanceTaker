package com.example.newu.attendancetaker.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.newu.attendancetaker.Fragments.LessonPlanFragment;
import com.example.newu.attendancetaker.R;

public class DigitalTLM extends AppCompatActivity {

    private static String lessonText;
    private Spinner classSp, subjectSp,topicSp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_tlm);

        classSp = findViewById(R.id.class_sp);
        subjectSp = findViewById(R.id.subject_sp);
        topicSp = findViewById(R.id.topic_sp);


        /*"English is a West Germanic language that" +
                " was first spoken in early medieval England and is now a global lingua franca.";*/

    }

    public void startPPTdownload(View view) {
        Toast.makeText(getApplicationContext(),"PPT loading...",Toast.LENGTH_SHORT).show();
    }

    public void startWorksheetdownload(View view) {
        Toast.makeText(getApplicationContext(),"Worksheet loading...",Toast.LENGTH_SHORT).show();
    }

    public void moveToOptions(View view) {
        Intent intent = new Intent(DigitalTLM.this, OptionsPage.class);
        startActivity(intent);
        finish();
    }


    public void displayLessonPlan(View view) {
        LessonPlanFragment lessonPlanFragment = (LessonPlanFragment)getSupportFragmentManager().findFragmentById(R.id.my_linear_viewer);
        lessonPlanFragment.setLessonText();
    }
}
