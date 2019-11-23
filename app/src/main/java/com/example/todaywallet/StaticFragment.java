package com.example.todaywallet;



import android.graphics.Color;
import android.icu.text.AlphabeticIndex;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.todaywallet.R;
import com.example.todaywallet.databinding.FragmentStaticBinding;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class StaticFragment extends Fragment {
    FragmentStaticBinding fragmentStaticBinding;
    PieChart pieChart;


    Button btnLeft;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentStaticBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_static,container,false);

        pieChart = fragmentStaticBinding.pieChart;
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);
        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(Color.BLACK);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();

        yValues.add(new PieEntry(23f,"Japen"));
        yValues.add(new PieEntry(18f,"USA"));
        yValues.add(new PieEntry(9f,"UK"));
        yValues.add(new PieEntry(15f,"India"));
        yValues.add(new PieEntry(5f,"Russia"));
        yValues.add(new PieEntry(30f,"Korea"));


        pieChart.animateY(1000, Easing.EaseInOutCubic);
        PieDataSet dataSet = new PieDataSet(yValues,"Countries");

        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(12f);
        int [] color = {Color.parseColor("#FD6381"),Color.parseColor("#FAF57D"),
            Color.parseColor("#C9F8A7"),Color.parseColor("#F4F3F3"),Color.parseColor("#BCE0FD")
            , Color.parseColor("#A1C3F2")};

        dataSet.setColors(ColorTemplate.createColors(color));


        PieData data = new PieData((dataSet));
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.YELLOW);
        pieChart.setData(data);
        pieChart.getLegend().setEnabled(false);




        btnLeft = fragmentStaticBinding.btnStaticLeft;
        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StaticFutureFragment staticFutureFragment = new StaticFutureFragment();
                FragmentManager fragmentManager = ((AppCompatActivity)getContext()).getSupportFragmentManager();
                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container,staticFutureFragment).commitAllowingStateLoss();
            }
        });
        return fragmentStaticBinding.getRoot();
    }




}

