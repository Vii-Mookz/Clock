package com.example.vipavee.clock;

import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button btn_analog,btn_digital;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("   Clock");
        toolbar.setTitleTextColor(0xFFFFFFFF);
        toolbar.setLogo(R.drawable.clock2);
        toolbar.setSubtitle("    Time");
        toolbar.setSubtitleTextColor(0xFFFFFFFF);
        btn_analog = findViewById(R.id.btn_analog);
        btn_analog.setOnClickListener(this);
        btn_digital = findViewById(R.id.btn_digital);
        btn_digital.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment fragment;
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_date:
                startActivity(new Intent(Settings.ACTION_DATE_SETTINGS));
                break;
            case R.id.menu_location:
                startActivity(new Intent(Settings.ACTION_LOCALE_SETTINGS));
                break;
            case R.id.menu_sleep:
                startActivity(new Intent(Settings.ACTION_SOUND_SETTINGS));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Fragment fragment;
        if (view == btn_analog) {
            fragment = new FragmentAnalog();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();
        }else {
            fragment = new FragmentDigital();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();

        }
//        replaceFragment(fragment);

    }

//    private void replaceFragment(Fragment fragment) {
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//        transaction.replace(R.id.fragment_container, fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//
//    }


}
