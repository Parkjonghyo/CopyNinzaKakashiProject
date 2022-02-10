package com.example.clonecoovapp.setup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.clonecoovapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SetupActivity extends AppCompatActivity {

    BottomNavigationView nav_btm;
    Intent intent;
    Fragment fragment;


    public void changeFragment( Fragment to_frag ){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, to_frag).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        changeFragment(new SelectLanguageFragment());

    }
}