
package com.zsmart.accountingProject.service.impl ;
import com.zsmart.accountingProject.service.facade.OperationComptableService ; 
import com.zsmart.accountingProject.dao.OperationComptableDao ;
import com.zsmart.accountingProject.service.util.SearchUtil;
import com.zsmart.accountingProject.bean.OperationComptable;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.zsmart.accountingProject.bean.Caisse; 
import com.zsmart.accountingProject.service.facade.CaisseService ; 
import com.zsmart.accountingProject.bean.CompteBanquaire; 
import com.zsmart.accountingProject.service.facade.CompteBanquaireService ; 
import com.zsmart.accountingProject.bean.CompteComptable; 
import com.zsmart.accountingProject.service.facade.CompteComptableService ; 
import com.zsmart.accountingProject.bean.OperationComptableGroupe; 
import com.zsmart.accountingProject.service.facade.OperationComptableGroupeService ; 
import com.zsmart.accountingProject.bean.Facture; 
import com.zsmart.accountingProject.service.facade.FactureService ; 

 @Service  

 public class OperationComptableServiceImpl implements OperationComptableService  {


 @Autowired 

 private OperationComptableDao operationcomptableDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private CaisseService caisseService; 

 @Autowired 

 private CompteBanquaireService comptebanquaireService; 

 @Autowired 

 private CompteComptableService comptecomptableService; 

 @Autowired 

 private OperationComptableGroupeService operationcomptablegroupeService; 

 @Autowired 

 private FactureService factureService; 

 @Override 
public OperationComptable  save (OperationComptable operationcomptable){

if(operationcomptable== null){ 
 return null; 
}else {
 operationcomptableDao.save(operationcomptable);
return operationcomptable;
}
}

 @Override 
public List< OperationComptable>  findAll(){
 return operationcomptableDao.findAll();
}

 @Override 
public OperationComptable findById(Long id){
 return operationcomptableDao.getOne(id);
}

 @Override 
public int delete(OperationComptable operationcomptable){
if(operationcomptable== null){ 
  return -1; 
}else {
 operationcomptableDao.delete(operationcomptable);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       operationcomptableDao.deleteById(id);
}
public void clone(OperationComptable operationcomptable,OperationComptable operationcomptableClone){
if(operationcomptable!= null && operationcomptableClone != null){
operationcomptableClone.setId(operationcomptable.getId());
operationcomptableClone.setLibelle(operationcomptable.getLibelle());
operationcomptableClone.setReferenceSociete(operationcomptable.getReferenceSociete());
operationcomptableClone.setReferenceFacture(operationcomptable.getReferenceFacture());
operationcomptableClone.setDebit(operationcomptable.getDebit());
operationcomptableClone.setCredit(operationcomptable.getCredit());
operationcomptableClone.setDateOperationComptable(operationcomptable.getDateOperationComptable());
operationcomptableClone.setDateSaisie(operationcomptable.getDateSaisie());
operationcomptableClone.setCaisse(caisseService.clone(operationcomptable.getCaisse()));
operationcomptableClone.setCompteBanquaire(comptebanquaireService.clone(operationcomptable.getCompteBanquaire()));
operationcomptableClone.setCompteComptable(comptecomptableService.clone(operationcomptable.getCompteComptable()));
operationcomptableClone.setOperationComptableGroupe(operationcomptablegroupeService.clone(operationcomptable.getOperationComptableGroupe()));
operationcomptableClone.setFacture(factureService.clone(operationcomptable.getFacture()));
}
}
public OperationComptable clone(OperationComptable operationcomptable){
if(operationcomptable== null){       return null ;
}else{OperationComptable operationcomptableClone= new OperationComptable();
 clone(operationcomptable,operationcomptableClone);
return operationcomptableClone;
}
}
public List<OperationComptable> clone(List<OperationComptable>operationcomptables){
if(operationcomptables== null){
       return null ;
}else{List<OperationComptable> operationcomptablesClone = new ArrayList();
	 	 	 operationcomptables.forEach((operationcomptable)->{operationcomptablesClone.add(clone(operationcomptable));
});return operationcomptablesClone;
}
}
 @Override 
 public List< OperationComptable>  findByCriteria(String libelle,String referenceSociete,String referenceFacture,Long idMin,Long idMax,BigDecimal debitMin,BigDecimal debitMax,BigDecimal creditMin,BigDecimal creditMax,Date dateOperationComptableMin,Date dateOperationComptableMax,Date dateSaisieMin,Date dateSaisieMax){
 return entityManager.createQuery(constructQuery(libelle,referenceSociete,referenceFacture,idMin,idMax,debitMin,debitMax,creditMin,creditMax,dateOperationComptableMin,dateOperationComptableMax,dateSaisieMin,dateSaisieMax)).getResultList(); 
 }
private String constructQuery(String libelle,String referenceSociete,String referenceFacture,Long idMin,Long idMax,BigDecimal debitMin,BigDecimal debitMax,BigDecimal creditMin,BigDecimal creditMax,Date dateOperationComptableMin,Date dateOperationComptableMax,Date dateSaisieMin,Date dateSaisieMax){
String query = "SELECT o FROM OperationComptable o where 1=1 ";
query += SearchUtil.addConstraint( "o", "libelle","=",libelle);
query += SearchUtil.addConstraint( "o", "referenceSociete","=",referenceSociete);
query += SearchUtil.addConstraint( "o", "referenceFacture","=",referenceFacture);
query += SearchUtil.addConstraintMinMax("o", "id", idMin, idMax);
query += SearchUtil.addConstraintMinMax("o", "debit", debitMin, debitMax);
query += SearchUtil.addConstraintMinMax("o", "credit", creditMin, creditMax);
query += SearchUtil.addConstraintMinMaxDate("o"," dateOperationComptable", dateOperationComptableMin, dateOperationComptableMax);
query += SearchUtil.addConstraintMinMaxDate("o"," dateSaisie", dateSaisieMin, dateSaisieMax);

  return query; 
}
}
