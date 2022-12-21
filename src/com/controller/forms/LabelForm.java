package com.controller.forms;

import javax.servlet.http.HttpServletRequest;

public class LabelForm {
	public String addLabel(HttpServletRequest request){	
		String title = request.getParameter("title");
		String code = request.getParameter("code");
		
		return title + " created with success !";
	}
}
