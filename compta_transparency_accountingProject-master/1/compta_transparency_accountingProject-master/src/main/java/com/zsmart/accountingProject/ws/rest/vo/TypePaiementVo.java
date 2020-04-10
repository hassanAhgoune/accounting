package com.zsmart.accountingProject.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;


public class TypePaiementVo{

private String id ;
private String libelle ;
private String code ;
private List<PaiementFactureVo>paiementFacturesVo;



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

public List<PaiementFactureVo> getPaiementFacturesVo(){
    return paiementFacturesVo;
}

public void setPaiementFacturesVo(List<PaiementFactureVo> paiementFacturesVo){
     this.paiementFacturesVo = paiementFacturesVo;
}




}