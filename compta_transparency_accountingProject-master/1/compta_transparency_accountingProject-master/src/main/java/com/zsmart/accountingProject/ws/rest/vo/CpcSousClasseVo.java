package com.zsmart.accountingProject.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;


public class CpcSousClasseVo{

private String id ;
private String montant;
private String montantMin ;
private String montantMax ;
private SousClasseComptableVo sousClasseComptableVo ;
private CpcVo cpcVo ;
private List<CpcCompteComptableVo>cpcCompteComptablesVo;



public String  getId(){
    return id;
}

public void setId(String  id){
     this.id = id;
}

public String  getMontant(){
    return montant;
}

public void setMontant(String  montant){
     this.montant = montant;
}

public String  getMontantMin(){
    return montantMin;
}

public void setMontantMin(String  montantMin){
     this.montantMin = montantMin;
}

public String  getMontantMax(){
    return montantMax;
}

public void setMontantMax(String  montantMax){
     this.montantMax = montantMax;
}

public SousClasseComptableVo  getSousClasseComptableVo (){
    return sousClasseComptableVo ;
}

public void setSousClasseComptableVo (SousClasseComptableVo  sousClasseComptableVo ){
     this.sousClasseComptableVo  = sousClasseComptableVo ;
}

public CpcVo  getCpcVo (){
    return cpcVo ;
}

public void setCpcVo (CpcVo  cpcVo ){
     this.cpcVo  = cpcVo ;
}

public List<CpcCompteComptableVo> getCpcCompteComptablesVo(){
    return cpcCompteComptablesVo;
}

public void setCpcCompteComptablesVo(List<CpcCompteComptableVo> cpcCompteComptablesVo){
     this.cpcCompteComptablesVo = cpcCompteComptablesVo;
}




}