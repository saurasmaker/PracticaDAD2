package edu.ucam.classes;

import java.util.ArrayList;

public class Comment {
	
	//Static Atributes
	public static String COMMENT_PARAM = "COMMENT_PARAM", COMMENT_RESUME_PARAM = "COMMENT_RESUME_PARAM", COMMENT_CONTENT_PARAM = "COMMENT_CONTENT_PARAM", 
		COMMENT_VOTE_ID_PARAM = "COMMENT_VOTE_ID_PARAM", COMMENT_ID_PARAM = "COMMENT_ID_PARAM";
			
	
	//Attributes
	String resume, content, voteId, id;
	
	
	//Constructors
	public Comment() {
		
	}
	
	public Comment(String resume, String content, String voteId, String id) {
		this.resume = resume;
		this.content = content;
		this.voteId = voteId;
		this.id = id;
	}
	
	
	//Static Methods
	static public void generateId(Comment comment, ArrayList<Comment> comments) {
		//Id Example -> C12223245; The id of the comments have 1 character 'C' and 8 numbers.
		String newId = "C" + (Integer.parseInt(comments.get(comments.size()-1).getId().substring(1))+1);
		comment.setId(newId);
			
		return;
	}

	static public void generateIdByReference(Comment comment, String previus) {
		//Id Example -> C12223245; The id of the comments have 1 character 'C' and 8 numbers.
		String newId = "C" + (Integer.parseInt(previus.substring(1))+1);
		comment.setId(newId);
		
		return;
	}
	
	//Getters & Setters
	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVoteId() {
		return voteId;
	}

	public void setVoteId(String voteId) {
		this.voteId = voteId;
	}
	

}
