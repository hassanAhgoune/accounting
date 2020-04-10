package com.zsmart.accountingProject.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CpcCompteComptable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private CompteComptable compteComptable;
    @Column(precision = 16, scale = 4)
    private BigDecimal montant;
    @ManyToOne
    private CpcSousClasse cpcSousClasse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompteComptable getCompteComptable() {
        return compteComptable;
    }

    public void setCompteComptable(CompteComptable compteComptable) {
        this.compteComptable = compteComptable;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public CpcSousClasse getCpcSousClasse() {
        return cpcSousClasse;
    }

    public void setCpcSousClasse(CpcSousClasse cpcSousClasse) {
        this.cpcSousClasse = cpcSousClasse;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        CpcCompteComptable other = (CpcCompteComptable) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CpcCompteComptable [id=" + id + ", compteComptable=" + compteComptable + ", montant=" + montant
                + ", cpcSousClasse=" + cpcSousClasse + "]";
    }

}
