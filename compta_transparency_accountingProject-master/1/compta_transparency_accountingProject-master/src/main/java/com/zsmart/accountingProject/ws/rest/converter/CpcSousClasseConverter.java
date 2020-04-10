package com.zsmart.accountingProject.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.accountingProject.service.util.*;
import com.zsmart.accountingProject.bean.CpcSousClasse; 
import com.zsmart.accountingProject.ws.rest.vo.CpcSousClasseVo; 

 @Component 
public class CpcSousClasseConverter extends AbstractConverter<CpcSousClasse,CpcSousClasseVo>{ 

private boolean sousClasseComptable; 

 @Autowired
 private SousClasseComptableConverter sousClasseComptableConverter ; 
private boolean cpc; 

 @Autowired
 private CpcConverter cpcConverter ; 
private boolean cpcCompteComptables; 

 @Autowired
 private CpcCompteComptableConverter cpcCompteComptableConverter ; 

 @Override 
 public CpcSousClasse toItem(CpcSousClasseVo vo) {
 if (vo == null) {
    return null;
      } else {
CpcSousClasse item = new CpcSousClasse();

 if(sousClasseComptable&& vo.getSousClasseComptableVo() != null) {
 item.setSousClasseComptable(sousClasseComptableConverter.toItem(vo.getSousClasseComptableVo()));
} 
 
 if(cpc&& vo.getCpcVo() != null) {
 item.setCpc(cpcConverter.toItem(vo.getCpcVo()));
} 
 
 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

 if (vo.getMontant() != null) {
 item.setMontant(NumberUtil.toBigDecimal(vo.getMontant()));
} 

 if (ListUtil.isNotEmpty(vo.getCpcCompteComptablesVo ()) && cpcCompteComptables) {
 item.setCpcCompteComptables(cpcCompteComptableConverter.toItem(vo.getCpcCompteComptablesVo())); 
} 

return item;
 }
 }

  @Override 
 public CpcSousClasseVo toVo(CpcSousClasse item) {
 if (item == null) {
    return null;
      } else {
CpcSousClasseVo vo = new CpcSousClasseVo();

 if(sousClasseComptable&& item.getSousClasseComptable() != null) {
 vo.setSousClasseComptableVo(sousClasseComptableConverter.toVo(item.getSousClasseComptable()));
} 
 
 if(cpc&& item.getCpc() != null) {
 vo.setCpcVo(cpcConverter.toVo(item.getCpc()));
} 
 
 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

 if (item.getMontant() != null) {
 vo.setMontant(NumberUtil.toString(item.getMontant()));
} 

 if(ListUtil.isNotEmpty(item.getCpcCompteComptables()) && cpcCompteComptables) {
 vo.setCpcCompteComptablesVo(cpcCompteComptableConverter.toVo(item.getCpcCompteComptables()));
} 

return vo;
 }
 }
public void init() { 

sousClasseComptable = true; 

cpc = true; 

cpcCompteComptables = true; 
}
 } 
