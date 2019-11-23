package com.example.todaywallet.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.todaywallet.R;
import com.example.todaywallet.databinding.DialogUnlockTestBinding;

public class BearDialog extends Activity {

    DialogUnlockTestBinding dialogUnlockTestBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams  layoutParams = new WindowManager.LayoutParams();

        dialogUnlockTestBinding = DataBindingUtil.setContentView(this, R.layout.dialog_unlock_test);
    }
}
