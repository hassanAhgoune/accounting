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
import com.zsmart.accountingProject.service.facade.CaisseService;
import com.zsmart.accountingProject.bean.Caisse;
import com.zsmart.accountingProject.ws.rest.vo.CaisseVo;
import com.zsmart.accountingProject.ws.rest.converter.CaisseConverter;
import com.zsmart.accountingProject.service.util.* ;
@RestController
@RequestMapping("/accountingProject/Caisse")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CaisseRest {

 @Autowired 
 private CaisseService caisseService;

 @Autowired 
private CaisseConverter caisseConverter ;

@PostMapping("/")
public CaisseVo save(@RequestBody CaisseVo caisseVo){
Caisse caisse= caisseConverter.toItem(caisseVo);
return caisseConverter.toVo(caisseService.save(caisse));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
caisseService.deleteById(id);
}
@GetMapping("/")
public List<CaisseVo> findAll(){
return caisseConverter.toVo(caisseService.findAll());
}

 public CaisseConverter getCaisseConverter(){
return caisseConverter;
}
 
 public void setCaisseConverter(CaisseConverter caisseConverter){
this.caisseConverter=caisseConverter;
}

 public CaisseService getCaisseService(){
return caisseService;
}
 
 public void setCaisseService(CaisseService caisseService){
this.caisseService=caisseService;
}

}