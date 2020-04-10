package com.zsmart.accountingProject.dao;
import com.zsmart.accountingProject.bean.EtatFacture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface EtatFactureDao extends JpaRepository<EtatFacture,Long> {




}
