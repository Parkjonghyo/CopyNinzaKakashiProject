package com.example.clonecoovapp.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.clonecoovapp.R;

public class LoginCheckActivity extends AppCompatActivity {

    public void changeFragment( Fragment to_frag ){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, to_frag).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_check);

        changeFragment(new SetPassFragment(this));
    }
}