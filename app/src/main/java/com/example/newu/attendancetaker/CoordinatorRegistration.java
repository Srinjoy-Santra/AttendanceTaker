package com.example.newu.attendancetaker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CoordinatorRegistration extends AppCompatActivity {

    Spinner schoolNameSpinner;
    EditText coordinatorNameEt,coordinatorPhoneEt,coordinatorEmailEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_registration);

        schoolNameSpinner = (Spinner) findViewById(R.id.school_name_spinner);
        String schoolName = (String) schoolNameSpinner.getSelectedItem();

        coordinatorNameEt = (EditText)findViewById(R.id.coordinator_name_et);
        String coordinatorName = coordinatorNameEt.getText().toString();

        coordinatorPhoneEt = (EditText)findViewById(R.id.coordinator_phn_et);
        String coordinatorPhn = coordinatorPhoneEt.getText().toString();

        coordinatorEmailEt = (EditText)findViewById(R.id.coordinator_email_et);
        String coordinatorEmail = coordinatorEmailEt.getText().toString();

        Toast.makeText(getApplicationContext(),"submitted" + schoolName + coordinatorName ,Toast.LENGTH_SHORT).show();

    }


}
