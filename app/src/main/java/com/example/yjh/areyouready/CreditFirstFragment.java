package com.example.yjh.areyouready;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreditFirstFragment extends Fragment {

    TableLayout table2017;
    TableLayout table2016;
    TableLayout table2015;
    TableLayout table2014;
    TableLayout table2013;

    CheckBox chk2017_1;
    CheckBox chk2017_2;
    CheckBox chk2017_3;
    CheckBox chk2017_4;
    CheckBox chk2017_5;
    CheckBox chk2017_6;
    CheckBox chk2017_7;
    CheckBox chk2017_8;
    CheckBox chk2017_9;
    CheckBox chk2017_10;
    CheckBox chk2017_11;
    CheckBox chk2017_12;
    CheckBox chk2017_13;
    CheckBox chk2017_14;
    CheckBox chk2017_15;
    CheckBox chk2017_16;
    CheckBox chk2017_17;

    CheckBox chk2016_1;
    CheckBox chk2016_2;
    CheckBox chk2016_3;
    CheckBox chk2016_4;
    CheckBox chk2016_5;
    CheckBox chk2016_6;
    CheckBox chk2016_7;
    CheckBox chk2016_8;
    CheckBox chk2016_9;
    CheckBox chk2016_10;
    CheckBox chk2016_11;
    CheckBox chk2016_12;
    CheckBox chk2016_13;
    CheckBox chk2016_14;

    Button button2017;
    Button button2016;
    Button button2015;
    Button button2014;
    Button button2013;

    String file2017_1 = "file2017_1.txt";


    //shared preference
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;
    String enterYear;
    Context context;

    // 연도 - 해당 테이블 매핑(mapping)
    HashMap<Integer, TableLayout> tb_year;

    // 과목순서 - 체크박스 매핑
    HashMap<Integer, CheckBox> defaultChk2017_1;

    public CreditFirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_credit_first, container, false);

        table2017 = rootView.findViewById(R.id.tableLayout2017);
        table2016 = rootView.findViewById(R.id.tableLayout2016);
        table2015 = rootView.findViewById(R.id.tableLayout2015);
        table2014 = rootView.findViewById(R.id.tableLayout2014);
        table2013 = rootView.findViewById(R.id.tableLayout2013);

        chk2017_1 = rootView.findViewById(R.id.chk2017_1);
        chk2017_2= rootView.findViewById(R.id.chk2017_2);
        chk2017_3= rootView.findViewById(R.id.chk2017_3);
        chk2017_4= rootView.findViewById(R.id.chk2017_4);
        chk2017_5= rootView.findViewById(R.id.chk2017_5);
        chk2017_6= rootView.findViewById(R.id.chk2017_6);
        chk2017_7= rootView.findViewById(R.id.chk2017_7);
        chk2017_8= rootView.findViewById(R.id.chk2017_8);
        chk2017_9= rootView.findViewById(R.id.chk2017_9);
        chk2017_10= rootView.findViewById(R.id.chk2017_10);
        chk2017_11= rootView.findViewById(R.id.chk2017_11);
        chk2017_12= rootView.findViewById(R.id.chk2017_12);
        chk2017_13= rootView.findViewById(R.id.chk2017_13);
        chk2017_14= rootView.findViewById(R.id.chk2017_14);
        chk2017_15= rootView.findViewById(R.id.chk2017_15);
        chk2017_16= rootView.findViewById(R.id.chk2017_16);
        chk2017_17= rootView.findViewById(R.id.chk2017_17);

        button2017= rootView.findViewById(R.id.button2017);


        // <연도 - 테이블> 해시맵을 생성하고 연도와 그에 해당하는 테이블을 매핑한다.
        tb_year = new HashMap<Integer, TableLayout>();
        tb_year.put(2013, table2013);
        tb_year.put(2014, table2014);
        tb_year.put(2015, table2015);
        tb_year.put(2016, table2016);
        tb_year.put(2017, table2017);

        // getArguments()를 이용해 Credit fragment에서 전달된 연도값을 받는다.
        enterYear = "2017"; // default year - 2017, (별 이유없이 그냥 2017로 설정함...)
        if(getArguments() != null) {
            enterYear = getArguments().getString("enterYearTemp");
        }


        // 2013 ~ 2017중 Credit fragment에서 전달된 값에 해당하는 테이블만 VISIBLE로 바꾸고, 나머지 테이블은 GONE으로 바꾼다.
        for(int i = 2013; i <= 2017; i++) {
            TableLayout tl = tb_year.get(i); // i값에 매핑된 테이블을 참조한다.
            if(i == Integer.parseInt(enterYear)) { // 전달된 값에 해당하는 경우
                tl.setVisibility(View.VISIBLE);


            }
            else { // 전달된 값이 아닌 경우
                tl.setVisibility(View.GONE);
            }
        }





        button2017.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    int sum=0;
                    OutputStreamWriter out = new OutputStreamWriter(getActivity().openFileOutput(file2017_1, 0));
                    if(chk2017_1.isChecked()) {
                        chk2017_1.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        out.write("0\n");
                    }
                    if(chk2017_2.isChecked()) {
                        chk2017_2.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        out.write("0\n");
                    }
                    if(chk2017_3.isChecked()) {
                        chk2017_3.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        out.write("0\n");
                    }
                    if(chk2017_4.isChecked()) {
                        chk2017_4.setText("완료");
                        out.write("1\n");
                        sum += 1;
                    } else {
                        out.write("0\n");
                    }
                    if(chk2017_5.isChecked()) {
                        chk2017_5.setText("완료");
                        out.write("1\n");
                        sum += 1;
                    } else {
                        out.write("0\n");
                    }
                    if(chk2017_6.isChecked()) {
                        chk2017_6.setText("완료");
                        out.write("2\n");
                        sum += 2;
                    } else {
                        out.write("0\n");
                    }
                    if(chk2017_7.isChecked()) {
                        chk2017_7.setText("완료");
                        out.write("2\n");
                        sum += 2;
                    } else {
                        out.write("0\n");
                    }
                    if(chk2017_8.isChecked()) {
                        chk2017_8.setText("완료");
                        out.write("2\n");
                        sum += 2;
                    } else {
                        out.write("0\n");
                    }
                    if(chk2017_9.isChecked()) {
                        chk2017_9.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        out.write("0\n");
                    }
                    if(chk2017_10.isChecked()) {
                        chk2017_10.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        out.write("0\n");
                    }
                    if(chk2017_11.isChecked()) {
                        chk2017_11.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        out.write("0\n");
                    }
                    if(chk2017_12.isChecked()) {
                        chk2017_12.setText("완료");
                        out.write("1\n");
                        sum += 1;
                    } else {
                        out.write("0\n");
                    }
                    if(chk2017_13.isChecked()) {
                        chk2017_13.setText("완료");
                        out.write("2\n");
                        sum += 2;
                    } else {
                        out.write("0\n");
                    }
                    if(chk2017_14.isChecked()) {
                        chk2017_14.setText("완료");
                        out.write("2\n");
                        sum += 2;
                    } else {
                        out.write("0\n");
                    }
                    if(chk2017_15.isChecked()) {
                        chk2017_15.setText("완료");
                        out.write("2\n");
                        sum += 2;
                    } else {
                        out.write("0\n");
                    }
                    if(chk2017_16.isChecked()) {
                        chk2017_16.setText("완료");
                        out.write("2\n");
                        sum += 2;
                    } else {
                        out.write("0\n");
                    }
                    if(chk2017_17.isChecked()) {
                        chk2017_17.setText("완료");
                        out.write("2\n");
                        sum += 2;
                    } else {
                        out.write("0\n");
                    }
                    out.close();
                    //2017_1 이수학점 총합 저장
                    sharedPreferencesCreditSum("sum2017_1", sum);
                    sharedPreferences();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        return rootView;
    }


    public void onResume() {
        super.onResume();
        //enterYear 값에 맞는 default 보여주기
        switch(enterYear) {
            case "2017":
                showDefault2017_1();
                break;
                /*
            case "2016":
                showDefault2016_1();
                break;
            case "2015":
                showDefault2015_1();
                break;
            case "2014":
                showDefault2014_1();
                break;
            case "2013":
                showDefault2013_1();
                break;
                */
            default:
                break;
        }

    }

    public void sharedPreferences() {
        context = getActivity();
        sh_Pref = context.getSharedPreferences("STORE DATA", MODE_PRIVATE);
        toEdit = sh_Pref.edit();
        toEdit.putString("enterYearFix", enterYear);
        toEdit.commit();
    }

    public void sharedPreferencesCreditSum(String year, int sum) {
        context = getActivity();
        sh_Pref = context.getSharedPreferences("STORE DATA", MODE_PRIVATE);
        toEdit = sh_Pref.edit();
        toEdit.putInt(year, sum);
        toEdit.commit();
    }



    private void showDefault2017_1() {
        int i=0;
        CheckBox chkTemp;

        //<과목순서 - 체크박스> 해시맵 생성 & 매핑
        defaultChk2017_1 = new HashMap<Integer, CheckBox>();
        defaultChk2017_1.put(1, chk2017_1);
        defaultChk2017_1.put(2, chk2017_2);
        defaultChk2017_1.put(3, chk2017_3);
        defaultChk2017_1.put(4, chk2017_4);
        defaultChk2017_1.put(5, chk2017_5);
        defaultChk2017_1.put(6, chk2017_6);
        defaultChk2017_1.put(7, chk2017_7);
        defaultChk2017_1.put(8, chk2017_8);
        defaultChk2017_1.put(9, chk2017_9);
        defaultChk2017_1.put(10, chk2017_10);
        defaultChk2017_1.put(11, chk2017_11);
        defaultChk2017_1.put(12, chk2017_12);
        defaultChk2017_1.put(13, chk2017_13);
        defaultChk2017_1.put(14, chk2017_14);
        defaultChk2017_1.put(15, chk2017_15);
        defaultChk2017_1.put(16, chk2017_16);
        defaultChk2017_1.put(17, chk2017_17);

        try {
            InputStream in = getActivity().openFileInput(file2017_1);
            if(in != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String str = "";

                while ((str = reader.readLine()) != null) {
                    i++;
                    if(Integer.parseInt(str) != 0) {
                        chkTemp = defaultChk2017_1.get(i); //i 값에 매핑된 체크박스 참조
                        chkTemp.setChecked(true);
                        chkTemp.setText("완료");
                    }
                }
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
