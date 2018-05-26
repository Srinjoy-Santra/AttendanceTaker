package com.example.newu.attendancetaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewUpdate extends AppCompatActivity {

    static boolean ViewOption,UpdateOption;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_update);

        Intent intent = getIntent();

        if(intent == null)
            return;

        String header = intent.getStringExtra("nextHeader");
        String clas = intent.getStringExtra("class");
        String section = intent.getStringExtra("section");
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");

        TextView headerTv = findViewById(R.id.header_vu);
        headerTv.setText(header);
        button = findViewById(R.id.button_vu);
        button.setText(getResources().getString(R.string.blank));
        button.setEnabled(false);

    }

    public void displayViews(View view) {
        ViewOption =true; UpdateOption =false;
        Toast.makeText(getApplicationContext(),"View mode!",Toast.LENGTH_SHORT).show();
        button.setEnabled(true);
        button.setText(getResources().getString(R.string.returns));
    }

    public void displayUpdate(View view) {
        ViewOption =false; UpdateOption =true;
        Toast.makeText(getApplicationContext(),"Update mode!",Toast.LENGTH_SHORT).show();
        button.setEnabled(true);
        button.setText(getResources().getString(R.string.save));
    }

    public void moveToOptions(View view) {
        Intent intent = new Intent(ViewUpdate.this, OptionsPage.class);
        startActivity(intent);
        finish();
    }
}
