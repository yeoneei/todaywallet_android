package com.example.todaywallet.retrofit.dto.response;

import com.google.gson.annotations.SerializedName;

public class SixMonthResponse {

    String nxtQyKey;

    public String getNxtQyKey() {
        return nxtQyKey;
    }

    public void setNxtQyKey(String nxtQyKey) {
        this.nxtQyKey = nxtQyKey;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    @SerializedName("group")
    Group[] groups;

    public class Group{
        String setlTypeNo;
        String setIDay;
        String bankno;
        String accno;
        String billAmt;
        String aowDuD;

        public String getSetlTypeNo() {
            return setlTypeNo;
        }

        public void setSetlTypeNo(String setlTypeNo) {
            this.setlTypeNo = setlTypeNo;
        }

        public String getSetIDay() {
            return setIDay;
        }

        public void setSetIDay(String setIDay) {
            this.setIDay = setIDay;
        }

        public String getBankno() {
            return bankno;
        }

        public void setBankno(String bankno) {
            this.bankno = bankno;
        }

        public String getAccno() {
            return accno;
        }

        public void setAccno(String accno) {
            this.accno = accno;
        }

        public String getBillAmt() {
            return billAmt;
        }

        public void setBillAmt(String billAmt) {
            this.billAmt = billAmt;
        }

        public String getAowDuD() {
            return aowDuD;
        }

        public void setAowDuD(String aowDuD) {
            this.aowDuD = aowDuD;
        }
    }


}
