package com.persistance;
import java.util.*;
import com.metier.*;
public class AccesData {
	
	public static TypeChargeDAO tcDAO;
	public static BorneDAO bDAO;
	public static StationDAO sDAO;
	
	public static ArrayList<TypeCharge> getListeTypeCharge(){
		return getTypeChargeDAO().retrieve();
	}
	
	public static ArrayList<Station> getListeStation(){
		return getStationDAO().retrieve();
	}
	
	public static ArrayList<Borne> getListBorne(){
		return getBorneDAO().retrieve();
	}
	
	public static ArrayList<Borne> getBorneStation(int idStation){
		return getBorneDAO().retrieve2(idStation);
	}
	
	public static TypeCharge getTypeCharge(int idType){
		return getTypeChargeDAO().find(idType);
	}
	
	private static BorneDAO getBorneDAO(){
		bDAO=new BorneDAO();
		return bDAO;
	}
	
	private static TypeChargeDAO getTypeChargeDAO(){
		tcDAO= new TypeChargeDAO();
		return tcDAO;
	}
	
	private static StationDAO getStationDAO(){
		sDAO=new StationDAO();
		return sDAO;
	}
	
	public boolean addTypeCharge(TypeCharge t)
	{
		boolean result = tcDAO.create(t);
		return result;
	}
	
	public boolean deleteTypeCharge(TypeCharge t)
	{
		boolean resultat = tcDAO.delete(t);
		return resultat;
	}
	
	public boolean updateTypeCharge(TypeCharge t)
	{
		boolean resultat = tcDAO.update(t);
		return resultat;
	}
}
