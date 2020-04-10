package com.zsmart.accountingProject.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;


public class OperationComptableVo{

private String id ;
private String libelle ;
private String referenceSociete ;
private String referenceFacture ;
private String debit;
private String debitMin ;
private String debitMax ;
private String credit;
private String creditMin ;
private String creditMax ;
private String dateOperationComptable;
private String dateOperationComptableMin ;
private String dateOperationComptableMax ;
private String dateSaisie;
private String dateSaisieMin ;
private String dateSaisieMax ;
private CaisseVo caisseVo ;
private CompteBanquaireVo compteBanquaireVo ;
private CompteComptableVo compteComptableVo ;
private OperationComptableGroupeVo operationComptableGroupeVo ;
private FactureVo factureVo ;



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

public String  getReferenceSociete(){
    return referenceSociete;
}

public void setReferenceSociete(String  referenceSociete){
     this.referenceSociete = referenceSociete;
}

public String  getReferenceFacture(){
    return referenceFacture;
}

public void setReferenceFacture(String  referenceFacture){
     this.referenceFacture = referenceFacture;
}

public String  getDebit(){
    return debit;
}

public void setDebit(String  debit){
     this.debit = debit;
}

public String  getDebitMin(){
    return debitMin;
}

public void setDebitMin(String  debitMin){
     this.debitMin = debitMin;
}

public String  getDebitMax(){
    return debitMax;
}

public void setDebitMax(String  debitMax){
     this.debitMax = debitMax;
}

public String  getCredit(){
    return credit;
}

public void setCredit(String  credit){
     this.credit = credit;
}

public String  getCreditMin(){
    return creditMin;
}

public void setCreditMin(String  creditMin){
     this.creditMin = creditMin;
}

public String  getCreditMax(){
    return creditMax;
}

public void setCreditMax(String  creditMax){
     this.creditMax = creditMax;
}

public String  getDateOperationComptable(){
    return dateOperationComptable;
}

public void setDateOperationComptable(String  dateOperationComptable){
     this.dateOperationComptable = dateOperationComptable;
}

public String  getDateOperationComptableMin(){
    return dateOperationComptableMin;
}

public void setDateOperationComptableMin(String  dateOperationComptableMin){
     this.dateOperationComptableMin = dateOperationComptableMin;
}

public String  getDateOperationComptableMax(){
    return dateOperationComptableMax;
}

public void setDateOperationComptableMax(String  dateOperationComptableMax){
     this.dateOperationComptableMax = dateOperationComptableMax;
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

public CaisseVo  getCaisseVo (){
    return caisseVo ;
}

public void setCaisseVo (CaisseVo  caisseVo ){
     this.caisseVo  = caisseVo ;
}

public CompteBanquaireVo  getCompteBanquaireVo (){
    return compteBanquaireVo ;
}

public void setCompteBanquaireVo (CompteBanquaireVo  compteBanquaireVo ){
     this.compteBanquaireVo  = compteBanquaireVo ;
}

public CompteComptableVo  getCompteComptableVo (){
    return compteComptableVo ;
}

public void setCompteComptableVo (CompteComptableVo  compteComptableVo ){
     this.compteComptableVo  = compteComptableVo ;
}

public OperationComptableGroupeVo  getOperationComptableGroupeVo (){
    return operationComptableGroupeVo ;
}

public void setOperationComptableGroupeVo (OperationComptableGroupeVo  operationComptableGroupeVo ){
     this.operationComptableGroupeVo  = operationComptableGroupeVo ;
}

public FactureVo  getFactureVo (){
    return factureVo ;
}

public void setFactureVo (FactureVo  factureVo ){
     this.factureVo  = factureVo ;
}




}