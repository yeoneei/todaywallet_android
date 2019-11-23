package com.example.todaywallet.calendar;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaywallet.R;
import com.example.todaywallet.TodayCalendarFragment;

public class BeforeDayViewHolder extends RecyclerView.ViewHolder {// 요일 입 ViewHolder

    TextView itemDay;
    Context mContext;

    public BeforeDayViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        initView(itemView);
        this.mContext = context;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TodayCalendarFragment todayCalendarFragment = new TodayCalendarFragment();
                Bundle bundle = new Bundle(1);
                bundle.putString("clickDay",itemDay.getText().toString());
                Log.i("todayTest",itemDay.getText().toString());
                todayCalendarFragment.setArguments(bundle);
                FragmentManager fragmentManager = ((AppCompatActivity)mContext).getSupportFragmentManager();
                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container,todayCalendarFragment).commitAllowingStateLoss();
            }
        });
    }

    public void initView(View v){
        itemDay = (TextView)v.findViewById(R.id.txt_recycle_unblock_day);
    }

    public void bind(Day model){
        String day = model.getDay();
        // 일자 값 View에 보이게하기
        itemDay.setText(day);

    };
}