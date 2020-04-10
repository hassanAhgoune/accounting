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
import com.zsmart.accountingProject.service.facade.CpcSousClasseService;
import com.zsmart.accountingProject.bean.CpcSousClasse;
import com.zsmart.accountingProject.ws.rest.vo.CpcSousClasseVo;
import com.zsmart.accountingProject.ws.rest.converter.CpcSousClasseConverter;
import com.zsmart.accountingProject.service.util.* ;
@RestController
@RequestMapping("/accountingProject/CpcSousClasse")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CpcSousClasseRest {

 @Autowired 
 private CpcSousClasseService cpcSousClasseService;

 @Autowired 
private CpcSousClasseConverter cpcSousClasseConverter ;

@PostMapping("/")
public CpcSousClasseVo save(@RequestBody CpcSousClasseVo cpcSousClasseVo){
CpcSousClasse cpcSousClasse= cpcSousClasseConverter.toItem(cpcSousClasseVo);
return cpcSousClasseConverter.toVo(cpcSousClasseService.save(cpcSousClasse));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
cpcSousClasseService.deleteById(id);
}
@GetMapping("/")
public List<CpcSousClasseVo> findAll(){
return cpcSousClasseConverter.toVo(cpcSousClasseService.findAll());
}

 public CpcSousClasseConverter getCpcSousClasseConverter(){
return cpcSousClasseConverter;
}
 
 public void setCpcSousClasseConverter(CpcSousClasseConverter cpcSousClasseConverter){
this.cpcSousClasseConverter=cpcSousClasseConverter;
}

 public CpcSousClasseService getCpcSousClasseService(){
return cpcSousClasseService;
}
 
 public void setCpcSousClasseService(CpcSousClasseService cpcSousClasseService){
this.cpcSousClasseService=cpcSousClasseService;
}

}