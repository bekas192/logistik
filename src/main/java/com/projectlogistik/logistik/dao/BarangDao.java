/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectlogistik.logistik.dao;

import com.projectlogistik.logistik.model.Barang;
import com.projectlogistik.logistik.service.BarangService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author arrif
 */
@Service
public class BarangDao implements BarangService{

    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    
    @Override
    public List<Barang> listBarang() {
    EntityManager em = emf.createEntityManager();
        
        return em.createQuery("from Barang", Barang.class).getResultList();    }
    
    
    @Override
    public Barang saveOurUpdate(Barang barang) {
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Barang saved = em.merge(barang);
        em.getTransaction().commit();
        
        return saved;
    }

    @Override
    public Barang getIdBarang(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Barang.class, id);
        
    }

    @Override
    public void hapus(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Barang.class, id));
        em.getTransaction().commit();
    }
}
