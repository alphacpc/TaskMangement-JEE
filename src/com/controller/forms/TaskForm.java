package com.controller.forms;

import javax.servlet.http.HttpServletRequest;

import com.models.bdd.TaskModel;
import com.models.beans.TaskBean;

public class TaskForm {
	public String addTask(HttpServletRequest request){	
		
		TaskBean task = new TaskBean();
		TaskModel taskModel = new TaskModel();
		
		task.setTitle(request.getParameter("title"));
		task.setDesc(request.getParameter("desc"));
		task.setLabelid(request.getParameter("labelid"));
		task.setUserid(request.getParameter("userid"));
		
		taskModel.addTaskModel(task);

		return " created with success !";
	}
}
