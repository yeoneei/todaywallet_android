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

import com.example.todaywallet.R;
import com.example.todaywallet.databinding.ActivityRegister1wonBinding;

public class RegisterBookWon extends AppCompatActivity {
    ActivityRegister1wonBinding activityRegister1wonBinding;
    String bankNumber;
    String number;
    Button btnCheck;

    EditText e1,e2,e3,e4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRegister1wonBinding = DataBindingUtil.setContentView(this, R.layout.activity_register_1won);
        Intent intent = getIntent();
        bankNumber = intent.getStringExtra("bank");
        number = intent.getStringExtra("number");
        Log.i("bank",bankNumber);
        btnCheck = activityRegister1wonBinding.btnWonAuthNext;
        e1 = activityRegister1wonBinding.editAuth1;
        e2 = activityRegister1wonBinding.editAuth2;
        e3 = activityRegister1wonBinding.editAuth3;
        e4 = activityRegister1wonBinding.editAuth4;
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String complete = e1.getText().toString()+e2.getText().toString()+e3.getText().toString()+e4.getText().toString();
                Log.i("bank",complete);
                String a ="";
                for(int i=2; i<number.length();i++){
                    a+=number.charAt(i);
                }
                Log.i("char",a);
                if(complete.equals(a)){
                    Intent intent = new Intent(getApplicationContext(),RegisterBookComplete.class);
                    intent.putExtra("bank",bankNumber);
                    startActivity(intent);
                    finish();
                }



            }
        });



    }
}
