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
import com.zsmart.accountingProject.service.facade.CpcService;
import com.zsmart.accountingProject.bean.Cpc;
import com.zsmart.accountingProject.ws.rest.vo.CpcVo;
import com.zsmart.accountingProject.ws.rest.converter.CpcConverter;
import com.zsmart.accountingProject.service.util.* ;
@RestController
@RequestMapping("/accountingProject/Cpc")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CpcRest {

 @Autowired 
 private CpcService cpcService;

 @Autowired 
private CpcConverter cpcConverter ;

@PostMapping("/")
public CpcVo save(@RequestBody CpcVo cpcVo){
Cpc cpc= cpcConverter.toItem(cpcVo);
return cpcConverter.toVo(cpcService.save(cpc));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
cpcService.deleteById(id);
}
@GetMapping("/")
public List<CpcVo> findAll(){
return cpcConverter.toVo(cpcService.findAll());
}

 public CpcConverter getCpcConverter(){
return cpcConverter;
}
 
 public void setCpcConverter(CpcConverter cpcConverter){
this.cpcConverter=cpcConverter;
}

 public CpcService getCpcService(){
return cpcService;
}
 
 public void setCpcService(CpcService cpcService){
this.cpcService=cpcService;
}

}