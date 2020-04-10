package com.zsmart.accountingProject.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;


public class BanqueVo{

private String id ;
private String libelle ;
private String code ;
private List<CompteBanquaireVo>compteBanquairesVo;



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

public List<CompteBanquaireVo> getCompteBanquairesVo(){
    return compteBanquairesVo;
}

public void setCompteBanquairesVo(List<CompteBanquaireVo> compteBanquairesVo){
     this.compteBanquairesVo = compteBanquairesVo;
}




}