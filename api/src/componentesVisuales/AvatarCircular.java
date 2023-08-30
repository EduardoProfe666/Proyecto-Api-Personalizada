package componentesVisuales;


import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *  
 * Componente visual que permitirá la representación de un avatar
 * circular, con tamaño de borde variable. Para cambiar el color del borde use el método {@code setForeground(Color)} 
 * 
 * <h1>Ver:</h1>{@link #avatar}<br>{@link #tamBorde}<br><br>
 * @version 28/10/2022
 * @author DJ-Raven
 * @author Eduardo
 *
 */

public class AvatarCircular extends JComponent{

	private static final long serialVersionUID = 1L;
	/**
	 * {@link Icon} que determinará la imagen del avatar. Para setearla, puede ser tanto por constructor,
	 * como por <code>setAvatar(Icon i)</code><br><b>Ejemplo:</b><br>
	 * <code>setAvatar(new ImageIcon(ClaseActual.class.getResource("/imagen/avatar.png")));</code>
	 * 
	 * @author EduardoProfe
	 */
	private Icon avatar;
	/**
	 * 
	 * Entero que determina el grosor del borde del avatar. Para modificar
	 * su color, modifique el valor de <b>foreground</b>.
	 * 
	 * @author EduardoProfe
	 */
	private int tamBorde;
	/**
	 * 
	 * @param avatar <b>Icon</b> que determinará la imagen a renderizar de avatar circular.
	 * @param tamBorde <b>Entero</b> que determinará el grosor del borde circular.
	 * @author EduardoProfe  
	 */
	public AvatarCircular(Icon avatar, int tamBorde) {
		setAvatar(avatar);
		setTamBorde(tamBorde);
	}
	public AvatarCircular(){
		this.avatar=null;
		this.tamBorde=0;
	}
	/**
	 * @return avatar
	 * @see #avatar
	 */
	public Icon getAvatar() {
		return avatar;
	}
	/**
	 * @param avatar Avatar
	 * @see #avatar
	 */
	public void setAvatar(Icon avatar) {
		if(avatar!=null)
			this.avatar = avatar;
	}
	/**
	 * @return tamBorde
	 * @see #tamBorde
	 */
	public int getTamBorde() {
		return tamBorde;
	}
	/**
	 * @param tamBorde Tamaño de borde
	 * @see #tamBorde
	 */
	public void setTamBorde(int tamBorde) {
		if(tamBorde>=0)
			this.tamBorde = tamBorde;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics grphcs) {
		if (avatar != null) {
			int ancho = getWidth();
			int alto = getHeight();
			int diametro = Math.min(ancho, alto);
			int x = ancho / 2 - diametro / 2;
			int y = alto / 2 - diametro / 2;
			int borde = tamBorde * 2;
			diametro -= borde;
			Rectangle tam = ajustarImagen(avatar, diametro);
			BufferedImage img = new BufferedImage(tam.width, tam.height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2_img = img.createGraphics();
			g2_img.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2_img.fillOval(0, 0, diametro, diametro);
			Composite composite = g2_img.getComposite();
			g2_img.setComposite(AlphaComposite.SrcIn);
			g2_img.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2_img.drawImage(toImage(avatar), tam.x, tam.y, tam.width, tam.height, null);
			g2_img.setComposite(composite);
			g2_img.dispose();
			Graphics2D g2 = (Graphics2D) grphcs;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			if (tamBorde > 0) {
				diametro += borde;
				g2.setColor(getForeground());
				g2.fillOval(x, y, diametro, diametro);
			}
			if (isOpaque()) {
				g2.setColor(getBackground());
				diametro -= borde;
				g2.fillOval(x + tamBorde, y + tamBorde, diametro, diametro);
			}
			g2.drawImage(img, x + tamBorde, y + tamBorde, null);
		}
		super.paintComponent(grphcs);
	}

	private Rectangle ajustarImagen(Icon avatar, int tam) {
		int w = tam;
		int h = tam;
		int iw = avatar.getIconWidth();
		int ih = avatar.getIconHeight();
		double escalaX = (double) w / iw;
		double escalaY = (double) h / ih;
		double escala = Math.max(escalaX, escalaY);
		int ancho = (int) (escala * iw);
		int alto = (int) (escala * ih);
		if (ancho < 1) {
			ancho = 1;
		}
		if (alto < 1) {
			alto = 1;
		}
		int cw = tam;
		int ch =tam;
		int x = (cw - ancho) / 2;
		int y = (ch - alto) / 2;
		return new Rectangle(new Point(x, y), new Dimension(ancho, alto));
	}

	private Image toImage(Icon icono) {
		return ((ImageIcon) icono).getImage();
	}
}
