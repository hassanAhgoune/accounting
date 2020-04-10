package com.zsmart.accountingProject.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.accountingProject.bean.Fournisseur;
public interface FournisseurService {

public Fournisseur save(Fournisseur fournisseur); 
public Fournisseur  saveWithFactureFournisseurs (Fournisseur fournisseur);public List<Fournisseur>  findAll();
public Fournisseur findById(Long id);
public int delete(Fournisseur fournisseur);
public void  deleteById(Long id);
public void clone(Fournisseur fournisseur,Fournisseur fournisseurClone);
public Fournisseur clone(Fournisseur fournisseur);
public List<Fournisseur> clone(List<Fournisseur>fournisseurs);
 public List<Fournisseur>  findByCriteria(String ice,String identifiantFiscale,String rc,String libelle,String code,Long idMin,Long idMax);

}
