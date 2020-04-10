package com.zsmart.accountingProject.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.accountingProject.bean.CompteComptable;
import com.zsmart.accountingProject.bean.SousClasseComptable; 
public interface CompteComptableService {

public CompteComptable save(CompteComptable comptecomptable); 
public List<CompteComptable>  findAll();
public CompteComptable findById(Long id);
public int delete(CompteComptable comptecomptable);
public void  deleteById(Long id);
public void clone(CompteComptable comptecomptable,CompteComptable comptecomptableClone);
public CompteComptable clone(CompteComptable comptecomptable);
public List<CompteComptable> clone(List<CompteComptable>comptecomptables);
 public List<CompteComptable>  findByCriteria(String code,String libelle,Long idMin,Long idMax);

}
