package com.example.todaywallet.calendar;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.todaywallet.R;
import com.example.todaywallet.databinding.ItemEmptyDayBinding;
import com.example.todaywallet.databinding.ItemLockDayBinding;
import com.example.todaywallet.databinding.ItemTodayBinding;
import com.example.todaywallet.databinding.ItemUnlockDayBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
public class CalendarAdapter extends RecyclerView.Adapter {

    private final int EMPTY_TYPE = 1;
    private final int DAY_TYPE = 2;

    private List<Object> mCalendarList;
    private int today = 0;

    public CalendarAdapter(List<Object> calendarList,int today) {
        mCalendarList = calendarList;
        this.today = today;

    }

    public void setCalendarList(List<Object> calendarList) {
        mCalendarList = calendarList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) { //뷰타입 나누기
        Object item = mCalendarList.get(position);
         if (item instanceof String) {
            return EMPTY_TYPE; // 비어있는 일자 타입
        } else {
            return DAY_TYPE; // 일자 타입

        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (viewType == EMPTY_TYPE) {
            return new EmptyViewHolder(inflater.inflate(R.layout.item_empty_day, parent, false));

        }
        else {
            return new DayViewHolder(inflater.inflate(R.layout.item_today, parent, false));

        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        int viewType = getItemViewType(position);


        if (viewType == EMPTY_TYPE) {
            EmptyViewHolder holder = (EmptyViewHolder) viewHolder;
            EmptyDay model = new EmptyDay();
            holder.bind(model);
        }

        else if (viewType == DAY_TYPE) {
            DayViewHolder holder = (DayViewHolder) viewHolder;
            Object item = mCalendarList.get(position);
            Day model = new Day();
            if (item instanceof Calendar) {

                model.setCalendar((Calendar) item);
            }
            holder.bind(model);
        }
    }

    // 개수구하기
    @Override
    public int getItemCount() {

        return mCalendarList.size();
    }

}