package componentesVisuales;

import java.text.ParseException;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.MaskFormatter;

import utilidades.Auxiliares;
import utilidades.Validaciones;
/**
 * {@link JFormattedTextField} modificado para poder validar 
 * la introducción del carnet de identidad. Para su uso 
 * simplemente agrege un {@link CaretListener} y compruebe si {@link #ciValido}==true.
 * Debe pasar por parámetros una fecha mínima y máxima admisible para el carnet de identidad. Si se pasan valores <b>null</b>,
 * no se comprobará que la fecha del carnet de identidad sea mayor o menor que dicha fecha, en dependencia del caso. 
 * <h1>Sugerencia:</h1> Emplee como {@link #fechaMax} la actual, y como {@link #fechaMin} la actual <b>-</b> la 
 * edad máxima de una persona, valor que usted definirá en dependencia de la situación en que se encuentre.
 * <h1>Aclaración:</h1> La fecha creada a la hora de validar la fecha de nacimiento del carnet de identidad, se crea 
 * con 0:00:00:00, por tanto tome esto en cuenta a la hora de declarar los rangos de fecha.
 * <h1>Actualización:</h1> Una vez validado el carnet de identidad, el componente determina ciertas informaciones, 
 * acerca de la persona perteneciente al carnet de identidad, como son su fecha de nacimiento, su edad actual, su
 * caracter de sexo, y el {@link String} de sexo. Para acceder a estos parámetros simplemente use los gets correspondientes.
 * 
 * <h1>Ver:</h1>{@link #fechaMin}<br>{@link #fechaMax}<br>{@link #ciValido}<br>{@link #fechaNacimientoCi}<br>{@link #edad}
 * <br>{@link #sexoChar}<br>{@link #sexoString}<br><br>
 * @version 22/11/2022
 * @author EduardoProfe 
 *
 */
public class CampoCIValidado extends JFormattedTextField{
	private static final long serialVersionUID = 1L;
	/**
	 * {@link Date} que determinará la fecha mínima de nacimiento a la que puede
	 * referirse el carnet de identidad introducido. La fecha creada a la hora de validar la fecha de nacimiento del carnet de identidad, se crea 
	 * con 0:00:00:00, por tanto tome esto en cuenta a la hora de declarar los rangos de fecha. Si es <b>null</b> no se comprobará
	 * el rango inferior.
	 * 
	 * @author EduardoProfe
	 */
	private Date fechaMin;
	/**
	 * {@link Date} que determinará la fecha máxima de nacimiento a la que puede
	 * referirse el carnet de identidad introducido. La fecha creada a la hora de validar la fecha de nacimiento del carnet de identidad, se crea 
	 * con 0:00:00:00, por tanto tome esto en cuenta a la hora de declarar los rangos de fecha. Si es <b>null</b> no se comprobará
	 * el rango superior.
	 * 
	 * @author EduardoProfe
	 */
	private Date fechaMax;
	/**
	 * 
	 * Booleano que determinará si el carnet de identidad introducido es válido. Ya se encuentra
	 * implementado el sistema de validación, solamente es trabajar con dicho valor, agregando
	 * un {@link CaretListener} a la implementación y determinando el comportamiento a seguir
	 * en caso de que se encuentre validado o no.
	 * 
	 * @author EduardoProfe
	 */
	private boolean ciValido;
	/**
	 * {@link Date} que determinará la fecha de nacimiento que corresponde a la persona del carnet de identidad
	 * introducido. Si el ci no es válido, pues se mantendrá con valor <b>null</b>. Considerar que en dependencia del
	 * rango de fechas introducido (o no), este valor puede arrojar resultados extraños.
	 * @author EduardoProfe
	 */
	private Date fechaNacimientoCi;
	/**
	 * {@link Integer} que determinará la edad actual de la persona en dependencia del carnet de identidad
	 * introducido. Si el ci no es válido, pues se mantendrá con valor <b>null</b>. Considerar que en dependencia del
	 * rango de fechas introducido (o no), este valor puede arrojar resultados extraños.
	 * 
	 * @author EduardoProfe
	 */
	private Integer edad;
	/**
	 * {@link Character} que determinará el caracter de sexo (<b>F</b> o <b>M</b>) perteneciente a la persona que corresponde el carnet
	 * de identidad introducido. Si el ci no es válido, pues se mantendrá con valor <b>null</b>. Considerar que en dependencia del
	 * rango de fechas introducido (o no), este valor puede arrojar resultados extraños.
	 * @author EduardoProfe
	 */
	private Character sexoChar;
	/**
	 * {@link String} que determinará el nombre del sexo (<b>Femenino</b> o <b>Masculino</b>) perteneciente a la persona que corresponde el carnet de identidad introducido.
	 * Si el ci no es válido, pues se mantendrá con valor <b>null</b>. Considerar que en dependencia del
	 * rango de fechas introducido (o no), este valor puede arrojar resultados extraños. 
	 * @author EduardoProfe
	 */
	private String sexoString;
	
	public CampoCIValidado(final Date fechaMin, final Date fechaMax) throws ParseException{
		super(new MaskFormatter("###########"));
		ciValido=false;
		determinarDatos();
		setFechaMin(fechaMin);
		setFechaMax(fechaMax);
		setFocusLostBehavior(JFormattedTextField.PERSIST);
		setColumns(11);
		addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				ciValido=Validaciones.validarCI(getText().trim(), fechaMin, fechaMax);
				determinarDatos();
			}
		});
	}
	public CampoCIValidado() throws ParseException{
		this(null, null);
	}
	/**
	 * 
	 * @return fechaMin Fecha Mínima
	 * @see #fechaMin
	 */
	public Date getFechaMin() {
		return fechaMin;
	}
	/**
	 * @param fechaMin Fecha mínima
	 * @see #fechaMin
	 */
	public void setFechaMin(Date fechaMin) {
		if(this.fechaMax!=null && fechaMin!=null && fechaMin.after(this.fechaMax))
			throw new IllegalArgumentException();
			
		this.fechaMin = fechaMin==null ? fechaMin : (Date)fechaMin.clone();
	}
	/**
	 * @return fechaMax Fecha máxima
	 * @see #fechaMax
	 */
	public Date getFechaMax() {
		return fechaMax;
	}
	/**
	 * @param fechaMax Fecha Máxima
	 * @see #fechaMax
	 */
	public void setFechaMax(Date fechaMax) {
		if(this.fechaMin!=null && fechaMax!=null && this.fechaMin.after(fechaMax))
			throw new IllegalArgumentException();
		
		this.fechaMax = fechaMax==null ? fechaMax : (Date)fechaMax.clone();
	}
	/**
	 * @return ciValido Carnet de identidad válido
	 * @see #ciValido
	 */
	public boolean getCiValido(){
		return this.ciValido;
	}
	/**
	 * @return fechaNacimientoCi Fecha de nacimiento del carnet de identidad
	 * @see #fechaNacimientoCi
	 */
	public Date getFechaNacimientoCi() {
		return fechaNacimientoCi;
	}
	/**
	 * @return edad Edad
	 * @see #edad
	 */
	public Integer getEdad() {
		return edad;
	}
	/**
	 * 
	 * @return sexoChar Caracter de sexo
	 * @see #sexoChar
	 */
	public Character getSexoChar() {
		return sexoChar;
	}
	/**
	 * 
	 * @return sexoString String de sexo
	 * @see #sexoString
	 */
	public String getSexoString() {
		return sexoString;
	}
	private void determinarDatos(){
		String ci = this.getText();
			this.fechaNacimientoCi = this.ciValido ? Auxiliares.convertirFechaNacimientoCiDate(ci) : null ;
			this.edad = this.ciValido ? Auxiliares.determinarEdad(fechaNacimientoCi) : null ;
			this.sexoChar = this.ciValido ? Auxiliares.determinarSexo(ci) : null ;
			this.sexoString = this.ciValido ? Auxiliares.determinarSexoString(ci) : null ;
	}
}
