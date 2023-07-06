package api.prueba_modelo_tabla;

import java.util.ArrayList;

import api.prueba_modelo_tabla.Persona;

public class Principal {
	private static Principal instancia;
	private ArrayList<Persona> listado;
	
	public static Principal getInstancia(){
		if(instancia==null)
			instancia=new Principal();
		return instancia;
	}
	
	private Principal(){
		this.listado = new ArrayList<Persona>(); 
	}
	
	public ArrayList<Persona> getListado(){
		return new ArrayList<Persona>(listado);
	}
	
	public Persona getPersona(int indice){
		return listado.get(indice);
	}
	public int getIndicePersona(Persona p){
		return listado.indexOf(p);
	}
	public void addPersonaX(String nombre, String primerApellido,
			String segundoApellido, String ci, Integer id){
		listado.add(new Persona(nombre,primerApellido,segundoApellido,ci,id));
	}
	public void addPersona(String nombre, String primerApellido,
			String segundoApellido, String ci, Integer id){
		listado.add(new Persona(nombre,primerApellido,segundoApellido,ci,id));
	}
	public void removePersona(int indice){
		listado.remove(indice);
	}
}
