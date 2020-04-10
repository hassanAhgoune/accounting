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
import com.zsmart.accountingProject.service.facade.CompteComptableService;
import com.zsmart.accountingProject.bean.CompteComptable;
import com.zsmart.accountingProject.ws.rest.vo.CompteComptableVo;
import com.zsmart.accountingProject.ws.rest.converter.CompteComptableConverter;
import com.zsmart.accountingProject.service.util.* ;
@RestController
@RequestMapping("/accountingProject/CompteComptable")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CompteComptableRest {

 @Autowired 
 private CompteComptableService compteComptableService;

 @Autowired 
private CompteComptableConverter compteComptableConverter ;

@PostMapping("/")
public CompteComptableVo save(@RequestBody CompteComptableVo compteComptableVo){
CompteComptable compteComptable= compteComptableConverter.toItem(compteComptableVo);
return compteComptableConverter.toVo(compteComptableService.save(compteComptable));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
compteComptableService.deleteById(id);
}
@GetMapping("/")
public List<CompteComptableVo> findAll(){
return compteComptableConverter.toVo(compteComptableService.findAll());
}

 public CompteComptableConverter getCompteComptableConverter(){
return compteComptableConverter;
}
 
 public void setCompteComptableConverter(CompteComptableConverter compteComptableConverter){
this.compteComptableConverter=compteComptableConverter;
}

 public CompteComptableService getCompteComptableService(){
return compteComptableService;
}
 
 public void setCompteComptableService(CompteComptableService compteComptableService){
this.compteComptableService=compteComptableService;
}

}