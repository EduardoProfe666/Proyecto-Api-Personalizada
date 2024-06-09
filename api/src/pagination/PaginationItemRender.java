package pagination;

import javax.swing.JButton;

public interface PaginationItemRender {

    public JButton createPaginationItem(Object value, boolean isPrevious, boolean isNext, boolean enable);

    public JButton createButton(Object value, boolean isPrevious, boolean isNext, boolean enable);

    public Object createPreviousIcon();

    public Object createNextIcon();
}
