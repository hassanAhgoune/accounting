package com.zsmart.accountingProject.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.accountingProject.bean.ClasseComptable;
public interface ClasseComptableService {

public ClasseComptable save(ClasseComptable classecomptable); 
public ClasseComptable  saveWithSousClasseComptables (ClasseComptable classecomptable);public List<ClasseComptable>  findAll();
public ClasseComptable findById(Long id);
public int delete(ClasseComptable classecomptable);
public void  deleteById(Long id);
public void clone(ClasseComptable classecomptable,ClasseComptable classecomptableClone);
public ClasseComptable clone(ClasseComptable classecomptable);
public List<ClasseComptable> clone(List<ClasseComptable>classecomptables);
 public List<ClasseComptable>  findByCriteria(String libelle,Long idMin,Long idMax,Integer numeroMin,Integer numeroMax);

}
