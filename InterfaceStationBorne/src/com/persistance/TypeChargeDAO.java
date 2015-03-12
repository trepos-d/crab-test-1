package com.persistance;
import java.util.ArrayList;

import com.metier.*;

import java.sql.*;
public class TypeChargeDAO extends DAO<TypeCharge> {

	public TypeChargeDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(TypeCharge obj) {
		String sql="insert into TypeRecharge(libelleType,puissance) Values('"+obj.getLibelleTypeCharge()+"',"+obj.getPuissanceTypeCharge()+");";
	
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
	public boolean delete(TypeCharge obj) {
		String sql="delete from TypeRecharge where idTypeRecharge="+obj.getCodeTypeCharge()+";";
		
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
	public boolean update(TypeCharge obj) {
		String sql="Update TypeRecharge set libelleType='"+obj.getLibelleTypeCharge()+"',puissance="+obj.getPuissanceTypeCharge()+"where idTypeRecharge="+obj.getCodeTypeCharge()+";";
		
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
	public TypeCharge find(int id) {
		TypeCharge t =null;
		
		int codeType;
        String libelle;
        int puissance;
		
        String sql;
        sql="select * from TypeRecharge where idTypeRecharge="+id;
        
        ResultSet rs;
        
        try{
        	rs = this.cnx.createStatement().executeQuery(sql);
			while(rs.next())
			{
				codeType = rs.getInt(1);
				libelle=rs.getString(2);
				puissance = rs.getInt(3);
				
				t = new TypeCharge(codeType,libelle,puissance);
			}
			}catch(SQLException e){
	        	e.printStackTrace();
	        	
	        }
			return t;
	}

	@Override
	public ArrayList<TypeCharge> retrieve() {
		
		TypeCharge t = null;
		
		ArrayList<TypeCharge> lesTypes = new ArrayList<TypeCharge>();
        int codeType;
        String libelle;
        int puissance;

        String sql;
        sql = "select * from TypeRecharge;";

        ResultSet rs;
        
        try{
        	rs = this.cnx.createStatement().executeQuery(sql);
			while(rs.next())
			{
				codeType = rs.getInt(1);
				libelle=rs.getString(2);
				puissance = rs.getInt(3);
				t = new TypeCharge(codeType,libelle,puissance);
				lesTypes.add(t);
			}
			
        }catch(SQLException e){
        	e.printStackTrace();
        	
        }
        return lesTypes;
        
	}
	
}
