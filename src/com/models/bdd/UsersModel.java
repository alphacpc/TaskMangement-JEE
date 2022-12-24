package com.models.bdd;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.models.beans.User;
import com.models.bdd.ConnectDB;


public class UsersModel {
	
	private Connection connexion = new ConnectDB().loadDatabase();
	
	public List<User> getUsers(){
		List<User> users = new ArrayList<User>();
		ResultSet result;
			
		try {
			
			// connexion.createStatement();
			result = connexion.createStatement().executeQuery("SELECT * FROM Users;");
			
			while (result.next()) {
				String fname = result.getString("fname");
				String lname = result.getString("lname");
				String email = result.getString("email");
				String profession = result.getString("profession");
				
				User user = new User();
				user.setFname(fname);
				user.setLname(lname);
				user.setEmail(email);
				user.setJob(profession);
				
				users.add(user);
			}
		}
		catch(SQLException e){
			System.out.println(e);
		}
		
		return users;
	}
	
	
	public void addUserModel(User user){
		
		try {
			String query = "INSERT INTO Users(userid, fname, lname, email, profession, pwd) VALUES(NULL, ?, ?, ?, ?, ?);";
			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO Users(userid, fname, lname, email, profession, pwd) VALUES(?, ?, ?, ?, ?, ?);");
			
			preparedStatement.setString(1, null);
			preparedStatement.setString(2, user.getFname());
			preparedStatement.setString(3, user.getLname());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getJob());
			preparedStatement.setString(6, user.getPwd());
			System.out.println("Dans addUser Models");
			System.out.println(user.getEmail());
			
			preparedStatement.execute();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
	
}
