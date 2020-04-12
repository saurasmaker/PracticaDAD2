package edu.ucam.database;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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
		
		try {
            File file = new File(System.getProperty("user.dir") + "/database/products.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document doc = documentBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList productsList =  doc.getElementsByTagName("product");
		
            //Generate Id to the new object
            Node node = productsList.item(productsList.getLength()-1);
            Element element = (Element)node;
            Product.generateIdByReference(p, element.getElementsByTagName("id").item(0).getTextContent());
            
            
            //Add Element to DDBB
            Element rootElement = (Element) doc.getElementsByTagName("products");

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
			
			Element price = doc.createElement("price");
			description.appendChild(doc.createTextNode(p.getPrice().toString()));
			product.appendChild(price);
		
			// escribimos el contenido en un archivo .xml
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(System.getProperty("user.dir") + "/database/products.xml"));				 
			transformer.transform(source, result);
		}
		catch(Exception e) {
			
		}
		
		return;
	}
	
	
public static void User(User u) {
		
		try {
            File file = new File(System.getProperty("user.dir") + "/database/users.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document doc = documentBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList productsList =  doc.getElementsByTagName("user");
		
            Node node = productsList.item(productsList.getLength()-1);
            Element element = (Element)node;
            User.generateIdByReference(u, element.getElementsByTagName("id").item(0).getTextContent());
		
            Element rootElement = (Element) doc.getElementsByTagName("users");

            //Add Element to DDBB
            Element user = doc.createElement("user");
			rootElement.appendChild(user);

			Element id = doc.createElement("id");
			id.appendChild(doc.createTextNode(u.getId()));
			user.appendChild(id);
			
			Element username = doc.createElement("username");
			username.appendChild(doc.createTextNode(u.getUsername()));
			user.appendChild(username);

			Element email = doc.createElement("username");
			email.appendChild(doc.createTextNode(u.getEmail()));
			user.appendChild(email);
			
			Element password = doc.createElement("password");
			password.appendChild(doc.createTextNode(u.getPassword()));
			user.appendChild(password);
			
			Element byography = doc.createElement("byography");
			byography.appendChild(doc.createTextNode(u.getBiography()));
			user.appendChild(byography);
			
			Element address = doc.createElement("address");
			address.appendChild(doc.createTextNode(u.getAddress()));
			user.appendChild(address);
		
			// escribimos el contenido en un archivo .xml
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(System.getProperty("user.dir") + "/database/users.xml"));				 
			transformer.transform(source, result);
		}
		catch(Exception e) {
			
		}
		
		return;
	}
	
	public static void Vote(Vote v) {

		try {
            File file = new File(System.getProperty("user.dir") + "/database/votes.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document doc = documentBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList productsList =  doc.getElementsByTagName("vote");
		
            Node node = productsList.item(productsList.getLength()-1);
            Element element = (Element)node;
            Vote.generateIdByReference(v, element.getElementsByTagName("id").item(0).getTextContent());
		
            Element rootElement = (Element) doc.getElementsByTagName("votes");

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
			date.appendChild(doc.createTextNode(v.getDate().toString()));
			vote.appendChild(date);
		
			// escribimos el contenido en un archivo .xml
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(System.getProperty("user.dir") + "/database/votes.xml"));				 
			transformer.transform(source, result);
		}
		catch(Exception e) {
			
		}
		
		return;
	}
	
	public static void Comment(Comment c) {
		
		try {
            File file = new File(System.getProperty("user.dir") + "/database/comments.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document doc = documentBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList productsList =  doc.getElementsByTagName("comment");
		
            Node node = productsList.item(productsList.getLength()-1);
            Element element = (Element)node;
            Comment.generateIdByReference(c, element.getElementsByTagName("id").item(0).getTextContent());
		
            Element rootElement = (Element) doc.getElementsByTagName("comments");

            //Add Element to DDBB
            Element comment = doc.createElement("comment");
			rootElement.appendChild(comment);

			Element id = doc.createElement("id");
			id.appendChild(doc.createTextNode(c.getId()));
			comment.appendChild(id);
			
			Element resume = doc.createElement("id");
			resume.appendChild(doc.createTextNode(c.getResume()));
			comment.appendChild(resume);
			
			Element content = doc.createElement("id");
			content.appendChild(doc.createTextNode(c.getContent()));
			comment.appendChild(content);
		
			// escribimos el contenido en un archivo .xml
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(System.getProperty("user.dir") + "/database/comments.xml"));				 
			transformer.transform(source, result);
		}
		catch(Exception e) {
			
		}
		
		return;
	}
	

}
