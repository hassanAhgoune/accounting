package com.zsmart.accountingProject.dao;
import com.zsmart.accountingProject.bean.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface ClientDao extends JpaRepository<Client,Long> {




}
