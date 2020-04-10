package edu.ucam.database;

import java.io.File;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import edu.ucam.classes.Comment;
import edu.ucam.classes.Product;
import edu.ucam.classes.User;
import edu.ucam.classes.Vote;

public class LoadDataByReference {
	
	public static Product product(String id, String path) {
		
		Product product = null;
		
		try {
            File file = new File(path + "database/products.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            NodeList productsList =  document.getElementsByTagName("product");
            
            for (int i = 0; i < productsList.getLength(); ++i) {
                Node node = productsList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    if(id.equals(element.getElementsByTagName("id").item(0).getTextContent())) {
                    	product = new Product();
                    	product.setId(element.getElementsByTagName("id").item(0).getTextContent());
                        product.setName(element.getElementsByTagName("name").item(0).getTextContent());
                        product.setModel(element.getElementsByTagName("model").item(0).getTextContent());
                        product.setTrademark(element.getElementsByTagName("trademark").item(0).getTextContent());
                        product.setDescription(element.getElementsByTagName("description").item(0).getTextContent());
                        try{product.setPrice(Float.parseFloat(element.getElementsByTagName("price").item(0).getTextContent()));}
                        catch(Exception e){product.setPrice((float)0.0);}
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return product;
	}
	
	
public static User user(String id) {
		
		User user = null;
		
		try {
            File file = new File(System.getProperty("user.dir") + "/database/users.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            NodeList productsList =  document.getElementsByTagName("user");
            
            for (int i = 0; i < productsList.getLength(); ++i) {
                Node node = productsList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    if(id.equals(element.getElementsByTagName("id").item(0).getTextContent())) {
                    	user = new User();
                    	user.setId(element.getElementsByTagName("id").item(0).getTextContent());
                        user.setUsername(element.getElementsByTagName("username").item(0).getTextContent());
                        user.setEmail(element.getElementsByTagName("email").item(0).getTextContent());
                        user.setPassword(element.getElementsByTagName("password").item(0).getTextContent());
                        user.setBiography(element.getElementsByTagName("byography").item(0).getTextContent());
                        user.setAddress(element.getElementsByTagName("address").item(0).getTextContent());    
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return user;
	}


	public static Vote vote(String id) {
	
		Vote vote = null;
	
		try {
        	File file = new File(System.getProperty("user.dir") + "/database/votes.xml");
        	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        	DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
        	Document document = documentBuilder.parse(file);
        	document.getDocumentElement().normalize();
        	NodeList productsList =  document.getElementsByTagName("vote");
        
        	for (int i = 0; i < productsList.getLength(); ++i) {
            	Node node = productsList.item(i);
            	if (node.getNodeType() == Node.ELEMENT_NODE) {
                	Element element = (Element) node;
                	if(id.equals(element.getElementsByTagName("id").item(0).getTextContent())) {
                		vote = new Vote();
                        vote.setId(element.getElementsByTagName("id").item(0).getTextContent());
                        vote.setAssessment(Integer.parseInt(element.getElementsByTagName("assessment").item(0).getTextContent()));
                        vote.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(element.getElementsByTagName("date").item(0).getTextContent()));
                        vote.setProductId(element.getElementsByTagName("productId").item(0).getTextContent());
                        vote.setUserId(element.getElementsByTagName("userId").item(0).getTextContent());
                 
                	}
            	}
        	}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	
		return vote;
	}
	
	public static Comment comment(String id) {
		
		Comment comment = null;
	
		try {
        	File file = new File(System.getProperty("user.dir") + "/database/comments.xml");
        	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        	DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
        	Document document = documentBuilder.parse(file);
        	document.getDocumentElement().normalize();
        	NodeList productsList =  document.getElementsByTagName("comment");
        
        	for (int i = 0; i < productsList.getLength(); ++i) {
            	Node node = productsList.item(i);
            	if (node.getNodeType() == Node.ELEMENT_NODE) {
                	Element element = (Element) node;
                	if(id.equals(element.getElementsByTagName("id").item(0).getTextContent())) {
                		comment = new Comment();
                		comment.setId(element.getElementsByTagName("id").item(0).getTextContent());
                        comment.setResume(element.getElementsByTagName("resume").item(0).getTextContent());
                        comment.setContent(element.getElementsByTagName("content").item(0).getTextContent());
                        comment.setVoteId(element.getElementsByTagName("voteId").item(0).getTextContent());
                 
                	}
            	}
        	}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	
		return comment;
	}

}
