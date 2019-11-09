/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectlogistik.logistik.service;

import com.projectlogistik.logistik.model.Barang;
import java.util.List;

/**
 *
 * @author arrif
 */
public interface BarangService {
    
    List<Barang> listBarang();
    Barang saveOurUpdate(Barang barang);
    Barang getIdBarang(Integer id);
    void hapus (Integer id);
}
