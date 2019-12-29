package com.example.todaywallet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaywallet.adapter.TodayHistoryAdapter;
import com.example.todaywallet.databinding.FragmentTodayCalendarInBinding;
import com.example.todaywallet.dialog.BearDialog;
import com.example.todaywallet.retrofit.client.ApiClient;
import com.example.todaywallet.retrofit.client.CustomCallback;
import com.example.todaywallet.retrofit.dto.response.DayHistoryResponse;
import com.example.todaywallet.retrofit.dto.response.SignUpResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class TodayCalendarBelowFragment extends Fragment {
    FragmentTodayCalendarInBinding fragmentTodayCalendarInBinding;
    ImageView lock1;
    ImageView lock2;
    RecyclerView recyclerView;
    List<DayHistoryResponse.Data> list;
    TodayHistoryAdapter todayHistoryAdapter;
    TextView tv1;
    TextView tv3;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentTodayCalendarInBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_today_calendar_in,container,false);
        int type = Integer.parseInt((String)getArguments().get("type"));
        int today = Integer.parseInt((String)getArguments().get("today"));
        recyclerView = fragmentTodayCalendarInBinding.rycTodayBankBookList;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        tv1 = fragmentTodayCalendarInBinding.txtTodayCaldendar1;
        tv3 = fragmentTodayCalendarInBinding.txtTodayCaldendar3;

        lock1 = fragmentTodayCalendarInBinding.imgTodayCalendarLock1;
        lock2 = fragmentTodayCalendarInBinding.imgTodayCalendarLock2;
        if(type==1 || type==0){
            lock1.setVisibility(View.INVISIBLE);
            lock2.setVisibility(View.INVISIBLE);
        }
        if(type==2){
            recyclerView.setVisibility(View.INVISIBLE);
            tv1.setText("미래의");
            tv3.setText("입니다");

        }

        lock1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), BearDialog.class));
            }
        });

        ApiClient.getInstance().getAuthService()
                .getDayHistory(8)
                .enqueue(new CustomCallback<DayHistoryResponse>() {
            @Override
            public void onResponse(Call<DayHistoryResponse> call, Response<DayHistoryResponse> response) {

                list = response.body().getData();
                todayHistoryAdapter = new TodayHistoryAdapter(list);
                recyclerView.setAdapter(todayHistoryAdapter);



            }

        });





        return fragmentTodayCalendarInBinding.getRoot();
    }
}
