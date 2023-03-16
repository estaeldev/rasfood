package com.rasfood.restaurante.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public Optional<Cardapio> findByNome(String nome) {
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE UPPER(c.nome) = :nome";
            Cardapio cardapio = this.entityManager.createQuery(jpql, Cardapio.class).setParameter("nome", nome.toUpperCase()).getSingleResult();
            return Optional.of(cardapio);
        } catch (Exception e) {
            return Optional.empty();
        }
         
    }

    public Optional<List<Cardapio>> findAll() {
        
        try {
            String jpql = "SELECT c FROM Cardapio c";
            List<Cardapio> cardapioList = this.entityManager.createQuery(jpql, Cardapio.class).getResultList();
            return Optional.of(cardapioList);
        } catch (Exception e) {
            return Optional.empty();
        }
        
    }

    public Optional<List<Cardapio>> findByValor(final BigDecimal valor) {
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE c.valor = :valor";
            List<Cardapio> cardapioList = this.entityManager.createQuery(jpql, Cardapio.class).setParameter("valor", valor) .getResultList();
            return Optional.of(cardapioList);
        } catch (Exception e) {
            return Optional.empty();
        }
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
