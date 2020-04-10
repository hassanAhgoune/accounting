package com.zsmart.accountingProject.dao;
import com.zsmart.accountingProject.bean.ClasseComptable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface ClasseComptableDao extends JpaRepository<ClasseComptable,Long> {




}
