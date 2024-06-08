package componentesVisuales;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.Timer;

import logica.utilidades.interfaz.AuxiliaresVisuales;

/**
 * Clase que permite modelar un imagen con una animación de movimiento simple en dirección vertical y horizontal con suavizado.
 * <br><br><b>ES UNA VERSION BETA, NO ESTA TERMINADA NI OPTIMIZADA NI TESTEADA</b><br>
 * <b>SOLO SE GARANTIZA SU CORRECTO FUNCIONAMIENTO EN CONTENEDORES CON ABSOLUTE LAYOUT</b>
 * <h1>Ver:</h1>
 * 1.--{@link #delayAnim}<br>
 * 2.--{@link #radioAnim}<br>
 * 3.--{@link #direccion}<br>
 * 4.--{@link Direccion}<br>
 * 
 * @version 28/08/2023 BETA
 * @author LilyRosy
 * @author EduardoProfe
 *
 */
public class ImagenAnimada extends JLabel{
	private static final long serialVersionUID = 1L;
	/**
	 * Permite modificar el retardo de cada frame de la animación. Se da en milisegundos.
	 */
	private int delayAnim;
	/**
	 * Permite modificar el radio de la animación, es decir, rango de movimiento = 2*radioAnim. Se da en pixeles.
	 */
	private Integer radioAnim;
	/**
	 * {@link Direccion} del movimiento de la animacion.
	 */
	private Direccion direccion;
	private Timer temporizador;
	private double num;
	private boolean dir;
	private int xOriginal;
	private int yOriginal;
	private int nOriginal;
	private boolean b;
	
	/**
	 * Permite crear una ImagenAnimada. Tener en cuenta que al crearse el componente se inicia la animación.
	 * 
	 * @param rutaImagen Ruta URL de la imagen. Para un correcto funcionamiento se debe emplear la siguiente forma: 
	 * {@code ClaseBase.class.getResource("/imagenes/imagen.png")}
	 * @param anchoImg Ancho que va a tener la imagen.
	 * @param largoImg Largo que va a tener la imagen.
	 * @param delayAnim {@link #delayAnim}
	 * @param radioAnimm {@link #radioAnim}
	 * @param direccionn {@link #direccion}
	 */
	public ImagenAnimada(URL rutaImagen, int anchoImg, int largoImg, int delayAnim, int radioAnimm, Direccion direccionn) {
		setIcon(AuxiliaresVisuales.ajustarImagen(new Dimension(anchoImg,largoImg), rutaImagen));
		setDelayAnim(delayAnim);
		setRadioAnim(radioAnimm);
		setDireccion(direccionn);
		num = 0;
		dir = true;
		b=false;
		temporizador = new Timer(radioAnim, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!b){
					b=true;
					yOriginal = getY();
					xOriginal = getX();
				}
				nOriginal = direccion.equals(Direccion.VERTICAL) ? yOriginal:xOriginal;
				if((int)num==0){
					num+=.08;
					dir=true;
				}
				else if((int)num==1000000){
					num-=.08;
					dir=false;
				}
				else{
					if(dir)
						num+=.08;
					else
						num-=.08;
				}
				double n = radioAnim*Math.sin(num)+nOriginal;
				setBounds(direccion.equals(Direccion.HORIZONTAL)?(int)n:getX(),direccion.equals(Direccion.VERTICAL)?(int)n:getY(),getWidth(),getHeight());
			}
		});
		iniciarAnimacion();
	}
	
	private void reiniciar() {
		if(temporizador!=null)
			temporizador.stop();
		num=0;
		dir=true;
		if(temporizador!=null)
			temporizador.start();
	}
	
	/**
	 * Permite iniciar la animacion
	 */
	public void iniciarAnimacion() {
		temporizador.start();
	}
	
	/**
	 * Permite detener la animacion
	 */
	public void detenerAnimacion() {
		temporizador.stop();
	}
	
	/**
	 * {@link #radioAnim}
	 * @return radio
	 */
	public int getRadioAnim() {
		return radioAnim;
	}
	/**
	 * {@link #radioAnim}
	 * @param radioAnim
	 */
	public void setRadioAnim(int radioAnim) {
		if(radioAnim<0)
			throw new IllegalArgumentException("Radio de la animacion tiene que ser mayor que -1");
		this.radioAnim = radioAnim;
	}
	
	/**
	 * {@link #direccion}
	 * @return direccion
	 */
	public Direccion getDireccion() {
		return direccion;
	}
	/**
	 * {@link #direccion}
	 * @param direccion
	 */
	public void setDireccion(Direccion direccion) {
		if(direccion==null)
			this.direccion=Direccion.VERTICAL;
		else
			this.direccion = direccion;
		reiniciar();
	}
	
	/**
	 * {@link #delayAnim}
	 * @return delay
	 */
	public int getDelayAnim() {
		return delayAnim;
	}
	/**
	 * {@link #delayAnim}
	 * @param delayAnim
	 */
	public void setDelayAnim(int delayAnim) {
		if(delayAnim<0)
			throw new IllegalArgumentException("El delay de la animacion tiene que ser mayor que -1");
		this.delayAnim = delayAnim;
		if(temporizador!=null)
			temporizador.setDelay(delayAnim);
	}


	/**
	 * Enum que permite modelar la direccion de la animacion. Las direcciones soportadas actualmente son:<br>
	 * 1.--{@link #VERTICAL}<br>
	 * 2.--{@link #HORIZONTAL}<br>
	 * 
	 * @author EduardoProfe
	 *
	 */
	public static enum Direccion{
		/**
		 * Permite una animacion en sentido vertical
		 */
		VERTICAL,
		/**
		 * Permite una animacion en sentido horizontal
		 */
		HORIZONTAL
	}
}
