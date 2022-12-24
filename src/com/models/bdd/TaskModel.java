package com.models.bdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.models.beans.TaskBean;


public class TaskModel {
	
	private Connection connexion = new ConnectDB().loadDatabase();

	public List<TaskBean> getTasks(){
		List<TaskBean> taskList = new ArrayList<TaskBean>();
		ResultSet result;
			
		try {
			
			result = connexion.createStatement().executeQuery("SELECT * FROM Tasks;");
			
			while (result.next()) {
				String title = result.getString("title");
				
				TaskBean task = new TaskBean();
				task.setTitle(title);
				
				taskList.add(task);
			}
		}
		catch(SQLException e){
			System.out.println(e);
		}
		
		return taskList;
	}
}
