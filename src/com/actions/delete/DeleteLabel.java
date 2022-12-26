package com.actions.delete;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.bdd.LabelModel;

@WebServlet(
		urlPatterns = { "/delete/label" }, 
		initParams = { 
				@WebInitParam(name = "id", value = "1")
		})
public class DeleteLabel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteLabel() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doDelete(request, response);
		
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String labelid = request.getParameter("id");
		LabelModel label = new LabelModel();
	
		label.deleteLabel(labelid);
		
		response.getWriter().append("Suppression avec succes de : "+ labelid).append(request.getContextPath());
	}

}
