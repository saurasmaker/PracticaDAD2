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

public class RemoveVoteAndComment extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String voteId = request.getParameter(Vote.VOTE_ID_PARAM);
		ArrayList<Comment> comments = new ArrayList<Comment>();
		LoadData.loadComments(comments);		
		
		if(voteId!=null) {
			
			for(Comment c: comments) 
				if(c.getVoteId().equals(voteId))
					RemoveElementByReference.comment(c.getId());
			
			RemoveElementByReference.vote(voteId);
		}
		
		return "/GoTo?GO_TO=/src/administer.jsp";
	}

}
