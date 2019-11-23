package com.example.todaywallet.retrofit.client.service;

import com.example.todaywallet.retrofit.dto.request.MonthRequest;
import com.example.todaywallet.retrofit.dto.request.SixMonthRequest;
import com.example.todaywallet.retrofit.dto.response.MonthResponse;
import com.example.todaywallet.retrofit.dto.response.SixMonthResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CardService {

    @POST("/v1/usecreditcard/searchmonthlybillingfor6months")
    Call<SixMonthResponse> getSixMonthCard(@Body SixMonthRequest sixMonthRequest);

    @POST("/v1/usecreditcard/searchmonthlybillingdetail")
    Call<MonthResponse> getMonthResponse(@Body MonthRequest monthRequesth);




}
