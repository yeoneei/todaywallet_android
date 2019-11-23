package com.example.todaywallet;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaywallet.adapter.TodayCalendarAdapter;
import com.example.todaywallet.calendar.Keys;
import com.example.todaywallet.databinding.FragmentTodayCalendarBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class TodayCalendarFragment extends Fragment {
    FragmentTodayCalendarBinding fragmentTodayCalendarBinding;

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    TodayCalendarAdapter todayCalendarAdapter;
    ArrayList<Integer> mDateList;
    int clickDay;
    int month;
    int lastDay;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentTodayCalendarBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_today_calendar,container,false);
        recyclerView = fragmentTodayCalendarBinding.rycTodayCalendar;
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);


        clickDay = Integer.parseInt(getArguments().getString("clickDay"));
        Log.i("click",getArguments().getString("clickDay")+"");
        Calendar cal = Calendar.getInstance();
        month = cal.get(Calendar.MONTH)+1;

        if(month ==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
            lastDay = 31;
        }else{
            lastDay= 30;
        }

        mDateList = new ArrayList<Integer>();
        for(int i=clickDay-6; i<clickDay;i++){
            mDateList.add(i);
        }
        mDateList.add(clickDay);
        for(int i=clickDay+1; i<clickDay+6;i++){
            mDateList.add(i);
        }

        todayCalendarAdapter = new TodayCalendarAdapter(mDateList,clickDay,lastDay);
        recyclerView.setAdapter(todayCalendarAdapter);
        recyclerView.scrollToPosition((mDateList.size()/2)-3);


        return fragmentTodayCalendarBinding.getRoot();
    }


}
