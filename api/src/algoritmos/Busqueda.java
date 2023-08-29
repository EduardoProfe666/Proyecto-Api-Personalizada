package algoritmos;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public final class Busqueda {
	private Busqueda() {}

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

	public static <T extends Comparable<? super T>> int binarySearchNativo(List<T> lista, T buscar) {
		return Collections.binarySearch(lista, buscar);
	}
	
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

	public static <T extends Comparable<? super T>> int binarySearchRecursive(List<T> lista, T buscar) {
		return binarySearchRecursive(lista, buscar, 0, lista.size() - 1);
	}

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
