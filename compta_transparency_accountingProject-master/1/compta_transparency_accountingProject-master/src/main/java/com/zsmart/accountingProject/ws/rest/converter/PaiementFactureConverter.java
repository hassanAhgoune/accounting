package com.zsmart.accountingProject.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.accountingProject.service.util.*;
import com.zsmart.accountingProject.bean.PaiementFacture; 
import com.zsmart.accountingProject.ws.rest.vo.PaiementFactureVo; 

 @Component 
public class PaiementFactureConverter extends AbstractConverter<PaiementFacture,PaiementFactureVo>{ 

private boolean typePaiment; 

 @Autowired
 private TypePaiementConverter typePaiementConverter ; 
private boolean facture; 

 @Autowired
 private FactureConverter factureConverter ; 

 @Override 
 public PaiementFacture toItem(PaiementFactureVo vo) {
 if (vo == null) {
    return null;
      } else {
PaiementFacture item = new PaiementFacture();

 if(typePaiment&& vo.getTypePaimentVo() != null) {
 item.setTypePaiment(typePaiementConverter.toItem(vo.getTypePaimentVo()));
} 
 
 if(facture&& vo.getFactureVo() != null) {
 item.setFacture(factureConverter.toItem(vo.getFactureVo()));
} 
 
 if (StringUtil.isNotEmpty(vo.getDescription())) {
 item.setDescription(vo.getDescription());
} 

 if (StringUtil.isNotEmpty(vo.getScan())) {
 item.setScan(vo.getScan());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

 if (vo.getDatePaiment() != null) {
 item.setDatePaiment(DateUtil.parse(vo.getDatePaiment()));
} 

 if (vo.getDateSaisie() != null) {
 item.setDateSaisie(DateUtil.parse(vo.getDateSaisie()));
} 

 if (vo.getMontant() != null) {
 item.setMontant(NumberUtil.toBigDecimal(vo.getMontant()));
} 

return item;
 }
 }

  @Override 
 public PaiementFactureVo toVo(PaiementFacture item) {
 if (item == null) {
    return null;
      } else {
PaiementFactureVo vo = new PaiementFactureVo();

 if(typePaiment&& item.getTypePaiment() != null) {
 vo.setTypePaimentVo(typePaiementConverter.toVo(item.getTypePaiment()));
} 
 
 if(facture&& item.getFacture() != null) {
 vo.setFactureVo(factureConverter.toVo(item.getFacture()));
} 
 
 if (StringUtil.isNotEmpty(item.getDescription())) {
 vo.setDescription(item.getDescription());
} 

 if (StringUtil.isNotEmpty(item.getScan())) {
 vo.setScan(item.getScan());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

 if (item.getDatePaiment() != null) {
 vo.setDatePaiment(DateUtil.formateDate(item.getDatePaiment()));
} 

 if (item.getDateSaisie() != null) {
 vo.setDateSaisie(DateUtil.formateDate(item.getDateSaisie()));
} 

 if (item.getMontant() != null) {
 vo.setMontant(NumberUtil.toString(item.getMontant()));
} 

return vo;
 }
 }
public void init() { 

typePaiment = true; 

facture = true; 
}
 } 
