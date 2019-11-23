package com.example.todaywallet.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.todaywallet.R;
import com.example.todaywallet.databinding.ActivityRegisterbankbookBinding;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterbankbookBinding activityRegisterbankbookBinding;
    TextView tvNext;
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_registerbankbook);

        activityRegisterbankbookBinding = DataBindingUtil.setContentView(this,R.layout.activity_registerbankbook);
        tvNext = activityRegisterbankbookBinding.btnRegister1Next;
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,RegisterBookActivity.class));
                finish();
            }
        });

    }
}
