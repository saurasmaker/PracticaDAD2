package edu.ucam.tools;

import java.io.File;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import edu.ucam.classes.*;

public class Database {

	/*******************************************************************************************************************************/
	/***********LOAD DATABASE*******************************************************************************************************/
	/*******************************************************************************************************************************/
	
	public static void loadProducts(ArrayList<Product> products) {
		try {
            File file = new File(System.getProperty("user.dir") + "/database/products.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            NodeList productsList =  document.getElementsByTagName("product");
            
            for (int i = 0; i < productsList.getLength(); ++i) {
                Node node = productsList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Product product = new Product();
                    product.setId(element.getElementsByTagName("id").item(0).getTextContent());
                    product.setName(element.getElementsByTagName("name").item(0).getTextContent());
                    product.setModel(element.getElementsByTagName("model").item(0).getTextContent());
                    product.setTrademark(element.getElementsByTagName("trademark").item(0).getTextContent());
                    product.setDescription(element.getElementsByTagName("trademark").item(0).getTextContent());
                    
                    products.add(product);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return;
	}
	
	
	public static void loadUsers(ArrayList<User> users) {
		try {
            File file = new File(System.getProperty("user.dir") + "/database/users.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            NodeList usersList =  document.getElementsByTagName("user");
            
            for (int i = 0; i < usersList.getLength(); ++i) {
                Node node = usersList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    User user = new User();
                    user.setId(element.getElementsByTagName("id").item(0).getTextContent());
                    user.setUsername(element.getElementsByTagName("username").item(0).getTextContent());
                    user.setEmail(element.getElementsByTagName("email").item(0).getTextContent());
                    user.setPassword(element.getElementsByTagName("password").item(0).getTextContent());
                    user.setBiography(element.getElementsByTagName("byography").item(0).getTextContent());
                    user.setAddress(element.getElementsByTagName("address").item(0).getTextContent());    
                    
                    users.add(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return;
	}
	
	public static void loadVotes(ArrayList<Vote> votes) {
		try {
            File file = new File(System.getProperty("user.dir") + "/database/votes.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            NodeList votesList =  document.getElementsByTagName("vote");
            
            for (int i = 0; i < votesList.getLength(); ++i) {
                Node node = votesList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Vote vote = new Vote();
                    vote.setId(element.getElementsByTagName("id").item(0).getTextContent());
                    vote.setAssessment(Integer.parseInt(element.getElementsByTagName("assessment").item(0).getTextContent()));
                    vote.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(element.getElementsByTagName("date").item(0).getTextContent()));
                    vote.setProductId(element.getElementsByTagName("productId").item(0).getTextContent());
                    vote.setUserId(element.getElementsByTagName("userId").item(0).getTextContent());
                    
                    votes.add(vote);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return;
	}
	
	public static void loadComments(ArrayList<Comment> comments) {
		try {
            File file = new File(System.getProperty("user.dir") + "/database/comments.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            NodeList commentsList =  document.getElementsByTagName("comment");
            
            for (int i = 0; i < commentsList.getLength(); ++i) {
                Node node = commentsList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Comment comment = new Comment();
                    comment.setId(element.getElementsByTagName("id").item(0).getTextContent());
                    comment.setResume(element.getElementsByTagName("resume").item(0).getTextContent());
                    comment.setContent(element.getElementsByTagName("content").item(0).getTextContent());
                    comment.setVoteId(element.getElementsByTagName("voteId").item(0).getTextContent());
                    
                    comments.add(comment);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return;
	}
	
	public static void loadData(ArrayList<User> users, ArrayList<Product> products, ArrayList<Vote> votes, ArrayList<Comment> comments) {
		
		loadProducts(products);
		loadUsers(users);
		loadVotes(votes);
		loadComments(comments);
		
		return;
	}
	
	
	/*******************************************************************************************************************************/
	/***********SAVE DATABASE*******************************************************************************************************/
	/*******************************************************************************************************************************/
	public static void saveProducts(ArrayList<Product> products) {
		
		try {
			 
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
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
				 
				// escribimos el contenido en un archivo .xml
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File(System.getProperty("user.dir") + "/database/products.xml"));				 
				transformer.transform(source, result);
				 
				System.out.println("Products saved!");
			}
		
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
		
		return;
	}
	
	
	public static void saveUsers(ArrayList<User> users) {
		try {
			 
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
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
				 
				System.out.println("Users saved!");
			}
		
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
		
		return;
	}
	
	public static void saveVotes(ArrayList<Vote> votes) {
		try {
			 
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
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
				date.appendChild(doc.createTextNode(v.getDate().toString()));
				vote.appendChild(date);
				
				
				// escribimos el contenido en un archivo .xml
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File(System.getProperty("user.dir") + "/database/votes.xml"));				 
				transformer.transform(source, result);
				 
				System.out.println("Votes saved!");
			}
		
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
		
		return;
	}
	
	public static void saveComments(ArrayList<Comment> comments) {
		try {
			 
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
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
				 
				System.out.println("Votes saved!");
			}
		
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
		
		return;
	}
	
	public static void saveData(ArrayList<User> users, ArrayList<Product> products, ArrayList<Vote> votes, ArrayList<Comment> comments) {
		
		saveProducts(products);
		saveUsers(users);
		saveVotes(votes);
		saveComments(comments);
		
		return;
	}
}
