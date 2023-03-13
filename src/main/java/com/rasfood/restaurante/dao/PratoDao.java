package com.rasfood.restaurante.dao;

import java.util.Objects;

import javax.persistence.EntityManager;

import com.rasfood.restaurante.entity.Prato;

public class PratoDao {
    
    private EntityManager entityManager;


    public PratoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }   
    

    public void save(final Prato prato) {
        this.entityManager.persist(prato);
        this.entityManager.flush();
    }

    public Prato findById(final Long id) {
        Prato prato = this.entityManager.find(Prato.class, id);
        return prato;
    }

    public void update(final Prato prato) {
        if(!Objects.isNull(prato.getId())) {
            this.entityManager.merge(prato);
            this.entityManager.flush();
        }
    }

    public void delete(final Prato prato) {
        if(!Objects.isNull(prato.getId())) {
            this.entityManager.remove(prato);
            this.entityManager.flush();
        }
    }

}
