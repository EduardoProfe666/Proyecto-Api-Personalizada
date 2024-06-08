package logica.modelos;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.table.DefaultTableModel;

/**
 * Clase modelo de tabla abstracta a la cual solo hay que adicionarle el comportamiento
 * de c�mo se generan nuevas filas con los elementos at�micos de la lista,
 * definir el n�mero de columnas y sus respectivos nombres en el constructor de la clase hija. Adem�s se parametriza
 * el modelo con el objeto at�mico de las listas.
 * 
 * <h1>M�todos implementados:</h1>
 * ---------{@link #eliminarFilas()}<br>
 * ---------{@link #actualizar(List)}<br>
 * ---------{@link #actualizar(List, Comparator)}<br>
 * ---------{@link #isCellEditable(int, int)}<br>
 * 
 * <h1>M�todos a implementar:</h1>
 * ---------{@link #adicionar(Object)}<br>
 * 
 * 
 * @version 15/11/2022
 * @author EduardoProfe
 *
 */

public abstract class ModeloPrincipalTableModel<T> extends DefaultTableModel{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Elimina enteramente el contenido de la tabla.
	 * 
	 * @author EduardoProfe
	 */
	public void eliminarFilas() {
		this.setRowCount(0);
	}
	
	/**
	 * 
	 * Adiciona nuevos elementos a la lista. Implemente el comportamiento
	 * de este m�todo en las clases hijas.
	 * 
	 * @param t Objeto a adicionar del tipo acorde a la parametrizaci�n escogida
	 * 
	 * @author EduardoProfe
	 */
	public abstract void adicionar(T t);
	
	/**
	 * 
	 * Actualiza el listado, orden�ndolo acorde al Comparator pasado.
	 * 
	 * @param listado Lista de objetos del tipo acorde a la parametrizaci�n escogida.
	 * @param comparador Comparator parametrizado con la misma parametrizaci�n del modelo. Si es null, 
	 * se organizar� de acuerdo al orden natural de sus elementos at�micos. Se hace la comprobaci�n
	 * de que sea instancia de Comparable, si no lo es, pues no se organiza, y simplemente
	 * tendr� la misma funcionalidad que {@link #actualizar(List)}
	 * 
	 * @author EduardoProfe
	 * 
	 */
	public void actualizar(List<T> listado, Comparator<? super T> comparador) {
		try{
			Collections.sort(listado,comparador);
		}catch(Exception e){}
		actualizar(listado);
	}
	
	/**
	 * Actualiza el listado.
	 * 
	 * @param listado Lista de objetos del tipo acorde a la parametrizaci�n escogida.
	 * 
	 * @author EduardoProfe
	 */
	public void actualizar(List<T> listado){
		if(listado!=null) {
			this.eliminarFilas();
			for(T t : listado) 
				adicionar(t);
		}
	}
	/**
	 * 
	 * Permitir� que las celdas no sean modificables. Si se desea lo contrario,
	 * sobreescibir este m�todo con el comportamiento deseado.
	 * 
	 * @return false
	 *  @author EduardoProfe
	 */
	
	@Override
	public boolean isCellEditable(int row, int column) { //
		return false;
	}
}
