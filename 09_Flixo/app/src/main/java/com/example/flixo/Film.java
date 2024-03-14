package com.example.flixo;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.google.firebase.auth.FirebaseAuth;

public class Film extends AppCompatActivity {

    private static final int MENU_LOGOUT = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);

        String[] categories = {"Action", "Comedy", "Horror", "Drama", "Science Fiction", "Romance", "Adventure"};

        Spinner categorySpinner = findViewById(R.id.catSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);

        categorySpinner.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_LOGOUT, 0, "Logout");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_LOGOUT:
                // Show a confirmation dialog before logging out
                showLogoutConfirmationDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showLogoutConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Logout Confirmation");
        builder.setMessage("Are you sure you want to logout?");

        builder.setPositiveButton("Logout", (dialog, which) -> {
            // Handle logout and navigate to the login page
            logoutAndNavigateToLogin();
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> {
            // User canceled the logout action
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void logoutAndNavigateToLogin() {
        // Implement the logout logic here (e.g., Firebase sign-out)

        // Start the Login activity
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);

        // Finish the current activity to prevent returning to Film activity
        finish();
    }
}
