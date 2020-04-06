package edu.ucam.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionLogin extends ServletAction {

	public static final String NAME = "LOGIN";
	
	@Override
	public void ejecutar(HttpServletRequest request,
			HttpServletResponse response) {	
		
		super.addAtributo("banner","/jsp/tiles/banner.jsp");
		super.addAtributo("menu" , "/jsp/tiles/common_menu.jsp");
		super.addAtributo("body" , "/jsp/tiles/body_servlet.jsp");
		super.addAtributo("footer" , "/jsp/tiles/credits.jsp");

		
		super.renderPage(request, response);
	}

}
