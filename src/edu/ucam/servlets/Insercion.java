package edu.ucam.servlets;
import edu.ucam.classes.*;
import edu.ucam.servlets.*;
import edu.ucam.database.*;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.database.SaveData;

/**
 * Servlet implementation class Insercion
 */
@WebServlet("/Insercion")
public class Insercion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insercion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opc = request.getParameter("tipoInsercion");
		SaveDataByReference save = new SaveDataByReference();
		if(opc == "1") {
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String biografia = request.getParameter("biografia");
			String direccion = request.getParameter("adress");
			User user = new User(username, email, password, null);
			user.setAddress(direccion);
			user.setBiography(biografia);
			save.User(user);
		}else if(opc == "2") {
			String nombre = request.getParameter("name");
			String marca = request.getParameter("trademark");
			String modelo = request.getParameter("model");
			String descripcion = request.getParameter("description");
			String precioS = request.getParameter("price");
			float precio = Float.parseFloat(precioS);
			Product product = new Product(nombre, marca, modelo, descripcion, precio, null);
			save.Product(product);
		}else if(opc == "3") {
			String evaluacionS = request.getParameter("assessment");
			int evaluacion = Integer.parseInt(evaluacionS);
			String userId = request.getParameter("userId");
			String productId = request.getParameter("productId");
			String fechaS = request.getParameter("date");
			Date fecha = Date.valueOf(fechaS);
			Vote vote = new Vote(evaluacion, userId, productId, null);
			vote.setDate(fecha);
			save.Vote(vote);
		}else if(opc == "4") {
			String resumo = request.getParameter("resume");
			String contenido = request.getParameter("content");
			String voto = request.getParameter("vote");
			Comment comment = new Comment(resumo, contenido, voto, null);
			save.Comment(comment);
		}
		request.getRequestDispatcher("/insercion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
