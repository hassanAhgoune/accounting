
package com.zsmart.accountingProject.service.impl ;
import com.zsmart.accountingProject.service.facade.TypePaiementService ; 
import com.zsmart.accountingProject.dao.TypePaiementDao ;
import com.zsmart.accountingProject.service.util.SearchUtil;
import com.zsmart.accountingProject.bean.TypePaiement;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.zsmart.accountingProject.service.facade.PaiementFactureService ; 
import com.zsmart.accountingProject.bean.PaiementFacture ; 

 @Service  

 public class TypePaiementServiceImpl implements TypePaiementService  {


 @Autowired 

 private TypePaiementDao typepaiementDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private PaiementFactureService paiementfactureService; 

 @Override 
public TypePaiement  save (TypePaiement typepaiement){

if(typepaiement== null){ 
 return null; 
}else {
 typepaiementDao.save(typepaiement);
return typepaiement;
}
}

 @Override 
public TypePaiement  saveWithPaiementFactures (TypePaiement typepaiement){

if(typepaiement== null){ 
        return null; 
}else {
   if(typepaiement.getPaiementFactures().isEmpty()){
            return null;
        }else{
typepaiementDao.save(typepaiement);
            for (PaiementFacture paiementfacture : typepaiement.getPaiementFactures()) {
paiementfacture.setTypePaiment(typepaiement);
 paiementfactureService.save(  paiementfacture);          
            }
return typepaiement;
}
}
            }

 @Override 
public List< TypePaiement>  findAll(){
 return typepaiementDao.findAll();
}

 @Override 
public TypePaiement findById(Long id){
 return typepaiementDao.getOne(id);
}

 @Override 
public int delete(TypePaiement typepaiement){
if(typepaiement== null){ 
  return -1; 
}else {
 typepaiementDao.delete(typepaiement);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       typepaiementDao.deleteById(id);
}
public void clone(TypePaiement typepaiement,TypePaiement typepaiementClone){
if(typepaiement!= null && typepaiementClone != null){
typepaiementClone.setId(typepaiement.getId());
typepaiementClone.setLibelle(typepaiement.getLibelle());
typepaiementClone.setCode(typepaiement.getCode());
typepaiementClone.setPaiementFactures(paiementfactureService.clone(typepaiement.getPaiementFactures()));
}
}
public TypePaiement clone(TypePaiement typepaiement){
if(typepaiement== null){       return null ;
}else{TypePaiement typepaiementClone= new TypePaiement();
 clone(typepaiement,typepaiementClone);
return typepaiementClone;
}
}
public List<TypePaiement> clone(List<TypePaiement>typepaiements){
if(typepaiements== null){
       return null ;
}else{List<TypePaiement> typepaiementsClone = new ArrayList();
	 	 	 typepaiements.forEach((typepaiement)->{typepaiementsClone.add(clone(typepaiement));
});return typepaiementsClone;
}
}
 @Override 
 public List< TypePaiement>  findByCriteria(String libelle,String code,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(libelle,code,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String libelle,String code,Long idMin,Long idMax){
String query = "SELECT t FROM TypePaiement t where 1=1 ";
query += SearchUtil.addConstraint( "t", "libelle","=",libelle);
query += SearchUtil.addConstraint( "t", "code","=",code);
query += SearchUtil.addConstraintMinMax("t", "id", idMin, idMax);

  return query; 
}
}
