package edu.ucam.interfaces;

import java.util.ArrayList;

import edu.ucam.classes.User;

public interface UsuariosBdd {
	public boolean registrarUsuarios(User cliente);
	public boolean actualizarUsuarios(User cliente);
	public boolean eliminarUsuarios(User cliente);
	public ArrayList<User> obtenerUsuarios();
}
