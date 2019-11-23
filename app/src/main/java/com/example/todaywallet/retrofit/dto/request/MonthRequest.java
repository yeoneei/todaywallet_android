package com.example.todaywallet.retrofit.dto.request;

public class MonthRequest {
    String nxtQyKey;
    String setlDay;
    String setlTypeNo;

    public String getNxtQyKey() {
        return nxtQyKey;
    }

    public void setNxtQyKey(String nxtQyKey) {
        this.nxtQyKey = nxtQyKey;
    }

    public String getSetlDay() {
        return setlDay;
    }

    public void setSetlDay(String setlDay) {
        this.setlDay = setlDay;
    }

    public String getSetlTypeNo() {
        return setlTypeNo;
    }

    public void setSetlTypeNo(String setlTypeNo) {
        this.setlTypeNo = setlTypeNo;
    }
}
