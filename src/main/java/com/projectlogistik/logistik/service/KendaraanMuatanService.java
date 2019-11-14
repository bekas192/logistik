/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectlogistik.logistik.service;

import com.projectlogistik.logistik.model.Barang;
import com.projectlogistik.logistik.model.KendaraanMuatan;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author 300
 */
@Service
public interface KendaraanMuatanService {
    List<KendaraanMuatan> listKendaraan();
    KendaraanMuatan saveOrUpdate(KendaraanMuatan kendaraan);
    KendaraanMuatan getIdKendaraanMuatan(Integer id);
    void hapus (Integer id);
}
