package com.rasfood.restaurante.service.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.rasfood.restaurante.dao.CardapioDao;
import com.rasfood.restaurante.dao.CategoriaDao;
import com.rasfood.restaurante.entity.Cardapio;
import com.rasfood.restaurante.entity.Categoria;
import com.rasfood.restaurante.util.JPAUtil;

public class CardapioService {
    
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasfood();
        entityManager.getTransaction().begin();

        //cadastrarCategoria(entityManager, "Prato Principal");
        cadastrarItemCardapio(entityManager);

        entityManager.getTransaction().commit();
        entityManager.close();


    }

    private static void cadastrarCategoria(EntityManager entityManager, String nomeCategoria) {
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        Categoria categoria = new Categoria(nomeCategoria);
        categoriaDao.save(categoria);
    }


    private static void cadastrarItemCardapio(EntityManager entityManager) {
        Cardapio risoto = new Cardapio();
        risoto.setNome("Sisoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));

        Cardapio salmao = new Cardapio();
        salmao.setNome("Salmao ao molho de maracuja");
        salmao.setDescricao("salmao grelhado ao molho de maracuja");
        salmao.setDisponivel(true);
        salmao.setValor(BigDecimal.valueOf(60.00));

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        Categoria categoriaPrincipal = categoriaDao.findById(1l);

        risoto.setCategoria(categoriaPrincipal);
        salmao.setCategoria(categoriaPrincipal);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        
        //cardapioDao.save(risoto);
        //cardapioDao.save(salmao);

        // System.out.println("O prato consultado foi: " + cardapioDao.findById(2l));
        
        // Cardapio cardapioEncontrado = cardapioDao.findById(1l);

        // cardapioDao.delete(cardapioEncontrado);
        // System.out.println("O prato consultado foi: " + cardapioDao.findById(2l));

        // cardapioEncontrado.setValor(BigDecimal.valueOf(100.00));
        // cardapioDao.update(cardapioEncontrado);


        List<Cardapio> cardapios = cardapioDao.findAll();
        cardapios.forEach(cardapio -> System.out.println("O prato consultado foi: " + cardapio));
        
    }

}
