package api.componentesVisuales;


import javax.swing.JPanel;

import api.componentesVisuales.PanelAnimacionCurvas;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

/**
 * 
 * Clase que modela un panel con triple gradiente horizontal. Será usado principalmente para la modelación
 * del panel base del {@link PanelAnimacionCurvas}.
 *  
 * <h1>Ver:</h1>{@link #inicioGradiente}<br>{@link #finGradiente}<br>{@link PanelAnimacionCurvas}<br><br> 
 * @author DJ-Raven
 * @author EduardoProfe
 *
 */

public class PanelGradiente extends JPanel{
	
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
	
    public PanelGradiente(Color inicioGradiente, Color finGradiente) {
        setInicioGradiente(inicioGradiente);
        setFinGradiente(finGradiente);
    }
    /**
   	 * 
   	 * @param color Color Inicio Gradiente
   	 * @see #inicioGradiente
   	 */
    public void setInicioGradiente(Color color){
    	if(color!=null)
    		this.inicioGradiente=color;
    	else
    		this.inicioGradiente=Color.GRAY;
    	repaint();
    }
    /**
	 * 
	 * @param color Color Fin Gradiente
	 * @see #finGradiente
	 */
    public void setFinGradiente(Color color){
    	if(color!=null)
    		this.finGradiente=color;
    	else
    		this.finGradiente=Color.LIGHT_GRAY;
    	repaint();
    }

    @Override
    protected void paintComponent(Graphics g) { 
        int alto = getHeight();
        Graphics2D g2 = (Graphics2D) g.create();
        GradientPaint representacionGrafica = new GradientPaint(0, 0, inicioGradiente, 0, alto, finGradiente);
        Paint oldPainter = g2.getPaint();
        
        g2.setPaint(representacionGrafica);
        g2.fill(g2.getClip());
        representacionGrafica = new GradientPaint(0, 0, finGradiente, 0, alto/2.0f, inicioGradiente);
        g2.setPaint(representacionGrafica);
        g2.fill(g2.getClip());

        representacionGrafica = new GradientPaint(0, alto/2.0f, inicioGradiente,0, alto, finGradiente);
        g2.setPaint(representacionGrafica);
        g2.fill(g2.getClip());

        g2.setPaint(oldPainter);
    }
    /**
   	 * @return color Color Inicio Gradiente
   	 * @see #inicioGradiente
   	 */
    public Color getInicioGradiente() {
		return inicioGradiente;
	}
    /**
	 * @return color Color Final Gradiente
	 * @see #finGradiente
	 */
	public Color getFinGradiente() {
		return finGradiente;
	}
}
