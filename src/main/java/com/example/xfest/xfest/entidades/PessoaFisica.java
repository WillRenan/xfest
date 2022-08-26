package com.example.xfest.xfest.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="PessoasFisicas")
@DiscriminatorValue("1") // para que serve?
@Getter @Setter @AllArgsConstructor @EqualsAndHashCode(callSuper = true)
public class PessoaFisica extends Pessoa {

    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

     /* @OneToOne //dúvidas
    @JoinColumn(name = "RepresentanteID")
    private Pessoa representante;  */

    public PessoaFisica(){
        super();
        setTipo(PessoaTipo.FISICA);
        this.cpf = "";
        this.dataNascimento = new Date();
    }
    
    
}
