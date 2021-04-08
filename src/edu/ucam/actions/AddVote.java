package edu.ucam.actions;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.classes.Vote;
import edu.ucam.database.LoadDataReferences;
import edu.ucam.database.SaveDataByReference;

public class AddVote extends ServletAction {


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Vote newVote = new Vote();
		newVote.setProductId(request.getParameter(Vote.VOTE_PRODUCT_PARAM));
		newVote.setUserId(request.getParameter(Vote.VOTE_USER_PARAM));
		String assessment = request.getParameter(Vote.VOTE_ASSESSMENT_PARAM);				
		try {newVote.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter(Vote.VOTE_DATE_PARAM)));}catch(Exception t) {newVote.setDate(null);}
		
		
		if(assessment!=null) {
			newVote.setAssessment(Integer.parseInt(assessment));
						
			ArrayList<String> votesReferences = new ArrayList<String>();
			LoadDataReferences.loadVotesReferences(request.getContextPath(), votesReferences);	
		
			Vote.generateIdByReference(newVote, votesReferences);
			
			SaveDataByReference.Vote(request.getContextPath(), newVote);
		}
				
		return "/src/administer.jsp";
	}

}
