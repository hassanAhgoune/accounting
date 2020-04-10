package com.zsmart.accountingProject.dao;
import com.zsmart.accountingProject.bean.Client;
import com.zsmart.accountingProject.bean.FactureClient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface FactureClientDao extends JpaRepository<FactureClient,Long> {


	 public FactureClient findByClient(Client client);

	 public int deleteByClient(Client client);

}
