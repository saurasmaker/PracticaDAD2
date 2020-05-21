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

public class RemoveProduct extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter(Product.PRODUCT_ID_PARAM);
		
		if(id!=null && canRemove(id))
			RemoveElementByReference.product(id);
		
		return "/GoTo?GO_TO=/src/administer.jsp";
	}

	
	private Boolean canRemove(String id) {
		
		ArrayList<Vote> votes = new ArrayList<Vote>();
		LoadData.loadVotes(votes);
		
		for(Vote v: votes) 
			if(v.getProductId().equals(id)) 
				return false;
			
		return true;
	}
}
