package api.componentesVisuales;


import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
/**
 * Clase que permitirá generar una imagen que se reajuste automáticamente
 * a las dimensiones dadas, pudiéndole establecer una transparencia
 * 
 * <h1>Ver:</h1>{@link #imagen}<br>{@link #alpha}<br><br>
 * @version 16/12/2022
 * @author EduardoProfe
 *
 */
public class Imagen extends JComponent{

	private static final long serialVersionUID = 1L;
	/**
	 * {@link Icon} que determinará la imagen a renderizar.
	 * 
	 * @author EduardoProfe
	 */
	private Icon imagen;
	/**
	 * {@link Float} que determinará la transparencia de la imagen.
	 * Es un un valor que va desde 0 (transparente) hasta 1 (sólido), 
	 * pudiendo asignarle un valor en el medio como 0.5f (semi-transparente).
	 * 
	 * @author EduardoProfe
	 */
	private float alpha;
	public Imagen(Icon imagen) {
		setImagen(imagen);
		alpha=1.0f;
	}
	/**
	 * @return imagen Imagen
	 * @see #imagen
	 */
	public Icon getImagen() {
		return this.imagen;
	}
	/**
	 * @param imagen Imagen
	 * @see #imagen
	 */
	public void setImagen(Icon imagen) {
		if(imagen!=null)
			this.imagen=imagen;
		this.repaint();
	}
	/**
	 * 
	 * @return alpha Alpha
	 * @see #alpha
	 */
	public float getAlpha(){
		return this.alpha;
	}
	/**
	 * @param alpha Alpha
	 * @see #alpha
	 */
	public void setAlpha(float alpha){
		if(alpha>=0 && alpha<=1)
			this.alpha=alpha;
		this.repaint();
	}

	
	@Override
	protected void paintComponent(Graphics gr) {
		if(imagen!=null) {
			Dimension contorno = new Dimension(this.getWidth(),this.getHeight());
			BufferedImage img = new BufferedImage(contorno.width, contorno.height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2_img = img.createGraphics();
			
			g2_img.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2_img.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2_img.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			g2_img.fillRect(0, 0, contorno.width, contorno.height);
			
			Composite composite = g2_img.getComposite();
			
			g2_img.setComposite(AlphaComposite.SrcIn.derive(alpha));
			g2_img.drawImage(toImage(this.imagen), 0,0,contorno.width, contorno.height, null);
			g2_img.setComposite(composite);
			g2_img.dispose();
			
			Graphics2D g2 = (Graphics2D) gr;
			g2.drawImage(img, 0,0,null);
		}
		super.paintComponent(gr);
	}
	
	private Image toImage(Icon icon) {
		return ((ImageIcon) icon).getImage();
	}
}
