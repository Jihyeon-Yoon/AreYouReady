package com.example.yjh.areyouready;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;


/**
 * A simple {@link Fragment} subclass.
 */
/*
 * Requirement Credit Fragment
 */
public class RequirementCreFragment extends Fragment {
    private WebView mWebView; // 웹뷰
    private WebSettings mWebSettings; // 웹뷰 세팅

    public RequirementCreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_requirement_cre, container, false);

        // 졸업요건 교양과목 표를 WebView를 이용해서 보여줄 것임.
        mWebView = rootView.findViewById(R.id.wv_liberal_arts);

        // WebView 세부 옵션
        mWebSettings = mWebView.getSettings();

        // 컨텐츠가 웹뷰보다 클 경우 스크린 크기에 맞게 조정
        mWebSettings.setUseWideViewPort(true);
        mWebSettings.setLoadWithOverviewMode(true);

        // 웹뷰 멀티터치 가능하게 (줌기능)
        mWebSettings.setBuiltInZoomControls(true); // 줌 아이콘 사용 설정
        mWebSettings.setSupportZoom(true);

        // assets 폴더 안의 www 폴더 안에 html파일이 있음. 그 html 파일이 표 이미지를 보여주는 html 파일임.
        mWebView.loadUrl("file:///android_asset/www/test.html");

        return rootView;
    }

}
