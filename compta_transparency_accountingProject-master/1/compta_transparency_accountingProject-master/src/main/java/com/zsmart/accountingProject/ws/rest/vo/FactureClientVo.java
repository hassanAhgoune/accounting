package com.zsmart.accountingProject.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;


public class FactureClientVo{

private String id ;
private ClientVo clientVo ;



public String  getId(){
    return id;
}

public void setId(String  id){
     this.id = id;
}

public ClientVo  getClientVo (){
    return clientVo ;
}

public void setClientVo (ClientVo  clientVo ){
     this.clientVo  = clientVo ;
}




}