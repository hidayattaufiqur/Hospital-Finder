package com.hospitalfinder.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hospitalfinder.R;
import com.hospitalfinder.model.Rumah_Sakit;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterRS extends ArrayAdapter<Rumah_Sakit> {

    private Context mContext;
    private int mResource;

    public AdapterRS(@NonNull Context context, int resource, @NonNull ArrayList<Rumah_Sakit> objects) {
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

        TextView namaRS = (TextView) view.findViewById(R.id.text_rekomendasi_rs);
//        TextView website = (TextView) view.findViewById(R.id.website);
//        TextView desc = (TextView) view.findViewById(R.id.desc_rs);

        namaRS.setText(getItem(position).getNamaRS());
//        website.setText(getItem(position).getWebsite());
//        desc.setText(getItem(position).getDeskripsi());

        return view;
    }
}
