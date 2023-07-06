package api.componentesVisuales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.Timer;
/**
 * 
 * Clase que modela un <b>JLabel</b> en el cual se dispondrá la 
 * hora del sistema en tiempo real. Contiene varios formatos de hora. 
 * Puede iniciarse y detenerse en reloj en todo momento.
 * 
 * <h1>Ver:</h1>{@link #iniciarReloj()}<br>{@link #detenerReloj()}<br>{@link #setFormatoHora(int)}<br><br>
 * @version v26/11/2022
 * @author EduardoProfe
 *
 */
public class JLabelHora extends JLabel{
	/**
	 * 
	 * Formato de hora predeterminado. Sigue la norma hh:mm:ss aa.<br>
	 * <b>Ej:</b> 07:07:07 PM<br>
	 * <b>Valor:</b> 0
	 * 
	 * @author EduardoProfe
	 */
	public static final int FORMATO_PREDETERMINADO = 0;
	/**
	 * Formato de hora predeterminado sin el marcador AM/PM. Sigue la norma hh:mm:ss.<br>
	 * <b>Ej:</b> 07:07:07<br>
	 * <b>Valor:</b> 1
	 * 
	 * @author EduardoProfe
	 */
	public static final int FORMATO_PREDETERMINADO_SIN_AM_PM = 1;
	/**
	 * Formato de hora militar. Sigue la norma kk:mm:ss.<br>
	 * <b>Ej:</b> 19:07:07<br>
	 * <b>Valor:</b> 2
	 * 
	 * @author EduardoProfe
	 */
	public static final int FORMATO_MILITAR = 2;
	private static final long serialVersionUID = 1L;
	private SimpleDateFormat formatoHora;
	private Timer temporizador;
	
	public JLabelHora(int formatoHora){
		setFormatoHora(formatoHora);
		actualizarHora();
		temporizador = new Timer(1,new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarHora();
			}});
		iniciarReloj();
	}
	private void actualizarHora(){
		setText(formatoHora.format(new Date()));
	}
	
	public void iniciarReloj(){
		temporizador.start();
	}
	public void detenerReloj(){
		temporizador.stop();
	}
	/**
	 * 
	 * Método que permitirá modificar el formato en que se muestra el reloj.
	 * 
	 * 
	 * <h1>Formatos:</h1>{@link #FORMATO_PREDETERMINADO}<br>{@link #FORMATO_PREDETERMINADO_SIN_AM_PM}<br>{@link #FORMATO_MILITAR}<br><br>
	 * @param formato Entero que indicará el formato de hora en que se representará 
	 * el reloj.
	 * @throws 		IllegalArgumentException Si se introduce un formato erróneo.
	 * 
	 * @author EduardoProfe
	 */
	public void setFormatoHora(int formato){
		switch(formato){
		case 0:
			formatoHora = new SimpleDateFormat("hh:mm:ss aa");
			break;
		case 1:
			formatoHora = new SimpleDateFormat("hh:mm:ss");
			break;
		case 2:
			formatoHora = new SimpleDateFormat("kk:mm:ss");
			break;
		default:
			throw new IllegalArgumentException("Debe seleccionar una de los formatos de hora válidos");
		}
	}

}
