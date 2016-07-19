package com.triwayuprasetyo.retrofit21sdp;

/**
 * Created by sdp03 on 7/18/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AnggotaWrapper {
    @SerializedName(value = "data")
    public List<Anggota> anggota;

    public List<Anggota> getAnggota() {
        return anggota;
    }

    public void setAnggota(List<Anggota> anggota) {
        this.anggota = anggota;
    }

    public static class Anggota {
        @Expose
        @SerializedName("id")
        private String id;
        @Expose
        @SerializedName("nama")
        private String nama;
        @Expose
        @SerializedName("alamat")
        private String alamat;
        @Expose
        @SerializedName("username")
        private String username;
        @Expose
        @SerializedName("password")
        private String password;
        @Expose
        @SerializedName("latitude")
        private String latitude;
        @Expose
        @SerializedName("longitude")
        private String longitude;
        @Expose
        @SerializedName("foto")
        private String foto;

        public Anggota() {
        }

        public Anggota(String nama, String alamat, String username, String password) {
            this.nama = nama;
            this.alamat = alamat;
            this.username = username;
            this.password = password;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getAlamat() {
            return alamat;
        }

        public void setAlamat(String alamat) {
            this.alamat = alamat;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getFoto() {
            return foto;
        }

        public void setFoto(String foto) {
            this.foto = foto;
        }
    }
}