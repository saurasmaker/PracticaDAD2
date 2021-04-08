package edu.ucam.database;

import java.io.File;

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

public class RemoveElementByReference {
	
	public static void user(String contextPath, String id) {
		
		//Load XML
		File file = new File(contextPath + "/WebContent/database/users.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        Document document = null;
        try {
        	documentBuilder = dbf.newDocumentBuilder();
         	document = documentBuilder.parse(file);
        }
        catch(Exception t){
            	
        }
        document.getDocumentElement().normalize();
        NodeList usersList =  document.getElementsByTagName("user");
          
        
        //Delete element selected
        for (int i = 0; i < usersList.getLength(); ++i) {
            Node node = usersList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if(element.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
                	element.getParentNode().removeChild(element);
                }
            }
        }
            
     
		//Save new XML file
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
		DOMSource source = new DOMSource(document);
				
		try {
			transformer.transform(source, result);
		}
		catch(Exception t) {
						
		}
		
		return;
	}
	
	
	
	public static void product(String contextPath, String id) {
		
		//Load XML
		File file = new File(contextPath + "/WebContent/database/products.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        Document document = null;
        try {
        	documentBuilder = dbf.newDocumentBuilder();
         	document = documentBuilder.parse(file);
        }
        catch(Exception t){
            	
        }
        document.getDocumentElement().normalize();
        NodeList productsList =  document.getElementsByTagName("product");
          
        
        //Delete element selected
        for (int i = 0; i < productsList.getLength(); ++i) {
            Node node = productsList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if(element.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
                	element.getParentNode().removeChild(element);
                }
            }
        }
            
     
		//Save new XML file
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
		DOMSource source = new DOMSource(document);
				
		try {
			transformer.transform(source, result);
		}
		catch(Exception t) {
						
		}
		
		return;
	}
	
	
	
	
	public static void vote(String contextPath, String id) {
		
		//Load XML
		File file = new File(contextPath + "/WebContent/database/votes.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        Document document = null;
        try {
        	documentBuilder = dbf.newDocumentBuilder();
         	document = documentBuilder.parse(file);
        }
        catch(Exception t){
            	
        }
        document.getDocumentElement().normalize();
        NodeList votesList =  document.getElementsByTagName("vote");
          
        
        //Delete element selected
        for (int i = 0; i < votesList.getLength(); ++i) {
            Node node = votesList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if(element.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
                	element.getParentNode().removeChild(element);
                }
            }
        }
            
     
		//Save new XML file
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
		DOMSource source = new DOMSource(document);
				
		try {
			transformer.transform(source, result);
		}
		catch(Exception t) {
						
		}
		
		return;
	}
	
	
	
	
public static void comment(String contextPath, String id) {
		
		//Load XML
		File file = new File(contextPath + "/WebContent/database/comments.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        Document document = null;
        try {
        	documentBuilder = dbf.newDocumentBuilder();
         	document = documentBuilder.parse(file);
        }
        catch(Exception t){
            	
        }
        document.getDocumentElement().normalize();
        NodeList commentsList =  document.getElementsByTagName("comment");
          
        
        //Delete element selected
        for (int i = 0; i < commentsList.getLength(); ++i) {
            Node node = commentsList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if(element.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
                	element.getParentNode().removeChild(element);
                }
            }
        }
            
     
		//Save new XML file
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
		DOMSource source = new DOMSource(document);
				
		try {
			transformer.transform(source, result);
		}
		catch(Exception t) {
						
		}
		
		return;
	}
	
}
