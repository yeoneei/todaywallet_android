package com.example.todaywallet.retrofit.dto.request;

import com.google.gson.annotations.SerializedName;

public class WonAuthRequest{

    @SerializedName(value="공통부")
    String common;

    @SerializedName(value="고객구분")
    String client;

    @SerializedName(value="주민번호")
    String idNumber;

    @SerializedName(value="고객번호")
    String custumerNumber;

    @SerializedName(value = "관계구분")
    String relation;

    String FILLER;

    @SerializedName(value = "보험사코드")
    String code;

    @SerializedName(value = "증권번호")
    String stok;

    @SerializedName(value = "초과여부")
    String over;

    @SerializedName(value = "필러")
    String fl;
}

