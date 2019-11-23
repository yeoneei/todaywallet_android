package com.example.todaywallet.viewholder;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaywallet.R;
import com.example.todaywallet.TodayCalendarBelowFragment;
import com.example.todaywallet.calendar.Day;
import com.example.todaywallet.databinding.FragmentTodayCalendarBinding;

public class TodayCalendarEmptyDayViewHolder extends RecyclerView.ViewHolder {// 요일 입 ViewHolder

    TextView itemDay;
    Context mContext;
    TodayCalendarBelowFragment todayCalendarBelowFragment;

    public TodayCalendarEmptyDayViewHolder(@NonNull final View itemView,Context context) {
        super(itemView);
        mContext = context;
        initView(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todayCalendarBelowFragment = new TodayCalendarBelowFragment();
                Bundle bundle = new Bundle(1);
                bundle.putString("type","0");
                todayCalendarBelowFragment.setArguments(bundle);
                FragmentManager fragmentManager = ((AppCompatActivity)mContext).getSupportFragmentManager();
                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_calendar_container,todayCalendarBelowFragment).commitAllowingStateLoss();

            }
        });

    }


    public void initView(View v){

    }

    public void bind(int model){
        String day = String.valueOf(model);
        itemDay.setText(day);

    }
}
