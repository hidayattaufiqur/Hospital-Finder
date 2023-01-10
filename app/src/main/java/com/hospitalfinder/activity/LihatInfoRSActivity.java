package com.hospitalfinder.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.hospitalfinder.R;

public class LihatInfoRSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_info_rsactivity);

        ImageView imageView, imageView1;
        imageView = findViewById(R.id.list_dokter_button);
        imageView1 = findViewById(R.id.rute_terdekat_button);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LihatInfoRSActivity.this, LihatInfoDokterActivity.class));
            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LihatInfoRSActivity.this, MapsActivity.class));
            }
        });
    }
}