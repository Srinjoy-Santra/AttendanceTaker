package com.example.newu.attendancetaker.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.newu.attendancetaker.R;

public class DigitalTLM extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_tlm);
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
}
