package utilidades;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Clase de utilidades que contiene algunos métodos auxiliares para el trabajo con {@link Date}
 * y con el carnet de identidad, además de otros. El acceso a sus métodos es de manera estática.
 * 
 * <h1>Métodos implementados:</h1>
 * 1.--{@link #convertirFechaNacimientoCiDate(String)}<br>
 * 2.--{@link #determinarEdad(Date)}<br>
 * 3.--{@link #determinarDiferenciaAnyos(Date, Date)}<br>
 * 4.--{@link #determinarSexo(String)}<br>
 * 5.--{@link #determinarSexoString(String)}<br>
 * 6.--{@link #sumarAnyosFecha(Date, int)}<br>
 * 7.--{@link #cantidadCaracteresEntero(int)}<br>
 * 8.--{@link #introducirElementoListadoOrdenado(List, Comparable...)}<br>
 * 
 * @version 14/11/2022
 * @author EduardoProfe
 *
 */
public final class Auxiliares {

	private Auxiliares(){}
	/**
	 * 
	 * Método para extraer la fecha de nacimiento del carnet de identidad suministrado. Debe estar 
	 * previamente validado el carnet de identidad para evitar comportamientos extraños. 
	 * 
	 * @param ci Carnet de identidad
	 * @return  {@link Date} fecha de nacimiento.<br><br>
	 * 
	 * @throws 					IllegalArgumentException Si <b>ci</b>==null.
	 * 
	 * @author EduardoProfe
	 */
	public static Date convertirFechaNacimientoCiDate(String ci) {
		if(ci==null){
			throw new IllegalArgumentException();
		}
		int siglo = 0;
		Date fechaNacimiento = null;

		int digitoMilenio = Byte.valueOf(""+ci.charAt(6));

		if(digitoMilenio<=5)
			siglo=20;
		else if(digitoMilenio<=8)
			siglo=21;
		else
			siglo=19;

		String anyo = (siglo-1)+ci.substring(0, 2);
		String mes = ci.substring(2,4);
		String dia = ci.substring(4,6);
		Calendar c = new GregorianCalendar(Integer.valueOf(anyo),Integer.valueOf(mes)-1, Integer.valueOf(dia));
		fechaNacimiento = c.getTime();


		return fechaNacimiento;
	}
	/**
	 * 
	 * Método para determinar la edad actual de la persona en dependencia de su fecha de nacimiento.
	 * 
	 * @param fechaNacimientoCi {@link Date} fecha de nacimiento
	 * @return Un entero que representa la edad de la persona<br><br>
	 * 
	 * @throws			 IllegalArgumentException Si la <b>fechaNacimientoCi</b>==null, o <b>fechaNacimientoCi</b> es 
	 * después que la fecha actual.
	 * 
	 * @author EduardoProfe
	 */
	public static int determinarEdad(Date fechaNacimientoCi) {
		if(fechaNacimientoCi==null || fechaNacimientoCi.after(new Date()))
			throw new IllegalArgumentException();
		return determinarDiferenciaAnyos(fechaNacimientoCi, new Date());
	}
	/**
	 * 
	 * Método para determinar la diferencia en años entre dos fechas.
	 * 
	 * @param fechaInicial {@link Date} fecha inicial (menor)
	 * @param fechaFinal {@link Date} fecha final (mayor) 
	 * @return Entero que representa la diferencia en años entre ambas fechas pasadas.<br><br>
	 * 
	 * @throws 		IllegalArgumentException Si la <b>fechaInicial</b>==null, o <b>fechaFinal</b>==null, o
	 * <b>fechaInicial</b> es después que la <b>fechaFinal</b>.
	 * 
	 * @author EduardoProfe
	 */
	public static int determinarDiferenciaAnyos(Date fechaInicial, Date fechaFinal) {
		if(fechaInicial==null || fechaFinal==null || fechaInicial.after(fechaFinal))
			throw new IllegalArgumentException();

		int difAnyos=0;

		Calendar fechaInic = new GregorianCalendar();
		fechaInic.setTime(fechaInicial);
		Calendar fechaFin = new GregorianCalendar();
		fechaFin.setTime(fechaFinal);

		difAnyos = fechaFin.get(Calendar.YEAR) - fechaInic.get(Calendar.YEAR);
		int difMeses = fechaFin.get(Calendar.MONTH) - fechaInic.get(Calendar.MONTH);
		int difDias = fechaFin.get(Calendar.DAY_OF_MONTH) - fechaInic.get(Calendar.DAY_OF_MONTH);

		if(difMeses<0 || (difMeses==0 && difDias<0))
			difAnyos--;


		return difAnyos;
	}
	/**
	 * Método para determinar el sexo de la persona en dependencia de su carnet de identidad.
	 * Debe estar previamente validado el carnet de identidad para evitar comportamientos extraños. Devuelve
	 * un char referente al sexo.
	 * 
	 * @param ci {@link String} carnet de identidad
	 * @return char <b>F</b> en caso de ser femenina, y char <b>M</b> en caso de ser masculino.<br><br>
	 * 
	 * @throws 			IllegalArgumentException Si el <b>ci</b>==null, o <b>ci.length()</b>!=11.
	 * 
	 * @author EduardoProfe
	 */
	public static char determinarSexo(String ci) {
		if(ci==null || ci.length()!=11)
			throw new IllegalArgumentException();
		char sexo = 'F';
		int aux = ci.charAt(9);
		if(aux%2==0)
			sexo = 'M';
		return sexo;
	}
	/**
	 * Método para determinar el sexo de la persona en dependencia de su carnet de identidad.
	 * Debe estar previamente validado el carnet de identidad para evitar comportamientos extraños. Devuelve
	 * un {@link String} referente al sexo. 
	 * 
	 * @param ci {@link String} carnet de identidad
	 * @return {@link String} <b>Femenino</b> en caso de ser femenina, y {@link String} <b>Masculino</b> en caso de ser masculino.
	 * 
	 * @throws			 IllegalArgumentException Si el <b>ci</b>==null, o <b>ci.length()</b>!=11.
	 * 
	 * @author EduardoProfe
	 */
	public static String determinarSexoString(String ci) {
		char sexo = determinarSexo(ci);
		return sexo == 'F' ? "Femenino" : "Masculino";
	}
	/**
	 * Método para sumar (o restar) años a una fecha dada.
	 * 
	 * @param fecha {@link Date} fecha a incrementar o decrementar.
	 * @param cantAnyos Cantidad de años a variar (negativo si se quiere decrementar)
	 * @return {@link Date} incrementada o decrementada en dependencia de la <b>cantAnyos</b>.<br><br>
	 * 
	 * @throws 			IllegalArgumentException Si <b>fecha</b>==null.
	 * 
	 * @author EduardoProfe
	 */
	public static Date sumarAnyosFecha(Date fecha, int cantAnyos) {
		if(fecha==null)
			throw new IllegalArgumentException();
		Calendar fechaCalendar = new GregorianCalendar();
		fechaCalendar.setTime(fecha);
		fechaCalendar.set(Calendar.YEAR, fechaCalendar.get(Calendar.YEAR)+cantAnyos);
		return fechaCalendar.getTime();
	}
	/**
	 * Método para determinar la cantidad de caracteres que determinaría un
	 * entero en caso de ser {@link String}.
	 * 
	 * @param i Entero
	 * @return Cantidad de caracteres que determinaría <b>i</b> si fuese {@link String}.
	 * 
	 * @author EduardoProfe
	 */
	public static int cantidadCaracteresEntero(int i) {
		return String.valueOf(i).length();
	}

	/**
	 * Método para introducir de forma ordenada un elemento (o varios) en una lista. Puede ser empleado
	 * para ordenar en una lista una serie de elementos, aunque no es recomendable su uso por la complejidad
	 * que podría alcanzar el algoritmo, en caso de que sean numerosos elementos.
	 * 
	 * @param listado {@link List} con los elementos a comparar y donde se introducirá el o los elementos pasados por parámetro
	 * @param elementos Elemento o elementos a introducir de forma ordenada.
	 * 
	 * @throws 				IllegalArgumentException Si <b>elementos</b>==null, o <b>listado</b>==null<br><br>
	 * 
	 * 
	 * @author EduardoProfe
	 */
	@SafeVarargs
	public static <T extends Comparable<? super T>> void introducirElementoListadoOrdenado(List<T> listado, T...elementos) {
		if(elementos==null || listado==null)
			throw new IllegalArgumentException();

		for(T t: elementos){
			if(t==null)
				throw new IllegalArgumentException();
		}

		for(T t : elementos){
			boolean aux=true;
			
			for(int i=0;i<listado.size() && aux;i++) {
				if(t.compareTo(listado.get(i))<0) {
					listado.add(i, t);
					aux=false;
				}
			}

			if(aux)
				listado.add(t);
		}
	}
}
