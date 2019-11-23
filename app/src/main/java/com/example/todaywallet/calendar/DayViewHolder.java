package com.example.todaywallet.calendar;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaywallet.R;
import com.example.todaywallet.TodayCalendarFragment;

class DayViewHolder extends RecyclerView.ViewHolder {// 요일 입 ViewHolder

    TextView itemDay;


    public DayViewHolder(@NonNull View itemView, final Context context) {
        super(itemView);

        initView(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TodayCalendarFragment todayCalendarFragment = new TodayCalendarFragment();
                Bundle bundle = new Bundle(1);
                bundle.putString("clickDay",itemDay.getText().toString());
                Log.i("todayTest",itemDay.getText().toString());
                todayCalendarFragment.setArguments(bundle);
                FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container,todayCalendarFragment).commitAllowingStateLoss();

            }
        });

    }

    public void initView(View v){

        itemDay = (TextView)v.findViewById(R.id.txt_recycle_to_day);

    }

    public void bind(Day model){
        String day = model.getDay();

        itemDay.setText(day);

    };
}
