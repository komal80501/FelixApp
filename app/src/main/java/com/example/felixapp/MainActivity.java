package com.example.felixapp;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonRegister;
    private EditText editTextEmail,editTextPassword,editTextConfirmPass;
    private TextView textViewLogin;
    private ProgressDialog progressDialog;
    private FirebaseAuth fireBaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fireBaseAuth =FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        buttonRegister = findViewById(R.id.btnRegister);

        editTextEmail = findViewById(R.id.editEmail);
        editTextPassword = findViewById(R.id.editPass);
        editTextConfirmPass =findViewById(R.id.editConfirmPass);

        textViewLogin = findViewById(R.id.textLogin);

        buttonRegister.setOnClickListener(this);
        textViewLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == buttonRegister)
        {
            registerUser();
        }

        if (view == textViewLogin)
        {
            //Open Login Activity 
        }
    }

    private void registerUser() {
        String email= editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString().trim();
        String rePassword = editTextConfirmPass.getText().toString().trim();


        if (TextUtils.isEmpty(email)){
            editTextEmail.setError("Please Enter Email");
            editTextEmail.requestFocus();
            return;

        }

        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError("Please Enter Password");
            editTextPassword.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(rePassword)){
                editTextConfirmPass.setError("Please Re-Enter Password");
                editTextConfirmPass.requestFocus();
                return;
        }

        if (!password.equals(rePassword))
        {
            editTextConfirmPass.setError("Password doesn't match");
            editTextConfirmPass.requestFocus();
            return;
        }

        progressDialog.setMessage("Registering User....");
        progressDialog.show();

        fireBaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Registered SuccessFully", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}
