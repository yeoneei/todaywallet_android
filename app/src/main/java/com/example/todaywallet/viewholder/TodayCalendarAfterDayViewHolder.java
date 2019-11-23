package com.example.todaywallet.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaywallet.R;
import com.example.todaywallet.TodayCalendarFragment;
import com.example.todaywallet.calendar.Day;

public class TodayCalendarAfterDayViewHolder extends RecyclerView.ViewHolder {// 요일 입 ViewHolder

    TextView itemDay;

    public TodayCalendarAfterDayViewHolder (@NonNull final View itemView) {
        super(itemView);

        initView(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

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
