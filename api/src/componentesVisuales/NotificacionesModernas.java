package componentesVisuales;

import java.awt.Color;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

import com.formdev.flatlaf.ui.FlatUIUtils;
import com.formdev.flatlaf.util.Animator;
import com.formdev.flatlaf.util.UIScale;

import raven.toast.ToastClientProperties;
import raven.toast.ui.ToastNotificationPanel;
import raven.toast.util.UIUtils;

/**
 * <!-- FlatLaf Property -->
 * <p>
 * Toast.outlineWidth                   int         0       (default)
 * Toast.iconTextGap                    int         5       (default)
 * Toast.closeButtonGap                 int         5       (default)
 * Toast.arc                            int         20      (default)
 * Toast.horizontalGap                  int         10      (default)
 * <p>
 * Toast.duration                       long        2500    (default)
 * Toast.animation                      int         200     (default)
 * Toast.animationResolution            int         5       (default)
 * Toast.animationMove                  int         10      (default)
 * Toast.minimumWidth                   int         50      (default)
 * <p>
 * Toast.shadowColor                    Color
 * Toast.shadowOpacity                  float       0.1f    (default)
 * Toast.shadowInsets                   Insets      0,0,6,6 (default)
 * <p>
 * Toast.useEffect                      boolean     true    (default)
 * Toast.effectWidth                    float       0.5f    (default)   0.5f as 50%
 * Toast.effectOpacity                  float       0.2f    (default)   0 to 1
 * Toast.effectAlignment                String      left    (default)   left, right
 * Toast.effectColor                    Color
 * Toast.success.effectColor            Color
 * Toast.info.effectColor               Color
 * Toast.warning.effectColor            Color
 * Toast.error.effectColor              Color
 * <p>
 * Toast.outlineColor                   Color
 * Toast.foreground                     Color
 * Toast.background                     Color
 * <p>
 * Toast.success.outlineColor           Color
 * Toast.success.foreground             Color
 * Toast.success.background             Color
 * Toast.info.outlineColor              Color
 * Toast.info.foreground                Color
 * Toast.info.background                Color
 * Toast.warning.outlineColor           Color
 * Toast.warning.foreground             Color
 * Toast.warning.background             Color
 * Toast.error.outlineColor             Color
 * Toast.error.foreground               Color
 * Toast.error.background               Color
 * <p>
 * Toast.frameInsets                    Insets      10,10,10,10     (default)
 * Toast.margin                         Insets      8,8,8,8         (default)
 * <p>
 * Toast.showCloseButton                boolean     true            (default)
 * Toast.closeIconColor                 Color
 *
 * <p>
 * <!-- UIManager -->
 * <p>
 * Toast.success.icon                   Icon
 * Toast.info.icon                      Icon
 * Toast.warning.icon                   Icon
 * Toast.error.icon                     Icon
 * Toast.closeIcon                      Icon
 */

/**
 * Clase que permite un sistema de notificaciones modernas. Créditos para DJ-Raven. Esta clase usa Singletone, por tanto para 
 * poder acceder a sus metodos se debe realizar de esta forma: {@code NotificacionesModernas.getInstancia()}.  
 * Las notificaciones implementan un sistema en cascada ;).<br>
 * <b>Funciona solamente en componentes con el Look and Feel de FlatLaf instalado. Es dinámico, es decir, varia en dependencia del flatlaf instalado</b><br>
 * Para poder usar las notificaciones primero instale el sistema en el {@link JFrame} donde se mostraran y luego use cualquiera de los 
 * metodos {@code show} especificados en esta clase. 
 * 
 * 
 * <h1>Ver:</h1>
 * .{@link #getInstancia()}<br>
 * .{@link #setJFrame(JFrame)}<br>
 * .{@link #show(JComponent)}<br>
 * .{@link #show(Localizacion, JComponent)}<br>
 * .{@link #show(Tipo, String)}<br>
 * .{@link #show(Localizacion, long, JComponent)}<br>
 * .{@link #show(Tipo, long, String)}<br>
 * .{@link #show(Tipo, Localizacion, String)}<br>
 * .{@link #show(Tipo, Localizacion, long, String)}<br>
 * .{@link #clear(Localizacion)}<br>
 * .{@link #clearAll()}<br>
 * .{@link Tipo}<br>
 * .{@link Localizacion}<br>
 * 
 * @version 29/08/2023
 * @author EduardoProfe
 * @author Raven
 */
public class NotificacionesModernas {

    private static NotificacionesModernas instance;
    private JFrame frame;
    private final Map<Localizacion, List<NotificationAnimation>> lists = new HashMap<>();

    private ComponentListener windowEvent;

    private void installEvent(JFrame frame) {
        if (windowEvent == null && frame != null) {
            windowEvent = new ComponentAdapter() {
                @Override
                public void componentMoved(ComponentEvent e) {
                    move(frame.getBounds());
                }

                @Override
                public void componentResized(ComponentEvent e) {
                    move(frame.getBounds());
                }
            };
        }
        if (this.frame != null) {
            this.frame.removeComponentListener(windowEvent);
        }
        if (frame != null) {
            frame.addComponentListener(windowEvent);
        }
        this.frame = frame;
    }

    public static NotificacionesModernas getInstancia() {
        if (instance == null) {
            instance = new NotificacionesModernas();
        }
        return instance;
    }

    private synchronized void move(Rectangle rectangle) {
        for (Map.Entry<Localizacion, List<NotificationAnimation>> set : lists.entrySet()) {
            for (int i = 0; i < set.getValue().size(); i++) {
                NotificationAnimation an = set.getValue().get(i);
                if (an != null) {
                    an.move(rectangle);
                }
            }
        }
    }
    
    /**
     * Permite instalar el sistema de notificaciones en el {@link JFrame} dado.
     * @param frame {@link JFrame}
     */
    public void setJFrame(JFrame frame) {
        installEvent(frame);
    }
    
    /**
     * Permite mostrar una notificacion del tipo y con el mensaje especificado. Se creara en la parte central superior del JFrame base y 
     * tendra una duracion de 2.5s. La notificacion se mostrara en el {@link JFrame} en donde se encuentra instalado el sistema. Para instalar un JFrame emplee {@link #setJFrame(JFrame)}.
     * @param type {@link Tipo} de la notificacion.
     * @param message {@link String} mensaje de la notificacion.
     */
    public void show(Tipo type, String message) {
        show(type, Localizacion.SUP_CENTRO, message);
    }
    
    /**
     * Permite mostrar una notificacion del tipo, duracion en milisegundos y con el mensaje especificado. Se creara en la parte central superior del JFrame base.
     * @param type {@link Tipo} de la notificacion. La notificacion se mostrara en el {@link JFrame} en donde se encuentra instalado el sistema. Para instalar un JFrame emplee {@link #setJFrame(JFrame)}.
     * @param duration Duracion en milisegundos de la notificacion.
     * @param message {@link String} mensaje de la notificacion.
     */
    public void show(Tipo type, long duration, String message) {
        show(type, Localizacion.SUP_CENTRO, duration, message);
    }
    
    /**
     * Permite mostrar una notificacion del tipo, localizacion y con el mensaje especificado. Se creara con una duracion de 2.5s. La notificacion se mostrara en el {@link JFrame} en donde se encuentra instalado el sistema. Para instalar un JFrame emplee {@link #setJFrame(JFrame)}.
     * @param type {@link Tipo} de la notificacion
     * @param location {@link Localizacion} de la notificacion.
     * @param message Mensaje de la notificacion.
     */
    public void show(Tipo type, Localizacion location, String message) {
        long duration = FlatUIUtils.getUIInt("Toast.duration", 2500);
        show(type, location, duration, message);
    }
    
    /**
     * Permite mostrar una notificacion del tipo, localizacion, duracion y con el mensaje especificado. 
     * La notificacion se mostrara en el {@link JFrame} en donde se encuentra instalado el sistema. Para instalar un JFrame emplee {@link #setJFrame(JFrame)}.
     * @param type {@link Tipo} de la notificacion
     * @param location {@link Localizacion} de la notificacion.
     * @param duration Duracion de la notificacion en milisegundos.
     * @param message Mensaje de la notificacion.
     */
    public void show(Tipo type, Localizacion location, long duration, String message) {
        new NotificationAnimation(type, location, message).start(duration);
    }
    
    /**
     * Permite mostrar una notificacion con el {@link JComponent} especificado. Se creara en la parte central superior del JFrame base y con una duracion de 2.5s. 
     * La notificacion se mostrara en el {@link JFrame} en donde se encuentra instalado el sistema. Para instalar un JFrame emplee {@link #setJFrame(JFrame)}.
     * @param component 
     */
    public void show(JComponent component) {
        show(Localizacion.SUP_CENTRO, component);
    }
    /**
     * Permite crear una notificacion con el {@link JComponent} especificado y en una localizacion dada. Se creara con una duracion de 2.5s. 
     * La notificacion se mostrara en el {@link JFrame} en donde se encuentra instalado el sistema. Para instalar un JFrame emplee {@link #setJFrame(JFrame)}.
     * @param location
     * @param component
     */
    public void show(Localizacion location, JComponent component) {
        long duration = FlatUIUtils.getUIInt("Toast.duration", 2500);
        show(location, duration, component);
    }
    /**
     * Permite crear una notificacion en la localizacion y con la duracion y {@link JComponent} especificado.
     * La notificacion se mostrara en el {@link JFrame} en donde se encuentra instalado el sistema. Para instalar un JFrame emplee {@link #setJFrame(JFrame)}.
     * @param location
     * @param duration
     * @param component
     */
    public void show(Localizacion location, long duration, JComponent component) {
        new NotificationAnimation(location, component).start(duration);
    }
    
    /**
     * Permite borrar todas las notificaciones almacenadas en cualquier parte de la pantalla, es decir, borrar de forma inmediata de 
     * la pantalla las notificaciones que se esten mostrando.
     */
    public void clearAll() {
        for (Map.Entry<Localizacion, List<NotificationAnimation>> set : lists.entrySet()) {
            for (int i = 0; i < set.getValue().size(); i++) {
                NotificationAnimation an = set.getValue().get(i);
                if (an != null) {
                    an.close();
                }
            }
        }
    }

    /**
     * Permite borrar las notificaciones pertenecientes a una localizacion especifica.
     * @param location {@link Localizacion} de las notificaciones a borrar.
     */
    public void clear(Localizacion location) {
        List<NotificationAnimation> list = lists.get(location);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                NotificationAnimation an = list.get(i);
                if (an != null) {
                    an.close();
                }
            }
        }
    }

    protected ToastNotificationPanel createNotification(Tipo type, String message) {
        ToastNotificationPanel toastNotificationPanel = new ToastNotificationPanel();
        toastNotificationPanel.set(type, message);
        return toastNotificationPanel;
    }

    private synchronized void updateList(Localizacion key, NotificationAnimation values, boolean add) {
        if (add) {
            if (lists.containsKey(key)) {
                lists.get(key).add(values);
            } else {
                List<NotificationAnimation> list = new ArrayList<>();
                list.add(values);
                lists.put(key, list);
            }
        } else {
            if (lists.containsKey(key)) {
                lists.get(key).remove(values);
                if (lists.get(key).isEmpty()) {
                    lists.remove(key);
                }
            }
        }
    }
    
    /**
     * Enum que permite clasificar las notificaciones. Los tipos de notificaciones actualmente soportados son:<br>
     * 1.{@link #EXITO}<br>
     * 2.{@link #INFO}<br>
     * 3.{@link #ADVERTENCIA}<br>
     * 4.{@link #ERROR}<br>
     * 
     * @author EduardoProfe
     *
     */
    public enum Tipo {
    	/**
    	 * Permite crear una notificacion de tipo exito.
    	 */
        EXITO,
        /**
         * Permite crear una notificacion de tipo informacion.
         */
        INFO,
        /**
         * Permite crear una notificacion de tipo advertencia.
         */
        ADVERTENCIA,
        /**
         * Permite crear una notificacion de tipo error.
         */
        ERROR
    }
    
    /**
     * Enum que permite posicionar las notificaciones. Las localizaciones disponibles actualmente son:
     * 1.{@link #SUP_IZQ}<br>
     * 2.{@link #SUP_DER}<br>
     * 3.{@link #SUP_CENTRO}<br>
     * 4.{@link #INF_IZQ}<br>
     * 5.{@link #INF_DER}<br>
     * 6.{@link #INF_CENTRO}
     * 
     * @author EduardoProfe
     *
     */
    public enum Localizacion {
    	/**
    	 * Permite crear una notificacion en la esquina superior izquierda del {@link JFrame} donde se encuentra instalado el sistema.
    	 */
        SUP_IZQ, 
        /**
         * Permite crear una notificacion en el centro superior del {@link JFrame} donde se encuentra instalado el sistema.
         */
        SUP_CENTRO,
        /**
         * Permite crear una notificacion en la esquina superior derecha del {@link JFrame} donde se encuentra instalado el sistema.
         */
        SUP_DER, 
        /**
         * Permite crear una notificacion en la esquina inferior izquierda del {@link JFrame} donde se encuentra instalado el sistema.
         */
        INF_IZQ, 
        /**
         * Permite crear una notificacion en el centro inferior del {@link JFrame} donde se encuentra instalado el sistema.
         */
        INF_CENTRO,
        /**
         * Permite crear una notificacion en la esquina inferior derecha del {@link JFrame} donde se encuentra instalado el sistema.
         */
        INF_DER
    }

    private class NotificationAnimation {

        private JWindow window;
        private Animator animator;
        private boolean show = true;
        private float animate;
        private int x;
        private int y;
        private Localizacion location;
        private Insets frameInsets;
        private int horizontalSpace;
        private int animationMove;
        private boolean top;
        private boolean close = false;

        @SuppressWarnings("rawtypes")
		public NotificationAnimation(Tipo type, Localizacion location, String message) {
            installDefault();
            this.location = location;
            window = new JWindow(frame);
            ToastNotificationPanel toastNotificationPanel = createNotification(type, message);
            toastNotificationPanel.putClientProperty(ToastClientProperties.TOAST_CLOSE_CALLBACK, (Consumer) o -> close());
            window.setContentPane(toastNotificationPanel);
            window.setFocusableWindowState(false);
            toastNotificationPanel.setDialog(window);
        }

        public NotificationAnimation(Localizacion location, JComponent component) {
            installDefault();
            this.location = location;
            window = new JWindow(frame);
            window.setBackground(new Color(0, 0, 0, 0));
            window.setContentPane(component);
            window.setFocusableWindowState(false);
            window.setSize(component.getPreferredSize());
        }

        private void installDefault() {
            frameInsets = UIUtils.getInsets("Toast.frameInsets", new Insets(10, 10, 10, 10));
            horizontalSpace = FlatUIUtils.getUIInt("Toast.horizontalGap", 10);
            animationMove = FlatUIUtils.getUIInt("Toast.animationMove", 10);
        }

        public void start(long duration) {
            int animation = FlatUIUtils.getUIInt("Toast.animation", 200);
            int resolution = FlatUIUtils.getUIInt("Toast.animationResolution", 5);
            animator = new Animator(animation, new Animator.TimingTarget() {
                @Override
                public void begin() {
                    if (show) {
                        updateList(location, NotificationAnimation.this, true);
                        installLocation();
                    }
                }

                @Override
                public void timingEvent(float f) {
                    animate = show ? f : 1f - f;
                    updateLocation(true);
                }

                @Override
                public void end() {
                    if (show && close == false) {
                        SwingUtilities.invokeLater(() -> {
                            new Thread(() -> {
                                sleep(duration);
                                if (close == false) {
                                    show = false;
                                    animator.start();
                                }
                            }).start();
                        });
                    } else {
                        updateList(location, NotificationAnimation.this, false);
                        window.dispose();
                    }
                }
            });
            animator.setResolution(resolution);
            animator.start();
        }

        private void installLocation() {
            Insets insets;
            Rectangle rec;
            if (frame == null) {
                insets = UIScale.scale(frameInsets);
                rec = new Rectangle(new Point(0, 0), Toolkit.getDefaultToolkit().getScreenSize());
            } else {
                insets = UIScale.scale(FlatUIUtils.addInsets(frameInsets, frame.getInsets()));
                rec = frame.getBounds();
            }
            setupLocation(rec, insets);
            window.setOpacity(0f);
            window.setVisible(true);
        }

        private void move(Rectangle rec) {
            Insets insets = UIScale.scale(FlatUIUtils.addInsets(frameInsets, frame.getInsets()));
            setupLocation(rec, insets);
        }

        private void setupLocation(Rectangle rec, Insets insets) {
            if (location == Localizacion.SUP_IZQ) {
                x = rec.x + insets.left;
                y = rec.y + insets.top;
                top = true;
            } else if (location == Localizacion.SUP_CENTRO) {
                x = rec.x + (rec.width - window.getWidth()) / 2;
                y = rec.y + insets.top;
                top = true;
            } else if (location == Localizacion.SUP_DER) {
                x = rec.x + rec.width - (window.getWidth() + insets.right);
                y = rec.y + insets.top;
                top = true;
            } else if (location == Localizacion.INF_IZQ) {
                x = rec.x + insets.left;
                y = rec.y + rec.height - (window.getHeight() + insets.bottom);
                top = false;
            } else if (location == Localizacion.INF_CENTRO) {
                x = rec.x + (rec.width - window.getWidth()) / 2;
                y = rec.y + rec.height - (window.getHeight() + insets.bottom);
                top = false;
            } else if (location == Localizacion.INF_DER) {
                x = rec.x + rec.width - (window.getWidth() + insets.right);
                y = rec.y + rec.height - (window.getHeight() + insets.bottom);
                top = false;
            }
            int am = UIScale.scale(top ? animationMove : -animationMove);
            int ly = (int) (getLocation(NotificationAnimation.this) + y + animate * am);
            window.setLocation(x, ly);
        }

        private void updateLocation(boolean loop) {
            int am = UIScale.scale(top ? animationMove : -animationMove);
            int ly = (int) (getLocation(NotificationAnimation.this) + y + animate * am);
            window.setLocation(x, ly);
            window.setOpacity(animate);
            if (loop) {
                update(this);
            }
        }

        private int getLocation(NotificationAnimation notification) {
            int height = 0;
            List<NotificationAnimation> list = lists.get(location);
            for (int i = 0; i < list.size(); i++) {
                NotificationAnimation n = list.get(i);
                if (notification == n) {
                    return height;
                }
                double v = n.animate * (list.get(i).window.getHeight() + UIScale.scale(horizontalSpace));
                height += top ? v : -v;
            }
            return height;
        }

        private void update(NotificationAnimation except) {
            List<NotificationAnimation> list = lists.get(location);
            for (int i = 0; i < list.size(); i++) {
                NotificationAnimation n = list.get(i);
                if (n != except) {
                    n.updateLocation(false);
                }
            }
        }

        public void close() {
            close = true;
            show = false;
            if (animator.isRunning()) {
                animator.stop();
            }
            animator.start();
        }

        private void sleep(long l) {
            try {
                Thread.sleep(l);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
}

