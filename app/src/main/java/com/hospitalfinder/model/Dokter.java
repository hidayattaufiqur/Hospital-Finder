package com.hospitalfinder.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Dokter {
    private int DokterID;
    private String Nama, Spesialis, Jadwal, Lokasi;
    private double Tarif;

    public Dokter() {}

    public Dokter(String Nama, String Spesialis, String Jadwal, String Lokasi, double Tarif) {
        this.Nama = Nama;
        this.Spesialis = Spesialis;
        this.Jadwal = Jadwal;
        this.Tarif = Tarif;
        this.Lokasi = Lokasi;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getSpesialis() {
        return Spesialis;
    }

    public void setSpesialis(String spesialis) {
        Spesialis = spesialis;
    }

    public String getJadwal() {
        return Jadwal;
    }

    public void setJadwal(String jadwal) {
        Jadwal = jadwal;
    }

    public String getLokasi() {
        return Lokasi;
    }

    public void setLokasi(String lokasi) {
        Lokasi = lokasi;
    }

    public double getTarif() {
        return Tarif;
    }

    public void setTarif(double tarif) {
        Tarif = tarif;
    }

}
