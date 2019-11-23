package com.example.todaywallet.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaywallet.R;
import com.example.todaywallet.calendar.Day;
import com.example.todaywallet.viewholder.TodayCalendarAfterDayViewHolder;
import com.example.todaywallet.viewholder.TodayCalendarBeforeDayViewHolder;
import com.example.todaywallet.viewholder.TodayCalendarEmptyDayViewHolder;
import com.example.todaywallet.viewholder.TodayCalendarTodayViewHolder;

import java.util.List;

public class TodayCalendarAdapter extends RecyclerView.Adapter  {

    private int TODAY=1;
    private int BEFORE=2;
    private int AFTER=3;
    private int EMPTY=0;

    private List<Integer> mDateList;

    private int today;
    private int lastDay;

    public TodayCalendarAdapter(List<Integer> mDateList, int today, int lastDay) {
        this.mDateList = mDateList;
        this.today = today;
        this.lastDay = lastDay;
    }



    public List<Integer> getmDateList() {
        return mDateList;
    }

    public void setmDateList(List<Integer> mDateList) {
        this.mDateList = mDateList;
        notifyDataSetChanged();
    }

    public int getToday() {
        return today;
    }

    public void setToday(int today) {
        this.today = today;
    }

    @Override
    public int getItemViewType(int position) {
        int item = mDateList.get(position);

        if(item<=0 || item >lastDay){
            return EMPTY;
        }else if(item == today){
            return TODAY;
        }else if(item < today){
            return BEFORE;
        }
        return AFTER;
    }

    @Override
    public int getItemCount() {
        return mDateList.size();

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == AFTER) {
            return new TodayCalendarAfterDayViewHolder(inflater.inflate(R.layout.item_today_calendar_after, parent, false));
        }else if(viewType == BEFORE){
            return new TodayCalendarBeforeDayViewHolder(inflater.inflate(R.layout.item_today_calendar_before, parent, false));
        }else if(viewType == EMPTY){
            return new TodayCalendarEmptyDayViewHolder(inflater.inflate(R.layout.item_today_calendar_empty,parent,false));
        }
        return new TodayCalendarTodayViewHolder(inflater.inflate(R.layout.item_today_calendar_today, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        int viewType = getItemViewType(position);
        Object item = mDateList.get(position);
        Log.i("null test",String.valueOf((Integer)item));
        if(viewType==EMPTY){
            TodayCalendarEmptyDayViewHolder holder = (TodayCalendarEmptyDayViewHolder)viewHolder;
            int model = (Integer)item;
            holder.bind(model);

        }
        if (viewType == TODAY) {
            TodayCalendarTodayViewHolder holder = (TodayCalendarTodayViewHolder) viewHolder;
            int model = (Integer)item;
            holder.bind(model);
        }
        else if (viewType == AFTER) {
            TodayCalendarAfterDayViewHolder holder = (TodayCalendarAfterDayViewHolder) viewHolder;
            int model = (Integer)item;
            holder.bind(model);
        }else if(viewType == BEFORE){
            TodayCalendarBeforeDayViewHolder holder = (TodayCalendarBeforeDayViewHolder) viewHolder;
            int model = (Integer)item;
            holder.bind(model);
        }
    }

}
