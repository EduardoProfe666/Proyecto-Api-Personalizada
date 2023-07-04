package componentesVisuales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;
/**
 * 
 * Clase que modela un JLabel con animación, al cual se le puede personalizar el texto, el retraso entre letras,
 * el retraso inicial, y el retraso final. Para poder emplearla debe llamar a <code>iniciarAnimacion()</code>, para 
 * que la animación comience a funcionar. Del mismo modo puede detenerla simplemente llamando a <code>detenerAnimacion()</code>.
 * 
 * <h1>Ver:</h1>{@link #textoAnimacion}<br>{@link #retardoLetra}<br>{@link #retardoInicialTexto}<br>{@link #retardoFinalTexto}<br>
 * {@link #iniciarAnimacion()}<br>{@link #detenerAnimacion()}<br><br>
 * @version 26/11/2022
 * @author EduardoProfe
 *
 */
public class JLabelAnimacion extends JLabel{
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * <b>String</b> que permitirá definir el texto de la animación.
	 * 
	 * @author EduardoProfe
	 */
	private String textoAnimacion;
	/**
	 * 
	 * <b>String</b> que permitirá modificar la duración del retardo del texto durante la animación.
	 * 
	 * @author EduardoProfe
	 */
	private int retardoLetra;
	/**
	 * <b>String</b> que permitirá modificar la duración del retardo del texto al comenzar la animación la animación.
	 * 
	 * @author EduardoProfe
	 */
	private int retardoInicialTexto;
	/**
	 * <b>String</b> que permitirá modificar la duración del retardo del texto al finalizar la animación.
	 * 
	 * @author EduardoProfe
	 */
	private int retardoFinalTexto;
	private int contador;
	private boolean aux;
	private Timer temporizador;

	public JLabelAnimacion(final String s, int retardoLetra, int retardoInicialTexto, int retardoFinalTexto) {
		setTexto(s);
		setRetardoLetra(retardoLetra);
		setRetardoInicialTexto(retardoInicialTexto);
		setRetardoFinalTexto(retardoFinalTexto);
		contador = 0;
		aux=true;
		temporizador = new Timer(this.retardoLetra,new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textoAnimacion.length()!=0)
					animacion();
			}});
		temporizador.start();
	}

	public String getTexto() {
		return textoAnimacion;
	}

	public void setTexto(String texto) {
		if(texto!=null)
			this.textoAnimacion = texto;
		else
			this.textoAnimacion = "";
		
		setText("");
		contador=0;
		aux=true;
	}

	public int getRetardoLetra() {
		return retardoLetra;
	}

	public void setRetardoLetra(int retardoLetra) {
		this.retardoLetra = retardoLetra<0 ? 70 : retardoLetra;
		if(temporizador!=null)
			temporizador.setDelay(this.retardoLetra);
	}

	public int getRetardoInicialTexto() {
		return retardoInicialTexto;
	}

	public void setRetardoInicialTexto(int retardoInicialTexto) {
		this.retardoInicialTexto = retardoInicialTexto<0 ? 100 : retardoInicialTexto;
	}

	public int getRetardoFinalTexto() {
		return retardoFinalTexto;
	}

	public void setRetardoFinalTexto(int retardoFinalTexto) {
		this.retardoFinalTexto = retardoFinalTexto<0 ? 700 : retardoFinalTexto;
	}

	private void animacion(){
		if(contador == textoAnimacion.length()){
			try {
				Thread.sleep(retardoFinalTexto);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			aux = false;
		}
		else if(contador == 0){
			try {
				Thread.sleep(retardoInicialTexto);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			aux = true;
		}

		if(aux)
			setText(getText()+textoAnimacion.charAt(contador++));
		else
			setText(new StringBuilder(getText()).deleteCharAt(--contador).toString());
	}
	/**
	 * 
	 * Método que permitirá el inicio de la animación.
	 * 
	 * @author EduardoProfe
	 */
	public void iniciarAnimacion(){
		temporizador.start();
	}
	/**
	 * Método que permitirá terminar con la animación.
	 * 
	 * @author EduardoProfe
	 */
	public void detenerAnimacion(){
		temporizador.stop();
	}

}
