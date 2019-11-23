package com.example.todaywallet.retrofit.dto.response;

import com.google.gson.annotations.SerializedName;

public class WonAuthResponse {
    String result;
    int status;
    Boolean success;
    Object data;
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
