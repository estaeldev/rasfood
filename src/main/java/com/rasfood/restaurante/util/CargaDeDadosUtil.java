package com.rasfood.restaurante.util;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.rasfood.restaurante.dao.CardapioDao;
import com.rasfood.restaurante.dao.CategoriaDao;
import com.rasfood.restaurante.entity.Cardapio;
import com.rasfood.restaurante.entity.Categoria;

public class CargaDeDadosUtil {
    
    private CargaDeDadosUtil() {}


    public static void cadastarCategorias(EntityManager entityManager) {
        Categoria entrada = new Categoria("Entradas");
        Categoria salada = new Categoria("Saladas");
        Categoria principal = new Categoria("Pratos Principais");

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        categoriaDao.save(entrada);
        categoriaDao.save(salada);
        categoriaDao.save(principal);
        entityManager.flush();
    }

    public static void cadastrarProdutosCardapio(EntityManager entityManager) {
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);

        List<Categoria> categorias = null;

        if(categoriaDao.findAll().isPresent()) {
            categorias = categoriaDao.findAll().get();
        }
        

        Cardapio moqueca = new Cardapio("Moqueca", "Peixe branco, banana da terra, arroz e farofa",
                true, BigDecimal.valueOf(95.00), categorias.get(2));

        Cardapio spaguetti = new Cardapio("Spaguetti", "Spagatti ao molho de parmesão e cogumelos",
                true, BigDecimal.valueOf(68.00), categorias.get(2));

        Cardapio bife = new Cardapio("Bife", "Bife acebolado com arroz branco, farofa e batata frita",
                true, BigDecimal.valueOf(59.00), categorias.get(2));

        Cardapio cordeiro = new Cardapio("Cordeiro", "Cordeiro com risoto de funghi",
                true, BigDecimal.valueOf(88.00), categorias.get(2));
                
        Cardapio burrata = new Cardapio("Burrata", "Tomates queimados, rúcula e torrada",
                true, BigDecimal.valueOf(15.00), categorias.get(0));
                
        Cardapio bruschetta = new Cardapio("Bruschetta", "Tomate, mucarela e manjericao",
                true, BigDecimal.valueOf(20.00), categorias.get(0));
                
        Cardapio scappeta = new Cardapio("Scappeta", "Ragu de linguica e torradinhas",
                true, BigDecimal.valueOf(25.00), categorias.get(0));
                
        Cardapio caprese = new Cardapio("Caprese", "Mini rucula e mucarela",
                true, BigDecimal.valueOf(47.00), categorias.get(1));
                
        Cardapio caesar = new Cardapio("Caesar", "Salada de franco com molho ceasar",
                true, BigDecimal.valueOf(40.00), categorias.get(1));
                
        Cardapio chevre = new Cardapio("Chevre", "Mix de folhas, mostarda e mel",
                true, BigDecimal.valueOf(59.00), categorias.get(1));
                

        cardapioDao.save(moqueca);
        cardapioDao.save(spaguetti);
        cardapioDao.save(bife);
        cardapioDao.save(cordeiro);
        cardapioDao.save(burrata);
        cardapioDao.save(bruschetta);
        cardapioDao.save(scappeta);
        cardapioDao.save(caprese);
        cardapioDao.save(caesar);
        cardapioDao.save(chevre);
        
        entityManager.flush();
    }


}
