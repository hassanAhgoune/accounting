package com.zsmart.accountingProject.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;


public class CpcVo{

private String id ;
private String dateDebut;
private String dateDebutMin ;
private String dateDebutMax ;
private String dateFin;
private String dateFinMin ;
private String dateFinMax ;
private String referenceSociete ;
private String totalCharge;
private String totalChargeMin ;
private String totalChargeMax ;
private String totalProduit;
private String totalProduitMin ;
private String totalProduitMax ;
private String resultat;
private String resultatMin ;
private String resultatMax ;
private List<CpcSousClasseVo>cpcSousClassesVo;



public String  getId(){
    return id;
}

public void setId(String  id){
     this.id = id;
}

public String  getDateDebut(){
    return dateDebut;
}

public void setDateDebut(String  dateDebut){
     this.dateDebut = dateDebut;
}

public String  getDateDebutMin(){
    return dateDebutMin;
}

public void setDateDebutMin(String  dateDebutMin){
     this.dateDebutMin = dateDebutMin;
}

public String  getDateDebutMax(){
    return dateDebutMax;
}

public void setDateDebutMax(String  dateDebutMax){
     this.dateDebutMax = dateDebutMax;
}

public String  getDateFin(){
    return dateFin;
}

public void setDateFin(String  dateFin){
     this.dateFin = dateFin;
}

public String  getDateFinMin(){
    return dateFinMin;
}

public void setDateFinMin(String  dateFinMin){
     this.dateFinMin = dateFinMin;
}

public String  getDateFinMax(){
    return dateFinMax;
}

public void setDateFinMax(String  dateFinMax){
     this.dateFinMax = dateFinMax;
}

public String  getReferenceSociete(){
    return referenceSociete;
}

public void setReferenceSociete(String  referenceSociete){
     this.referenceSociete = referenceSociete;
}

public String  getTotalCharge(){
    return totalCharge;
}

public void setTotalCharge(String  totalCharge){
     this.totalCharge = totalCharge;
}

public String  getTotalChargeMin(){
    return totalChargeMin;
}

public void setTotalChargeMin(String  totalChargeMin){
     this.totalChargeMin = totalChargeMin;
}

public String  getTotalChargeMax(){
    return totalChargeMax;
}

public void setTotalChargeMax(String  totalChargeMax){
     this.totalChargeMax = totalChargeMax;
}

public String  getTotalProduit(){
    return totalProduit;
}

public void setTotalProduit(String  totalProduit){
     this.totalProduit = totalProduit;
}

public String  getTotalProduitMin(){
    return totalProduitMin;
}

public void setTotalProduitMin(String  totalProduitMin){
     this.totalProduitMin = totalProduitMin;
}

public String  getTotalProduitMax(){
    return totalProduitMax;
}

public void setTotalProduitMax(String  totalProduitMax){
     this.totalProduitMax = totalProduitMax;
}

public String  getResultat(){
    return resultat;
}

public void setResultat(String  resultat){
     this.resultat = resultat;
}

public String  getResultatMin(){
    return resultatMin;
}

public void setResultatMin(String  resultatMin){
     this.resultatMin = resultatMin;
}

public String  getResultatMax(){
    return resultatMax;
}

public void setResultatMax(String  resultatMax){
     this.resultatMax = resultatMax;
}

public List<CpcSousClasseVo> getCpcSousClassesVo(){
    return cpcSousClassesVo;
}

public void setCpcSousClassesVo(List<CpcSousClasseVo> cpcSousClassesVo){
     this.cpcSousClassesVo = cpcSousClassesVo;
}




}