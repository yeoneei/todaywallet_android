package com.example.todaywallet.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaywallet.retrofit.dto.response.DayHistoryResponse;

import java.util.List;

public class TodayHistoryAdapter extends RecyclerView.Adapter {

    private List<DayHistoryResponse> mDateList;
    public TodayHistoryAdapter(List<DayHistoryResponse> dateList){
        mDateList = dateList;
    }

    @Override
    public int getItemCount() {
        return mDateList.size();
    }

    public List<DayHistoryResponse> getmDateList() {
        return mDateList;

    }

    public void setmDateList(List<DayHistoryResponse> mDateList) {
        this.mDateList = mDateList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    }
}
