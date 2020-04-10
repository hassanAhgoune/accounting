package com.zsmart.accountingProject.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.accountingProject.bean.Client;
public interface ClientService {

public Client save(Client client); 
public Client  saveWithFactureClients (Client client);public List<Client>  findAll();
public Client findById(Long id);
public int delete(Client client);
public void  deleteById(Long id);
public void clone(Client client,Client clientClone);
public Client clone(Client client);
public List<Client> clone(List<Client>clients);
 public List<Client>  findByCriteria(String ice,String identifiantFiscale,String rc,String libelle,String code,Long idMin,Long idMax);

}
