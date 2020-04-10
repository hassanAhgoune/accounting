package com.zsmart.accountingProject.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;


public class FactureFournisseurVo{

private String id ;
private FournisseurVo fournisseurVo ;



public String  getId(){
    return id;
}

public void setId(String  id){
     this.id = id;
}

public FournisseurVo  getFournisseurVo (){
    return fournisseurVo ;
}

public void setFournisseurVo (FournisseurVo  fournisseurVo ){
     this.fournisseurVo  = fournisseurVo ;
}




}