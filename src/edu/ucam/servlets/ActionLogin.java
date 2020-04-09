package edu.ucam.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.classes.User;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ActionLogin extends ServletAction {
       
	public static String ACTION = "ActionLogin";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionLogin() {
        super();
    }

	

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramUsername = (request.getParameter(User.USER_USERNAME_PARAM)==null)?"":request.getParameter(User.USER_USERNAME_PARAM);
		String paramPass = (request.getParameter(User.USER_PASSWORD_PARAM)==null)?"":request.getParameter(User.USER_PASSWORD_PARAM);
		
		
		if("admin".equalsIgnoreCase(paramUsername)&& "admin".equalsIgnoreCase(paramPass)) {
			User user = new User();
			user.setUsername(paramUsername);
			user.setPassword(paramPass);
			
			request.getSession().setAttribute(User.USER_PARAM, user);
		}else {
			request.setAttribute("MSG_ERROR", "Usuario o clave incorrectos");
		}
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		return "/index.jsp";
	}

}
