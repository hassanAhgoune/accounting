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
import com.zsmart.accountingProject.service.facade.FactureItemService;
import com.zsmart.accountingProject.bean.FactureItem;
import com.zsmart.accountingProject.ws.rest.vo.FactureItemVo;
import com.zsmart.accountingProject.ws.rest.converter.FactureItemConverter;
import com.zsmart.accountingProject.service.util.* ;
@RestController
@RequestMapping("/accountingProject/FactureItem")
@CrossOrigin(origins = {"http://localhost:4200"})
public class FactureItemRest {

 @Autowired 
 private FactureItemService factureItemService;

 @Autowired 
private FactureItemConverter factureItemConverter ;

@PostMapping("/")
public FactureItemVo save(@RequestBody FactureItemVo factureItemVo){
FactureItem factureItem= factureItemConverter.toItem(factureItemVo);
return factureItemConverter.toVo(factureItemService.save(factureItem));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
factureItemService.deleteById(id);
}
@GetMapping("/")
public List<FactureItemVo> findAll(){
return factureItemConverter.toVo(factureItemService.findAll());
}

 public FactureItemConverter getFactureItemConverter(){
return factureItemConverter;
}
 
 public void setFactureItemConverter(FactureItemConverter factureItemConverter){
this.factureItemConverter=factureItemConverter;
}

 public FactureItemService getFactureItemService(){
return factureItemService;
}
 
 public void setFactureItemService(FactureItemService factureItemService){
this.factureItemService=factureItemService;
}

}