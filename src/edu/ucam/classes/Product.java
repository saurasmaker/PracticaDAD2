package edu.ucam.classes;

import java.util.ArrayList;

public class Product {

	
	//Static Atributes
	public static String PRODUCT_PARAM = "PRODUCT_PARAM", PRODUCT_PARAM_NAME = "PRODUCT_PARAM_NAME", 
		PRODUCT_TRADEMARK_PARAM = "PRODUCT_TRADEMARK_PARAM", PRODUCT_MODEL_PARAM = "PRODUCT_MODEL_PARAM", 
		PRODUCT_ID_PARAM = "PRODUCT_ID_PARAM", PRODUCT_DESCRIPTION_PARAM = "PRODUCT_DESCRIPTION_PARAM", 
		PRODUCT_PRICE_PARAM = "PRODUCT_PRICE_PARAM", PRODUCT_IMG_PARAM = "PRODUCT_IMG_PARAM", 
		PRODUCT_IMG_PATH_PARAM = "PRODUCT_IMG_PATH_PARAM", PRODUCT_IMG_NAME_PARAM = "PRODUCT_IMG_NAME_PARAM";
		
	
	
	//Attributes
	String name, trademark, model, description, img_path, id;
	Float price;
	
	//Constructors
	public Product() {
	}
	
	public Product(String name, String trademark, String model, String desription, Float price, String img_path, String id){
		this.name = name;
		this.trademark = trademark;
		this.model = model;
		this.description = desription;
		this.price = price;
		this.img_path = img_path;
		this.id = id;
	}
	
	
	
	//Static Methods
	static public void generateId(Product product, ArrayList<Product> products) {
		//Id Example -> P12223245; The id of the products have 1 character 'P' and 8 numbers.
		
		if(!(products.size() > 0)) {
			product.setId("P0");
			return;
		}
		
		String newId = "P" + (Integer.parseInt(products.get(products.size()-1).getId().substring(1))+1);
		product.setId(newId);
		
		return;
	}
	
	static public void generateIdByReference(Product product, ArrayList<String> products) {
		//Id Example -> P12223245; The id of the products have 1 character 'P' and 8 numbers.	
		if(!(products.size() > 0)) {
			product.setId("P0");
			return;
		}
		
		String previus = products.get(products.size()-1);
		String newId = "P" + (Integer.parseInt(previus.substring(1))+1);
		product.setId(newId);
		
		return;
	}

	
	//Methods
	
	
	
	
	
	//Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrademark() {
		return trademark;
	}

	public void setTrademark(String trademark) {
		this.trademark = trademark;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}
	

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	

}
