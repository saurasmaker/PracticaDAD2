package edu.ucam.classes;

import java.util.ArrayList;

public class Vote {

	//Static Attributes
	String VOTE_PARAM = "VOTE_PARAM", VOTE_ASSESSMENT_PARAM = "VOTE_ASSESSMENT_PARAM", VOTE_USER_PARAM = "VOTE_USER_PARAM", 
		VOTE_ID_PARAM = "VOTE_ID_PARAM", VOTE_COMMENT_PARAM = "VOTE_COMMENT_PARAM";
	
	
	
	//Attributes
	String id, userId;
	Integer assessment;
	User user;
	Comment comment;
	
	
	
	//Constructors
	public Vote() {
		
	}
	
	public Vote(Integer assessment, String userId, Comment comment, String id) {
		this.assessment =assessment;
		this.userId = userId;
		this.comment = comment;
		this.id = id;
	}
	
	
	
	//Static Methods
	static public void generateId(Vote vote, ArrayList<Vote> votes) {
		//Id Example -> V12223245; The id of the comments have 1 character 'V' and 8 numbers.
		String newId = "" + (Integer.parseInt(votes.get(votes.size()-1).getId().substring(1))+1);
		vote.setId(newId);
			
		return;
	}

	
	
	//Getters & Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getAssessment() {
		return assessment;
	}

	public void setAssessment(Integer assessment) {
		this.assessment = assessment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
}
