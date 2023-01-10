package com.hospitalfinder.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.hospitalfinder.R;

public class MainMenuActivity extends AppCompatActivity {
//ImageView imageView;
private ImageView cariRsBtn, lihatInfoDokter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cariRsBtn = findViewById(R.id.cari_rs_button);
        cariRsBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainMenuActivity.this, CariRSActivity.class));
            }
        });

        lihatInfoDokter = findViewById(R.id.lht_info_dokt_button);
        lihatInfoDokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainMenuActivity.this, LihatInfoDokterActivity.class));
            }
        });
    }
}