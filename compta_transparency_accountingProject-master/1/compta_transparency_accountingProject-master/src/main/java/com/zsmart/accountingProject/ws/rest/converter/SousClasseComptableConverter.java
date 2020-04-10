package com.zsmart.accountingProject.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.accountingProject.service.util.*;
import com.zsmart.accountingProject.bean.SousClasseComptable; 
import com.zsmart.accountingProject.ws.rest.vo.SousClasseComptableVo; 

 @Component 
public class SousClasseComptableConverter extends AbstractConverter<SousClasseComptable,SousClasseComptableVo>{ 

private boolean classeComptable; 

 @Autowired
 private ClasseComptableConverter classeComptableConverter ; 
private boolean compteComptables; 

 @Autowired
 private CompteComptableConverter compteComptableConverter ; 

 @Override 
 public SousClasseComptable toItem(SousClasseComptableVo vo) {
 if (vo == null) {
    return null;
      } else {
SousClasseComptable item = new SousClasseComptable();

 if(classeComptable&& vo.getClasseComptableVo() != null) {
 item.setClasseComptable(classeComptableConverter.toItem(vo.getClasseComptableVo()));
} 
 
 if (StringUtil.isNotEmpty(vo.getLibelle())) {
 item.setLibelle(vo.getLibelle());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

 if (vo.getNumero() != null) {
 item.setNumero(NumberUtil.toInt(vo.getNumero()));
} 

 if (ListUtil.isNotEmpty(vo.getCompteComptablesVo ()) && compteComptables) {
 item.setCompteComptables(compteComptableConverter.toItem(vo.getCompteComptablesVo())); 
} 

return item;
 }
 }

  @Override 
 public SousClasseComptableVo toVo(SousClasseComptable item) {
 if (item == null) {
    return null;
      } else {
SousClasseComptableVo vo = new SousClasseComptableVo();

 if(classeComptable&& item.getClasseComptable() != null) {
 vo.setClasseComptableVo(classeComptableConverter.toVo(item.getClasseComptable()));
} 
 
 if (StringUtil.isNotEmpty(item.getLibelle())) {
 vo.setLibelle(item.getLibelle());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

 if (item.getNumero() != null) {
 vo.setNumero(NumberUtil.toString(item.getNumero()));
} 

 if(ListUtil.isNotEmpty(item.getCompteComptables()) && compteComptables) {
 vo.setCompteComptablesVo(compteComptableConverter.toVo(item.getCompteComptables()));
} 

return vo;
 }
 }
public void init() { 

classeComptable = true; 

compteComptables = true; 
}
 } 
