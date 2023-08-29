package componentesVisuales;

import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import rojerusan.RSNotifyFade;
import rojerusan.RSNotifyFade.PositionNotify;
import rojerusan.RSNotifyFade.TypeNotify;
import utilidades.ManejadorLookAndFeels;
/**
 * 
 * Clase que permitir� un sistema personalizado de notificaciones. Presenta mensajes de error,
 * advertencia, informaci�n y �xito. Se pueden colocar en cualquiera de las esquinas del programa. Tiene
 * un duraci�n (segundos) determinada por el usuario, la cual se recomienda que sea m�nimo 1 segundo. Si el 
 * usuario presiona sobre la notificaci�n, la misma desaparece, sin importar cuanto tiempo de duraci�n reste.
 * El acceso a dichas notificaciones es igual que con <b>JOptionPane</b>, de manera est�tica e indicando la descripci�n de la
 * notificaci�n. Para una mejor apariencia cambiar el LookAndFeel a trav�s del {@link ManejadorLookAndFeels}. Seleccionar
 * el adecuado, pues algunos LookAndFeels, debido a su naturaleza, modifican como se visualiza este componente.
 * 
 * <h1>Ver:</h1>{@link #lanzarNotificacion(String, String, int, int, int)}<br><br>
 * @version v26/11/2022
 * @author RojeruSans
 * @author EduardoProfe
 *
 */
public final class Notificaciones {
	private Notificaciones(){}
	/**
	 * Posici�n superior izquierda. Valor: <b>0</b>.
	 */
	public static final int POSICION_SUP_IZQ = 0;
	/**
	 * Posici�n superior derecha. Valor: <b>1</b>.
	 */
	public static final int POSICION_SUP_DER = 1;
	/**
	 * Posici�n inferior izquierda. Valor: <b>2</b>.
	 */
	public static final int POSICION_INF_IZQ = 2;
	/**
	 * Posici�n inferior derecha. Valor: <b>3</b>.
	 */
	public static final int POSICION_INF_DER = 3;
	
	/**
	 * Tipo de notificaci�n de error. Valor: <b>0</b>.
	 */
	public static final int MENSAJE_ERROR = 0;
	/**
	 * Tipo de notificaci�n de advertencia. Valor: <b>1</b>.
	 */
	public static final int MENSAJE_ADVERTENCIA = 1;
	/**
	 * Tipo de notificaci�n de informaci�n. Valor: <b>2</b>.
	 */
	public static final int MENSAJE_INFORMACION = 2;
	/**
	 * Tipo de notificaci�n de �xito. Valor: <b>3</b>.
	 */
	public static final int MENSAJE_EXITO =3;
	
	/**
	 *  M�todo que permitir� lanzar la notificaci�n, describiendo el tipo y la descripci�n de la 
	 *  misma.
	 * 
	 * <h1>Posiciones:</h1>{@link #POSICION_SUP_IZQ}<br>{@link #POSICION_SUP_DER}<br>{@link #POSICION_INF_IZQ}<br>{@link #POSICION_INF_DER}<br><br>
	 * <h1>Tipos de Notificaci�n:</h1>{@link #MENSAJE_ERROR}<br>{@link #MENSAJE_ADVERTENCIA}<br>{@link #MENSAJE_INFORMACION}<br>{@link #MENSAJE_EXITO}<br><br>
	 * 
	 * @param titulo <b>String</b> que ser� el t�tulo de la notificaci�n. Puede ser <b>null</b>.
	 * @param mensaje <b>String</b> que ser� la descripci�n de la notificaci�n. Puede ser <b>null</b>.
	 * @param retrasoSegundos Entero que indica la duraci�n en segundos de la notificaci�n antes de que la misma desaparezca.
	 * @param posicionNotificacion Entero que indica la posici�n de la notificaci�n. 
	 * @param tipoNotificacion Entero que indica el tipo de notificaci�n.
	 * 
	 * @throws		IllegalArgumentException Si la posici�n y/o el tipo de notificaci�n no son
	 * v�lidos.
	 * 
	 * @author EduardoProfe
	 */
	public static void lanzarNotificacion(String titulo, String mensaje, final int retrasoSegundos, int posicionNotificacion, int tipoNotificacion){
		final LookAndFeel a = UIManager.getLookAndFeel();
		try {
			ManejadorLookAndFeels.setLookAndFeel(ManejadorLookAndFeels.FLATLAF_LIGHT);
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new RSNotifyFade(titulo, mensaje, retrasoSegundos, obtenerPosicion(posicionNotificacion), obtenerTipo(tipoNotificacion)).setVisible(true);
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					Thread.sleep(retrasoSegundos*1000);
					UIManager.setLookAndFeel(a);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}).start();
		
	}
	
	private static PositionNotify obtenerPosicion(int n){
		switch(n){
		case 0:
			return PositionNotify.TopLef;
		case 1:
			return PositionNotify.TopRight;
		case 2:
			return PositionNotify.BottomLeft;
		case 3:
			return PositionNotify.BottomRight;
		default:
			return null;
		}
	}
	
	private static TypeNotify obtenerTipo(int n){
		switch(n){
		case 0:
			return TypeNotify.ERROR;
		case 1:
			return TypeNotify.WARNING;
		case 2:
			return TypeNotify.INFORMATION;
		case 3:
			return TypeNotify.SUCCESS;
		default:
			return null;
		}
	}
}
