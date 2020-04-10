/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.accountingProject.bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author YOUNES
 */
@Entity
public class SousClasseComptable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer numero;
    @ManyToOne
    private ClasseComptable classeComptable;
    @OneToMany(mappedBy = "sousClasseComptable")
    private List<CompteComptable> compteComptables;
    private String libelle;

    public List<CompteComptable> getCompteComptables() {
        return compteComptables;
    }

    public void setCompteComptables(List<CompteComptable> compteComptables) {
        this.compteComptables = compteComptables;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public ClasseComptable getClasseComptable() {
        return classeComptable;
    }

    public void setClasseComptable(ClasseComptable classeComptable) {
        this.classeComptable = classeComptable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SousClasseComptable)) {
            return false;
        }
        SousClasseComptable other = (SousClasseComptable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return libelle + "(" + numero + ")";
    }
}
