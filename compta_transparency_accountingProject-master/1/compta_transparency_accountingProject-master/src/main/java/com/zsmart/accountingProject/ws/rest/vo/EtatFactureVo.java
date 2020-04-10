package com.zsmart.accountingProject.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;


public class EtatFactureVo{

private String id ;
private String libelle ;
private String code ;
private List<FactureVo>facturesVo;



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

public List<FactureVo> getFacturesVo(){
    return facturesVo;
}

public void setFacturesVo(List<FactureVo> facturesVo){
     this.facturesVo = facturesVo;
}




}