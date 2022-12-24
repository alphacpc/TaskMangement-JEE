package com.models.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.models.beans.LabelBean;
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
				
				LabelBean label = new LabelBean();
				label.setTitle(title);
				label.setCode(code);
				
				ListLabels.add(label);
			}
		}
		catch(SQLException e){
			System.out.println(e);
		}
		
		return ListLabels;
	}
	
	public void addLabelModel(LabelBean label){
		
		try {
			String query = "INSERT INTO Labels(labelid, title, code) VALUES(NULL, ?, ?);";
			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO Labels(labelid, title, code) VALUES(?, ?, ?);");
			
			preparedStatement.setString(1, null);
			preparedStatement.setString(2, label.getTitle());
			preparedStatement.setString(3, label.getCode());
			
			preparedStatement.execute();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}