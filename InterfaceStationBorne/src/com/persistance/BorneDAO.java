package com.persistance;
import java.util.ArrayList;

import com.metier.*;

import java.sql.*;
public class BorneDAO extends DAO<Borne> {

	public BorneDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Borne obj) {
		String sql="insert into Borne(idBorne,dateMiseEnService,idStation,idTypeRecharge) Values('"+obj.getIdBorne()+"',"+obj.getDateMiseEnService()+"',"+obj.getidStation()+"',"+obj.getTypeCharge().getCodeTypeCharge()+");";
		
		boolean result = false;
		
		try{
			cnx.createStatement().executeUpdate(sql);
			result=true;
		}
		catch(SQLException e){
			System.out.println("probleme create");
		}
		this.retrieve();
		return result;
	}

	@Override
	public boolean delete(Borne obj) {
		String sql="delete from TypeRecharge where idBorne="+obj.getIdBorne()+";";
		
		boolean result = false;
		try{
			cnx.createStatement().executeUpdate(sql);
			result=true;
		}
		catch(SQLException e){
			System.out.println("probleme delete");
		}
		this.retrieve();
		return result;	
	}

	@Override
	public boolean update(Borne obj) {
		String sql="Update Borne set dateMiseEnService="+obj.getDateMiseEnService()+"',idStation="+obj.getidStation()+"',idTypeRecharge="+obj.getTypeCharge().getCodeTypeCharge()+"where idBorne='"+obj.getIdBorne()+";";
		
		boolean result = false;
		
		try{
			cnx.createStatement().executeUpdate(sql);
			result=true;
		}
		catch(SQLException e){
			System.out.println("probleme update");
		}
		this.retrieve();
		return result;
	}

	@Override
	public Borne find(int id) {
		Borne b = null;
		
		int idBorne;
		String date;
		int idType;
		int idStation;
		
		TypeChargeDAO t;
		t= new TypeChargeDAO();
		
		String sql ="select * from Borne where idBorne="+id;
		
		ResultSet rs;
		
		try{
			rs = this.cnx.createStatement().executeQuery(sql);
			while(rs.next())
			{
				idBorne = rs.getInt(1);
				date=rs.getString(2);
				idType=rs.getInt(4);
				idStation=rs.getInt(3);
				
				b=new Borne(idBorne,date,t.find(idType),idStation);
			}
		}catch(SQLException e){
        	e.printStackTrace();
		}
	return b;
	}

	@Override
	public ArrayList<Borne> retrieve() {
		Borne b =null;
		ArrayList<Borne> lesBornes = new ArrayList<Borne>();
		int idBorne;
		String date;
		TypeCharge t;
		int idStation;
		TypeChargeDAO typeCharge = new TypeChargeDAO();
		String sql;
		sql="select * from Borne;";
		
		ResultSet rs;
		
		try{
			rs= this.cnx.createStatement().executeQuery(sql);
			while(rs.next())
			{
				idBorne=rs.getInt(1);
				date = rs.getString(2);
				t=typeCharge.find(rs.getInt(4));
				idStation=rs.getInt(3);
				b=new Borne(idBorne,date,t,idStation);
				lesBornes.add(b);
			}
		}catch(SQLException e){
			e.printStackTrace();
        	
        }
		return lesBornes;
		}
	
	public ArrayList<Borne> retrieve2(int idStation){
		Borne b =null;
		ArrayList<Borne> lesBornes = new ArrayList<Borne>();
		int idBorne;
		String date;
		TypeCharge t;
		TypeChargeDAO typeCharge = new TypeChargeDAO();
		String sql;
		sql="select * from Borne where idStation="+idStation;
		
		ResultSet rs;
		
		try{
			rs= this.cnx.createStatement().executeQuery(sql);
			while(rs.next())
			{
				idBorne=rs.getInt(1);
				date = rs.getString(2);
				t=typeCharge.find(rs.getInt(4));
				b=new Borne(idBorne,date,t,idStation);
				lesBornes.add(b);
			}
		}catch(SQLException e){
			e.printStackTrace();
        	
        }
		return lesBornes;
	}
	
}

