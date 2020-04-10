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
import com.zsmart.accountingProject.service.facade.OperationComptableService;
import com.zsmart.accountingProject.bean.OperationComptable;
import com.zsmart.accountingProject.ws.rest.vo.OperationComptableVo;
import com.zsmart.accountingProject.ws.rest.converter.OperationComptableConverter;
import com.zsmart.accountingProject.service.util.* ;
@RestController
@RequestMapping("/accountingProject/OperationComptable")
@CrossOrigin(origins = {"http://localhost:4200"})
public class OperationComptableRest {

 @Autowired 
 private OperationComptableService operationComptableService;

 @Autowired 
private OperationComptableConverter operationComptableConverter ;

@PostMapping("/")
public OperationComptableVo save(@RequestBody OperationComptableVo operationComptableVo){
OperationComptable operationComptable= operationComptableConverter.toItem(operationComptableVo);
return operationComptableConverter.toVo(operationComptableService.save(operationComptable));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
operationComptableService.deleteById(id);
}
@GetMapping("/")
public List<OperationComptableVo> findAll(){
return operationComptableConverter.toVo(operationComptableService.findAll());
}

 public OperationComptableConverter getOperationComptableConverter(){
return operationComptableConverter;
}
 
 public void setOperationComptableConverter(OperationComptableConverter operationComptableConverter){
this.operationComptableConverter=operationComptableConverter;
}

 public OperationComptableService getOperationComptableService(){
return operationComptableService;
}
 
 public void setOperationComptableService(OperationComptableService operationComptableService){
this.operationComptableService=operationComptableService;
}

}