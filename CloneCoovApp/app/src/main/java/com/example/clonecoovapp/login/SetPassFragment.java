package com.example.clonecoovapp.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.clonecoovapp.R;

import java.util.ArrayList;

public class SetPassFragment extends Fragment implements View.OnClickListener {

    ImageView[] img_list = new ImageView[6];
    Button[] btn_list = new Button[11];
    StringBuilder pw = new StringBuilder();
    LoginCheckActivity activity;

    public SetPassFragment(LoginCheckActivity activity) {
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_set_pass, container, false);
        init(rootView);

        for (Button btn: btn_list) {
            btn.setOnClickListener(this);
        }

        // 스트링 버퍼에 아무것도 안 들어갔을 땐 "" 상태. 또한 length로 길이를 쟀을 때는 0
        // Toast.makeText(getContext(), pw.toString().length()+"", Toast.LENGTH_SHORT).show();

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn0:
                pw.append("0");
                break;
            case R.id.btn1:
                pw.append("1");
                break;
            case R.id.btn2:
                pw.append("2");
                break;
            case R.id.btn3:
                pw.append("3");
                break;
            case R.id.btn4:
                pw.append("4");
                break;
            case R.id.btn5:
                pw.append("5");
                break;
            case R.id.btn6:
                pw.append("6");
                break;
            case R.id.btn7:
                pw.append("7");
                break;
            case R.id.btn8:
                pw.append("8");
                break;
            case R.id.btn9:
                pw.append("9");
                break;
            case R.id.btn_left_arrow:
                if(pw.length() > 0) pw.setLength(pw.length() - 1);
                break;
        }
        for(ImageView iv : img_list){
            iv.setColorFilter(getResources().getColor(R.color.gray));
        }
        for(int i=0; i<pw.length(); i++){
            img_list[i].setColorFilter(getResources().getColor(R.color.blue_500));
        }
        if(pw.length() == 6){
            activity.changeFragment(new CheckPassFragment(activity));

        }
    }

    public void init(ViewGroup rv){
        img_list[0] = rv.findViewById(R.id.img_chk1);
        img_list[1] = rv.findViewById(R.id.img_chk2);
        img_list[2] = rv.findViewById(R.id.img_chk3);
        img_list[3] = rv.findViewById(R.id.img_chk4);
        img_list[4] = rv.findViewById(R.id.img_chk5);
        img_list[5] = rv.findViewById(R.id.img_chk6);

        btn_list[0] = rv.findViewById(R.id.btn0);
        btn_list[1] = rv.findViewById(R.id.btn1);
        btn_list[2] = rv.findViewById(R.id.btn2);
        btn_list[3] = rv.findViewById(R.id.btn3);
        btn_list[4] = rv.findViewById(R.id.btn4);
        btn_list[5] = rv.findViewById(R.id.btn5);
        btn_list[6] = rv.findViewById(R.id.btn6);
        btn_list[7] = rv.findViewById(R.id.btn7);
        btn_list[8] = rv.findViewById(R.id.btn8);
        btn_list[9] = rv.findViewById(R.id.btn9);
        btn_list[10] = rv.findViewById(R.id.btn_left_arrow);
    }

}