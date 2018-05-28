package com.example.newu.attendancetaker.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.newu.attendancetaker.R;

public class OptionsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_page);
    }




    public void returnToLogin(View view) {
        Intent intent = new Intent(OptionsPage.this, Login.class);
        startActivity(intent);
        finish();
    }

    public void moveToDigitalTLM(View view) {
        //getIntent();
        Intent intent = new Intent(OptionsPage.this, DigitalTLM.class);
        startActivity(intent);
        finish();
    }

    public void moveToEnglish(View view) {
        Intent intent = new Intent(OptionsPage.this, TrainingNeeds.class);
        String message = getResources().getString(R.string.subject_name_1);
        intent.putExtra("nextHeader",message);
        startActivity(intent);
        finish();
    }
    public void moveToDigital(View view) {
        Intent intent = new Intent(OptionsPage.this, TrainingNeeds.class);
        String message = getResources().getString(R.string.subject_name_2);
        intent.putExtra("nextHeader",message);
        startActivity(intent);
        finish();
    }
    public void moveToOthers(View view) {
        Intent intent = new Intent(OptionsPage.this, TrainingNeeds.class);
        String message = getResources().getString(R.string.other);
        intent.putExtra("nextHeader",message);
        startActivity(intent);
        finish();
    }


    public void moveToClassAdmin(View view) {
        Intent intent = new Intent(OptionsPage.this, ClassAdmin.class);
        startActivity(intent);
        finish();
    }


}
