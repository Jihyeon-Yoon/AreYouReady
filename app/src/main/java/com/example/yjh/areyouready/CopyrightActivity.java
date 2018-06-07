package com.example.yjh.areyouready;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class CopyrightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copyright);

            // 졸업요건 교양과목 표를 WebView를 이용해서 보여줄 것임.
        WebView mWebView = findViewById(R.id.wv_liberal_arts);

        // assets 폴더 안의 www 폴더 안에 html파일이 있음. 그 html 파일이 표 이미지를 보여주는 html 파일임.
        mWebView.loadUrl("file:///android_asset/www/test.html");
    }
}
