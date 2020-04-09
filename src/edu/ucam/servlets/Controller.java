package edu.ucam.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String PARAM_ACTION_ID = "PARAM_ACTION_ID", PARAM_ADD_PRODUCT_ACTION = "PARAM_ADD_PRODUCT_ACTION", PARAM_LOGIN_ACTION = "PARAM_LOGIN_ACTION",
			PARAM_REGISTER_ACTION = "PARAM_REGISTER_ACTION", PARAM_REMOVE_PRODUCT_ACTION = "PARAM_REMOVE_PRODUCT_ACTION";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String actionId = (String)request.getParameter(Controller.PARAM_ACTION_ID);
		ServletAction action = null;
		String jsp = "/html_jsp/error.jsp";
	
		try {
			action = (ServletAction)Class.forName("edu.ucam.servlets." + actionId).newInstance();
			jsp = action.execute(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			request.setAttribute("MSG_ERROR", e.getStackTrace().toString());
		}	
				
		request.getRequestDispatcher(jsp).forward(request, response);
	
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
