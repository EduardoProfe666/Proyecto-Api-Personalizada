package utilidades;

import java.util.Random;

/**
 * Clase que permite generar contraseñas de longitud y tipo variable.
 * 
 * <h1>Métodos implementados:</h1>
 * 1.--{@link #generarContraseña(TipoContraseña)}<br>
 * 2.--{@link #generarContraseña(int, TipoContraseña)}<br>
 * 3.--{@link #generarContraseña(int, CharSequence)}<br>
 * 
 * <h1>Ver:</h1>
 * .---{@link TipoContraseña} 
 * 
 * @author EduardoProfe
 * @version 27/08/2023
 *
 */
public class GeneradorContraseñas {
	private GeneradorContraseñas(){}

	private static final CharSequence alfaNum = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final CharSequence num = "0123456789";
	private static final CharSequence alfa = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final CharSequence alfaMayusc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final CharSequence alfaMinusc = "abcdefghijklmnopqrstuvwxyz";

	/**
	 * Longitud mínima de la contraseña generada con longitud variable.
	 * @author EduardoProfe
	 */
	private static final int LONGITUD_MINIMA = 10;
	/**
	 * Longitud máxima de la contraseña generada con longitud variable.
	 * @author EduardoProfe
	 */
	private static final int LONGITUD_MAXIMA = 30;

	private static final Random rnd = new Random();

	private static CharSequence charSequence(TipoContraseña tipoCaracteresContraseña) {
		CharSequence c = null;
		switch(tipoCaracteresContraseña) {
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
	 * Permite generar una contraseña de longitud variable, teniendo como extremos {@link #LONGITUD_MINIMA} y 
	 * {@link #LONGITUD_MAXIMA}. Dicha contraseña se generará con caracteres del tipo especificado.
	 * 
	 * @param tipoCaracteresContraseña {@link TipoContraseña}
	 * @return String contraseña generada de forma aleatoria
	 * @author EduardoProfe
	 */
	public static String generarContraseña(TipoContraseña tipoCaracteresContraseña) {
		return generarContraseña(rnd.nextInt(LONGITUD_MAXIMA+1-LONGITUD_MINIMA)+LONGITUD_MINIMA,
				tipoCaracteresContraseña).toString();
	}

	/**
	 * Permite generar una contraseña de longitud proporcionada y con caracteres del tipo especificado.
	 * 
	 * @param longitud Longitud de la contraseña a generar
	 * @param tipoCaracteresContraseña {@link TipoContraseña}
	 * @return String contraseña generada de forma aleatoria
	 * @author EduardoProfe
	 */
	public static String generarContraseña(int longitud,TipoContraseña tipoCaracteresContraseña) {
		return generarContraseña(longitud, charSequence(tipoCaracteresContraseña)).toString();
	}
	
	/**
	 * Permite generar una contraseña de longitud proporcionada y con caracteres del {@link CharSequence} pasado.
	 * 
	 * @param longitud Longitud de la contraseña a generar
	 * @param caracteres {@link CharSequence} que contiene los caracteres con los que se generará la contraseña (Puede ser un String).
	 * @return String contraseña generada de forma aleatoria
	 * @author EduardoProfe
	 */
	public static String generarContraseña(int longitud, CharSequence caracteres) {
		StringBuilder s = new StringBuilder(longitud);

		int tamCs = caracteres.length();

		while(longitud-->0) {
			s.append(caracteres.charAt(rnd.nextInt(tamCs)));
		}

		return s.toString();
	}
	
	/**
	 * Enum que modela los tipos de contraseñas existentes.
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
	public static enum TipoContraseña{
		/**
		 * Permite crear contraseñas de tipo alfanumérico, teniendo como CharSequence base a:<br>
		 * <b>0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz</b>
		 * 
		 * @author EduardoProfe
		 */
		ALFANUMERICA,
		
		/**
		 * Permite crear contraseñas de tipo numérico, teniendo como CharSequence base a:<br>
		 * <b>0123456789</b>
		 * @author EduardoProfe
		 */
		NUMERICA,
		
		/**
		 * Permite crear contraseñas de tipo alfabético, teniendo como CharSequence base a:<br>
		 * <b>ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz</b>
		 * @author EduardoProfe
		 */
		ALFABETICA,
		
		/**
		 * Permite crear contraseñas de tipo alfabético minúsculo, teniendo como CharSequence base a:<br>
		 * <b>abcdefghijklmnopqrstuvwxyz</b>
		 * @author EduardoProfe
		 */
		ALFABETICA_MINUSCULA,
		
		/**
		 * Permite crear contraseñas de tipo alfabético mayúsculo, teniendo como CharSequence base a:<br>
		 * <b>ABCDEFGHIJKLMNOPQRSTUVWXYZ</b>
		 * @author EduardoProfe
		 */
		ALFABETICA_MAYUSCULA
	}
}
