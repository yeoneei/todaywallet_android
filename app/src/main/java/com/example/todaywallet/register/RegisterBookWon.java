package com.example.todaywallet.register;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.todaywallet.R;
import com.example.todaywallet.databinding.ActivityRegister1wonBinding;

public class RegisterBookWon extends AppCompatActivity {
    ActivityRegister1wonBinding activityRegister1wonBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRegister1wonBinding = DataBindingUtil.setContentView(this, R.layout.activity_register_1won);
    }
}
