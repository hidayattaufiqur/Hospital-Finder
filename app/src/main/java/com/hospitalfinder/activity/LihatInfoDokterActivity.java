package com.hospitalfinder.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hospitalfinder.R;
import com.hospitalfinder.adapter.AdapterDokter;
import com.hospitalfinder.adapter.AdapterRS;
import com.hospitalfinder.model.Dokter;

import java.util.ArrayList;

public class LihatInfoDokterActivity extends AppCompatActivity {
    private ListView lv;
    private ArrayList<Dokter> arrayList;
    private AdapterDokter adapter;
    private FirebaseDatabase fbDatabase;
    private DatabaseReference reference;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_info_dokter);

        fbDatabase = FirebaseDatabase.getInstance();
        reference = fbDatabase.getReference();
        arrayList = new ArrayList<Dokter>();

        lv = findViewById(R.id.list_dokter);
        searchView = findViewById(R.id.searchView);
        adapter = new AdapterDokter(LihatInfoDokterActivity.this, R.layout.items_dokter, arrayList);

        reference.child("Dokter").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();

                for (DataSnapshot ds : snapshot.getChildren()) {
                    String Nama = ds.child("Nama").getValue(String.class);
                    Log.d("HEY", (String) Nama);

                    String Spesialis = ds.child("Spesialis").getValue(String.class);
                    String Jadwal = ds.child("Jadwal").getValue(String.class);
                    String Lokasi = ds.child("Lokasi").getValue(String.class);
                    double Tarif = ds.child("Tarif").getValue(Double.class);


                    arrayList.add(new Dokter(Nama, Spesialis, Jadwal, Lokasi, Tarif));
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Dokter> filteredDokter = new ArrayList<>();

                for (Dokter dk : arrayList) {
                    if (dk.getNama().toLowerCase().contains(newText.toLowerCase())) {
                        filteredDokter.add(dk);
                    }
                }

                adapter = new AdapterDokter(LihatInfoDokterActivity.this, R.layout.items_dokter, filteredDokter);

                lv.setAdapter(adapter);

                return false;
            }

        });

        lv.setAdapter(adapter);
    }
}