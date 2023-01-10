package com.hospitalfinder.model;

import java.util.ArrayList;

public class Rumah_Sakit {
    private String NamaRS, Alamat, Deskripsi, Website;
    private ArrayList<String> FasilitasMedis, FasilitasUmum;

    public Rumah_Sakit() {}

    public Rumah_Sakit(String Nama, String Alamat, String Deskripsi, ArrayList<String> FasMedis, ArrayList<String> FasUmum, String Website) {
        this.NamaRS = Nama;
        this.Alamat = Alamat;
        this.Deskripsi = Deskripsi;
        this.FasilitasMedis = FasMedis;
        this.FasilitasUmum = FasUmum;
        this.Website = Website;
    }

    public String getNamaRS() {
        return NamaRS;
    }

    public void setNamaRS(String namaRS) {
        NamaRS = namaRS;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        Deskripsi = deskripsi;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public ArrayList<String> getFasilitasMedis() {
        return FasilitasMedis;
    }

    public void setFasilitasMedis(ArrayList<String> fasilitasMedis) {
        FasilitasMedis = fasilitasMedis;
    }

    public ArrayList<String> getFasilitasUmum() {
        return FasilitasUmum;
    }

    public void setFasilitasUmum(ArrayList<String> fasilitasUmum) {
        FasilitasUmum = fasilitasUmum;
    }
}
