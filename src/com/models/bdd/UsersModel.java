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
				int userid = result.getInt("userid");
				String fname = result.getString("fname");
				String lname = result.getString("lname");
				String email = result.getString("email");
				String profession = result.getString("profession");
				
				User user = new User();
				user.setUserid(userid);
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
	
	public User getUserById(String userid) {
		User user = new User();
	
		try {
			
			String query = "SELECT * FROM Users WHERE userid="+ userid +";";
						
			ResultSet result = connexion.createStatement().executeQuery(query);

			while (result.next()) {
				user.setFname(result.getString("fname"));
				user.setLname(result.getString("lname"));
				user.setEmail(result.getString("email"));
				user.setJob(result.getString("profession"));
			}
				
		}
		catch(SQLException e){
			System.out.println(e);
		}
		
		return user;
	}
	
	
	
}
