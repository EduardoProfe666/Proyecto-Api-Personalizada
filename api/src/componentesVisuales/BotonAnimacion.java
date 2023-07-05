package componentesVisuales;


import java.awt.AlphaComposite;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *  
 * Clase que modela un botón con animación al ser presionado. 
 * 
 * <h1>Ver:</h1>{@link #colorEfecto}<br><br>
 * @version 28/10/2022
 * @author DJ-Raven
 * @author EduardoProfe
 */

public class BotonAnimacion extends JButton {

    private static final long serialVersionUID = 1L;
    
    /**
     * @return colorEfecto Color de efecto
     * @see #colorEfecto
     */
	public Color getColorEfecto() {
        return colorEfecto;
    }
	/**
	 * @param colorEfecto Color de efecto
	 * @see #colorEfecto
	 */
    public void setColorEfecto(Color colorEfecto) {
    	if(colorEfecto!=null)
    		this.colorEfecto = colorEfecto;
    }

    private Animator animator;
    private int tamMaxBtn;
    private float tamAnim;
    private Point puntoPresionado;
    private float alpha;
    /**
     * {@link Color} que determinará el color de la animación.
     * 
     * @author EduardoProfe
     */
    private Color colorEfecto = new Color(173, 173, 173);

    public BotonAnimacion() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setBackground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent m) {
                tamMaxBtn = Math.max(getWidth(), getHeight()) * 2;
                tamAnim = 0;
                puntoPresionado = m.getPoint();
                alpha = 0.5f;
                if (animator.isRunning()) {
                    animator.stop();
                }
                animator.start();
            }
        });
        TimingTarget tiempoPreferido = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraccion) {
                if (fraccion > 0.5f) {
                    alpha = 1 - fraccion;
                }
                tamAnim = fraccion * tamMaxBtn;
                repaint();
            }
        };
        animator = new Animator(400, tiempoPreferido);
        animator.setResolution(0);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        int ancho = getWidth();
        int alto = getHeight();
        BufferedImage img = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, ancho, alto, alto, alto);
        if (puntoPresionado != null) {
            g2.setColor(colorEfecto);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            g2.fillOval((int) (puntoPresionado.x - tamAnim / 2), (int) (puntoPresionado.y - tamAnim / 2), (int) tamAnim, (int) tamAnim);
        }
        g2.dispose();
        grphcs.drawImage(img, 0, 0, null);
        super.paintComponent(grphcs);
    }
}
