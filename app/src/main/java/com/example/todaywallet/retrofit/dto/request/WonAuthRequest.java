package com.example.todaywallet.retrofit.dto.request;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class WonAuthRequest{


        String serviceCode;

        @SerializedName("입금계좌번호")
        String bank;

        @SerializedName("기관전문전송시간")
        String time;

        @SerializedName("앱코드")
        String appCode;

        @SerializedName("입금은행코드")
        String bankCode;

        @SerializedName("기관전문관리번호")
        String mangmentNumber;

        @SerializedName("이체금액")
        String price;

        public String getServiceCode() {
            return serviceCode;
        }

        public void setServiceCode(String serviceCode) {
            this.serviceCode = serviceCode;
        }

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getAppCode() {
            return appCode;
        }

        public void setAppCode(String appCode) {
            this.appCode = appCode;
        }

        public String getBankCode() {
            return bankCode;
        }

        public void setBankCode(String bankCode) {
            this.bankCode = bankCode;
        }

        public String getMangmentNumber() {
            return mangmentNumber;
        }

        public void setMangmentNumber(String mangmentNumber) {
            this.mangmentNumber = mangmentNumber;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }


