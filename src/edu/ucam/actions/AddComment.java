package edu.ucam.actions;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.classes.Comment;
import edu.ucam.database.LoadDataReferences;
import edu.ucam.database.SaveDataByReference;


public class AddComment extends ServletAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Comment newComment = new Comment();

		
		newComment = new Comment();
		newComment.setResume(request.getParameter(Comment.COMMENT_RESUME_PARAM));
		newComment.setContent(request.getParameter(Comment.COMMENT_CONTENT_PARAM));
		newComment.setVoteId(request.getParameter(Comment.COMMENT_VOTE_ID_PARAM));
		
		if(newComment.getResume()!=null) {
			ArrayList<String> commentsReferences = new ArrayList<String>();
			LoadDataReferences.loadCommentsReferences(commentsReferences);	
		
			Comment.generateIdByReference(newComment, commentsReferences);
			
			SaveDataByReference.Comment(newComment);
		}
		
		return "/src/administer.jsp";
	}

}
