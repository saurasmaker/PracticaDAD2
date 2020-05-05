package edu.ucam.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.classes.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setUsername(request.getParameter(User.USER_USERNAME_PARAM));
		user.setPassword(request.getParameter(User.USER_PASSWORD_PARAM));
		user.setId("prueba");
		
		try {
			
			if(user.getUsername().equals(user.getPassword())) {
				request.getSession().setAttribute(User.USER_PARAM, user);
			}
			else {
				request.setAttribute("MSG_ERROR", "Usuario o clave incorrectos");
			}
			
			
			
		}
		catch(Exception e) {
			request.setAttribute("MSG_ERROR", "Usuario o clave incorrectos");
		}
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
