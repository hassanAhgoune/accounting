package com.zsmart.accountingProject.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.accountingProject.service.util.*;
import com.zsmart.accountingProject.bean.FactureClient; 
import com.zsmart.accountingProject.ws.rest.vo.FactureClientVo; 

 @Component 
public class FactureClientConverter extends AbstractConverter<FactureClient,FactureClientVo>{ 

private boolean client; 

 @Autowired
 private ClientConverter clientConverter ; 

 @Override 
 public FactureClient toItem(FactureClientVo vo) {
 if (vo == null) {
    return null;
      } else {
FactureClient item = new FactureClient();

 if(client&& vo.getClientVo() != null) {
 item.setClient(clientConverter.toItem(vo.getClientVo()));
} 
 
 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

return item;
 }
 }

  @Override 
 public FactureClientVo toVo(FactureClient item) {
 if (item == null) {
    return null;
      } else {
FactureClientVo vo = new FactureClientVo();

 if(client&& item.getClient() != null) {
 vo.setClientVo(clientConverter.toVo(item.getClient()));
} 
 
 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

return vo;
 }
 }
public void init() { 

client = true; 
}
 } 
