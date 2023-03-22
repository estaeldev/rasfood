package com.rasfood.restaurante.dao;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.rasfood.restaurante.entity.Cliente;

public class ClienteDao {
    
    private EntityManager entityManager;


    public ClienteDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }   
    

    public void save(final Cliente cliente) {
        if(findById(cliente.getId()).isEmpty()) {
            this.entityManager.persist(cliente);
            this.entityManager.flush();
        }
    }

    public Optional<List<Cliente>> findAll() {
        try {
            String query = "SELECT c FROM Cliente c";
             List<Cliente> clienteList = this.entityManager.createQuery(query, Cliente.class).getResultList();
            return Optional.of(clienteList);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<Cliente> findById(final Long id) {
        try {
            Cliente cliente = this.entityManager.find(Cliente.class, id);
            return Optional.of(cliente);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public void update(final Cliente cliente) {
        if(!Objects.isNull(cliente.getId())) {
            this.entityManager.merge(cliente);
            this.entityManager.flush();
        }
    }

    public void delete(final Cliente cliente) {
        if(!Objects.isNull(cliente.getId())) {
            this.entityManager.remove(cliente);
            this.entityManager.flush();
        }
    }

}
