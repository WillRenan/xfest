package com.example.xfest.xfest.entidades;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name = "Pessoas")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "nome", length = 500, nullable = false)
    private String nome;

    //problema ao criar e relacionar as entidades
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pessoa")
    private List<Endereco> enderecos;

    @Column(name = "sobrenome", length = 500, nullable = false)
    private String sobrenome;

    @Enumerated(EnumType.ORDINAL)
    private PessoaTipo tipo;


    //tirar e colcoar na pessoa fisica
    @Enumerated(EnumType.ORDINAL)
    private PessoaSexo sexo;
    
    
   /*  @Temporal( TemporalType.DATE)
    @Column(name = "dataNascimento")
    private Date dataNascimento; */
    
    
    public PessoaSexo getSexo() {
        return sexo;
    }


    public void setSexo(PessoaSexo sexo) {
        this.sexo = sexo;
    }


  

    public Pessoa(){  //Construtor vazio
        this.Id = 0L;
        this.nome = "";
        this.nome = "";
        this.sobrenome = "";
        this.tipo = null;
        this.sexo = null;
        this.enderecos =  null;
    }
    
    
    public Pessoa(long id, String nome, String sobrenome, PessoaTipo tipo, PessoaSexo sexo, List<Endereco> endereco) {
        Id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tipo = tipo;
        this.sexo = sexo;
        this.enderecos = endereco;
    }
    
    
    public List<Endereco> getEndereco() {
         return enderecos;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.enderecos = endereco;
    }


    public String getSobrenome() {
        return sobrenome;
    }


    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }


    public PessoaTipo getTipo() {
        return tipo;
    }


    public void setTipo(PessoaTipo tipo) {
        this.tipo = tipo;
    }

    public long getId() {
        return Id;
    }


    public void setId(long id) {
        Id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (Id ^ (Id >>> 32));
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (Id != other.Id)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + "]";
    }


}
