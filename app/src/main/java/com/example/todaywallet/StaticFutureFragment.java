package com.example.todaywallet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.todaywallet.databinding.FragmentFutureStaticBinding;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class StaticFutureFragment extends Fragment {
    FragmentFutureStaticBinding fragmentFutureStaticBinding;
    ViewFlipper viewFlipper;
    int images[] = {
            R.drawable.add1,
            R.drawable.add2,
            R.drawable.add3,
    };
    BarChart chart;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentFutureStaticBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_future_static,container,false);
        /*viewFlipper = fragmentFutureStaticBinding.vfFutureStaticAd;

        for(int imge : images) {
            fllipperImages(imge);
        }

        chart = fragmentFutureStaticBinding.barChart;

        ArrayList NoOfEmp = new ArrayList();

        NoOfEmp.add(new BarEntry(0f, 0));
        NoOfEmp.add(new BarEntry(1f, 1));
        NoOfEmp.add(new BarEntry(2f, 2));
        NoOfEmp.add(new BarEntry(3f, 3));
        NoOfEmp.add(new BarEntry(4f, 4));

        ArrayList year = new ArrayList();

        year.add("식비");
        year.add("영화");
        year.add("옷");
        year.add("택시비");
        year.add("화장품");
        year.add("담배");
        year.add("기타");

        BarDataSet bardataset = new BarDataSet(NoOfEmp, "No Of Employee");
        chart.animateY(4000);
        BarData data = new BarData(bardataset);
        bardataset.setBarBorderWidth(1f);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);

        chart.setData(data);

         */




        return fragmentFutureStaticBinding.getRoot();
    }


    public void fllipperImages(int image){
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);      // 이미지 추가
        viewFlipper.setFlipInterval(4000);       // 자동 이미지 슬라이드 딜레이시간(1000 당 1초)
        viewFlipper.setAutoStart(true);          // 자동 시작 유무 설정

        viewFlipper.setInAnimation(getContext(),android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(getContext(),android.R.anim.slide_out_right);
    }

}
