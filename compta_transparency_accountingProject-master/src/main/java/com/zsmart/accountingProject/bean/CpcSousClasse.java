package com.zsmart.accountingProject.bean;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CpcSousClasse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private SousClasseComptable sousClasseComptable;
    @Column(precision = 16, scale = 4)
    private BigDecimal montant;
    @ManyToOne
    private Cpc cpc;
    @OneToMany(mappedBy = "cpcSousClasse")
    private List<CpcCompteComptable> cpcCompteComptables;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SousClasseComptable getSousClasseComptable() {
        return sousClasseComptable;
    }

    public void setSousClasseComptable(SousClasseComptable sousClasseComptable) {
        this.sousClasseComptable = sousClasseComptable;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Cpc getCpc() {
        return cpc;
    }

    public void setCpc(Cpc cpc) {
        this.cpc = cpc;
    }

    public List<CpcCompteComptable> getCpcCompteComptables() {
        return cpcCompteComptables;
    }

    public void setCpcCompteComptables(List<CpcCompteComptable> cpcCompteComptables) {
        this.cpcCompteComptables = cpcCompteComptables;
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
        CpcSousClasse other = (CpcSousClasse) obj;
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
        return "CpcSousClasse [id=" + id + ", sousClasseComptable=" + sousClasseComptable + ", montant=" + montant
                + ", cpc=" + cpc + ", cpcCompteComptables=" + cpcCompteComptables + "]";
    }

}
