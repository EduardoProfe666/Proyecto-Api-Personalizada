package logica.utilidades.interfaz;

import java.awt.Component;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCobalt2IJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDraculaIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoDarkFuchsiaIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoDeepOceanIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoMidnightBlueIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoNatureGreenIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGrayIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkHardIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkMediumIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkSoftIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatHiberbeeDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatHighContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatMaterialDesignDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatMonocaiIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatMonokaiProIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatNordIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatSpacegrayIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatVuesionIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatXcodeDarkIJTheme;

/**
 * 
 * Clase que permitirá el manejo de los look and feels de forma sencilla, pudiendo incluso
 * cambiarla en tiempo de ejecución. Incorpora los lafs predeterminados, los de FlatLaf, los de JTattoo, Liquid,
 * Nimrod, Tiny, Tonic y JGoodies.
 * 
 * <h1>Ver:</h1>{@link #setLookAndFeel(int)}<br>{@link #setLookAndFeelDinamico(int, Component)}<br><br>
 * @version 24/11/2022
 * @author EduardoProfe
 *
 */

public final class ManejadorLookAndFeels {
	private ManejadorLookAndFeels() {}
	//Predeterminados
	public static final int PREDETERMINADO = -1;
	public static final int NIMBUS = 0;
	//FlatLaf
	public static final int FLATLAF_LIGHT = 1;
	public static final int FLATLAF_DARK = 2;
	public static final int FLATLAF_DARCULA = 3;
	public static final int FLATLAF_ARC = 4;
	public static final int FLATLAF_ARC_ORANGE = 5;
	public static final int FLATLAF_ARC_DARK = 6;
	public static final int FLATLAF_ARC_DARK_ORANGE = 7;
	public static final int FLATLAF_CARBON = 8;
	public static final int FLATLAF_COBALT2 = 9;
	public static final int FLATLAF_CYAN_LIGHT = 10;
	public static final int FLATLAF_DARK_FLAT = 11;
	public static final int FLATLAF_DARK_PURPLE = 12;
	public static final int FLATLAF_DRACULA = 13;
	public static final int FLATLAF_GRADIANTO_DARK_FUCHSIA = 14;
	public static final int FLATLAF_GRADIANTO_DEEP_OCEAN = 15;
	public static final int FLATLAF_MIDNIGHT_BLUE = 16;
	public static final int FLATLAF_NATURE_GREEN = 17;
	public static final int FLATLAF_GRAY = 18;
	public static final int FLATLAF_GRUVBOX_DARK_HARD = 19;
	public static final int FLATLAF_GRUVBOX_DARK_MEDIUM = 20;
	public static final int FLATLAF_GRUVBOX_DARK_SOFT = 21;
	public static final int FLATLAF_HIBERBEE_DARK = 22;
	public static final int FLATLAF_HIGH_CONTRAST = 23;
	public static final int FLATLAF_LIGHT_FLAT = 24;
	public static final int FLATLAF_MATERIAL_DESIGN_DARK = 25;
	public static final int FLATLAF_MONOCAI = 26;
	public static final int FLATLAF_MONOKAI_PRO = 27;
	public static final int FLATLAF_NORD = 28;
	public static final int FLATLAF_ONE_DARK = 29;
	public static final int FLATLAF_SOLARIZED_DARK = 30;
	public static final int FLATLAF_SOLARIZED_LIGHT = 31;
	public static final int FLATLAF_SPACEGRAY = 32;
	public static final int FLATLAF_VUESION = 33;
	public static final int FLATLAF_XCODE_GRAY = 34;
	
	/**
	 * 
	 * Método que permitirá el manejo de los look and feels referenciados. Simplemente es necesario
	 * el indice en esta clase del laf deseado. El método hará el cambio. <b>NO</b> es dinámico, es 
	 * decir, no puede ser empleado para cambiar el laf en tiempo de ejecución. Para ello, utilice
	 * {@link #setLookAndFeelDinamico(int, Component)}.
	 * 
	 * @param lookAndFeel Entero que indica el índice del look and feel deseado. Para mayor facilidad de uso, emplee las constantes 
	 * de esta clase.
	 * @throws		 UnsupportedLookAndFeelException
	 * 
	 * @author EduardoProfe
	 */
	public static void setLookAndFeel(int lookAndFeel) throws UnsupportedLookAndFeelException{
		switch(lookAndFeel){
		case -1:
			UIManager.setLookAndFeel(new MetalLookAndFeel());
			break;
		case 0:
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
			break;
		case 1:
			FlatLightLaf.setup();
			break;	 
		case 2:
			FlatDarkLaf.setup();
			break;
		case 3:
			FlatDarculaLaf.setup();
			break;
		case 4:
			FlatArcIJTheme.setup();
			break;
		case 5:
			FlatArcOrangeIJTheme.setup();
			break;
		case 6:
			FlatArcDarkIJTheme.setup();
		case 7:
			FlatArcDarkOrangeIJTheme.setup();
			break;
		case 8:
			FlatCarbonIJTheme.setup();
			break;
		case 9:
			FlatCobalt2IJTheme.setup();
			break;
		case 10:
			FlatCyanLightIJTheme.setup();
			break;
		case 11:
			FlatDarkFlatIJTheme.setup();
			break;
		case 12:
			FlatDarkPurpleIJTheme.setup();
			break;
		case 13:
			FlatDraculaIJTheme.setup();
			break;
		case 14:
			FlatGradiantoDarkFuchsiaIJTheme.setup();
			break;
		case 15:
			FlatGradiantoDeepOceanIJTheme.setup();
			break;
		case 16:
			FlatGradiantoMidnightBlueIJTheme.setup();
			break;
		case 17:
			FlatGradiantoNatureGreenIJTheme.setup();
			break;
		case 18:
			FlatGrayIJTheme.setup();
			break;
		case 19:
			FlatGruvboxDarkHardIJTheme.setup();
			break;
		case 20:
			FlatGruvboxDarkMediumIJTheme.setup();
			break;
		case 21:
			FlatGruvboxDarkSoftIJTheme.setup();
			break;
		case 22:
			FlatHiberbeeDarkIJTheme.setup();
			break;
		case 23:
			FlatHighContrastIJTheme.setup();
			break;
		case 24:
			FlatLightFlatIJTheme.setup();
			break;
		case 25:
			FlatMaterialDesignDarkIJTheme.setup();
			break;
		case 26:
			FlatMonocaiIJTheme.setup();
			break;
		case 27:
			FlatMonokaiProIJTheme.setup();
			break;
		case 28:
			FlatNordIJTheme.setup();
			break;
		case 29:
			FlatOneDarkIJTheme.setup();
			break;
		case 30:
			FlatSolarizedDarkIJTheme.setup();
			break;
		case 31:
			FlatSolarizedLightIJTheme.setup();
			break;
		case 32:
			FlatSpacegrayIJTheme.setup();
			break;
		case 33:
			FlatVuesionIJTheme.setup();
			break;
		case 34:
			FlatXcodeDarkIJTheme.setup();
			break;
		default:
			throw new IllegalArgumentException("Debe elegir un lookAndFeel correcto");
		}
	}
	
	/**
	 * 
	 * @param lookAndFeel Entero que indica el índice del look and feel deseado. Para mayor facilidad de uso, emplee las constantes 
	 * de esta clase.
	 * @param c <b>Component</b> al cual se le realizará el cambio dinámico del look and feel de él y sus componentes. Al final de cuentas, 
	 * utilícelo pasando el JFrame o el JDialog en el que se encuentre. Ej: <code>ManejadorLookAndFeels.setLookAndFeelDinamico(-1,rootPane)</code>. 
	 * @throws UnsupportedLookAndFeelException
	 * 
	 * @author EduardoProfe
	 */
	public static void setLookAndFeelDinamico(int lookAndFeel, Component c) throws UnsupportedLookAndFeelException{
		setLookAndFeel(lookAndFeel);
		SwingUtilities.updateComponentTreeUI(c);
	}
}
