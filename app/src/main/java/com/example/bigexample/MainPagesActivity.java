package com.example.bigexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.IntentFilter;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;

import com.example.bigexample.Broadcast.ExampleBroadcastReceiver;
import com.example.bigexample.Golobal.Golobal;
import com.example.bigexample.Maps.MyMapFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainPagesActivity extends AppCompatActivity {
    public static Button btn;
    public static TextView txt;
    ExampleBroadcastReceiver exampleBroadcastReceiver = new ExampleBroadcastReceiver();

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        registerReceiver(exampleBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(exampleBroadcastReceiver);
    }

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
                    Golobal.setCheckEditCmt(0);
                    if(Golobal.getCheckEditCmt() == 1 )
                    fragment_content_post.txtCancelEditCmt.setVisibility(View.INVISIBLE);
                    break;
                case R.id.nav_upload:
                    selectedframent = new UploadPages();
                    Golobal.setCheckEditCmt(0);
                    if(Golobal.getCheckEditCmt() == 1 )
                    fragment_content_post.txtCancelEditCmt.setVisibility(View.INVISIBLE);
                    break;
                case R.id.nav_chat:
                    selectedframent = new ChatPages();
                    Golobal.setCheckEditCmt(0);
                    if(Golobal.getCheckEditCmt() == 1 )
                    fragment_content_post.txtCancelEditCmt.setVisibility(View.INVISIBLE);
                    break;
                case R.id.nav_account:
                    selectedframent = new AccountPages();
                    Golobal.setCheckEditCmt(0);
                    if(Golobal.getCheckEditCmt() == 1 )
                    fragment_content_post.txtCancelEditCmt.setVisibility(View.INVISIBLE);
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedframent).commit();
            return true;
        }
    };
}
