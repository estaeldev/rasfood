package com.rasfood.restaurante.entity;

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
@Table(name = "enderecos")
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;
    private String rua;
    private String complemento;
    private String estado;

    @ManyToOne
    private Cliente cliente;

    public Endereco(String cep, String rua, String complemento, String estado) {
        this.cep = cep;
        this.rua = rua;
        this.complemento = complemento;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Endereco [id=" + id + ", cep=" + cep + ", rua=" + rua + ", complemento=" + complemento + ", estado="
                + estado + "]";
    }

}
