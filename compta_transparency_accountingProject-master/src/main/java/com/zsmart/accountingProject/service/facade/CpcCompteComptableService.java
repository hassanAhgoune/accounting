package com.zsmart.accountingProject.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.accountingProject.bean.CpcCompteComptable;
import com.zsmart.accountingProject.bean.CompteComptable; 
import com.zsmart.accountingProject.bean.CpcSousClasse; 
public interface CpcCompteComptableService {

public CpcCompteComptable save(CpcCompteComptable cpccomptecomptable); 
public List<CpcCompteComptable>  findAll();
public CpcCompteComptable findById(Long id);
public int delete(CpcCompteComptable cpccomptecomptable);
public void  deleteById(Long id);
public void clone(CpcCompteComptable cpccomptecomptable,CpcCompteComptable cpccomptecomptableClone);
public CpcCompteComptable clone(CpcCompteComptable cpccomptecomptable);
public List<CpcCompteComptable> clone(List<CpcCompteComptable>cpccomptecomptables);
 public List<CpcCompteComptable>  findByCriteria(Long idMin,Long idMax,BigDecimal montantMin,BigDecimal montantMax);

}
