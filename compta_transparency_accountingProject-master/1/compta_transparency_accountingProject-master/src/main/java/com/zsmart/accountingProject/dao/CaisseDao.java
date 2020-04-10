package com.zsmart.accountingProject.dao;
import com.zsmart.accountingProject.bean.Caisse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface CaisseDao extends JpaRepository<Caisse,Long> {




}
