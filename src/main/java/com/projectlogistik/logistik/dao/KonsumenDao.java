/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectlogistik.logistik.dao;

import com.projectlogistik.logistik.model.Konsumen;
import com.projectlogistik.logistik.service.KonsumenService;
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
public class KonsumenDao implements KonsumenService{
    private EntityManagerFactory emf;
     @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Konsumen> listKonsumen() {
    EntityManager em = emf.createEntityManager();
        return em.createQuery("from Konsumen", Konsumen.class).getResultList();
    }

    @Override
    public Konsumen saveOrUpdate(Konsumen konsumen) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Konsumen saved = em.merge(konsumen);
        em.getTransaction().commit();

        return saved;
    }

    @Override
    public Konsumen getIdKonsumen(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Konsumen.class,id);
    }

    @Override
    public void hapus(Integer id) {
         EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Konsumen.class , id));
        em.getTransaction().commit();
    }
    
}
