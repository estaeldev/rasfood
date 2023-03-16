package com.rasfood.restaurante.dao;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public Optional<List<Categoria>> findAll() {
        try {
            String query = "SELECT c FROM Categoria c";
             List<Categoria> cardapioList = this.entityManager.createQuery(query, Categoria.class).getResultList();
            return Optional.of(cardapioList);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<Categoria> findById(final Long id) {
        try {
            Categoria categoria = this.entityManager.find(Categoria.class, id);
            return Optional.of(categoria);
        } catch (Exception e) {
            return Optional.empty();
        }
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
