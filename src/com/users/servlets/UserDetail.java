package com.users.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		doGet(request, response);
	}

}
