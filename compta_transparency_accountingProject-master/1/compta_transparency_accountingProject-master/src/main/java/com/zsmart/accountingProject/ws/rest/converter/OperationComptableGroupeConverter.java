package com.zsmart.accountingProject.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.accountingProject.service.util.*;
import com.zsmart.accountingProject.bean.OperationComptableGroupe; 
import com.zsmart.accountingProject.ws.rest.vo.OperationComptableGroupeVo; 

 @Component 
public class OperationComptableGroupeConverter extends AbstractConverter<OperationComptableGroupe,OperationComptableGroupeVo>{ 

private boolean operationComptables; 

 @Autowired
 private OperationComptableConverter operationComptableConverter ; 

 @Override 
 public OperationComptableGroupe toItem(OperationComptableGroupeVo vo) {
 if (vo == null) {
    return null;
      } else {
OperationComptableGroupe item = new OperationComptableGroupe();

 if (StringUtil.isNotEmpty(vo.getLibelle())) {
 item.setLibelle(vo.getLibelle());
} 

 if (StringUtil.isNotEmpty(vo.getCode())) {
 item.setCode(vo.getCode());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

 if (ListUtil.isNotEmpty(vo.getOperationComptablesVo ()) && operationComptables) {
 item.setOperationComptables(operationComptableConverter.toItem(vo.getOperationComptablesVo())); 
} 

return item;
 }
 }

  @Override 
 public OperationComptableGroupeVo toVo(OperationComptableGroupe item) {
 if (item == null) {
    return null;
      } else {
OperationComptableGroupeVo vo = new OperationComptableGroupeVo();

 if (StringUtil.isNotEmpty(item.getLibelle())) {
 vo.setLibelle(item.getLibelle());
} 

 if (StringUtil.isNotEmpty(item.getCode())) {
 vo.setCode(item.getCode());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

 if(ListUtil.isNotEmpty(item.getOperationComptables()) && operationComptables) {
 vo.setOperationComptablesVo(operationComptableConverter.toVo(item.getOperationComptables()));
} 

return vo;
 }
 }
public void init() { 

operationComptables = true; 
}
 } 
