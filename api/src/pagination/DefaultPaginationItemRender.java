package pagination;

import javax.swing.Icon;
import javax.swing.JButton;

public class DefaultPaginationItemRender implements PaginationItemRender {

    @Override
    public JButton createPaginationItem(Object value, boolean isPrevious, boolean isNext, boolean enable) {
        JButton cmd = createButton(value, isPrevious, isNext, enable);
        if (isPrevious) {
            Object icon = createPreviousIcon();
            if (icon != null) {
                if (icon instanceof Icon) {
                    cmd.setIcon((Icon) icon);
                } else {
                    cmd.setText(icon.toString());
                }
            }
        } else if (isNext) {
            Object icon = createNextIcon();
            if (icon != null) {
                if (icon instanceof Icon) {
                    cmd.setIcon((Icon) icon);
                } else {
                    cmd.setText(icon.toString());
                }
            }
        } else {
            cmd.setText(value.toString());
        }
        if (!enable) {
            cmd.setFocusable(false);
        }
        return cmd;
    }

    @Override
    public JButton createButton(Object value, boolean isPrevious, boolean isNext, boolean enable) {
        return new JButton();
    }

    @Override
    public Object createPreviousIcon() {
        return "Previous";
    }

    @Override
    public Object createNextIcon() {
        return "Next";
    }
}
