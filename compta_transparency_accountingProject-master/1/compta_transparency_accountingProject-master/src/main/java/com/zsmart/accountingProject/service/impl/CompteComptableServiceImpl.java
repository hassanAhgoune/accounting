
package com.zsmart.accountingProject.service.impl ;
import com.zsmart.accountingProject.service.facade.CompteComptableService ; 
import com.zsmart.accountingProject.dao.CompteComptableDao ;
import com.zsmart.accountingProject.service.util.SearchUtil;
import com.zsmart.accountingProject.bean.CompteComptable;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.zsmart.accountingProject.bean.SousClasseComptable; 
import com.zsmart.accountingProject.service.facade.SousClasseComptableService ; 

 @Service  

 public class CompteComptableServiceImpl implements CompteComptableService  {


 @Autowired 

 private CompteComptableDao comptecomptableDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private SousClasseComptableService sousclassecomptableService; 

 @Override 
public CompteComptable  save (CompteComptable comptecomptable){

if(comptecomptable== null){ 
 return null; 
}else {
 comptecomptableDao.save(comptecomptable);
return comptecomptable;
}
}

 @Override 
public List< CompteComptable>  findAll(){
 return comptecomptableDao.findAll();
}

 @Override 
public CompteComptable findById(Long id){
 return comptecomptableDao.getOne(id);
}

 @Override 
public int delete(CompteComptable comptecomptable){
if(comptecomptable== null){ 
  return -1; 
}else {
 comptecomptableDao.delete(comptecomptable);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       comptecomptableDao.deleteById(id);
}
public void clone(CompteComptable comptecomptable,CompteComptable comptecomptableClone){
if(comptecomptable!= null && comptecomptableClone != null){
comptecomptableClone.setId(comptecomptable.getId());
comptecomptableClone.setCode(comptecomptable.getCode());
comptecomptableClone.setLibelle(comptecomptable.getLibelle());
comptecomptableClone.setSousClasseComptable(sousclassecomptableService.clone(comptecomptable.getSousClasseComptable()));
}
}
public CompteComptable clone(CompteComptable comptecomptable){
if(comptecomptable== null){       return null ;
}else{CompteComptable comptecomptableClone= new CompteComptable();
 clone(comptecomptable,comptecomptableClone);
return comptecomptableClone;
}
}
public List<CompteComptable> clone(List<CompteComptable>comptecomptables){
if(comptecomptables== null){
       return null ;
}else{List<CompteComptable> comptecomptablesClone = new ArrayList();
	 	 	 comptecomptables.forEach((comptecomptable)->{comptecomptablesClone.add(clone(comptecomptable));
});return comptecomptablesClone;
}
}
 @Override 
 public List< CompteComptable>  findByCriteria(String code,String libelle,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(code,libelle,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String code,String libelle,Long idMin,Long idMax){
String query = "SELECT c FROM CompteComptable c where 1=1 ";
query += SearchUtil.addConstraint( "c", "code","=",code);
query += SearchUtil.addConstraint( "c", "libelle","=",libelle);
query += SearchUtil.addConstraintMinMax("c", "id", idMin, idMax);

  return query; 
}
}
