package com.zsmart.accountingProject.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.accountingProject.bean.Banque;
public interface BanqueService {

public Banque save(Banque banque); 
public Banque  saveWithCompteBanquaires (Banque banque);public List<Banque>  findAll();
public Banque findById(Long id);
public int delete(Banque banque);
public void  deleteById(Long id);
public void clone(Banque banque,Banque banqueClone);
public Banque clone(Banque banque);
public List<Banque> clone(List<Banque>banques);
 public List<Banque>  findByCriteria(String libelle,String code,Long idMin,Long idMax);

}
