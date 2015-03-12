package com.metier;

public class Borne {
private int idBorne;
private String dateMiseEnService;
private String etat;
private TypeCharge typeCharge;
private int idStation;

public Borne(int idBorne, String dateMiseEnService, TypeCharge typeCharge, int idStation) 
{
super();
this.idBorne = idBorne;
this.dateMiseEnService = dateMiseEnService;
this.etat="ES";
this.typeCharge = typeCharge;
this.idStation=idStation;
}
public Borne(String dateMiseEnService, TypeCharge typeCharge, int idStation) {
	super();
	this.dateMiseEnService = dateMiseEnService;
	this.etat = "ES";
	this.typeCharge = typeCharge;
	this.idStation=idStation;
}
@Override
public String toString() {
	return "Borne [idBorne=" + idBorne + ", dateMiseEnService="
			+ dateMiseEnService + ", etat=" + etat + ", typeCharge="
			+ typeCharge + "]";
}
public int getidStation(){
	return idStation;
}
public void setIdStation(int idStation){
	this.idStation=idStation;
}
public String getDateMiseEnService() {
return dateMiseEnService;
}
public void setDateMiseEnService(String dateMiseEnService) {
this.dateMiseEnService = dateMiseEnService;
}
public String getEtat() {
return etat;
}
public void setEtat(String etat) {
this.etat = etat;
}
public TypeCharge getTypeCharge() {
return typeCharge;
}
public void setTypeCharge(TypeCharge typeCharge) {
this.typeCharge = typeCharge;
}
public int getIdBorne() {
return idBorne;
}
}
