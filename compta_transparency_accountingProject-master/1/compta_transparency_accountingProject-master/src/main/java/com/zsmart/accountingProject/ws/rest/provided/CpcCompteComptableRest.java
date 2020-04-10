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
import com.zsmart.accountingProject.service.facade.CpcCompteComptableService;
import com.zsmart.accountingProject.bean.CpcCompteComptable;
import com.zsmart.accountingProject.ws.rest.vo.CpcCompteComptableVo;
import com.zsmart.accountingProject.ws.rest.converter.CpcCompteComptableConverter;
import com.zsmart.accountingProject.service.util.* ;
@RestController
@RequestMapping("/accountingProject/CpcCompteComptable")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CpcCompteComptableRest {

 @Autowired 
 private CpcCompteComptableService cpcCompteComptableService;

 @Autowired 
private CpcCompteComptableConverter cpcCompteComptableConverter ;

@PostMapping("/")
public CpcCompteComptableVo save(@RequestBody CpcCompteComptableVo cpcCompteComptableVo){
CpcCompteComptable cpcCompteComptable= cpcCompteComptableConverter.toItem(cpcCompteComptableVo);
return cpcCompteComptableConverter.toVo(cpcCompteComptableService.save(cpcCompteComptable));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
cpcCompteComptableService.deleteById(id);
}
@GetMapping("/")
public List<CpcCompteComptableVo> findAll(){
return cpcCompteComptableConverter.toVo(cpcCompteComptableService.findAll());
}

 public CpcCompteComptableConverter getCpcCompteComptableConverter(){
return cpcCompteComptableConverter;
}
 
 public void setCpcCompteComptableConverter(CpcCompteComptableConverter cpcCompteComptableConverter){
this.cpcCompteComptableConverter=cpcCompteComptableConverter;
}

 public CpcCompteComptableService getCpcCompteComptableService(){
return cpcCompteComptableService;
}
 
 public void setCpcCompteComptableService(CpcCompteComptableService cpcCompteComptableService){
this.cpcCompteComptableService=cpcCompteComptableService;
}

}