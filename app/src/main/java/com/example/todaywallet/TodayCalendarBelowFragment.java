package com.example.todaywallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaywallet.databinding.FragmentTodayCalendarInBinding;
import com.example.todaywallet.dialog.BearDialog;

public class TodayCalendarBelowFragment extends Fragment {
    FragmentTodayCalendarInBinding fragmentTodayCalendarInBinding;
    ImageView lock1;
    ImageView lock2;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentTodayCalendarInBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_today_calendar_in,container,false);
        int type = Integer.parseInt((String)getArguments().get("type"));
        int today = Integer.parseInt((String)getArguments().get("today"));
        recyclerView = fragmentTodayCalendarInBinding.rycTodayBankBookList;


        lock1 = fragmentTodayCalendarInBinding.imgTodayCalendarLock1;
        lock2 = fragmentTodayCalendarInBinding.imgTodayCalendarLock2;
        if(type==1 || type==0){
            lock1.setVisibility(View.INVISIBLE);
            lock2.setVisibility(View.INVISIBLE);
        }

        lock1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), BearDialog.class));
            }
        });





        return fragmentTodayCalendarInBinding.getRoot();
    }
}
