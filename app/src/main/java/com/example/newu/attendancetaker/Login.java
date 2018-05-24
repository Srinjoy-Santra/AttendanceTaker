package com.example.newu.attendancetaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends AppCompatActivity {

    private EditText id_et,pass_et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id_et = (EditText)findViewById(R.id.id_et);
        String id = id_et.getText().toString();

        pass_et = (EditText)findViewById(R.id.password_et);
        String password = pass_et.getText().toString();

        Toast.makeText(getApplicationContext(),id+" "+password,Toast.LENGTH_SHORT).show();

    }

    public void logInDataReceived(View view) {
       id_et = (EditText)findViewById(R.id.id_et);
        String id = id_et.getText().toString();

        pass_et = (EditText)findViewById(R.id.password_et);
        String password = pass_et.getText().toString();

        Toast.makeText(getApplicationContext(),id+" "+password, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Login.this, OptionsPage.class);
        startActivity(intent);
        finish();
    }
}
