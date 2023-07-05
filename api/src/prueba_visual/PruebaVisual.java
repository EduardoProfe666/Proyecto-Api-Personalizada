package prueba_visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import prueba_modelo_tabla.PruebaModeloTabla;
import utilidades.ManejadorLookAndFeels;
import algoritmos.Busqueda;
import algoritmos.Ordenamiento;

import componentesVisuales.AvatarCircular;
import componentesVisuales.BotonAnimacion;
import componentesVisuales.CampoCIValidado;
import componentesVisuales.Imagen;
import componentesVisuales.JLabelAnimacion;
import componentesVisuales.JLabelHora;
import componentesVisuales.JTextFieldModificado;
import componentesVisuales.Linea;
import componentesVisuales.Notificaciones;
import componentesVisuales.PanelAnimacionCurvas;
import componentesVisuales.PanelBordeOval;
import componentesVisuales.PanelGradiente;
import componentesVisuales.PanelGradienteH;
import componentesVisuales.PanelGradienteV;

/**
 * 
 * Prueba visual de la api
 * 
 * @version 04/07/2023
 * @author EduardoProfe
 *
 */

public class PruebaVisual extends JFrame {
	private List<Integer> listaN;
	private List<Integer> listaNB;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelAvatar;
	private JPanel panelBotonAnimacion;
	private JPanel panelImagen;
	private JPanel panelGradiente;
	private JPanel panelAnimacionCurvas;
	private JPanel panelBordeOval;
	private JPanel panelTexto1;
	private JPanel panelUtilsModelos;
	private AvatarCircular avatar1;
	private AvatarCircular avatar2;
	private JSpinner spinner1;
	private JLabel lblNewLabel_1;
	private JComboBox<Colores> colores1;
	private JSpinner spinner2;
	private JComboBox<Colores> colores2;
	private JToggleButton botonAnimacionCurvas;
	private PanelAnimacionCurvas panelAnimacionCurvas_1;
	private PanelBordeOval panelBordeOval_1;
	private JSlider slider1;
	private JSlider slider2;
	private JSlider slider3;
	private JSlider slider4;
	private Imagen imagen;
	private JSlider sliderAncho;
	private JSlider sliderAlto;
	private PanelGradiente gradiente1;
	private PanelGradienteV gradiente3;
	private PanelGradienteH gradiente2;
	private JComboBox<Colores> comboBox;
	private JComboBox<Colores> comboBox_1;
	private JSpinner spinnerLmt;
	private JTextFieldModificado campoMod;
	private JComboBox<String> validarComboBox;
	private JToggleButton beepButton;
	private CampoCIValidado campoCIValidado;
	private JLabel edad;
	private JLabel fechaNac;
	private JLabel sexoChar;
	private JLabel sexoString;
	private JComboBox<LookAndFeels> laf;
	private JTabbedPane tabbedPane;
	private JLabelHora hora1;
	private JLabelHora hora2;
	private JLabelHora hora3;
	private JLabelAnimacion labelAnimacion;
	private JLabel lblPruebaDeComponente_6;
	private JSeparator separator_1;
	private JSpinner retardoLetra;
	private JLabel lblTexto;
	private JTextField textField;
	private JSpinner retardoInicio;
	private JSpinner retardoFinal;
	private JTextField titulo;
	private JTextField texto1;
	private JSpinner retardoNot;
	private JComboBox<String> posicionNot;
	private JComboBox<String> tipoNot;
	private JTextField validacionPersonalizada;
	private JPanel panelLinea;
	private JSpinner posNBusqueda;
	private JSpinner cantNBusqueda;
	private JLabel bubbleSort;
	private JLabel insertionSort;
	private JLabel bucketSort;
	private JLabel selectionSort;
	private JLabel mergeSort;
	private JLabel quickSort;
	private JLabel heapSort;
	private JLabel oddEvenSort;
	private JLabel combSort;
	private JLabel timSort;
	private JLabel gnomeSort;
	private JLabel cocktailSort;
	private JLabel shellSort;
	private JLabel timSortNativo;
	private JLabel linealSearch;
	private JLabel binarySearchRecursive;
	private JLabel binarySearchNotRecursive;
	private JLabel binarySearchNativo;
	private JLabel exponentialSearch;
	private JLabel fibonacciSearch;
	private JLabel ternarySearch;

	/**
	 * Create the frame.
	 * @throws ParseException 
	 * @throws UnsupportedLookAndFeelException 
	 */
	public PruebaVisual() throws ParseException, UnsupportedLookAndFeelException {
		setResizable(false);
		setTitle("Prueba de Api ver.04/07/2022 \u00A9EduardoProfe ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		hora1 = new JLabelHora(0);
		hora2 = new JLabelHora(1);
		hora3 = new JLabelHora(2);
		labelAnimacion = new JLabelAnimacion((String) null, -1, -1, -1);
		panelAnimacionCurvas_1 = new PanelAnimacionCurvas((Color) null, (Color) null, (Color) null, (Color) null);
		botonAnimacionCurvas = new JToggleButton("Activar");
		botonAnimacionCurvas.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(botonAnimacionCurvas.isSelected()){
					panelAnimacionCurvas_1.iniciarAnimacion();
					botonAnimacionCurvas.setText("Desactivar");
				}
				else{
					botonAnimacionCurvas.setText("Activar");
					panelAnimacionCurvas_1.detenerAnimacion();
				}
			}
		});

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				requestFocus();
				if(tabbedPane.getSelectedIndex()!=4){
					botonAnimacionCurvas.setSelected(false);
				}
				if(tabbedPane.getSelectedIndex()!=7){
					hora1.detenerReloj();
					hora2.detenerReloj();
					hora3.detenerReloj();
					labelAnimacion.detenerAnimacion();
				}
				else{
					hora1.iniciarReloj();
					hora2.iniciarReloj();
					hora3.iniciarReloj();
					labelAnimacion.iniciarAnimacion();
				}
			}
		});
		tabbedPane.setFont(new Font("Dialog", Font.BOLD, 16));
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(tabbedPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
				);

		panelAvatar = new JPanel();
		tabbedPane.addTab("AvatarCircular", null, panelAvatar, null);

		JLabel lblNewLabel = new JLabel("Prueba de Componente Visual: AvatarCircular");
		lblNewLabel.setBounds(179, 16, 409, 23);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));

		avatar1 = new AvatarCircular();
		avatar1.setBounds(15, 57, 344, 300);
		avatar1.setForeground(Color.BLACK);
		avatar1.setAvatar(new ImageIcon(PruebaVisual.class.getResource("/imagenes_prueba/avatar1.jpg")));

		avatar2 = new AvatarCircular();
		avatar2.setBounds(408, 57, 345, 300);
		avatar2.setForeground(Color.BLACK);
		avatar2.setAvatar(new ImageIcon(PruebaVisual.class.getResource("/imagenes_prueba/avatar2.jpg")));

		JLabel lblTamaoBorde = new JLabel("Tama\u00F1o Borde:");
		lblTamaoBorde.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTamaoBorde.setBounds(60, 373, 143, 30);

		spinner1 = new JSpinner();
		spinner1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		spinner1.setBounds(214, 373, 100, 30);
		spinner1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				avatar1.setTamBorde(Integer.valueOf(spinner1.getValue().toString()));
			}
		});
		spinner1.setModel(new SpinnerNumberModel(0, 0, 150, 1));

		lblNewLabel_1 = new JLabel("Colores:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(87, 419, 79, 30);

		colores1 = new JComboBox<Colores>();
		colores1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		colores1.setBounds(172, 419, 142, 30);
		colores1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Colores c = (Colores) colores1.getSelectedItem();
				if(c!=null)
					avatar1.setForeground(convertirColor(c));
			}
		});
		colores1.setModel(new DefaultComboBoxModel<Colores>(Colores.values()));

		JLabel label = new JLabel("Tama\u00F1o Borde:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label.setBounds(468, 373, 137, 30);

		spinner2 = new JSpinner();
		spinner2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		spinner2.setModel(new SpinnerNumberModel(0, 0, 150, 1));
		spinner2.setBounds(611, 373, 100, 30);
		spinner2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				avatar2.setTamBorde(Integer.valueOf(spinner2.getValue().toString()));
			}
		});

		colores2 = new JComboBox<Colores>();
		colores2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		colores2.setBounds(561, 420, 150, 30);
		colores2.setModel(new DefaultComboBoxModel<Colores>(Colores.values()));
		colores2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Colores c = (Colores) colores2.getSelectedItem();
				if(c!=null)
					avatar2.setForeground(convertirColor(c));
			}
		});

		JLabel label_1 = new JLabel("Colores:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_1.setBounds(478, 420, 72, 30);
		panelAvatar.setLayout(null);
		panelAvatar.add(lblNewLabel);
		panelAvatar.add(avatar1);
		panelAvatar.add(avatar2);
		panelAvatar.add(lblTamaoBorde);
		panelAvatar.add(spinner1);
		panelAvatar.add(lblNewLabel_1);
		panelAvatar.add(colores1);
		panelAvatar.add(label);
		panelAvatar.add(spinner2);
		panelAvatar.add(label_1);
		panelAvatar.add(colores2);

		panelBotonAnimacion = new JPanel();
		tabbedPane.addTab("BotonAnimacion", null, panelBotonAnimacion, null);
		panelBotonAnimacion.setLayout(null);

		JLabel lblPruebaDeComponente = new JLabel("Prueba de Componente Visual: BotonAnimacion");
		lblPruebaDeComponente.setBounds(159, 16, 444, 23);
		lblPruebaDeComponente.setHorizontalAlignment(SwingConstants.CENTER);
		lblPruebaDeComponente.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelBotonAnimacion.add(lblPruebaDeComponente);

		BotonAnimacion botonAnimacion = new BotonAnimacion();
		botonAnimacion.setBackground(new Color(240, 248, 255));
		botonAnimacion.setBounds(47, 57, 104, 68);
		panelBotonAnimacion.add(botonAnimacion);

		BotonAnimacion botonAnimacion_1 = new BotonAnimacion();
		botonAnimacion_1.setBackground(new Color(240, 248, 255));
		botonAnimacion_1.setBounds(169, 55, 83, 153);
		panelBotonAnimacion.add(botonAnimacion_1);

		BotonAnimacion botonAnimacion_2 = new BotonAnimacion();
		botonAnimacion_2.setBackground(new Color(240, 248, 255));
		botonAnimacion_2.setBounds(81, 141, 70, 70);
		panelBotonAnimacion.add(botonAnimacion_2);

		BotonAnimacion botonAnimacion_3 = new BotonAnimacion();
		botonAnimacion_3.setColorEfecto(new Color(32, 178, 170));
		botonAnimacion_3.setBackground(new Color(0, 250, 154));
		botonAnimacion_3.setBounds(289, 54, 104, 68);
		panelBotonAnimacion.add(botonAnimacion_3);

		BotonAnimacion botonAnimacion_4 = new BotonAnimacion();
		botonAnimacion_4.setColorEfecto(new Color(32, 178, 170));
		botonAnimacion_4.setBackground(new Color(0, 250, 154));
		botonAnimacion_4.setBounds(411, 52, 83, 153);
		panelBotonAnimacion.add(botonAnimacion_4);

		BotonAnimacion botonAnimacion_5 = new BotonAnimacion();
		botonAnimacion_5.setColorEfecto(new Color(32, 178, 170));
		botonAnimacion_5.setBackground(new Color(0, 250, 154));
		botonAnimacion_5.setBounds(323, 138, 70, 70);
		panelBotonAnimacion.add(botonAnimacion_5);

		BotonAnimacion botonAnimacion_6 = new BotonAnimacion();
		botonAnimacion_6.setColorEfecto(new Color(139, 0, 0));
		botonAnimacion_6.setBackground(new Color(255, 0, 0));
		botonAnimacion_6.setBounds(543, 51, 104, 68);
		panelBotonAnimacion.add(botonAnimacion_6);

		BotonAnimacion botonAnimacion_7 = new BotonAnimacion();
		botonAnimacion_7.setColorEfecto(new Color(139, 0, 0));
		botonAnimacion_7.setBackground(new Color(255, 0, 0));
		botonAnimacion_7.setBounds(665, 49, 83, 153);
		panelBotonAnimacion.add(botonAnimacion_7);

		BotonAnimacion botonAnimacion_8 = new BotonAnimacion();
		botonAnimacion_8.setColorEfecto(new Color(139, 0, 0));
		botonAnimacion_8.setBackground(new Color(255, 0, 0));
		botonAnimacion_8.setBounds(577, 135, 70, 70);
		panelBotonAnimacion.add(botonAnimacion_8);

		BotonAnimacion botonAnimacion_9 = new BotonAnimacion();
		botonAnimacion_9.setBackground(new Color(0, 255, 255));
		botonAnimacion_9.setColorEfecto(new Color(25, 25, 112));
		botonAnimacion_9.setBounds(47, 281, 104, 68);
		panelBotonAnimacion.add(botonAnimacion_9);

		BotonAnimacion botonAnimacion_10 = new BotonAnimacion();
		botonAnimacion_10.setColorEfecto(new Color(25, 25, 112));
		botonAnimacion_10.setBackground(new Color(0, 255, 255));
		botonAnimacion_10.setBounds(169, 279, 83, 153);
		panelBotonAnimacion.add(botonAnimacion_10);

		BotonAnimacion botonAnimacion_11 = new BotonAnimacion();
		botonAnimacion_11.setColorEfecto(new Color(25, 25, 112));
		botonAnimacion_11.setBackground(new Color(0, 255, 255));
		botonAnimacion_11.setBounds(81, 365, 70, 70);
		panelBotonAnimacion.add(botonAnimacion_11);

		BotonAnimacion botonAnimacion_12 = new BotonAnimacion();
		botonAnimacion_12.setColorEfecto(new Color(138, 43, 226));
		botonAnimacion_12.setBackground(new Color(255, 0, 255));
		botonAnimacion_12.setBounds(289, 278, 104, 68);
		panelBotonAnimacion.add(botonAnimacion_12);

		BotonAnimacion botonAnimacion_13 = new BotonAnimacion();
		botonAnimacion_13.setColorEfecto(new Color(138, 43, 226));
		botonAnimacion_13.setBackground(new Color(255, 0, 255));
		botonAnimacion_13.setBounds(411, 276, 83, 153);
		panelBotonAnimacion.add(botonAnimacion_13);

		BotonAnimacion botonAnimacion_14 = new BotonAnimacion();
		botonAnimacion_14.setColorEfecto(new Color(138, 43, 226));
		botonAnimacion_14.setBackground(new Color(255, 0, 255));
		botonAnimacion_14.setBounds(323, 362, 70, 70);
		panelBotonAnimacion.add(botonAnimacion_14);

		BotonAnimacion botonAnimacion_15 = new BotonAnimacion();
		botonAnimacion_15.setBackground(new Color(119, 136, 153));
		botonAnimacion_15.setColorEfecto(new Color(25, 25, 112));
		botonAnimacion_15.setBounds(543, 283, 104, 68);
		panelBotonAnimacion.add(botonAnimacion_15);

		BotonAnimacion botonAnimacion_16 = new BotonAnimacion();
		botonAnimacion_16.setColorEfecto(new Color(25, 25, 112));
		botonAnimacion_16.setBackground(new Color(119, 136, 153));
		botonAnimacion_16.setBounds(665, 281, 83, 153);
		panelBotonAnimacion.add(botonAnimacion_16);

		BotonAnimacion botonAnimacion_17 = new BotonAnimacion();
		botonAnimacion_17.setColorEfecto(new Color(25, 25, 112));
		botonAnimacion_17.setBackground(new Color(119, 136, 153));
		botonAnimacion_17.setBounds(577, 367, 70, 70);
		panelBotonAnimacion.add(botonAnimacion_17);

		panelImagen = new JPanel();
		tabbedPane.addTab("Imagen", null, panelImagen, null);

		JLabel lblPruebaDeComponente_2 = new JLabel("Prueba de Componente Visual: Imagen");
		lblPruebaDeComponente_2.setBounds(179, 16, 404, 23);
		lblPruebaDeComponente_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPruebaDeComponente_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelImagen.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 235, 215));
		panel.setBounds(15, 48, 733, 380);
		panelImagen.add(panel);
		panel.setLayout(null);

		imagen = new Imagen((Icon) null);
		imagen.setAlpha(1.0f);
		imagen.setBounds(15, 16, 703, 348);
		imagen.setImagen(new ImageIcon(PruebaVisual.class.getResource("/imagenes_prueba/avatar1.jpg")));
		panel.add(imagen);
		panelImagen.add(lblPruebaDeComponente_2);

		sliderAncho = new JSlider();
		sliderAncho.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int aux = (703-(103+sliderAncho.getValue()))/2;
				imagen.setBounds(15+aux, imagen.getY(), 103+sliderAncho.getValue(), imagen.getHeight());
			}
		});
		sliderAncho.setMaximum(600);
		sliderAncho.setValue(600);
		sliderAncho.setBounds(15, 458, 344, 26);
		panelImagen.add(sliderAncho);

		JLabel lblNewLabel_2 = new JLabel("Ancho");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(153, 432, 69, 20);
		panelImagen.add(lblNewLabel_2);

		sliderAlto = new JSlider();
		sliderAlto.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int aux = (348-(98+sliderAlto.getValue()))/2;
				imagen.setBounds(imagen.getX(), 16+aux, imagen.getWidth(), 98+sliderAlto.getValue());
			}
		});
		sliderAlto.setMaximum(250);
		sliderAlto.setValue(250);
		sliderAlto.setBounds(404, 458, 344, 26);
		panelImagen.add(sliderAlto);

		JLabel lblAlto = new JLabel("Alto");
		lblAlto.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAlto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlto.setBounds(542, 432, 69, 20);
		panelImagen.add(lblAlto);

		final JSlider slider = new JSlider();
		slider.setMaximum(600);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				imagen.setAlpha(slider.getValue()/600f);
			}
		});
		slider.setValue(600);
		slider.setBounds(15, 16, 149, 26);
		panelImagen.add(slider);

		panelGradiente = new JPanel();
		tabbedPane.addTab("Paneles Gradientes", null, panelGradiente, null);
		panelGradiente.setLayout(null);

		gradiente1 = new PanelGradiente(Color.BLACK, Color.BLACK);
		gradiente1.setBounds(15, 55, 266, 294);
		panelGradiente.add(gradiente1);

		gradiente2 = new PanelGradienteH(Color.BLACK, Color.BLACK);
		gradiente2.setBounds(296, 55, 452, 105);
		panelGradiente.add(gradiente2);

		gradiente3 = new PanelGradienteV(Color.BLACK, Color.BLACK);
		gradiente3.setBounds(296, 176, 452, 170);
		panelGradiente.add(gradiente3);

		comboBox = new JComboBox<Colores>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Colores c = (Colores) comboBox.getSelectedItem();
				if(c!=null){
					gradiente1.setInicioGradiente(convertirColor(c));
					gradiente2.setInicioGradiente(convertirColor(c));
					gradiente3.setInicioGradiente(convertirColor(c));
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel<Colores>(Colores.values()));
		comboBox.setBounds(181, 414, 112, 30);
		panelGradiente.add(comboBox);

		JLabel lblColorGradienteA = new JLabel("Color Gradiente A:");
		lblColorGradienteA.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblColorGradienteA.setVerticalAlignment(SwingConstants.TOP);
		lblColorGradienteA.setBounds(15, 414, 165, 30);
		panelGradiente.add(lblColorGradienteA);

		JLabel lblColorGradienteB = new JLabel("Color Gradiente B:");
		lblColorGradienteB.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblColorGradienteB.setVerticalAlignment(SwingConstants.TOP);
		lblColorGradienteB.setBounds(381, 414, 165, 30);
		panelGradiente.add(lblColorGradienteB);

		comboBox_1 = new JComboBox<Colores>();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Colores c = (Colores) comboBox_1.getSelectedItem();
				if(c!=null){
					gradiente1.setFinGradiente(convertirColor(c));
					gradiente2.setFinGradiente(convertirColor(c));
					gradiente3.setFinGradiente(convertirColor(c));
				}
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel<Colores>(Colores.values()));
		comboBox_1.setBounds(550, 411, 112, 30);
		panelGradiente.add(comboBox_1);

		JLabel lblPruebaDeComponente_3 = new JLabel("Prueba de Componente Visual: PanelGradientes");
		lblPruebaDeComponente_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPruebaDeComponente_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPruebaDeComponente_3.setBounds(156, 16, 451, 23);
		panelGradiente.add(lblPruebaDeComponente_3);

		panelAnimacionCurvas = new JPanel();
		tabbedPane.addTab("PanelAnimacionCurvas", null, panelAnimacionCurvas, null);
		panelAnimacionCurvas.setLayout(null);

		JLabel lblPruebaDeComponente_4 = new JLabel("Prueba de Componente Visual: PanelAnimacionCurvas");
		lblPruebaDeComponente_4.setBounds(138, 16, 487, 23);
		lblPruebaDeComponente_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPruebaDeComponente_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelAnimacionCurvas.add(lblPruebaDeComponente_4);


		panelAnimacionCurvas_1.detenerAnimacion();
		panelAnimacionCurvas_1.setBounds(15, 53, 733, 386);
		panelAnimacionCurvas.add(panelAnimacionCurvas_1);


		botonAnimacionCurvas.setBounds(300, 455, 163, 29);
		panelAnimacionCurvas.add(botonAnimacionCurvas);

		panelBordeOval = new JPanel();
		tabbedPane.addTab("PanelBordeOval", null, panelBordeOval, null);

		JLabel lblPruebaDeComponente_5 = new JLabel("Prueba de Componente Visual: PanelBordeOval");
		lblPruebaDeComponente_5.setBounds(169, 16, 425, 23);
		lblPruebaDeComponente_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblPruebaDeComponente_5.setFont(new Font("Tahoma", Font.PLAIN, 19));

		panelBordeOval_1 = new PanelBordeOval(0
				);
		panelBordeOval_1.setBorder(null);
		panelBordeOval_1.setBounds(15, 48, 384, 253);
		panelBordeOval_1.setBackground(new Color(50, 205, 50));
		panelBordeOval.setLayout(null);
		panelBordeOval.add(lblPruebaDeComponente_5);
		panelBordeOval.add(panelBordeOval_1);

		PanelBordeOval panelBordeOval_2 = new PanelBordeOval(100);
		panelBordeOval_2.setBackground(new Color(153, 50, 204));
		panelBordeOval_2.setBounds(428, 48, 139, 176);
		panelBordeOval.add(panelBordeOval_2);

		PanelBordeOval panelBordeOval_3 = new PanelBordeOval(0);
		panelBordeOval_3.setBackground(new Color(128, 128, 0));
		panelBordeOval_3.setValorEsquinaOvalSI(200);
		panelBordeOval_3.setValorEsquinaOvalII(50);
		panelBordeOval_3.setValorEsquinaOvalID(100);
		panelBordeOval_3.setBounds(428, 240, 320, 228);
		panelBordeOval.add(panelBordeOval_3);

		PanelBordeOval panelBordeOval_4 = new PanelBordeOval(0);
		panelBordeOval_4.setValorEsquinaOvalSI(30);
		panelBordeOval_4.setValorEsquinaOvalSD(300);
		panelBordeOval_4.setValorEsquinaOvalII(90);
		panelBordeOval_4.setValorEsquinaOvalID(20);
		panelBordeOval_4.setBackground(new Color(64, 224, 208));
		panelBordeOval_4.setBounds(596, 46, 152, 178);
		panelBordeOval.add(panelBordeOval_4);

		slider1 = new JSlider();
		slider1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				panelBordeOval_1.setValorEsquinaOvalSI(slider1.getValue());
			}
		});
		slider1.setValue(0);
		slider1.setMaximum(400);
		slider1.setBounds(25, 317, 374, 26);
		panelBordeOval.add(slider1);

		slider2 = new JSlider();
		slider2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				panelBordeOval_1.setValorEsquinaOvalSD(slider2.getValue());
			}
		});
		slider2.setValue(0);
		slider2.setMaximum(400);
		slider2.setBounds(25, 359, 374, 26);
		panelBordeOval.add(slider2);

		slider3 = new JSlider();
		slider3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				panelBordeOval_1.setValorEsquinaOvalII(slider3.getValue());
			}
		});
		slider3.setValue(0);
		slider3.setMaximum(400);
		slider3.setBounds(25, 401, 374, 26);
		panelBordeOval.add(slider3);

		slider4 = new JSlider();
		slider4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				panelBordeOval_1.setValorEsquinaOvalID(slider4.getValue());
			}
		});
		slider4.setValue(0);
		slider4.setMaximum(400);
		slider4.setBounds(25, 442, 374, 26);
		panelBordeOval.add(slider4);

		panelTexto1 = new JPanel();
		tabbedPane.addTab("Texto 1", null, panelTexto1, null);
		panelTexto1.setLayout(null);

		JLabel label_4 = new JLabel("Prueba de Componente Visual: JTextFieldModificado");
		label_4.setBounds(135, 16, 492, 23);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelTexto1.add(label_4);

		campoMod = new JTextFieldModificado();
		campoMod.setFont(new Font("Tahoma", Font.PLAIN, 20));
		campoMod.setBounds(15, 66, 733, 46);
		panelTexto1.add(campoMod);

		JLabel lblLimite = new JLabel("Limite:");
		lblLimite.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblLimite.setVerticalAlignment(SwingConstants.TOP);
		lblLimite.setBounds(25, 138, 66, 30);
		panelTexto1.add(lblLimite);

		validarComboBox = new JComboBox<String>();
		validarComboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		validarComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(validarComboBox.getSelectedIndex()!=-1){
					campoMod.setText("");
					int aux = validarComboBox.getSelectedIndex();
					campoMod.setTipoValidacion(aux-1);
				}
			}
		});
		validarComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Sin Validar", "Solo Letras", "Solo Letras Espacios", "Solo D\u00EDgitos", "Solo D\u00EDgitos Espacios", "Validaci\u00F3n Personalizada", "Validaci\u00F3n Personalizada Inversa"}));
		validarComboBox.setBounds(204, 135, 350, 30);
		panelTexto1.add(validarComboBox);

		spinnerLmt = new JSpinner();
		spinnerLmt.setFont(new Font("Tahoma", Font.PLAIN, 19));
		spinnerLmt.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				campoMod.setText("");
				campoMod.setLimite(Integer.valueOf(spinnerLmt.getValue().toString()));
			}
		});
		spinnerLmt.setModel(new SpinnerNumberModel(-1, -1, 100, 1));
		spinnerLmt.setBounds(89, 135, 100, 30);
		panelTexto1.add(spinnerLmt);

		beepButton = new JToggleButton("beep");
		beepButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		beepButton.setSelected(true);
		beepButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				campoMod.setBeepActivado(beepButton.isSelected());
			}
		});
		beepButton.setBounds(569, 135, 123, 30);
		panelTexto1.add(beepButton);

		JLabel label_6 = new JLabel("Prueba de Componente Visual: CampoCIValidado");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_6.setBounds(160, 286, 443, 23);
		panelTexto1.add(label_6);

		campoCIValidado = new CampoCIValidado();
		campoCIValidado.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				actualizarCi();
			}
		});
		campoCIValidado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		campoCIValidado.setBounds(15, 325, 733, 46);
		panelTexto1.add(campoCIValidado);

		edad = new JLabel("Edad: ");
		edad.setEnabled(false);
		edad.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		edad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		edad.setBounds(69, 387, 112, 29);
		panelTexto1.add(edad);

		fechaNac = new JLabel("Fecha de Nacimiento:");
		fechaNac.setEnabled(false);
		fechaNac.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fechaNac.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		fechaNac.setBounds(69, 450, 284, 29);
		panelTexto1.add(fechaNac);

		sexoChar = new JLabel("Sexo Char:");
		sexoChar.setEnabled(false);
		sexoChar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sexoChar.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		sexoChar.setBounds(465, 391, 162, 29);
		panelTexto1.add(sexoChar);

		sexoString = new JLabel("Sexo String:");
		sexoString.setEnabled(false);
		sexoString.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sexoString.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		sexoString.setBounds(465, 454, 227, 29);
		panelTexto1.add(sexoString);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 251, 763, 2);
		panelTexto1.add(separator);

		JLabel lblValidacinPersonalizada = new JLabel("Validaci\u00F3n Personalizada:");
		lblValidacinPersonalizada.setVerticalAlignment(SwingConstants.TOP);
		lblValidacinPersonalizada.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblValidacinPersonalizada.setBounds(25, 190, 221, 30);
		panelTexto1.add(lblValidacinPersonalizada);

		validacionPersonalizada = new JTextField();
		validacionPersonalizada.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				campoMod.setValidacionPersonalizada(validacionPersonalizada.getText());
				campoMod.setText("");
			}
		});
		validacionPersonalizada.setFont(new Font("Tahoma", Font.PLAIN, 19));
		validacionPersonalizada.setBounds(243, 181, 505, 45);
		panelTexto1.add(validacionPersonalizada);
		validacionPersonalizada.setColumns(10);

		labelAnimacion.setFont(new Font("Tahoma", Font.PLAIN, 19));

		JPanel panelTexto2 = new JPanel();
		tabbedPane.addTab("Texto 2", null, panelTexto2, null);
		panelTexto2.setLayout(null);


		hora1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		hora1.setBounds(101, 66, 119, 23);
		panelTexto2.add(hora1);


		hora2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		hora2.setBounds(321, 66, 119, 23);
		panelTexto2.add(hora2);


		hora3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		hora3.setBounds(541, 66, 119, 23);
		panelTexto2.add(hora3);

		JLabel lblPruebaDeComponente_1 = new JLabel("Prueba de Componente Visual: JLabelHora");
		lblPruebaDeComponente_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPruebaDeComponente_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPruebaDeComponente_1.setBounds(135, 16, 492, 23);
		panelTexto2.add(lblPruebaDeComponente_1);


		labelAnimacion.setBounds(15, 156, 733, 32);
		panelTexto2.add(labelAnimacion);

		lblPruebaDeComponente_6 = new JLabel("Prueba de Componente Visual: JLabelAnimacion");
		lblPruebaDeComponente_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblPruebaDeComponente_6.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPruebaDeComponente_6.setBounds(135, 117, 492, 23);
		panelTexto2.add(lblPruebaDeComponente_6);

		separator_1 = new JSeparator();
		separator_1.setBounds(0, 106, 763, 10);
		panelTexto2.add(separator_1);

		JLabel lblRetardoLetra = new JLabel("Retardo Letra:");
		lblRetardoLetra.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblRetardoLetra.setBounds(15, 244, 131, 30);
		panelTexto2.add(lblRetardoLetra);

		retardoLetra = new JSpinner();
		retardoLetra.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				labelAnimacion.setRetardoLetra(Integer.valueOf(retardoLetra.getValue().toString()));
			}
		});
		retardoLetra.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
		retardoLetra.setFont(new Font("Tahoma", Font.PLAIN, 19));
		retardoLetra.setBounds(144, 244, 100, 30);
		panelTexto2.add(retardoLetra);

		JLabel lblRetardoInicio = new JLabel("Retardo Inicio:");
		lblRetardoInicio.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblRetardoInicio.setBounds(267, 244, 131, 30);
		panelTexto2.add(lblRetardoInicio);

		retardoInicio = new JSpinner();
		retardoInicio.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				labelAnimacion.setRetardoInicialTexto(Integer.valueOf(retardoInicio.getValue().toString()));
			}
		});
		retardoInicio.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
		retardoInicio.setFont(new Font("Tahoma", Font.PLAIN, 19));
		retardoInicio.setBounds(396, 244, 100, 30);
		panelTexto2.add(retardoInicio);

		JLabel lblRetardoFinal = new JLabel("Retardo Final:");
		lblRetardoFinal.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblRetardoFinal.setBounds(519, 244, 131, 30);
		panelTexto2.add(lblRetardoFinal);

		retardoFinal = new JSpinner();
		retardoFinal.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				labelAnimacion.setRetardoFinalTexto(Integer.valueOf(retardoFinal.getValue().toString()));
			}
		});
		retardoFinal.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
		retardoFinal.setFont(new Font("Tahoma", Font.PLAIN, 19));
		retardoFinal.setBounds(648, 244, 100, 30);
		panelTexto2.add(retardoFinal);

		lblTexto = new JLabel("Texto:");
		lblTexto.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTexto.setBounds(15, 198, 63, 32);
		panelTexto2.add(lblTexto);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField.getText().length()==60){
					e.consume();
				}
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				labelAnimacion.setTexto(textField.getText());
			}
		});
		textField.setBounds(75, 199, 673, 32);
		panelTexto2.add(textField);
		textField.setColumns(10);

		JPanel panelNotificaciones = new JPanel();
		tabbedPane.addTab("Notificaciones", null, panelNotificaciones, null);
		panelNotificaciones.setLayout(null);

		JLabel lblPruebaDeComponente_7 = new JLabel("Prueba de Componente Visual: Notificaciones");
		lblPruebaDeComponente_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblPruebaDeComponente_7.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPruebaDeComponente_7.setBounds(135, 114, 492, 23);
		panelNotificaciones.add(lblPruebaDeComponente_7);

		JLabel lblTitulo = new JLabel("T\u00EDtulo:");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTitulo.setBounds(15, 153, 63, 32);
		panelNotificaciones.add(lblTitulo);

		titulo = new JTextField();
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		titulo.setColumns(10);
		titulo.setBounds(75, 154, 673, 32);
		panelNotificaciones.add(titulo);

		JLabel label_3 = new JLabel("Texto:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_3.setBounds(15, 201, 63, 32);
		panelNotificaciones.add(label_3);

		texto1 = new JTextField();
		texto1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		texto1.setColumns(10);
		texto1.setBounds(75, 202, 673, 32);
		panelNotificaciones.add(texto1);

		retardoNot = new JSpinner();
		retardoNot.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
		retardoNot.setFont(new Font("Tahoma", Font.PLAIN, 19));
		retardoNot.setBounds(99, 266, 100, 30);
		panelNotificaciones.add(retardoNot);

		JLabel lblRetardo = new JLabel("Retardo:");
		lblRetardo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblRetardo.setBounds(15, 265, 83, 30);
		panelNotificaciones.add(lblRetardo);

		JButton notificar = new JButton();
		notificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int retraso = Integer.valueOf(retardoNot.getValue().toString());
				Notificaciones.lanzarNotificacion(titulo.getText(), texto1.getText(), retraso, posicionNot.getSelectedIndex(), tipoNot.getSelectedIndex());
			}
		});
		notificar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		notificar.setText("Notificaci\u00F3n");
		notificar.setBounds(556, 331, 192, 55);
		panelNotificaciones.add(notificar);

		posicionNot = new JComboBox<String>();
		posicionNot.setModel(new DefaultComboBoxModel<String>(new String[] {"Sup. Izquierda", "Sup. Derecha", "Inf. Izquierda", "Inf. Derecha"}));
		posicionNot.setSelectedIndex(0);
		posicionNot.setFont(new Font("Tahoma", Font.PLAIN, 17));
		posicionNot.setBounds(331, 266, 154, 30);
		panelNotificaciones.add(posicionNot);

		JLabel lblPosicin = new JLabel("Posici\u00F3n:");
		lblPosicin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPosicin.setBounds(243, 265, 83, 30);
		panelNotificaciones.add(lblPosicin);

		JLabel lblTipoDeNotificacin = new JLabel("Tipo:");
		lblTipoDeNotificacin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTipoDeNotificacin.setBounds(535, 265, 54, 30);
		panelNotificaciones.add(lblTipoDeNotificacin);

		tipoNot = new JComboBox<String>();
		tipoNot.setModel(new DefaultComboBoxModel<String>(new String[] {"Error", "Advertencia", "Informaci\u00F3n", "\u00C9xito"}));
		tipoNot.setSelectedIndex(0);
		tipoNot.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tipoNot.setBounds(594, 266, 154, 30);
		panelNotificaciones.add(tipoNot);

		panelLinea = new JPanel();
		tabbedPane.addTab("Lineas", null, panelLinea, null);
		panelLinea.setLayout(null);

		PanelBordeOval lineas = new PanelBordeOval(0);
		lineas.setBackground(Color.PINK);
		lineas.setValorEsquinaOvalSI(40);
		lineas.setValorEsquinaOvalSD(40);
		lineas.setValorEsquinaOvalII(40);
		lineas.setValorEsquinaOvalID(40);
		lineas.setBounds(15, 16, 733, 279);
		panelLinea.add(lineas);
		lineas.setLayout(null);

		final Linea linea = new Linea(Color.BLACK,0,0,0);
		linea.setBounds(16, 15, 702, 248);
		lineas.add(linea);

		JLabel lblPruebaDeComponente_8 = new JLabel("Prueba de Componente Visual: Linea");
		lblPruebaDeComponente_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblPruebaDeComponente_8.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPruebaDeComponente_8.setBounds(164, 0, 404, 23);
		lineas.add(lblPruebaDeComponente_8);

		JLabel lblOrientaci = new JLabel("Orientaci\u00F3n:");
		lblOrientaci.setVerticalAlignment(SwingConstants.TOP);
		lblOrientaci.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblOrientaci.setBounds(15, 311, 112, 30);
		panelLinea.add(lblOrientaci);

		final JComboBox<String> orientacionLinea = new JComboBox<String>();
		orientacionLinea.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				linea.setOrientacion(orientacionLinea.getSelectedIndex());
			}
		});
		orientacionLinea.setModel(new DefaultComboBoxModel<String>(new String[] {"Orientaci\u00F3n Vertical", "Orientaci\u00F3n Horizontal", "Orientaci\u00F3n Diagonal Izquierda", "Orientaci\u00F3n Diagonal Derecha"}));
		orientacionLinea.setFont(new Font("Tahoma", Font.PLAIN, 17));
		orientacionLinea.setBounds(126, 308, 258, 30);
		panelLinea.add(orientacionLinea);

		JLabel lblTipoDeLnea = new JLabel("Tipo de L\u00EDnea:");
		lblTipoDeLnea.setVerticalAlignment(SwingConstants.TOP);
		lblTipoDeLnea.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTipoDeLnea.setBounds(15, 360, 131, 30);
		panelLinea.add(lblTipoDeLnea);

		final JComboBox<String> tipoLinea = new JComboBox<String>();
		tipoLinea.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				linea.setTipoLinea(tipoLinea.getSelectedIndex());
			}
		});
		tipoLinea.setModel(new DefaultComboBoxModel<String>(new String[] {"Linea Continua", "Linea Discontinua"}));
		tipoLinea.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tipoLinea.setBounds(147, 357, 237, 30);
		panelLinea.add(tipoLinea);

		JLabel lblGrosor = new JLabel("Grosor:");
		lblGrosor.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblGrosor.setBounds(445, 311, 79, 30);
		panelLinea.add(lblGrosor);

		final JSpinner grosorLinea = new JSpinner();
		grosorLinea.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				linea.setGrosor(Integer.valueOf(grosorLinea.getValue().toString()));
			}
		});
		grosorLinea.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		grosorLinea.setFont(new Font("Tahoma", Font.PLAIN, 19));
		grosorLinea.setBounds(522, 311, 100, 30);
		panelLinea.add(grosorLinea);

		JLabel label_2 = new JLabel("Color:");
		label_2.setVerticalAlignment(SwingConstants.TOP);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_2.setBounds(445, 357, 60, 30);
		panelLinea.add(label_2);

		final JComboBox<Colores> colorLinea = new JComboBox<Colores>();
		colorLinea.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Colores c = (Colores) colorLinea.getSelectedItem();
				if(c!=null)
					linea.setColor(convertirColor(c));
			}
		});
		colorLinea.setFont(new Font("Tahoma", Font.PLAIN, 17));
		colorLinea.setBounds(502, 357, 160, 30);
		colorLinea.setModel(new DefaultComboBoxModel<Colores>(Colores.values()));
		panelLinea.add(colorLinea);

		JLabel lblCoordXInicial = new JLabel("Coord X Inicial:");
		lblCoordXInicial.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCoordXInicial.setBounds(15, 406, 137, 30);
		panelLinea.add(lblCoordXInicial);

		final JSpinner xInicial = new JSpinner();
		xInicial.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				linea.setBounds(Integer.valueOf(xInicial.getValue().toString()), linea.getY(), linea.getWidth(), linea.getHeight());
			}
		});
		xInicial.setModel(new SpinnerNumberModel(16, 16, 718, 1));
		xInicial.setFont(new Font("Tahoma", Font.PLAIN, 19));
		xInicial.setBounds(157, 407, 100, 30);
		panelLinea.add(xInicial);

		JLabel lblCoordYInicial = new JLabel("Coord Y Inicial:");
		lblCoordYInicial.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCoordYInicial.setBounds(15, 452, 137, 30);
		panelLinea.add(lblCoordYInicial);

		final JSpinner yInicial = new JSpinner();
		yInicial.setModel(new SpinnerNumberModel(15, 15, 263, 1));
		yInicial.setFont(new Font("Tahoma", Font.PLAIN, 19));
		yInicial.setBounds(157, 453, 100, 30);
		yInicial.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				linea.setBounds(linea.getX(), Integer.valueOf(yInicial.getValue().toString()), linea.getWidth(), linea.getHeight());
			}
		});
		panelLinea.add(yInicial);

		JLabel lblCoordXFinal = new JLabel("Coord X Final:");
		lblCoordXFinal.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCoordXFinal.setBounds(445, 403, 137, 30);
		panelLinea.add(lblCoordXFinal);

		final JSpinner xFinal = new JSpinner();
		xFinal.setModel(new SpinnerNumberModel(718, 16, 718, 1));
		xFinal.setFont(new Font("Tahoma", Font.PLAIN, 19));
		xFinal.setBounds(587, 404, 100, 30);
		xFinal.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				linea.setBounds(linea.getX(), linea.getY(), Integer.valueOf(xFinal.getValue().toString())-16, linea.getHeight());
			}
		});
		panelLinea.add(xFinal);

		JLabel lblCoordXFinal_1 = new JLabel("Coord Y Final:");
		lblCoordXFinal_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCoordXFinal_1.setBounds(445, 449, 137, 30);
		panelLinea.add(lblCoordXFinal_1);

		final JSpinner yFinal = new JSpinner();
		yFinal.setModel(new SpinnerNumberModel(263, 15, 263, 1));
		yFinal.setFont(new Font("Tahoma", Font.PLAIN, 19));
		yFinal.setBounds(587, 450, 100, 30);
		yFinal.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				linea.setBounds(linea.getX(), linea.getY(), linea.getWidth(), Integer.valueOf(yFinal.getValue().toString())-15);
			}
		});
		panelLinea.add(yFinal);

		JPanel panelOrdenamiento = new JPanel();
		tabbedPane.addTab("Ordenamiento", null, panelOrdenamiento, null);
		panelOrdenamiento.setLayout(null);

		JLabel lblPruebaDeRendimiento = new JLabel("Prueba de Rendimiento de Algoritmos de Ordenamiento");
		lblPruebaDeRendimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblPruebaDeRendimiento.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPruebaDeRendimiento.setBounds(97, 16, 568, 23);
		panelOrdenamiento.add(lblPruebaDeRendimiento);

		JLabel lblTiempoDeEjecucin = new JLabel("Tiempo de Ejecuci\u00F3n de Algoritmos (milisegundos):");
		lblTiempoDeEjecucin.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblTiempoDeEjecucin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTiempoDeEjecucin.setBounds(15, 55, 733, 23);
		panelOrdenamiento.add(lblTiempoDeEjecucin);

		JLabel lblControlDePruebas = new JLabel("Control de Pruebas:");
		lblControlDePruebas.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblControlDePruebas.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblControlDePruebas.setBounds(15, 414, 733, 23);
		panelOrdenamiento.add(lblControlDePruebas);

		JLabel lblCantDeL = new JLabel("Cant. de numeros a ordenar:");
		lblCantDeL.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCantDeL.setBounds(15, 453, 257, 30);
		panelOrdenamiento.add(lblCantDeL);

		final JSpinner cantNOrdenamiento = new JSpinner();
		cantNOrdenamiento.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ordenamiento(Integer.valueOf(cantNOrdenamiento.getValue().toString()));
			}
		});
		cantNOrdenamiento.setModel(new SpinnerNumberModel(100, 0, 600000, 1));
		cantNOrdenamiento.setFont(new Font("Tahoma", Font.PLAIN, 19));
		cantNOrdenamiento.setBounds(273, 453, 135, 30);
		panelOrdenamiento.add(cantNOrdenamiento);

		bubbleSort = new JLabel("BubbleSort: 0.000009");
		bubbleSort.setFont(new Font("Tahoma", Font.PLAIN, 19));
		bubbleSort.setBounds(15, 86, 232, 30);
		panelOrdenamiento.add(bubbleSort);

		insertionSort = new JLabel("InsertionSort: 0.000009");
		insertionSort.setFont(new Font("Tahoma", Font.PLAIN, 19));
		insertionSort.setBounds(15, 132, 232, 30);
		panelOrdenamiento.add(insertionSort);

		bucketSort = new JLabel("BucketSort: 0.000009");
		bucketSort.setFont(new Font("Tahoma", Font.PLAIN, 19));
		bucketSort.setBounds(15, 178, 232, 30);
		panelOrdenamiento.add(bucketSort);

		selectionSort = new JLabel("SelectionSort: 0.000009");
		selectionSort.setFont(new Font("Tahoma", Font.PLAIN, 19));
		selectionSort.setBounds(15, 224, 232, 30);
		panelOrdenamiento.add(selectionSort);

		mergeSort = new JLabel("MergeSort: 0.000009");
		mergeSort.setFont(new Font("Tahoma", Font.PLAIN, 19));
		mergeSort.setBounds(15, 270, 232, 30);
		panelOrdenamiento.add(mergeSort);

		quickSort = new JLabel("QuickSort: 0.000009");
		quickSort.setFont(new Font("Tahoma", Font.PLAIN, 19));
		quickSort.setBounds(15, 316, 232, 30);
		panelOrdenamiento.add(quickSort);

		heapSort = new JLabel("HeapSort: 0.000009");
		heapSort.setFont(new Font("Tahoma", Font.PLAIN, 19));
		heapSort.setBounds(15, 362, 232, 30);
		panelOrdenamiento.add(heapSort);

		shellSort = new JLabel("ShellSort: 0.000009");
		shellSort.setFont(new Font("Tahoma", Font.PLAIN, 19));
		shellSort.setBounds(252, 132, 239, 30);
		panelOrdenamiento.add(shellSort);

		cocktailSort = new JLabel("CocktailSort: 0.000009");
		cocktailSort.setFont(new Font("Tahoma", Font.PLAIN, 19));
		cocktailSort.setBounds(252, 178, 239, 30);
		panelOrdenamiento.add(cocktailSort);

		gnomeSort = new JLabel("GnomeSort: 0.000009");
		gnomeSort.setFont(new Font("Tahoma", Font.PLAIN, 19));
		gnomeSort.setBounds(252, 224, 239, 30);
		panelOrdenamiento.add(gnomeSort);

		timSort = new JLabel("TimSort: 0.000009");
		timSort.setFont(new Font("Tahoma", Font.PLAIN, 19));
		timSort.setBounds(252, 270, 239, 30);
		panelOrdenamiento.add(timSort);

		combSort = new JLabel("CombSort: 0.000009");
		combSort.setFont(new Font("Tahoma", Font.PLAIN, 19));
		combSort.setBounds(252, 316, 239, 30);
		panelOrdenamiento.add(combSort);

		oddEvenSort = new JLabel("OddEvenSort: 0.000009");
		oddEvenSort.setFont(new Font("Tahoma", Font.PLAIN, 19));
		oddEvenSort.setBounds(252, 362, 239, 30);
		panelOrdenamiento.add(oddEvenSort);

		timSortNativo = new JLabel("TimSort Nativo: 0.000009");
		timSortNativo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		timSortNativo.setBounds(252, 86, 242, 30);
		panelOrdenamiento.add(timSortNativo);

		ordenamiento(100);

		JPanel panelBusqueda = new JPanel();
		tabbedPane.addTab("Busqueda", null, panelBusqueda, null);
		panelBusqueda.setLayout(null);

		JLabel label_7 = new JLabel("Prueba de Rendimiento de Algoritmos de Busqueda");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_7.setBounds(97, 16, 568, 23);
		panelBusqueda.add(label_7);

		JLabel label_8 = new JLabel("Control de Pruebas:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_8.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		label_8.setBounds(15, 414, 733, 23);
		panelBusqueda.add(label_8);

		JLabel lblTiempoDeEjecucin_1 = new JLabel("Tiempo de Ejecuci\u00F3n de Algoritmos (milisegundos):");
		lblTiempoDeEjecucin_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTiempoDeEjecucin_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblTiempoDeEjecucin_1.setBounds(15, 55, 733, 23);
		panelBusqueda.add(lblTiempoDeEjecucin_1);

		JLabel lblCantDeNumeros = new JLabel("Cant. de numeros:");
		lblCantDeNumeros.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCantDeNumeros.setBounds(15, 453, 173, 30);
		panelBusqueda.add(lblCantDeNumeros);

		cantNBusqueda = new JSpinner();
		cantNBusqueda.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int n = Integer.valueOf(cantNBusqueda.getValue().toString());
				posNBusqueda.setModel(new SpinnerNumberModel(0, 0, n!=0 ? n-1 : 0, 1));
				listaNB = randomN(Integer.valueOf(cantNBusqueda.getValue().toString()));
				Collections.sort(listaNB);
				busqueda(Integer.valueOf(posNBusqueda.getValue().toString()));
			}
		});
		cantNBusqueda.setModel(new SpinnerNumberModel(10000, 0, 10000000, 1));
		cantNBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 19));
		cantNBusqueda.setBounds(184, 454, 135, 30);
		panelBusqueda.add(cantNBusqueda);

		JLabel lblPosNumeroA = new JLabel("Pos. numero a buscar:");
		lblPosNumeroA.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPosNumeroA.setBounds(334, 453, 208, 30);
		panelBusqueda.add(lblPosNumeroA);

		posNBusqueda = new JSpinner();
		posNBusqueda.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				busqueda(Integer.valueOf(posNBusqueda.getValue().toString()));
			}
		});
		posNBusqueda.setModel(new SpinnerNumberModel(9999, 0, 9999999, 1));
		posNBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 19));
		posNBusqueda.setBounds(540, 454, 135, 30);
		panelBusqueda.add(posNBusqueda);
		
		linealSearch = new JLabel("LinealSearch: 0.000009");
		linealSearch.setFont(new Font("Tahoma", Font.PLAIN, 19));
		linealSearch.setBounds(15, 94, 357, 30);
		panelBusqueda.add(linealSearch);
		
		binarySearchRecursive = new JLabel("BinarySearchRecursive: 0.000009");
		binarySearchRecursive.setFont(new Font("Tahoma", Font.PLAIN, 19));
		binarySearchRecursive.setBounds(15, 140, 357, 30);
		panelBusqueda.add(binarySearchRecursive);
		
		binarySearchNotRecursive = new JLabel("BinarySearchNotRecursive: 0.000009");
		binarySearchNotRecursive.setFont(new Font("Tahoma", Font.PLAIN, 19));
		binarySearchNotRecursive.setBounds(15, 186, 357, 30);
		panelBusqueda.add(binarySearchNotRecursive);
		
		binarySearchNativo = new JLabel("BinarySearchNativo: 0.000009");
		binarySearchNativo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		binarySearchNativo.setBounds(15, 232, 357, 30);
		panelBusqueda.add(binarySearchNativo);
		
		exponentialSearch = new JLabel("ExponentialSearch: 0.000009");
		exponentialSearch.setFont(new Font("Tahoma", Font.PLAIN, 19));
		exponentialSearch.setBounds(391, 94, 357, 30);
		panelBusqueda.add(exponentialSearch);
		
		fibonacciSearch = new JLabel("FibonacciSearch: 0.000009");
		fibonacciSearch.setFont(new Font("Tahoma", Font.PLAIN, 19));
		fibonacciSearch.setBounds(391, 140, 357, 30);
		panelBusqueda.add(fibonacciSearch);
		
		ternarySearch = new JLabel("TernarySearch: 0.000009");
		ternarySearch.setFont(new Font("Tahoma", Font.PLAIN, 19));
		ternarySearch.setBounds(391, 186, 357, 30);
		panelBusqueda.add(ternarySearch);
		
		listaNB = randomN(10000);
		Collections.sort(listaNB);
		busqueda(Integer.valueOf(posNBusqueda.getValue().toString()));
		
		panelUtilsModelos = new JPanel();
		tabbedPane.addTab("Utilidades-Modelos", null, panelUtilsModelos, null);

		JLabel lblPruebaDeUtilidades = new JLabel("Prueba de Utilidades y Modelos");
		lblPruebaDeUtilidades.setBounds(201, 16, 360, 23);
		lblPruebaDeUtilidades.setHorizontalAlignment(SwingConstants.CENTER);
		lblPruebaDeUtilidades.setFont(new Font("Tahoma", Font.PLAIN, 19));

		JButton tableModelBtn = new JButton("ModeloPrincipalTableModel");
		tableModelBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tableModelBtn.setBounds(15, 55, 338, 29);
		tableModelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PruebaModeloTabla a = new PruebaModeloTabla(null);
				a.setVisible(true);
			}
		});
		panelUtilsModelos.setLayout(null);
		panelUtilsModelos.add(lblPruebaDeUtilidades);
		panelUtilsModelos.add(tableModelBtn);

		JLabel lblNewLabel_3 = new JLabel("ManejadorLookAndFeels:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(15, 100, 223, 30);
		panelUtilsModelos.add(lblNewLabel_3);

		laf = new JComboBox<LookAndFeels>();
		laf.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(laf.getSelectedIndex()!=-1){
					try {
						ManejadorLookAndFeels.setLookAndFeelDinamico(laf.getSelectedIndex()-1,rootPane);
						panelAnimacionCurvas_1.detenerAnimacion();
					} catch (UnsupportedLookAndFeelException e1) {
						e1.printStackTrace();
					} 
				}
			}
		});
		laf.setFont(new Font("Tahoma", Font.PLAIN, 17));
		laf.setModel(new DefaultComboBoxModel<LookAndFeels>(LookAndFeels.values()));
		laf.setBounds(233, 100, 223, 30);
		panelUtilsModelos.add(laf);

		contentPane.setLayout(gl_contentPane);

		this.pack();
	}
	private Color convertirColor(Colores c){
		switch(c){
		case Negro:
			return Color.BLACK;
		case Blanco:
			return Color.WHITE;
		case Gris:
			return Color.GRAY;
		case Azul:
			return Color.BLUE;
		case Verde:
			return Color.GREEN;
		case Amarillo:
			return Color.YELLOW;
		case Rosado:
			return Color.PINK;
		case Morado:
			return Color.MAGENTA;
		case Cyan:
			return Color.CYAN;
		case Gris_Claro:
			return Color.LIGHT_GRAY;
		case Gris_Oscuro:
			return Color.DARK_GRAY;
		case Naranja:
			return Color.ORANGE;
		default:
			return Color.BLACK;
		}
	}
	private void actualizarCi(){
		edad.setEnabled(campoCIValidado.getCiValido());
		fechaNac.setEnabled(campoCIValidado.getCiValido());
		sexoChar.setEnabled(campoCIValidado.getCiValido());
		sexoString.setEnabled(campoCIValidado.getCiValido());
		if(campoCIValidado.getCiValido()){
			edad.setText("Edad: "+campoCIValidado.getEdad());
			fechaNac.setText("Fecha de Nacimiento: "+new SimpleDateFormat("dd/MM/yyyy").format(campoCIValidado.getFechaNacimientoCi()));
			sexoChar.setText("Sexo Char: "+campoCIValidado.getSexoChar());
			sexoString.setText("Sexo String: "+campoCIValidado.getSexoString());
		}
	}

	private void busqueda(int posN) {
		long tiempoInicio;
		long tiempoFin;
		List<Integer> lista;
		lista = listaNB;
		
		Integer buscar = lista.get(posN);
		
		
		tiempoInicio = System.nanoTime();
		Busqueda.linealSearch(lista, buscar);
		tiempoFin = System.nanoTime();
		ordenamiento("LinealSearch",linealSearch,(tiempoFin-tiempoInicio)/1e6);
		
		tiempoInicio = System.nanoTime();
		Busqueda.binarySearchRecursive(lista, buscar);
		tiempoFin = System.nanoTime();
		ordenamiento("BinarySearchRecursive",binarySearchRecursive,(tiempoFin-tiempoInicio)/1e6);
		
		tiempoInicio = System.nanoTime();
		Busqueda.binarySearchNotRecursive(lista, buscar);
		tiempoFin = System.nanoTime();
		ordenamiento("BinarySearchNotRecursive",binarySearchNotRecursive,(tiempoFin-tiempoInicio)/1e6);
		
		tiempoInicio = System.nanoTime();
		Busqueda.binarySearchNativo(lista, buscar);
		tiempoFin = System.nanoTime();
		ordenamiento("BinarySearchNativo",binarySearchNativo,(tiempoFin-tiempoInicio)/1e6);
		
		tiempoInicio = System.nanoTime();
		Busqueda.exponentialSearch(lista, buscar);
		tiempoFin = System.nanoTime();
		ordenamiento("ExponentialSearch",exponentialSearch,(tiempoFin-tiempoInicio)/1e6);
		
		tiempoInicio = System.nanoTime();
		Busqueda.fibonacciSearch(lista, buscar);
		tiempoFin = System.nanoTime();
		ordenamiento("FibonacciSearch",fibonacciSearch,(tiempoFin-tiempoInicio)/1e6);
		
		tiempoInicio = System.nanoTime();
		Busqueda.ternarySearch(lista, buscar);
		tiempoFin = System.nanoTime();
		ordenamiento("TernarySearch",ternarySearch,(tiempoFin-tiempoInicio)/1e6);
	}
	
	private void ordenamiento(int cantN) {
		listaN = randomN(cantN);
		long tiempoInicio;
		long tiempoFin;
		List<Integer> lista;

		lista = new LinkedList<>(listaN);
		tiempoInicio = System.nanoTime();
		Ordenamiento.bubbleSort(lista);
		tiempoFin = System.nanoTime();
		ordenamiento("BubbleSort",bubbleSort,(tiempoFin-tiempoInicio)/1e6);
		
		
		lista = new LinkedList<>(listaN);
		tiempoInicio = System.nanoTime();
		Ordenamiento.bubbleSort(lista);
		tiempoFin = System.nanoTime();
		ordenamiento("BubbleSort",bubbleSort,(tiempoFin-tiempoInicio)/1e6);
		
		lista = new LinkedList<>(listaN);
		tiempoInicio = System.nanoTime();
		Ordenamiento.insertionSort(lista);
		tiempoFin = System.nanoTime();
		ordenamiento("InsertionSort",insertionSort,(tiempoFin-tiempoInicio)/1e6);
		
		lista = new LinkedList<>(listaN);
		tiempoInicio = System.nanoTime();
		Ordenamiento.bucketSort(lista,new Random().nextInt(100)+1);
		tiempoFin = System.nanoTime();
		ordenamiento("BucketSort",bucketSort,(tiempoFin-tiempoInicio)/1e6);
		
		lista = new LinkedList<>(listaN);
		tiempoInicio = System.nanoTime();
		Ordenamiento.selectionSort(lista);
		tiempoFin = System.nanoTime();
		ordenamiento("SelectionSort",selectionSort,(tiempoFin-tiempoInicio)/1e6);
		
		lista = new LinkedList<>(listaN);
		tiempoInicio = System.nanoTime();
		Ordenamiento.mergeSort(lista);
		tiempoFin = System.nanoTime();
		ordenamiento("MergeSort",mergeSort,(tiempoFin-tiempoInicio)/1e6);
		
		lista = new LinkedList<>(listaN);
		tiempoInicio = System.nanoTime();
		Ordenamiento.quickSort(lista);
		tiempoFin = System.nanoTime();
		ordenamiento("QuickSort",quickSort,(tiempoFin-tiempoInicio)/1e6);
		
		lista = new LinkedList<>(listaN);
		tiempoInicio = System.nanoTime();
		Ordenamiento.heapSort(lista);
		tiempoFin = System.nanoTime();
		ordenamiento("HeapSort",heapSort,(tiempoFin-tiempoInicio)/1e6);
		
		lista = new LinkedList<>(listaN);
		tiempoInicio = System.nanoTime();
		Ordenamiento.shellSort(lista);
		tiempoFin = System.nanoTime();
		ordenamiento("ShellSort",shellSort,(tiempoFin-tiempoInicio)/1e6);
		
		
		lista = new LinkedList<>(listaN);
		tiempoInicio = System.nanoTime();
		Ordenamiento.cocktailSort(lista);
		tiempoFin = System.nanoTime();
		ordenamiento("CocktailSort",cocktailSort,(tiempoFin-tiempoInicio)/1e6);
		
		lista = new LinkedList<>(listaN);
		tiempoInicio = System.nanoTime();
		Ordenamiento.combSort(lista);
		tiempoFin = System.nanoTime();
		ordenamiento("CombSort",combSort,(tiempoFin-tiempoInicio)/1e6);
		
		lista = new LinkedList<>(listaN);
		tiempoInicio = System.nanoTime();
		Ordenamiento.gnomeSort(lista);
		tiempoFin = System.nanoTime();
		ordenamiento("GnomeSort",gnomeSort,(tiempoFin-tiempoInicio)/1e6);
		
		lista = new LinkedList<>(listaN);
		tiempoInicio = System.nanoTime();
		Ordenamiento.timSort(lista);
		tiempoFin = System.nanoTime();
		ordenamiento("TimSort",timSort,(tiempoFin-tiempoInicio)/1e6);
		
		lista = new LinkedList<>(listaN);
		tiempoInicio = System.nanoTime();
		Ordenamiento.oddEvenSort(lista);
		tiempoFin = System.nanoTime();
		ordenamiento("OddEvenSort",oddEvenSort,(tiempoFin-tiempoInicio)/1e6);
		
		lista = new LinkedList<>(listaN);
		tiempoInicio = System.nanoTime();
		Ordenamiento.timSortNativo(lista);
		tiempoFin = System.nanoTime();
		ordenamiento("TimSort Nativo",timSortNativo,(tiempoFin-tiempoInicio)/1e6);
		
	}

	private void ordenamiento(String s,JLabel j, double milisegundos){
		BigDecimal b = new BigDecimal(milisegundos);
		b = b.setScale(6, RoundingMode.HALF_DOWN);
		
		s = s.concat(": "+ b.toString());
		j.setText(s);
	}

	private static List<Integer> randomN(int cantN){
		List<Integer> l = new LinkedList<>();
		Random r = new Random();

		for(int i=0;i<cantN;i++)
			l.add(r.nextInt());

		return l;
	}
}
