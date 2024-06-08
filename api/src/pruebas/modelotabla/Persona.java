package pruebas.modelotabla;

public class Persona implements Comparable<Persona>{

	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String ci;
	private Integer id;
	
	public Persona(String nombre, String primerApellido,
			String segundoApellido, String ci, Integer id) {
		this.setNombre(nombre);
		this.setPrimerApellido(primerApellido);
		this.setSegundoApellido(segundoApellido);
		this.setCi(ci);
		this.setId(id);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}
	public String nombreCompleto(){
		return nombre + " " + primerApellido + " " + segundoApellido;
	}

	@Override
	public int compareTo(Persona p) {
		return id.compareTo(p.id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}	
