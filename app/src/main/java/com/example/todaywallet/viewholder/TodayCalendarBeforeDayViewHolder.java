package com.example.todaywallet.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaywallet.R;
import com.example.todaywallet.calendar.Day;

public class TodayCalendarBeforeDayViewHolder extends RecyclerView.ViewHolder {// 요일 입 ViewHolder

    TextView itemDay;


    public TodayCalendarBeforeDayViewHolder (@NonNull View itemView) {
        super(itemView);

        initView(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //다이얼로그 구현
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
