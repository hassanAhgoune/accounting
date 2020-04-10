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
import com.zsmart.accountingProject.service.facade.FournisseurService;
import com.zsmart.accountingProject.bean.Fournisseur;
import com.zsmart.accountingProject.ws.rest.vo.FournisseurVo;
import com.zsmart.accountingProject.ws.rest.converter.FournisseurConverter;
import com.zsmart.accountingProject.service.util.* ;
@RestController
@RequestMapping("/accountingProject/Fournisseur")
@CrossOrigin(origins = {"http://localhost:4200"})
public class FournisseurRest {

 @Autowired 
 private FournisseurService fournisseurService;

 @Autowired 
private FournisseurConverter fournisseurConverter ;

@PostMapping("/")
public FournisseurVo save(@RequestBody FournisseurVo fournisseurVo){
Fournisseur fournisseur= fournisseurConverter.toItem(fournisseurVo);
return fournisseurConverter.toVo(fournisseurService.save(fournisseur));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
fournisseurService.deleteById(id);
}
@GetMapping("/")
public List<FournisseurVo> findAll(){
return fournisseurConverter.toVo(fournisseurService.findAll());
}

 public FournisseurConverter getFournisseurConverter(){
return fournisseurConverter;
}
 
 public void setFournisseurConverter(FournisseurConverter fournisseurConverter){
this.fournisseurConverter=fournisseurConverter;
}

 public FournisseurService getFournisseurService(){
return fournisseurService;
}
 
 public void setFournisseurService(FournisseurService fournisseurService){
this.fournisseurService=fournisseurService;
}

}