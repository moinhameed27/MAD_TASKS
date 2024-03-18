package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button webButton, emailButton;
    EditText subjectText, emailText, urlText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webButton = findViewById(R.id.web);
        emailButton = findViewById(R.id.email);
        subjectText = findViewById(R.id.subjectText);
        emailText = findViewById(R.id.emailText);
        urlText = findViewById(R.id.urlText);
        webButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("QueryPermissionsNeeded")
            @Override
            public void onClick(View v) {
                String url = urlText.getText().toString() ;
                Toast.makeText(MainActivity.this, "Opening Web Browser", Toast.LENGTH_SHORT).show();
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        emailButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("QueryPermissionsNeeded")
            @Override
            public void onClick(View v) {
                String subject = subjectText.getText().toString();
                String address = emailText.getText().toString();
//                String[] addresses = {"moin27@yahoo.com", "mrleo27@softec.pk"};
                Toast.makeText(MainActivity.this, "Opening email", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // Only email apps handle this.
                intent.putExtra(Intent.EXTRA_EMAIL, address);
//                intent.putExtra(Intent.EXTRA_EMAIL, addresses);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}