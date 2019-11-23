package com.example.todaywallet;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.todaywallet.calendar.CalendarAdapter;
import com.example.todaywallet.calendar.Keys;
import com.example.todaywallet.databinding.FragmentCalendarBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarFragment extends Fragment {

    private FragmentCalendarBinding fragmentCalendarBinding;


    private int today=0;
    private int year;
    private int month;
    private int weekToday;
    private int lastDay;
    private int weekStartDay;
    private int weekLastDay;
    private ArrayList<Object> mDateList;
    TextView txtYear;
    TextView txtMonth;


    public int mCenterPosition;
    private long mCurrentTime;
    public ArrayList<Object> mCalendarList = new ArrayList<>();

    public TextView textView;
    public RecyclerView recyclerView;
    private CalendarAdapter mAdapter;
    private StaggeredGridLayoutManager manager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView =(ViewGroup)inflater.inflate(R.layout.fragment_calendar, container, false);
        fragmentCalendarBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_calendar,container,false);
        Calendar cal = Calendar.getInstance();
        today = cal.get(Calendar.DATE);
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);

        Log.i("year",year+"");
        txtYear =  fragmentCalendarBinding.txtCalendarYear;
        txtYear.setText(String.valueOf(year));

        fragmentCalendarBinding.txtFreeCount.setText("1234");


        txtMonth =fragmentCalendarBinding.txtCalendarMonth;
        if(month==0){
            txtMonth.setText("January");
        }else if(month==1){
            txtMonth.setText("February");
        }else if(month==2){
            txtMonth.setText("March");
        }else if(month==3){
            txtMonth.setText("April");
        }else if(month==4){
            txtMonth.setText("May");
        }else if(month==5){
            txtMonth.setText("June");
        }else if(month==6){
            txtMonth.setText("July");
        }else if(month==7){
            txtMonth.setText("August");
        }else if(month==8){
            txtMonth.setText("September");
        }else if(month==9){
            txtMonth.setText("October");
        }else if(month==10){
            txtMonth.setText("November");
        }else if(month==11){
            txtMonth.setText("December");
        }



        initView(rootView);
        initSet();
        setRecycler();

        return rootView;
    }

    public void initView(View v){

        recyclerView = (RecyclerView)v.findViewById(R.id.calendar);

    }

    public void initSet(){

        initCalendarList();

    }

    public void initCalendarList() {
        GregorianCalendar cal = new GregorianCalendar();
        setCalendarList(cal);
    }

    private void setRecycler() {

        if (mCalendarList == null) {
            Log.w("caldendar", "No Query, not initializing RecyclerView");
        }

        manager = new StaggeredGridLayoutManager(7, StaggeredGridLayoutManager.VERTICAL);


        mAdapter = new CalendarAdapter(mCalendarList,today,getActivity());

        mAdapter.setCalendarList(mCalendarList);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(mAdapter);

        if (mCenterPosition >= 0) {
            recyclerView.scrollToPosition(mCenterPosition);
        }
    }

    public void setCalendarList(GregorianCalendar cal) {

        ArrayList<Object> calendarList = new ArrayList<>();

        GregorianCalendar gregorianCalendar = new GregorianCalendar(year, month,1);
        int firstDay = gregorianCalendar.get(Calendar.DAY_OF_WEEK);
        int lastDay;
        for(int i=1; i<firstDay;i++){
            calendarList.add(Keys.EMPTY);
        }
        month++;
        if(month ==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
            for(int i=1; i<=31;i++){
                calendarList.add(i);
            }
            lastDay = 31;
        }else{
            for(int i=1; i<=30;i++){
                calendarList.add(i);
            }
            lastDay= 30;
        }
        gregorianCalendar = new GregorianCalendar(year, month,lastDay);

        for(int i=gregorianCalendar.get(Calendar.DAY_OF_WEEK);i<=7;i++){
            calendarList.add(Keys.EMPTY);
        }


        mCalendarList = calendarList;
    }


}