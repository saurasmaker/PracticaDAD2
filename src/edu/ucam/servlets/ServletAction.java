package edu.ucam.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ServletAction {
	
	public abstract String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;
	
}
