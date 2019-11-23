package com.example.todaywallet.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaywallet.R;
import com.example.todaywallet.TodayCalendarBelowFragment;
import com.example.todaywallet.TodayCalendarFragment;
import com.example.todaywallet.calendar.Day;

public class TodayCalendarAfterDayViewHolder extends RecyclerView.ViewHolder {// 요일 입 ViewHolder

    TextView itemDay;
    Context mContext;
    TodayCalendarBelowFragment todayCalendarBelowFragment;

    public TodayCalendarAfterDayViewHolder (@NonNull final View itemView,Context context) {
        super(itemView);
        initView(itemView);
        this.mContext = context;
        itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    todayCalendarBelowFragment = new TodayCalendarBelowFragment();
                    Bundle bundle = new Bundle(2);
                    bundle.putString("type","2");
                    bundle.putString("today",itemDay.getText().toString());
                    todayCalendarBelowFragment.setArguments(bundle);
                    FragmentManager fragmentManager = ((AppCompatActivity)mContext).getSupportFragmentManager();
                    FragmentTransaction transaction =fragmentManager.beginTransaction();
                    transaction.replace(R.id.fragment_calendar_container,todayCalendarBelowFragment).commitAllowingStateLoss();
                }
            });
    }


    public void initView(View v){
        itemDay = (TextView)v.findViewById(R.id.txt_recycle_to_day_after);


    }

    public void bind(int model){
        String day = String.valueOf(model);
        itemDay.setText(day);

    }
}
