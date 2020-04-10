package com.zsmart.accountingProject.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class PaiementFacture implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date datePaiment;

	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateSaisie;
	@Column(precision = 16, scale = 4)
	private BigDecimal montant;
	private String description;
	private String scan;
	@ManyToOne
	private TypePaiement typePaiment;
	@ManyToOne
	private Facture facture;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatePaiment() {
		return datePaiment;
	}

	public void setDatePaiment(Date datePaiment) {
		this.datePaiment = datePaiment;
	}

	public Date getDateSaisie() {
		return dateSaisie;
	}

	public void setDateSaisie(Date dateSaisie) {
		this.dateSaisie = dateSaisie;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getScan() {
		return scan;
	}

	public void setScan(String scan) {
		this.scan = scan;
	}

	public TypePaiement getTypePaiment() {
		return typePaiment;
	}

	public void setTypePaiment(TypePaiement typePaiment) {
		this.typePaiment = typePaiment;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
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
		PaiementFacture other = (PaiementFacture) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PaiementFacture [id=" + id + ", datePaiment=" + datePaiment + ", dateSaisie=" + dateSaisie
				+ ", montant=" + montant + ", description=" + description + ", scan=" + scan + ", typePaiment="
				+ typePaiment + ", facture=" + facture + "]";
	}

}
