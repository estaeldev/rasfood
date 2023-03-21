package com.rasfood.restaurante.service.teste;

import javax.persistence.EntityManager;

import com.rasfood.restaurante.util.CargaDeDadosUtil;
import com.rasfood.restaurante.util.JPAUtil;

public class CardapioService {
    
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasfood();
        entityManager.getTransaction().begin();

        CargaDeDadosUtil.cadastarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);

        //CardapioDao cardapioDao = new CardapioDao(entityManager);

        // cardapioDao.findByValor(BigDecimal.valueOf(59.00)).forEach(cardapio -> {
        //     System.out.println(cardapio);
        // });

        //cardapioDao.findByNome("moqueca").ifPresent(cardapio -> System.out.println(cardapio));


        

        entityManager.getTransaction().commit();
        entityManager.close();

    }

}
