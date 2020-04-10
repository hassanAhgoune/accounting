
package com.zsmart.accountingProject.service.impl ;
import com.zsmart.accountingProject.service.facade.CpcSousClasseService ; 
import com.zsmart.accountingProject.dao.CpcSousClasseDao ;
import com.zsmart.accountingProject.service.util.SearchUtil;
import com.zsmart.accountingProject.bean.CpcSousClasse;
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
import com.zsmart.accountingProject.bean.Cpc; 
import com.zsmart.accountingProject.service.facade.CpcService ; 
import com.zsmart.accountingProject.service.facade.CpcCompteComptableService ; 
import com.zsmart.accountingProject.bean.CpcCompteComptable ; 

 @Service  

 public class CpcSousClasseServiceImpl implements CpcSousClasseService  {


 @Autowired 

 private CpcSousClasseDao cpcsousclasseDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private CpcCompteComptableService cpccomptecomptableService; 

 @Autowired 

 private SousClasseComptableService sousclassecomptableService; 

 @Autowired 

 private CpcService cpcService; 

 @Override 
public CpcSousClasse  save (CpcSousClasse cpcsousclasse){

if(cpcsousclasse== null){ 
 return null; 
}else {
 cpcsousclasseDao.save(cpcsousclasse);
return cpcsousclasse;
}
}

 @Override 
public CpcSousClasse  saveWithCpcCompteComptables (CpcSousClasse cpcsousclasse){

if(cpcsousclasse== null){ 
        return null; 
}else {
   if(cpcsousclasse.getCpcCompteComptables().isEmpty()){
            return null;
        }else{
cpcsousclasseDao.save(cpcsousclasse);
            for (CpcCompteComptable cpccomptecomptable : cpcsousclasse.getCpcCompteComptables()) {
cpccomptecomptable.setCpcSousClasse(cpcsousclasse);
 cpccomptecomptableService.save(  cpccomptecomptable);          
            }
return cpcsousclasse;
}
}
            }

 @Override 
public List< CpcSousClasse>  findAll(){
 return cpcsousclasseDao.findAll();
}

 @Override 
public CpcSousClasse findById(Long id){
 return cpcsousclasseDao.getOne(id);
}

 @Override 
public int delete(CpcSousClasse cpcsousclasse){
if(cpcsousclasse== null){ 
  return -1; 
}else {
 cpcsousclasseDao.delete(cpcsousclasse);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       cpcsousclasseDao.deleteById(id);
}
public void clone(CpcSousClasse cpcsousclasse,CpcSousClasse cpcsousclasseClone){
if(cpcsousclasse!= null && cpcsousclasseClone != null){
cpcsousclasseClone.setId(cpcsousclasse.getId());
cpcsousclasseClone.setMontant(cpcsousclasse.getMontant());
cpcsousclasseClone.setSousClasseComptable(sousclassecomptableService.clone(cpcsousclasse.getSousClasseComptable()));
cpcsousclasseClone.setCpc(cpcService.clone(cpcsousclasse.getCpc()));
cpcsousclasseClone.setCpcCompteComptables(cpccomptecomptableService.clone(cpcsousclasse.getCpcCompteComptables()));
}
}
public CpcSousClasse clone(CpcSousClasse cpcsousclasse){
if(cpcsousclasse== null){       return null ;
}else{CpcSousClasse cpcsousclasseClone= new CpcSousClasse();
 clone(cpcsousclasse,cpcsousclasseClone);
return cpcsousclasseClone;
}
}
public List<CpcSousClasse> clone(List<CpcSousClasse>cpcsousclasses){
if(cpcsousclasses== null){
       return null ;
}else{List<CpcSousClasse> cpcsousclassesClone = new ArrayList();
	 	 	 cpcsousclasses.forEach((cpcsousclasse)->{cpcsousclassesClone.add(clone(cpcsousclasse));
});return cpcsousclassesClone;
}
}
 @Override 
 public List< CpcSousClasse>  findByCriteria(Long idMin,Long idMax,BigDecimal montantMin,BigDecimal montantMax){
 return entityManager.createQuery(constructQuery(idMin,idMax,montantMin,montantMax)).getResultList(); 
 }
private String constructQuery(Long idMin,Long idMax,BigDecimal montantMin,BigDecimal montantMax){
String query = "SELECT c FROM CpcSousClasse c where 1=1 ";
query += SearchUtil.addConstraintMinMax("c", "id", idMin, idMax);
query += SearchUtil.addConstraintMinMax("c", "montant", montantMin, montantMax);

  return query; 
}
}
