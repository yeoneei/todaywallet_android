package com.example.todaywallet.calendar;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaywallet.R;

public class AfterViewHolder extends RecyclerView.ViewHolder {// 요일 입 ViewHolder

    TextView itemDay;

    public AfterViewHolder(@NonNull View itemView) {
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
        itemDay = (TextView)v.findViewById(R.id.txt_recycle_lock_day);
    }

    public void bind(Day model){
        String day = model.getDay();
        // 일자 값 View에 보이게하기
        itemDay.setText(day);

    };
}