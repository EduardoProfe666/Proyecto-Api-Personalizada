package api.utilidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que permitirá
 * 
 * @version 06/07/2023
 * @author EduardoProfe
 *
 */
public final class GeneradorCarnetIdentidadCubano {
	private List<String> listadoCI;
	private static GeneradorCarnetIdentidadCubano instancia;
	
	public static GeneradorCarnetIdentidadCubano getInstancia() {
		if(instancia==null)
			instancia = new GeneradorCarnetIdentidadCubano();
		return instancia;
	}
	
	public static GeneradorCarnetIdentidadCubano generarNuevaInstancia() {
		instancia = new GeneradorCarnetIdentidadCubano();
		return instancia;
	}
	
	private GeneradorCarnetIdentidadCubano() {
		listadoCI = new LinkedList<String>();
	}
	
	public ArrayList<String> getListadoCI() {
		return new ArrayList<String>(listadoCI);
	}
	
	public void borrarCIGenerados() {
		listadoCI.clear();
	}
	
	private boolean comprobarCiExistente(String ci) {
		boolean esValido = ci!=null;
		
		if(esValido)
			esValido = Collections.binarySearch(listadoCI, ci)>=0;
		return esValido;
	}
	
}
