package com.zsmart.accountingProject.dao;
import com.zsmart.accountingProject.bean.TypePaiement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface TypePaiementDao extends JpaRepository<TypePaiement,Long> {




}
