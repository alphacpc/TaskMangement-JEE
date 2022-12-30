package com.actions.delete;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.bdd.LabelModel;
import com.models.bdd.UsersModel;


@WebServlet(urlPatterns = { "/delete/utilisateur" })
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDelete(request, response);
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		UsersModel user = new UsersModel();
	
		user.deleteUser(userid);
		
		response.sendRedirect("/TasksManagement/utilisateurs");
		
		response.getWriter().append("Suppression avec succes de : "+ userid).append(request.getContextPath());
	}

}
