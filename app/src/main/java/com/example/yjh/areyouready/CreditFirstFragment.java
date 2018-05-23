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

        Button btn = rootView.findViewById(R.id.button2017);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                table2017.setVisibility(View.INVISIBLE);
                table2016.setVisibility(View.VISIBLE);

                applySharedPreference();
                if(!enterYearFix.equals(enterYearTemp)) {
                    totalCreditChoose();
                    sharedPreferences();
                }

            }
        });

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
