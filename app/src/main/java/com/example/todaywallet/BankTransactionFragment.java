package com.example.todaywallet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaywallet.adapter.TodayHistoryAdapter;
import com.example.todaywallet.databinding.FragmentBankBookTransactionBinding;
import com.example.todaywallet.retrofit.client.ApiClient;
import com.example.todaywallet.retrofit.client.CustomCallback;
import com.example.todaywallet.retrofit.dto.response.DayHistoryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class BankTransactionFragment extends Fragment {
    FragmentBankBookTransactionBinding fragmentBankBookTransactionBinding;
    RecyclerView recyclerView;
    TodayHistoryAdapter todayHistoryAdapter;
    List<DayHistoryResponse.Data> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentBankBookTransactionBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_bank_book_transaction,container,false);
        recyclerView = fragmentBankBookTransactionBinding.rcyBankTransaction;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ApiClient.getInstance().getAuthService()
                .getDayHistory(8)
                .enqueue(new CustomCallback<DayHistoryResponse>() {
                    @Override
                    public void onResponse(Call<DayHistoryResponse> call, Response<DayHistoryResponse> response) {
                        list = response.body().getData();
                        todayHistoryAdapter = new TodayHistoryAdapter(list);
                        recyclerView.setAdapter(todayHistoryAdapter);
                        todayHistoryAdapter.setmDateList(list);

                    }

                });



        return fragmentBankBookTransactionBinding.getRoot();


    }
}
