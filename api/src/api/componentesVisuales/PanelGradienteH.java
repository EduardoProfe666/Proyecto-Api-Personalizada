package api.componentesVisuales;


import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
/**
 * Clase que modela un panel con color gradiente en dirección horizontal,
 * definiendo el {@link Color} inicial y el {@link Color} final.
 * 
 * <h1>Ver:</h1>{@link #inicioGradiente}<br>{@link #finGradiente}<br><br>
 * @version 11/11/2022
 * @author EduardoProfe
 *
 */
public class PanelGradienteH extends JPanel{

	private static final long serialVersionUID = 1L;
	/**
	 * {@link Color} inicial del gradiente a renderizar.
	 * 
	 * @author EduardoProfe
	 */
	private Color inicioGradiente;
	/**
	 * {@link Color} final del gradiente a renderizar.
	 * 
	 * @author EduardoProfe
	 */
	private Color finGradiente;
	
    public PanelGradienteH(Color inicioGradiente, Color finGradiente) {
        setInicioGradiente(inicioGradiente);
        setFinGradiente(finGradiente);;
    }
   
    @Override
    protected void paintComponent(Graphics g) { 
        int ancho = getWidth();
        Graphics2D g2 = (Graphics2D) g.create();
        GradientPaint representacionGrafica = new GradientPaint(0, 0, inicioGradiente, ancho, 0, finGradiente);
        g2.setPaint(representacionGrafica);
        g2.fill(g2.getClip());
    }
    /**
   	 * @return color Color Inicio Gradiente
   	 * @see #inicioGradiente
   	 */
    public Color getInicioGradiente() {
		return inicioGradiente;
	}
    /**
	 * @param color Color Inicio Gradiente
	 * @see #inicioGradiente
	 */
    public void setInicioGradiente(Color color){
    	if(color!=null)
    		this.inicioGradiente=color;
    	else
    		this.inicioGradiente=Color.BLACK;
    	repaint();
    }
    /**
	 * @param color Color Final Gradiente
	 * @see #finGradiente
	 */
    public void setFinGradiente(Color color){
    	if(color!=null)
    		this.finGradiente=color;
    	else
    		this.finGradiente=Color.LIGHT_GRAY;
    	repaint();
    }
    /**
	 * @return color Color Final Gradiente
	 * @see #finGradiente
	 */
	public Color getFinGradiente() {
		return finGradiente;
	}
}
