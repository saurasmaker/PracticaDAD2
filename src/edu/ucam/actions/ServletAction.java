package edu.ucam.actions;

import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.TilesContainer;
import org.apache.tiles.servlet.context.ServletUtil;

public abstract class ServletAction {
	

	private String definition = "myapp.homepage";
	
	private Properties atributos = new Properties();
	
	public void addAtributo(String key, String value) {
		this.atributos.put(key, value);
	}
	
	
	public String getDefinition() {
		return definition;
	}




	public void setDefinition(String definition) {
		this.definition = definition;
	}




	public abstract void ejecutar(HttpServletRequest request, HttpServletResponse response);

	
	public void renderPage(HttpServletRequest request, HttpServletResponse response){
		
		TilesContainer container = ServletUtil.getContainer(
		        request.getSession().getServletContext());

		AttributeContext attributeContext = container.startContext(request,response);	
		
		String key;
		for(Enumeration keys = this.atributos.keys();keys.hasMoreElements();) {
			key = (String) keys.nextElement();
			attributeContext.putAttribute(key,new Attribute(this.atributos.get(key)));
		}
		
			
		container.render(this.definition, request, response);
		container.endContext(request, response);
	}
}
