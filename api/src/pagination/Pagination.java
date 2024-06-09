package pagination;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Pagination extends JPanel {

    private static final long serialVersionUID = 1L;

	public PaginationItemRender getPaginationItemRender() {
        return paginationItemRender;
    }

    public void setPaginationItemRender(PaginationItemRender paginationItemRender) {
        this.paginationItemRender = paginationItemRender;
        changePage(page.getCurrent(), page.getTotalPage());
    }

    private PaginationItemRender paginationItemRender;
    private List<EventPagination> events = new ArrayList<>();
    private Page page;

    public Pagination() {
        init();
    }

    private void init() {
        paginationItemRender = new DefaultPaginationItemRender();
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));
        setPagegination(1, 1);
    }

    private void runEvent() {
        for (EventPagination event : events) {
            event.pageChanged(page.getCurrent());
        }
    }

    private boolean isEnable(Object item) {
        return (item instanceof Page.BreakLabel || Integer.valueOf(item.toString()) != page.getCurrent());
    }

    public void addEventPagination(EventPagination event) {
        events.add(event);
    }

    public void setPagegination(int current, int totalPage) {
        if (current > totalPage) {
            current = totalPage;
        }
        if (page == null || (page.getCurrent() != current || page.getTotalPage() != totalPage)) {
            changePage(current, totalPage);
        }
    }

    private void changePage(int current, int totalPage) {
        page = paginate(current, totalPage);
        removeAll();
        refresh();
        JButton cmdPrev = paginationItemRender.createPaginationItem("Previous", true, false, page.isPrevious());
        cmdPrev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (page.getCurrent() > 1) {
                    setPagegination(page.getCurrent() - 1, totalPage);
                    runEvent();
                }
            }
        });
        add(cmdPrev);
        for (Object item : page.getItems()) {
            JButton cmd = paginationItemRender.createPaginationItem(item, false, false, isEnable(item));
            if (item instanceof Integer) {
                if (Integer.valueOf(item.toString()) == page.getCurrent()) {
                    cmd.setSelected(true);
                }
            }
            cmd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!cmd.isSelected() && item != null) {
                        if (item instanceof Page.BreakLabel) {
                            Page.BreakLabel pb = (Page.BreakLabel) item;
                            setPagegination(pb.getPage(), totalPage);
                        } else {
                            setPagegination(Integer.valueOf(item.toString()), totalPage);
                        }
                        runEvent();
                    }
                }
            });
            add(cmd);
        }
        JButton cmdNext = paginationItemRender.createPaginationItem("Next", false, true, page.isNext());
        cmdNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (page.getCurrent() < page.getTotalPage()) {
                    setPagegination(page.getCurrent() + 1, totalPage);
                    runEvent();
                }
            }
        });
        add(cmdNext);
    }

    private void refresh() {
        repaint();
        revalidate();
    }

    private Page paginate(int current, int max) {
        boolean prev = current > 1;
        boolean next = current < max;
        List<Object> items = new ArrayList<>();
        items.add(1);
        if (current == 1 && max == 1) {
            return new Page(current, prev, next, items, max);
        }
        int r = 2;
        int r1 = current - r;
        int r2 = current + r;
        if (current > 4) {
            items.add(new Page.BreakLabel((r1 > 2 ? r1 : 2) - 1));
        }
        for (int i = r1 > 2 ? r1 : 2; i <= Math.min(max, r2); i++) {
            items.add(i);
        }
        if (r2 + 1 < max) {
            items.add(new Page.BreakLabel(Integer.valueOf(items.get(items.size() - 1).toString()) + 1));
        }
        if (r2 < max) {
            items.add(max);
        }
        return new Page(current, prev, next, items, max);
    }
}
