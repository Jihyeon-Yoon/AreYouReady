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


    //shared preference
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;
    String enterYearTemp, enterYearFix;
    int totalCredit;
    int totalCreditNow;
    Context context;

    // 추가 - 이상원
    HashMap<Integer, TableLayout> tb_year;

    // 임시 추가 - 이상원
    CheckBox chk2015_1, chk2015_2, chk2015_5, chk2015_7, chk2015_8, chk2015_9, chk2015_10, chk2015_12;

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

        // 추가 - 이상원
        tb_year = new HashMap<Integer, TableLayout>();
        tb_year.put(2013, table2013);
        tb_year.put(2014, table2014);
        tb_year.put(2015, table2015);
        tb_year.put(2016, table2016);
        tb_year.put(2017, table2017);

        Button btn = rootView.findViewById(R.id.button2015);

        // 임시 추가 - 이상원
        chk2015_1 = rootView.findViewById(R.id.chk2015_1);
        chk2015_2 = rootView.findViewById(R.id.chk2015_2);
        chk2015_5 = rootView.findViewById(R.id.chk2015_5);
        chk2015_7 = rootView.findViewById(R.id.chk2015_7);
        chk2015_8 = rootView.findViewById(R.id.chk2015_8);
        chk2015_9 = rootView.findViewById(R.id.chk2015_9);
        chk2015_10 = rootView.findViewById(R.id.chk2015_10);
        chk2015_12 = rootView.findViewById(R.id.chk2015_12);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               /* table2017.setVisibility(View.INVISIBLE);
                table2016.setVisibility(View.VISIBLE);

                applySharedPreference();
                if(!enterYearFix.equals(enterYearTemp)) {
                    totalCreditChoose();
                    sharedPreferences();
                }*/

               // 임시 추가 - 이상원
                chk2015_1.setText("완료");
                chk2015_2.setText("완료");
                chk2015_5.setText("완료");
                chk2015_7.setText("완료");
                chk2015_8.setText("완료");
                chk2015_9.setText("완료");
                chk2015_10.setText("완료");
                chk2015_12.setText("완료");
               Toast.makeText(getActivity(), "업데이트 되었습니다!", Toast.LENGTH_LONG).show();
            }
        });

        // 추가 - 이상원
        String enterYear = "2017"; // default year - 2017
        if(getArguments() != null) {
            enterYear = getArguments().getString("enterYearTemp");
        }

        for(int i = 2013; i <= 2017; i++) {
            TableLayout tl = tb_year.get(i);
            if(i == Integer.parseInt(enterYear)) {
                tl.setVisibility(View.VISIBLE);
            }
            else {
                tl.setVisibility(View.GONE);
            }
        }

        return rootView;
    }

    private void totalCreditChoose() {
        int temp = Integer.parseInt(enterYearTemp);
        switch(temp) {
            case 2017:
            case 2016:
                totalCredit = 121;
                break;
            case 2015:
            case 2014:
            case 2013:
                totalCredit = 120;
                break;
            default:
                break;
        }
    }

    public void sharedPreferences() {
        context = getActivity();
        sh_Pref = context.getSharedPreferences("STORE DATA", MODE_PRIVATE);
        toEdit = sh_Pref.edit();
        toEdit.putString("enterYearFix", enterYearTemp);
        toEdit.putInt("totalCredit", totalCredit);
        toEdit.commit();
    }

    public void applySharedPreference() {
        context = getActivity();
        sh_Pref = context.getSharedPreferences("STORE DATA", MODE_PRIVATE);
        if(sh_Pref != null && sh_Pref.contains("enterYearTemp")) {
            enterYearTemp = sh_Pref.getString("enterYearTemp", "2013");
        }
        if(sh_Pref != null && sh_Pref.contains("enterYearFix")) {
            enterYearFix = sh_Pref.getString("enterYearFix", "2017");
        }
    }

}
