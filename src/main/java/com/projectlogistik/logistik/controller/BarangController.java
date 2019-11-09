/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectlogistik.logistik.controller;

import com.projectlogistik.logistik.model.Barang;
import com.projectlogistik.logistik.service.BarangService;
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
 * @author arrif
 */
@RequestMapping("/barang")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BarangController {
    
    private BarangService barangService;
    
    @Autowired
     public void setBarangService(BarangService barangService) {
        this.barangService = barangService;
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Barang> BarangList(){
        
        return barangService.listBarang();
    }
    

    
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String simpanDataBarang(@RequestBody Barang barang){
        barangService.saveOurUpdate(barang);
        return "SUCCESS";
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String editDataBarang(@PathVariable Integer id, @RequestBody Barang barang){
        Barang brg = barangService.getIdBarang(id);
        
        brg.setNamaBarang(barang.getNamaBarang());
        brg.setHargaBeli(barang.getHargaBeli()); 
        brg.setHargaJual(barang.getHargaJual());
        brg.setSatuan(barang.getSatuan());
        
        barangService.saveOurUpdate(brg);
        return "SUCCESS";

    }
    
    @RequestMapping(value = "/hapus/{id}", method = RequestMethod.DELETE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String hapusDataBarang(@PathVariable Integer id){
        barangService.hapus(id);
        return "SUCCESS";
    }
}
