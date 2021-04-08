package edu.ucam.actions;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.classes.Product;
import edu.ucam.classes.Vote;
import edu.ucam.database.LoadData;
import edu.ucam.database.RemoveElementByReference;

public class RemoveProduct extends ServletAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter(Product.PRODUCT_ID_PARAM);
		String cantRemove = "";
		if(id!=null &&  (cantRemove=canRemove(request.getContextPath(), id))==null)
			RemoveElementByReference.product(request.getContextPath(), id);
		
		else return "/src/remove_error.jsp?MESSAGE_ERROR="+cantRemove;
			
		
		return "/src/administer.jsp";
	}

	
	private String canRemove(String contextPath, String id) {
		
		ArrayList<Vote> votes = new ArrayList<Vote>();
		LoadData.loadVotes(contextPath, votes);
		
		for(Vote v: votes) 
			if(v.getProductId().equals(id)) {
				return "No puedes eliminar este Producto porque tiene Votos asociados a el. Elimina antes todos sus Votos para poder eliminarlo.";
			}
			
		return null;
	}
}
