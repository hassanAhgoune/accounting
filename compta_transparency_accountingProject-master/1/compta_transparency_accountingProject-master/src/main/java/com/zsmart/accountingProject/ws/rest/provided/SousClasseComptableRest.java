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
import com.zsmart.accountingProject.service.facade.SousClasseComptableService;
import com.zsmart.accountingProject.bean.SousClasseComptable;
import com.zsmart.accountingProject.ws.rest.vo.SousClasseComptableVo;
import com.zsmart.accountingProject.ws.rest.converter.SousClasseComptableConverter;
import com.zsmart.accountingProject.service.util.* ;
@RestController
@RequestMapping("/accountingProject/SousClasseComptable")
@CrossOrigin(origins = {"http://localhost:4200"})
public class SousClasseComptableRest {

 @Autowired 
 private SousClasseComptableService sousClasseComptableService;

 @Autowired 
private SousClasseComptableConverter sousClasseComptableConverter ;

@PostMapping("/")
public SousClasseComptableVo save(@RequestBody SousClasseComptableVo sousClasseComptableVo){
SousClasseComptable sousClasseComptable= sousClasseComptableConverter.toItem(sousClasseComptableVo);
return sousClasseComptableConverter.toVo(sousClasseComptableService.save(sousClasseComptable));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
sousClasseComptableService.deleteById(id);
}
@GetMapping("/")
public List<SousClasseComptableVo> findAll(){
return sousClasseComptableConverter.toVo(sousClasseComptableService.findAll());
}

 public SousClasseComptableConverter getSousClasseComptableConverter(){
return sousClasseComptableConverter;
}
 
 public void setSousClasseComptableConverter(SousClasseComptableConverter sousClasseComptableConverter){
this.sousClasseComptableConverter=sousClasseComptableConverter;
}

 public SousClasseComptableService getSousClasseComptableService(){
return sousClasseComptableService;
}
 
 public void setSousClasseComptableService(SousClasseComptableService sousClasseComptableService){
this.sousClasseComptableService=sousClasseComptableService;
}

}