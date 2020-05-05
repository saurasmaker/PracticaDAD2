package edu.ucam.database;

import java.io.File;
import java.util.ArrayList;

import edu.ucam.classes.Product;
import edu.ucam.classes.User;

public class PruebasDataBase {

	public static void main(String[] args) {
		/*User newUser = new User();
		newUser.setUsername("pruebadatabase");
		newUser.setEmail("correo@prueba.es");
		newUser.setPassword("contraseñadeprueba");
		newUser.setAddress("direccion de prueba");
		newUser.setBiography("Esto es una biografia para comprobar que todo funciona perfectamentes");

		String path = System.getProperty("user.dir") + "/WebContent/";
		
		ArrayList<String> usersReferences = new ArrayList<String>();
		LoadDataReferences.loadUsersReferences(usersReferences, path);
		User.generateIdByReference(newUser, usersReferences.get(usersReferences.size()-1));
		
		SaveDataByReference.User(newUser, path);
		System.out.println("nuevo usuario: " + newUser.getId());
		*/
		
		ArrayList<String> usersReferences = new ArrayList<String>();
		LoadDataReferences.loadUsersReferences(usersReferences);
		System.out.println("\n Lista usuarios: ");		
		for(int i = 0; i < usersReferences.size(); ++i){
			User u = LoadDataByReference.user(usersReferences.get(i));
			System.out.println(u.getUsername());
		}
		
		


		
		System.out.println("\n" + edu.ucam.tools.ProjectPath.getPathWindowsVersion() + "WebContent/database/");

		
		/*Product newProduct = new Product();
		newProduct.setName("nombre producto");
		newProduct.setImg_path("asdf");
		newProduct.setModel("modelo");
		newProduct.setPrice(Float.parseFloat("12.12"));
		newProduct.setTrademark("marca de turno");
		
		String path = System.getProperty("user.dir") + "/WebContent/";
		
		ArrayList<String> productsReferences = new ArrayList<String>();
		LoadDataReferences.loadUsersReferences(productsReferences, path);
		Product.generateIdByReference(newProduct, productsReferences.get(productsReferences.size()-1));
		
		Product.generateIdByReference(newProduct, productsReferences.get(productsReferences.size()-1));
		
		/*productsReferences = new ArrayList<String>();
		LoadDataReferences.loadProductsReferences(productsReferences, path);
			System.out.println("\n Lista Productos: ");		
		for(int i = 0; i < productsReferences.size(); ++i){
			Product p = LoadDataByReference.product(productsReferences.get(i), path);
			System.out.println(p.getName());
		}*/
	}

}
