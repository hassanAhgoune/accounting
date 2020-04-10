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
import com.zsmart.accountingProject.service.facade.PaiementFactureService;
import com.zsmart.accountingProject.bean.PaiementFacture;
import com.zsmart.accountingProject.ws.rest.vo.PaiementFactureVo;
import com.zsmart.accountingProject.ws.rest.converter.PaiementFactureConverter;
import com.zsmart.accountingProject.service.util.* ;
@RestController
@RequestMapping("/accountingProject/PaiementFacture")
@CrossOrigin(origins = {"http://localhost:4200"})
public class PaiementFactureRest {

 @Autowired 
 private PaiementFactureService paiementFactureService;

 @Autowired 
private PaiementFactureConverter paiementFactureConverter ;

@PostMapping("/")
public PaiementFactureVo save(@RequestBody PaiementFactureVo paiementFactureVo){
PaiementFacture paiementFacture= paiementFactureConverter.toItem(paiementFactureVo);
return paiementFactureConverter.toVo(paiementFactureService.save(paiementFacture));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
paiementFactureService.deleteById(id);
}
@GetMapping("/")
public List<PaiementFactureVo> findAll(){
return paiementFactureConverter.toVo(paiementFactureService.findAll());
}

 public PaiementFactureConverter getPaiementFactureConverter(){
return paiementFactureConverter;
}
 
 public void setPaiementFactureConverter(PaiementFactureConverter paiementFactureConverter){
this.paiementFactureConverter=paiementFactureConverter;
}

 public PaiementFactureService getPaiementFactureService(){
return paiementFactureService;
}
 
 public void setPaiementFactureService(PaiementFactureService paiementFactureService){
this.paiementFactureService=paiementFactureService;
}

}