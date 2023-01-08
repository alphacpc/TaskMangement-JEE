package com.models.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.models.beans.LabelBean;
import com.models.beans.TaskBean;
import com.models.beans.User;

public class LabelModel {

	private Connection connexion = new ConnectDB().loadDatabase();
	
	public List<LabelBean> getLabels() {
		
		List<LabelBean> ListLabels = new ArrayList<LabelBean>();
		ResultSet result;
		
		try {
			
			result = connexion.createStatement().executeQuery("SELECT * FROM Labels;");
			
			while (result.next()) {
				String title = result.getString("title");
				String code = result.getString("code");
				int id = result.getInt("labelid");
				
				LabelBean label = new LabelBean();
				label.setTitle(title);
				label.setCode(code);
				label.setId(id);
				
				ListLabels.add(label);
			}
		}
		catch(SQLException e){
			System.out.println(e);
		}
		
		return ListLabels;
	}
	
	public List<LabelBean> getLabelsMin() {
		
		List<LabelBean> ListLabels = new ArrayList<LabelBean>();
		ResultSet result;
		
		try {
			
			result = connexion.createStatement().executeQuery("SELECT * FROM Labels;");
			
			while (result.next()) {
				LabelBean label = new LabelBean();
				label.setTitle(result.getString("title"));
				label.setId(result.getInt("labelid"));
				
				ListLabels.add(label);
			}
		}
		catch(SQLException e){
			System.out.println(e);
		}
		
		return ListLabels;
	}
	
	public LabelBean getLabelById(String labelid) {
		LabelBean label = new LabelBean();
		
		try {
			
			String query = "SELECT * FROM Labels WHERE labelid="+ labelid +";";
						
			ResultSet result = connexion.createStatement().executeQuery(query);

			while (result.next()) {
				label.setTitle(result.getString("title"));
				label.setCode(result.getString("code"));
			}
				
		}
		catch(SQLException e){
			System.out.println(e);
		}
		
		return label;
	}
	
	
	public LabelBean getLabelTask(String labelid){
		LabelBean label = new LabelBean();
		ResultSet result;
		
		try {
			
			result = connexion.createStatement().executeQuery("SELECT title, code FROM Labels WHERE labelid = "+ labelid +";");
			
			while (result.next()) {
				label.setTitle(result.getString("title"));
				label.setCode(result.getString("code"));
			}
		}
		catch(SQLException e){
			System.out.println(e);
		}
		
		return label;
	}
	
	public void addLabelModel(LabelBean label){
		
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String formattedDate = myDateObj.format(myFormatObj);
		
		try {
			
			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO Labels(labelid, title, code, updatedAt) VALUES(?, ?, ?);");
			
			preparedStatement.setString(1, null);
			preparedStatement.setString(2, label.getTitle());
			preparedStatement.setString(3, label.getCode());
			preparedStatement.setString(4, formattedDate);
			
			preparedStatement.execute();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public String deleteLabel(String id) {
		
		String result;
		
		try {
			String query = "DELETE FROM Labels WHERE Labels.labelid ="+ id +";";
			
			PreparedStatement preparedStatement = connexion.prepareStatement(query);
			
			preparedStatement.execute();
			
			result = "Suppression avec succès !";
			
		}catch(SQLException e){
			e.printStackTrace();
			result = "Erreur de requete !!!";
		}
		
		return result;
	}
	
	
	public String updateLabel(LabelBean label, String labelid) {
		
		String result;
		
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String formattedDate = myDateObj.format(myFormatObj);
		
		try {
			String query = "UPDATE Labels SET title = ?, code = ?, updatedAt = ? WHERE Labels.labelid ="+ labelid +";";
			
			PreparedStatement preparedStatement = connexion.prepareStatement(query);
			
			preparedStatement.setString(1, label.getTitle());
			preparedStatement.setString(2, label.getCode());
			preparedStatement.setString(3, formattedDate);
			
			preparedStatement.execute();
			
			result = "Mis à jour avec succès !";
			
		}catch(SQLException e){
			e.printStackTrace();
			result = "Erreur de requete !!!";
		}
		
		return result;
	}
	
}
