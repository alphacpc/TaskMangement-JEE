package com.users.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.forms.UserForm;
import com.models.beans.User;


@WebServlet("/connexion")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("profil") != null) {
			if(session.getAttribute("profil").equals("admin")) {
				response.sendRedirect("/TasksManagement/utilisateurs");
			}else {
				response.sendRedirect("/TasksManagement/taches");
			}
		}else {
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserForm userForm = new UserForm();
		User user = userForm.checkUser(request);
	
		if( user.getEmail() != null && user.getProfil() != null) {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("profil", user.getProfil());
			session.setAttribute("email", user.getEmail());
			session.setAttribute("userid", user.getUserid());
			
			if(user.getProfil().equals("admin")) {
				response.sendRedirect("/TasksManagement/utilisateurs");
			}else {
				response.sendRedirect("/TasksManagement/taches");
			}
			
		}else {
			doGet(request, response);
		}
	}

}
