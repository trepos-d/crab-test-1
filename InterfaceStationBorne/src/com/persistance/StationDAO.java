package com.persistance;
import java.util.ArrayList;

import com.metier.*;

import java.sql.*;
public class StationDAO extends DAO<Station> {

	public StationDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Station obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Station obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Station obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Station find(int id) {
		Station s= null;
		
		int idStation;
		String libelle;
		
		BorneDAO b;
		b=new BorneDAO();
		
		String sql="select* from Station where idStation="+id;
		
		ResultSet rs;
		
		try{
        	rs = this.cnx.createStatement().executeQuery(sql);
			while(rs.next())
			{
				idStation=rs.getInt(1);
				libelle=rs.getString(2);
				
				s=new Station(idStation,libelle);
				s.setLesBornes(b.retrieve2(idStation));
			}
		}catch(SQLException e){
	        	e.printStackTrace();
	        	
	        }
			return s;
	}

	@Override
	public ArrayList<Station> retrieve() {
		ArrayList<Station> Stations = new ArrayList<Station>();
		Station s =null;
		Statement req;
		ResultSet resultat;
		try {
		req = this.cnx.createStatement();
		resultat = req.executeQuery("select idStation from Station;");
		while (resultat.next())
		{
		int idStation = resultat.getInt(1);
		s = find(idStation);
		Stations.add(s);
		}

		} 
		catch (SQLException e) 
		{
		System.out.println("Problème d'accès à la base !");
		System.out.println(e);
		} 
		return Stations;
		}

}
