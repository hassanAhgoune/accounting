package com.zsmart.accountingProject.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.accountingProject.bean.OperationComptableGroupe;
public interface OperationComptableGroupeService {

public OperationComptableGroupe save(OperationComptableGroupe operationcomptablegroupe); 
public OperationComptableGroupe  saveWithOperationComptables (OperationComptableGroupe operationcomptablegroupe);public List<OperationComptableGroupe>  findAll();
public OperationComptableGroupe findById(Long id);
public int delete(OperationComptableGroupe operationcomptablegroupe);
public void  deleteById(Long id);
public void clone(OperationComptableGroupe operationcomptablegroupe,OperationComptableGroupe operationcomptablegroupeClone);
public OperationComptableGroupe clone(OperationComptableGroupe operationcomptablegroupe);
public List<OperationComptableGroupe> clone(List<OperationComptableGroupe>operationcomptablegroupes);
 public List<OperationComptableGroupe>  findByCriteria(String libelle,String code,Long idMin,Long idMax);

}
