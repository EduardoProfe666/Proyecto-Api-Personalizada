package utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase que permite generar nombres femeninos y masculinos y apellidos, junto con una serie de funcionalidades extras.
 * 
 * <h1>Métodos implementados:</h1>
 * 1.--{@link #generarNombre(Sexo, Complejidad)}<br>
 * 2.--{@link #generarNombres(Sexo)}<br>
 * 3.--{@link #generarNombres(int, Sexo)}<br>
 * 4.--{@link #generarApellido(Complejidad)}<br>
 * 5.--{@link #generarApellidos()}<br>
 * 6.--{@link #generarApellidos(int)}<br>
 * 7.--{@link #generarNombreYApellidos(Sexo, Complejidad, Complejidad)}<br>
 * 8.--{@link #generarListadoNombreYApellidos(int, Sexo, Complejidad, Complejidad)}<br>
 * 9.--{@link #generarInformeListadoNombreYApellidos(int, Sexo, Complejidad, Complejidad)}<br>
 * 
 * 
 * <h1>Ver:</h1>
 * .---{@link Sexo}<br>
 * .---{@link Complejidad}<br> 
 * 
 * @author EduardoProfe
 * @version 27/08/2023
 *
 */
public final class GeneradorNombres {
	private GeneradorNombres(){}

	private static List<String> nombres_femeninos = inicializar_nombres_femeninos();
	private static List<String> nombres_masculinos = inicializar_nombres_masculinos();
	private static List<String> apellidos = inicializar_apellidos();
	
	/**
	 * Cantidad de nombres femeninos de la piscina de datos = 2001.
	 */
	public static final int cantNombresFemeninos = 2001;
	/**
	 * Cantidad de nombres masculinos de la piscina de datos = 1599.
	 */
	public static final int cantNombresMasculinos = 1599;
	/**
	 * Cantidad de nombres tanto femeninos como masculinos de la piscina de datos=3600.
	 */
	public static final int cantNombres = cantNombresFemeninos+cantNombresMasculinos;
	/**
	 * Cantidad de apellidos de la piscina de datos = 4908.
	 */
	public static final int cantApellidos = 4908;

	private static List<String> inicializar_nombres_femeninos(){
		List<String> nombres = new ArrayList<String>();
		File f = new File("src/utilidades/nombres/nombres_femeninos.txt");
		try(Scanner sc = new Scanner(f)){
			while(sc.hasNext()){
				nombres.add(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nombres;

	}
	private static List<String> inicializar_nombres_masculinos(){
		List<String> nombres = new ArrayList<String>();
		File f = new File("src/utilidades/nombres/nombres_masculinos.txt");
		try(Scanner sc = new Scanner(f)){
			while(sc.hasNext()){
				nombres.add(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nombres;

	}
	private static List<String> inicializar_apellidos(){
		List<String> apellidos = new ArrayList<String>();
		File f = new File("src/utilidades/nombres/apellidos.txt");
		try(Scanner sc = new Scanner(f)){
			while(sc.hasNext()){
				apellidos.add(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return apellidos;
	}
	
	/**
	 * Permite generar todos los nombres posibles del {@link Sexo} pasado. La cantidad de nombres generados, en 
	 * dependencia del Sexo seleccionado es:<br>
	 * .<b>Femenino</b>: {@link #cantNombresFemeninos}<br>
	 * .<b>Masculino</b>: {@link #cantNombresMasculinos}<br>
	 * .<b>Aleatorio</b>: {@link #cantNombres}
	 * 
	 * @param sexo Sexo de los nombres a generar
	 * @return Listado de nombres generados
	 * 
	 * @author EduardoProfe
	 */
	public static List<String> generarNombres(Sexo sexo) {
		List<String> s = new ArrayList<>();
		switch (sexo) {
		case FEMENINO:
			s.addAll(nombres_femeninos);
			break;
		case MASCULINO:
			s.addAll(nombres_masculinos);
			break;
		case ALEATORIO:
			s.addAll(nombres_femeninos);
			s.addAll(nombres_masculinos);
			break;
		default:
			throw new IllegalArgumentException("Parametros erroneos");
		}
		Collections.sort(s);
		
		return s;
	}
	
	/**
	 * Permite generar una cantidad de nombres del {@link Sexo} pasado. La cantidad máxima de nombres generados, en 
	 * dependencia del Sexo seleccionado es:<br>
	 * .<b>Femenino</b>: {@link #cantNombresFemeninos}<br>
	 * .<b>Masculino</b>: {@link #cantNombresMasculinos}<br>
	 * .<b>Aleatorio</b>: {@link #cantNombres}
	 * 
	 * @param cantidad Cantidad de los nombres a generar
	 * @param sexo Sexo de los nombres a generar
	 * @return Listado de nombres generados
	 * 
	 * @author EduardoProfe
	 */
	public static List<String> generarNombres(int cantidad, Sexo sexo){
		List<String> s = generarNombres(sexo);
		Collections.shuffle(s);
		s = s.subList(0, cantidad-1);
		Collections.sort(s);
		return s;
	}
	
	/**
	 * Permite generar todos los apellidos posibles, es decir, un listado de {@value #cantApellidos} apellidos.
	 * 
	 * @return Listado de apellidos generados
	 */
	public static List<String> generarApellidos() {
		return new ArrayList<String>(apellidos);
	}
	
	/**
	 * Permite generar una cantidad de apellidos, teniendo como máximo {@value #cantApellidos} apellidos.
	 * @param cantidad Cantidad de apellidos a generar
	 * @return Listado de apellidos generados
	 */
	public static List<String> generarApellidos(int cantidad) {
		List<String> s = generarApellidos();
		Collections.shuffle(s);
		s = s.subList(0, cantidad-1);
		Collections.sort(s);
		return s;
	}
	
	/**
	 * Permite generar un nombre con determinado {@link Sexo} y {@link Complejidad}
	 * 
	 * @param sexo {@link Sexo} del nombre a generar
	 * @param complejidad {@link Complejidad} del nombre a generar
	 * @return Nombre generado
	 */
	public static String generarNombre(Sexo sexo, Complejidad complejidad) {
		List<String> s = new ArrayList<String>();
		String respuesta;
		switch(sexo){
		case FEMENINO:
			s.addAll(nombres_femeninos);
			break;
		case MASCULINO:
			s.addAll(nombres_masculinos);
			break;
		case ALEATORIO:
			s.addAll(nombres_masculinos);
			s.addAll(nombres_femeninos);
			break;
		default:
			throw new RuntimeException("Sexo NULL");
		}
		if(complejidad.equals(Complejidad.ALEATORIA)){
			respuesta = s.get(new Random().nextInt(s.size()));
			if(new Random().nextBoolean()){
				respuesta+=" "+s.get(new Random().nextInt(s.size()));
			}
		}
		else{
			respuesta = s.get(new Random().nextInt(s.size()));
			if(complejidad.equals(Complejidad.COMPUESTA))
				respuesta+=" "+s.get(new Random().nextInt(s.size()));
		}
		return respuesta;
	}
	/**
	 * Permite generar un apellido con determinada {@link Complejidad}
	 * 
	 * @param complejidad {@link Complejidad} del apellido a generar
	 * @return Apellido generado
	 */
	public static String generarApellido(Complejidad complejidad) {
		String s;
		if(complejidad.equals(Complejidad.ALEATORIA)){
			s = apellidos.get(new Random().nextInt(apellidos.size()));
			if(new Random().nextBoolean())
				s+=" "+apellidos.get(new Random().nextInt(apellidos.size()));
		}
		else{
			s = apellidos.get(new Random().nextInt(apellidos.size()));
			if(complejidad.equals(Complejidad.COMPUESTA))
				s+=" "+apellidos.get(new Random().nextInt(apellidos.size()));
		}
		return s;
	}
	
	/**
	 * Permite generar un nombre/s con apellido/s con determinado {@link Sexo}, {@link Complejidad} del nombre y {@link Complejidad} del apellido
	 * 
	 * @param sexo {@link Sexo} del nombre a generar
	 * @param complejidadNombre {@link Complejidad} del nombre a generar
	 * @param complejidadApellido {@link Complejidad} del apellido a generar
	 * @return Nombre y apellido generado
	 */
	public static String generarNombreYApellidos(Sexo sexo, Complejidad complejidadNombre, Complejidad complejidadApellido){
		return generarNombre(sexo, complejidadNombre)+" "+generarApellido(complejidadApellido);
	}
	
	/**
	 * Permite generar una cantidad determinada de nombres con apellidos con determinado {@link Sexo}, {@link Complejidad} del nombre y {@link Complejidad} del apellido
	 *  
	 * @param cantidad Cantidad de nombres a generar
	 * @param sexo {@link Sexo} del nombre a generar
	 * @param complejidadNombre {@link Complejidad} del nombre a generar
	 * @param complejidadApellido {@link Complejidad} del apellido a generar
	 * @return Listado de nombre y apellido generados
	 */
	public static List<String> generarListadoNombreYApellidos(int cantidad, Sexo sexo,Complejidad complejidadNombre, Complejidad complejidadApellido){
		List<String> s = new ArrayList<String>();
		for(int i=0;i<cantidad;i++){
			s.add(generarNombreYApellidos(sexo, complejidadNombre, complejidadApellido));
		}
		return s;
	}
	
	/**
	 * Permite generar un archivo txt en la carpeta raiz que contiene un listado de nombres y apellidos con determinado {@link Sexo}, {@link Complejidad} de los nombres y {@link Complejidad} de los apellidos. 
	 * Este archivo se crea con el nombre <b>Listado_Nombre_y_Apellidos_Generados.txt</b>. Al crearse, se imprime por consola la ruta del archivo generado.
	 * 
	 * @param cantidad Cantidad de nombres a generar
	 * @param sexo {@link Sexo} del nombre a generar
	 * @param complejidadNombre {@link Complejidad} del nombre a generar
	 * @param complejidadApellido {@link Complejidad} del apellido a generar
	 */
	public static void generarInformeListadoNombreYApellidos(int cantidad, Sexo sexo,Complejidad complejidadNombre, Complejidad complejidadApellido){
		File f = new File("Listado_Nombre_y_Apellidos_Generados.txt");
		f.delete();
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(PrintWriter pw = new PrintWriter(f)){
			for(String s : generarListadoNombreYApellidos(cantidad, sexo, complejidadNombre, complejidadApellido)){
				pw.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Ruta del archivo generado: "+System.getProperty("user.dir")+"/Listado_Nombre_y_Apellidos_Generados.txt");
		
	}

	/**
	 * Enum que permite modelar el sexo de los nombres a generar. Los sexos actualmente soportados son:<br>
	 * 1.--{@link #FEMENINO}<br>
	 * 2.--{@link #MASCULINO}<br>
	 * 3.--{@link #ALEATORIO}<br>
	 * @author EduardoProfe
	 *
	 */
	public static enum Sexo{
		/**
		 * Permite generar nombres de sexo femenino
		 * 
		 * @author EduardoProfe
		 */
		FEMENINO,
		/**
		 * Permite generar nombres de sexo masculino
		 * 
		 * @author EduardoProfe
		 */
		MASCULINO,
		/**
		 * Permite generar nombres tanto de sexo femenino como masculino
		 * 
		 * @author EduardoProfe
		 */
		ALEATORIO
	}
	
	/**
	 * Enum que permite modelar la complejidad de los nombres y apellidos a generar. Las complejidades actualmente soportadas son:<br>
	 * 1.--{@link #SIMPLE}<br>
	 * 2.--{@link #COMPUESTA}<br>
	 * 3.--{@link #ALEATORIA}<br>
	 * @author EduardoProfe
	 *
	 */
	public static enum Complejidad {
		/**
		 * Permite generar nombres y apellidos simples; es decir, nombres y apellidos con una sola ocurrencia.<br>
		 * Por ejemplo:<br>
		 * .<b>Nombre Simple</b> -: Juan<br>
		 * .<b>Apellido Simple</b> -: Rojas<br>
		 * .<b>Nombre y Apellido Simples</b> -: Juan Rojas<br>
		 * 
		 * @author EduardoProfe
		 */
		SIMPLE,
		/**
		 * Permite generar nombres y apellidos compuestos; es decir, nombres y apellidos con doble sola ocurrencia.<br>
		 * Por ejemplo:<br>
		 * .<b>Nombre Compuesto</b> -: Juan Alejandro<br>
		 * .<b>Apellido compuesto</b> -: Rojas Rosales<br>
		 * .<b>Nombre y Apellido compuestos</b> -: Juan Alejandro Rojas Rosales<br>
		 * 
		 * @author EduardoProfe
		 */
		COMPUESTA,
		/**
		 * Permite generar nombres y apellidos tanto simples como compuestos; es decir, nombres y apellidos con una o doble sola ocurrencia.
		 * Ver {@link #SIMPLE} y {@link #COMPUESTA}
		 * 
		 * @author EduardoProfe
		 */
		ALEATORIA
	}

}
