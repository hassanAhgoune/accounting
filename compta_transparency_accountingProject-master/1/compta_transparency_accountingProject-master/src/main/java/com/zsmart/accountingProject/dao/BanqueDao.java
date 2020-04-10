package com.zsmart.accountingProject.dao;
import com.zsmart.accountingProject.bean.Banque;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface BanqueDao extends JpaRepository<Banque,Long> {




}
