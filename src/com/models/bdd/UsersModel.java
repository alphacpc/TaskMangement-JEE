package com.models.bdd;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.models.beans.User;

public class UsersModel {
	public List<User> getUsers(){
		List<User> users = new ArrayList<User>();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
		}
		catch(ClassNotFoundException e){
			System.out.println(e);
		}
		
		Connection connexion;
		//Statement statement;
		ResultSet result;
		
		try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercice1", "root", "");
			// connexion.createStatement();
			result = connexion.createStatement().executeQuery("SELECT * FROM vehicules;");
			
			while (result.next()) {
				String fname = result.getString("marque");
				
				User user = new User();
				user.setFname(fname);
				
				users.add(user);
			}
		}
		catch(SQLException e){
			System.out.println(e);
		}
		
		return users;
	}
}
