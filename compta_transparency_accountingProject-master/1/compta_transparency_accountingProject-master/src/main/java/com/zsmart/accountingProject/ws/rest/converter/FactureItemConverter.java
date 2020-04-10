package com.zsmart.accountingProject.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.accountingProject.service.util.*;
import com.zsmart.accountingProject.bean.FactureItem; 
import com.zsmart.accountingProject.ws.rest.vo.FactureItemVo; 

 @Component 
public class FactureItemConverter extends AbstractConverter<FactureItem,FactureItemVo>{ 

private boolean facture; 

 @Autowired
 private FactureConverter factureConverter ; 

 @Override 
 public FactureItem toItem(FactureItemVo vo) {
 if (vo == null) {
    return null;
      } else {
FactureItem item = new FactureItem();

 if(facture&& vo.getFactureVo() != null) {
 item.setFacture(factureConverter.toItem(vo.getFactureVo()));
} 
 
 if (StringUtil.isNotEmpty(vo.getProduit())) {
 item.setProduit(vo.getProduit());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

 if (vo.getMontant() != null) {
 item.setMontant(NumberUtil.toBigDecimal(vo.getMontant()));
} 

 if (vo.getQuantite() != null) {
 item.setQuantite(NumberUtil.toBigDecimal(vo.getQuantite()));
} 

return item;
 }
 }

  @Override 
 public FactureItemVo toVo(FactureItem item) {
 if (item == null) {
    return null;
      } else {
FactureItemVo vo = new FactureItemVo();

 if(facture&& item.getFacture() != null) {
 vo.setFactureVo(factureConverter.toVo(item.getFacture()));
} 
 
 if (StringUtil.isNotEmpty(item.getProduit())) {
 vo.setProduit(item.getProduit());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

 if (item.getMontant() != null) {
 vo.setMontant(NumberUtil.toString(item.getMontant()));
} 

 if (item.getQuantite() != null) {
 vo.setQuantite(NumberUtil.toString(item.getQuantite()));
} 

return vo;
 }
 }
public void init() { 

facture = true; 
}
 } 
