package edu.ucam.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.actions.ServletAction;

/**
 * Servlet implementation class Controller
 */
@MultipartConfig
@WebServlet("/Control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String PARAM_ACTION_ID = "PARAM_ACTION_ID";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Control() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String actionId = (String)request.getParameter(Control.PARAM_ACTION_ID);
		ServletAction action = null;
		String jsp = "/src/error.jsp";
	
		try {
			action = (ServletAction)Class.forName("edu.ucam.actions." + actionId).newInstance();
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
