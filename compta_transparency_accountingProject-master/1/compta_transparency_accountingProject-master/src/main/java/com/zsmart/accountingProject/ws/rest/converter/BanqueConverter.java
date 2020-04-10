package com.zsmart.accountingProject.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.accountingProject.service.util.*;
import com.zsmart.accountingProject.bean.Banque; 
import com.zsmart.accountingProject.ws.rest.vo.BanqueVo; 

 @Component 
public class BanqueConverter extends AbstractConverter<Banque,BanqueVo>{ 

private boolean compteBanquaires; 

 @Autowired
 private CompteBanquaireConverter compteBanquaireConverter ; 

 @Override 
 public Banque toItem(BanqueVo vo) {
 if (vo == null) {
    return null;
      } else {
Banque item = new Banque();

 if (StringUtil.isNotEmpty(vo.getLibelle())) {
 item.setLibelle(vo.getLibelle());
} 

 if (StringUtil.isNotEmpty(vo.getCode())) {
 item.setCode(vo.getCode());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

 if (ListUtil.isNotEmpty(vo.getCompteBanquairesVo ()) && compteBanquaires) {
 item.setCompteBanquaires(compteBanquaireConverter.toItem(vo.getCompteBanquairesVo())); 
} 

return item;
 }
 }

  @Override 
 public BanqueVo toVo(Banque item) {
 if (item == null) {
    return null;
      } else {
BanqueVo vo = new BanqueVo();

 if (StringUtil.isNotEmpty(item.getLibelle())) {
 vo.setLibelle(item.getLibelle());
} 

 if (StringUtil.isNotEmpty(item.getCode())) {
 vo.setCode(item.getCode());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

 if(ListUtil.isNotEmpty(item.getCompteBanquaires()) && compteBanquaires) {
 vo.setCompteBanquairesVo(compteBanquaireConverter.toVo(item.getCompteBanquaires()));
} 

return vo;
 }
 }
public void init() { 

compteBanquaires = true; 
}
 } 
