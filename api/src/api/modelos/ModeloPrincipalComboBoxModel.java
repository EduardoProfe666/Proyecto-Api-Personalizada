package api.modelos;

import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

/**
 * Clase modelo de ComboBox abstracta a la cual solo hay que adicionarle el comportamiento de c�mo se inicializa el ComboBox. 
 * 
 * <h1>M�todos implementados:</h1>
 * ---------{@link #actualizar()}<br>
 * ---------{@link #actualizarSinInicializar()}<br>
 * ---------{@link #agregarElementos(List)}<br>
 * ---------{@link #agregarElemento(String)}<br>
 * ---------{@link #eliminarTodosLosElementos()}<br>
 * ---------{@link #eliminarElementos(List)}<br>
 * ---------{@link #eliminarElemento(String)}<br>
 * 
 * 
 * <h1>M�todos a implementar:</h1>
 * ---------{@link #inicializar()}<br>
 * 
 * @version 05/07/2023
 * @author EduardoProfe
 *
 */
public abstract class ModeloPrincipalComboBoxModel extends DefaultComboBoxModel<String>{

	private static final long serialVersionUID = 1L;
	private List<String> listado;
	
	/**
	 * Permite inicializar el comboBox .Por lo general se agrega un primer String que dice "Seleccione un nombre". 
	 * Esto es realizado con el m�todo {@link #addElement(String)}. Si no se desea agregar ning�n String, simplemente 
	 * dejar vac�o el m�todo {@link #inicializar()}.
	 */
	public abstract void inicializar();
	
	/**
	 * Permite crear un ComboBox, primeramente inicializando el componente con el m�todo {@link #inicializar()} y adicionando los 
	 * String del listado pasado.
	 * 
	 * @param listado Listado de Strings a agregar al ComboBox
	 */
	public ModeloPrincipalComboBoxModel(List<String> listado) {
		listado = new LinkedList<String>();
		if(listado!=null)
			this.listado = listado;
		actualizar();
	}
	
	/**
	 * Permite actualizar el contenido del comboBox con los elementos del listado, inicializandolo nuevamente con el metodo {@link #inicializar()}.
	 */
	public void actualizar() {
		this.removeAllElements();
		this.inicializar();
		for(String s : listado)
			this.addElement(s);
	}
	
	/**
	 * Permite actualizar el contenido del comboBox con los elementos del listado, sin la inicializacion.
	 */
	public void actualizarSinInicializar() {
		this.removeAllElements();
		for(String s : listado)
			this.addElement(s);
	}
	
	/**
	 * Permite agregar al listado del comboBox, el listado de String pasado.
	 * @param listado Listado de String a agregar
	 */
	public void agregarElementos(List<String> listado) {
		this.listado.addAll(listado);
		actualizar();
	}
	
	/**
	 * Permite agregar al listado del comboBox, el String pasado.
	 * @param s String a agregar
	 */
	public void agregarElemento(String s) {
		this.listado.add(s);
		actualizar();
	}
	
	/**
	 * Permite eliminar todos los elementos del listado.
	 */
	public void eliminarTodosLosElementos() {
		this.listado.clear();
		actualizar();
	}
	
	/**
	 * Permite eliminar el String pasado.
	 * @param s String a eliminar
	 */
	public void eliminarElemento(String s) {
		this.listado.remove(s);
		actualizar();
	}
	
	/**
	 * Permite eliminar el listado de String pasado.
	 * @param listado Listado de String a eliminar
	 */
	public void eliminarElementos(List<String> listado) {
		this.listado.removeAll(listado);
		actualizar();
	}
}
