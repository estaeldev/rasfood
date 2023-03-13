package com.rasfood.restaurante.service.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.rasfood.restaurante.dao.PratoDao;
import com.rasfood.restaurante.entity.Prato;
import com.rasfood.restaurante.util.JPAUtil;

public class PratoService {
    
    public static void main(String[] args) {
        Prato risoto = new Prato();
        risoto.setNome("Sisoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));

        Prato salmao = new Prato();
        salmao.setNome("Salmao ao molho de maracuja");
        salmao.setDescricao("salmao grelhado ao molho de maracuja");
        salmao.setDisponivel(true);
        salmao.setValor(BigDecimal.valueOf(60.00));

        EntityManager entityManager = JPAUtil.getEntityManagerRasfood();
        PratoDao pratoDao = new PratoDao(entityManager);
        
        entityManager.getTransaction().begin();

        // pratoDao.save(risoto);
        // pratoDao.save(salmao);
        // System.out.println("O prato consultado foi: " + pratoDao.findById(2l));
        
        Prato pratoEncontrado = pratoDao.findById(1l);

        // pratoDao.delete(pratoEncontrado);
        // System.out.println("O prato consultado foi: " + pratoDao.findById(2l));

        pratoEncontrado.setValor(BigDecimal.valueOf(100.00));
        pratoDao.update(pratoEncontrado);

        entityManager.getTransaction().commit();
        entityManager.close();

    }


}
