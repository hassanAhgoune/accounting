package com.zsmart.accountingProject.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;


public class CpcCompteComptableVo{

private String id ;
private String montant;
private String montantMin ;
private String montantMax ;
private CompteComptableVo compteComptableVo ;
private CpcSousClasseVo cpcSousClasseVo ;



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

public CompteComptableVo  getCompteComptableVo (){
    return compteComptableVo ;
}

public void setCompteComptableVo (CompteComptableVo  compteComptableVo ){
     this.compteComptableVo  = compteComptableVo ;
}

public CpcSousClasseVo  getCpcSousClasseVo (){
    return cpcSousClasseVo ;
}

public void setCpcSousClasseVo (CpcSousClasseVo  cpcSousClasseVo ){
     this.cpcSousClasseVo  = cpcSousClasseVo ;
}




}