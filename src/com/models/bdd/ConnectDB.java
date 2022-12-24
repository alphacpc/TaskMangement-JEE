package com.models.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	private Connection connexion;
	
	@SuppressWarnings("unused")
	public Connection loadDatabase(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}
		
		try {
			connexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/TasksManagement", "root", "root");
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return connexion;
	}

}
