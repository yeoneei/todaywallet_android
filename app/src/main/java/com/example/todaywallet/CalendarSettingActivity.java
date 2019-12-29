package com.example.todaywallet;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.todaywallet.databinding.ActivityCalendarSettingBinding;
import com.example.todaywallet.dialog.NumberPickerDialog;
import com.example.todaywallet.dialog.PigDialog;

public class CalendarSettingActivity extends AppCompatActivity {
    ActivityCalendarSettingBinding activityCalendarSettingBinding;
    RelativeLayout linearLayoutPig, time, day;
    TextView tvdaymoeny, tvday,tvtime;

    View dial;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_setting);
        activityCalendarSettingBinding = DataBindingUtil.setContentView(this,R.layout.activity_calendar_setting);
        tvdaymoeny = activityCalendarSettingBinding.txtMypageDayMoney;
        tvday = activityCalendarSettingBinding.tvCalendarSettingDay;
        tvtime = activityCalendarSettingBinding.tvCalendarSettingTime;
        linearLayoutPig = activityCalendarSettingBinding.linearCalednarSettingPig;
        linearLayoutPig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dial = (View) View.inflate(CalendarSettingActivity.this,R.layout.dialog_set_day_money,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(CalendarSettingActivity.this);
                dlg.setView(dial);

                dlg.setTitle("하루 생활비를 얼마로 설정할까요?");
                dlg.setIcon(R.drawable.ic_pig);
                final NumberPicker n = (NumberPicker)dial.findViewById(R.id.calendar_money_numberpicker);
                n.setMaxValue(100000);
                n.setMinValue(10000);
                n.setWrapSelectorWheel(false);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvday.setText(n.getValue()+"");
                    }
                });
                //n.setOnValueChangedListener(this);
                dlg.show();
            }
        });

        day = activityCalendarSettingBinding.linearCalednarSettingDay;
        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dial = (View) View.inflate(CalendarSettingActivity.this,R.layout.dialog_set_day,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(CalendarSettingActivity.this);
                dlg.setView(dial);

                dlg.setTitle("인출 날짜를 언제로 설정할까요?");
                dlg.setIcon(R.drawable.ic_calendar);
                final NumberPicker n = (NumberPicker)dial.findViewById(R.id.calendar_day_numberpicker);
                n.setMaxValue(31);
                n.setMinValue(1);
                n.setWrapSelectorWheel(false);
                dlg.setPositiveButton("확인",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                        int day = n.getValue();
                        tvdaymoeny.setText(day+"");
                    }
                });


                dlg.show();
            }
        });

        time = activityCalendarSettingBinding.linearCalednarSettingTime;
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                dial = (View) View.inflate(CalendarSettingActivity.this,R.layout.dialog_set_time,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(CalendarSettingActivity.this);
                dlg.setView(dial);

                dlg.setTitle("인출 날짜를 언제로 설정할까요?");
                dlg.setIcon(R.drawable.ic_calendar);
                final TimePicker t = (TimePicker) dial.findViewById(R.id.calendar_day_time_picker);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                //n.setOnValueChangedListener(this);
                dlg.show();
            }

        });




    }

}
