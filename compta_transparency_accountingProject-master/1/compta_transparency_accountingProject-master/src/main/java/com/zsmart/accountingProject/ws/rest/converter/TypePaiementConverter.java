package com.zsmart.accountingProject.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.accountingProject.service.util.*;
import com.zsmart.accountingProject.bean.TypePaiement; 
import com.zsmart.accountingProject.ws.rest.vo.TypePaiementVo; 

 @Component 
public class TypePaiementConverter extends AbstractConverter<TypePaiement,TypePaiementVo>{ 

private boolean paiementFactures; 

 @Autowired
 private PaiementFactureConverter paiementFactureConverter ; 

 @Override 
 public TypePaiement toItem(TypePaiementVo vo) {
 if (vo == null) {
    return null;
      } else {
TypePaiement item = new TypePaiement();

 if (StringUtil.isNotEmpty(vo.getLibelle())) {
 item.setLibelle(vo.getLibelle());
} 

 if (StringUtil.isNotEmpty(vo.getCode())) {
 item.setCode(vo.getCode());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

 if (ListUtil.isNotEmpty(vo.getPaiementFacturesVo ()) && paiementFactures) {
 item.setPaiementFactures(paiementFactureConverter.toItem(vo.getPaiementFacturesVo())); 
} 

return item;
 }
 }

  @Override 
 public TypePaiementVo toVo(TypePaiement item) {
 if (item == null) {
    return null;
      } else {
TypePaiementVo vo = new TypePaiementVo();

 if (StringUtil.isNotEmpty(item.getLibelle())) {
 vo.setLibelle(item.getLibelle());
} 

 if (StringUtil.isNotEmpty(item.getCode())) {
 vo.setCode(item.getCode());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

 if(ListUtil.isNotEmpty(item.getPaiementFactures()) && paiementFactures) {
 vo.setPaiementFacturesVo(paiementFactureConverter.toVo(item.getPaiementFactures()));
} 

return vo;
 }
 }
public void init() { 

paiementFactures = true; 
}
 } 
