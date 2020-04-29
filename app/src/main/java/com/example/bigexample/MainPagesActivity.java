package com.example.bigexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainPagesActivity extends AppCompatActivity {
    public static Button btn;
    public static TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pages);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomePages()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedframent = null;
            switch (item.getItemId()) {
                case R.id.nav_home:
                    selectedframent = new HomePages();
                    break;
                case R.id.nav_upload:
                    selectedframent = new UploadPages();
                    break;
                case R.id.nav_chat:
                    selectedframent = new ChatPages();
                    break;
                case R.id.nav_account:
                    selectedframent = new AccountPages();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedframent).commit();
            return true;
        }
    };
}
