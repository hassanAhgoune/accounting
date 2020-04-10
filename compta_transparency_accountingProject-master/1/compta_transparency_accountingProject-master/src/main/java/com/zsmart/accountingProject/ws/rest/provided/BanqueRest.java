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
import com.zsmart.accountingProject.service.facade.BanqueService;
import com.zsmart.accountingProject.bean.Banque;
import com.zsmart.accountingProject.ws.rest.vo.BanqueVo;
import com.zsmart.accountingProject.ws.rest.converter.BanqueConverter;
import com.zsmart.accountingProject.service.util.* ;
@RestController
@RequestMapping("/accountingProject/Banque")
@CrossOrigin(origins = {"http://localhost:4200"})
public class BanqueRest {

 @Autowired 
 private BanqueService banqueService;

 @Autowired 
private BanqueConverter banqueConverter ;

@PostMapping("/")
public BanqueVo save(@RequestBody BanqueVo banqueVo){
Banque banque= banqueConverter.toItem(banqueVo);
return banqueConverter.toVo(banqueService.save(banque));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
banqueService.deleteById(id);
}
@GetMapping("/")
public List<BanqueVo> findAll(){
return banqueConverter.toVo(banqueService.findAll());
}

 public BanqueConverter getBanqueConverter(){
return banqueConverter;
}
 
 public void setBanqueConverter(BanqueConverter banqueConverter){
this.banqueConverter=banqueConverter;
}

 public BanqueService getBanqueService(){
return banqueService;
}
 
 public void setBanqueService(BanqueService banqueService){
this.banqueService=banqueService;
}

}