package com.hospitalfinder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hospitalfinder.R;
import com.hospitalfinder.model.Penyakit;

import java.util.ArrayList;

public class AdapterPenyakit extends ArrayAdapter <Penyakit> {

    private Context mContext;
    private int mResource;

    public AdapterPenyakit(@NonNull Context context, int resource, @NonNull ArrayList<Penyakit> objects) {
        super(context, resource, objects);
        this.mResource = resource;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        }

        TextView nama = (TextView) view.findViewById(R.id.text_nama_dokter);

        nama.setText(getItem(position).getNama());

        return view;
    }


}
