package edu.ucam.servlets;
import edu.ucam.classes.*;
import edu.ucam.database.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Insercion
 */
@WebServlet("/Insercion")
public class ActionInsertion extends HttpServlet {
	
	
	public static String PARAM_INSERT = "ActionInsertion", PARAM_INSERT_USER = "PARAM_INSERT_USER", PARAM_INSERT_PRODUCT = "PARAM_INSERT_PRODUCT",
			PARAM_INSERT_VOTE = "PARAM_INSERT_VOTE", PARAM_INSERT_COMMENT = "PARAM_INSERT_COMMENT";
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionInsertion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opc = request.getParameter(PARAM_INSERT);
		
		switch(opc) {
		case "PARAM_INSERT_USER":
			insertUser(request,response);
			break;
		case "PARAM_INSERT_PRODUCT":
			insertProduct(request,response);
			break;
		case "PARAM_INSERT_VOTE":
			insertVote(request,response);
			break;
		case "PARAM_INSERT_COMMENT":
			insertComment(request,response);
			break;
		default:
			break;
		}

		request.getRequestDispatcher("/insercion.jsp").forward(request, response);
	}


	
		
	//Methods
	private static void insertUser(HttpServletRequest request, HttpServletResponse response) {
		
		String username = request.getParameter(User.USER_USERNAME_PARAM);
		String email = request.getParameter(User.USER_EMAIL_PARAM);
		String password = request.getParameter(User.USER_PASSWORD_PARAM);
		String biografia = request.getParameter(User.USER_BIOGRAPHY_PARAM);
		String direccion = request.getParameter(User.USER_ADDRESS_PARAM);
		User user = new User(username, email, password, null);
		user.setAddress(direccion);
		user.setBiography(biografia);
		
		SaveDataByReference.User(user);
		
		return;
	}
	
	
	private static void insertProduct(HttpServletRequest request, HttpServletResponse response) {
		
		String nombre = request.getParameter(Product.PRODUCT_PARAM_NAME);
		String marca = request.getParameter(Product.PRODUCT_TRADEMARK_PARAM);
		String modelo = request.getParameter(Product.PRODUCT_MODEL_PARAM);
		String descripcion = request.getParameter(Product.PRODUCT_DESCRIPTION_PARAM);
		String precioS = request.getParameter(Product.PRODUCT_PRICE_PARAM);
		float precio = Float.parseFloat(precioS);
		Product product = new Product(nombre, marca, modelo, descripcion, precio, null);
	
		SaveDataByReference.Product(product);
		
		return;
	}
	
	
	private static void insertVote(HttpServletRequest request, HttpServletResponse response) {
		
		int assessment = Integer.parseInt(request.getParameter(Vote.VOTE_ASSESSMENT_PARAM));
		String userId = request.getParameter(Vote.VOTE_USER_PARAM);
		String productId = request.getParameter(Vote.VOTE_PRODUCT_PARAM);
		Vote vote = new Vote(assessment, userId, productId, null);
		try {
			vote.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter(Vote.VOTE_DATE_PARAM)));
		} catch (ParseException e) {
			vote.setDate(null);
		}
	
		SaveDataByReference.Vote(vote);
		
		return;
	}

	
	private static void insertComment(HttpServletRequest request, HttpServletResponse response) {
	
		String resume = request.getParameter(Comment.COMMENT_RESUME_PARAM);
		String content = request.getParameter(Comment.COMMENT_CONTENT_PARAM);
		String vote = request.getParameter(Comment.COMMENT_VOTE_ID_PARAM);
		Comment comment = new Comment(resume, content, vote, null);

		SaveDataByReference.Comment(comment);
	
	return;
}

}
