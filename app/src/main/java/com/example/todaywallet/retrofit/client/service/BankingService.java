package com.example.todaywallet.retrofit.client.service;

import com.example.todaywallet.retrofit.dto.request.WonAuthRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

interface BankingService {

    @Headers({
            "Accept:application/json, text/plain, */*",
            "Content-Type:application/json;charset=UTF-8"
    })

    @POST("/v1/account/bancassurance/detail")
    Call<WonAuthRequest> wonAuth(@Body WonAuthRequest wonAuthRequest);
}
