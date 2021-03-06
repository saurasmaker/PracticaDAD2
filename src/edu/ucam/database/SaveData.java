package edu.ucam.database;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import edu.ucam.classes.Comment;
import edu.ucam.classes.Product;
import edu.ucam.classes.User;
import edu.ucam.classes.Vote;

public class SaveData {
	/*******************************************************************************************************************************/
	/***********SAVE DATABASE*******************************************************************************************************/
	/*******************************************************************************************************************************/
	public static void saveProducts(String contextPath, ArrayList<Product> products) {
		
		try {
			 
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbf.newDocumentBuilder();
	 
			//root element
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("products");
			doc.appendChild(rootElement);

			for(Product p: products) {
				
				//user
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
				description.appendChild(doc.createTextNode(p.getPrice().toString()));
				product.appendChild(price);
				
				// escribimos el contenido en un archivo .xml
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File(contextPath + "/WebContent/database/products.xml"));				 
				transformer.transform(source, result);
				 
			}
		
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
		
		return;
	}
	
	
	public static void saveUsers(String contextPath, ArrayList<User> users) {
		try {
			 
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbf.newDocumentBuilder();
	 
			//root element
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("users");
			doc.appendChild(rootElement);

			for(User u: users) {
				
				//user
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
				
				Element biography = doc.createElement("biography");
				biography.appendChild(doc.createTextNode(u.getBiography()));
				user.appendChild(biography);
				
				Element address = doc.createElement("address");
				address.appendChild(doc.createTextNode(u.getAddress()));
				user.appendChild(address);
				
				// escribimos el contenido en un archivo .xml
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File(contextPath + "/WebContent/database/users.xml"));				 
				transformer.transform(source, result);
				 
			}
		
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
		
		return;
	}
	
	public static void saveVotes(String contextPath, ArrayList<Vote> votes) {
		try {
			 
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbf.newDocumentBuilder();
	 
			//root element
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("votes");
			doc.appendChild(rootElement);

			for(Vote v: votes) {
				
				//user
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
				date.appendChild(doc.createTextNode(dateFormat.format(v.getDate())));
				vote.appendChild(date);
				
				
				// escribimos el contenido en un archivo .xml
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File(contextPath + "/WebContent/database/votes.xml"));				 
				transformer.transform(source, result);
				 
			}
		
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
		
		return;
	}
	
	public static void saveComments(String contextPath,  ArrayList<Comment> comments) {
		try {
			 
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbf.newDocumentBuilder();
	 
			//root element
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("comments");
			doc.appendChild(rootElement);

			for(Comment c: comments) {			
				//user
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
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File(contextPath + "/WebContent/database/comments.xml"));				 
				transformer.transform(source, result);
				 
			}
		
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
		
		return;
	}
	
	public static void saveDataBase(String contextPath, ArrayList<User> users, ArrayList<Product> products, ArrayList<Vote> votes, ArrayList<Comment> comments) {
		
		saveProducts(contextPath, products);
		saveUsers(contextPath, users);
		saveVotes(contextPath, votes);
		saveComments(contextPath, comments);
		
		return;
	}
}
