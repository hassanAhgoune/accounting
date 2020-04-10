package com.zsmart.accountingProject.dao;
import com.zsmart.accountingProject.bean.Banque;
import com.zsmart.accountingProject.bean.CompteBanquaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface CompteBanquaireDao extends JpaRepository<CompteBanquaire,Long> {


	 public CompteBanquaire findByBanque(Banque banque);

	 public int deleteByBanque(Banque banque);

}
