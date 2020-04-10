package com.zsmart.accountingProject.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.accountingProject.bean.FactureItem;
import com.zsmart.accountingProject.bean.Facture; 
public interface FactureItemService {

public FactureItem save(FactureItem factureitem); 
public List<FactureItem>  findAll();
public FactureItem findById(Long id);
public int delete(FactureItem factureitem);
public void  deleteById(Long id);
public void clone(FactureItem factureitem,FactureItem factureitemClone);
public FactureItem clone(FactureItem factureitem);
public List<FactureItem> clone(List<FactureItem>factureitems);
 public List<FactureItem>  findByCriteria(String produit,Long idMin,Long idMax,BigDecimal montantMin,BigDecimal montantMax,BigDecimal quantiteMin,BigDecimal quantiteMax);

}
