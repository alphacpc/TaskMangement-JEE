package com.controller.forms;

import javax.servlet.http.HttpServletRequest;

public class UserForm {
	
	public String addUser(HttpServletRequest request){	
		String pass = request.getParameter("pwd");
		String passc = request.getParameter("pwdc");
		
		if(pass.equals(passc)) {
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String job = request.getParameter("job");
			
			return email + " Created with success !!!";
		}
		else {
			return "Les deux mots de passe ne sont pas identiques !";
		}			
	}
	
	
}
