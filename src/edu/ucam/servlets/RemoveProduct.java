package edu.ucam.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.classes.Comment;
import edu.ucam.classes.Product;
import edu.ucam.classes.Vote;
import edu.ucam.database.LoadData;
import edu.ucam.database.LoadDataReferences;
import edu.ucam.database.RemoveElementByReference;

/**
 * Servlet implementation class RemoveProduct
 */
@WebServlet("/RemoveProduct")
public class RemoveProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter(Product.PRODUCT_ID_PARAM);
		
		if(id!=null && canRemove(id))
			RemoveElementByReference.product(id);
		
		request.getRequestDispatcher("/GoTo?GO_TO=/src/administer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
