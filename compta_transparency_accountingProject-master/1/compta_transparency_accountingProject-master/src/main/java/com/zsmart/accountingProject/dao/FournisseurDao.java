package com.zsmart.accountingProject.dao;
import com.zsmart.accountingProject.bean.Fournisseur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface FournisseurDao extends JpaRepository<Fournisseur,Long> {




}
