package edu.ucam.tools;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import edu.ucam.classes.*;
import edu.ucam.interfaces.*;

public class BddComentario implements CommentariosBdd{

	@Override
	public boolean registrarComentarios(Comment comentario){
		boolean registro = false;
		try{
			     File fXmlFile = new File(System.getProperty("user.dir") + "/database/products.xml");
	             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	             DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	             Document doc = dBuilder.parse(fXmlFile);
	             doc.getDocumentElement().normalize();
	             Element root = doc.getDocumentElement();
	             NodeList nList = doc.getElementsByTagName("id");
	             int temp;
	             Element eElement = null;
	             for (temp = 0; temp < nList.getLength(); temp++) {
	                    Node node = nList.item(temp);
	                    eElement = (Element) node;
	             }
	             Element newNode= doc.createElement("Node"+temp);
                 newNode.appendChild(doc.createTextNode("insert into users values ("+comentario.getResume()+",'"+comentario.getContent()+"','"+comentario.getVoteId()+"','"+comentario.getId()+"');"));
                 eElement.appendChild(newNode);
	             registro = true;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return registro;
	}
}
