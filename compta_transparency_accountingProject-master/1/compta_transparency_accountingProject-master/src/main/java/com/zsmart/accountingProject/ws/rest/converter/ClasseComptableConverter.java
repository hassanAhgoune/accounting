package com.zsmart.accountingProject.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.accountingProject.service.util.*;
import com.zsmart.accountingProject.bean.ClasseComptable; 
import com.zsmart.accountingProject.ws.rest.vo.ClasseComptableVo; 

 @Component 
public class ClasseComptableConverter extends AbstractConverter<ClasseComptable,ClasseComptableVo>{ 

private boolean sousClasseComptables; 

 @Autowired
 private SousClasseComptableConverter sousClasseComptableConverter ; 

 @Override 
 public ClasseComptable toItem(ClasseComptableVo vo) {
 if (vo == null) {
    return null;
      } else {
ClasseComptable item = new ClasseComptable();

 if (StringUtil.isNotEmpty(vo.getLibelle())) {
 item.setLibelle(vo.getLibelle());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

 if (vo.getNumero() != null) {
 item.setNumero(NumberUtil.toInt(vo.getNumero()));
} 

 if (ListUtil.isNotEmpty(vo.getSousClasseComptablesVo ()) && sousClasseComptables) {
 item.setSousClasseComptables(sousClasseComptableConverter.toItem(vo.getSousClasseComptablesVo())); 
} 

return item;
 }
 }

  @Override 
 public ClasseComptableVo toVo(ClasseComptable item) {
 if (item == null) {
    return null;
      } else {
ClasseComptableVo vo = new ClasseComptableVo();

 if (StringUtil.isNotEmpty(item.getLibelle())) {
 vo.setLibelle(item.getLibelle());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

 if (item.getNumero() != null) {
 vo.setNumero(NumberUtil.toString(item.getNumero()));
} 

 if(ListUtil.isNotEmpty(item.getSousClasseComptables()) && sousClasseComptables) {
 vo.setSousClasseComptablesVo(sousClasseComptableConverter.toVo(item.getSousClasseComptables()));
} 

return vo;
 }
 }
public void init() { 

sousClasseComptables = true; 
}
 } 
