package edu.ucam.classes;

import java.util.ArrayList;
import java.util.Date;

public class Vote {

	//Static Attributes
	public static String VOTE_PARAM = "VOTE_PARAM", VOTE_ASSESSMENT_PARAM = "VOTE_ASSESSMENT_PARAM", VOTE_USER_PARAM = "VOTE_USER_PARAM",
		VOTE_PRODUCT_PARAM = "VOTE_PRODUCT_PARAM", VOTE_ID_PARAM = "VOTE_ID_PARAM", VOTE_DATE_PARAM = "VOTE_DATE_PARAM";
	
	
	
	//Attributes
	String id, userId, productId;
	Integer assessment;
	Date date;
	
	
	//Constructors
	public Vote() {
		
	}
	
	public Vote(Integer assessment, String userId, String productId, String id) {
		this.assessment =assessment;
		this.userId = userId;
		this.productId = productId;
		this.id = id;
	}
	
	
	
	//Static Methods
	static public void generateId(Vote vote, ArrayList<Vote> votes) {
		//Id Example -> V12223245; The id of the comments have 1 character 'V' and 8 numbers.
		
		if(!(votes.size() > 0)) {
			vote.setId("V0");
			return;
		}
		
		String newId = "V" + (Integer.parseInt(votes.get(votes.size()-1).getId().substring(1))+1);
		vote.setId(newId);
			
		return;
	}

	
	static public void generateIdByReference(Vote vote, ArrayList<String> votes) {
		//Id Example -> V12223245; The id of the comments have 1 character 'V' and 8 numbers.
		if(!(votes.size() > 0)) {
			vote.setId("V0");
			return;
		}
		
		String previus = votes.get(votes.size()-1);
		String newId = "V" + (Integer.parseInt(previus.substring(1))+1);
		vote.setId(newId);
			
		return;
	}
	
	
	//Getters & Setters
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getAssessment() {
		return this.assessment;
	}

	public void setAssessment(Integer assessment) {
		this.assessment = assessment;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	
}
