package edu.ucam.database;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import edu.ucam.classes.Comment;
import edu.ucam.classes.Product;
import edu.ucam.classes.User;
import edu.ucam.classes.Vote;

public class SaveDataByReference{
	
	public static void Product(Product p) {
		
	
		File file = new File(edu.ucam.tools.ProjectPath.getPathWindowsVersion() + "WebContent/database/products.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        Document doc = null;
        try {
            documentBuilder = dbf.newDocumentBuilder();
            doc = documentBuilder.parse(file);
        }catch(Exception t) {
            	
        }
        doc.getDocumentElement().normalize();
        NodeList productsList =  doc.getElementsByTagName("product");
		
        //Generate Id to the new object
        Node node = productsList.item(productsList.getLength()-1);
        Element element = (Element)node;
        Product.generateIdByReference(p, element.getElementsByTagName("id").item(0).getTextContent());
            
            
        //Add Element to DDBB
        Element rootElement = (Element) doc.getElementsByTagName("products").item(0);
        Element product = doc.createElement("product");
        rootElement.appendChild(product);

		Element id = doc.createElement("id");
		id.appendChild(doc.createTextNode(p.getId()));
		product.appendChild(id);
			
		Element name = doc.createElement("name");
		name.appendChild(doc.createTextNode(p.getName()));
		product.appendChild(name);
		 
		Element model = doc.createElement("model");
		model.appendChild(doc.createTextNode(p.getModel()));
		product.appendChild(model);
			 
		Element trademark = doc.createElement("trademark");
		trademark.appendChild(doc.createTextNode(p.getTrademark()));
		product.appendChild(trademark);
			 
		Element description = doc.createElement("description");
		description.appendChild(doc.createTextNode(p.getDescription()));
		product.appendChild(description);
			
		Element img_path = doc.createElement("img_path");
		img_path.appendChild(doc.createTextNode(p.getImg_path()));
		product.appendChild(img_path);
			
		Element price = doc.createElement("price");
		price.appendChild(doc.createTextNode(""+p.getPrice()));
		product.appendChild(price);
		
		// escribimos el contenido en un archivo .xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;

		try {
			transformer = transformerFactory.newTransformer();
		}catch(Exception t) {
					
		}
				
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
				
		//initialize StreamResult with File object to save to file
		StreamResult result = new StreamResult(new File(file.getAbsolutePath()));
		DOMSource source = new DOMSource(doc);
				
		try {
			transformer.transform(source, result);
		}
		catch(Exception t) {
						
		}
			
			

		return;
	}
	
	
	public static void User(User u) {
		

		File file = new File(edu.ucam.tools.ProjectPath.getPathWindowsVersion() + "WebContent/database/users.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		Document doc = null;
        try {
        	documentBuilder = dbf.newDocumentBuilder();
            doc = documentBuilder.parse(file);
        }
        catch(Exception t){
            	
        }
        doc.getDocumentElement().normalize();
        NodeList productsList =  doc.getElementsByTagName("user");
		
        Node node = productsList.item(productsList.getLength()-1);
        Element element = (Element)node;
        User.generateIdByReference(u, element.getElementsByTagName("id").item(0).getTextContent());
		
        Element rootElement = (Element) doc.getElementsByTagName("users").item(0);

        //Add Element to DDBB
        Element user = doc.createElement("user");
        rootElement.appendChild(user);

		Element id = doc.createElement("id");
		id.appendChild(doc.createTextNode(u.getId()));
		user.appendChild(id);
			
		Element username = doc.createElement("username");
		username.appendChild(doc.createTextNode(u.getUsername()));
		user.appendChild(username);

		Element email = doc.createElement("email");
		email.appendChild(doc.createTextNode(u.getEmail()));
		user.appendChild(email);
			
		Element password = doc.createElement("password");
		password.appendChild(doc.createTextNode(u.getPassword()));
		user.appendChild(password);
			
		Element byography = doc.createElement("biography");
		byography.appendChild(doc.createTextNode(u.getBiography()));
		user.appendChild(byography);
			
		Element address = doc.createElement("address");
		address.appendChild(doc.createTextNode(u.getAddress()));
		user.appendChild(address);
		
		// escribimos el contenido en un archivo .xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;

		try {
			transformer = transformerFactory.newTransformer();
		}catch(Exception t) {
				
		}
			
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
				
		//initialize StreamResult with File object to save to file
		StreamResult result = new StreamResult(new File(file.getAbsolutePath()));
		DOMSource source = new DOMSource(doc);
			
		try {
			transformer.transform(source, result);
		}
		catch(Exception t) {
					
		}
						
		return;
	}
	
	public static void Vote(Vote v) {
	
        File file = new File(edu.ucam.tools.ProjectPath.getPathWindowsVersion() + "WebContent/database/votes.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        Document doc = null;
        try {
        	documentBuilder = dbf.newDocumentBuilder();
        	doc = documentBuilder.parse(file);
        }catch(Exception t) {
        	
        }
        
        doc.getDocumentElement().normalize();
        NodeList productsList =  doc.getElementsByTagName("vote");
		
        Node node = productsList.item(productsList.getLength()-1);
        Element element = (Element)node;
        Vote.generateIdByReference(v, element.getElementsByTagName("id").item(0).getTextContent());
		
        Element rootElement = (Element) doc.getElementsByTagName("votes").item(0);

        //Add Element to DDBB
        Element vote = doc.createElement("vote");
		rootElement.appendChild(vote);

		Element id = doc.createElement("id");
		id.appendChild(doc.createTextNode(v.getId()));
		vote.appendChild(id);
			
		Element userId = doc.createElement("userId");
		userId.appendChild(doc.createTextNode(v.getUserId()));
		vote.appendChild(userId);
			
		Element productId = doc.createElement("productId");
		productId.appendChild(doc.createTextNode(v.getProductId()));
		vote.appendChild(productId);
			
		Element assessment = doc.createElement("assessment");
		assessment.appendChild(doc.createTextNode(v.getAssessment().toString()));
		vote.appendChild(assessment);
			
		Element date = doc.createElement("date");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try{date.appendChild(doc.createTextNode(dateFormat.format(v.getDate())));}catch(Exception t) {}
		vote.appendChild(date);
		
		// escribimos el contenido en un archivo .xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;

		try {
			transformer = transformerFactory.newTransformer();
		}catch(Exception t) {
					
		}
				
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
					
		//initialize StreamResult with File object to save to file
		StreamResult result = new StreamResult(new File(file.getAbsolutePath()));
		DOMSource source = new DOMSource(doc);
				
		try {
			transformer.transform(source, result);
		}
		catch(Exception t) {
						
		}		

		
		return;
	}
	
	public static void Comment(Comment c) {
		
		File file = new File(edu.ucam.tools.ProjectPath.getPathWindowsVersion() + "WebContent/database/comments.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        Document doc = null;
        try {
        	documentBuilder = dbf.newDocumentBuilder();
        	doc = documentBuilder.parse(file);
        }catch(Exception t) {
        	
        }
        doc.getDocumentElement().normalize();
        NodeList productsList =  doc.getElementsByTagName("comment");
		
        Node node = productsList.item(productsList.getLength()-1);
        Element element = (Element)node;
        Comment.generateIdByReference(c, element.getElementsByTagName("id").item(0).getTextContent());
		
        Element rootElement = (Element) doc.getElementsByTagName("comments").item(0);

        //Add Element to DDBB
        Element comment = doc.createElement("comment");
		rootElement.appendChild(comment);

		Element id = doc.createElement("id");
		id.appendChild(doc.createTextNode(c.getId()));
		comment.appendChild(id);
		
		Element voteId = doc.createElement("voteId");
		voteId.appendChild(doc.createTextNode(c.getVoteId()));
		comment.appendChild(voteId);
			
		Element resume = doc.createElement("resume");
		resume.appendChild(doc.createTextNode(c.getResume()));
		comment.appendChild(resume);
			
		Element content = doc.createElement("content");
		content.appendChild(doc.createTextNode(c.getContent()));
		comment.appendChild(content);
		
		// escribimos el contenido en un archivo .xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;

		try {
			transformer = transformerFactory.newTransformer();
		}catch(Exception t) {
							
		}
						
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
							
		//initialize StreamResult with File object to save to file
		StreamResult result = new StreamResult(new File(file.getAbsolutePath()));
		DOMSource source = new DOMSource(doc);
						
		try {
			transformer.transform(source, result);
		}
		catch(Exception t) {
								
		}	

		
		return;
	}
	

}
