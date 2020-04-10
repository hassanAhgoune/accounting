package com.zsmart.accountingProject.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.accountingProject.service.util.*;
import com.zsmart.accountingProject.bean.FactureFournisseur; 
import com.zsmart.accountingProject.ws.rest.vo.FactureFournisseurVo; 

 @Component 
public class FactureFournisseurConverter extends AbstractConverter<FactureFournisseur,FactureFournisseurVo>{ 

private boolean fournisseur; 

 @Autowired
 private FournisseurConverter fournisseurConverter ; 

 @Override 
 public FactureFournisseur toItem(FactureFournisseurVo vo) {
 if (vo == null) {
    return null;
      } else {
FactureFournisseur item = new FactureFournisseur();

 if(fournisseur&& vo.getFournisseurVo() != null) {
 item.setFournisseur(fournisseurConverter.toItem(vo.getFournisseurVo()));
} 
 
 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

return item;
 }
 }

  @Override 
 public FactureFournisseurVo toVo(FactureFournisseur item) {
 if (item == null) {
    return null;
      } else {
FactureFournisseurVo vo = new FactureFournisseurVo();

 if(fournisseur&& item.getFournisseur() != null) {
 vo.setFournisseurVo(fournisseurConverter.toVo(item.getFournisseur()));
} 
 
 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

return vo;
 }
 }
public void init() { 

fournisseur = true; 
}
 } 
