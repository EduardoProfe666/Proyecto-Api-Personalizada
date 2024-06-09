package javaswingdev.drawer.scroll;

import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBar extends JScrollBar {

    private static final long serialVersionUID = 1L;

	public ScrollBar(int al) {
        super(al);
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(5, 5));
        setOpaque(false);
        setUnitIncrement(20);
    }
}
