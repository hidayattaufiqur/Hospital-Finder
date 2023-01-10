package com.hospitalfinder.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hospitalfinder.R;
import com.hospitalfinder.adapter.AdapterRS;
import com.hospitalfinder.databinding.ActivityMainBinding;
import com.hospitalfinder.model.Rumah_Sakit;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RekomendasiRSActivity extends AppCompatActivity {
    private ListView lv;
    private ArrayList<Rumah_Sakit> arrayList;
    private AdapterRS adapter;
    private FirebaseDatabase fbDatabase;
    private DatabaseReference reference;
    private CardView cardView;

    ActivityMainBinding binding;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_rekomendasi__rsactivity);
//        setContentView(binding.getRoot());

        fbDatabase = FirebaseDatabase.getInstance();
        reference = fbDatabase.getReference();

        lv = findViewById(R.id.list_rekomendasi_rs);

        arrayList = new ArrayList<Rumah_Sakit>();

        adapter = new AdapterRS(RekomendasiRSActivity.this, R.layout.items_rekomendasi_rs, arrayList);

        reference.child("Rumah Sakit").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();

                for (DataSnapshot ds : snapshot.getChildren()) {
                    String namaRS = ds.child("NamaRS").getValue(String.class);
                    Log.d("HEY", (String) namaRS);

                    String alamat = ds.child("Alamat").getValue(String.class);
                    String desc = ds.child("Deskripsi").getValue(String.class);
                    String website = ds.child("Website").getValue(String.class);
                    ArrayList<String> fasUmum, fasMedis;
//
//                        Object fu = rumahSakit.child("Fasilitas").child("Umum").getValue(Object.class);
//                        Object fm = rumahSakit.child("Fasilitas").child("Medis").getValue(Object.class);
//
                    fasUmum = new ArrayList<String>();
                    fasUmum.add("Parkiran");

                    fasMedis = new ArrayList<String>();
                    fasMedis.add("IGD");
                    fasMedis.add("Radiologi");
                    fasMedis.add("Lab");

                    arrayList.add(new Rumah_Sakit(namaRS, alamat, desc, fasMedis, fasUmum, website));
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });

        lv.setAdapter(adapter);
//
//        cardView = findViewById(R.id.card_rekomendasi_rs);
//
//        cardView.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(RekomendasiRSActivity.this, LihatInfoRSActivity.class));
//            }
//        });
    }


}