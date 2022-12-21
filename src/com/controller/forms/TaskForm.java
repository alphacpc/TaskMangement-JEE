package com.controller.forms;

import javax.servlet.http.HttpServletRequest;

public class TaskForm {
	public String addTask(HttpServletRequest request){	
		String title = request.getParameter("title");
		String desc = request.getParameter("desc");
		String label = request.getParameter("label");
		String user = request.getParameter("user");
		
		return title + " created with success !";
	}
}
