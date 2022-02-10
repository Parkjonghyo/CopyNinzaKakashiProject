package com.example.clonecoovapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.clonecoovapp.setup.SetupActivity;

public class SplashActivity extends AppCompatActivity {
    /* 스플래시 화면이 표시되는 시간을 설정(ms) */
    private final int SPLASH_DISPLAY_TIME = 3000;
//  [내부]  [상수] [정수]  [상수명(대문자)]  [ms단위]

    // 출처: https://smoh.tistory.com/196 [Simple is Beautiful.]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // 핸들러란, worker thread 에서 main thread 로 메시지를 전달해주는 역할을 하는 클래스이다. - https://salix97.tistory.com/82
        Handler handler = new Handler();
        // 두번째 매개변수값의 ms 만큼 지났다가 run을 실행한다.
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, SetupActivity.class));
                // 스플래시 액티비티를 스택에서 제거 (220209, 오늘 말해주셨던 것 finish)
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_TIME);
    }

    @Override
    public void onBackPressed() { // 뒤로가기 버튼을 눌렀을 때 사용(실행)할 메서드
        /* 스플래시 화면에서 뒤로가기 기능 제거 */
    }

}