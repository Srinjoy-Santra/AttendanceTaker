package com.example.newu.attendancetaker.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newu.attendancetaker.R;

public class TrainingNeeds extends AppCompatActivity {

    private static String message;
    LinearLayout detailsLayout;
    private Button schedule,courseCont;
    /*private static boolean engIsChecked,compIsChecked;*/
    private EditText courseSel;
    private TextView coursched;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_needs);

        courseSel = findViewById(R.id.needs);
        schedule = findViewById(R.id.schedule_btn);
        courseCont = findViewById(R.id.course_btn);
        coursched = findViewById(R.id.details);
        detailsLayout =findViewById(R.id.my_details_view);

        Intent intent = getIntent();
        if(intent == null)
            return;

        message="";
        String header = intent.getStringExtra("nextHeader");
        message+=header;

        if(header.equals(getResources().getString(R.string.subject_name_1)) ||
                header.equals(getResources().getString(R.string.subject_name_2)))
        {
            courseSel.setText(header);
            courseSel.setClickable(false);
            courseSel.setFocusable(false);
        }
        else
        {
            schedule.setEnabled(false);
            schedule.setVisibility(View.INVISIBLE);
            courseCont.setEnabled(false);
            courseCont.setVisibility(View.INVISIBLE);
            coursched.setVisibility(View.INVISIBLE);
            detailsLayout.setVisibility(View.INVISIBLE);

        }



    }
    public void moveToOptions(View view) {
        Intent intent = new Intent(TrainingNeeds.this, OptionsPage.class);
        startActivity(intent);
        finish();
    }


    public void displayCourseContents(View view) {


        Toast.makeText(getApplicationContext(),"Course contents of "+message,Toast.LENGTH_SHORT).show();

        //message="";
    }

    public void displaySchedule(View view) {

        Toast.makeText(getApplicationContext(), "Schedule of " + message, Toast.LENGTH_SHORT).show();
        //message="";
    }


    /*public void onRadioButtonClicked(View view) {
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


    }*/

}
