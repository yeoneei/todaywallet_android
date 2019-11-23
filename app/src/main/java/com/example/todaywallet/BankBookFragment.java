package com.example.todaywallet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.todaywallet.databinding.FragmentBankBookBinding;

public class BankBookFragment extends Fragment {
    FragmentBankBookBinding fragmentBankBookBinding;
    TextView textView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentBankBookBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_bank_book,container,false);
        textView = fragmentBankBookBinding.btnShowTransaction;
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BankTransactionFragment bankTransactionFragment = new BankTransactionFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container,bankTransactionFragment).commitAllowingStateLoss();
            }
        });


        return fragmentBankBookBinding.getRoot();
    }
}
