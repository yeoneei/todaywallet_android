package com.example.todaywallet.retrofit.client.service;

import com.example.todaywallet.retrofit.dto.request.SignInRequest;
import com.example.todaywallet.retrofit.dto.request.SignUpRequest;
import com.example.todaywallet.retrofit.dto.response.SignInResponse;
import com.example.todaywallet.retrofit.dto.response.SignUpResponse;
import com.example.todaywallet.retrofit.messege.ApiMessasge;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {


    /**
     * 회원가입
     * [회원가입 페이지]
     *
     * @param request 회원가입 정보
     * @return 성공 여부
     */
    @POST("auth/signup")
    Call<SignUpResponse> userSignUp(@Body SignUpRequest request);


    /**
     * 로그인
     * [토큰 없이]
     * @param request 로그인 정보
     * @return 성공 여부
     */
    @POST("auth/signin")
    Call<SignInResponse> userSignIn(@Body SignInRequest request);

}
