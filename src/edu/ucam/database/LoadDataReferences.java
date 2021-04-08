package edu.ucam.database;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LoadDataReferences {
	/*******************************************************************************************************************************/
	/***********LOAD REFERENCES*****************************************************************************************************/
	/*******************************************************************************************************************************/
	
	public static void loadProductsReferences(String contextPath, ArrayList<String> products_references) {
		
		try {
			
			File file = new File(contextPath + "/WebContent/database/products.xml");
			
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            NodeList productsList =  document.getElementsByTagName("product");
            
            for (int i = 0; i < productsList.getLength(); ++i) {
                Node node = productsList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    products_references.add(element.getElementsByTagName("id").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return;
	}
	
	
	public static void loadUsersReferences(String contextPath, ArrayList<String> users_references) {
		try {
            File file = new File(contextPath + "/WebContent/database/users.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            NodeList usersList =  document.getElementsByTagName("user");
            
            for (int i = 0; i < usersList.getLength(); ++i) {
                Node node = usersList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    users_references.add(element.getElementsByTagName("id").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return;
	}
	
	public static void loadVotesReferences(String contextPath, ArrayList<String> votes_references) {
		try {
            File file = new File(contextPath + "/WebContent/database/votes.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            NodeList votesList =  document.getElementsByTagName("vote");
            
            for (int i = 0; i < votesList.getLength(); ++i) {
                Node node = votesList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    votes_references.add(element.getElementsByTagName("id").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return;
	}
	
	public static void loadCommentsReferences(String contextPath, ArrayList<String> comments_references) {
		try {
            File file = new File(contextPath + "/WebContent/database/comments.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            NodeList commentsList =  document.getElementsByTagName("comment");
            
            for (int i = 0; i < commentsList.getLength(); ++i) {
                Node node = commentsList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    comments_references.add(element.getElementsByTagName("id").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return;
	}
	
	public static void loadDataReferences(String contextPath, ArrayList<String> users_references, ArrayList<String> products_references, ArrayList<String> votes_references, ArrayList<String> comments_references) {
		
		loadProductsReferences(contextPath, products_references);
		loadUsersReferences(contextPath, users_references);
		loadVotesReferences(contextPath, votes_references);
		loadCommentsReferences(contextPath, comments_references);
		
		return;
	}
}
