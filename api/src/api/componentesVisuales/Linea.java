package api.componentesVisuales;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JComponent;

/**
 * Clase que permitirá generar una línea. La linea puede ser personalizada con {@link #color}, {@link #grosor}, {@link #orientacion} y 
 * {@link #tipoLinea}.
 * 
 * @version 04/07/2023
 * @author EduardoProfe
 *
 */
public class Linea extends JComponent{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Permite construir una linea con orientacion vertical. Es construida en el extremo izquierdo del componente. <b>Valor</b>=0.
	 */
	public static final int ORIENTACION_VERTICAL = 0;
	/**
	 * Permite construir una linea con orientacion horizontal. Es construida en el extremo superior del componente. <b>Valor</b>=1.
	 */
	public static final int ORIENTACION_HORIZONTAL = 1;
	/**
	 * Permite construir una linea con orientacion diagonal derecha. Es construida desde el extremo inferior izquierdo hasta 
	 * el extremo superior derecho del componente. <b>Valor</b>=2.
	 */
	public static final int ORIENTACION_DIAGONAL_DERECHA = 2;
	/**
	 * Permite construir una linea con orientacion diagonal izquierda. Es construida desde el extremo superior derecho hasta el 
	 * extremo inferior derecho del componente. <b>Valor</b>=3.
	 */
	public static final int ORIENTACION_DIAGONAL_IZQUIERDA = 3;

	/**
	 * Permite construir una linea continua. <b>Valor</b>=0.
	 */
	public static final int LINEA_CONTINUA = 0;
	/**
	 * Permite construir una linea discontinua. Si se quiere cambiar el patron, cree una clase que herede de {@link Linea} y 
	 * cambie el valor retornado por el metodo {@link #patronLineaDiscontinua()}. <b>Valor</b>=1.
	 * 
	 */
	public static final int LINEA_DISCONTINUA = 1;

	/**
	 * Atributo que permite cambiar el color de la linea
	 */
	private Color color;

	/**
	 * Atributo que permite cambiar el grosor de la linea, no debe ser negativa
	 */
	private int grosor;
	
	
	/**
	 * Atributo que permite cambiar la orientación de la linea construida. Los tipos de orientacion validos son:<br>
	 * 0.--{@link #ORIENTACION_VERTICAL}<br>
	 * 1.--{@link #ORIENTACION_HORIZONTAL}<br>
	 * 2.--{@link #ORIENTACION_DIAGONAL_DERECHA}<br>
	 * 3.--{@link #ORIENTACION_DIAGONAL_IZQUIERDA}<br>
	 */
	private int orientacion;
	/**
	 * Atributo que permite cambiar el tipo de linea de la linea construida. Los tipos de linea validos son:<br>
	 * 0.--{@link #LINEA_CONTINUA}<br>
	 * 1.--{@link #LINEA_DISCONTINUA}<br>
	 */
	private int tipoLinea;

	/**
	 * Permite construir una linea dada una orientacion y un tipo de linea. Construye la linea de color negro y 
	 * grosor 3.
	 * 
	 * @param orientacion {@link #orientacion}
	 * @param tipoLinea {@link #tipoLinea}
	 */
	public Linea(int orientacion, int tipoLinea) {
		this(Color.BLACK,3,orientacion, tipoLinea);
	}

	/**
	 * Permite construir una linea dado un color, un grosor, una orientacion y un tipo de linea
	 * 
	 * @param color {@link #color}
	 * @param grosor {@link #grosor}
	 * @param orientacion {@link #orientacion}
	 * @param tipoLinea {@link #tipoLinea}
	 */
	public Linea(Color color, int grosor, int orientacion, int tipoLinea) {
		setBounds(0,0,50,50);
		this.color = color;
		this.grosor = grosor;
		this.orientacion = orientacion;
		this.tipoLinea = tipoLinea;
		repaint();
	}

	public int getTipoLinea() {
		return tipoLinea;
	}

	public void setTipoLinea(int tipoLinea) {
		this.tipoLinea = tipoLinea;
		repaint();
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x,y,width,height);
		repaint();
	}

	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
		repaint();
	}
	public int getGrosor() {
		return grosor;
	}
	public void setGrosor(int grosor) {
		if(grosor<0)
			grosor = 0;
		this.grosor = grosor;
		repaint();
	}
	public int getOrientacion() {
		return orientacion;
	}
	public void setOrientacion(int orientacion) {
		this.orientacion = orientacion;
		repaint();
	}



	@Override
	protected void paintComponent(Graphics g) {
		RenderingHints pistaRenderizacion = new RenderingHints(RenderingHints.KEY_ALPHA_INTERPOLATION,RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		pistaRenderizacion.put(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		pistaRenderizacion.put(RenderingHints.KEY_COLOR_RENDERING,RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		pistaRenderizacion.put(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		pistaRenderizacion.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);

		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHints(pistaRenderizacion);
		super.paintComponent(g2);

		g2.setColor(color);
		g2.setStroke(new BasicStroke(grosor,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,5.0f,tipoLinea==LINEA_DISCONTINUA ? patronLineaDiscontinua() : null,0.0f));


		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;

		Rectangle r = getBounds();

		switch(orientacion) {
		case ORIENTACION_VERTICAL:
			x1 = grosor;
			y1 = 0;
			x2 = grosor;
			y2 = r.height;
			break;
		case ORIENTACION_HORIZONTAL:
			x1 = 0;
			y1 = grosor;
			x2 = r.width;
			y2 = grosor;
			break;
		case ORIENTACION_DIAGONAL_DERECHA:
			x1 = 0;
			y1 = r.height;
			x2 = r.width;
			y2 = 0;
			break;
		case ORIENTACION_DIAGONAL_IZQUIERDA:
			x1 = 0;
			y1 = 0;
			x2 = r.width;
			y2 = r.height;
			break;
		default:
			break;	
		}

		g2.drawLine(x1, y1, x2, y2);
	}
	
	/**
	 * Otorga el patron de las lineas discontinuas. En el arreglo, los numeros en posiciones pares son el tamaño de la linea, y 
	 * los numeros en posiciones impares son el tamaño del espacio. Sobreescribir este metodo para cambiar el patron.
	 * 
	 * @return Patron Discontinuo de la Linea
	 */
	protected float[] patronLineaDiscontinua() {
		return new float[] {6,6};
	}
}

