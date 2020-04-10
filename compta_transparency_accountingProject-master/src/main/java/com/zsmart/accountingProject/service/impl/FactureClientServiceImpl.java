
package com.zsmart.accountingProject.service.impl ;
import com.zsmart.accountingProject.service.facade.FactureClientService ; 
import com.zsmart.accountingProject.dao.FactureClientDao ;
import com.zsmart.accountingProject.service.util.SearchUtil;
import com.zsmart.accountingProject.bean.FactureClient;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.zsmart.accountingProject.bean.Client; 
import com.zsmart.accountingProject.service.facade.ClientService ; 

 @Service  

 public class FactureClientServiceImpl implements FactureClientService  {


 @Autowired 

 private FactureClientDao factureclientDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private ClientService clientService; 

 @Override 
public FactureClient  save (FactureClient factureclient){

if(factureclient== null){ 
 return null; 
}else {
 factureclientDao.save(factureclient);
return factureclient;
}
}

 @Override 
public List< FactureClient>  findAll(){
 return factureclientDao.findAll();
}

 @Override 
public FactureClient findById(Long id){
 return factureclientDao.getOne(id);
}

 @Override 
public int delete(FactureClient factureclient){
if(factureclient== null){ 
  return -1; 
}else {
 factureclientDao.delete(factureclient);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       factureclientDao.deleteById(id);
}
public void clone(FactureClient factureclient,FactureClient factureclientClone){
if(factureclient!= null && factureclientClone != null){
factureclientClone.setId(factureclient.getId());
factureclientClone.setClient(clientService.clone(factureclient.getClient()));
}
}
public FactureClient clone(FactureClient factureclient){
if(factureclient== null){       return null ;
}else{FactureClient factureclientClone= new FactureClient();
 clone(factureclient,factureclientClone);
return factureclientClone;
}
}
public List<FactureClient> clone(List<FactureClient>factureclients){
if(factureclients== null){
       return null ;
}else{List<FactureClient> factureclientsClone = new ArrayList();
	 	 	 factureclients.forEach((factureclient)->{factureclientsClone.add(clone(factureclient));
});return factureclientsClone;
}
}
 @Override 
 public List< FactureClient>  findByCriteria(Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(idMin,idMax)).getResultList(); 
 }
private String constructQuery(Long idMin,Long idMax){
String query = "SELECT f FROM FactureClient f where 1=1 ";
query += SearchUtil.addConstraintMinMax("f", "id", idMin, idMax);

  return query; 
}
}
