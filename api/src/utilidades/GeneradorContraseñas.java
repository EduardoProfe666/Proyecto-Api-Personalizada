package utilidades;

import java.util.Random;

/**
 * Clase que permite generar contrase�as de longitud y tipo variable.
 * 
 * <h1>M�todos implementados:</h1>
 * 1.--{@link #generarContrase�a(TipoContrase�a)}<br>
 * 2.--{@link #generarContrase�a(int, TipoContrase�a)}<br>
 * 3.--{@link #generarContrase�a(int, CharSequence)}<br>
 * 
 * <h1>Ver:</h1>
 * .---{@link TipoContrase�a} 
 * 
 * @author EduardoProfe
 * @version 27/08/2023
 *
 */
public class GeneradorContrase�as {
	private GeneradorContrase�as(){}

	private static final CharSequence alfaNum = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final CharSequence num = "0123456789";
	private static final CharSequence alfa = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final CharSequence alfaMayusc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final CharSequence alfaMinusc = "abcdefghijklmnopqrstuvwxyz";

	/**
	 * Longitud m�nima de la contrase�a generada con longitud variable.
	 * @author EduardoProfe
	 */
	private static final int LONGITUD_MINIMA = 10;
	/**
	 * Longitud m�xima de la contrase�a generada con longitud variable.
	 * @author EduardoProfe
	 */
	private static final int LONGITUD_MAXIMA = 30;

	private static final Random rnd = new Random();

	private static CharSequence charSequence(TipoContrase�a tipoCaracteresContrase�a) {
		CharSequence c = null;
		switch(tipoCaracteresContrase�a) {
		case ALFANUMERICA:
			c = alfaNum;
			break;
		case NUMERICA:
			c = num;
			break;
		case ALFABETICA:
			c = alfa;
			break;
		case ALFABETICA_MINUSCULA:
			c = alfaMinusc;
			break;
		case ALFABETICA_MAYUSCULA:
			c = alfaMayusc;
			break;
		}
		return c;
	}
	
	/**
	 * Permite generar una contrase�a de longitud variable, teniendo como extremos {@link #LONGITUD_MINIMA} y 
	 * {@link #LONGITUD_MAXIMA}. Dicha contrase�a se generar� con caracteres del tipo especificado.
	 * 
	 * @param tipoCaracteresContrase�a {@link TipoContrase�a}
	 * @return String contrase�a generada de forma aleatoria
	 * @author EduardoProfe
	 */
	public static String generarContrase�a(TipoContrase�a tipoCaracteresContrase�a) {
		return generarContrase�a(rnd.nextInt(LONGITUD_MAXIMA+1-LONGITUD_MINIMA)+LONGITUD_MINIMA,
				tipoCaracteresContrase�a).toString();
	}

	/**
	 * Permite generar una contrase�a de longitud proporcionada y con caracteres del tipo especificado.
	 * 
	 * @param longitud Longitud de la contrase�a a generar
	 * @param tipoCaracteresContrase�a {@link TipoContrase�a}
	 * @return String contrase�a generada de forma aleatoria
	 * @author EduardoProfe
	 */
	public static String generarContrase�a(int longitud,TipoContrase�a tipoCaracteresContrase�a) {
		return generarContrase�a(longitud, charSequence(tipoCaracteresContrase�a)).toString();
	}
	
	/**
	 * Permite generar una contrase�a de longitud proporcionada y con caracteres del {@link CharSequence} pasado.
	 * 
	 * @param longitud Longitud de la contrase�a a generar
	 * @param caracteres {@link CharSequence} que contiene los caracteres con los que se generar� la contrase�a (Puede ser un String).
	 * @return String contrase�a generada de forma aleatoria
	 * @author EduardoProfe
	 */
	public static String generarContrase�a(int longitud, CharSequence caracteres) {
		StringBuilder s = new StringBuilder(longitud);

		int tamCs = caracteres.length();

		while(longitud-->0) {
			s.append(caracteres.charAt(rnd.nextInt(tamCs)));
		}

		return s.toString();
	}
	
	/**
	 * Enum que modela los tipos de contrase�as existentes.
	 * Los tipos actualmente soportados son:<br>
	 * 1.--{@link #ALFANUMERICA}<br>
	 * 2.--{@link #NUMERICA}<br>
	 * 3.--{@link #ALFABETICA}<br>
	 * 4.--{@link #ALFABETICA_MINUSCULA}<br>
	 * 5.--{@link #ALFABETICA_MAYUSCULA}<br>
	 * 
	 * @author EduardoProfe
	 *
	 */
	public static enum TipoContrase�a{
		/**
		 * Permite crear contrase�as de tipo alfanum�rico, teniendo como CharSequence base a:<br>
		 * <b>0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz</b>
		 * 
		 * @author EduardoProfe
		 */
		ALFANUMERICA,
		
		/**
		 * Permite crear contrase�as de tipo num�rico, teniendo como CharSequence base a:<br>
		 * <b>0123456789</b>
		 * @author EduardoProfe
		 */
		NUMERICA,
		
		/**
		 * Permite crear contrase�as de tipo alfab�tico, teniendo como CharSequence base a:<br>
		 * <b>ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz</b>
		 * @author EduardoProfe
		 */
		ALFABETICA,
		
		/**
		 * Permite crear contrase�as de tipo alfab�tico min�sculo, teniendo como CharSequence base a:<br>
		 * <b>abcdefghijklmnopqrstuvwxyz</b>
		 * @author EduardoProfe
		 */
		ALFABETICA_MINUSCULA,
		
		/**
		 * Permite crear contrase�as de tipo alfab�tico may�sculo, teniendo como CharSequence base a:<br>
		 * <b>ABCDEFGHIJKLMNOPQRSTUVWXYZ</b>
		 * @author EduardoProfe
		 */
		ALFABETICA_MAYUSCULA
	}
}
