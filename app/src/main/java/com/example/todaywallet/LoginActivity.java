package com.example.todaywallet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.todaywallet.databinding.SigninBinding;
import com.example.todaywallet.register.RegisterActivity;
import com.example.todaywallet.retrofit.client.ApiClient;
import com.example.todaywallet.retrofit.client.CustomCallback;
import com.example.todaywallet.retrofit.dto.request.SignInRequest;
import com.example.todaywallet.retrofit.dto.response.SignInResponse;
import com.example.todaywallet.retrofit.messege.ApiMessasge;
import com.example.todaywallet.utils.SimpleCallbackUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    SigninBinding signinBinding;
    LinearLayout linearLayout;
    Button login;
    EditText editId;
    EditText editPw;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        signinBinding = DataBindingUtil.setContentView(this,R.layout.signin);
        linearLayout = signinBinding.linearGoToSingUp;
        editId = signinBinding.editTextSignInEmail;
        editPw = signinBinding.editTextSignInPw;
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        login = signinBinding.btnLogIn;
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SignInRequest signInRequest = new SignInRequest();
                String FAIL = "비밀번호가 틀렸습니다.";
                signInRequest.setEmail(editId.getText().toString());
                signInRequest.setPwo(editPw.getText().toString());
                ApiClient.getInstance().getAuthService()
                        .userSignIn(signInRequest)
                        .enqueue(new CustomCallback<SignInResponse>() {
                            @Override
                            public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {
                                SignInResponse signInResponse = response.body();
                                if(signInResponse.getMessage()!=null){

                                }else{
                                    startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                                }
                            }

                        });

            }
        });


    }
}
