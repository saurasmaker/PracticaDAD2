package edu.ucam.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.classes.Comment;
import edu.ucam.classes.Vote;
import edu.ucam.database.LoadDataReferences;
import edu.ucam.database.SaveDataByReference;


public class AddVoteAndComment extends ServletAction {


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Vote newVote = new Vote();
		newVote.setProductId(request.getParameter(Vote.VOTE_PRODUCT_PARAM));
		newVote.setUserId(request.getParameter(Vote.VOTE_USER_PARAM));
		String assessment = request.getParameter(Vote.VOTE_ASSESSMENT_PARAM);
		try {newVote.setDate(new Date());}catch(Exception t) {newVote.setDate(null);}
			
		System.out.println(assessment);
		
		if(assessment!=null) {
			newVote.setAssessment(Integer.parseInt(assessment));
			
			ArrayList<String> votesReferences = new ArrayList<String>();
			LoadDataReferences.loadVotesReferences(votesReferences);	
		
			Vote.generateIdByReference(newVote, votesReferences);
			
			Comment newComment = null;
			String resume;
			if((resume = request.getParameter(Comment.COMMENT_RESUME_PARAM)) != null) { 
				newComment = new Comment();
				newComment.setResume(resume);
				newComment.setContent(request.getParameter(Comment.COMMENT_CONTENT_PARAM));
				newComment.setVoteId(newVote.getId());
			}
			
			if(newComment!=null) {
				ArrayList<String> commentsReferences = new ArrayList<String>();
				LoadDataReferences.loadCommentsReferences(commentsReferences);	
			
				Comment.generateIdByReference(newComment, commentsReferences);
				
				SaveDataByReference.Comment(newComment);
			}
		
			SaveDataByReference.Vote(newVote);
		}
		
		return "/index.jsp";
	}

}
