package edu.ucam.classes;

import java.util.ArrayList;

public class User {

	//Static Atributes
	public static String USER_PARAM = "USER_PARAM", USER_USERNAME_PARAM = "USER_USERNAME_PARAM", USER_EMAIL_PARAM = "USER_EMAIL_PARAM", USER_PASSWORD_PARAM = "USER_PASSWORD_PARAM", 
			USER_ID_PARAM = "USER_ID_PARAM", USER_BIOGRAPHY_PARAM = "USER_BIOGRAPHY_PARAM", USER_ADDRESS_PARAM = "USER_ADDRESS_PARAM";
	
	//Attributes
	String username, email, password, id, biography, address;
	
	
	//Contructors
	public User() {
		
	}
	
	public User(String username, String email, String password, String id) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.id = id;
	}
	
	
	//Method
	
	
	
	//Static Methods
	static public void generateId(User user, ArrayList<User> users) {
		//Id Example -> U12223245; The id of the users have 1 character 'U' and 8 numbers. If the user is an admin, the character will be a 'A'.
		
		if(!(users.size() > 0)) {
			user.setId("U0");
			return;
		}
		
		String newId = "U" + (Integer.parseInt(users.get(users.size()-1).getId().substring(1))+1);
		user.setId(newId);
		
		return;
	}

	static public void generateIdByReference(User user, ArrayList<String> users) {
		//Id Example -> U12223245; The id of the users have 1 character 'U' and 8 numbers. If the user is an admin, the character will be a 'A'.
		if(!(users.size() > 0)) {
			user.setId("U0");
			return;
		}
		
		String previus = users.get(users.size()-1);
		String newId = "U" + (Integer.parseInt(previus.substring(1))+1);
		user.setId(newId);
		
		return;
	}
	//Getters & Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
