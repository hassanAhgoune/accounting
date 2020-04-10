package com.zsmart.accountingProject.dao;
import com.zsmart.accountingProject.bean.CompteComptable;
import com.zsmart.accountingProject.bean.CpcSousClasse;
import com.zsmart.accountingProject.bean.CpcCompteComptable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface CpcCompteComptableDao extends JpaRepository<CpcCompteComptable,Long> {


	 public CpcCompteComptable findByCompteComptable(CompteComptable compteComptable);
	 public CpcCompteComptable findByCpcSousClasse(CpcSousClasse cpcSousClasse);

	 public int deleteByCompteComptable(CompteComptable compteComptable);
	 public int deleteByCpcSousClasse(CpcSousClasse cpcSousClasse);

}
