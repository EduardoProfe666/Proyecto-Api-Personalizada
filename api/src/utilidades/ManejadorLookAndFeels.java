package utilidades;

import java.awt.Component;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.birosoft.liquid.LiquidLookAndFeel;
import com.digitprop.tonic.TonicLookAndFeel;
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
import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.fast.FastLookAndFeel;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import com.jtattoo.plaf.noire.NoireLookAndFeel;
import com.jtattoo.plaf.smart.SmartLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;
import com.nilo.plaf.nimrod.NimRODLookAndFeel;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import de.muntjak.tinylookandfeel.TinyLookAndFeel;

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
	public static final int WINDOWS = 1;
	public static final int WINDOWS_CLASSIC = 2;
	public static final int CDE_MOTIF = 3;
	//FlatLaf
	public static final int FLATLAF_LIGHT = 4;
	public static final int FLATLAF_DARK = 5;
	public static final int FLATLAF_DARCULA = 6;
	public static final int FLATLAF_ARC = 7;
	public static final int FLATLAF_ARC_ORANGE = 8;
	public static final int FLATLAF_ARC_DARK = 9;
	public static final int FLATLAF_ARC_DARK_ORANGE = 10;
	public static final int FLATLAF_CARBON = 11;
	public static final int FLATLAF_COBALT2 = 12;
	public static final int FLATLAF_CYAN_LIGHT = 13;
	public static final int FLATLAF_DARK_FLAT = 14;
	public static final int FLATLAF_DARK_PURPLE = 15;
	public static final int FLATLAF_DRACULA = 16;
	public static final int FLATLAF_GRADIANTO_DARK_FUCHSIA = 17;
	public static final int FLATLAF_GRADIANTO_DEEP_OCEAN = 18;
	public static final int FLATLAF_MIDNIGHT_BLUE = 19;
	public static final int FLATLAF_NATURE_GREEN = 20;
	public static final int FLATLAF_GRAY = 21;
	public static final int FLATLAF_GRUVBOX_DARK_HARD = 22;
	public static final int FLATLAF_GRUVBOX_DARK_MEDIUM = 23;
	public static final int FLATLAF_GRUVBOX_DARK_SOFT = 24;
	public static final int FLATLAF_HIBERBEE_DARK = 25;
	public static final int FLATLAF_HIGH_CONTRAST = 26;
	public static final int FLATLAF_LIGHT_FLAT = 27;
	public static final int FLATLAF_MATERIAL_DESIGN_DARK = 28;
	public static final int FLATLAF_MONOCAI = 29;
	public static final int FLATLAF_MONOKAI_PRO = 30;
	public static final int FLATLAF_NORD = 31;
	public static final int FLATLAF_ONE_DARK = 32;
	public static final int FLATLAF_SOLARIZED_DARK = 33;
	public static final int FLATLAF_SOLARIZED_LIGHT = 34;
	public static final int FLATLAF_SPACEGRAY = 35;
	public static final int FLATLAF_VUESION = 36;
	public static final int FLATLAF_XCODE_GRAY = 37;
	//JTattoo
	public static final int JTATTOO_ACRYL = 38;
	public static final int JTATTOO_AERO = 39;
	public static final int JTATTOO_ALUMINIUM = 40;
	public static final int JTATTOO_BERNSTEIN = 41;
	public static final int JTATTOO_FAST = 42;
	public static final int JTATTOO_GRAPHITE = 43;
	public static final int JTATTOO_LUNA = 44;
	public static final int JTATTOO_MCWIN = 45;
	public static final int JTATTOO_MINT = 46;
	public static final int JTATTOO_NOIRE = 47;
	public static final int JTATTOO_SMART = 48;
	public static final int JTATTOO_TEXTURE = 49;
	//Liquid
	public static final int LIQUID = 50;
	//Nimrod
	public static final int NIMROD = 51;
	//Tiny
	public static final int TINY = 52;
	//Tonic
	public static final int TONIC = 53;
	//JGoodies
	public static final int PLASTIC = 54;
	public static final int PLASTIC3D = 55;
	public static final int WINDOWS_JGOODIES = 56;
	
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
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
			break;
		case 2:
			UIManager.setLookAndFeel(new WindowsClassicLookAndFeel());
			break;
		case 3:
			UIManager.setLookAndFeel(new MotifLookAndFeel());
			break;
		case 4:
			FlatLightLaf.setup();
			break;	 
		case 5:
			FlatDarkLaf.setup();
			break;
		case 6:
			FlatDarculaLaf.setup();
			break;
		case 7:
			FlatArcIJTheme.setup();
			break;
		case 8:
			FlatArcOrangeIJTheme.setup();
			break;
		case 9:
			FlatArcDarkIJTheme.setup();
		case 10:
			FlatArcDarkOrangeIJTheme.setup();
			break;
		case 11:
			FlatCarbonIJTheme.setup();
			break;
		case 12:
			FlatCobalt2IJTheme.setup();
			break;
		case 13:
			FlatCyanLightIJTheme.setup();
			break;
		case 14:
			FlatDarkFlatIJTheme.setup();
			break;
		case 15:
			FlatDarkPurpleIJTheme.setup();
			break;
		case 16:
			FlatDraculaIJTheme.setup();
			break;
		case 17:
			FlatGradiantoDarkFuchsiaIJTheme.setup();
			break;
		case 18:
			FlatGradiantoDeepOceanIJTheme.setup();
			break;
		case 19:
			FlatGradiantoMidnightBlueIJTheme.setup();
			break;
		case 20:
			FlatGradiantoNatureGreenIJTheme.setup();
			break;
		case 21:
			FlatGrayIJTheme.setup();
			break;
		case 22:
			FlatGruvboxDarkHardIJTheme.setup();
			break;
		case 23:
			FlatGruvboxDarkMediumIJTheme.setup();
			break;
		case 24:
			FlatGruvboxDarkSoftIJTheme.setup();
			break;
		case 25:
			FlatHiberbeeDarkIJTheme.setup();
			break;
		case 26:
			FlatHighContrastIJTheme.setup();
			break;
		case 27:
			FlatLightFlatIJTheme.setup();
			break;
		case 28:
			FlatMaterialDesignDarkIJTheme.setup();
			break;
		case 29:
			FlatMonocaiIJTheme.setup();
			break;
		case 30:
			FlatMonokaiProIJTheme.setup();
			break;
		case 31:
			FlatNordIJTheme.setup();
			break;
		case 32:
			FlatOneDarkIJTheme.setup();
			break;
		case 33:
			FlatSolarizedDarkIJTheme.setup();
			break;
		case 34:
			FlatSolarizedLightIJTheme.setup();
			break;
		case 35:
			FlatSpacegrayIJTheme.setup();
			break;
		case 36:
			FlatVuesionIJTheme.setup();
			break;
		case 37:
			FlatXcodeDarkIJTheme.setup();
			break;
		case 38:
			UIManager.setLookAndFeel(new AcrylLookAndFeel());
			break;
		case 39:
			UIManager.setLookAndFeel(new AeroLookAndFeel());
			break;
		case 40:
			UIManager.setLookAndFeel(new AluminiumLookAndFeel());
			break;
		case 41:
			UIManager.setLookAndFeel(new BernsteinLookAndFeel());
			break;
		case 42:
			UIManager.setLookAndFeel(new FastLookAndFeel());
			break;
		case 43:
			UIManager.setLookAndFeel(new GraphiteLookAndFeel());
			break;
		case 44:
			UIManager.setLookAndFeel(new LunaLookAndFeel());
			break;
		case 45:
			UIManager.setLookAndFeel(new McWinLookAndFeel());
			break;
		case 46:
			UIManager.setLookAndFeel(new MintLookAndFeel());
			break;
		case 47:
			UIManager.setLookAndFeel(new NoireLookAndFeel());
			break;
		case 48:
			UIManager.setLookAndFeel(new SmartLookAndFeel());
			break;
		case 49:
			UIManager.setLookAndFeel(new TextureLookAndFeel());
			break;
		case 50:
			UIManager.setLookAndFeel(new LiquidLookAndFeel());
			break;
		case 51:
			UIManager.setLookAndFeel(new NimRODLookAndFeel());
			break;
		case 52:
			UIManager.setLookAndFeel(new TinyLookAndFeel());
			break;
		case 53:
			UIManager.setLookAndFeel(new TonicLookAndFeel());
			break;
		case 54:
			UIManager.setLookAndFeel(new PlasticLookAndFeel());
			break;
		case 55:
			UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
			break;
		case 56:
			UIManager.setLookAndFeel(new com.jgoodies.looks.windows.WindowsLookAndFeel());
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
