package com.example.todaywallet.calendar;

import java.util.Calendar;

public class Day {
    String day;

    public Day() {
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    // TODO : day에 달력일값넣기
    public void setCalendar(int day){
        this.day = String.valueOf(day);
    }
}
