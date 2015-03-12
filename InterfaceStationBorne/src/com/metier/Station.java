package com.metier;
import java.util.ArrayList;
public class Station {
private int idStation;
private String libelleEmplacement;
private ArrayList<Borne> lesBornes;
public Station(int idStation, String libelleEmplacement) {
super();
this.idStation = idStation;
this.libelleEmplacement = libelleEmplacement;
this.lesBornes =new ArrayList<Borne>();
}
public Station(String libelleEmplacement) {
	super();
	this.libelleEmplacement = libelleEmplacement;
	this.lesBornes = new ArrayList<Borne>();
}
@Override
public String toString() {
	return "Station [idStation=" + idStation + ", libelleEmplacement="
			+ libelleEmplacement + ", lesBornes=" + lesBornes + "]";
}
public String getLibelleEmplacement() {
return libelleEmplacement;
}
public void setLibelleEmplacement(String libelleEmplacement) {
this.libelleEmplacement = libelleEmplacement;
}
public ArrayList<Borne> getLesBornes() {
return lesBornes;
}
public void setLesBornes(ArrayList<Borne> lesBornes) {
this.lesBornes = lesBornes;
}
public int getIdStation() {
return idStation;
}
}