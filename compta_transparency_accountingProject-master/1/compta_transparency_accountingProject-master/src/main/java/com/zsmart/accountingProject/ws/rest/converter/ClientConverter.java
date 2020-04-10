package com.zsmart.accountingProject.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.accountingProject.service.util.*;
import com.zsmart.accountingProject.bean.Client; 
import com.zsmart.accountingProject.ws.rest.vo.ClientVo; 

 @Component 
public class ClientConverter extends AbstractConverter<Client,ClientVo>{ 

private boolean factureClients; 

 @Autowired
 private FactureClientConverter factureClientConverter ; 

 @Override 
 public Client toItem(ClientVo vo) {
 if (vo == null) {
    return null;
      } else {
Client item = new Client();

 if (StringUtil.isNotEmpty(vo.getIce())) {
 item.setIce(vo.getIce());
} 

 if (StringUtil.isNotEmpty(vo.getIdentifiantFiscale())) {
 item.setIdentifiantFiscale(vo.getIdentifiantFiscale());
} 

 if (StringUtil.isNotEmpty(vo.getRc())) {
 item.setRc(vo.getRc());
} 

 if (StringUtil.isNotEmpty(vo.getLibelle())) {
 item.setLibelle(vo.getLibelle());
} 

 if (StringUtil.isNotEmpty(vo.getCode())) {
 item.setCode(vo.getCode());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

 if (ListUtil.isNotEmpty(vo.getFactureClientsVo ()) && factureClients) {
 item.setFactureClients(factureClientConverter.toItem(vo.getFactureClientsVo())); 
} 

return item;
 }
 }

  @Override 
 public ClientVo toVo(Client item) {
 if (item == null) {
    return null;
      } else {
ClientVo vo = new ClientVo();

 if (StringUtil.isNotEmpty(item.getIce())) {
 vo.setIce(item.getIce());
} 

 if (StringUtil.isNotEmpty(item.getIdentifiantFiscale())) {
 vo.setIdentifiantFiscale(item.getIdentifiantFiscale());
} 

 if (StringUtil.isNotEmpty(item.getRc())) {
 vo.setRc(item.getRc());
} 

 if (StringUtil.isNotEmpty(item.getLibelle())) {
 vo.setLibelle(item.getLibelle());
} 

 if (StringUtil.isNotEmpty(item.getCode())) {
 vo.setCode(item.getCode());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

 if(ListUtil.isNotEmpty(item.getFactureClients()) && factureClients) {
 vo.setFactureClientsVo(factureClientConverter.toVo(item.getFactureClients()));
} 

return vo;
 }
 }
public void init() { 

factureClients = true; 
}
 } 
