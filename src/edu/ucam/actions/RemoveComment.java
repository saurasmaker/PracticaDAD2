package edu.ucam.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.classes.Comment;
import edu.ucam.database.RemoveElementByReference;

public class RemoveComment extends Action {


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter(Comment.COMMENT_ID_PARAM);
		
		if(id!=null)
			RemoveElementByReference.comment(id);
		
		return "/GoTo?GO_TO=/src/administer.jsp";
	}

}
