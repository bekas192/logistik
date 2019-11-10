/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectlogistik.logistik.controller;

import com.projectlogistik.logistik.model.Konsumen;
import com.projectlogistik.logistik.service.KonsumenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 300
 */
@RequestMapping("/sevlog/konsumen")
@RestController
public class KonsumenController {
    private KonsumenService konsumenService;
    
    @Autowired
     public void setBarangService(KonsumenService konsumenService) {
        this.konsumenService = konsumenService;
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Konsumen> KonsumenList(){
        
        return konsumenService.listKonsumen();
    }
    

    
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String simpanDataKonsumen(@RequestBody Konsumen konsumen){
        konsumenService.saveOrUpdate(konsumen);
        return "SUCCESS";
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String editDataBarang(@PathVariable Integer id, @RequestBody Konsumen konsumen){
        Konsumen kns = konsumenService.getIdKonsumen(id);
        
        kns.setNo_faktur(konsumen.getNo_faktur());
        kns.setTanggal_faktur(konsumen.getTanggal_faktur()); 
        kns.setNama(konsumen.getNama());
        kns.setTelepon(konsumen.getTelepon());
        kns.setAlamat(konsumen.getAlamat());
        kns.setKeterangan(konsumen.getKeterangan());
        kns.setTanggal_batal(konsumen.getTanggal_batal());
        
        konsumenService.saveOrUpdate(kns);
        return "SUCCESS";

    }
    
    @RequestMapping(value = "/hapus/{id}", method = RequestMethod.DELETE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String hapusDataBarang(@PathVariable Integer id){
        konsumenService.hapus(id);
        return "SUCCESS";
    }
    
}
