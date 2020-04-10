package com.zsmart.accountingProject.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;


public class PaiementFactureVo{

private String id ;
private String datePaiment;
private String datePaimentMin ;
private String datePaimentMax ;
private String dateSaisie;
private String dateSaisieMin ;
private String dateSaisieMax ;
private String montant;
private String montantMin ;
private String montantMax ;
private String description ;
private String scan ;
private TypePaiementVo typePaimentVo ;
private FactureVo factureVo ;



public String  getId(){
    return id;
}

public void setId(String  id){
     this.id = id;
}

public String  getDatePaiment(){
    return datePaiment;
}

public void setDatePaiment(String  datePaiment){
     this.datePaiment = datePaiment;
}

public String  getDatePaimentMin(){
    return datePaimentMin;
}

public void setDatePaimentMin(String  datePaimentMin){
     this.datePaimentMin = datePaimentMin;
}

public String  getDatePaimentMax(){
    return datePaimentMax;
}

public void setDatePaimentMax(String  datePaimentMax){
     this.datePaimentMax = datePaimentMax;
}

public String  getDateSaisie(){
    return dateSaisie;
}

public void setDateSaisie(String  dateSaisie){
     this.dateSaisie = dateSaisie;
}

public String  getDateSaisieMin(){
    return dateSaisieMin;
}

public void setDateSaisieMin(String  dateSaisieMin){
     this.dateSaisieMin = dateSaisieMin;
}

public String  getDateSaisieMax(){
    return dateSaisieMax;
}

public void setDateSaisieMax(String  dateSaisieMax){
     this.dateSaisieMax = dateSaisieMax;
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

public String  getDescription(){
    return description;
}

public void setDescription(String  description){
     this.description = description;
}

public String  getScan(){
    return scan;
}

public void setScan(String  scan){
     this.scan = scan;
}

public TypePaiementVo  getTypePaimentVo (){
    return typePaimentVo ;
}

public void setTypePaimentVo (TypePaiementVo  typePaimentVo ){
     this.typePaimentVo  = typePaimentVo ;
}

public FactureVo  getFactureVo (){
    return factureVo ;
}

public void setFactureVo (FactureVo  factureVo ){
     this.factureVo  = factureVo ;
}




}