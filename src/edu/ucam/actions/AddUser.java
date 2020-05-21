package edu.ucam.actions;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.classes.User;
import edu.ucam.database.LoadDataReferences;
import edu.ucam.database.SaveDataByReference;


public class AddUser extends ServletAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User newUser = new User();
		newUser.setUsername(request.getParameter(User.USER_USERNAME_PARAM));
		newUser.setEmail(request.getParameter(User.USER_EMAIL_PARAM));
		newUser.setPassword(request.getParameter(User.USER_PASSWORD_PARAM));
		newUser.setAddress(request.getParameter(User.USER_ADDRESS_PARAM));
		
		String biography;
		if((biography = request.getParameter(User.USER_BIOGRAPHY_PARAM)) == null) newUser.setBiography("NULL");
		else newUser.setBiography(biography);
		
		if(newUser.getUsername()!=null) {
			ArrayList<String> usersReferences = new ArrayList<String>();
			LoadDataReferences.loadUsersReferences(usersReferences);	
		
			User.generateIdByReference(newUser, usersReferences);
		
			SaveDataByReference.User(newUser);
		}
				
		return "/src/administer.jsp";
	}

}
