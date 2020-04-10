
package com.zsmart.accountingProject.service.impl ;
import com.zsmart.accountingProject.service.facade.FactureItemService ; 
import com.zsmart.accountingProject.dao.FactureItemDao ;
import com.zsmart.accountingProject.service.util.SearchUtil;
import com.zsmart.accountingProject.bean.FactureItem;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.zsmart.accountingProject.bean.Facture; 
import com.zsmart.accountingProject.service.facade.FactureService ; 

 @Service  

 public class FactureItemServiceImpl implements FactureItemService  {


 @Autowired 

 private FactureItemDao factureitemDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private FactureService factureService; 

 @Override 
public FactureItem  save (FactureItem factureitem){

if(factureitem== null){ 
 return null; 
}else {
 factureitemDao.save(factureitem);
return factureitem;
}
}

 @Override 
public List< FactureItem>  findAll(){
 return factureitemDao.findAll();
}

 @Override 
public FactureItem findById(Long id){
 return factureitemDao.getOne(id);
}

 @Override 
public int delete(FactureItem factureitem){
if(factureitem== null){ 
  return -1; 
}else {
 factureitemDao.delete(factureitem);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       factureitemDao.deleteById(id);
}
public void clone(FactureItem factureitem,FactureItem factureitemClone){
if(factureitem!= null && factureitemClone != null){
factureitemClone.setId(factureitem.getId());
factureitemClone.setProduit(factureitem.getProduit());
factureitemClone.setMontant(factureitem.getMontant());
factureitemClone.setQuantite(factureitem.getQuantite());
factureitemClone.setFacture(factureService.clone(factureitem.getFacture()));
}
}
public FactureItem clone(FactureItem factureitem){
if(factureitem== null){       return null ;
}else{FactureItem factureitemClone= new FactureItem();
 clone(factureitem,factureitemClone);
return factureitemClone;
}
}
public List<FactureItem> clone(List<FactureItem>factureitems){
if(factureitems== null){
       return null ;
}else{List<FactureItem> factureitemsClone = new ArrayList();
	 	 	 factureitems.forEach((factureitem)->{factureitemsClone.add(clone(factureitem));
});return factureitemsClone;
}
}
 @Override 
 public List< FactureItem>  findByCriteria(String produit,Long idMin,Long idMax,BigDecimal montantMin,BigDecimal montantMax,BigDecimal quantiteMin,BigDecimal quantiteMax){
 return entityManager.createQuery(constructQuery(produit,idMin,idMax,montantMin,montantMax,quantiteMin,quantiteMax)).getResultList(); 
 }
private String constructQuery(String produit,Long idMin,Long idMax,BigDecimal montantMin,BigDecimal montantMax,BigDecimal quantiteMin,BigDecimal quantiteMax){
String query = "SELECT f FROM FactureItem f where 1=1 ";
query += SearchUtil.addConstraint( "f", "produit","=",produit);
query += SearchUtil.addConstraintMinMax("f", "id", idMin, idMax);
query += SearchUtil.addConstraintMinMax("f", "montant", montantMin, montantMax);
query += SearchUtil.addConstraintMinMax("f", "quantite", quantiteMin, quantiteMax);

  return query; 
}
}
