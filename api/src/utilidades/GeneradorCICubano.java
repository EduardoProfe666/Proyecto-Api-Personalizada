package utilidades;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

/**
 * Clase que permite generar ci cubanos y otras funcionalidades extras.<br>
 * El algoritmo del ci cubano utiliza el sgte formato para generar los 11 dígitos del mismo:<br>
 * .<b>Dígitos 1-2</b>: Dígitos que representan los 2 últimos dígitos del año de nacimiento. Por ejemplo: <b>2002-:02</b><br>
 * .<b>Dígitos 3-4</b>: Dígitos que representan el mes de nacimiento, siendo <b>enero-:01</b> y <b>diciembre-:12</b><br>
 * .<b>Dígitos 5-6</b>: Dígitos que representan el día de nacimiento. Por ejemplo: <b>01</b> y <b>31</b><br>
 * .<b>Dígitos 7</b>: Dígito que representan el siglo de nacimiento, siendo <b>0-5 -: Siglo XX</b>, <b>6-8 -: Siglo XXI</b> y <b>9 -: Siglo XIX</b><br>
 * .<b>Dígitos 8-9</b>: Dígitos aleatorios<br>
 * .<b>Dígitos 10</b>: Dígito que representa el sexo, de forma tal que si es par es masculino e impar si es femenino<br>
 * .<b>Dígitos 11</b>: Dígito  aleatorio (En verdad este es un dígito de control, pero no se pudo recolectar el algoritmo empleado para su generación)<br>
 * 
 * <h1>Métodos implementados:</h1>
 * 1.--{@link #generarCICubano(Sexo, int)}<br>
 * 2.--{@link #generarCICubano(Sexo, int, int)}<br>
 * 3.--{@link #generarListadoCICubano(int, Sexo, int, int)}<br>
 * 4.--{@link #generarInformeListadoCiCubano(int, Sexo, int, int)}<br>
 * 
 * 
 * <h1>Ver:</h1>
 * .---{@link Sexo}
 * 
 * @author EduardoProfe
 * @version 27/08/2023
 *
 */
public final class GeneradorCICubano {
	private GeneradorCICubano() {}
	private static final Random rnd = new Random();
	
	/**
	 * Permite generar de forma aleatoria un ci cubano válido con {@link Sexo} y edad dados.
	 * 
	 * @param sexo {@link Sexo} del ci a generar
	 * @param edad Edad del ci a generar
	 * @return Ci cubano generado
	 */
	public static String generarCICubano(Sexo sexo, int edad){
		if(sexo==null || edad<0)
			throw new IllegalArgumentException("Parámetros Erróneos");
		return generarCICubano(sexo, edad, edad);
	}
	
	/**
	 * Permite generar de forma aleatoria un ci cubano válido con {@link Sexo} dado y una edad aleatoria en el rango entre edadMin y edadMax.
	 * 
	 * @param sexo {@link Sexo} del ci a generar
	 * @param edadMin Edad mínima del ci a generar
	 * @param edadMax Edad máxima del ci a generar
	 * @return Ci cubano generado
	 */
	public static String generarCICubano(Sexo sexo, int edadMin, int edadMax){
		if(sexo==null || edadMax<0 || edadMin<0 || edadMin>edadMax)
			throw new IllegalArgumentException("Parámetros Erróneos");
		Date fechaMin = Auxiliares.sumarAnyosFecha(new Date(), -edadMin);
		Date fechaMax = Auxiliares.sumarAnyosFecha(new Date(), -edadMax);
		Calendar fechaNacimiento = generarFechaCalendar(fechaMin, fechaMax);
		
		int anyo = fechaNacimiento.get(Calendar.YEAR);
		int mes = fechaNacimiento.get(Calendar.MONTH)+1;
		int dia = fechaNacimiento.get(Calendar.DAY_OF_MONTH);
		int sigloDisminuido = anyo/100;
		int anyoCi = anyo-(sigloDisminuido*100);
		
		return ""+convertirEnteroDobleString(anyoCi)+convertirEnteroDobleString(mes)+convertirEnteroDobleString(dia)+generarDigitoSiglo(sigloDisminuido)+convertirEnteroDobleString(generarEntero(0,99))+generarDigitoSexo(sexo)+generarEntero(0,9);
	}
	
	/**
	 * Permite generar un listado con una cantidad determinada de ci cubanos únicos y de forma aleatoria. Se generarán con el {@link Sexo} dado y una edad aleatoria en el rango entre edadMin y edadMax.
	 * 
	 * @param cantidad Cantidad de ci cubanos a generar
	 * @param sexo {@link Sexo} de los ci a generar
	 * @param edadMin Edad mínima de los ci a generar
	 * @param edadMax Edad máxima de los ci a generar
	 * @return Listado de ci cubanos generados
	 */
	public static List<String> generarListadoCICubano(int cantidad, Sexo sexo, int edadMin, int edadMax){
		List<String> listadoCi = new ArrayList<String>(cantidad);
		for(int i=0;i<cantidad;i++){
			String ci;
			do{
				ci = generarCICubano(sexo, edadMin, edadMax);
			}while(comprobarCiExistente(ci, listadoCi));
			listadoCi.add(ci);
		}
		Collections.sort(listadoCi);
		return listadoCi;
	}
	
	/**
	 * Permite generar un txt en la carpeta raiz que contiene un listado con una cantidad determinada de ci cubanos únicos y de forma aleatoria. Se generarán con el {@link Sexo} dado y una edad aleatoria en el rango entre edadMin y edadMax. 
	 * Este archivo se crea con el nombre <b>Listado_Ci_Generados.txt</b>. Al crearse, se imprime por consola la ruta del archivo generado.
	 * 
	 * @param cantidad Cantidad de ci cubanos a generar
	 * @param sexo {@link Sexo} de los ci a generar
	 * @param edadMin Edad mínima de los ci a generar
	 * @param edadMax Edad máxima de los ci a generar
	 */
	public static void generarInformeListadoCiCubano(int cantidad, Sexo sexo, int edadMin, int edadMax){
		File f = new File("Listado_Ci_Generados.txt");
		f.delete();
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(PrintWriter pw = new PrintWriter(f)){
			for(String s : generarListadoCICubano(cantidad, sexo, edadMin, edadMax)){
				pw.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Ruta del archivo generado: "+System.getProperty("user.dir")+"/Listado_Ci_Generados.txt");
		
	}
	
	private static String convertirEnteroDobleString(int entero) {
		String s = String.valueOf(entero);
		if(entero>=0 && entero<10) {
			s = "0"+s;
		}
		return s;
	}
	
	private static int generarDigitoSiglo(int sigloDisminuido) {
		int digito=9;

		if(sigloDisminuido==19)
			digito = rnd.nextInt(6);
		else if(sigloDisminuido==20)
			digito = rnd.nextInt(3)+6;

		return digito;
	}
	
	private static int generarDigitoSexo(Sexo sexo) {
		int digito=rnd.nextInt(10);
		if(sexo.equals(Sexo.FEMENINO) || (sexo.equals(Sexo.ALEATORIO) && rnd.nextBoolean())) {
			if(digito%2==0) {
				digito++;
			}

		}
		else if(digito%2==1){
			digito--;
		}
		return digito;
	}
	
	private static int generarEntero(int min, int max) {
		return rnd.nextInt(max-min+1)+min;
	}
	
	private static Calendar generarFechaCalendar(Date fechaMinima, Date fechaMaxima) {
		long max = fechaMaxima.getTime(); 
		long min = fechaMinima.getTime();
		long fechaLong = min + (long)(Math.random() * (max-min));

		Calendar c = new GregorianCalendar();
		c.setTimeInMillis(fechaLong);
		return c;
	}
	
	private static boolean comprobarCiExistente(String ci,List<String> listadoCI) {
		boolean esValido = ci!=null;
		
		if(esValido)
			esValido = Collections.binarySearch(listadoCI, ci)>=0;
		return esValido;
	}
	
	/**
	 * Enum que permite modelar el sexo de los ci a generar. Los sexos actualmente soportados son:<br>
	 * 1.--{@link #FEMENINO}<br>
	 * 2.--{@link #MASCULINO}<br>
	 * 3.--{@link #ALEATORIO}<br>
	 * @author EduardoProfe
	 *
	 */
	public static enum Sexo{
		/**
		 * Permite generar ci de sexo femenino
		 * 
		 * @author EduardoProfe
		 */
		FEMENINO,
		/**
		 * Permite generar ci de sexo masculino
		 * 
		 * @author EduardoProfe
		 */
		MASCULINO,
		/**
		 * Permite generar ci tanto de sexo femenino como masculino
		 * 
		 * @author EduardoProfe
		 */
		ALEATORIO
	}
	
}
