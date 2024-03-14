package com.example.recyclerview;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.databinding.ActivityRecyclerViewAndroidBinding;

public class RecyclerViewAndroid extends AppCompatActivity {
    RecyclerView RCVMo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_android);
        RCVMo = findViewById(R.id.RCVMo);
        RCVMo.setLayoutManager( new LinearLayoutManager(this));
        String array[] = {"Recycler View","--------------","STUDENTS NAME","Moin", "Junaid","Subhan","Sheharyar","Ahmad","AbuBakar","Kashif","Uzair","Husnain","Abdullah","Wahaj","Ali","Kabeer","Haris","Ehsan","Imran","Talha","Rafay","Huzaifa","Aaqil","Aftab","Alyas","Hamid","Athar","Hamid"};
        RCVMo.setAdapter(new RecyclerViewAdapter(array));
    }
}

