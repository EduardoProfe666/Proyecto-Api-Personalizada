package utilidades;

import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Clase de utilidades que contiene algunos métodos auxiliares para las interfaces gráficas. 
 * El acceso a sus métodos es de manera estática.
 * 
 * <h1>Métodos implementados:</h1>
 * ---------{@link #ajustarImagen(Dimension, URL)}<br>
 * 
 * @version 21/11/2022
 * @author EduardoProfe
 *
 */

public final class AuxiliaresVisuales {
	private AuxiliaresVisuales(){}
	/**
	 *  Método que permitirá redimensionar la imagen pasada a unas dimensiones determinadas.
	 * 
	 * @param dimensiones Dimensiones objetivas
	 * @param urlImagen Ruta de la imagen
	 * @return  {@link Icon} la imagen redimensionada <br><br>
	 * 
	 * @throws		 IllegalArgumentException Si <b>dimensiones</b>==null o <b>urlImagen</b>==null
	 * 
	 * @author EduardoProfe
	 */
	public static Icon ajustarImagen(Dimension dimensiones, URL urlImagen) {
		if(dimensiones==null || urlImagen==null)
			throw new IllegalArgumentException();
		ImageIcon imagen = new ImageIcon(urlImagen);
		
		return new ImageIcon(imagen.getImage().getScaledInstance(dimensiones.width, dimensiones.height, Image.SCALE_SMOOTH));
	}
}
