package com.rasfood.restaurante.service.teste;

import javax.persistence.EntityManager;

import com.rasfood.restaurante.dao.CardapioDao;
import com.rasfood.restaurante.dao.ClienteDao;
import com.rasfood.restaurante.dao.OrdemDao;
import com.rasfood.restaurante.entity.Cliente;
import com.rasfood.restaurante.entity.Endereco;
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
        
        Endereco endereco = new Endereco("00000000", "Barao do rio branco", "casa", "para");
        Cliente felipe = new Cliente("1111111111111", "Felipe");
        felipe.setEnderecoList(endereco);
        clienteDao.save(felipe);

        Ordem ordemFelipe = new Ordem(felipe);
        ordemFelipe.setOrdensCardapioList(new OrdensCardapio(cardapioDao.findById(1l), 2));
        ordemDao.save(ordemFelipe);

        System.out.println(ordemFelipe);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

}
