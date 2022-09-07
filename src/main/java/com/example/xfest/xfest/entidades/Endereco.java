package com.example.xfest.xfest.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name = "Enderecos")
@Getter @Setter @EqualsAndHashCode @AllArgsConstructor @NoArgsConstructor @ToString
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_ID")
    private Pessoa pessoaEdnderecos;

    @Column(name="logradouro", length = 500, nullable = false)
    private String logra;
    
    @Column(name="bairro", length = 500, nullable = false)
    private String bairro;

    @Column(name="cidade", length = 100, nullable = false)
    private String cidade;

    @Enumerated(EnumType.STRING)
    private EnderecoUF uf;

    @Override
    public String toString() {
        return "Endereco [bairro=" + bairro + ", cidade=" + cidade + ", id=" + id + ", logra=" + logra
                + ", pessoaEdnderecos=" + pessoaEdnderecos + ", uf=" + uf + "]";
    }



    
}
