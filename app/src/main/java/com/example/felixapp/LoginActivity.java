package com.example.felixapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonLogin;
    private EditText editTextEmail,editTextPassword;
    private TextView textViewSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editLoginEmail);
        editTextPassword = findViewById(R.id.editLoginPass);
        buttonLogin = findViewById(R.id.btnLogin);
        textViewSignUp = findViewById(R.id.textSignUp);

        buttonLogin.setOnClickListener(this);
        textViewSignUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }
}
