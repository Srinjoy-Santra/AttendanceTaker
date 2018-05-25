package com.example.newu.attendancetaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ClassAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_admin);
    }

    public void moveToAttendance(View view) {
        Intent intent = new Intent(ClassAdmin.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
