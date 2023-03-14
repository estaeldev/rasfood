package com.rasfood.restaurante.dao;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;

import com.rasfood.restaurante.entity.Cardapio;

public class CardapioDao {
    
    private EntityManager entityManager;


    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }   
    

    public void save(final Cardapio prato) {
        this.entityManager.persist(prato);
        this.entityManager.flush();
    }

    public Cardapio findById(final Long id) {
        Cardapio prato = this.entityManager.find(Cardapio.class, id);
        return prato;
    }

    public List<Cardapio> findAll() {
        String query = "SELECT c FROM Cardapio c";
        return entityManager.createQuery(query, Cardapio.class).getResultList();
    }

    public void update(final Cardapio prato) {
        if(!Objects.isNull(prato.getId())) {
            this.entityManager.merge(prato);
            this.entityManager.flush();
        }
    }

    public void delete(final Cardapio prato) {
        if(!Objects.isNull(prato.getId())) {
            this.entityManager.remove(prato);
            this.entityManager.flush();
        }
    }

}
