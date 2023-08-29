package componentesVisuales;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

/**
 * 
 * Clase que modela un panel con bordes ovalados. Pueden ser equitativos, o con valores
 * diferentes para cada esquina.
 * 
 * <h1>Ver:</h1>{@link #valorEsquinaOvalID}<br>{@link #valorEsquinaOvalII}<br>{@link #valorEsquinaOvalSI}<br>{@link #valorEsquinaOvalSD}<br><br>
 * @version 28/10/2022
 * @author EduardoProfe
 */
public class PanelBordeOval extends JPanel{

	private static final long serialVersionUID = 1L;
	/**
	 * Entero que representa el valor oval de la esquina superior izquierda
	 * @author EduardoProfe
	 */
	private int valorEsquinaOvalSI;
	/**
	 * Entero que representa el valor oval de la esquina superior derecha
	 * @author EduardoProfe
	 */
	private int valorEsquinaOvalSD;
	/**
	 * Entero que representa el valor oval de la esquina inferior izquierda
	 * @author EduardoProfe
	 */
	private int valorEsquinaOvalII;
	/**
	 * Entero que representa el valor oval de la esquina inferior izquierda
	 * @author EduardoProfe
	 */
	private int valorEsquinaOvalID;

	public PanelBordeOval(int valorEsquinaOval) {
		this.setOpaque(false);
		setValorEsquinaOvalID(valorEsquinaOval);
		setValorEsquinaOvalII(valorEsquinaOval);
		setValorEsquinaOvalSD(valorEsquinaOval);
		setValorEsquinaOvalSI(valorEsquinaOval);
	}
	public PanelBordeOval(int valorEsquinaOvalSI,int valorEsquinaOvalSD,int valorEsquinaOvalII,int valorEsquinaOvalID) {
		this.setOpaque(false);
		setValorEsquinaOvalID(valorEsquinaOvalID);
		setValorEsquinaOvalII(valorEsquinaOvalII);
		setValorEsquinaOvalSD(valorEsquinaOvalSD);
		setValorEsquinaOvalSI(valorEsquinaOvalSI);
	}

	private void validarValorEsquinaOval(int valorEsquinaOval) {
		if(valorEsquinaOval<0)
			throw new IllegalArgumentException("El valor oval de la esquina del panel debe ser un número no negativo");
	}

	/**
	 * @return valorEsquinaOvalSI Valor Oval de la esquina superior izquierda
	 * @see #valorEsquinaOvalSI
	 */
	public int getValorEsquinaOvalSI() {
		return valorEsquinaOvalSI;
	}
	/**
	 * @param valorEsquinaOvalSI Valor Oval de la esquina superior izquierda
	 * @see #valorEsquinaOvalSI
	 */
	public void setValorEsquinaOvalSI(int valorEsquinaOvalSI) {
		validarValorEsquinaOval(valorEsquinaOvalSI);
		this.valorEsquinaOvalSI = valorEsquinaOvalSI;
		repaint();
	}
	/**
	 * @return valorEsquinaOvalSD Valor Oval de la esquina superior derecha
	 * @see #valorEsquinaOvalSD
	 */
	public int getValorEsquinaOvalSD() {
		return valorEsquinaOvalSD;
	}
	/**
	 * @param valorEsquinaOvalSD Valor Oval de la esquina superior derecha
	 * @see #valorEsquinaOvalSD
	 */
	public void setValorEsquinaOvalSD(int valorEsquinaOvalSD) {
		validarValorEsquinaOval(valorEsquinaOvalSD);
		this.valorEsquinaOvalSD = valorEsquinaOvalSD;
		repaint();
	}
	/**
	 * @return valorEsquinaOvalII Valor Oval de la esquina inferior izquierda
	 * @see #valorEsquinaOvalII
	 */
	public int getValorEsquinaOvalII() {
		return valorEsquinaOvalII;
	}
	/**
	 * @param valorEsquinaOvalII Valor Oval de la esquina inferior izquierda
	 * @see #valorEsquinaOvalII
	 */
	public void setValorEsquinaOvalII(int valorEsquinaOvalII) {
		validarValorEsquinaOval(valorEsquinaOvalII);
		this.valorEsquinaOvalII = valorEsquinaOvalII;
		repaint();
	}
	/**
	 * @return valorEsquinaOvalID Valor Oval de la esquina inferior derecha
	 * @see #valorEsquinaOvalID
	 */
	public int getValorEsquinaOvalID() {
		return valorEsquinaOvalID;
	}
	/**
	 * @param valorEsquinaOvalID Valor Oval de la esquina inferior derecha
	 * @see #valorEsquinaOvalID
	 */
	public void setValorEsquinaOvalID(int valorEsquinaOvalID) {
		validarValorEsquinaOval(valorEsquinaOvalID);
		this.valorEsquinaOvalID = valorEsquinaOvalID;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics gr) {
		Graphics2D g2 = (Graphics2D) gr.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(getBackground());
		Area area = crearEsquinasOvales(1);

		area.intersect(crearEsquinasOvales(0));
		area.intersect(crearEsquinasOvales(3));
		area.intersect(crearEsquinasOvales(2));
		g2.fill(area);
		g2.dispose();
		super.paintComponent(gr);
	}

	private Area crearEsquinasOvales(int esquina) {
		//esquina>> 0:Superior-Derecha, 1:Superior-Izquierda, 2:Inferior-Derecha, 3:Inferior-Izquierda
		int anchoPanel = getWidth();
		int altoPanel = getHeight();
		int ovalX = 0;
		int ovalY = 0;	

		switch(esquina) {
		case 0:
			ovalX = Math.min(anchoPanel, this.valorEsquinaOvalSD);
			ovalY = Math.min(altoPanel, this.valorEsquinaOvalSD);	
			break;
		case 1:
			ovalX = Math.min(anchoPanel, this.valorEsquinaOvalSI);
			ovalY = Math.min(altoPanel, this.valorEsquinaOvalSI);	
			break;
		case 2:
			ovalX = Math.min(anchoPanel, this.valorEsquinaOvalID);
			ovalY = Math.min(altoPanel, this.valorEsquinaOvalID);	
			break;
		case 3:
			ovalX = Math.min(anchoPanel, this.valorEsquinaOvalII);
			ovalY = Math.min(altoPanel, this.valorEsquinaOvalII);	
			break;
		default:
			throw new IllegalArgumentException("Valor no válido de esquina");
		}

		Area area = new Area(new RoundRectangle2D.Double(0, 0, anchoPanel, altoPanel, ovalX, ovalY));

		switch(esquina) {
		case 0:
			area.add(new Area(new Rectangle2D.Double(0, 0, anchoPanel - ovalX / 2.0, altoPanel)));
			area.add(new Area(new Rectangle2D.Double(0, ovalY / 2.0, anchoPanel, altoPanel - ovalY / 2.0)));
			break;
		case 1:
			area.add(new Area(new Rectangle2D.Double(ovalX / 2.0, 0, anchoPanel - ovalX / 2.0, altoPanel)));
			area.add(new Area(new Rectangle2D.Double(0, ovalY / 2.0, anchoPanel, altoPanel - ovalY / 2.0)));
			break;
		case 2:
			area.add(new Area(new Rectangle2D.Double(0, 0, anchoPanel - ovalX / 2.0, altoPanel)));
			area.add(new Area(new Rectangle2D.Double(0, 0, anchoPanel, altoPanel - ovalY / 2.0)));
			break;
		case 3:
			area.add(new Area(new Rectangle2D.Double(ovalX / 2.0, 0, anchoPanel - ovalX / 2.0, altoPanel)));
			area.add(new Area(new Rectangle2D.Double(0, 0, anchoPanel, altoPanel - ovalY / 2.0)));
			break;
		default:
			throw new IllegalArgumentException("Valor no válido de esquina");
		}

		return area;
	}
}
