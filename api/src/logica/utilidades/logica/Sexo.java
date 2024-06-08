package logica.utilidades.logica;

/**
 * Enum que permite modelar el sexo de los ci o los nombres a generar. Los sexos actualmente soportados son:<br>
 * 1.--{@link #FEMENINO}<br>
 * 2.--{@link #MASCULINO}<br>
 * 3.--{@link #ALEATORIO}<br>
 * @author EduardoProfe
 *
 */
public enum Sexo {
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
