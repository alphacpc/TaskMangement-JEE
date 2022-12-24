package com.controller.forms;

import javax.servlet.http.HttpServletRequest;

import com.models.bdd.UsersModel;
import com.models.beans.User;

public class UserForm {
	
	public String addUser(HttpServletRequest request){	

		User new_user = new User();
		new_user.setFname(request.getParameter("fname"));
		new_user.setLname(request.getParameter("lname"));
		new_user.setEmail(request.getParameter("email"));
		new_user.setJob(request.getParameter("job"));
		new_user.setPwd(request.getParameter("pwd"));
		
		System.out.println("Premier phase de test not working");
		
		UsersModel new_user_model = new UsersModel();
		new_user_model.addUserModel(new_user);
		
		return "Création de compte de " + request.getParameter("email");
	}
}
