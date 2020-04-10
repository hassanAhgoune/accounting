package com.zsmart.accountingProject.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.accountingProject.bean.EtatFacture;
public interface EtatFactureService {

public EtatFacture save(EtatFacture etatfacture); 
public EtatFacture  saveWithFactures (EtatFacture etatfacture);public List<EtatFacture>  findAll();
public EtatFacture findById(Long id);
public int delete(EtatFacture etatfacture);
public void  deleteById(Long id);
public void clone(EtatFacture etatfacture,EtatFacture etatfactureClone);
public EtatFacture clone(EtatFacture etatfacture);
public List<EtatFacture> clone(List<EtatFacture>etatfactures);
 public List<EtatFacture>  findByCriteria(String libelle,String code,Long idMin,Long idMax);

}
