package prueba_modelo_tabla;

import java.util.Comparator;

public final class ComparadoresPersona {
	private ComparadoresPersona(){};
	
	public static final int NULL = -1;
	public static final int IDENTIFICADOR = 0;
	public static final int NOMBRE = 1;
	public static final int PRIMER_APELLIDO = 2;
	public static final int SEGUNDO_APELLIDO = 3;
	public static final int CI = 4;
	
	public static Comparator<Persona> getComparadorPersona(int indiceComparador){
		Comparator<Persona> c = null;
		
		switch(indiceComparador){
		case NULL:
			c = null;
			break;
		case IDENTIFICADOR:
			c = new Comparator<Persona>(){
				@Override
				public int compare(Persona p1, Persona p2) {
					return p1.getId().compareTo(p2.getId());
				}};
			break;
		case NOMBRE:
			c = new Comparator<Persona>(){
				@Override
				public int compare(Persona p1, Persona p2) {
					return p1.getNombre().compareToIgnoreCase(p2.getNombre());
				}};
			break;
		case PRIMER_APELLIDO:
			c = new Comparator<Persona>(){
				@Override
				public int compare(Persona p1, Persona p2) {
					return p1.getPrimerApellido().compareToIgnoreCase(p2.getPrimerApellido());
				}};
			break;
		case SEGUNDO_APELLIDO:
			c = new Comparator<Persona>(){
				@Override
				public int compare(Persona p1, Persona p2) {
					return p1.getSegundoApellido().compareToIgnoreCase(p2.getSegundoApellido());
				}};
			break;
		case CI:
			c = new Comparator<Persona>(){
				@Override
				public int compare(Persona p1, Persona p2) {
					return p1.getCi().compareTo(p2.getCi());
				}};
			break;
		default:
			throw new IllegalArgumentException("Índice no válido");
		}
		
		return c;
	}
}
