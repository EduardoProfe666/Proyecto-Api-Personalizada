package prueba_modelo_tabla;

import java.awt.Font;
import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;



import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PruebaModeloTabla extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaPersonas;
	private ListadoTableModel modelo;
	private Principal p;
	private boolean hayDatos;

	public PruebaModeloTabla(JFrame parent) {
		super(parent,true);
		hayDatos=true;
		setTitle("Prueba ModeloPrincipalTableModel");
		Inicializadora.instanciarPrincipal();
		p = Principal.getInstancia();
		setBounds(100, 100, 920, 500);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane panelListado = new JScrollPane();
		panelListado.setBounds(15, 101, 884, 343);
		contentPane.add(panelListado);
		
		modelo = new ListadoTableModel();
		tablaPersonas = new JTable();
		tablaPersonas.getTableHeader().setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		tablaPersonas.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		tablaPersonas.setModel(modelo);
		panelListado.setViewportView(tablaPersonas);
		
		JButton eliminarBtn = new JButton("Eliminar");
		eliminarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarTabla();
			}
		});
		eliminarBtn.setBounds(764, 56, 135, 29);
		contentPane.add(eliminarBtn);
		
		JButton restaurarBtn = new JButton("Restaurar");
		restaurarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTabla();
			}
		});
		restaurarBtn.setBounds(764, 26, 135, 29);
		contentPane.add(restaurarBtn);
		
		JPanel panelOrdenar = new JPanel();
		panelOrdenar.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ordenar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOrdenar.setBounds(15, 16, 734, 69);
		contentPane.add(panelOrdenar);
		panelOrdenar.setLayout(null);
		
		JButton ordenNaturalBtn = new JButton("Natural");
		ordenNaturalBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTabla(ComparadoresPersona.getComparadorPersona(ComparadoresPersona.NULL));
			}
		});
		ordenNaturalBtn.setBounds(15, 24, 137, 29);
		panelOrdenar.add(ordenNaturalBtn);
		
		JButton ordenNombreBtn = new JButton("Nombre");
		ordenNombreBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTabla(ComparadoresPersona.getComparadorPersona(ComparadoresPersona.NOMBRE));
			}
		});
		ordenNombreBtn.setBounds(167, 24, 128, 29);
		panelOrdenar.add(ordenNombreBtn);
		
		JButton ordenarPABtn = new JButton("1 Apellido");
		ordenarPABtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTabla(ComparadoresPersona.getComparadorPersona(ComparadoresPersona.PRIMER_APELLIDO));
			}
		});
		ordenarPABtn.setBounds(310, 24, 150, 29);
		panelOrdenar.add(ordenarPABtn);
		
		JButton segundoApellidoBtn = new JButton("2 Apellido");
		segundoApellidoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTabla(ComparadoresPersona.getComparadorPersona(ComparadoresPersona.SEGUNDO_APELLIDO));
			}
		});
		segundoApellidoBtn.setBounds(475, 24, 150, 29);
		panelOrdenar.add(segundoApellidoBtn);
		
		JButton ordenarCiBtn = new JButton("CI");
		ordenarCiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTabla(ComparadoresPersona.getComparadorPersona(ComparadoresPersona.CI));
			}
		});
		ordenarCiBtn.setBounds(640, 24, 79, 29);
		panelOrdenar.add(ordenarCiBtn);
		actualizarTabla();
		setLocationRelativeTo(null);
	}
	
	public void actualizarTabla(){
		modelo.actualizar(p.getListado());
		hayDatos=true;
	}
	public void actualizarTabla(Comparator<Persona> c){
		if(hayDatos)
			modelo.actualizar(p.getListado(),c);
	}
	public void eliminarTabla(){
		modelo.eliminarFilas();
		hayDatos=false;
	}
}
