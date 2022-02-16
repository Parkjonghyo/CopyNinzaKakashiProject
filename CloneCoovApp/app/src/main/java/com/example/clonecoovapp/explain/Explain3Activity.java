package com.example.clonecoovapp.explain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.clonecoovapp.login.LoginActivity;
import com.example.clonecoovapp.R;
import com.example.clonecoovapp.common.Utils;
import com.example.clonecoovapp.login.LoginCheckActivity;
import com.google.android.material.button.MaterialButton;

public class Explain3Activity extends AppCompatActivity implements View.OnClickListener {

    MaterialButton btn_confirm;
    ImageView img_all, img_sel1, img_sel2, img_desc1, img_desc2;
    boolean sel1, sel2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.setStatusBarColor(Explain3Activity.this, Utils.StatusBarColorType.BLUE_STATUS_BAR);
        setContentView(R.layout.activity_explain3);


        btn_confirm = findViewById(R.id.btn_confirm);
        img_all = findViewById(R.id.img_all);
        img_sel1 = findViewById(R.id.img_sel1);
        img_sel2 = findViewById(R.id.img_sel2);
        img_desc1 = findViewById(R.id.img_desc1);
        img_desc2 = findViewById(R.id.img_desc2);

        btn_confirm.setOnClickListener(this);
        img_all.setOnClickListener(this);
        img_sel1.setOnClickListener(this);
        img_sel2.setOnClickListener(this);
        img_desc1.setOnClickListener(this);
        img_desc2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.img_all:
                if(sel1 == sel2) {
                    sel1 = !sel1;
                    sel2 = !sel2;
                } else {
                    sel1 = sel2 = true;
                }
                break;
            case R.id.img_sel1:
                sel1 = !sel1;
                break;
            case R.id.img_sel2:
                sel2 = !sel2;
                break;
            case R.id.btn_confirm:
                if(!(sel1 && sel2)){
                    Toast.makeText(Explain3Activity.this, "모든 약관에 동의해주세요", Toast.LENGTH_SHORT).show();
                    break;
                }
                Intent intent = new Intent(Explain3Activity.this, LoginCheckActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                Toast.makeText(Explain3Activity.this, "~~이러이러한 혜택과 ~~한 주의점이 있습니다\n전부 이해하시면 좌측의 체크표시를 눌러주세요", Toast.LENGTH_SHORT).show();
                break;
        }

        if(sel1) changeColorImg(findViewById(R.id.img_sel1), "deeper");
        else changeColorImg(findViewById(R.id.img_sel1), "none");

        if(sel2) changeColorImg(findViewById(R.id.img_sel2), "deeper");
        else changeColorImg(findViewById(R.id.img_sel2), "none");

        if(sel1 && sel2) changeColorImg(findViewById(R.id.img_all), "deeper");
        else changeColorImg(findViewById(R.id.img_all), "none");
    }

    private void changeColorImg(ImageView imgv, String mode){
        if(mode.equals("none")) imgv.setColorFilter(getResources().getColor(R.color.gray));
        if(mode.equals("normal")) imgv.setColorFilter(getResources().getColor(R.color.blue_200));
        if(mode.equals("deep"))  imgv.setColorFilter(getResources().getColor(R.color.blue_500));
        if(mode.equals("deeper")) imgv.setColorFilter(getResources().getColor(R.color.blue_700));
    }
}