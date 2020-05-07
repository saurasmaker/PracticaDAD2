package edu.ucam.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GoTo
 */
@WebServlet("/GoTo")
public class GoTo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoTo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String goTo = (String)request.getParameter("GO_TO");
		String setParameter = null;
		if(goTo!=null) {
			switch(goTo) {
			case "/index.jsp":
				request.getSession().setAttribute("CURRENT_PAGE", "CATALOGUE");
				break;
			case "/src/search_catalogue.jsp":
				request.getSession().setAttribute("CURRENT_PAGE", "CATALOGUE");
				setParameter = "?SEARCH=" + request.getParameter("SEARCH");
				break;
			case "/src/promos.jsp":
				request.getSession().setAttribute("CURRENT_PAGE", "PROMO");
				break;
			case "/src/administer.jsp":
				request.getSession().setAttribute("CURRENT_PAGE", "ADMINISTER");
				break;
			case "/src/login_error.jsp":				
				request.getSession().setAttribute("CURRENT_PAGE", "LOGIN_ERROR");
				break;
			case "/src/register_error.jsp":
				request.getSession().setAttribute("ERROR", request.getAttribute("ERROR"));
				request.getSession().setAttribute("CURRENT_PAGE", "ADMINISTER");
				break;
			}
		}
		else {
			goTo = "/index.jsp";
		}
		
		if(setParameter != null)
			goTo += setParameter; 
		
		request.getRequestDispatcher(goTo).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
