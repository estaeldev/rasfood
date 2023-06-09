package com.rasfood.restaurante.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ordens_cardapio")
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

    public OrdensCardapio(Cardapio cardapio, Integer quantidade) {
        this.cardapio = cardapio;
        this.quantidade = quantidade;
        this.valor = cardapio.getValor();
    }

    @Override
    public String toString() {
        return "OrdensCardapio [id=" + id + ", valor=" + valor + ", quantidade=" + quantidade
                + "]";
    }

}
