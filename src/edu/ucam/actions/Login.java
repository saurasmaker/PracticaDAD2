package edu.ucam.actions;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.classes.User;
import edu.ucam.database.LoadData;


public class Login extends Action {


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		if(user == null)
			return "/GoTo?GO_TO=/src/login_error.jsp";
		
		return "/index.jsp";
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
