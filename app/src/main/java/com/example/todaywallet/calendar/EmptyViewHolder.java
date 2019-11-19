package com.example.todaywallet.calendar;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

class EmptyViewHolder extends RecyclerView.ViewHolder {


    public EmptyViewHolder(@NonNull View itemView) {
        super(itemView);

        initView(itemView);
    }

    public void initView(View v) {

    }

    public void bind(ViewModel model) {


    }

}