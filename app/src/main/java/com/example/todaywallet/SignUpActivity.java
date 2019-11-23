package com.example.todaywallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.todaywallet.databinding.SignupBinding;
import com.example.todaywallet.register.RegisterActivity;
import com.example.todaywallet.retrofit.client.ApiClient;
import com.example.todaywallet.retrofit.client.CustomCallback;
import com.example.todaywallet.retrofit.dto.request.SignUpRequest;
import com.example.todaywallet.retrofit.dto.response.SignInResponse;
import com.example.todaywallet.retrofit.dto.response.SignUpResponse;
import com.example.todaywallet.utils.Alert;
import com.example.todaywallet.utils.SimpleCallbackUtil;

import retrofit2.Call;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity{


    SignupBinding signupBinding;
    EditText tvEmail;
    EditText tvPw;
    EditText tvCheckPw;
    EditText tvName;
    EditText tvPhone;

    Button btnSignUp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signupBinding = DataBindingUtil.setContentView(this, R.layout.signup);
        setContentView(R.layout.signup);
        tvEmail = signupBinding.editTextSignUpEmail;
        tvPw = signupBinding.editTextSignUpPw;
        tvCheckPw = signupBinding.editTextSignUpRePw;
        tvName  = signupBinding.editTextSignUpNickName;
        tvPhone  = signupBinding.editTextSignUpPhone;
        btnSignUp =signupBinding.btnSignUp;
        //btnSignUp.setOnClickListener(this);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUpRequest signUpRequest = new SignUpRequest();

                signUpRequest.setEmail(tvEmail.getText().toString());
                signUpRequest.setPw(tvPw.getText().toString());
                signUpRequest.setPhone(tvPhone.getText().toString());
                signUpRequest.setName(tvName.getText().toString());
                Log.i("tvE",tvEmail.getText().toString());
                Log.i("tvE",tvPw.getText().toString());
                Log.i("tvE",tvPhone.getText().toString());
                Log.i("tvE",tvName.getText().toString());

                ApiClient.getInstance().getAuthService()
                        .userSignUp(signUpRequest)
                        .enqueue(new CustomCallback<SignUpResponse>() {
                            @Override
                            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                                SignUpResponse signUpResponse = response.body();
                                Log.i("signup",signUpResponse.getStatus()+"");
                                if(signUpResponse.getSuccess()!=true){
                                    Log.i("ts","회원가입 실패");
                                }else{
                                    finish();
                                }
                            }

                        });

                }});
            }


}


