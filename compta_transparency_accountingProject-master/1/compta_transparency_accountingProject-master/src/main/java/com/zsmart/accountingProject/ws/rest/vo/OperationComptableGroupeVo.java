package com.zsmart.accountingProject.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;


public class OperationComptableGroupeVo{

private String id ;
private String libelle ;
private String code ;
private List<OperationComptableVo>operationComptablesVo;



public String  getId(){
    return id;
}

public void setId(String  id){
     this.id = id;
}

public String  getLibelle(){
    return libelle;
}

public void setLibelle(String  libelle){
     this.libelle = libelle;
}

public String  getCode(){
    return code;
}

public void setCode(String  code){
     this.code = code;
}

public List<OperationComptableVo> getOperationComptablesVo(){
    return operationComptablesVo;
}

public void setOperationComptablesVo(List<OperationComptableVo> operationComptablesVo){
     this.operationComptablesVo = operationComptablesVo;
}




}