package componentesVisuales;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.Timer;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.Interpolator;

import componentesVisuales.datos.ImageSplit;

/**
 * Clase que permite modelar un carrusel de imágenes, es decir, permite mostrar en bucle una serie de imágenes otorgadas.
 * 
 * <h1>Ver:</h1>
 * 1.--{@link #CarruselImagenes(int)}<br>
 * 2.--{@link #addImage(Icon)}<br>
 * 3.--{@link #iniciarAnimacion()}<br>
 * 4.--{@link #detenerAnimacion()}<br>
 * 
 * @version 28/08/2023
 * @author EduardoProfe
 *
 */
public class CarruselImagenes extends JComponent {

    private static final long serialVersionUID = 1L;
	private List<Icon> images;
    private ImageSplit imageSplit;
    private int indexOld = -1;
    private Animator animator;
    private float animate;
    private Timer temporizador;
    private int indice=0;
    private int cantIm;
    private int delayy;
    
    /**
     * Permite construir el carrusel de imagenes. Para agregar imagenes usar {@link #addImage(Icon)}. Para iniciar la 
     * animacion usar {@link #iniciarAnimacion()}.
     * 
     * @param delay Retardo en ms entre cambio de imagenes
     */
    public CarruselImagenes(int delay) {
    	this.delayy=delay;
        images = new ArrayList<>();
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                animate = fraction;
                repaint();
            }

            @Override
            public void end() {
                imageSplit = null;
            }
        };
        animator = new Animator(2000, target);
        animator.setResolution(1);
        animator.setInterpolator(new Interpolator() {
            @Override
            public float interpolate(float f) {
                return easeOutBounce(f);
            }
        });
        
        temporizador = new Timer(delay, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				cantIm = images.size();
				temporizador.setDelay(delayy+2000);
				if(cantIm>0) {
					indice = (indice+1==cantIm) ? 0 : ++indice;
					showImage(indice);
				}
			}
		});
    }

    private float easeOutBounce(float x) {
        float n1 = 7.5625f;
        float d1 = 2.75f;
        double v;
        if (x < 1 / d1) {
            v = n1 * x * x;
        } else if (x < 2 / d1) {
            v = n1 * (x -= 1.5 / d1) * x + 0.75;
        } else if (x < 2.5 / d1) {
            v = n1 * (x -= 2.25 / d1) * x + 0.9375;
        } else {
            v = n1 * (x -= 2.625 / d1) * x + 0.984375;
        }
        return (float) v;
    }
    
    /**
     * Permite adicionar imagenes al carrusel.
     * @param image Imagen a adicionar.
     */
    public void addImage(Icon image) {
        images.add(image);
        if (indexOld == -1) {
            indexOld = 0;
            repaint();
        }
    }
    
    public void showImage(int index) {
        if (index < images.size()) {
            if (!animator.isRunning()) {
                imageSplit = new ImageSplit(toImage(images.get(indexOld)), getSize(), getAutoSize(images.get(indexOld)));
                indexOld = index;
                animator.start();
            }
        }
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        RenderingHints pistaRenderizacion = new RenderingHints(RenderingHints.KEY_ALPHA_INTERPOLATION,RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		pistaRenderizacion.put(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		pistaRenderizacion.put(RenderingHints.KEY_COLOR_RENDERING,RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		pistaRenderizacion.put(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		pistaRenderizacion.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHints(pistaRenderizacion);
        int width = getWidth();
        if (indexOld >= 0) {
            Icon image = images.get(indexOld);
            Rectangle size = getAutoSize(image);
            g2.drawImage(toImage(image), size.getLocation().x, size.getLocation().y, size.getSize().width, size.getSize().height, null);
        }
        if (imageSplit != null) {
            int x = (int) (animate * width);
            g2.drawImage(imageSplit.getImageLeft(), -x, 0, null);
            g2.drawImage(imageSplit.getImageRight(), x, 0, null);
        }
        g2.dispose();
        super.paint(grphcs);
    }

    private Rectangle getAutoSize(Icon image) {
//        int w = getWidth();
//        int h = getHeight();
//        if (w > image.getIconWidth()) {
//            w = image.getIconWidth();
//        }
//        if (h > image.getIconHeight()) {
//            h = image.getIconHeight();
//        }
//        int iw = image.getIconWidth();
//        int ih = image.getIconHeight();
//        double xScale = (double) w / iw;
//        double yScale = (double) h / ih;
//        double scale = Math.max(xScale, yScale);
//        int width = (int) (scale * iw);
//        int height = (int) (scale * ih);
//        int x = getWidth() / 2 - (width / 2);
//        int y = getHeight() / 2 - (height / 2);
        return new Rectangle(new Point(0, 0), new Dimension(getWidth(), getHeight()));
    }

    private Image toImage(Icon icon) {
        return ((ImageIcon) icon).getImage();
    }
    
    /**
     * Permite iniciar la animación
     */
    public void iniciarAnimacion() {
		temporizador.start();
	}

    /**
     * Permite detener la animación.
     */
	public void detenerAnimacion() {
		temporizador.stop();
	} 
}
