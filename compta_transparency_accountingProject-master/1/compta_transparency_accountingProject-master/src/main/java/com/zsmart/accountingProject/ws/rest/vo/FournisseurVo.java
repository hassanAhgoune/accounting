package com.zsmart.accountingProject.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;


public class FournisseurVo{

private String id ;
private String ice ;
private String identifiantFiscale ;
private String rc ;
private String libelle ;
private String code ;
private List<FactureFournisseurVo>factureFournisseursVo;



public String  getId(){
    return id;
}

public void setId(String  id){
     this.id = id;
}

public String  getIce(){
    return ice;
}

public void setIce(String  ice){
     this.ice = ice;
}

public String  getIdentifiantFiscale(){
    return identifiantFiscale;
}

public void setIdentifiantFiscale(String  identifiantFiscale){
     this.identifiantFiscale = identifiantFiscale;
}

public String  getRc(){
    return rc;
}

public void setRc(String  rc){
     this.rc = rc;
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

public List<FactureFournisseurVo> getFactureFournisseursVo(){
    return factureFournisseursVo;
}

public void setFactureFournisseursVo(List<FactureFournisseurVo> factureFournisseursVo){
     this.factureFournisseursVo = factureFournisseursVo;
}




}