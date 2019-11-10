/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectlogistik.logistik.service;

import com.projectlogistik.logistik.model.Konsumen;
import java.util.List;

/**
 *
 * @author 300
 */

public interface KonsumenService {
    List<Konsumen> listKonsumen();
    Konsumen saveOrUpdate(Konsumen konsumen);
    Konsumen getIdKonsumen(Integer id);
    void hapus (Integer id);
    
}
