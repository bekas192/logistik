/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectlogistik.logistik.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Konsumen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String no_faktur;
    private Date tanggal_faktur;
    @Column(name = "nama_konsumen")
    private String nama;
    @Column(name = "alamat_konsumen")
    private String alamat;
    private Integer telepon;
    private String keterangan;
    private Date tanggal_batal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo_faktur() {
        return no_faktur;
    }

    public void setNo_faktur(String no_faktur) {
        this.no_faktur = no_faktur;
    }

    public Date getTanggal_faktur() {
        return tanggal_faktur;
    }

    public void setTanggal_faktur(Date tanggal_faktur) {
        this.tanggal_faktur = tanggal_faktur;
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

    public Integer getTelepon() {
        return telepon;
    }

    public void setTelepon(Integer telepon) {
        this.telepon = telepon;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Date getTanggal_batal() {
        return tanggal_batal;
    }

    public void setTanggal_batal(Date tanggal_batal) {
        this.tanggal_batal = tanggal_batal;
    }
    
    
    
}
