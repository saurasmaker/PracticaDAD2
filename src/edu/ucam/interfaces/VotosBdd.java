package edu.ucam.interfaces;

import edu.ucam.classes.Vote;
import java.util.ArrayList;

public interface VotosBdd {
	public boolean registrarVotos(Vote voto);
	public boolean actualizarVotos(Vote voto);
	public boolean eliminarVotos(Vote voto);
	public ArrayList<Vote> obtenerVotos();
}
