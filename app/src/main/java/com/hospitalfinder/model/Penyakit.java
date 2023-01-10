package com.hospitalfinder.model;

public class Penyakit {
    private String Nama;

    public Penyakit() {}

    public Penyakit(String nama) {
        this.Nama = nama;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }
}
