package com.example.todaywallet.viewholder;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaywallet.R;
import com.example.todaywallet.retrofit.dto.response.DayHistoryResponse;

import org.w3c.dom.Text;

public class TodayHistoryViewHolder extends RecyclerView.ViewHolder {
    TextView date;
    TextView name;
    TextView price1;

    TextView price2;
    TextView allPrice;
    int in;

    public TodayHistoryViewHolder(@NonNull final View itemView,int in){
        super(itemView);
        initView(itemView);
        this.in = in;
    }

    public void initView(View v){
        date = (TextView)v.findViewById(R.id.item_bank_history_time);
        name = (TextView)v.findViewById(R.id.item_bank_history_name);
        price1 = (TextView)v.findViewById(R.id.item_bank_history_price1);
        price2 = (TextView)v.findViewById(R.id.item_bank_history_price2);
        allPrice = (TextView)v.findViewById(R.id.item_bank_history_all_price);

    }

    public void bind(DayHistoryResponse.Data dayHistoryResponse) {
        date.setText("2019/11/" + dayHistoryResponse.getDate() + " " + dayHistoryResponse.getTime());
        name.setText(dayHistoryResponse.getName()+"");
        price2.setText(dayHistoryResponse.getPrice()+"");
        if (in == 0) {
            price1.setTextColor(Color.RED);
            price2.setTextColor(Color.RED);
        }
        if (in == 1) {
            price1.setTextColor(Color.BLUE);
            price2.setTextColor(Color.BLUE);
            price1.setText("입금");
        }
        allPrice.setText(dayHistoryResponse.getAnother()+"");
    }

}
