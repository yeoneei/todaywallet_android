package com.example.todaywallet.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.DialogFragment;

import com.example.todaywallet.R;

public class PigDialog extends DialogFragment implements View.OnClickListener{
    private static final String TAG = "CustomDialogFragment";
    private static final String ARG_DIALOG_MAIN_MSG = "dialog_main_msg";
    private String mMainMsg;
    public static PigDialog newInstance(String mainMsg) {
        Bundle bundle = new Bundle();
        bundle.putString(ARG_DIALOG_MAIN_MSG, mainMsg);
        PigDialog fragment = new PigDialog();
        fragment.setArguments(bundle);
        return fragment;    }

    @Override    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        if (getArguments() != null) {
            mMainMsg = getArguments().getString(ARG_DIALOG_MAIN_MSG);        }
    }

    @Override    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_set_day_money, null);
        //((TextView)view.findViewById(R.id.dialog_confirm_msg)).setText(mMainMsg);
        //view.findViewById(R.id.dialog_confirm_btn).setOnClickListener(this);
        builder.setView(view);
        return builder.create();    }

    private void dismissDialog() {
        this.dismiss();    }

    @Override    public void onClick(View v) {
/*
        switch (v.getId()) {
            case R.id.dialog_confirm_btn:
                dismissDialog();                break;        }

 */
    }
}
