package com.zsmart.accountingProject.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Cpc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateDebut;
    private Date dateFin;
    private String referenceSociete;
    @Column(precision = 16, scale = 4)
    private BigDecimal totalCharge;
    @Column(precision = 16, scale = 4)
    private BigDecimal totalProduit;
    @Column(precision = 16, scale = 4)
    private BigDecimal resultat;
    @OneToMany(mappedBy = "cpc")
    private List<CpcSousClasse> cpcSousClasses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getReferenceSociete() {
        return referenceSociete;
    }

    public void setReferenceSociete(String referenceSociete) {
        this.referenceSociete = referenceSociete;
    }

    public BigDecimal getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(BigDecimal totalCharge) {
        this.totalCharge = totalCharge;
    }

    public BigDecimal getTotalProduit() {
        return totalProduit;
    }

    public void setTotalProduit(BigDecimal totalProduit) {
        this.totalProduit = totalProduit;
    }

    public BigDecimal getResultat() {
        return resultat;
    }

    public void setResultat(BigDecimal resultat) {
        this.resultat = resultat;
    }

    public List<CpcSousClasse> getCpcSousClasses() {
        return cpcSousClasses;
    }

    public void setCpcSousClasses(List<CpcSousClasse> cpcSousClasses) {
        this.cpcSousClasses = cpcSousClasses;
    }

    @Override
    public String toString() {
        return "Cpc [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", referenceSociete="
                + referenceSociete + ", totalCharge=" + totalCharge + ", totalProduit=" + totalProduit + ", resultat="
                + resultat + ", cpcSousClasses=" + cpcSousClasses + "]";
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
        Cpc other = (Cpc) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
