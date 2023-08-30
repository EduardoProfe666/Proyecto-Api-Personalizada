package componentesVisuales;

import java.util.HashMap;

import javax.swing.JLabel;

/**
 * Clase que permite modelar un JLabel con capacidad de mostrar texto con múltiples líneas y permite variar la alineación del mismo, 
 * pudiendo estar justificado. Se emplean HTML y CSS para poder realizar este cometido.
 * 
 * <h1>Ver:</h1>
 * .{@link #texto}<br>
 * .{@link #alineacion}<br>
 * 
 * @author EduardoProfe
 * @version 27/08/2023
 *
 */
public class JLabelMultilineaMultialineado extends JLabel{
	private static final long serialVersionUID = 1L;
	/**
	 * Texto a mostrar. Puede ser de extensa longitud, pues el componente reajusta el texto con múltiples líneas para el 
	 * correcto mostrado.
	 */
	private String texto;
	/**
	 * {@link Alineacion} del texto a mostrar, pudiendo ser Izquierda, Derecha, Centrada y Justificada.
	 */
	private Alineacion alineacion;
	private static final HashMap<Alineacion, String> alineaciones = inicializarAlineaciones();
	
	private static HashMap<Alineacion, String> inicializarAlineaciones() {
		HashMap<Alineacion, String> alineaciones = new HashMap<>();
		alineaciones.put(Alineacion.IZQUIERDA, "left");
		alineaciones.put(Alineacion.CENTRADA, "center");
		alineaciones.put(Alineacion.DERECHA, "right");
		alineaciones.put(Alineacion.JUSTIFICADA, "justify");
		return alineaciones;
	}
	
	/**
	 * Permite crear una instancia de {@link JLabelMultilineaMultialineado} con determinado {@link #texto} y {@link #alineacion}.
	 * @param texto
	 * @param alineacion
	 */
	public JLabelMultilineaMultialineado(String texto, Alineacion alineacion){
		this.texto = texto;
		this.setAlineacion(alineacion);
		this.setText(texto);
	}
	
	/**
	 * {@link #texto}
	 * @param texto
	 */
	@Override
	public void setText(String texto){
		this.texto=texto!=null?texto:"";
		super.setText("<html><style>body{text-align: "+alineaciones.get(alineacion)+";}</style><body>"+texto+"</body></html>");
	}
	
	/**
	 * {@link #texto}
	 * @return texto
	 */
	public String getTexto() {
		return texto;
	}
	
	/**
	 * {@link Alineacion}
	 * @return alineacion
	 */
	public Alineacion getAlineacion() {
		return alineacion;
	}
	
	/**
	 * {@link Alineacion}
	 * @param alineacion
	 */
	public void setAlineacion(Alineacion alineacion) {
		if(alineacion==null){
			this.alineacion=Alineacion.IZQUIERDA;
		}
		else{
			this.alineacion=alineacion;
			this.setText(texto);
		}
	}
	
	/**
	 * Enum que permite modelar las alineaciones posibles del texto a mostrar. Las alineaciones actualmente compatibles son: <br>
	 * 1.--{@link #IZQUIERDA}<br>
	 * 2.--{@link #DERECHA}<br>
	 * 3.--{@link #CENTRADA}<br>
	 * 4.--{@link #JUSTIFICADA}<br>
	 * 
	 * @author EduardoProfe
	 *
	 */
	public static enum Alineacion{
		/**
		 * Permite mostrar el texto con alineación a la izquierda (forma occidental)
		 */
		IZQUIERDA,
		/**
		 * Permite mostrar el texto con alineación a la derecha (forma oriental)
		 */
		DERECHA,
		/**
		 * Permite mostrar el texto con alineación centrada
		 */
		CENTRADA,
		/**
		 * Permite mostrar el texto de forma justificada
		 */
		JUSTIFICADA
	}
}
