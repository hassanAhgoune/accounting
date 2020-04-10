
package com.zsmart.accountingProject.service.impl ;
import com.zsmart.accountingProject.service.facade.EtatFactureService ; 
import com.zsmart.accountingProject.dao.EtatFactureDao ;
import com.zsmart.accountingProject.service.util.SearchUtil;
import com.zsmart.accountingProject.bean.EtatFacture;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.zsmart.accountingProject.service.facade.FactureService ; 
import com.zsmart.accountingProject.bean.Facture ; 

 @Service  

 public class EtatFactureServiceImpl implements EtatFactureService  {


 @Autowired 

 private EtatFactureDao etatfactureDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private FactureService factureService; 

 @Override 
public EtatFacture  save (EtatFacture etatfacture){

if(etatfacture== null){ 
 return null; 
}else {
 etatfactureDao.save(etatfacture);
return etatfacture;
}
}

 @Override 
public EtatFacture  saveWithFactures (EtatFacture etatfacture){

if(etatfacture== null){ 
        return null; 
}else {
   if(etatfacture.getFactures().isEmpty()){
            return null;
        }else{
etatfactureDao.save(etatfacture);
            for (Facture facture : etatfacture.getFactures()) {
facture.setEtatFacture(etatfacture);
 factureService.save(  facture);          
            }
return etatfacture;
}
}
            }

 @Override 
public List< EtatFacture>  findAll(){
 return etatfactureDao.findAll();
}

 @Override 
public EtatFacture findById(Long id){
 return etatfactureDao.getOne(id);
}

 @Override 
public int delete(EtatFacture etatfacture){
if(etatfacture== null){ 
  return -1; 
}else {
 etatfactureDao.delete(etatfacture);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       etatfactureDao.deleteById(id);
}
public void clone(EtatFacture etatfacture,EtatFacture etatfactureClone){
if(etatfacture!= null && etatfactureClone != null){
etatfactureClone.setId(etatfacture.getId());
etatfactureClone.setLibelle(etatfacture.getLibelle());
etatfactureClone.setCode(etatfacture.getCode());
etatfactureClone.setFactures(factureService.clone(etatfacture.getFactures()));
}
}
public EtatFacture clone(EtatFacture etatfacture){
if(etatfacture== null){       return null ;
}else{EtatFacture etatfactureClone= new EtatFacture();
 clone(etatfacture,etatfactureClone);
return etatfactureClone;
}
}
public List<EtatFacture> clone(List<EtatFacture>etatfactures){
if(etatfactures== null){
       return null ;
}else{List<EtatFacture> etatfacturesClone = new ArrayList();
	 	 	 etatfactures.forEach((etatfacture)->{etatfacturesClone.add(clone(etatfacture));
});return etatfacturesClone;
}
}
 @Override 
 public List< EtatFacture>  findByCriteria(String libelle,String code,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(libelle,code,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String libelle,String code,Long idMin,Long idMax){
String query = "SELECT e FROM EtatFacture e where 1=1 ";
query += SearchUtil.addConstraint( "e", "libelle","=",libelle);
query += SearchUtil.addConstraint( "e", "code","=",code);
query += SearchUtil.addConstraintMinMax("e", "id", idMin, idMax);

  return query; 
}
}
