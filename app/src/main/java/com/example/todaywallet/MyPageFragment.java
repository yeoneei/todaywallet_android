package com.example.todaywallet;



import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.todaywallet.R;
import com.example.todaywallet.databinding.FragmentMypageBinding;

public class MyPageFragment extends Fragment {

    FragmentMypageBinding fragmentMypageBinding;
    BankBookFragment bankBookFragment;
    ImageView btnBankNext;
    ImageView btnBankCalendarSetting;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentMypageBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_mypage,container,false);
        btnBankNext = fragmentMypageBinding.imgMypageBankNext;
        btnBankCalendarSetting = fragmentMypageBinding.imgMypageCalendarSetting;

        btnBankNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bankBookFragment = new BankBookFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container,bankBookFragment).commitAllowingStateLoss();

            }
        });

        btnBankCalendarSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),CalendarSettingActivity.class);
                startActivity(intent);
            }
        });
        return fragmentMypageBinding.getRoot();
    }




}
