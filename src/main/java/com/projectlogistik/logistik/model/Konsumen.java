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
    
   
    @Column(name = "nama_konsumen")
    private String nama;
    @Column(name = "alamat_konsumen")
    private String alamat;
    private Integer telepon;
    private String keterangan;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

   
    
    
    
}
