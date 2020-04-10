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
import com.zsmart.accountingProject.service.facade.FactureService;
import com.zsmart.accountingProject.bean.Facture;
import com.zsmart.accountingProject.ws.rest.vo.FactureVo;
import com.zsmart.accountingProject.ws.rest.converter.FactureConverter;
import com.zsmart.accountingProject.service.util.* ;
@RestController
@RequestMapping("/accountingProject/Facture")
@CrossOrigin(origins = {"http://localhost:4200"})
public class FactureRest {

 @Autowired 
 private FactureService factureService;

 @Autowired 
private FactureConverter factureConverter ;

@PostMapping("/")
public FactureVo save(@RequestBody FactureVo factureVo){
Facture facture= factureConverter.toItem(factureVo);
return factureConverter.toVo(factureService.save(facture));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
factureService.deleteById(id);
}
@DeleteMapping("/{reference}")
public void  deleteByReference(@PathVariable String  reference){
factureService.deleteByReference(reference);
}
@GetMapping("/")
public List<FactureVo> findAll(){
return factureConverter.toVo(factureService.findAll());
}

 public FactureConverter getFactureConverter(){
return factureConverter;
}
 
 public void setFactureConverter(FactureConverter factureConverter){
this.factureConverter=factureConverter;
}

 public FactureService getFactureService(){
return factureService;
}
 
 public void setFactureService(FactureService factureService){
this.factureService=factureService;
}

}