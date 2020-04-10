package com.zsmart.accountingProject.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.accountingProject.service.util.*;
import com.zsmart.accountingProject.bean.OperationComptable; 
import com.zsmart.accountingProject.ws.rest.vo.OperationComptableVo; 

 @Component 
public class OperationComptableConverter extends AbstractConverter<OperationComptable,OperationComptableVo>{ 

private boolean caisse; 

 @Autowired
 private CaisseConverter caisseConverter ; 
private boolean compteBanquaire; 

 @Autowired
 private CompteBanquaireConverter compteBanquaireConverter ; 
private boolean compteComptable; 

 @Autowired
 private CompteComptableConverter compteComptableConverter ; 
private boolean operationComptableGroupe; 

 @Autowired
 private OperationComptableGroupeConverter operationComptableGroupeConverter ; 
private boolean facture; 

 @Autowired
 private FactureConverter factureConverter ; 

 @Override 
 public OperationComptable toItem(OperationComptableVo vo) {
 if (vo == null) {
    return null;
      } else {
OperationComptable item = new OperationComptable();

 if(caisse&& vo.getCaisseVo() != null) {
 item.setCaisse(caisseConverter.toItem(vo.getCaisseVo()));
} 
 
 if(compteBanquaire&& vo.getCompteBanquaireVo() != null) {
 item.setCompteBanquaire(compteBanquaireConverter.toItem(vo.getCompteBanquaireVo()));
} 
 
 if(compteComptable&& vo.getCompteComptableVo() != null) {
 item.setCompteComptable(compteComptableConverter.toItem(vo.getCompteComptableVo()));
} 
 
 if(operationComptableGroupe&& vo.getOperationComptableGroupeVo() != null) {
 item.setOperationComptableGroupe(operationComptableGroupeConverter.toItem(vo.getOperationComptableGroupeVo()));
} 
 
 if(facture&& vo.getFactureVo() != null) {
 item.setFacture(factureConverter.toItem(vo.getFactureVo()));
} 
 
 if (StringUtil.isNotEmpty(vo.getLibelle())) {
 item.setLibelle(vo.getLibelle());
} 

 if (StringUtil.isNotEmpty(vo.getReferenceSociete())) {
 item.setReferenceSociete(vo.getReferenceSociete());
} 

 if (StringUtil.isNotEmpty(vo.getReferenceFacture())) {
 item.setReferenceFacture(vo.getReferenceFacture());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

 if (vo.getDebit() != null) {
 item.setDebit(NumberUtil.toBigDecimal(vo.getDebit()));
} 

 if (vo.getCredit() != null) {
 item.setCredit(NumberUtil.toBigDecimal(vo.getCredit()));
} 

 if (vo.getDateOperationComptable() != null) {
 item.setDateOperationComptable(DateUtil.parse(vo.getDateOperationComptable()));
} 

 if (vo.getDateSaisie() != null) {
 item.setDateSaisie(DateUtil.parse(vo.getDateSaisie()));
} 

return item;
 }
 }

  @Override 
 public OperationComptableVo toVo(OperationComptable item) {
 if (item == null) {
    return null;
      } else {
OperationComptableVo vo = new OperationComptableVo();

 if(caisse&& item.getCaisse() != null) {
 vo.setCaisseVo(caisseConverter.toVo(item.getCaisse()));
} 
 
 if(compteBanquaire&& item.getCompteBanquaire() != null) {
 vo.setCompteBanquaireVo(compteBanquaireConverter.toVo(item.getCompteBanquaire()));
} 
 
 if(compteComptable&& item.getCompteComptable() != null) {
 vo.setCompteComptableVo(compteComptableConverter.toVo(item.getCompteComptable()));
} 
 
 if(operationComptableGroupe&& item.getOperationComptableGroupe() != null) {
 vo.setOperationComptableGroupeVo(operationComptableGroupeConverter.toVo(item.getOperationComptableGroupe()));
} 
 
 if(facture&& item.getFacture() != null) {
 vo.setFactureVo(factureConverter.toVo(item.getFacture()));
} 
 
 if (StringUtil.isNotEmpty(item.getLibelle())) {
 vo.setLibelle(item.getLibelle());
} 

 if (StringUtil.isNotEmpty(item.getReferenceSociete())) {
 vo.setReferenceSociete(item.getReferenceSociete());
} 

 if (StringUtil.isNotEmpty(item.getReferenceFacture())) {
 vo.setReferenceFacture(item.getReferenceFacture());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

 if (item.getDebit() != null) {
 vo.setDebit(NumberUtil.toString(item.getDebit()));
} 

 if (item.getCredit() != null) {
 vo.setCredit(NumberUtil.toString(item.getCredit()));
} 

 if (item.getDateOperationComptable() != null) {
 vo.setDateOperationComptable(DateUtil.formateDate(item.getDateOperationComptable()));
} 

 if (item.getDateSaisie() != null) {
 vo.setDateSaisie(DateUtil.formateDate(item.getDateSaisie()));
} 

return vo;
 }
 }
public void init() { 

caisse = true; 

compteBanquaire = true; 

compteComptable = true; 

operationComptableGroupe = true; 

facture = true; 
}
 } 
