/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectlogistik.logistik.controller;


import com.projectlogistik.logistik.model.KendaraanMuatan;

import com.projectlogistik.logistik.service.KendaraanMuatanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 300
 */
@RequestMapping("/muatan")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class KendaraanMuatanController {
    
    private KendaraanMuatanService kendaraanMuatanService;
    
    @Autowired
     public void setKendaraanMuatanService(KendaraanMuatanService kendaraanMuatanService) {
        this.kendaraanMuatanService = kendaraanMuatanService;
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<KendaraanMuatan> KendaraanList(){
        
        return kendaraanMuatanService.listKendaraan();
    }
    

    
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String simpanDataKendaraanMuatan(@RequestBody KendaraanMuatan kendaraanMuatan){
        kendaraanMuatanService.saveOrUpdate(kendaraanMuatan);
        return "SUCCESS";
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String editDataKendaraanMuatan(@PathVariable Integer id, @RequestBody KendaraanMuatan kendaraanMuatan){
        KendaraanMuatan km = kendaraanMuatanService.getIdKendaraanMuatan(id);
        
        km.setJenisAngkutan(kendaraanMuatan.getJenisAngkutan());
        km.setKapasitasMuatan(kendaraanMuatan.getKapasitasMuatan()); 
        km.setMerkAngkutan(kendaraanMuatan.getMerkAngkutan());
        km.setKeterangan(kendaraanMuatan.getKeterangan());
        
        kendaraanMuatanService.saveOrUpdate(km);
        return "SUCCESS";

    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String hapusDataBarang(@PathVariable Integer id){
        kendaraanMuatanService.hapus(id);
        return "SUCCESS";
    }
}