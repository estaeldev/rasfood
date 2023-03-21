package com.rasfood.restaurante.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ordens_carpadio")
public class OrdensCardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ordem ordem;

    @ManyToOne
    private Cardapio cardapio;

    private BigDecimal valor;
    private Integer quantidade;

    public OrdensCardapio(Ordem ordem, Cardapio cardapio, Integer quantidade) {
        this.ordem = ordem;
        this.cardapio = cardapio;
        this.quantidade = quantidade;
    }

}
