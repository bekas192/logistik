/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectlogistik.logistik.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 300
 */
@Entity
public class KendaraanMuatan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String jenisAngkutan;
    private String merkAngkutan;
    private String kapasitasMuatan;
    private String keterangan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJenisAngkutan() {
        return jenisAngkutan;
    }

    public void setJenisAngkutan(String jenisAngkutan) {
        this.jenisAngkutan = jenisAngkutan;
    }

    public String getMerkAngkutan() {
        return merkAngkutan;
    }

    public void setMerkAngkutan(String merkAngkutan) {
        this.merkAngkutan = merkAngkutan;
    }

    public String getKapasitasMuatan() {
        return kapasitasMuatan;
    }

    public void setKapasitasMuatan(String kapasitasMuatan) {
        this.kapasitasMuatan = kapasitasMuatan;
    }



    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
}