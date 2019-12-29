package com.example.todaywallet.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaywallet.R;
import com.example.todaywallet.retrofit.dto.response.DayHistoryResponse;
import com.example.todaywallet.viewholder.TodayHistoryViewHolder;

import java.util.List;

public class TodayHistoryAdapter extends RecyclerView.Adapter {
    private int IN =1;
    private int NOTIN=0;

    private List<DayHistoryResponse.Data> mDateList;
    public TodayHistoryAdapter(List<DayHistoryResponse.Data> dateList){
        mDateList = dateList;
    }

    @Override
    public int getItemCount() {
        return mDateList.size();
    }

    public List<DayHistoryResponse.Data> getmDateList() {
        return mDateList;

    }

    public void setmDateList(List<DayHistoryResponse.Data> mDateList) {
        this.mDateList = mDateList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        DayHistoryResponse.Data item = this.mDateList.get(position);
        if(item.getIn()==0){
            return NOTIN;
        }else{
            return IN;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if(viewType==NOTIN) {
            return new TodayHistoryViewHolder(inflater.inflate(R.layout.item_bank_history, parent, false),NOTIN);
        }
        return new TodayHistoryViewHolder(inflater.inflate(R.layout.item_bank_history, parent, false),IN);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        DayHistoryResponse.Data item = mDateList.get(position);
        TodayHistoryViewHolder nholder = (TodayHistoryViewHolder)holder;
        ((TodayHistoryViewHolder) holder).bind(item);
    }
}
