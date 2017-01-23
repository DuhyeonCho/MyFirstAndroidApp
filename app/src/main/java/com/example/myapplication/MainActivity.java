package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);      // 물려받은 애를 사용함
        setContentView(R.layout.activity_main);  // 대문자 R은 리소스의 약자
    }
}
