package com.zsmart.accountingProject.dao;
import com.zsmart.accountingProject.bean.TypePaiement;
import com.zsmart.accountingProject.bean.Facture;
import com.zsmart.accountingProject.bean.PaiementFacture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface PaiementFactureDao extends JpaRepository<PaiementFacture,Long> {


	 public PaiementFacture findByTypePaiment(TypePaiement typePaiment);
	 public PaiementFacture findByFacture(Facture facture);

	 public int deleteByTypePaiment(TypePaiement typePaiment);
	 public int deleteByFacture(Facture facture);

}
