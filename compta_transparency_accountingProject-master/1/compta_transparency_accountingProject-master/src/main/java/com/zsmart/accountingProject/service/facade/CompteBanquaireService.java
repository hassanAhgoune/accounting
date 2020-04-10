package com.zsmart.accountingProject.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.accountingProject.bean.CompteBanquaire;
import com.zsmart.accountingProject.bean.Banque; 
public interface CompteBanquaireService {

public CompteBanquaire save(CompteBanquaire comptebanquaire); 
public CompteBanquaire  saveWithOperationComptables (CompteBanquaire comptebanquaire);public List<CompteBanquaire>  findAll();
public CompteBanquaire findById(Long id);
public int delete(CompteBanquaire comptebanquaire);
public void  deleteById(Long id);
public void clone(CompteBanquaire comptebanquaire,CompteBanquaire comptebanquaireClone);
public CompteBanquaire clone(CompteBanquaire comptebanquaire);
public List<CompteBanquaire> clone(List<CompteBanquaire>comptebanquaires);
 public List<CompteBanquaire>  findByCriteria(String libelle,String code,Long idMin,Long idMax,BigDecimal soldeMin,BigDecimal soldeMax);

}
