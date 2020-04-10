package com.zsmart.accountingProject.dao;
import com.zsmart.accountingProject.bean.SousClasseComptable;
import com.zsmart.accountingProject.bean.Cpc;
import com.zsmart.accountingProject.bean.CpcSousClasse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface CpcSousClasseDao extends JpaRepository<CpcSousClasse,Long> {


	 public CpcSousClasse findBySousClasseComptable(SousClasseComptable sousClasseComptable);
	 public CpcSousClasse findByCpc(Cpc cpc);

	 public int deleteBySousClasseComptable(SousClasseComptable sousClasseComptable);
	 public int deleteByCpc(Cpc cpc);

}
