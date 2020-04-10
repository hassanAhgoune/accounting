package com.zsmart.accountingProject.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.accountingProject.bean.PaiementFacture;
import com.zsmart.accountingProject.bean.TypePaiement; 
import com.zsmart.accountingProject.bean.Facture; 
public interface PaiementFactureService {

public PaiementFacture save(PaiementFacture paiementfacture); 
public List<PaiementFacture>  findAll();
public PaiementFacture findById(Long id);
public int delete(PaiementFacture paiementfacture);
public void  deleteById(Long id);
public void clone(PaiementFacture paiementfacture,PaiementFacture paiementfactureClone);
public PaiementFacture clone(PaiementFacture paiementfacture);
public List<PaiementFacture> clone(List<PaiementFacture>paiementfactures);
 public List<PaiementFacture>  findByCriteria(String description,String scan,Long idMin,Long idMax,Date datePaimentMin,Date datePaimentMax,Date dateSaisieMin,Date dateSaisieMax,BigDecimal montantMin,BigDecimal montantMax);

}
