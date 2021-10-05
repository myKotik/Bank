package com.example.bank;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class DialogFragmentClass extends androidx.fragment.app.DialogFragment {

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.MyDialog);
        builder.setView(R.layout.login);
        builder.setTitle("Авторизация");
        builder.setMessage("Введите ваш логин и пароль");
        builder.setNegativeButton("Отмена", null);
        builder.setPositiveButton("Добавить", (dialogInterface, i) -> {

        });

        return builder.create();
    }


}
