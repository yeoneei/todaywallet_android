package com.example.todaywallet.calendar;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaywallet.R;
import com.example.todaywallet.TodayCalendarFragment;

import java.util.List;
public class CalendarAdapter extends RecyclerView.Adapter {

    private final int EMPTY_TYPE = 1;
    private final int DAY_TYPE = 2;
    private final int AFTER_TYPE =3;
    private final int BEFORE_TYPE=4;

    private Context mContext;

    private List<Object> mCalendarList;
    private int today = 0;

    public CalendarAdapter(List<Object> calendarList,int today, Context mContext) {
        mCalendarList = calendarList;
        this.today = today;
        this.mContext = mContext;

    }

    public void setCalendarList(List<Object> calendarList) {
        mCalendarList = calendarList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) { //뷰타입 나누기
        Object item = mCalendarList.get(position);
        Log.i("item",item+"");
         if (item instanceof String) {
            return EMPTY_TYPE; // 비어있는 일자 타입
        }else if( item instanceof Integer && today == (Integer)item){
             return DAY_TYPE;
         }else if(item instanceof Integer && today < (Integer)item){
             return AFTER_TYPE;
         }else if(item instanceof Integer && today > (Integer)item){
             return BEFORE_TYPE;
         }
         return EMPTY_TYPE;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        Log.i("typeTest",viewType+"");
        if (viewType == EMPTY_TYPE) {
            return new EmptyViewHolder(inflater.inflate(R.layout.item_empty_day, parent, false));
        }else if(viewType == DAY_TYPE){
            return new DayViewHolder(inflater.inflate(R.layout.item_today, parent, false),mContext);
        }else if(viewType == AFTER_TYPE){
            return new AfterViewHolder(inflater.inflate(R.layout.item_lock_day, parent, false),mContext);
        }else if(viewType == BEFORE_TYPE){
            return new BeforeDayViewHolder(inflater.inflate(R.layout.item_unlock_day,parent,false),mContext);
        }
        return new EmptyViewHolder(inflater.inflate(R.layout.item_empty_day, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        int viewType = getItemViewType(position);
        Object item = mCalendarList.get(position);

        if (viewType == EMPTY_TYPE) {
            EmptyViewHolder holder = (EmptyViewHolder) viewHolder;
            EmptyDay model = new EmptyDay();
            holder.bind(model);
        }
        else if (viewType == DAY_TYPE) {
            DayViewHolder holder = (DayViewHolder) viewHolder;
            Day model = new Day();
            if (item instanceof Integer) {
                model.setCalendar((Integer) item);
            }
            holder.bind(model);
        }else if(viewType == AFTER_TYPE){
            AfterViewHolder holder = (AfterViewHolder)viewHolder;
            Day model = new Day();
            if (item instanceof Integer) {
                model.setCalendar((Integer) item);
            }
            holder.bind(model);
        }else if(viewType == BEFORE_TYPE){
            BeforeDayViewHolder holder = (BeforeDayViewHolder) viewHolder;
            Day model = new Day();
            if (item instanceof Integer) {
                model.setCalendar((Integer)item);
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