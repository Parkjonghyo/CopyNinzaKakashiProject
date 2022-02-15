package com.example.clonecoovapp.explain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.clonecoovapp.R;
import com.google.android.material.button.MaterialButton;

public class Explain2Activity extends AppCompatActivity {

    MaterialButton btn_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explain2);

        btn_confirm = findViewById(R.id.btn_confirm);

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Explain2Activity.this, Explain3Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}