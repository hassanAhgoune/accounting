package com.zsmart.accountingProject.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;


public class CaisseVo{

private String id ;
private String libelle ;
private String code ;
private String solde;
private String soldeMin ;
private String soldeMax ;
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

public String  getSolde(){
    return solde;
}

public void setSolde(String  solde){
     this.solde = solde;
}

public String  getSoldeMin(){
    return soldeMin;
}

public void setSoldeMin(String  soldeMin){
     this.soldeMin = soldeMin;
}

public String  getSoldeMax(){
    return soldeMax;
}

public void setSoldeMax(String  soldeMax){
     this.soldeMax = soldeMax;
}

public List<OperationComptableVo> getOperationComptablesVo(){
    return operationComptablesVo;
}

public void setOperationComptablesVo(List<OperationComptableVo> operationComptablesVo){
     this.operationComptablesVo = operationComptablesVo;
}




}