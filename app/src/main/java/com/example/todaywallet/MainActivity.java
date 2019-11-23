package com.example.todaywallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private FragmentManager fragmentManager;
    private CalendarFragment calendarFragment;
    private MyPageFragment myPageFragment;
    private StaticFragment staticFragment;
    private FragmentTransaction transaction;

    private ImageButton calendarBtn;
    private ImageButton myPageBtn;
    private ImageButton staticBtn;

    private TextView calendarTxt;
    private TextView myPageTxt;
    private TextView staticTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        calendarFragment = new CalendarFragment();

        myPageFragment = new MyPageFragment();
        staticFragment = new StaticFragment();

        calendarBtn = (ImageButton)findViewById(R.id.btn_tap_calendar);
        staticBtn = (ImageButton)findViewById(R.id.btn_tap_static);
        myPageBtn = (ImageButton)findViewById(R.id.btn_tap_user);

        calendarTxt = (TextView)findViewById(R.id.txt_tap_calendar);
        staticTxt = (TextView)findViewById(R.id.txt_tap_static);
        myPageTxt = (TextView)findViewById(R.id.txt_tap_user);

        calendarBtn.setOnClickListener(this);
        staticBtn.setOnClickListener(this);
        myPageBtn.setOnClickListener(this);



        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container,calendarFragment).commitAllowingStateLoss();
    }




    @Override
    public void onClick(View v) {
        transaction = fragmentManager.beginTransaction();
        switch (v.getId()){
            case R.id.btn_tap_calendar:
                calendarBtn.setBackgroundResource(R.drawable.icon_select_calendar);
                staticBtn.setBackgroundResource(R.drawable.icon_static);
                myPageBtn.setBackgroundResource(R.drawable.icon_user);
                calendarTxt.setTextColor(Color.parseColor("#012AF8"));
                staticTxt.setTextColor(Color.parseColor("#030303"));
                myPageTxt.setTextColor(Color.parseColor("#030303"));
                transaction.replace(R.id.fragment_container, calendarFragment).commitAllowingStateLoss();
                break;
            case R.id.btn_tap_static:
                calendarBtn.setBackgroundResource(R.drawable.calendar);
                staticBtn.setBackgroundResource(R.drawable.icon_select_static);
                myPageBtn.setBackgroundResource(R.drawable.icon_user);
                calendarTxt.setTextColor(Color.parseColor("#030303"));
                staticTxt.setTextColor(Color.parseColor("#012AF8"));
                myPageTxt.setTextColor(Color.parseColor("#030303"));
                transaction.replace(R.id.fragment_container, staticFragment).commitAllowingStateLoss();
                break;
            case R.id.btn_tap_user:
                calendarBtn.setBackgroundResource(R.drawable.calendar);
                staticBtn.setBackgroundResource(R.drawable.icon_static);
                myPageBtn.setBackgroundResource(R.drawable.icon_select_user);
                calendarTxt.setTextColor(Color.parseColor("#030303"));
                staticTxt.setTextColor(Color.parseColor("#030303"));
                myPageTxt.setTextColor(Color.parseColor("#012AF8"));
                transaction.replace(R.id.fragment_container, myPageFragment).commitAllowingStateLoss();
                break;

        }
    }

}
