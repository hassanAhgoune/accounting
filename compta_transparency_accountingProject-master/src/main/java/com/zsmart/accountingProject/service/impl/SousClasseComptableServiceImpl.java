
package com.zsmart.accountingProject.service.impl ;
import com.zsmart.accountingProject.service.facade.SousClasseComptableService ; 
import com.zsmart.accountingProject.dao.SousClasseComptableDao ;
import com.zsmart.accountingProject.service.util.SearchUtil;
import com.zsmart.accountingProject.bean.SousClasseComptable;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.zsmart.accountingProject.bean.ClasseComptable; 
import com.zsmart.accountingProject.service.facade.ClasseComptableService ; 
import com.zsmart.accountingProject.service.facade.CompteComptableService ; 
import com.zsmart.accountingProject.bean.CompteComptable ; 

 @Service  

 public class SousClasseComptableServiceImpl implements SousClasseComptableService  {


 @Autowired 

 private SousClasseComptableDao sousclassecomptableDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private CompteComptableService comptecomptableService; 

 @Autowired 

 private ClasseComptableService classecomptableService; 

 @Override 
public SousClasseComptable  save (SousClasseComptable sousclassecomptable){

if(sousclassecomptable== null){ 
 return null; 
}else {
 sousclassecomptableDao.save(sousclassecomptable);
return sousclassecomptable;
}
}

 @Override 
public SousClasseComptable  saveWithCompteComptables (SousClasseComptable sousclassecomptable){

if(sousclassecomptable== null){ 
        return null; 
}else {
   if(sousclassecomptable.getCompteComptables().isEmpty()){
            return null;
        }else{
sousclassecomptableDao.save(sousclassecomptable);
            for (CompteComptable comptecomptable : sousclassecomptable.getCompteComptables()) {
comptecomptable.setSousClasseComptable(sousclassecomptable);
 comptecomptableService.save(  comptecomptable);          
            }
return sousclassecomptable;
}
}
            }

 @Override 
public List< SousClasseComptable>  findAll(){
 return sousclassecomptableDao.findAll();
}

 @Override 
public SousClasseComptable findById(Long id){
 return sousclassecomptableDao.getOne(id);
}

 @Override 
public int delete(SousClasseComptable sousclassecomptable){
if(sousclassecomptable== null){ 
  return -1; 
}else {
 sousclassecomptableDao.delete(sousclassecomptable);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       sousclassecomptableDao.deleteById(id);
}
public void clone(SousClasseComptable sousclassecomptable,SousClasseComptable sousclassecomptableClone){
if(sousclassecomptable!= null && sousclassecomptableClone != null){
sousclassecomptableClone.setId(sousclassecomptable.getId());
sousclassecomptableClone.setNumero(sousclassecomptable.getNumero());
sousclassecomptableClone.setLibelle(sousclassecomptable.getLibelle());
sousclassecomptableClone.setClasseComptable(classecomptableService.clone(sousclassecomptable.getClasseComptable()));
sousclassecomptableClone.setCompteComptables(comptecomptableService.clone(sousclassecomptable.getCompteComptables()));
}
}
public SousClasseComptable clone(SousClasseComptable sousclassecomptable){
if(sousclassecomptable== null){       return null ;
}else{SousClasseComptable sousclassecomptableClone= new SousClasseComptable();
 clone(sousclassecomptable,sousclassecomptableClone);
return sousclassecomptableClone;
}
}
public List<SousClasseComptable> clone(List<SousClasseComptable>sousclassecomptables){
if(sousclassecomptables== null){
       return null ;
}else{List<SousClasseComptable> sousclassecomptablesClone = new ArrayList();
	 	 	 sousclassecomptables.forEach((sousclassecomptable)->{sousclassecomptablesClone.add(clone(sousclassecomptable));
});return sousclassecomptablesClone;
}
}
 @Override 
 public List< SousClasseComptable>  findByCriteria(String libelle,Long idMin,Long idMax,Integer numeroMin,Integer numeroMax){
 return entityManager.createQuery(constructQuery(libelle,idMin,idMax,numeroMin,numeroMax)).getResultList(); 
 }
private String constructQuery(String libelle,Long idMin,Long idMax,Integer numeroMin,Integer numeroMax){
String query = "SELECT s FROM SousClasseComptable s where 1=1 ";
query += SearchUtil.addConstraint( "s", "libelle","=",libelle);
query += SearchUtil.addConstraintMinMax("s", "id", idMin, idMax);
query += SearchUtil.addConstraintMinMax("s", "numero", numeroMin, numeroMax);

  return query; 
}
}
