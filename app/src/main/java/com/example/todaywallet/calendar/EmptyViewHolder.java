package com.example.todaywallet.calendar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaywallet.R;
import com.example.todaywallet.TodayCalendarFragment;

class EmptyViewHolder extends RecyclerView.ViewHolder {


    public EmptyViewHolder(@NonNull View itemView) {
        super(itemView);

        initView(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
    }

    public void initView(View v) {

    }

    public void bind(ViewModel model) {


    }

}