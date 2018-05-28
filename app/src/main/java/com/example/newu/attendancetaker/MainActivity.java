package com.example.newu.attendancetaker;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.newu.attendancetaker.Activity.OptionsPage;
import com.example.newu.attendancetaker.Activity.StudentBasics;
import com.example.newu.attendancetaker.Adapter.RecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    //vars
    private EditText dateEt;
    private EditText timeEt;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private Spinner classSp,sectionSp;
    private ArrayList<StudentBasics> mStudent = new ArrayList<>();
    private CheckBox selectAllCb;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initValues();

    }

    private void initValues()
    {

        for(int i=0;i<6;i++)
            mStudent.add(new StudentBasics("","","",true));

        mStudent.get(0).setName("Sam");
        mStudent.get(1).setName("Raj");
        mStudent.get(2).setName("Yash");
        mStudent.get(3).setName("Tim");
        mStudent.get(4).setName("First Middle Last");
        mStudent.get(5).setName("Srinjoy Santra");

        for(int i=0;i<mStudent.size();i++)
        {
            mStudent.get(i).setTick(false);
            mStudent.get(i).setRoll((160501+i)+"");
        }


        /*Spinner spinner = findViewById(R.id.class_sp);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.class_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);*/



        initRecyclerView();
    }

    private void initRecyclerView()
    {
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter( mStudent,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public void displayViews(View view) {
        String classStr=classSp.getSelectedItem().toString();
        String sectionStr=sectionSp.getSelectedItem().toString();
        String dateStr=dateEt.getText().toString();
        if(dateStr.matches(""))
            Toast.makeText(getApplicationContext(),"You did not enter a date!",Toast.LENGTH_SHORT).show();

        Toast.makeText(getApplicationContext(),classStr+" "+sectionStr+" "+dateStr,Toast.LENGTH_SHORT).show();
    }
    public void onClick(View view)
    {
    }

    public void moveToOptions(View view) {
        Intent intent = new Intent(MainActivity.this, OptionsPage.class);
        startActivity(intent);
        finish();
    }

    public void refreshAttendance(View view) {
        dateEt.setText("");
        selectAllCb = findViewById(R.id.status_check);
        selectAllCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                String s;
                if (isChecked) {
                    for(int i=0;i<mStudent.size();i++)
                        mStudent.get(i).setTick(true);
                    s="All present!";
                    initRecyclerView();
                } else {
                    mStudent.clear();
                    s="All absent!";
                    initValues();
                }
                Toast.makeText(getApplicationContext(),
                        s,
                        Toast.LENGTH_SHORT).show();
            }
        });




    }

    public void sendToDB(View view) {
    }
}
