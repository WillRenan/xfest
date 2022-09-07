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


import java.util.List;



//import antlr.collections.List;

@Entity
@Table(name = "OrdemServico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "NomeOrdem", length = 100, nullable = false)
    private String nomeOrdem;

    @Column(name = "Descricao", length = 500, nullable = false)
    private String descricaoOrdem;

    @Enumerated(EnumType.ORDINAL)
    private TamanhoEvento tamanhoEvento;

    @Enumerated(EnumType.ORDINAL)
    private Status statusOrdem;
    
    // cada ordem pode ter varios servicos
  /*   @ManyToMany
    private List<Servico> listServico;
 */
    @ManyToOne
    @JoinColumn(name="Criador_ID")
    private Pessoa pessoaCriador; 

    @Enumerated( EnumType.ORDINAL)
    private Status statusOrdemServico;







    //cnstructors
    public OrdemServico() {
        Id = 0L;
        this.nomeOrdem = "";
        this.descricaoOrdem = "";
        this.tamanhoEvento = null;
        this.statusOrdem = null;
      // this.listServico = new ArrayList<>();
       this.pessoaCriador = null;
        this.statusOrdemServico = null;
    }





    public OrdemServico(long id, String nomeOrdem, String descricaoOrdem, TamanhoEvento tamanhoEvento,
            Status statusOrdem, List<Servico> listServico, Pessoa pessoaCriador, Status statusOrdemServico) {
        Id = id;
        this.nomeOrdem = nomeOrdem;
        this.descricaoOrdem = descricaoOrdem;
        this.tamanhoEvento = tamanhoEvento;
        this.statusOrdem = statusOrdem;
       //this.listServico = listServico;
       this.pessoaCriador = pessoaCriador;
        this.statusOrdemServico = statusOrdemServico;
    }



    //getter, setter, egual, hash e toString

    
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNomeOrdem() {
        return nomeOrdem;
    }

    public void setNomeOrdem(String nomeOrdem) {
        this.nomeOrdem = nomeOrdem;
    }

    public String getDescricaoOrdem() {
        return descricaoOrdem;
    }

    public void setDescricaoOrdem(String descricaoOrdem) {
        this.descricaoOrdem = descricaoOrdem;
    }

    public TamanhoEvento getTamanhoEvento() {
        return tamanhoEvento;
    }

    public void setTamanhoEvento(TamanhoEvento tamanhoEvento) {
        this.tamanhoEvento = tamanhoEvento;
    }

    public Status getStatusOrdem() {
        return statusOrdem;
    }

    public void setStatusOrdem(Status statusOrdem) {
        this.statusOrdem = statusOrdem;
    }

 /*    public List<Servico> getListServico() {
        return listServico;
    }

    public void setListServico(List<Servico> listServico) {
        this.listServico = listServico;
    } */

    public Pessoa getPessoaCriador() {
        return pessoaCriador;
    }

    public void setPessoaCriador(Pessoa pessoaCriador) {
        this.pessoaCriador = pessoaCriador;
    }

    public Status getStatusOrdemServico() {
        return statusOrdemServico;
    }

    public void setStatusOrdemServico(Status statusOrdemServico) {
        this.statusOrdemServico = statusOrdemServico;
    }





    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (Id ^ (Id >>> 32));
        result = prime * result + ((descricaoOrdem == null) ? 0 : descricaoOrdem.hashCode());
       // result = prime * result + ((listServico == null) ? 0 : listServico.hashCode());
        result = prime * result + ((nomeOrdem == null) ? 0 : nomeOrdem.hashCode());
        result = prime * result + ((pessoaCriador == null) ? 0 : pessoaCriador.hashCode());
        result = prime * result + ((statusOrdem == null) ? 0 : statusOrdem.hashCode());
        result = prime * result + ((statusOrdemServico == null) ? 0 : statusOrdemServico.hashCode());
        result = prime * result + ((tamanhoEvento == null) ? 0 : tamanhoEvento.hashCode());
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
        OrdemServico other = (OrdemServico) obj;
        if (Id != other.Id)
            return false;
        if (descricaoOrdem == null) {
            if (other.descricaoOrdem != null)
                return false;
        } else if (!descricaoOrdem.equals(other.descricaoOrdem))
            return false;
        /* if (listServico == null) {
            if (other.listServico != null)
                return false;
        } else if (!listServico.equals(other.listServico))
            return false; */
        if (nomeOrdem == null) {
            if (other.nomeOrdem != null)
                return false;
        } else if (!nomeOrdem.equals(other.nomeOrdem))
            return false;
        if (pessoaCriador == null) {
            if (other.pessoaCriador != null)
                return false;
        } else if (!pessoaCriador.equals(other.pessoaCriador))
            return false;
        if (statusOrdem != other.statusOrdem)
            return false;
        if (statusOrdemServico != other.statusOrdemServico)
            return false;
        if (tamanhoEvento != other.tamanhoEvento)
            return false;
        return true;
    }





    @Override
    public String toString() {
        return "OrdemServico [Id=" + Id + ", descricaoOrdem=" + descricaoOrdem + ", listServico=" +  ", nomeOrdem=" + nomeOrdem + ", pessoaCriador=" + pessoaCriador + ", statusOrdem=" + statusOrdem
                + ", statusOrdemServico=" + statusOrdemServico + ", tamanhoEvento=" + tamanhoEvento + "]";
    }





    
    








}
