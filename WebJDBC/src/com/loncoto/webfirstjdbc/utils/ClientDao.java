package com.loncoto.webfirstjdbc.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.loncoto.webfirstjdbc.beans.Client;

public class ClientDao {

	private Connection conbase;
	private PreparedStatement findAllStatement;
	private PreparedStatement findByIdStatement;
	public static final String findAllSql = "select * from client";
	public static final String findByIdSql = "select * from client where id=?";
	
	public ClientDao (Connection conbase) {
		this.conbase = conbase;
		this.findAllStatement = findAllStatement;	
		this.findByIdStatement = findByIdStatement;
		try {
			findAllStatement = conbase.prepareStatement(findAllSql);
			findByIdStatement = conbase.prepareStatement("findByIdSql");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Client> findAll() {
		ArrayList<Client> data = new ArrayList<Client>();
		try {
			findAllStatement.clearParameters();
			ResultSet rs = findAllStatement.executeQuery(findAllSql);
			Client client = new Client();
			while(rs.next()){
				rs.getInt("id"); 
				rs.getString("nom"); 
				rs.getString("email"); 
				rs.getDouble("solde");
				data.add(client);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public Client findById(int id){
		Client c = null;
		try {
			findByIdStatement.clearParameters();
			findByIdStatement.setInt(1, id);
			ResultSet rs = findByIdStatement.executeQuery(findByIdSql);
			if (rs.next()){
				c = new Client();
				rs.getInt("id"); 
				rs.getString("nom"); 
				rs.getString("email"); 
				rs.getDouble("solde");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
} 
