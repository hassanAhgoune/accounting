package com.zsmart.accountingProject.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.accountingProject.bean.Caisse;
public interface CaisseService {

public Caisse save(Caisse caisse); 
public Caisse  saveWithOperationComptables (Caisse caisse);public List<Caisse>  findAll();
public Caisse findById(Long id);
public int delete(Caisse caisse);
public void  deleteById(Long id);
public void clone(Caisse caisse,Caisse caisseClone);
public Caisse clone(Caisse caisse);
public List<Caisse> clone(List<Caisse>caisses);
 public List<Caisse>  findByCriteria(String libelle,String code,Long idMin,Long idMax,BigDecimal soldeMin,BigDecimal soldeMax);

}
