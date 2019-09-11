package com.example.managemahasiswa;

import android.os.Parcel;
import android.os.Parcelable;

public class Mahasiswa implements Parcelable {
    int id_mahasiswa;
    String nama;
    String tanggal;
    String kelamin;
    String alamat;

    public int getId_mahasiswa() {
        return id_mahasiswa;
    }

    public void setId_mahasiswa(int id_mahasiswa) {
        this.id_mahasiswa = id_mahasiswa;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKelamin() {
        return kelamin;
    }

    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id_mahasiswa);
        dest.writeString(this.nama);
        dest.writeString(this.tanggal);
        dest.writeString(this.kelamin);
        dest.writeString(this.alamat);
    }

    public Mahasiswa() {
    }

    protected Mahasiswa(Parcel in) {
        this.id_mahasiswa = in.readInt();
        this.nama = in.readString();
        this.tanggal = in.readString();
        this.kelamin = in.readString();
        this.alamat = in.readString();
    }

    public static final Parcelable.Creator<Mahasiswa> CREATOR = new Parcelable.Creator<Mahasiswa>() {
        @Override
        public Mahasiswa createFromParcel(Parcel source) {
            return new Mahasiswa(source);
        }

        @Override
        public Mahasiswa[] newArray(int size) {
            return new Mahasiswa[size];
        }
    };
}
