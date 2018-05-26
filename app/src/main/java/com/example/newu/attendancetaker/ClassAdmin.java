package com.example.newu.attendancetaker;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;

public class ClassAdmin extends AppCompatActivity {

    private static final String TAG = "ClassAdminActivity";
    //vars
    private EditText dateEt,timeEt;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private Spinner classSp,sectionSp;
    private ArrayList<StudentBasics> mStudent = new ArrayList<>();
    private CheckBox selectAllCb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_admin);

        Log.d(TAG, "onCreate: started.");

        dateEt = findViewById(R.id.date_et);
        timeEt = findViewById(R.id.time_et);
        classSp = findViewById(R.id.class_sp);
        sectionSp = findViewById(R.id.section_sp);

        dateEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();

                int yy = calendar.get(Calendar.YEAR);
                int mm = calendar.get(Calendar.MONTH);
                int dd = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ClassAdmin.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        dateSetListener,
                        yy, mm, dd);
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String dateStr = dayOfMonth+"/"+month+"/"+year;
                Log.d(TAG,"onDateset : date : "+dateStr);
                dateEt.setText(dateStr);
            }
        };


    }

    public void moveToAttendance(View view) {
        Intent intent = new Intent(ClassAdmin.this, ViewUpdate.class);
        String message = getResources().getString(R.string.attend121);
        intent.putExtra("nextHeader",message);
        intent.putExtra("class",classSp.getSelectedItem().toString());
        intent.putExtra("section",sectionSp.getSelectedItem().toString());
        intent.putExtra("date",dateEt.getText().toString());
        intent.putExtra("time",timeEt.getText().toString());


        startActivity(intent);
        finish();
    }

    public void moveToSummative(View view) {
        Intent intent = new Intent(ClassAdmin.this, ViewUpdate.class);
        String message = getResources().getString(R.string.sum1222)+" "+getResources().getString(R.string.eval122);
        intent.putExtra("nextHeader",message);
        intent.putExtra("class",classSp.getSelectedItem().toString());
        intent.putExtra("section",sectionSp.getSelectedItem().toString());
        intent.putExtra("date",dateEt.getText().toString());
        intent.putExtra("time",timeEt.getText().toString());


        startActivity(intent);
        finish();
    }

    public void moveToFormative(View view) {
        Intent intent = new Intent(ClassAdmin.this, ViewUpdate.class);
        String message = getResources().getString(R.string.form1221)+" "+getResources().getString(R.string.eval122);
        intent.putExtra("nextHeader",message);
        intent.putExtra("class",classSp.getSelectedItem().toString());
        intent.putExtra("section",sectionSp.getSelectedItem().toString());
        intent.putExtra("date",dateEt.getText().toString());
        intent.putExtra("time",timeEt.getText().toString());


        startActivity(intent);
        finish();
    }
}
