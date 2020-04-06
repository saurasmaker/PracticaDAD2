package edu.ucam.classes;

import java.util.ArrayList;
import java.util.Date;

public class Comment {
		
	
	//Static Atributes
	String COMMENT_PARAM = "COMMENT_PARAM", COMMENT_CONTENT_PARAM = "COMMENT_CONTENT_PARAM", COMMENT_DATE_PARAM = "COMMENT_DATE_PARAM", 
		COMMENT_ID_PARAM = "COMMENT_ID_PARAM";
		
		
	//Attribute
	String content, id;
	Date date;
	
	
	
	//Contructors
	public Comment() {
		
	}
	
	public Comment(String content, Date date, String id) {
		this.content = content;
		this.date = date;
		this.id = id;
	}
	
	
	
	//Static Methods
	static public void generateId(Comment comment, ArrayList<Comment> comments) {
		//Id Example -> C12223245; The id of the comments have 1 character 'C' and 8 numbers.
		String newId = "" + (Integer.parseInt(comments.get(comments.size()-1).getId().substring(1))+1);
		comment.setId(newId);
		
		return;
	}

	
	
	//Getters & Setters
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
