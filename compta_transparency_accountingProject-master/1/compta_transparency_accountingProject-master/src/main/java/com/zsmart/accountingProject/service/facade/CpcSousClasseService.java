package com.zsmart.accountingProject.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.accountingProject.bean.CpcSousClasse;
import com.zsmart.accountingProject.bean.SousClasseComptable; 
import com.zsmart.accountingProject.bean.Cpc; 
public interface CpcSousClasseService {

public CpcSousClasse save(CpcSousClasse cpcsousclasse); 
public CpcSousClasse  saveWithCpcCompteComptables (CpcSousClasse cpcsousclasse);public List<CpcSousClasse>  findAll();
public CpcSousClasse findById(Long id);
public int delete(CpcSousClasse cpcsousclasse);
public void  deleteById(Long id);
public void clone(CpcSousClasse cpcsousclasse,CpcSousClasse cpcsousclasseClone);
public CpcSousClasse clone(CpcSousClasse cpcsousclasse);
public List<CpcSousClasse> clone(List<CpcSousClasse>cpcsousclasses);
 public List<CpcSousClasse>  findByCriteria(Long idMin,Long idMax,BigDecimal montantMin,BigDecimal montantMax);

}
