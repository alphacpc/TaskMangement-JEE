package com.models.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.models.beans.TaskBean;
import com.models.beans.User;


public class TaskModel {
	
	private Connection connexion = new ConnectDB().loadDatabase();

	public List<TaskBean> getTasks(){
		List<TaskBean> taskList = new ArrayList<TaskBean>();
		ResultSet result;
			
		try {
			
			result = connexion.createStatement().executeQuery("SELECT * FROM Tasks;");
			
			while (result.next()) {
				String title = result.getString("title");
				int id = result.getInt("taskid");
				
				TaskBean task = new TaskBean();
				task.setTitle(title);
				task.setTaskid(id);;
				
				taskList.add(task);
			}
		}
		catch(SQLException e){
			System.out.println(e);
		}
		
		return taskList;
	}
	
	
	
	public List<TaskBean> getUserTasks(String userid){
		
		List<TaskBean> taskList = new ArrayList<TaskBean>();
		ResultSet result;
			
		try {
			
			result = connexion.createStatement().executeQuery("SELECT * FROM Tasks WHERE user_id_task="+ userid +";");
			
			while (result.next()) {
				
				TaskBean task = new TaskBean();
				task.setTitle(result.getString("title"));
				task.setTaskid(result.getInt("taskid"));
				
				taskList.add(task);
			}
		}
		catch(SQLException e){
			System.out.println(e);
		}
		
		return taskList;
	}
	
	
	public TaskBean getTaskById(String userid) {
		TaskBean task = new TaskBean();
	
		try {
			
			String query = "SELECT * FROM Tasks WHERE taskid="+ userid +";";
						
			ResultSet result = connexion.createStatement().executeQuery(query);

			while (result.next()) {
				task.setTaskid(result.getInt("taskid"));
				task.setTitle(result.getString("title"));
				task.setDesc(result.getString("description"));
			}
				
		}
		catch(SQLException e){
			System.out.println(e);
		}
		
		return task;
	}
	
	
	public String deleteTask(String id) {
		
		String result;
		
		try {
			String query = "DELETE FROM Tasks WHERE Tasks.taskid ="+ id +";";
			
			PreparedStatement preparedStatement = connexion.prepareStatement(query);
			preparedStatement.execute();
			
			System.out.println(id);
			
			result = "Suppression avec succès !";
			
		}catch(SQLException e){
			e.printStackTrace();
			result = "Erreur de requete !!!";
		}
		
		return result;
	}
	
	public void addTaskModel(TaskBean task){
		
		try {
			String query = "INSERT INTO Tasks(taskid, title, description, label, user_id_task) VALUES(?, ?, ?, ?, ?);";
			PreparedStatement preparedStatement = connexion.prepareStatement(query);
			
			preparedStatement.setString(1, null);
			preparedStatement.setString(2, task.getTitle());
			preparedStatement.setString(3, task.getDesc());
			preparedStatement.setString(4, task.getLabelid());
			preparedStatement.setString(5, task.getUserid());
			
			preparedStatement.execute();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
}
