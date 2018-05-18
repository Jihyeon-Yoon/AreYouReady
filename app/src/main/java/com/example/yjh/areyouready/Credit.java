package com.example.yjh.areyouready;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by YJH on 2018-05-17.
 */

public class Credit extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.credit, null);

        TabLayout tabLayout = rootView.findViewById(R.id.credit_tab);
        ViewPager viewPager = rootView.findViewById(R.id.credit_viewPager);

        Fragment[] arrFragments = new Fragment[4];
        arrFragments[0] = new CreditFirstFragment();
        arrFragments[1] = new CreditSecondFragment();
        arrFragments[2] = new CreditThirdFragment();
        arrFragments[4] = new CreditFourthFragment();

        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager(), arrFragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        return rootView;
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        private Fragment[] arrFragments;

        public MyPagerAdapter(FragmentManager fm, Fragment[] arrFragments) {
            super(fm);
            this.arrFragments = arrFragments;
        }

        @Override
        public Fragment getItem(int position) {
            return arrFragments[position];
        }

        @Override
        public int getCount() {
            return arrFragments.length;
        }
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "1학년";
                case 1:
                    return "2학년";
                case 2:
                    return "3학년";
                case 3:
                    return "4학년";
                default:
                    return "";
            }
        }
    }
}
