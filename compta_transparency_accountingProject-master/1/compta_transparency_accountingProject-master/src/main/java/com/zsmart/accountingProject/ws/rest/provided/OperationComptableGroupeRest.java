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
import com.zsmart.accountingProject.service.facade.OperationComptableGroupeService;
import com.zsmart.accountingProject.bean.OperationComptableGroupe;
import com.zsmart.accountingProject.ws.rest.vo.OperationComptableGroupeVo;
import com.zsmart.accountingProject.ws.rest.converter.OperationComptableGroupeConverter;
import com.zsmart.accountingProject.service.util.* ;
@RestController
@RequestMapping("/accountingProject/OperationComptableGroupe")
@CrossOrigin(origins = {"http://localhost:4200"})
public class OperationComptableGroupeRest {

 @Autowired 
 private OperationComptableGroupeService operationComptableGroupeService;

 @Autowired 
private OperationComptableGroupeConverter operationComptableGroupeConverter ;

@PostMapping("/")
public OperationComptableGroupeVo save(@RequestBody OperationComptableGroupeVo operationComptableGroupeVo){
OperationComptableGroupe operationComptableGroupe= operationComptableGroupeConverter.toItem(operationComptableGroupeVo);
return operationComptableGroupeConverter.toVo(operationComptableGroupeService.save(operationComptableGroupe));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
operationComptableGroupeService.deleteById(id);
}
@GetMapping("/")
public List<OperationComptableGroupeVo> findAll(){
return operationComptableGroupeConverter.toVo(operationComptableGroupeService.findAll());
}

 public OperationComptableGroupeConverter getOperationComptableGroupeConverter(){
return operationComptableGroupeConverter;
}
 
 public void setOperationComptableGroupeConverter(OperationComptableGroupeConverter operationComptableGroupeConverter){
this.operationComptableGroupeConverter=operationComptableGroupeConverter;
}

 public OperationComptableGroupeService getOperationComptableGroupeService(){
return operationComptableGroupeService;
}
 
 public void setOperationComptableGroupeService(OperationComptableGroupeService operationComptableGroupeService){
this.operationComptableGroupeService=operationComptableGroupeService;
}

}