package com.models.bdd;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
				
				User user = new User();
				user.setUserid(result.getInt("userid"));
				user.setFname(result.getString("fname"));
				user.setLname(result.getString("lname"));
				user.setEmail(result.getString("email"));
				user.setJob(result.getString("profession"));
				
				users.add(user);
			}
		}
		catch(SQLException e){
			System.out.println(e);
		}
		
		return users;
	}
	
	public List<User> getUsersMin(){
		List<User> users = new ArrayList<User>();
		ResultSet result;
			
		try {
			
			result = connexion.createStatement().executeQuery("SELECT userid, email, profession FROM Users;");
			
			while (result.next()) {
				
				User user = new User();
				user.setUserid(result.getInt("userid"));
				user.setEmail(result.getString("email"));
				user.setJob(result.getString("profession"));
				
				users.add(user);
			}
		}
		catch(SQLException e){
			System.out.println(e);
		}
		
		return users;
	}
	
	
	public User getUserTask(String userid){
		User user = new User();
		ResultSet result;
			
		try {
			
			result = connexion.createStatement().executeQuery("SELECT fname, lname FROM Users WHERE userid = "+ userid +";");
			
			while (result.next()) {
				user.setFname(result.getString("fname"));
				user.setLname(result.getString("lname"));
			}
		}
		catch(SQLException e){
			System.out.println(e);
		}
		
		return user;
	}
	
	
	public void addUserModel(User user){
		
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String formattedDate = myDateObj.format(myFormatObj);
		
		try {
			String query = "INSERT INTO Users(userid, fname, lname, email, profession, pwd, updatedAt) VALUES(NULL, ?, ?, ?, ?, ?);";
			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO Users(userid, fname, lname, email, profession, pwd) VALUES(?, ?, ?, ?, ?, ?);");
			
			preparedStatement.setString(1, null);
			preparedStatement.setString(2, user.getFname());
			preparedStatement.setString(3, user.getLname());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getJob());
			preparedStatement.setString(6, user.getPwd());
			preparedStatement.setString(7, formattedDate);
			
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
				user.setUserid(result.getInt("userid"));
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
	
	
	public String deleteUser(String id) {
		
		String result;
		
		try {
			
			try {
				String query_task = "DELETE FROM Tasks WHERE Tasks.user_id_task ="+ id +";";
				PreparedStatement preparedStatement_task = connexion.prepareStatement(query_task);
				preparedStatement_task.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			String query = "DELETE FROM Users WHERE Users.userid ="+ id +";";
			PreparedStatement preparedStatement = connexion.prepareStatement(query);
			
			preparedStatement.execute();
			
			result = "Suppression avec succès !";
			
		}catch(SQLException e){
			e.printStackTrace();
			result = "Erreur de requete !!!";
		}
		
		return result;
	}
	
	
	public String updateUser(User user, String userid) {
		
		String result;
		
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String formattedDate = myDateObj.format(myFormatObj);
		
		try {
			String query = "UPDATE Users SET fname = ?, lname = ?, email = ?, profession = ?, updatedAt = ? WHERE Users.userid ="+ userid +";";
			
			PreparedStatement preparedStatement = connexion.prepareStatement(query);
			
			preparedStatement.setString(1, user.getFname());
			preparedStatement.setString(2, user.getLname());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getJob());
			preparedStatement.setString(5, formattedDate);
			
			preparedStatement.execute();
			
			result = "Mis à jour avec succès !";
			
		}catch(SQLException e){
			e.printStackTrace();
			result = "Erreur de requete !!!";
		}
		
		return result;
	}
	
	
	public User connectUser(String email, String pwd){
		User user = new User();
		
		try {
			String query = "SELECT userid, email, pwd, profil FROM Users WHERE Users.email = '"+ email +"';";
			ResultSet result = connexion.createStatement().executeQuery(query);
			
			while (result.next()) {
				user.setUserid(result.getInt("userid"));
				user.setEmail(result.getString("email"));
				user.setProfil(result.getString("profil"));
				user.setPwd(result.getString("pwd"));
			}
			
			if(pwd.toString().equals(user.getPwd())) {
				return user;
			}else {
				return new User();
			}

		}
		catch(SQLException e){
			System.out.println(e);
		}
		
		return user;
	}
	
}
