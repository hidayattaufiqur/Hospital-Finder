package com.hospitalfinder.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.badge.BadgeUtils;
import com.hospitalfinder.R;
import com.hospitalfinder.adapter.AdapterPenyakit;
import com.hospitalfinder.model.Penyakit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class InputPenyakitActivity extends AppCompatActivity {
    ListView listView;
    private ImageView searchBtn;
    private ArrayList<Penyakit> lstPenyakit = new ArrayList<>();
    private EditText editTextPenyakit;
    private Button btnAddPenyakit;
    private AdapterPenyakit adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_penyakit);

        listView = findViewById(R.id.list_penyakit);
        editTextPenyakit = findViewById(R.id.editText_penyakit);
        btnAddPenyakit = findViewById(R.id.btn_add_penyakit);
        searchBtn = findViewById(R.id.search_button);

        adapter = new AdapterPenyakit(InputPenyakitActivity.this, R.layout.items_penyakit, lstPenyakit);

        btnAddPenyakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaPenyakit = editTextPenyakit.getText().toString();

                lstPenyakit.add(new Penyakit(namaPenyakit));
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                editTextPenyakit.setText("");
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (lstPenyakit.isEmpty()) {
                    editTextPenyakit.setError("Masukkan penyakit...");
                } else {
                    startActivity(new Intent(InputPenyakitActivity.this, RekomendasiRSActivity.class));
                }
            }
        });

    }

}