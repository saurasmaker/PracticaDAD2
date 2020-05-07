package edu.ucam.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.classes.User;
import edu.ucam.database.LoadData;

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
		User user;
		
		String username = request.getParameter(User.USER_USERNAME_PARAM);
		String password = request.getParameter(User.USER_PASSWORD_PARAM);

		user = checkLogin(username, password);	
		try {			
			if(user!=null) {
				System.out.println("check true");
				System.out.println(user.getUsername());
				request.getSession().setAttribute(User.USER_PARAM, user);
			}
		}
		catch(Exception e) {
			request.setAttribute("MSG_ERROR", "Usuario o clave incorrectos");
		}
		
		if(user == null) {
			request.getRequestDispatcher("/GoTo?GO_TO=/src/login_error.jsp").forward(request, response);
			return;
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
	
	private User checkLogin(String username, String password) {
		
		User user = null;
		ArrayList<User> usersList = new ArrayList<User>();
		LoadData.loadUsers(usersList);
		
		for(User u: usersList) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
				user = u;
				break;
			}
		}
		
		return user;
	}

}
