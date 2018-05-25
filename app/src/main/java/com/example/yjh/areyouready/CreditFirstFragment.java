package com.example.yjh.areyouready;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

    // 연도 - 해당 테이블 매핑(mapping)
    HashMap<Integer, TableLayout> tb_year;

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

        // <연도 - 테이블> 해시맵을 생성하고 연도와 그에 해당하는 테이블을 매핑한다.
        tb_year = new HashMap<Integer, TableLayout>();
        tb_year.put(2013, table2013);
        tb_year.put(2014, table2014);
        tb_year.put(2015, table2015);
        tb_year.put(2016, table2016);
        tb_year.put(2017, table2017);

        Button btn = rootView.findViewById(R.id.button2015);


        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               /* table2017.setVisibility(View.INVISIBLE);
                table2016.setVisibility(View.VISIBLE);

                applySharedPreference();
                if(!enterYearFix.equals(enterYearTemp)) {
                    totalCreditChoose();
                    sharedPreferences();
                }*/

               Toast.makeText(getActivity(), "업데이트 되었습니다!", Toast.LENGTH_LONG).show();
            }
        });

        // getArguments()를 이용해 Credit fragment에서 전달된 연도값을 받는다.
        String enterYear = "2017"; // default year - 2017, (별 이유없이 그냥 2017로 설정함...)
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
