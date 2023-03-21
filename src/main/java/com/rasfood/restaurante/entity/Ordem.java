package com.rasfood.restaurante.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ordens")
public class Ordem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_total")
    private BigDecimal valotTotal;

    @Column(name = "data_de_criacao")
    private LocalDateTime dataDeCriacao = LocalDateTime.now();

    @ManyToOne
    private Cliente cliente;

    @OneToMany
    private List<OrdensCardapio> ordensCardapioList;

    public Ordem(Cliente cliente) {
        this.cliente = cliente;
    }
    

}