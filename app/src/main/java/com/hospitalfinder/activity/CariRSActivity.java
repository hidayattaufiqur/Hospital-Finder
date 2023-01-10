package com.hospitalfinder.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.hospitalfinder.R;

public class CariRSActivity extends AppCompatActivity{
    private ImageView CariRSTerdekatBtn, RekomendasiRSBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_rsactivity);

        CariRSTerdekatBtn = findViewById(R.id.cari_rs_terdekat_button);
        CariRSTerdekatBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(CariRSActivity.this, CariRSTerdekatActivity.class));
            }
        });

        RekomendasiRSBtn = findViewById(R.id.rekomendasi_rs_button);
        RekomendasiRSBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(CariRSActivity.this, InputPenyakitActivity.class));
            }
        });

    }
}

