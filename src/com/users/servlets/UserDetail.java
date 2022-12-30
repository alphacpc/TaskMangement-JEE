package com.users.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.forms.UserForm;
import com.models.bdd.UsersModel;
import com.models.beans.User;


@WebServlet("/utilisateur")
public class UserDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		UsersModel userModel = new UsersModel();
		User user = userModel.getUserById(userid);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/Details/user.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		User user = new User();
		
		String userid = request.getParameter("userid");
		user.setFname(request.getParameter("fname"));
		user.setLname(request.getParameter("lname"));
		user.setEmail(request.getParameter("email"));
		user.setJob(request.getParameter("job"));
		
		UsersModel userModel = new UsersModel();
		userModel.updateUser(user, userid);		
		
		doGet(request, response);
	}

}
