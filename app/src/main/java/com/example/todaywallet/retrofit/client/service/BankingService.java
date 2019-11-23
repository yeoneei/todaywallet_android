package com.example.todaywallet.retrofit.client.service;


import com.example.todaywallet.retrofit.dto.request.WonAuthRequest;
import com.example.todaywallet.retrofit.dto.response.WonAuthResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface BankingService {

    @Headers({
            "Content-Type:application/json;charset=UTF-8"
    })

    @POST("/v1/auth/1wontransfer")
    Call<WonAuthResponse> wonAuth(@Body WonAuthRequest wonAuthRequest);
}
