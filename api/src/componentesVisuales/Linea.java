package componentesVisuales;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JComponent;

public class Linea extends JComponent {
    private static final long serialVersionUID = 1L;
    public static final int ORIENTACION_VERTICAL = 0;
    public static final int ORIENTACION_HORIZONTAL = 1;
    public static final int ORIENTACION_DIAGONAL_DERECHA = 2;
    public static final int ORIENTACION_DIAGONAL_IZQUIERDA = 3;
    public static final int LINEA_CONTINUA = 0;
    public static final int LINEA_DISCONTINUA = 1;
    private Color color;
    private int grosor;
    private int orientacion;
    private int tipoLinea;

    public Linea(int orientacion, int tipoLinea) {
        this(Color.BLACK, 3, orientacion, tipoLinea);
    }

    public Linea(Color color, int grosor, int orientacion, int tipoLinea) {
        this.setBounds(0, 0, 50, 50);
        this.color = color;
        this.grosor = grosor;
        this.orientacion = orientacion;
        this.tipoLinea = tipoLinea;
        this.repaint();
    }

    public int getTipoLinea() {
        return this.tipoLinea;
    }

    public void setTipoLinea(int tipoLinea) {
        this.tipoLinea = tipoLinea;
        this.repaint();
    }

    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        this.repaint();
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
        this.repaint();
    }

    public int getGrosor() {
        return this.grosor;
    }

    public void setGrosor(int grosor) {
        if (grosor < 0) {
            grosor = 0;
        }

        this.grosor = grosor;
        this.repaint();
    }

    public int getOrientacion() {
        return this.orientacion;
    }

    public void setOrientacion(int orientacion) {
        this.orientacion = orientacion;
        this.repaint();
    }

    protected void paintComponent(Graphics g) {
        RenderingHints pistaRenderizacion = new RenderingHints(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        pistaRenderizacion.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        pistaRenderizacion.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        pistaRenderizacion.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        pistaRenderizacion.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHints(pistaRenderizacion);
        super.paintComponent(g2);
        g2.setColor(this.color);
        g2.setStroke(new BasicStroke((float)this.grosor, 1, 1, 5.0F, this.tipoLinea == 1 ? this.patronLineaDiscontinua() : null, 0.0F));
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        Rectangle r = this.getBounds();
        switch (this.orientacion) {
            case 0:
                x1 = this.grosor;
                y1 = 0;
                x2 = this.grosor;
                y2 = r.height;
                break;
            case 1:
                x1 = 0;
                y1 = this.grosor;
                x2 = r.width;
                y2 = this.grosor;
                break;
            case 2:
                x1 = 0;
                y1 = r.height;
                x2 = r.width;
                y2 = 0;
                break;
            case 3:
                x1 = 0;
                y1 = 0;
                x2 = r.width;
                y2 = r.height;
        }

        g2.drawLine(x1, y1, x2, y2);
    }

    protected float[] patronLineaDiscontinua() {
        return new float[]{6.0F, 6.0F};
    }
}
