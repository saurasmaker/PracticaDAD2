package edu.ucam.actions;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.classes.Comment;
import edu.ucam.classes.Vote;
import edu.ucam.database.LoadData;
import edu.ucam.database.RemoveElementByReference;


public class RemoveVote extends ServletAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter(Vote.VOTE_ID_PARAM);
		String cantRemove = "";
		if(id!=null && (cantRemove=canRemove(id))==null)
			RemoveElementByReference.vote(id);
		
		else return "/src/remove_error.jsp?MESSAGE_ERROR="+cantRemove;;
		
		return "/src/administer.jsp";
	}
	
	
	private String canRemove(String id) {
		
		ArrayList<Comment> comments = new ArrayList<Comment>();
		LoadData.loadComments(comments);
		
		for(Comment c: comments) 
			if(c.getVoteId().equals(id)) 
				return "No puedes eliminar este Voto porque tiene Comentarios asociados a el. Elimina antes todos sus Votos para poder eliminarlo.";	
		
		return null;
	}
}
