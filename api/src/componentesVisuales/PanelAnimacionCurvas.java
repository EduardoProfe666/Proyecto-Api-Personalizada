package componentesVisuales;


import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.GeneralPath;
import javax.swing.Timer;

/**
 * 
 * Clase que modela un panel con animación. Puede ser empleado para 
 * inicios o pantallas de carga. 
 *  
 * <h1>Ver:</h1>{@link #colorInicioAnimacion}<br>{@link #colorFinalAnimacion}<br>{@link #iniciarAnimacion()}<br>{@link #detenerAnimacion()}<br>
 * {@link PanelGradiente}<br><br> 
 * @version 14/11/2022 
 * @author DJ-Raven
 * @author EduardoProfe
 */

public class PanelAnimacionCurvas extends PanelGradiente{

	private static final long serialVersionUID = 1L;
	private RenderingHints pistasRenderizacion;
	private int contador;
	private Timer temporizador;
	/**
	 * {@link Color} que permitirá modificar el color del principio de las curvas
	 * de animación. Considerar utilizar los colores <b>sRGB</b>. <h1>Ejemplo:</h1>new Color(255,255,255,100);
	 * 
	 * @author EduardoProfe
	 */
	private Color colorInicioAnimacion;
	/**
	 * {@link Color} que permitirá modificar el color del final de las curvas
	 * de animación. Considerar utilizar los colores <b>sRGB</b>. <h1>Ejemplo:</h1>new Color(255,255,255,100);
	 * @author EduardoProfe
	 */
	private Color colorFinalAnimacion;

	public PanelAnimacionCurvas(Color colorInicioGradiente, Color colorFinalGradiente, Color colorInicioAnimacion, Color colorFinalAnimacion) {
		super(colorInicioGradiente,colorFinalGradiente);
		
		setColorInicioAnimacion(colorInicioAnimacion);
		setColorFinalAnimacion(colorFinalAnimacion);
		
		contador=0;
		
		temporizador = new Timer(20, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				repaint();
			}
		});

		pistasRenderizacion = new RenderingHints(RenderingHints.KEY_ALPHA_INTERPOLATION,RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		pistasRenderizacion.put(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		pistasRenderizacion.put(RenderingHints.KEY_COLOR_RENDERING,RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		pistasRenderizacion.put(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		pistasRenderizacion.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		iniciarAnimacion();
	}
	/**
	 * @param color Color
	 * @see #colorInicioAnimacion
	 */
	public void setColorInicioAnimacion(Color color){
		if(color!=null)
			this.colorInicioAnimacion=color;
		else
			this.colorInicioAnimacion=new Color(255,255,255,255);
	}
	/**
	 * @return color Color
	 * @see #colorInicioAnimacion
	 */
	public Color getColorInicioAnimacion(){
		return colorInicioAnimacion;
	}
	/**
	 * @param color Color
	 * @see #colorFinalAnimacion
	 */
	public void setColorFinalAnimacion(Color color){
		if(color!=null)
			this.colorFinalAnimacion=color;
		else
			this.colorFinalAnimacion=new Color(255,255,255,0);
	}
	/**
	 * @return color Color
	 * @see #colorFinalAnimacion
	 */
	public Color getColorFinalAnimacion(){
		return colorFinalAnimacion;
	}

	@Override
	protected void paintComponent(Graphics g) {
		contador++;

		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHints(pistasRenderizacion);
		super.paintComponent(g2);

		float ancho = getWidth();
		float alto = getHeight();

		g2.translate(0, -30);
		dibujarCurva(g2,
				20.0f, -10.0f, 20.0f, -10.0f,
				ancho / 2.0f - 40.0f, 10.0f,
				0.0f, -5.0f,
				ancho / 2.0f + 40, 1.0f,
				0.0f, 5.0f,
				50.0f, 5.0f, false);
		g2.translate(0, 30);

		g2.translate(0, alto - 60);
		dibujarCurva(g2,
				30.0f, -15.0f, 50.0f, 15.0f,
				ancho / 2.0f - 40.0f, 1.0f,
				15.0f, -25.0f,
				ancho / 2.0f, 1.0f / 2.0f,
				0.0f, 25.0f,
				15.0f, 6.0f, false);
		g2.translate(0, -alto + 60);

		dibujarCurva(g2,
				alto - 35.0f, -5.0f, alto - 50.0f, 10.0f,
				ancho / 2.0f - 40.0f, 1.0f,
				alto - 35.0f, -25.0f,
				ancho / 2.0f, 1.0f / 2.0f,
				alto - 20.0f, 25.0f,
				25.0f, 4.0f, true);
	}

	private void dibujarCurva(Graphics2D g2,
			float y1, float y1_offset,
			float y2, float y2_offset,
			float cx1, float cx1_offset,
			float cy1, float cy1_offset,
			float cx2, float cx2_offset,
			float cy2, float cy2_offset,
			float grosor,
			float velocidad,
			boolean invertir) {

		float ancho = getWidth();
		float alto = getHeight();

		double offset = Math.sin(contador / (velocidad * Math.PI));
		float inicioX = 0.0f;
		float inicioY = y1 + (float) (offset * y1_offset);
		float finalX = ancho;
		float finalY = y2 + (float) (offset * y2_offset);
		float controlX1 = (float) offset * cx1_offset + cx1;
		float controlY1 = cy1 + (float) (offset * cy1_offset);
		float controlX2 = (float) (offset * cx2_offset) + cx2;
		float controlY2 = (float) (offset * cy2_offset) + cy2;

		CubicCurve2D curva = new CubicCurve2D.Double(inicioX, inicioY, controlX1, controlY1, controlX2, controlY2, finalX, finalY);

		GeneralPath guiaCurva = new GeneralPath(curva);
		guiaCurva.lineTo(ancho, alto);
		guiaCurva.lineTo(0, alto);
		guiaCurva.closePath();

		Area grosorCurva = new Area((Shape) guiaCurva.clone());
		AffineTransform transformador = AffineTransform.getTranslateInstance(0, grosor);
		guiaCurva.transform(transformador);
		grosorCurva.subtract(new Area(guiaCurva));

		Color colorInicio = colorInicioAnimacion;
		Color colorFinal = colorFinalAnimacion;

		Rectangle limites = grosorCurva.getBounds();
		GradientPaint representacionGrafica = new GradientPaint(0, curva.getBounds().y,
				invertir ? colorFinal : colorInicio,
						0, limites.y + (float)limites.height,
						invertir ? colorInicio : colorFinal);
		Paint representacionGraficaPrevia = g2.getPaint();
		g2.setPaint(representacionGrafica);

		g2.fill(grosorCurva);

		g2.setPaint(representacionGraficaPrevia);
	}
	/**
	 * Método que permitirá el inicio de la animación.
	 * 
	 * @author EduardoProfe
	 */
	public void iniciarAnimacion() {
		temporizador.start();
	}
	/**
	 * Método que permitirá la finalización de la animación.
	 * 
	 * @author EduardoProfe
	 */
	public void detenerAnimacion() {
		temporizador.stop();
	}

}
