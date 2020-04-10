
package com.zsmart.accountingProject.service.impl ;
import com.zsmart.accountingProject.service.facade.FournisseurService ; 
import com.zsmart.accountingProject.dao.FournisseurDao ;
import com.zsmart.accountingProject.service.util.SearchUtil;
import com.zsmart.accountingProject.bean.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.zsmart.accountingProject.service.facade.FactureFournisseurService ; 
import com.zsmart.accountingProject.bean.FactureFournisseur ; 

 @Service  

 public class FournisseurServiceImpl implements FournisseurService  {


 @Autowired 

 private FournisseurDao fournisseurDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private FactureFournisseurService facturefournisseurService; 

 @Override 
public Fournisseur  save (Fournisseur fournisseur){

if(fournisseur== null){ 
 return null; 
}else {
 fournisseurDao.save(fournisseur);
return fournisseur;
}
}

 @Override 
public Fournisseur  saveWithFactureFournisseurs (Fournisseur fournisseur){

if(fournisseur== null){ 
        return null; 
}else {
   if(fournisseur.getFactureFournisseurs().isEmpty()){
            return null;
        }else{
fournisseurDao.save(fournisseur);
            for (FactureFournisseur facturefournisseur : fournisseur.getFactureFournisseurs()) {
facturefournisseur.setFournisseur(fournisseur);
 facturefournisseurService.save(  facturefournisseur);          
            }
return fournisseur;
}
}
            }

 @Override 
public List< Fournisseur>  findAll(){
 return fournisseurDao.findAll();
}

 @Override 
public Fournisseur findById(Long id){
 return fournisseurDao.getOne(id);
}

 @Override 
public int delete(Fournisseur fournisseur){
if(fournisseur== null){ 
  return -1; 
}else {
 fournisseurDao.delete(fournisseur);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       fournisseurDao.deleteById(id);
}
public void clone(Fournisseur fournisseur,Fournisseur fournisseurClone){
if(fournisseur!= null && fournisseurClone != null){
fournisseurClone.setId(fournisseur.getId());
fournisseurClone.setIce(fournisseur.getIce());
fournisseurClone.setIdentifiantFiscale(fournisseur.getIdentifiantFiscale());
fournisseurClone.setRc(fournisseur.getRc());
fournisseurClone.setLibelle(fournisseur.getLibelle());
fournisseurClone.setCode(fournisseur.getCode());
fournisseurClone.setFactureFournisseurs(facturefournisseurService.clone(fournisseur.getFactureFournisseurs()));
}
}
public Fournisseur clone(Fournisseur fournisseur){
if(fournisseur== null){       return null ;
}else{Fournisseur fournisseurClone= new Fournisseur();
 clone(fournisseur,fournisseurClone);
return fournisseurClone;
}
}
public List<Fournisseur> clone(List<Fournisseur>fournisseurs){
if(fournisseurs== null){
       return null ;
}else{List<Fournisseur> fournisseursClone = new ArrayList();
	 	 	 fournisseurs.forEach((fournisseur)->{fournisseursClone.add(clone(fournisseur));
});return fournisseursClone;
}
}
 @Override 
 public List< Fournisseur>  findByCriteria(String ice,String identifiantFiscale,String rc,String libelle,String code,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(ice,identifiantFiscale,rc,libelle,code,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String ice,String identifiantFiscale,String rc,String libelle,String code,Long idMin,Long idMax){
String query = "SELECT f FROM Fournisseur f where 1=1 ";
query += SearchUtil.addConstraint( "f", "ice","=",ice);
query += SearchUtil.addConstraint( "f", "identifiantFiscale","=",identifiantFiscale);
query += SearchUtil.addConstraint( "f", "rc","=",rc);
query += SearchUtil.addConstraint( "f", "libelle","=",libelle);
query += SearchUtil.addConstraint( "f", "code","=",code);
query += SearchUtil.addConstraintMinMax("f", "id", idMin, idMax);

  return query; 
}
}
