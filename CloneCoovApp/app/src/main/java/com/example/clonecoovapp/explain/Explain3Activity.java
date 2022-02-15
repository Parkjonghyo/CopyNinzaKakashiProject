package com.example.clonecoovapp.explain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.clonecoovapp.MainActivity;
import com.example.clonecoovapp.R;
import com.example.clonecoovapp.common.Utils;
import com.google.android.material.button.MaterialButton;

public class Explain3Activity extends AppCompatActivity {

    MaterialButton btn_confirm;
    ImageView img_all, img_sel1, img_sel2, img_desc1, img_desc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.setStatusBarColor(Explain3Activity.this, Utils.StatusBarColorType.BLUE_STATUS_BAR);
        setContentView(R.layout.activity_explain3);


        btn_confirm = findViewById(R.id.btn_confirm);

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Explain3Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}