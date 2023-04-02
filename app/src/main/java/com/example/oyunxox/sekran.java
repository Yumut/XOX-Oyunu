package com.example.oyunxox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class sekran extends Dialog {
    private final String mesaj;

    private final MainActivity main;

    public sekran(@NonNull Context context, String mesaj,MainActivity main) {
        super(context);
        this.mesaj=mesaj;
        this.main=main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sekran);


        TextView sonuctext = findViewById(R.id.sonuctext);
        Button tekrarbutton = findViewById(R.id.tekrarbutton);

        sonuctext.setText(mesaj);

        tekrarbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.YenidenOyna();
                dismiss();
            }
        });
    }

}