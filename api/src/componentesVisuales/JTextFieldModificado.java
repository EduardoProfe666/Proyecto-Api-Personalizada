package componentesVisuales;


import javax.swing.JTextField;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * {@link JTextField} modificado de tal manera que se pueda limitar la cantidad
 * máxima de caracteres introducidos, además de la posibilidad de impedir la introducción
 * de letras, dígitos, espacios, o una validación personalizada.
 * 
 * <h1>Ver:</h1>{@link #limite}<br>{@link #tipoValidacion}<br>{@link #beepActivado}<br>{@link #validacionPersonalizadaString}<br><br>
 * @version 02/12/2022
 * @author EduardoProfe
 *
 */
public class JTextFieldModificado extends JTextField{
	/**
	 * <b>-1</b>
	 */
	public static final int SIN_VALIDAR = -1;
	/**
	 * <b>0</b>
	 */
	public static final int SOLO_LETRAS = 0;
	/**
	 * <b>1</b>
	 */
	public static final int SOLO_LETRAS_ESPACIOS = 1;
	/**
	 * <b>2</b>
	 */
	public static final int SOLO_DIGITOS = 2;
	/**
	 * <b>3</b>
	 */
	public static final int SOLO_DIGITOS_ESPACIOS = 3;
	/**
	 * <b>4</b>
	 */
	public static final int VALIDACION_PERSONALIZADA = 4;
	/**
	 * <b>5</b>
	 */
	public static final int VALIDACION_PERSONALIZADA_INVERSA = 5;
	/**
	 * <b>-1</b>
	 */
	public static final int SIN_LIMITES = -1;
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo que determinará la cantidad máxima de caracteres posibles a introducir. Si no 
	 * se requiere esta funcionalidad, setear el atributo en <b>-1</b> o {@link #SIN_LIMITES}. 
	 * Tiene que tener un valor mayor o igual que <b>-1</b>.
	 * 
	 * @author EduardoProfe
	 */
	private int limite;
	/**
	 * Atributo que determinará el tipo de validación a realizar.<br>
	 * <h1>Tipos de validación:</h1>
	 * .-1 {@link #SIN_VALIDAR}<br>
	 * . 0 {@link #SOLO_LETRAS}<br>
	 * . 1 {@link #SOLO_LETRAS_ESPACIOS}<br>
	 * . 2 {@link #SOLO_DIGITOS}<br>
	 * . 3 {@link #SOLO_DIGITOS_ESPACIOS}<br>
	 * . 4 {@link #VALIDACION_PERSONALIZADA}<br>
	 * . 5 {@link #VALIDACION_PERSONALIZADA_INVERSA}<br>
	 * 
	 * 
	 * @author EduardoProfe
	 */
	private int tipoValidacion;
	/**
	 * Booleano que determina si se emitirá un sonido (beep) una vez que haya alcanzado el 
	 * máximo estado posible.
	 * 
	 * @author EduardoProfe
	 */
	private boolean beepActivado;
	/**
	 * Cadena de caracteres que será empleada para la validación personalizada. De base no contiene
	 * caracteres (se encuentra vacía). En dependencia del tipo de validación empleada se validará 
	 * la entrada de modo que solamente se admitan los caracteres de la presente cadena ({@link #VALIDACION_PERSONALIZADA}),
	 * o se admiten todos los caracteres exceptuando los caracteres de la presente cadena ({@link #VALIDACION_PERSONALIZADA_INVERSA}).
	 * 
	 * @author EduardoProfe
	 */
	private String validacionPersonalizadaString;

	public JTextFieldModificado() {
		setColumns(10);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(getText().length()==limite){
					if(beepActivado)
						Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
				else{
					char c = e.getKeyChar();
					switch(tipoValidacion) {
					case SOLO_LETRAS:
						if(!Character.isLetter(c)){
							if(beepActivado)
								Toolkit.getDefaultToolkit().beep();
							e.consume();
						}
						break;
					case SOLO_DIGITOS:
						if(!Character.isDigit(c)){
							if(beepActivado)
								Toolkit.getDefaultToolkit().beep();
							e.consume();
						}
						break;
					case SOLO_LETRAS_ESPACIOS:
						if(!Character.isLetter(c) && !Character.isWhitespace(c)){
							if(beepActivado)
								Toolkit.getDefaultToolkit().beep();
							e.consume();
						}
						break;
					case SOLO_DIGITOS_ESPACIOS:
						if(!Character.isDigit(c) && !Character.isWhitespace(c)){
							if(beepActivado)
								Toolkit.getDefaultToolkit().beep();
							e.consume();
						}
						break;
					case VALIDACION_PERSONALIZADA:
						if(!validacionPersonalizadaString.contains(c+"")){
							if(beepActivado)
								Toolkit.getDefaultToolkit().beep();
							e.consume();
						}
						break;
					case VALIDACION_PERSONALIZADA_INVERSA:
						if(validacionPersonalizadaString.contains(c+"")){
							if(beepActivado)
								Toolkit.getDefaultToolkit().beep();
							e.consume();
						}
						break;
					default:
						break;
					}
				}
			}
		});
		limite = SIN_LIMITES;
		tipoValidacion=SIN_VALIDAR;
		validacionPersonalizadaString = "";
		setBeepActivado(true);
	}
	/**
	 * @return limite Limite
	 * @see #limite
	 */
	public int getLimite() {
		return this.limite;
	}
	/**
	 * @param limite Limite
	 * @see #limite
	 */
	public void setLimite(int limite) {
		if(limite>=-1)
			this.limite=limite;
		else
			throw new IllegalArgumentException("El límite debe ser mayor que -1");
	}
	/**
	 * @return tipoValidacion Tipo de Validación
	 * @see #tipoValidacion
	 */
	public int getTipoValidacion() {
		return this.tipoValidacion;
	}
	/**
	 * @param tipoValidacion Tipo de Validación
	 * @see #tipoValidacion
	 */
	public void setTipoValidacion(int tipoValidacion) {
		if(tipoValidacion>=-1 && tipoValidacion<=5) {
			this.tipoValidacion=tipoValidacion;
		}
		else
			throw new IllegalArgumentException("El tipo de validación no es válido");
	}
	/**
	 * @return beepActivado Beep activado
	 * @see #beepActivado
	 */
	public boolean isBeepActivado() {
		return beepActivado;
	}
	/**
	 * @param beepActivado Beep activado
	 * @see #beepActivado
	 */
	public void setBeepActivado(boolean beepActivado) {
		this.beepActivado = beepActivado;
	}
	/**
	 * 
	 * @return validacionPersonalizadaString Cadena de caracteres usada en la validación personalizada
	 * @see #validacionPersonalizadaString
	 */
	public String getValidacionPersonalizada() {
		return validacionPersonalizadaString;
	}
	/**
	 * 
	 * @param validacionPersonalizadaString Cadena de caracteres usada en la validación personalizada
	 * @see #validacionPersonalizadaString
	 */
	public void setValidacionPersonalizada(
			String validacionPersonalizadaString) {
		if(validacionPersonalizadaString!=null)
			this.validacionPersonalizadaString = validacionPersonalizadaString;
		else
			throw new IllegalArgumentException("La cadena de caracteres no puede ser null");
	}
}
