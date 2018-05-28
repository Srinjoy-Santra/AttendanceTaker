package com.example.newu.attendancetaker.Activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.newu.attendancetaker.R;

import java.util.ArrayList;
import java.util.Calendar;

public class ClassAdmin extends AppCompatActivity {

    private static final String TAG = "ClassAdminActivity";
    //vars
    private EditText dateEt,timeEt,teacherEt;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private TimePickerDialog.OnTimeSetListener timeSetListener;
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
        teacherEt =findViewById(R.id.teacher_ma);

        updateDate(dateEt);
        updateTime(timeEt);


    }

    private void updateTime(EditText timeEtc) {
        final EditText timeEditText = timeEtc;
        timeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int hh = calendar.get(Calendar.HOUR_OF_DAY);
                int mm = calendar.get(Calendar.MINUTE);

                TimePickerDialog dialog = new TimePickerDialog(ClassAdmin.this,
                        timeSetListener, hh,mm,true);
                dialog.show();
            }
        });
        /*ClassAdmin.this,
                        timeSetListener,
                        hh,mm*/
        timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                String timeStr,format;


                if (hourOfDay == 0) {
                    hourOfDay += 12;
                    format = "AM";
                } else if (hourOfDay == 12) {
                    format = "PM";
                } else if (hourOfDay > 12) {
                    hourOfDay -= 12;
                    format = "PM";
                } else {
                    format = "AM";
                }
                timeStr = hourOfDay + ":" + ((minute>9)?minute : "0"+minute) + " " + format;
                Log.d(TAG,"onTimeSet : time : "+timeStr);
                timeEditText.setText(timeStr);
            }

        };
    }


    public void updateDate(EditText dateEtc)
    {
        final EditText dateEditText = dateEtc;
        dateEditText.setOnClickListener(new View.OnClickListener() {
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
                dateEditText.setText(dateStr);
            }
        };
    }

    public void moveToAttendance(View view) {
        checkInput();
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
        checkInput();
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
        checkInput();
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

    public void moveToOptions(View view) {
        Intent intent = new Intent(ClassAdmin.this, OptionsPage.class);
        startActivity(intent);
        finish();
    }

    public void checkInput()
    {
        String message;
        if(dateEt == null)
            message = "Enter a valid date!";
        else if (timeEt == null)
            message = "Enter a valid time!";
        else if (teacherEt == null)
            message = "Enter a valid teacher name!";
        else return;

        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}
