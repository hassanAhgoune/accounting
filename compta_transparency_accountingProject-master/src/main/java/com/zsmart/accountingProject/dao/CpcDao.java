package com.zsmart.accountingProject.dao;
import com.zsmart.accountingProject.bean.Cpc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface CpcDao extends JpaRepository<Cpc,Long> {




}
