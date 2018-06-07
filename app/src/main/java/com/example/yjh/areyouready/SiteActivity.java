package com.example.yjh.areyouready;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site);

        //타이틀바 가운데 정렬
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_site_part);

        Button english1 = findViewById(R.id.english1);
        Button english2 = findViewById(R.id.english2);
        Button english3 = findViewById(R.id.english3);
        Button english4 = findViewById(R.id.english4);

        Button competition1 = findViewById(R.id.competition1);
        Button competition2 = findViewById(R.id.competition2);
        Button competition3 = findViewById(R.id.competition3);

        Button job1 = findViewById(R.id.job1);
        Button job2 = findViewById(R.id.job2);
        Button job3 = findViewById(R.id.job3);
        Button job4 = findViewById(R.id.job4);

        Button study1 = findViewById(R.id.study1);
        Button study2 = findViewById(R.id.study2);
        Button study3 = findViewById(R.id.study3);
        Button study4 = findViewById(R.id.study4);
        Button study5 = findViewById(R.id.study5);
        Button study6 = findViewById(R.id.study6);

        english1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://m.exam.ybmnet.co.kr/toeic/schedule/schedule.asp"));
                startActivity(intent);
            }
        });

        english2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://appexam.ybmnet.co.kr/toeicswt/receipt/schedule.asp"));
                startActivity(intent);
            }
        });

        english3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.ets.org/bin/getprogram.cgi?urlSource=toefl&newRegURL=&test=TOEFL&greClosed=new&greClosedCountry=China&browserType=&toeflType=&redirect=&t_country1=group_Korea%28Rok%29"));
                startActivity(intent);
            }
        });

        english4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.opic.or.kr/opics/servlet/controller.opic.site.receipt.AnnualScheduleServlet?p_process=select-list&p_nav=1_5"));
                startActivity(intent);
            }
        });

        competition1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://icpckorea.org/"));
                startActivity(intent);
            }
        });

        competition2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.codeground.org/"));
                startActivity(intent);
            }
        });

        competition3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://atcoder.jp/"));
                startActivity(intent);
            }
        });

        job1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://kr.linkedin.com/"));
                startActivity(intent);
            }
        });

        job2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://cafe.naver.com/specup"));
                startActivity(intent);
            }
        });

        job3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://cafe.naver.com/dokchi"));
                startActivity(intent);
            }
        });

        job4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://cafe.naver.com/uccplus"));
                startActivity(intent);
            }
        });

        study1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://swexpertacademy.com/main/main.do"));
                startActivity(intent);
            }
        });

        study2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.opentutorials.org/"));
                startActivity(intent);
            }
        });

        study3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.inflearn.com/"));
                startActivity(intent);
            }
        });

        study4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://programmers.co.kr/"));
                startActivity(intent);
            }
        });

        study5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.acmicpc.net/"));
                startActivity(intent);
            }
        });

        study6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://algospot.com/"));
                startActivity(intent);
            }
        });


    }
}
