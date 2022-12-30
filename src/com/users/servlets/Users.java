package com.users.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.forms.UserForm;
import com.models.beans.User;
import com.models.bdd.UsersModel;

@WebServlet("/utilisateurs")
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Users() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputText = "Ajouter un utilisateur";
		
		UsersModel users = new UsersModel() ;
		List<User> result =  users.getUsers();
		
		request.setAttribute("result", result);
		request.setAttribute("input", inputText);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserForm user = new UserForm();
		String result = user.addUser(request);
		System.out.println(result);
		doGet(request, response);
	}

}
