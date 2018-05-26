package com.example.yjh.areyouready;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by YJH on 2018-05-19.
 */

public class Check extends Fragment {

    //shared preference
    Context context;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;
    int totalCredit;
    int totalCreditNow;
    int bookNumTemp;
    int volunNumTemp;
    int volunTimeTemp;

    TextView textView_bookPercent;
    TextView textView_bookProgress;
    TextView textView_volunNumPercent;
    TextView textView_volunNumProgress;
    TextView textView_volunTimePercent;
    TextView textView_volunTimeProgress;
    TextView textView_creditPercent;
    TextView textView_creditProgress;
    TextView textView_creditTotal;
    TextView textView_bookNow;
    TextView textView_bookRemain;
    TextView textView_volunNumNow;
    TextView textView_volunNumRemain;
    TextView textView_volunTimeNow;
    TextView textView_volunTimeRemain;
    TextView textView_creditNow;
    TextView textView_creditRemain;

    ProgressBar progressBar_book;
    ProgressBar progressBar_volunteerNum;
    ProgressBar progressBar_volunteerTime;
    ProgressBar progressBar_credit;

    ImageButton bookPlus;
    ImageButton bookMinus;
    ImageButton volNumPlus;
    ImageButton volNumMinus;
    ImageButton volTimePlus;
    ImageButton volTimeMinus;

    Button button_update;

    //delete
    int book = 15;
    int volNum = 5;
    int volTime = 12;
    int bookR = 25;
    int volNumR = 5;
    int volTimeR = 8;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.check, null);

        textView_bookPercent = rootView.findViewById(R.id.textView_bookPercent);
        textView_bookProgress = rootView.findViewById(R.id.textView_bookProgress);
        textView_volunNumPercent = rootView.findViewById(R.id.textView_volunNumPercent);
        textView_volunNumProgress = rootView.findViewById(R.id.textView_volunNumProgress);
        textView_volunTimePercent = rootView.findViewById(R.id.textView_volunTimePercent);
        textView_volunTimeProgress = rootView.findViewById(R.id.textView_volunTimeProgress);
        textView_creditPercent = rootView.findViewById(R.id.textView_creditPercent);
        textView_creditProgress = rootView.findViewById(R.id.textView_creditProgress);
        textView_creditTotal = rootView.findViewById(R.id.textView_creditTotal);
        textView_bookNow = rootView.findViewById(R.id.textView_bookNow);
        textView_bookRemain = rootView.findViewById(R.id.textView_bookRemain);
        textView_volunNumNow = rootView.findViewById(R.id.textView_volunNumNow);
        textView_volunNumRemain = rootView.findViewById(R.id.textView_volunNumRemain);
        textView_volunTimeNow = rootView.findViewById(R.id.textView_volunTimeNow);
        textView_volunTimeRemain = rootView.findViewById(R.id.textView_volunTimeRemain);
        textView_creditNow = rootView.findViewById(R.id.textView_creditNow);
        textView_creditRemain = rootView.findViewById(R.id.textView_creditRemain);

        progressBar_book = rootView.findViewById(R.id.progressBar_book);
        progressBar_volunteerNum = rootView.findViewById(R.id.progressBar_volunteerNum);
        progressBar_volunteerTime = rootView.findViewById(R.id.progressBar_volunteerTime);
        progressBar_credit = rootView.findViewById(R.id.progressBar_credit);

        bookPlus = rootView.findViewById(R.id.bookPlus);
        bookMinus = rootView.findViewById(R.id.bookMinus);
        volNumPlus = rootView.findViewById(R.id.volNumPlus);
        volNumMinus = rootView.findViewById(R.id.volNumMinus);
        volTimePlus = rootView.findViewById(R.id.volTimePlus);
        volTimeMinus = rootView.findViewById(R.id.volTimeMinus);

        button_update = rootView.findViewById(R.id.button_update);






        bookPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                book++;
                textView_bookNow.setText(String.valueOf(book));
                bookR--;
                textView_bookRemain.setText(String.valueOf(bookR));
            }
        });

        bookMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        volNumPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volNum++;
                textView_volunNumNow.setText(String.valueOf(volNum));
                volNumR--;
                textView_volunNumRemain.setText(String.valueOf(volNumR));

            }
        });

        volNumMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        volTimePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volTime++;
                textView_volunTimeNow.setText(String.valueOf(volTime));
                volTimeR--;
                textView_volunTimeRemain.setText(String.valueOf(volTimeR));
            }
        });

        volTimeMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        //update
        button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_bookPercent.setText(Double.toString(42.5));
                textView_bookProgress.setText(String.valueOf(17));
                progressBar_book.setProgress(17);

                textView_volunNumPercent.setText(String.valueOf(60));
                textView_volunNumProgress.setText(String.valueOf(6));
                progressBar_volunteerNum.setProgress(6);

                textView_volunTimePercent.setText(String.valueOf(70));
                textView_volunTimeProgress.setText(String.valueOf(14));
                progressBar_volunteerTime.setProgress(14);

                textView_bookNow.setText(String.valueOf(17));
                textView_volunNumNow.setText(String.valueOf(6));
                textView_volunTimeNow.setText(String.valueOf(14));

                textView_bookRemain.setText(String.valueOf(23));
                textView_volunNumRemain.setText(String.valueOf(4));
                textView_volunTimeRemain.setText(String.valueOf(6));

                Toast.makeText(getActivity(), "업데이트 되었습니다!", Toast.LENGTH_LONG).show();

            }
        });


        return rootView;
    }

    private void showStoredData() {
        String temp;
        //percent
        temp=String.format("%.1f", bookNumTemp/40.0*100);
        textView_bookPercent.setText(temp);
        temp=String.format("%.1f", volunNumTemp/10.0*100);
        textView_volunNumPercent.setText(temp);
        temp=String.format("%.1f", volunTimeTemp/20.0*100);
        textView_volunTimeProgress.setText(temp);
        temp=String.format("%.1f", (double)totalCreditNow/totalCredit*100);
        textView_creditPercent.setText(temp);
        //progress num
        textView_bookProgress.setText(String.valueOf(bookNumTemp));
        textView_volunNumProgress.setText(String.valueOf(volunNumTemp));
        textView_volunTimeProgress.setText(String.valueOf(volunTimeTemp));
        textView_creditProgress.setText(String.valueOf(totalCreditNow));
        textView_creditTotal.setText(String.valueOf(totalCredit));
        //progress bar
        progressBar_book.setProgress(bookNumTemp);
        progressBar_volunteerNum.setProgress(volunNumTemp);
        progressBar_volunteerTime.setProgress(volunTimeTemp);
        progressBar_credit.setProgress(totalCreditNow);
        //current & remain
        textView_bookNow.setText(String.valueOf(bookNumTemp));
        textView_bookRemain.setText(String.valueOf(40-bookNumTemp));
        textView_volunNumNow.setText(String.valueOf(volunNumTemp));
        textView_volunNumRemain.setText(String.valueOf(10-volunNumTemp));
        textView_volunTimeNow.setText(String.valueOf(volunTimeTemp));
        textView_volunTimeRemain.setText(String.valueOf(20-volunTimeTemp));
        textView_creditNow.setText(String.valueOf(totalCreditNow));
        textView_creditRemain.setText(String.valueOf(totalCredit-totalCreditNow));
    }

    public void sharedPreferences() {
        context = getActivity();
        sh_Pref = context.getSharedPreferences("STORE DATA", MODE_PRIVATE);
        toEdit = sh_Pref.edit();

        toEdit.putInt("bookNumStore", bookNumTemp);
        toEdit.putInt("volunNumStore", volunNumTemp);
        toEdit.putInt("volunTimeStore", volunTimeTemp);

        toEdit.commit();
    }

    public void applySharedPreference() {
        context = getActivity();
        sh_Pref = context.getSharedPreferences("STORE DATA", MODE_PRIVATE);
        if(sh_Pref != null && sh_Pref.contains("bookNumStore")) {
            bookNumTemp = sh_Pref.getInt("bookNumStore", 0);
        }
        if(sh_Pref != null && sh_Pref.contains("volunNumStore")) {
            volunNumTemp = sh_Pref.getInt("volunNumStore", 0);
        }
        if(sh_Pref != null && sh_Pref.contains("volunTimeStore")) {
            volunTimeTemp = sh_Pref.getInt("volunTimeStore", 0);
        }
        if(sh_Pref != null && sh_Pref.contains("totalCredit")) {
            totalCredit = sh_Pref.getInt("totalCredit", 0);
        }
        if(sh_Pref != null && sh_Pref.contains("totalCreditNow")) {
            totalCreditNow = sh_Pref.getInt("totalCreditNow", 0);
        }
    }





}