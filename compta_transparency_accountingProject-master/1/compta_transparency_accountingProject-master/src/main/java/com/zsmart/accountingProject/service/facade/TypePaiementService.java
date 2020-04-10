package com.zsmart.accountingProject.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.accountingProject.bean.TypePaiement;
public interface TypePaiementService {

public TypePaiement save(TypePaiement typepaiement); 
public TypePaiement  saveWithPaiementFactures (TypePaiement typepaiement);public List<TypePaiement>  findAll();
public TypePaiement findById(Long id);
public int delete(TypePaiement typepaiement);
public void  deleteById(Long id);
public void clone(TypePaiement typepaiement,TypePaiement typepaiementClone);
public TypePaiement clone(TypePaiement typepaiement);
public List<TypePaiement> clone(List<TypePaiement>typepaiements);
 public List<TypePaiement>  findByCriteria(String libelle,String code,Long idMin,Long idMax);

}
