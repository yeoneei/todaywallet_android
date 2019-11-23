package com.example.todaywallet.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaywallet.R;
import com.example.todaywallet.calendar.Day;

public class TodayCalendarEmptyDayViewHolder extends RecyclerView.ViewHolder {// 요일 입 ViewHolder

    TextView itemDay;
    ImageView lock1;
    ImageView lock2;

    public TodayCalendarEmptyDayViewHolder(@NonNull final View itemView) {
        super(itemView);

        initView(itemView);

    }


    public void initView(View v){
        lock1 = (ImageView)v.findViewById(R.id.img_today_calendar_lock1);
        lock1.setVisibility(View.INVISIBLE);

        lock2 = (ImageView)v.findViewById(R.id.img_today_calendar_lock2);
        lock2.setVisibility(View.INVISIBLE);
        itemDay = (TextView)v.findViewById(R.id.txt_recycle_to_day_after);
    }

    public void bind(int model){
        String day = String.valueOf(model);
        itemDay.setText(day);

    }
}
