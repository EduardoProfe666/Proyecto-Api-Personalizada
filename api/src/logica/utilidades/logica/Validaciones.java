package logica.utilidades.logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * 
 * 
 * 
 * <h1>Validaciones de {@link String} y double:</h1>
 * 1.--{@link #validarNumeroRango(double, double, double)}<br>
 * 2.--{@link #validarTamString(String, int, int)}<br>
 * 3.--{@link #validarStringTodoLetra(String)}<br>
 * 4.--{@link #validarStringTodoDigito(String)}<br>
 * 5.--{@link #validarStringTodoDigitoLetraSinEspacio(String)}<br>
 * 6.--{@link #validarStringNoTodoEspacio(String)}<br>
 * 7.--{@link #validarStringNoVacio(String)}<br>
 * 8.--{@link #validarStringNoEspacio(String)}<br>
 * <h1>Validaciones de {@link List}:</h1>
 * 9.--{@link #validarNoRepeticionLista(List)}<br>
 * 10.-{@link #validarNoRepeticionLista(List, Comparator)}<br>
 * 11.-{@link #validarNoRepeticionElementoLista(List, Comparable)}<br>
 * 12.-{@link #validarNoRepeticionElementoLista(List, Object, Comparator)}<br>
 * 13.-{@link #validarNoRepeticionListas(List...)}<br>
 * <h1>Validaciones de Carnet de Identidad y {@link Date}:</h1>
 * 14.-{@link #validarFechaNacimientoCi(String, Date, Date)}<br>
 * 15.-{@link #validarCI(String, Date, Date)}<br>
 * 16.-{@link #validarRangoFecha(Date, Date, Date)}<br>
 * 17.-{@link #validarCalendarsMismoDia(Calendar, Calendar)}<br>
 * 18.-{@link #validarDatesMismoDia(Date, Date)}<br>
 * 
 * 
 * @version 25/11/2022
 * @author EduardoProfe
 *
 */

public final class Validaciones {
	private Validaciones() {}

	/**
	 *  M�todo que permitir� validar si un valor se encuentra en un rango
	 *  dado.
	 * 
	 * @param valor Valor double a comparar
	 * @param minV Rango menor
	 * @param maxV Rango mayor
	 * @return  <b>true</b>, si el valor se encuentra en el rango; <b>false</b>,
	 * si no se encuentra en el rango, o <b>minV mayor que maxV</b>  
	 * 
	 * @author EduardoProfe
	 */
	public static boolean validarNumeroRango(double valor, double minV, double maxV) {
		boolean esValido = minV<=maxV;
		
		if(esValido)
			esValido = valor>=minV && valor<=maxV;

			return esValido;
	}
	/**
	 * 
	 * M�todo que permitir� validar si un {@link String} tiene un tama�o en un rango dado.
	 * 
	 * @param s {@link String} a validar
	 * @param min Rango menor
	 * @param max Rango mayor
	 * @return <b>true</b>, si el {@link String} tiene un tama�o en el rango dado; <b>false</b>
	 * si no se encuentra en el rango, o <b>min mayor que max</b>, o <b>s==null</b>
	 * 
	 * @author EduardoProfe
	 */
	public static boolean validarTamString(String s, int min, int max) {
		boolean esValido = s!=null && min<=max;

		if(esValido)
			esValido = s.length()>=min && s.length()<=max;

			return esValido;
	}
	/**
	 * M�todo que permitir� validar si un {@link String} est� compuesto solo por letras, incluyendo
	 * los espacios.
	 * 
	 * @param s {@link String} a validar
	 * @return <b>true</b>, si el {@link String} est� compuesto solo por letras y espacios; <b>false</b>
	 * si no lo est�, o <b>s</b>==<b>null</b>
	 * 
	 * @author EduardoProfe
	 */
	public static boolean validarStringTodoLetra(String s) {
		boolean esValido = s!=null;

		for(int i=0;i<s.length() && esValido;i++)
			esValido = Character.isLetter(s.charAt(i)) || Character.isWhitespace(s.charAt(i));

		return esValido;
	}
	/**
	 * M�todo que permitir� validar si un {@link String} est� compuesto solo por d�gitos.
	 * 
	 * @param s {@link String} a validar
	 * @return <b>true</b>, si el {@link String} est� compuesto solo por d�gitos; <b>false</b>
	 * si no lo est�, o <b>s</b>==<b>null</b>
	 * 
	 * @author EduardoProfe
	 */
	public static boolean validarStringTodoDigito(String s) {
		boolean esValido = s!=null;

		for(int i=0;i<s.length() && esValido;i++)
			esValido = Character.isDigit(s.charAt(i));

		return esValido;
	}
	/**
	 * M�todo que permitir� validar si un {@link String} est� compuesta solo por d�gitos y letras, sin espacios.
	 * 
	 * @param s {@link String} a validar
	 * @return <b>true</b>, si el {@link String} est� compuesto solo por d�gitos y letras, sin espacios; <b>false</b>
	 * si no lo est�, o <b>s</b>==<b>null</b>
	 * 
	 * @author EduardoProfe
	 */
	public static boolean validarStringTodoDigitoLetraSinEspacio(String s) {
		boolean esValido = s!=null;

		for(int i=0;i<s.length() && esValido;i++)
			esValido = Character.isDigit(s.charAt(i)) || Character.isUpperCase(s.charAt(i)) || Character.isLowerCase(s.charAt(i));

		return esValido;
	}
	/**
	 * M�todo que permitir� validar si un {@link String} est� compuesto no solo por espacios.
	 * 
	 * @param s {@link String} a validar
	 * @return <b>true</b>, si el {@link String} est� compuesto no solo por espacios; <b>false</b>
	 * si lo est�, o <b>s</b>==<b>null</b>
	 * 
	 * @author EduardoProfe
	 */
	public static boolean validarStringNoTodoEspacio(String s) {
		boolean esValido = false; 
		
		if(s!=null){
			for(int i=0;i<s.length() && !esValido;i++)
				if(!Character.isWhitespace(s.charAt(i)))
					esValido = true;
		}
		return esValido;
	}
	/**
	 * M�todo que permitir� validar si un {@link String} no es <b>null</b> ni est� vac�o.
	 * 
	 * @param s {@link String} a validar
	 * @return <b>true</b>, si el {@link String} no est� vac�o ni es <b>null</b>; <b>false</b>
	 * si pasa lo contrario
	 * 
	 *  @author EduardoProfe
	 */
	public static boolean validarStringNoVacio(String s) {
		return (s!=null && !s.isEmpty());
	}
	/**
	 * M�todo que permitir� validar si un {@link String} no se componga solamente por espacios.
	 * 
	 * @param s {@link String} a validar
	 * @return <b>true</b>, si el {@link String} no se compone solamente por espacios; <b>false</b>
	 * si pasa lo contrario
	 * 
	 *  @author EduardoProfe
	 */
	public static boolean validarStringNoEspacio(String s) {
		boolean esValido = (s!=null);

		for(int i=0;i<s.length() && esValido;i++)
			esValido = !Character.isWhitespace(s.charAt(i));

		return esValido;
	}
	/**
	 * 
	 * M�todo que permitir� validar si un {@link String}, que corresponde a un carnet de identidad, contenga una 
	 * fecha de nacimiento v�lida, dado un rango de fechas.
	 * 
	 * @param ci {@link String} correspondiente al carnet de identidad a validar
	 * @param fechaMin {@link Date} correspondiente a la fecha m�nima de nacimiento que puede presentar el carnet de identidad. 
	 * Si es <b>null</b> entonces no se comprobar� el rango inferior.
	 * @param fechaMax {@link Date} correspondiente a la fecha m�xima de nacimiento que puede presentar el carnet de identidad.
	 * Si es <b>null</b> entonces no se comprobar� el rango superior.
	 * @return <b>true</b>, si el {@link String} ci es v�lido en el rango de fechas; <b>false</b>
	 * si pasa lo contrario, o <b>ci</b>==<b>null</b>.
	 * 
	 *  @author EduardoProfe
	 */
	public static boolean validarFechaNacimientoCi(String ci, Date fechaMin, Date fechaMax) {
		boolean esValido = ci!=null;

		if(esValido) {
			int siglo = 0;
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
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			formato.setLenient(false);
			try {
				formato.parse(dia+"/"+mes+"/"+anyo);
			}catch(Exception e) {
				esValido=false;
			}
		}


		if(esValido){
			Date fecha = Auxiliares.convertirFechaNacimientoCiDate(ci);
			if(fechaMin!=null)
				esValido = fecha.compareTo(fechaMin)>=0;
			if(esValido && fechaMax!=null)
				esValido = fecha.compareTo(fechaMax)<=0;
		}

		return esValido;
	}
	/**
	 * 
	 * M�todo que permitir� validar si un {@link String} corresponde a un verdadero carnet de identidad.
	 * 
	 * @param ci {@link String} correspondiente al carnet de identidad a validar
	 * @param fechaMin {@link Date} correspondiente a la fecha m�nima de nacimiento que puede presentar el carnet de identidad
	 * @param fechaMax {@link Date} correspondiente a la fecha m�xima de nacimiento que puede presentar el carnet de identidad
	 * @return <b>true</b>, si el {@link String} ci es v�lido en el rango de fechas; <b>false</b>
	 * si pasa lo contrario, o <b>ci</b>==<b>null</b>.
	 * 
	 *  @author EduardoProfe
	 */
	public static boolean validarCI(String ci, Date fechaMin, Date fechaMax) {
		return validarStringNoVacio(ci) && validarTamString(ci,11,11) && validarStringTodoDigito(ci) && validarFechaNacimientoCi(ci,fechaMin,fechaMax);
	}
	/**
	 * 
	 * M�todo que permitir� validar si un {@link Date} se encuentra en un rango determinado.
	 * 
	 * @param fecha {@link Date} a validar
	 * @param fechaMin {@link Date} m�nima
	 * @param fechaMax {@link Date} m�xima
	 * @return <b>true</b>, si el {@link Date} fecha es v�lido en el rango de fechas; <b>false</b>
	 * si pasa lo contrario, o <b>fecha</b>==<b>null</b>, o <b>fechaMin</b>==null, o <b>fechaMax</b>==null
	 * 
	 * @author EduardoProfe
	 */
	public static boolean validarRangoFecha(Date fecha, Date fechaMin, Date fechaMax) {
		boolean esValida = (fecha!=null && fechaMin!=null && fechaMax!=null);

		if(esValida)
			esValida = (fecha.after(Auxiliares.sumarAnyosFecha(fechaMin, -1)) && fecha.before(Auxiliares.sumarAnyosFecha(fechaMax, 1)));

		return esValida;
	}
	/**
	 * M�todo que permitir� validar la no repetici�n de los elementos de la lista. En esta implementaci�n
	 * los elementos de la lista pasada deben implementar la interfaz {@link Comparable}, pues el algoritmo
	 * emplea el orden natural de los mismos.
	 * 
	 * @param lista {@link List} de elementos que implementan la interfaz {@link Comparable} a validar
	 * @return <b>true</b>, si la {@link List} lista no presenta elementos repetidos; <b>false</b>
	 * si pasa lo contrario, o <b>lista</b>==<b>null</b><br>
	 * 
	 * <h1>Ver:</h1>{@link #validarNoRepeticionLista(List, Comparator)}<br><br>
	 * @author EduardoProfe
	 */
	public static <T extends Comparable<? super T>> boolean validarNoRepeticionLista(List<T> lista) {
		boolean esValida = lista!=null;

		Collections.sort(lista);

		for(int i=0;i<lista.size()-1 && esValida;i++)
			esValida = !(lista.get(i).equals(lista.get(i+1)));

		return esValida;
	}
	/**
	 * M�todo que permitir� validar la no repetici�n de los elementos de la lista. En esta implementaci�n
	 * se debe pasar un {@link Comparator} que indique el orden de los elementos de la lista, pues 
	 * es empleado en el algoritmo.
	 * 
	 * @param lista {@link List} de elementos a validar
	 * @param c {@link Comparator} de los elementos de la lista
	 * @return <b>true</b>, si la {@link List} lista no presenta elementos repetidos; <b>false</b>
	 * si pasa lo contrario, o <b>lista</b>==<b>null</b>, o <b>c</b>==null
	 * 
	 * @author EduardoProfe
	 * @see #validarNoRepeticionLista(List)
	 */
	public static <T> boolean validarNoRepeticionLista(List<T> lista, Comparator<? super T> c){
		boolean esValida = lista!=null && c!=null;
		Collections.sort(lista, c);

		for(int i=0;i<lista.size()-1 && esValida;i++)
			esValida = !(lista.get(i).equals(lista.get(i+1)));

		return esValida;
	}
	/**
	 * M�todo que permitir� validar la no repetici�n de un elemento en una lista. En esta implementaci�n
	 * los elementos de la lista pasada deben implementar la interfaz {@link Comparable}, pues es el algoritmo
	 * emplea el orden natural de los mismos.
	 * 
	 * @param lista {@link List} de elementos
	 * @param elemento Elemento a validar
	 * @return <b>true</b>, si la {@link List} lista no contiene el elemento; <b>false</b>
	 * si pasa lo contrario, o <b>lista</b>==<b>null</b>, o <b>elemento</b>==null
	 * 
	 * @author EduardoProfe
	 * @see #validarNoRepeticionElementoLista(List, Object, Comparator)
	 */
	public static <T extends Comparable<? super T>> boolean validarNoRepeticionElementoLista(List<T> lista, T elemento) {
		boolean esValida = lista!=null && elemento!=null;

		if(esValida) {
			Collections.sort(lista);
			esValida = Collections.binarySearch(lista,elemento)<0;
		}

		return esValida;
	}
	/**
	 * 
	 * M�todo que permitir� validar la no repetici�n de un elemento en una lista. En esta implementaci�n
	 * se debe pasar un {@link Comparator} que indique el orden de los elementos de la lista, pues 
	 * es empleado en el algoritmo. 
	 * 
	 * @param lista {@link List} de elementos
	 * @param elemento Elemento a validar
	 * @param c {@link Comparator} de los elementos de la lista
	 * @return <b>true</b>, si la {@link List} lista no contiene el elemento; <b>false</b>
	 * si pasa lo contrario, o <b>lista</b>==<b>null</b>, o <b>elemento</b>==null, o <b>c</b>==null
	 * 
	 * @author EduardoProfe
	 * @see #validarNoRepeticionElementoLista(List, Comparable)
	 */
	public static <T> boolean validarNoRepeticionElementoLista(List<T> lista, T elemento, Comparator<? super T> c) {
		boolean esValida = lista!=null && elemento!=null && c!=null;

		if(esValida) {
			Collections.sort(lista,c);
			esValida = Collections.binarySearch(lista,elemento,c)<0;
		}

		return esValida;
	}
	/**
	 * M�todo para validar que las listas pasadas no contengan elementos en com�n.
	 * 
	 * @param listas Conjunto de listas
	 * @return <b>true</b>, si las {@link List} listas no contienen elementos en com�n; <b>false</b>
	 * si pasa lo contrario, o <b>listas</b>==<b>null</b>
	 * 
	 * @author EduardoProfe
	 */
	@SafeVarargs
	public static <T> boolean validarNoRepeticionListas(List<T>... listas) {
		boolean esValida = (listas!=null);

		for(int i=0;i<listas.length && esValida;i++)
			esValida = listas[i]!=null;

		if(esValida && listas.length>1){
			for(int i=0;i<listas.length && esValida;i++){
				for(int j=i+1;j<listas.length && esValida;j++){
					esValida = Collections.disjoint(listas[i], listas[j]);
				}
			}
		}
		return esValida;
	}
	/**
	 * M�todo para validar que dos <b>Calendar</b> representen el mismo d�a.
	 *  
	 * @param c1 <b>Calendar</b> a comprobar.
	 * @param c2 <b>Calendar</b> a comprobar.
	 * @return <b>true</b>, si los <b>Calendar</b> representan el mismo d�a, <b>false</b>
	 * si pasa lo contrario, o <b>c1</b>==<b>null</b> o <b>c2</b>==<b>null</b>
	 * 
	 * @author EduardorProfe
	 */
	public static boolean validarCalendarsMismoDia(Calendar c1, Calendar c2) {
		boolean esValido = c1!=null && c2!=null;
		
		if(esValido)
			esValido = c1.get(Calendar.YEAR)==c2.get(Calendar.YEAR);
		if(esValido)
			esValido = c1.get(Calendar.MONTH)==c2.get(Calendar.MONTH);
		if(esValido)
			esValido = c1.get(Calendar.DAY_OF_MONTH)==c2.get(Calendar.DAY_OF_MONTH);
		
		return esValido;
	}
	/**
	 * M�todo para validar que dos <b>Date</b> representen el mismo d�a.
	 * 
	 * @param d1 <b>Date</b> a comprobar
	 * @param d2 <b>Date</b> a comprobar
	 * @return <b>true</b>, si los <b>Date</b> representan el mismo d�a, <b>false</b>
	 * si pasa lo contrario, o <b>d1</b>==<b>null</b> o <b>d2</b>==<b>null</b>
	 * 
	 * @author EduardoProfe
	 */
	public static boolean validarDatesMismoDia(Date d1, Date d2) {
		boolean esValido = d1!=null && d2!=null;
		
		if(esValido){
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.setTime(d1);
			c2.setTime(d2);
			esValido = validarCalendarsMismoDia(c1,c2);
		}
		
		return esValido;
		
	}
}
