package com.mpyg.yjh.areyouready;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 타이틀바 가운데 정렬
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_layout);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new Requirement());
    }

    private boolean loadFragment(Fragment fragment) {
        if(fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();

            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch(item.getItemId()) {

            case R.id.navigation_requirement:
                fragment = new Requirement();
                break;

            case R.id.navigation_volunteer:
                fragment = new Volunteer();
                break;

            case R.id.navigation_book:
                fragment = new Book();
                break;

            case R.id.navigation_credit:
                fragment = new Credit();
                break;

            case R.id.navigation_check:
                fragment = new Check();
                break;
        }

        return loadFragment(fragment);
    }

   // 메뉴(유용한 사이트, 저작권 정보)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int curId = item.getItemId();
        Intent intent = null;

        switch(curId) {
            case R.id.menu_site:
                intent = new Intent (getApplicationContext(), SiteActivity.class);
                break;
            case R.id.menu_copyright:
                intent = new Intent (getApplicationContext(), CopyrightActivity.class);
                break;
            default:
                break;
        }

        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

}
