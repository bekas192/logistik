/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectlogistik.logistik.dao;

import com.projectlogistik.logistik.model.KendaraanMuatan;
import com.projectlogistik.logistik.service.KendaraanMuatanService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 300
 */
@Service
public class KendaraanMuatanDao implements KendaraanMuatanService{
    
    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<KendaraanMuatan> listKendaraan() {
        EntityManager em = emf.createEntityManager();
        
        return em.createQuery("from KendaraanMuatan", KendaraanMuatan.class).getResultList();    }

    @Override
    public KendaraanMuatan saveOrUpdate(KendaraanMuatan kendaraan) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        KendaraanMuatan saved = em.merge(kendaraan);
        em.getTransaction().commit();
        
        return saved;}

    @Override
    public KendaraanMuatan getIdKendaraanMuatan(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(KendaraanMuatan.class, id);
    }

    @Override
    public void hapus(Integer id) {
       EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(KendaraanMuatan.class, id));
        em.getTransaction().commit();
    }
    
}
