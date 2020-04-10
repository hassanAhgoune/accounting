package com.zsmart.accountingProject.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.accountingProject.service.util.*;
import com.zsmart.accountingProject.bean.EtatFacture; 
import com.zsmart.accountingProject.ws.rest.vo.EtatFactureVo; 

 @Component 
public class EtatFactureConverter extends AbstractConverter<EtatFacture,EtatFactureVo>{ 

private boolean factures; 

 @Autowired
 private FactureConverter factureConverter ; 

 @Override 
 public EtatFacture toItem(EtatFactureVo vo) {
 if (vo == null) {
    return null;
      } else {
EtatFacture item = new EtatFacture();

 if (StringUtil.isNotEmpty(vo.getLibelle())) {
 item.setLibelle(vo.getLibelle());
} 

 if (StringUtil.isNotEmpty(vo.getCode())) {
 item.setCode(vo.getCode());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

 if (ListUtil.isNotEmpty(vo.getFacturesVo ()) && factures) {
 item.setFactures(factureConverter.toItem(vo.getFacturesVo())); 
} 

return item;
 }
 }

  @Override 
 public EtatFactureVo toVo(EtatFacture item) {
 if (item == null) {
    return null;
      } else {
EtatFactureVo vo = new EtatFactureVo();

 if (StringUtil.isNotEmpty(item.getLibelle())) {
 vo.setLibelle(item.getLibelle());
} 

 if (StringUtil.isNotEmpty(item.getCode())) {
 vo.setCode(item.getCode());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

 if(ListUtil.isNotEmpty(item.getFactures()) && factures) {
 vo.setFacturesVo(factureConverter.toVo(item.getFactures()));
} 

return vo;
 }
 }
public void init() { 

factures = true; 
}
 } 
