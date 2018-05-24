package com.example.newu.attendancetaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class TrainingNeeds extends AppCompatActivity {

    private static String message="";
    private static boolean engIsChecked,compIsChecked;
    private RadioGroup rg;
    private RadioButton cerb,bcrb;
    private Button schedule,courseCont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_needs);


    }
    public void moveToOptions(View view) {
        Intent intent = new Intent(TrainingNeeds.this, OptionsPage.class);
        startActivity(intent);
        finish();
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.subj1_rb:
                if (checked) {

                    engIsChecked = true;
                    compIsChecked = false;
                }
                break;
            case R.id.subj2_rb:
                if (checked) {
                    message += getResources().getString(R.string.subject_name_2);
                    engIsChecked=false;
                    compIsChecked=true;
                    }
                break;
        }


    }
    public void displayCourseContents(View view) {

        message += getResources().getString(R.string.subject_name_1);
        Toast.makeText(getApplicationContext(),"Course contents of "+message,Toast.LENGTH_SHORT).show();

        message="";
    }

    public void displaySchedule(View view) {

        Toast.makeText(getApplicationContext(), "Schedule of " + message, Toast.LENGTH_SHORT).show();
        message="";
    }


}
