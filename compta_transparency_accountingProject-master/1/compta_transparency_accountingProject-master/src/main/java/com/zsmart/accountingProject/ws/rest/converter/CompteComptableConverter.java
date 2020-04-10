package com.zsmart.accountingProject.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.accountingProject.service.util.*;
import com.zsmart.accountingProject.bean.CompteComptable; 
import com.zsmart.accountingProject.ws.rest.vo.CompteComptableVo; 

 @Component 
public class CompteComptableConverter extends AbstractConverter<CompteComptable,CompteComptableVo>{ 

private boolean sousClasseComptable; 

 @Autowired
 private SousClasseComptableConverter sousClasseComptableConverter ; 

 @Override 
 public CompteComptable toItem(CompteComptableVo vo) {
 if (vo == null) {
    return null;
      } else {
CompteComptable item = new CompteComptable();

 if(sousClasseComptable&& vo.getSousClasseComptableVo() != null) {
 item.setSousClasseComptable(sousClasseComptableConverter.toItem(vo.getSousClasseComptableVo()));
} 
 
 if (StringUtil.isNotEmpty(vo.getCode())) {
 item.setCode(vo.getCode());
} 

 if (StringUtil.isNotEmpty(vo.getLibelle())) {
 item.setLibelle(vo.getLibelle());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

return item;
 }
 }

  @Override 
 public CompteComptableVo toVo(CompteComptable item) {
 if (item == null) {
    return null;
      } else {
CompteComptableVo vo = new CompteComptableVo();

 if(sousClasseComptable&& item.getSousClasseComptable() != null) {
 vo.setSousClasseComptableVo(sousClasseComptableConverter.toVo(item.getSousClasseComptable()));
} 
 
 if (StringUtil.isNotEmpty(item.getCode())) {
 vo.setCode(item.getCode());
} 

 if (StringUtil.isNotEmpty(item.getLibelle())) {
 vo.setLibelle(item.getLibelle());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

return vo;
 }
 }
public void init() { 

sousClasseComptable = true; 
}
 } 
