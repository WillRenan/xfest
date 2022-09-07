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

@Entity
@Table(name = "Servicos")
public class Servico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

   /*  //cada Servico pode estar em varias Ordens de Servico 
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "Servico")
    private List<OrdemServico> listOrdemServico;
 */
    //cada servico está associada à uma pessoa/usuario/conta
    @ManyToOne
    @JoinColumn(name = "pessoa_Id")
    private Pessoa pessoaServico;

    @Enumerated(EnumType.ORDINAL)
    private ServicoTipo tipoServico;

    @Column(name = "DescicaoServico", length = 500, nullable =  false)
    private String descricaoServico;

    @Column(name = "ValorServico")
    private float valorServico;

    @Column(name = "TelServico", length = 14, nullable =  false)
    private String telServico;

    @Column(name = "EmailServico", length =  500, nullable = false)
    private String emailServico;


    @Enumerated(EnumType.ORDINAL)
    private Status statusServico;

    //constructors
    public Servico() {
        Id = 0L;
        //this.listOrdemServico = new ArrayList<>();
        this.pessoaServico = null;
        this.tipoServico = null;
        this.descricaoServico = "";
        this.valorServico = 0f;
        this.telServico = "";
        this.emailServico = "";
        this.statusServico = null;
    }

    public Servico(long id, List<OrdemServico> listOrdemServico, Pessoa pessoa, ServicoTipo tipoServico,
            String descricaoServico, float valorServico, String telServico, String emailServico, Status statusServico) {
        Id = id;
       // this.listOrdemServico = listOrdemServico;
        this.pessoaServico = pessoa;
        this.tipoServico = tipoServico;
        this.descricaoServico = descricaoServico;
        this.valorServico = valorServico;
        this.telServico = telServico;
        this.emailServico = emailServico;
        this.statusServico = statusServico;
    }

     //getter, setter, egual, hash e toString
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    /* public List<OrdemServico> getListOrdemServico() {
        return listOrdemServico;
    }

    public void setListOrdemServico(List<OrdemServico> listOrdemServico) {
        this.listOrdemServico = listOrdemServico;
    }
 */
    public Pessoa getPessoa() {
        return pessoaServico;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoaServico = pessoa;
    }

    public ServicoTipo getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(ServicoTipo tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public float getValorServico() {
        return valorServico;
    }

    public void setValorServico(float valorServico) {
        this.valorServico = valorServico;
    }

    public String getTelServico() {
        return telServico;
    }

    public void setTelServico(String telServico) {
        this.telServico = telServico;
    }

    public String getEmailServico() {
        return emailServico;
    }

    public void setEmailServico(String emailServico) {
        this.emailServico = emailServico;
    }

    public Status getStatusServico() {
        return statusServico;
    }

    public void setStatusServico(Status statusServico) {
        this.statusServico = statusServico;
    }

   

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (Id ^ (Id >>> 32));
        result = prime * result + ((descricaoServico == null) ? 0 : descricaoServico.hashCode());
        result = prime * result + ((emailServico == null) ? 0 : emailServico.hashCode());
        result = prime * result + ((pessoaServico == null) ? 0 : pessoaServico.hashCode());
        result = prime * result + ((statusServico == null) ? 0 : statusServico.hashCode());
        result = prime * result + ((telServico == null) ? 0 : telServico.hashCode());
        result = prime * result + ((tipoServico == null) ? 0 : tipoServico.hashCode());
        result = prime * result + Float.floatToIntBits(valorServico);
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
        Servico other = (Servico) obj;
        if (Id != other.Id)
            return false;
        if (descricaoServico == null) {
            if (other.descricaoServico != null)
                return false;
        } else if (!descricaoServico.equals(other.descricaoServico))
            return false;
        if (emailServico == null) {
            if (other.emailServico != null)
                return false;
        } else if (!emailServico.equals(other.emailServico))
            return false;
        if (pessoaServico == null) {
            if (other.pessoaServico != null)
                return false;
        } else if (!pessoaServico.equals(other.pessoaServico))
            return false;
        if (statusServico != other.statusServico)
            return false;
        if (telServico == null) {
            if (other.telServico != null)
                return false;
        } else if (!telServico.equals(other.telServico))
            return false;
        if (tipoServico != other.tipoServico)
            return false;
        if (Float.floatToIntBits(valorServico) != Float.floatToIntBits(other.valorServico))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Servico [Id=" + Id + ", descricaoServico=" + descricaoServico + ", emailServico=" + emailServico
                + ", pessoaServico=" + pessoaServico + ", statusServico=" + statusServico + ", telServico=" + telServico
                + ", tipoServico=" + tipoServico + ", valorServico=" + valorServico + "]";
    }

   
    
   

    

    










}
