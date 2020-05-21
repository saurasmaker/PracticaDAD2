package edu.ucam.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchProduct extends ServletAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().setAttribute("CURRENT_PAGE", "CATALOGUE");
		
		return "/src/search_catalogue.jsp?SEARCH=" + request.getParameter("SEARCH");
	}

}
