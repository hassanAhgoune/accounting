package com.zsmart.accountingProject.dao;
import com.zsmart.accountingProject.bean.OperationComptableGroupe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface OperationComptableGroupeDao extends JpaRepository<OperationComptableGroupe,Long> {




}
