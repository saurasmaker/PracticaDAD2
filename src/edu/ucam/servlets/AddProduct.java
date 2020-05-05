package edu.ucam.servlets;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import edu.ucam.classes.Product;

import edu.ucam.database.LoadDataReferences;
import edu.ucam.database.SaveDataByReference;
import edu.ucam.tools.ProjectPath;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
@MultipartConfig
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		request.getRequestDispatcher("/GoTo?GO_TO=/src/administer.jsp").forward(request, response);
		
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product newProduct = new Product();
		newProduct.setName(request.getParameter(Product.PRODUCT_PARAM_NAME));
		newProduct.setTrademark(request.getParameter(Product.PRODUCT_TRADEMARK_PARAM));
		newProduct.setModel(request.getParameter(Product.PRODUCT_MODEL_PARAM));
		newProduct.setDescription(request.getParameter(Product.PRODUCT_DESCRIPTION_PARAM));
		
		try{newProduct.setPrice(Float.parseFloat(request.getParameter(Product.PRODUCT_PRICE_PARAM).replace(",", "."))); System.out.println(newProduct.getPrice());}catch(Exception t) {newProduct.setPrice(new Float(22.22));}
		
		String fileName = request.getParameter(Product.PRODUCT_IMG_NAME_PARAM);
		
		Part imgPart = request.getPart(Product.PRODUCT_IMG_PARAM);
		Collection<String> headers = imgPart.getHeaders("content-disposition");
		
		if (headers != null) {
			String allHeaders = "";
			for(String header : headers){
				allHeaders += header;                  
		   } 
			String[] headerSplited = allHeaders.replace("\\", "/").split("/");
			headerSplited = headerSplited[headerSplited.length-1].split("\"");
			fileName = headerSplited[headerSplited.length-1].replace(" ", "_");
		}

        if (imgPart!=null) {
            if (!imgPart.getContentType().contains("image") == false) {
            	fileName = ProjectPath.getPathWindowsVersion() + "WebContent/img/products/" + fileName;
            	String[] aux =  fileName.split("/");
            	String imageName = aux[aux.length-1];
                guardarImagenDeProdructoEnElSistemaDeFicheros(imgPart.getInputStream(), fileName);
                newProduct.setImg_path(imageName);
            }
        }

        
        if(newProduct.getName()!=null) {
        	ArrayList<String> productsReferences = new ArrayList<String>();
        	LoadDataReferences.loadProductsReferences(productsReferences);	
	
        	Product.generateIdByReference(newProduct, productsReferences.get(productsReferences.size()-1));
	
        	SaveDataByReference.Product(newProduct);
        }
        
		doGet(request, response);
	}

	
	public static void guardarImagenDeProdructoEnElSistemaDeFicheros(InputStream input, String fileName)
			throws ServletException {
	    
		FileOutputStream output = null;
	    
	    try {
	        output = new FileOutputStream(fileName);
	        int leido = 0;
	        leido = input.read();
	        while (leido != -1) {
	            output.write(leido);
	            leido = input.read();
	        }
	    } catch (Exception ex) {
	    } finally {
	        try {
	            output.flush();
	            output.close();
	            input.close();
	        } catch (Exception ex) {
	        }
	    }
	}
	
}
