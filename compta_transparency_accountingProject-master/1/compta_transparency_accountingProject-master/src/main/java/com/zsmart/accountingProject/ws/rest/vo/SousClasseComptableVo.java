package com.zsmart.accountingProject.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;


public class SousClasseComptableVo{

private String id ;
private String numero;
private String numeroMin ;
private String numeroMax ;
private String libelle ;
private ClasseComptableVo classeComptableVo ;
private List<CompteComptableVo>compteComptablesVo;



public String  getId(){
    return id;
}

public void setId(String  id){
     this.id = id;
}

public String  getNumero(){
    return numero;
}

public void setNumero(String  numero){
     this.numero = numero;
}

public String  getNumeroMin(){
    return numeroMin;
}

public void setNumeroMin(String  numeroMin){
     this.numeroMin = numeroMin;
}

public String  getNumeroMax(){
    return numeroMax;
}

public void setNumeroMax(String  numeroMax){
     this.numeroMax = numeroMax;
}

public String  getLibelle(){
    return libelle;
}

public void setLibelle(String  libelle){
     this.libelle = libelle;
}

public ClasseComptableVo  getClasseComptableVo (){
    return classeComptableVo ;
}

public void setClasseComptableVo (ClasseComptableVo  classeComptableVo ){
     this.classeComptableVo  = classeComptableVo ;
}

public List<CompteComptableVo> getCompteComptablesVo(){
    return compteComptablesVo;
}

public void setCompteComptablesVo(List<CompteComptableVo> compteComptablesVo){
     this.compteComptablesVo = compteComptablesVo;
}




}