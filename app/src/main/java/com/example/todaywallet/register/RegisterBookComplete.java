package com.example.todaywallet.register;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.todaywallet.MainActivity;
import com.example.todaywallet.R;
import com.example.todaywallet.databinding.ActivityRegisterbankbook2Binding;
import com.example.todaywallet.retrofit.client.ApiClient;
import com.example.todaywallet.retrofit.client.CustomCallback;
import com.example.todaywallet.retrofit.dto.request.WonAuthRequest;
import com.example.todaywallet.retrofit.dto.response.WonAuth;

import retrofit2.Call;
import retrofit2.Response;

public class RegisterBookComplete extends AppCompatActivity {

    ActivityRegisterbankbook2Binding activityRegisterbankbook2Binding;
    EditText bankNumber;
    Button btnNext;
    Button btnCheck;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerbankbook2);
        activityRegisterbankbook2Binding = DataBindingUtil.setContentView(this,R.layout.activity_registerbankbook2);
        Intent intent = getIntent();
        String bankNum = intent.getStringExtra("bank");

        btnNext = activityRegisterbankbook2Binding.btnRegister2Next;
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterBookComplete.this, MainActivity.class));
                finish();
            }
        });
        bankNumber = activityRegisterbankbook2Binding.editTextRegister2BankNumber;
        bankNumber.setBackgroundResource(R.drawable.roundblue);
        bankNumber.setText(bankNum);
        bankNumber.setTextColor(Color.BLUE);
        bankNumber.setEnabled(false);

        btnCheck = activityRegisterbankbook2Binding.btnRegister2CheckBankNumber;
        btnCheck.setVisibility(View.INVISIBLE);
    }
}
