package edu.ucam.actions;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.classes.User;
import edu.ucam.database.LoadData;
import edu.ucam.database.LoadDataReferences;
import edu.ucam.database.SaveDataByReference;

public class Register extends ServletAction {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
		
		else return "/src/register_error.jsp?ERROR=" + error;
		
		
		return "/src/register_success.jsp";
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
