package api.algoritmos;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * 
 * Clase que contiene implementaciones de algunos de los m�todos de b�squeda m�s usados, dada una lista de elementos y el elemento a 
 * encontrar. Los elementos deben implementar la interfaz Comparable para poder realizar el algoritmo.
 * 
 * <h1>M�todos implementados:</h1>
 * 1.--{@link #linealSearch(List, Comparable)}<br>
 * 2.--{@link #binarySearchNativo(List, Comparable)}<br>
 * 3.--{@link #binarySearchNotRecursive(List, Comparable)}<br>
 * 4.--{@link #binarySearchRecursive(List, Comparable)}<br>
 * 5.--{@link #fibonacciSearch(List, Comparable)}<br>
 * 6.--{@link #ternarySearch(List, Comparable)}<br>
 * 7.--{@link #exponentialSearch(List, Comparable)}<br>
 * 
 * @version 04/07/2023
 * @author EduardoProfe
 *
 */
public final class Busqueda {
	private Busqueda() {}
	
	/**
	 * <b>Descripci�n:</b><br>
	 * Algoritmo de b�squeda que modela la b�squeda lineal o secuencial. Este algoritmo es un m�todo simple 
	 * para buscar un elemento en una lista de elementos. Funciona recorriendo la lista de elementos uno por uno, 
	 * comparando cada elemento con el valor de b�squeda hasta que se encuentra una coincidencia o se recorre toda la lista. 
	 * Para el funcionamiento correcto no es necesario que la lista est� ordenada. Este algoritmo es simple de implementar, y 
	 * es �til para listas peque�as o no ordenadas. 
	 * <br><br><b>Funcionamiento:</b><br>
	 * El proceso comienza comparando el primer elemento de la lista con el valor de b�squeda. Si son iguales, se devuelve la 
	 * posici�n del primer elemento como resultado de la b�squeda. Si no son iguales, el siguiente elemento de la lista se 
	 * compara con el valor de b�squeda y as� sucesivamente hasta que se encuentra una coincidencia o se recorre toda la lista. 
	 * Si se recorre toda la lista y no se encuentra una coincidencia, se devuelve un valor indicando que el elemento no se 
	 * encuentra en la lista.
	 * 
	 * @param lista Lista de elementos
	 * @param buscar Elemento a encontrar
	 * @return El �ndice del elemento a encontrar en la lista dada, o -1 si no fue encontrado.
	 */
	public static <T extends Comparable<? super T>> int linealSearch(List<T> lista, T buscar) {
		int indice = -1;
		ListIterator<T> iter = lista.listIterator();

		while(iter.hasNext() && indice==-1) {
			int index = iter.nextIndex();
			T elemento = iter.next();

			if(elemento.compareTo(buscar)==0)
				indice = index;
		}
		return indice;
	}

	/**
	 * Algoritmo de b�squeda que utiliza la b�squeda binaria nativa de {@link Collections}.
	 *   
	 * 
	 * @param lista Lista de elementos
	 * @param buscar Elemento a encontrar
	 * @return El �ndice del elemento a encontrar en la lista dada, o -1 si no fue encontrado.
	 */
	public static <T extends Comparable<? super T>> int binarySearchNativo(List<T> lista, T buscar) {
		return Collections.binarySearch(lista, buscar);
	}
	
	/**
	 * <b>Descripci�n:</b><br>
	 * Algoritmo de b�squeda que modela la b�squeda binaria no recursiva. Este algoritmo es un metodo eficiente para 
	 * buscar un elemento en una lista ordenada. El algoritmo funciona dividiendo repetidamente la lista en dos mitades y 
	 * descartando la mitad donde no se encuentra el elemento buscado. Es eficiente para listas grandes y ordenadas, ya que reduce 
	 * el n�mero de comparaciones necesarias para encontrar el elemento buscado. Es ligeramente m�s eficiente que la implementaci�n recursiva en 
	 * cuesti�n de gesti�n de recursos de memoria.  
	 * <br><br><b>Funcionamiento:</b><br>
	 * El proceso comienza comparando el elemento medio de la lista con el valor de b�squeda. Si son iguales, se devuelve 
	 * la posici�n del elemento medio como resultado de la b�squeda. Si el valor de b�squeda es menor que el elemento medio, 
	 * se descarta la mitad derecha de la lista y se contin�a la b�squeda en la mitad izquierda. Si el valor de b�squeda 
	 * es mayor que el elemento medio, se descarta la mitad izquierda de la lista y se contin�a la b�squeda en la mitad 
	 * derecha. Este proceso se repite hasta que se encuentra el elemento buscado o hasta que la lista se reduce a una 
	 * sola posici�n. Si se reduce la lista a una sola posici�n y el elemento en esa posici�n no coincide con el valor 
	 * de b�squeda, se devuelve un valor indicando que el elemento no se encuentra en la lista.
	 * 
	 * @param lista Lista de elementos
	 * @param buscar Elemento a encontrar
	 * @return El �ndice del elemento a encontrar en la lista dada, o -1 si no fue encontrado.
	 */
	public static <T extends Comparable<? super T>> int binarySearchNotRecursive(List<T> lista, T buscar) {
		int low = 0;
		int high = lista.size() - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			int cmp = buscar.compareTo(lista.get(mid));
			if (cmp < 0) {
				high = mid - 1;
			} else if (cmp > 0) {
				low = mid + 1;
			} else {
				return mid; // key found
			}
		}

		return -(low + 1);  // key not found
	}
	
	/**
	 * <b>Descripci�n:</b><br>
	 * Algoritmo de b�squeda que modela la b�squeda binaria recursiva. Este algoritmo es un metodo eficiente para 
	 * buscar un elemento en una lista ordenada. El algoritmo funciona dividiendo repetidamente la lista en dos mitades y 
	 * descartando la mitad donde no se encuentra el elemento buscado. Es eficiente para listas grandes y ordenadas, ya que reduce 
	 * el n�mero de comparaciones necesarias para encontrar el elemento buscado. 
	 * <br><br><b>Funcionamiento:</b><br>
	 * El proceso comienza comparando el elemento medio de la lista con el valor de b�squeda. Si son iguales, se devuelve 
	 * la posici�n del elemento medio como resultado de la b�squeda. Si el valor de b�squeda es menor que el elemento medio, 
	 * se descarta la mitad derecha de la lista y se contin�a la b�squeda en la mitad izquierda. Si el valor de b�squeda 
	 * es mayor que el elemento medio, se descarta la mitad izquierda de la lista y se contin�a la b�squeda en la mitad 
	 * derecha. Este proceso se repite hasta que se encuentra el elemento buscado o hasta que la lista se reduce a una 
	 * sola posici�n. Si se reduce la lista a una sola posici�n y el elemento en esa posici�n no coincide con el valor 
	 * de b�squeda, se devuelve un valor indicando que el elemento no se encuentra en la lista.
	 * 
	 * @param lista Lista de elementos
	 * @param buscar Elemento a encontrar
	 * @return El �ndice del elemento a encontrar en la lista dada, o -1 si no fue encontrado.
	 */
	public static <T extends Comparable<? super T>> int binarySearchRecursive(List<T> lista, T buscar) {
		return binarySearchRecursive(lista, buscar, 0, lista.size() - 1);
	}
	
	/**
	 * <b>Descripci�n:</b><br>
	 * Algoritmo de b�squeda que modela la b�squeda exponencial. Este algoritmo es un metodo de busqueda en listas ordenadas que 
	 * se basa en la estrategia de busqueda binaria. La principal diferencia es que, en lugar de dividir la lista en dos partes 
	 * iguales, se divide en partes exponenciales, lo que permite reducir el n�mero de comparaciones necesarias en ciertos casos. Es 
	 * m�s eficiente que el algoritmo de busqueda binaria en casos donde el elemento buscado est� cerca del inicio de la lista, ya que 
	 * reduce el numero de comparaciones necesarias. Sin embargo, si el elemento buscado no se encuentra en la lista o al final de la 
	 * misma, puede ser menos eficiente que la busqueda binaria.
	 * <br><br><b>Funcionamiento:</b><br>
	 * El proceso comienza comparando el primer elemento de la lista con el valor de b�squeda. Si son iguales, se devuelve 
	 * la posici�n del primer elemento como resultado de la b�squeda. Si el valor de b�squeda es mayor que el primer elemento, 
	 * se duplica el tama�o del paso y se busca otra vez. Si el valor de b�squeda es menor que el primer elemento, se establece 
	 * el tama�o del paso como la mitad del �ndice actual, se busca en la lista de la posici�n 0 a la posici�n actual menos el 
	 * tama�o del paso, y se repite el proceso hasta que se encuentra el elemento buscado o hasta que se reduce el tama�o del 
	 * paso a 1. Si se reduce el tama�o del paso a 1 y el elemento en esa posici�n no coincide con el valor de b�squeda, se 
	 * devuelve un valor indicando que el elemento no se encuentra en la lista.
	 * 
	 * @param lista Lista de elementos
	 * @param buscar Elemento a encontrar
	 * @return El �ndice del elemento a encontrar en la lista dada, o -1 si no fue encontrado.
	 */
	public static <T extends Comparable<? super T>> int exponentialSearch(List<T> lista, T buscar) {
		int n = lista.size();
		if (lista.get(0).equals(buscar)) {
			return 0;
		}
		int i = 1;
		while (i < n && lista.get(i).compareTo(buscar) <= 0) {
			i *= 2;
		}
		return binarySearchNotRecursive(lista, buscar, i/2, Math.min(i, n-1));
	}
	
	/**
	 * <b>Descripci�n:</b><br>
	 * Algoritmo de b�squeda que modela la b�squeda Fibonacci. Este algoritmo es un metodo de busqueda en una lista ordenada que se 
	 * basa en la secuencia de Fibonacci para determinar los �ndices de los elementos a comparar. Es similar al algoritmo de busqueda 
	 * binaria, pero en lugar de dividir en dos partes iguales, divide la lista en partes cuyas longitudes estan basadas en la secuencia 
	 * Fibonacci. Es menos eficiente que el algoritmo de busqueda binaria en ciertos casos. Es especialmente util cuando la lista es grande 
	 * y no se sabe con certeza la posicion del elemento buscado. 
	 * <br><br><b>Funcionamiento:</b><br>
	 * El proceso comienza definiendo dos n�meros de la secuencia de Fibonacci, F(n-2) y F(n-1), que sean menores o iguales 
	 * al tama�o de la lista. Luego, se compara el elemento en la posici�n F(n-2) con el valor de b�squeda. Si son iguales, 
	 * se devuelve la posici�n correspondiente. Si el valor de b�squeda es mayor que el elemento en la posici�n F(n-2), se 
	 * busca en la sublista que comienza en la posici�n F(n-1) y se reduce la secuencia de Fibonacci a F(n-3), F(n-4), 
	 * F(n-5),..., F(1), F(0). Si el valor de b�squeda es menor que el elemento en la posici�n F(n-2), se busca en la 
	 * sublista que comienza en la posici�n 0 y se reduce la secuencia de Fibonacci a F(n-4), F(n-5), F(n-6), ..., F(1), F(0). 
	 * Este proceso se repite hasta que se encuentra el elemento buscado o hasta que la sublista se reduce a una sola posici�n. 
	 * Si se reduce la sublista a una sola posici�n y el elemento en esa posici�n no coincide con el valor de b�squeda, se 
	 * devuelve un valor indicando que el elemento no se encuentra en la lista.
	 * 
	 * @param lista Lista de elementos
	 * @param buscar Elemento a encontrar
	 * @return El �ndice del elemento a encontrar en la lista dada, o -1 si no fue encontrado.
	 */
	public static <T extends Comparable<? super T>> int fibonacciSearch(List<T> lista, T buscar) {
		int n = lista.size();
		int fibM2 = 0;
		int fibM1 = 1;
		int fibM = fibM2 + fibM1;
		while (fibM < n) {
			fibM2 = fibM1;
			fibM1 = fibM;
			fibM = fibM2 + fibM1;
		}
		int offset = -1;
		while (fibM > 1) {
			int i = Math.min(offset+fibM2, n-1);
			if (lista.get(i).compareTo(buscar) < 0) {
				fibM = fibM1;
				fibM1 = fibM2;
				fibM2 = fibM - fibM1;
				offset = i;
			} else if (lista.get(i).compareTo(buscar) > 0) {
				fibM = fibM2;
				fibM1 = fibM1 - fibM2;
				fibM2 = fibM - fibM1;
			} else {
				return i;
			}
		}
		if (fibM1 == 1 && lista.get(offset+1).equals(buscar)) {
			return offset+1;
		}
		return -1;
	}
	
	/**
	 * <b>Descripci�n:</b><br>
	 * Algoritmo de b�squeda que modela la b�squeda ternaria. Este algoritmo es un metodo de busqueda en una lista 
	 * ordenada que se basa en la divisi�n de la lista en tres partes iguales en lugar de dos partes como en la b�squeda binaria. 
	 * Es util cuando se busca un elemento en una lista grande. Comparado con la b�squeda binaria, el n�mero de comparaciones 
	 * necesarias para encontrar el elemento buscado puede ser menor en ciertos casos. Sin embargo, el algoritmo de b�squeda 
	 * ternaria puede ser menos eficiente que la b�squeda binaria cuando se busca en una lista peque�a. Esta es una implementaci�n 
	 * no recursiva del algoritmo por lo que emplea menos memoria.
	 * <br><br><b>Funcionamiento:</b><br>
	 * El proceso comienza comparando el valor de b�squeda con el elemento en el tercio inferior de la lista. Si son 
	 * iguales, se devuelve la posici�n del elemento. Si el valor de b�squeda es menor que el elemento en el tercio inferior, 
	 * se busca en la sublista que comienza en la posici�n 0 y termina en la posici�n del tercio inferior menos uno. Si el valor 
	 * de b�squeda es mayor que el elemento en el tercio superior, se busca en la sublista que comienza en la posici�n del tercio 
	 * superior m�s uno y termina en la �ltima posici�n de la lista. Si el valor de b�squeda est� entre el tercio inferior y el 
	 * tercio medio, se busca en la sublista que comienza en la posici�n del tercio inferior m�s uno y termina en la posici�n del 
	 * tercio medio menos uno. Si el valor de b�squeda est� entre el tercio medio y el tercio superior, se busca en la sublista 
	 * que comienza en la posici�n del tercio medio m�s uno y termina en la posici�n del tercio superior menos uno. Este proceso 
	 * se repite hasta que se encuentra el elemento buscado o hasta que la sublista se reduce a una sola posici�n. 
	 * Si se reduce la sublista a una sola posici�n y el elemento en esa posici�n no coincide con el valor de b�squeda, se 
	 * devuelve un valor indicando que el elemento no se encuentra en la lista.
	 * 
	 * @param lista Lista de elementos
	 * @param buscar Elemento a encontrar
	 * @return El �ndice del elemento a encontrar en la lista dada, o -1 si no fue encontrado.
	 */
	public static <T extends Comparable<? super T>> int ternarySearch(List<T> lista, T buscar) {
		int left = 0;
		int right = lista.size() - 1;
		while (left <= right) {
			int mid1 = left + (right - left) / 3;
			int mid2 = right - (right - left) / 3;
			if (lista.get(mid1).equals(buscar)) {
				return mid1;
			} else if (lista.get(mid2).equals(buscar)) {
				return mid2;
			} else if (lista.get(mid1).compareTo(buscar) > 0) {
				right = mid1 - 1;
			} else if (lista.get(mid2).compareTo(buscar) < 0) {
				left = mid2 + 1;
			} else {
				left = mid1 + 1;
				right = mid2 - 1;
			}
		}
		return -1;
	}

	




	//Metodos Auxiliares
	private static <T extends Comparable<? super T>> int binarySearchRecursive(List<T> list, T key, int low, int high) {
		if (low > high) {
			return -(low + 1);  // key not found
		}

		int mid = (low + high) / 2;
		int cmp = key.compareTo(list.get(mid));
		if (cmp < 0) {
			return binarySearchRecursive(list, key, low, mid - 1);
		} else if (cmp > 0) {
			return binarySearchRecursive(list, key, mid + 1, high);
		} else {
			return mid;  // key found
		}
	}

	private static <T extends Comparable<? super T>> int binarySearchNotRecursive(List<T> list, T target, int lo, int hi) {
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (list.get(mid).equals(target)) {
				return mid;
			} else if (list.get(mid).compareTo(target) < 0) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return -1;
	}
}
