package edu.ucam.actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.classes.Vote;
import edu.ucam.database.RemoveElementByReference;


public class RemoveVote extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter(Vote.VOTE_ID_PARAM);
			
		if(id!=null && canRemove())
			RemoveElementByReference.vote(id);
		
		else return "cantremove";
		
		return "/GoTo?GO_TO=/src/administer.jsp";
	}
	
	
	private Boolean canRemove() {
		
		
		return false;
	}
}
