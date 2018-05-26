package com.example.newu.attendancetaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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

    public void moveToTrainingNeeds(View view) {
        Intent intent = new Intent(OptionsPage.this, TrainingNeeds.class);
        startActivity(intent);
        finish();
    }

    public void moveToClassAdmin(View view) {
        Intent intent = new Intent(OptionsPage.this, ClassAdmin.class);
        startActivity(intent);
        finish();
    }


}
