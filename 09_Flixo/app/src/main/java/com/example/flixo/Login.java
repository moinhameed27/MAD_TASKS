package com.example.flixo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    TextView forgetpass;
    TextView signup;
    Button signin;
    EditText email,password;
    ProgressBar progressBar;
    FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser != null){
//            Intent intent = new Intent(getApplicationContext(), Login.class);
//            startActivity(intent);
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signin = findViewById(R.id.loginbtn);
        email = findViewById(R.id.sinemail);
        password = findViewById(R.id.sinpass);
        progressBar = findViewById(R.id.ProgressBar);
        mAuth = FirebaseAuth.getInstance();
        forgetpass = findViewById(R.id.forgetPass);
        signup = findViewById(R.id.signup0);
        forgetpass.setOnClickListener(view ->
                Toast.makeText(Login.this, "Us", Toast.LENGTH_SHORT).show());
        signup.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Signup.class);
            startActivity(intent);
            finish();
        });
        signin.setOnClickListener(v -> {
            progressBar.setVisibility(View.VISIBLE);
            String emails,passwords;
            emails = email.getText().toString();
            passwords = password.getText().toString();

            if (TextUtils.isEmpty(emails)){
                Toast.makeText(Login.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(passwords)){
                Toast.makeText(Login.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }
            mAuth.signInWithEmailAndPassword(emails, passwords)
                    .addOnCompleteListener(task -> {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Film.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    });

        });

    }
}