package com.zsmart.accountingProject.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;


public class FactureItemVo{

private String id ;
private String produit ;
private String montant;
private String montantMin ;
private String montantMax ;
private String quantite;
private String quantiteMin ;
private String quantiteMax ;
private FactureVo factureVo ;



public String  getId(){
    return id;
}

public void setId(String  id){
     this.id = id;
}

public String  getProduit(){
    return produit;
}

public void setProduit(String  produit){
     this.produit = produit;
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

public String  getQuantite(){
    return quantite;
}

public void setQuantite(String  quantite){
     this.quantite = quantite;
}

public String  getQuantiteMin(){
    return quantiteMin;
}

public void setQuantiteMin(String  quantiteMin){
     this.quantiteMin = quantiteMin;
}

public String  getQuantiteMax(){
    return quantiteMax;
}

public void setQuantiteMax(String  quantiteMax){
     this.quantiteMax = quantiteMax;
}

public FactureVo  getFactureVo (){
    return factureVo ;
}

public void setFactureVo (FactureVo  factureVo ){
     this.factureVo  = factureVo ;
}




}