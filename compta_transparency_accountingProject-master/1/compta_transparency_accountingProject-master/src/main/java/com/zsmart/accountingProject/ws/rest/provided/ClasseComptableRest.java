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
import com.zsmart.accountingProject.service.facade.ClasseComptableService;
import com.zsmart.accountingProject.bean.ClasseComptable;
import com.zsmart.accountingProject.ws.rest.vo.ClasseComptableVo;
import com.zsmart.accountingProject.ws.rest.converter.ClasseComptableConverter;
import com.zsmart.accountingProject.service.util.* ;
@RestController
@RequestMapping("/accountingProject/ClasseComptable")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ClasseComptableRest {

 @Autowired 
 private ClasseComptableService classeComptableService;

 @Autowired 
private ClasseComptableConverter classeComptableConverter ;

@PostMapping("/")
public ClasseComptableVo save(@RequestBody ClasseComptableVo classeComptableVo){
ClasseComptable classeComptable= classeComptableConverter.toItem(classeComptableVo);
return classeComptableConverter.toVo(classeComptableService.save(classeComptable));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
classeComptableService.deleteById(id);
}
@GetMapping("/")
public List<ClasseComptableVo> findAll(){
return classeComptableConverter.toVo(classeComptableService.findAll());
}

 public ClasseComptableConverter getClasseComptableConverter(){
return classeComptableConverter;
}
 
 public void setClasseComptableConverter(ClasseComptableConverter classeComptableConverter){
this.classeComptableConverter=classeComptableConverter;
}

 public ClasseComptableService getClasseComptableService(){
return classeComptableService;
}
 
 public void setClasseComptableService(ClasseComptableService classeComptableService){
this.classeComptableService=classeComptableService;
}

}