package com.example.todaywallet.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaywallet.R;
import com.example.todaywallet.TodayCalendarBelowFragment;
import com.example.todaywallet.calendar.Day;

public class TodayCalendarBeforeDayViewHolder extends RecyclerView.ViewHolder {// 요일 입 ViewHolder

    TextView itemDay;
    Context context;
    TodayCalendarBelowFragment todayCalendarBelowFragment;


    public TodayCalendarBeforeDayViewHolder (@NonNull View itemView, final Context context) {
        super(itemView);

        initView(itemView);
        this.context= context;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todayCalendarBelowFragment = new TodayCalendarBelowFragment();
                Bundle bundle = new Bundle(2);
                bundle.putString("type","0");
                bundle.putString("today",itemDay.getText().toString());
                todayCalendarBelowFragment.setArguments(bundle);
                FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_calendar_container,todayCalendarBelowFragment).commitAllowingStateLoss();

            }
        });

    }


    public void initView(View v){
        itemDay = (TextView)v.findViewById(R.id.txt_recycle_to_day_before);

    }

    public void bind(int model){
        String day = String.valueOf(model);
        itemDay.setText(day);


    }
}
