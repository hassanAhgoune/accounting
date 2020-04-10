package com.zsmart.accountingProject.dao;
import com.zsmart.accountingProject.bean.Caisse;
import com.zsmart.accountingProject.bean.CompteBanquaire;
import com.zsmart.accountingProject.bean.CompteComptable;
import com.zsmart.accountingProject.bean.OperationComptableGroupe;
import com.zsmart.accountingProject.bean.Facture;
import com.zsmart.accountingProject.bean.OperationComptable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface OperationComptableDao extends JpaRepository<OperationComptable,Long> {


	 public OperationComptable findByCaisse(Caisse caisse);
	 public OperationComptable findByCompteBanquaire(CompteBanquaire compteBanquaire);
	 public OperationComptable findByCompteComptable(CompteComptable compteComptable);
	 public OperationComptable findByOperationComptableGroupe(OperationComptableGroupe operationComptableGroupe);
	 public OperationComptable findByFacture(Facture facture);

	 public int deleteByCaisse(Caisse caisse);
	 public int deleteByCompteBanquaire(CompteBanquaire compteBanquaire);
	 public int deleteByCompteComptable(CompteComptable compteComptable);
	 public int deleteByOperationComptableGroupe(OperationComptableGroupe operationComptableGroupe);
	 public int deleteByFacture(Facture facture);

}
