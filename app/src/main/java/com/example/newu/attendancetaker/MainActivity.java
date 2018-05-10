package com.example.newu.attendancetaker;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    //vars
   ;

    private ArrayList<StudentBasics> mStudent = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: started.");

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
        mStudent.get(4).setName("Rob");
        mStudent.get(5).setName("Srinjoy Santra");

        for(int i=0;i<mStudent.size();i++)
        {
            mStudent.get(i).setTick(false);
            mStudent.get(i).setRoll((160501+i)+"");
        }



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
    public void onClick(View view) {
        TextView textView = (TextView)view.findViewById(R.id.status);

    }
}
