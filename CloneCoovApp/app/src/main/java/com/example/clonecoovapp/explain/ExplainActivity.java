package com.example.clonecoovapp.explain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.clonecoovapp.MainActivity;
import com.example.clonecoovapp.R;
import com.google.android.material.button.MaterialButton;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import java.util.ArrayList;

public class ExplainActivity extends AppCompatActivity {

    ViewPager2 pager2;
    SpringDotsIndicator indicator;
    MaterialButton btn_next, btn_skip, btn_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explain);

        pager2 = findViewById(R.id.pager2);
        indicator = findViewById(R.id.dots_indicator);
        btn_next = findViewById(R.id.btn_next);
        btn_skip = findViewById(R.id.btn_skip);
        btn_go = findViewById(R.id.btn_go);

        ArrayList<ExplainDTO> list = initList();

        ExplainAdapter adapter = new ExplainAdapter(list, ExplainActivity.this);
        pager2.setAdapter(adapter);
        pager2.setUserInputEnabled(false);
        indicator.setViewPager2(pager2);


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager2.setCurrentItem(pager2.getCurrentItem()+1);
                if(pager2.getCurrentItem() == 4){
                    btn_skip.setVisibility(View.GONE);
                    btn_next.setVisibility(View.GONE);
                    btn_go.setVisibility(View.VISIBLE);
                }
            }
        });

        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager2.setCurrentItem(4);
                btn_skip.setVisibility(View.GONE);
                btn_next.setVisibility(View.GONE);
                btn_go.setVisibility(View.VISIBLE);
            }
        });
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExplainActivity.this, Explain2Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private ArrayList<ExplainDTO> initList() {
        ArrayList<ExplainDTO> list = new ArrayList<>();

        list.add(new ExplainDTO(R.drawable.ex01, "완벽한 개인 정보 보호", "블록체인 기술을 이용해 서버에 사용 기록이\n남지 않아 개인정보를 안전하게 보호합니다"));
        list.add(new ExplainDTO(R.drawable.ex02, "증명서 제출 및 상대방 검증 기능", "생성된 QR코드로 나의 증명서를 제출하고\n상대방의 QR코드를 카메라 스캔으로\n검증합니다"));
        list.add(new ExplainDTO(R.drawable.ex03, "선택에 따른 추가 정보 제공", "성인 인증을 비롯해 이름 생년월일 여권본호\n등 다양한 정보를 사용자의 선택에 의해\n제공할 수 있습니다."));
        list.add(new ExplainDTO(R.drawable.ex04, "국가예방접종 시스템으로 사용", "향후 접종 받은 다양한 백신의 정보를\nCOOV를 통해 확인하고 인증할 수 있습니다"));
        list.add(new ExplainDTO(R.drawable.ex05, "세계 각국에서 사용 가능", "PASS INFRA를 통해 세계 각국에서 상호\n호환이 가능합니다"));

        return list;
    }
}