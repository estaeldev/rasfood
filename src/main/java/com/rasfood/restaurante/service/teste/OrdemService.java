package com.rasfood.restaurante.service.teste;

import javax.persistence.EntityManager;

import com.rasfood.restaurante.dao.CardapioDao;
import com.rasfood.restaurante.dao.ClienteDao;
import com.rasfood.restaurante.dao.OrdemDao;
import com.rasfood.restaurante.entity.Cliente;
import com.rasfood.restaurante.entity.Ordem;
import com.rasfood.restaurante.entity.OrdensCardapio;
import com.rasfood.restaurante.util.JPAUtil;

public class OrdemService {
    
    public static void main(String[] args) {
        
        EntityManager entityManager = JPAUtil.getEntityManagerRasfood();

        entityManager.getTransaction().begin();

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);
        
        Cliente felipe = new Cliente("1111111111111", "Felipe", "00000000");
        clienteDao.save(felipe);

        Ordem ordemFelipe = new Ordem(felipe);
        ordemFelipe.setOrdensCardapioList(new OrdensCardapio(ordemFelipe, cardapioDao.findById(1l), 2));
        ordemDao.save(ordemFelipe);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

}
