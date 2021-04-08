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
import edu.ucam.database.LoadDataReferences;
import edu.ucam.database.SaveDataByReference;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User newUser = new User();
		newUser.setUsername(request.getParameter(User.USER_USERNAME_PARAM));
		newUser.setEmail(request.getParameter(User.USER_EMAIL_PARAM));
		newUser.setPassword(request.getParameter(User.USER_PASSWORD_PARAM));
		newUser.setAddress(request.getParameter(User.USER_ADDRESS_PARAM));

		String error = checkRegister(request.getContextPath(), newUser, request.getParameter(User.USER_REPEAT_PASSWORD_PARAM));
		
		if(error==null) {
			
			String biography;
			if((biography = request.getParameter(User.USER_BIOGRAPHY_PARAM)) == null) newUser.setBiography("NULL");
			else newUser.setBiography(biography);
			
			if(newUser.getUsername()!=null) {
				ArrayList<String> usersReferences = new ArrayList<String>();
				LoadDataReferences.loadUsersReferences(request.getContextPath(), usersReferences);	
			
				User.generateIdByReference(newUser, usersReferences);
			
				SaveDataByReference.User(request.getContextPath(), newUser);
			}
			
			request.getRequestDispatcher("/GoTo?GO_TO=/src/register_success.jsp").forward(request, response);
			
		}
		
		else {
			request.getSession().setAttribute("ERROR", error);
			request.getRequestDispatcher("/GoTo?GO_TO=/src/register_error.jsp?ERROR=" + error).forward(request, response);
		}
		
		
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String checkRegister(String contextPath, User user, String repeatPass) {
		
		ArrayList<User> usersList = new ArrayList<User>();
		LoadData.loadUsers(contextPath, usersList);
		
		if(!user.getPassword().equals(repeatPass))
			return "Las contraseñas no coinciden. Por favor inténtelo de nuevo.";
		
		for(User u: usersList) {
			if(u.getEmail().equals(user.getEmail())) 
				return "Este correo electrónico ya ha sido utilizado.";
			
			if(u.getUsername().equals(user.getUsername())) 
				return "Este nombre de usuario ya ha sido utilizado.";

		}
		
		return null;
	}

}
