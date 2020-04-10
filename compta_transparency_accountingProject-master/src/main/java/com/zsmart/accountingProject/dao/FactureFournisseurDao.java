package com.zsmart.accountingProject.dao;
import com.zsmart.accountingProject.bean.Fournisseur;
import com.zsmart.accountingProject.bean.FactureFournisseur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface FactureFournisseurDao extends JpaRepository<FactureFournisseur,Long> {


	 public FactureFournisseur findByFournisseur(Fournisseur fournisseur);

	 public int deleteByFournisseur(Fournisseur fournisseur);

}
