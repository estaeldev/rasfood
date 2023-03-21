package com.rasfood.restaurante.dao;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.rasfood.restaurante.entity.Ordem;

public class OrdemDao {
    
    private EntityManager entityManager;


    public OrdemDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }   
    

    public void save(final Ordem ordem) {
        if(findById(ordem.getId()).isEmpty()) {
            this.entityManager.persist(ordem);
            this.entityManager.flush();
        }
    }

    public Optional<List<Ordem>> findAll() {
        try {
            String query = "SELECT o FROM Ordem o";
             List<Ordem> ordemList = this.entityManager.createQuery(query, Ordem.class).getResultList();
            return Optional.of(ordemList);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<Ordem> findById(final Long id) {
        try {
            Ordem ordem = this.entityManager.find(Ordem.class, id);
            return Optional.of(ordem);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public void update(final Ordem ordem) {
        if(!Objects.isNull(ordem.getId())) {
            this.entityManager.merge(ordem);
            this.entityManager.flush();
        }
    }

    public void delete(final Ordem ordem) {
        if(!Objects.isNull(ordem.getId())) {
            this.entityManager.remove(ordem);
            this.entityManager.flush();
        }
    }


}
