package com.example.todaywallet.register;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.todaywallet.LoginActivity;
import com.example.todaywallet.MainActivity;
import com.example.todaywallet.R;
import com.example.todaywallet.databinding.ActivityRegisterbankbook2Binding;
import com.example.todaywallet.retrofit.client.ApiClient;
import com.example.todaywallet.retrofit.client.BankClient;
import com.example.todaywallet.retrofit.client.CustomCallback;
import com.example.todaywallet.retrofit.dto.request.WonAuthRequest;
import com.example.todaywallet.retrofit.dto.response.SignInResponse;
import com.example.todaywallet.retrofit.dto.response.WonAuth;
import com.example.todaywallet.retrofit.dto.response.WonAuthResponse;

import java.text.SimpleDateFormat;

import retrofit2.Call;
import retrofit2.Response;

public class RegisterBookActivity extends AppCompatActivity {

    ActivityRegisterbankbook2Binding activityRegisterbankbook2Binding;
    EditText bankNumber;
    Button btnNext;
    Button btnCheck;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerbankbook2);
        activityRegisterbankbook2Binding = DataBindingUtil.setContentView(this,R.layout.activity_registerbankbook2);
        btnNext = activityRegisterbankbook2Binding.btnRegister2Next;
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterBookActivity.this, MainActivity.class));
                finish();
            }
        });
        bankNumber = activityRegisterbankbook2Binding.editTextRegister2BankNumber;

        btnCheck = activityRegisterbankbook2Binding.btnRegister2CheckBankNumber;
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WonAuthRequest wonAuthRequest = new WonAuthRequest();

                wonAuthRequest.setServiceCode("D2073");
                wonAuthRequest.setBankCode("035");
                wonAuthRequest.setBank("5602019741");
                wonAuthRequest.setTime("20190905175031");
                wonAuthRequest.setAppCode("040001");
                wonAuthRequest.setMangmentNumber("128307200");
                wonAuthRequest.setPrice("1");

                ApiClient.getInstance().getAuthService()
                        .getWonAuth()
                        .enqueue(new CustomCallback<WonAuth>() {
                            @Override
                            public void onResponse(Call<WonAuth> call, Response<WonAuth> response) {
                               WonAuth wonAuth = response.body();
                               Intent intent = new Intent(getApplicationContext(), RegisterBookWon.class);
                               intent.putExtra("number",wonAuth.getData().getResult());
                               intent.putExtra("bank",bankNumber.getText().toString());
                               startActivity(intent);
                               finish();


                            }


                        });




                /*
                Intent intent = new Intent(RegisterBookActivity.this,RegisterBookWon.class);
                intent.putExtra("bankNumber",bankNumber.getText().toString());
                startActivity(intent);

                finish();

                 */
            }
        });
    }
}
