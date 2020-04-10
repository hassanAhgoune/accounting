package com.zsmart.accountingProject.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public class Facture implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
	private String typeFacture;
	private Integer annee;
	private Integer mois;
	private Integer trimester;
	@Column(precision = 16, scale = 4)
	private BigDecimal totalHt;
	@Column(precision = 16, scale = 4)
	private BigDecimal totalTtc;
	@Column(precision = 16, scale = 4)
	private BigDecimal tva;
	@Column(precision = 16, scale = 4)
	private BigDecimal totalPayerHt;
	@Column(precision = 16, scale = 4)
	private BigDecimal totalRestantHt;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateFacture;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateSaisie;
	private String referenceSociete;
	@ManyToOne
	private EtatFacture etatFacture;
	@OneToMany(mappedBy = "facture")
	private List<PaiementFacture> paimentFactures;
	@OneToMany(mappedBy = "facture")
	private List<OperationComptable> operationComptable;
	@OneToMany(mappedBy = "facture")
	private List<FactureItem> factureItems;
	
	
	public List<FactureItem> getFactureItems() {
		return factureItems;
	}
	public void setFactureItems(List<FactureItem> factureItems) {
		this.factureItems = factureItems;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getTypeFacture() {
		return typeFacture;
	}
	public void setTypeFacture(String typeFacture) {
		this.typeFacture = typeFacture;
	}
	public Integer getAnnee() {
		return annee;
	}
	public void setAnnee(Integer annee) {
		this.annee = annee;
	}
	public Integer getMois() {
		return mois;
	}
	public void setMois(Integer mois) {
		this.mois = mois;
	}
	public Integer getTrimester() {
		return trimester;
	}
	public void setTrimester(Integer trimester) {
		this.trimester = trimester;
	}
	public BigDecimal getTotalHt() {
		return totalHt;
	}
	public void setTotalHt(BigDecimal totalHt) {
		this.totalHt = totalHt;
	}
	public BigDecimal getTotalTtc() {
		return totalTtc;
	}
	public void setTotalTtc(BigDecimal totalTtc) {
		this.totalTtc = totalTtc;
	}
	public BigDecimal getTva() {
		return tva;
	}
	public void setTva(BigDecimal tva) {
		this.tva = tva;
	}
	public BigDecimal getTotalPayerHt() {
		return totalPayerHt;
	}
	public void setTotalPayerHt(BigDecimal totalPayerHt) {
		this.totalPayerHt = totalPayerHt;
	}
	public BigDecimal getTotalRestantHt() {
		return totalRestantHt;
	}
	public void setTotalRestantHt(BigDecimal totalRestantHt) {
		this.totalRestantHt = totalRestantHt;
	}
	public Date getDateFacture() {
		return dateFacture;
	}
	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}
	public Date getDateSaisie() {
		return dateSaisie;
	}
	public void setDateSaisie(Date dateSaisie) {
		this.dateSaisie = dateSaisie;
	}
	public String getReferenceSociete() {
		return referenceSociete;
	}
	public void setReferenceSociete(String referenceSociete) {
		this.referenceSociete = referenceSociete;
	}
	public EtatFacture getEtatFacture() {
		return etatFacture;
	}
	public void setEtatFacture(EtatFacture etatFacture) {
		this.etatFacture = etatFacture;
	}
	public List<PaiementFacture> getPaimentFactures() {
		return paimentFactures;
	}
	public void setPaimentFactures(List<PaiementFacture> paimentFactures) {
		this.paimentFactures = paimentFactures;
	}
	public List<OperationComptable> getOperationComptable() {
		return operationComptable;
	}
	public void setOperationComptable(List<OperationComptable> operationComptable) {
		this.operationComptable = operationComptable;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Facture other = (Facture) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Facture [id=" + id + ", reference=" + reference + ", typeFacture=" + typeFacture + ", annee=" + annee
				+ ", mois=" + mois + ", trimester=" + trimester + ", totalHt=" + totalHt + ", totalTtc=" + totalTtc
				+ ", tva=" + tva + ", totalPayerHt=" + totalPayerHt + ", totalRestantHt=" + totalRestantHt
				+ ", dateFacture=" + dateFacture + ", dateSaisie=" + dateSaisie + ", referenceSociete="
				+ referenceSociete + ", etatFacture=" + etatFacture + ", paimentFactures=" + paimentFactures
				+ ", operationComptable=" + operationComptable + ", factureItems=" + factureItems + "]";
	}

	
	
}
