package com.zsmart.accountingProject.ws.rest.provided ;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.zsmart.accountingProject.service.facade.TypePaiementService;
import com.zsmart.accountingProject.bean.TypePaiement;
import com.zsmart.accountingProject.ws.rest.vo.TypePaiementVo;
import com.zsmart.accountingProject.ws.rest.converter.TypePaiementConverter;
import com.zsmart.accountingProject.service.util.* ;
@RestController
@RequestMapping("/accountingProject/TypePaiement")
@CrossOrigin(origins = {"http://localhost:4200"})
public class TypePaiementRest {

 @Autowired 
 private TypePaiementService typePaiementService;

 @Autowired 
private TypePaiementConverter typePaiementConverter ;

@PostMapping("/")
public TypePaiementVo save(@RequestBody TypePaiementVo typePaiementVo){
TypePaiement typePaiement= typePaiementConverter.toItem(typePaiementVo);
return typePaiementConverter.toVo(typePaiementService.save(typePaiement));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
typePaiementService.deleteById(id);
}
@GetMapping("/")
public List<TypePaiementVo> findAll(){
return typePaiementConverter.toVo(typePaiementService.findAll());
}

 public TypePaiementConverter getTypePaiementConverter(){
return typePaiementConverter;
}
 
 public void setTypePaiementConverter(TypePaiementConverter typePaiementConverter){
this.typePaiementConverter=typePaiementConverter;
}

 public TypePaiementService getTypePaiementService(){
return typePaiementService;
}
 
 public void setTypePaiementService(TypePaiementService typePaiementService){
this.typePaiementService=typePaiementService;
}

}