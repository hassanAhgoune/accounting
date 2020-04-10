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
import com.zsmart.accountingProject.service.facade.EtatFactureService;
import com.zsmart.accountingProject.bean.EtatFacture;
import com.zsmart.accountingProject.ws.rest.vo.EtatFactureVo;
import com.zsmart.accountingProject.ws.rest.converter.EtatFactureConverter;
import com.zsmart.accountingProject.service.util.* ;
@RestController
@RequestMapping("/accountingProject/EtatFacture")
@CrossOrigin(origins = {"http://localhost:4200"})
public class EtatFactureRest {

 @Autowired 
 private EtatFactureService etatFactureService;

 @Autowired 
private EtatFactureConverter etatFactureConverter ;

@PostMapping("/")
public EtatFactureVo save(@RequestBody EtatFactureVo etatFactureVo){
EtatFacture etatFacture= etatFactureConverter.toItem(etatFactureVo);
return etatFactureConverter.toVo(etatFactureService.save(etatFacture));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
etatFactureService.deleteById(id);
}
@GetMapping("/")
public List<EtatFactureVo> findAll(){
return etatFactureConverter.toVo(etatFactureService.findAll());
}

 public EtatFactureConverter getEtatFactureConverter(){
return etatFactureConverter;
}
 
 public void setEtatFactureConverter(EtatFactureConverter etatFactureConverter){
this.etatFactureConverter=etatFactureConverter;
}

 public EtatFactureService getEtatFactureService(){
return etatFactureService;
}
 
 public void setEtatFactureService(EtatFactureService etatFactureService){
this.etatFactureService=etatFactureService;
}

}