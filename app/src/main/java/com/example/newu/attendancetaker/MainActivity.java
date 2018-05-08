package com.example.newu.attendancetaker;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    //vars
    private ArrayList<String> mRolls = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mStatuses = new ArrayList<>();

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
        mNames.add("Sam");
        mNames.add("Raj");
        mNames.add("Yash");
        mNames.add("Tim");
        mNames.add("Rob");


        for(int i=0;i<5;i++)
        {
            mStatuses.add("Absent");
            mRolls.add(i+"");
        }



        initRecyclerView();
    }

    private void initRecyclerView()
    {
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mRolls, mNames, mStatuses);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
