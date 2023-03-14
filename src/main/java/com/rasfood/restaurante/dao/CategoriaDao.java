package com.rasfood.restaurante.dao;

import java.util.Objects;

import javax.persistence.EntityManager;

import com.rasfood.restaurante.entity.Categoria;

public class CategoriaDao {
    
    private EntityManager entityManager;


    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }   
    

    public void save(final Categoria categoria) {
        this.entityManager.persist(categoria);
        this.entityManager.flush();
    }

    public Categoria findById(final Long id) {
        Categoria categoria = this.entityManager.find(Categoria.class, id);
        return categoria;
    }

    public void update(final Categoria categoria) {
        if(!Objects.isNull(categoria.getId())) {
            this.entityManager.merge(categoria);
            this.entityManager.flush();
        }
    }

    public void delete(final Categoria categoria) {
        if(!Objects.isNull(categoria.getId())) {
            this.entityManager.remove(categoria);
            this.entityManager.flush();
        }
    }

}
