package com.zsmart.accountingProject.dao;
import com.zsmart.accountingProject.bean.Facture;
import com.zsmart.accountingProject.bean.FactureItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface FactureItemDao extends JpaRepository<FactureItem,Long> {


	 public FactureItem findByFacture(Facture facture);

	 public int deleteByFacture(Facture facture);

}
