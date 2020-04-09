package edu.ucam.tools;
import edu.ucam.interfaces.*;
import edu.ucam.classes.*;
import java.sql.*;

public class BddUser implements UsuariosBdd{
	@Override
	public boolean registrarUsuarios(User clientes){
		boolean registro = false;
		Connection stm = null;
		Statement con = null;
		String sql = "insert into ------- values ("+clientes.getUsername()+"','"+clientes.getEmail()+"','"+clientes.getPassword()+"','"+clientes.getId+"')";
		try {			
			con=Conexion.conectar();
			stm= con.createStatement();
			stm.execute(sql);
			registro=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clientes, método registrar");
			e.printStackTrace();
		}
		return registro;
	}
}
