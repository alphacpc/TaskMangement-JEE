package com.users.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.forms.UserForm;
import com.models.beans.User;


@WebServlet("/connexion")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserForm userForm = new UserForm();
		User user = userForm.checkUser(request);
		
		System.out.println(user.getEmail());
		
		if( user.getEmail() != null) {
			response.sendRedirect("/TasksManagement/utilisateurs");
		}else {
			doGet(request, response);
		}
	}

}
