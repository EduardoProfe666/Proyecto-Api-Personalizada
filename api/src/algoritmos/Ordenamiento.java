package algoritmos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class Ordenamiento {
	private Ordenamiento() {}
	private static final int MIN_MERGE = 32;
	
	
	public static <T extends Comparable<? super T>> void bubbleSort(List<T> lista) {
		int size = lista.size();
		
		for(int i=0;i<size-1;i++) {
			for(int j=i+1;j<size;j++){
				if(lista.get(j).compareTo(lista.get(i))<0) {
					Collections.swap(lista, i, j);
				}
			}
		}
	}
	
	public static <T extends Comparable<? super T>> void insertionSort(List<T> lista) {
        int n = lista.size();
        for (int i = 1; i < n; i++) {
            T key = lista.get(i);
            int j = i - 1;
            while (j >= 0 && lista.get(j).compareTo(key) > 0) {
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, key);
        }
    }
	
	public static <T extends Comparable<? super T>> void bucketSort(List<T> lista, int numeroBuckets) {
		if(lista == null || lista.isEmpty() || numeroBuckets<=0)
			return;
		
		List<List<T>> buckets = new ArrayList<>(numeroBuckets);
		
		//Determinar el valor maximo y minimo
		T maxVal = Collections.max(lista);
		T minVal = Collections.min(lista);
		
		//Determinar el ancho de cada cubeta
		double rango = ((double)maxVal.compareTo(minVal)) / numeroBuckets;
		if(rango==0)
			rango=1;
		
		//Crear buckets
		for(int i=0;i<numeroBuckets;i++){
			buckets.add(new ArrayList<T>());
		}
		
		//Distribuir elementos por los buckets
		for(T val : lista) {
			int bucketIndice = (int) (val.compareTo(minVal) / rango);
			if(bucketIndice>=numeroBuckets)
				bucketIndice = numeroBuckets-1;
			buckets.get(bucketIndice).add(val);
		}
		
		//Ordenar buckets
		for(List<T> bucket : buckets){
			Collections.sort(bucket);
		}
		
		//Concatenar los buckets en orden en la lista original
		int indice = 0;
		for(List<T> bucket : buckets) {
			for(T val : bucket){
				lista.set(indice++, val);
			}
		}
	}
	
	public static <T extends Comparable<? super T>> void selectionSort(List<T> lista) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (lista.get(j).compareTo(lista.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            T temp = lista.get(minIndex);
            lista.set(minIndex, lista.get(i));
            lista.set(i, temp);
        }
    }
	
	public static <T extends Comparable<? super T>> void mergeSort(List<T> lista) {
        if (lista.size() > 1) {
            int midIndex = lista.size() / 2;
            List<T> leftArr = new ArrayList<>(lista.subList(0, midIndex));
            List<T> rightArr = new ArrayList<>(lista.subList(midIndex, lista.size()));
            mergeSort(leftArr);
            mergeSort(rightArr);
            merge(lista, leftArr, rightArr);
        }
    }
    
    public static <T extends Comparable<? super T>> void quickSort(List<T> lista) {
        quickSort(lista, 0, lista.size() - 1);
    }
    
    public static <T extends Comparable<? super T>> void heapSort(List<T> lista) {
        int n = lista.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(lista, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            Collections.swap(lista, 0, i);
            heapify(lista, i, 0);
        }
    }

    public static <T extends Comparable<? super T>> void radixSort(List<T> lista) {
        if (lista == null || lista.isEmpty()) {
            return;
        }

        // Encontramos el valor máximo en el arreglo
        T maxVal = lista.get(0);
        for (T val : lista) {
            if (val.compareTo(maxVal) > 0) {
                maxVal = val;
            }
        }

        // Obtenemos el número de dígitos del valor máximo
        int numDigits = String.valueOf(maxVal).length();

        // Ordenamos los elementos por dígitos
        for (int i = 0; i < numDigits; i++) {
            countingSort(lista, i);
        }
    }

    public static <T extends Comparable<? super T>> void shellSort(List<T> lista) {
        int n = lista.size();

        // Definimos la secuencia de distancias
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};

        // Aplicamos Insertion Sort con cada distancia
        for (int gap : gaps) {
            for (int i = gap; i < n; i++) {
                T temp = lista.get(i);
                int j;
                for (j = i; j >= gap && lista.get(j - gap).compareTo(temp) > 0; j -= gap) {
                    lista.set(j, lista.get(j - gap));
                }
                lista.set(j, temp);
            }
        }
    }

    public static <T extends Comparable<? super T>> void cocktailSort(List<T> lista) {
        int start = 0;
        int end = lista.size() - 1;
        boolean swapped = true;

        // Recorremos el arreglo hacia adelante y hacia atrás
        while (swapped) {
            swapped = false;

            // Recorrido hacia adelante
            for (int i = start; i < end; i++) {
                if (lista.get(i).compareTo(lista.get(i + 1)) > 0) {
                    Collections.swap(lista, i, i + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }

            swapped = false;

            // Recorrido hacia atrás
            end--;
            for (int i = end - 1; i >= start; i--) {
                if (lista.get(i).compareTo(lista.get(i + 1)) > 0) {
                    Collections.swap(lista, i, i + 1);
                    swapped = true;
                }
            }

            start++;
        }
    }
    
    public static <T extends Comparable<? super T>> void combSort(List<T> lista) {
        int n = lista.size();
        int gap = n;
        boolean swapped = true;

        // Reducimos la distancia entre pares de elementos
        while (gap > 1 || swapped) {
            gap = getNextGap(gap);

            swapped = false;
            for (int i = 0; i < n - gap; i++) {
                if (lista.get(i).compareTo(lista.get(i + gap)) > 0) {
                    Collections.swap(lista, i, i + gap);
                    swapped = true;
                }
            }
        }
    }

    public static <T extends Comparable<? super T>> void gnomeSort(List<T> lista) {
        int n = lista.size();
        int i = 0;

        while (i < n) {
            if (i == 0 || lista.get(i - 1).compareTo(lista.get(i)) <= 0) {
                i++;
            } else {
                Collections.swap(lista, i - 1, i);
                i--;
            }
        }
    }

    public static <T extends Comparable<? super T>> void timSortNativo(List<T> lista) {
    	Collections.sort(lista);
    }
    
    public static <T extends Comparable<? super T>> void oddEvenSort(List<T> lista) {
        boolean sorted = false;
        int n = lista.size();

        while (!sorted) {
            sorted = true;

            // Ordenamos los elementos en índices impares
            for (int i = 1; i < n - 1; i += 2) {
                if (lista.get(i).compareTo(lista.get(i + 1)) > 0) {
                    Collections.swap(lista, i, i + 1);
                    sorted = false;
                }
            }

            // Ordenamos los elementos en índices pares
            for (int i = 0; i < n - 1; i += 2) {
                if (lista.get(i).compareTo(lista.get(i + 1)) > 0) {
                    Collections.swap(lista, i, i + 1);
                    sorted = false;
                }
            }
        }
    }
    
    public static <T extends Comparable<? super T>> void timSort(List<T> lista) {
        int n = lista.size();

        // Tamaño mínimo de los bloques a ordenar
        int minRun = minRunLength(MIN_MERGE, n);

        // Dividimos la lista en bloques y los ordenamos
        for (int i = 0; i < n; i += minRun) {
            int end = Math.min(i + minRun - 1, n - 1);
            insertionSort(lista, i, end);
        }

        // Combinamos los bloques utilizando el algoritmo de mezcla
        for (int size = minRun; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);
                merge(lista, left, mid, right);
            }
        }
    }

    
    
    
    
    //Metodos Auxiliares
    private static <T extends Comparable<? super T>> void countingSort(List<T> arr, int digit) {
        // Creamos el arreglo de conteos
        int[] counts = new int[10];
        for (T val : arr) {
            int digitVal = getDigit(val, digit);
            counts[digitVal]++;
        }

        // Calculamos las posiciones iniciales de cada valor
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        // Creamos el arreglo ordenado
        List<T> sortedArr = new ArrayList<>(arr);
        for (int i = arr.size() - 1; i >= 0; i--) {
            T val = arr.get(i);
            int digitVal = getDigit(val, digit);
            int index = counts[digitVal] - 1;
            sortedArr.set(index, val);
            counts[digitVal]--;
        }

        // Copiamos el arreglo ordenado al arreglo original
        Collections.copy(arr, sortedArr);
    }

    private static <T extends Comparable<? super T>> int getDigit(T val, int digit) {
        String strVal = String.valueOf(val);
        if (digit >= strVal.length()) {
            return 0;
        }
        char digitChar = strVal.charAt(strVal.length() - 1 - digit);
        return Character.digit(digitChar, 10);
    }
    
    private static <T extends Comparable<? super T>> void heapify(List<T> arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr.get(left).compareTo(arr.get(largest)) > 0) {
            largest = left;
        }
        if (right < n && arr.get(right).compareTo(arr.get(largest)) > 0) {
            largest = right;
        }
        if (largest != i) {
            Collections.swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
    
    private static <T extends Comparable<? super T>> void quickSort(List<T> arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }
    
    private static <T extends Comparable<? super T>> int partition(List<T> arr, int left, int right) {
        T pivot = arr.get(right);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr.get(j).compareTo(pivot) <= 0) {
                i++;
                Collections.swap(arr, i, j);
            }
        }
        Collections.swap(arr, i + 1, right);
        return i + 1;
    }
    
    private static <T extends Comparable<? super T>> void merge(List<T> arr, List<T> leftArr, List<T> rightArr) {
        int i = 0, j = 0, k = 0;
        while (i < leftArr.size() && j < rightArr.size()) {
            if (leftArr.get(i).compareTo(rightArr.get(j)) <= 0) {
                arr.set(k++, leftArr.get(i++));
            } else {
                arr.set(k++, rightArr.get(j++));
            }
        }
        while (i < leftArr.size()) {
            arr.set(k++, leftArr.get(i++));
        }
        while (j < rightArr.size()) {
            arr.set(k++, rightArr.get(j++));
        }
    }

    private static <T extends Comparable<? super T>> int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        if (gap < 1) {
            return 1;
        }
        return gap;
    }

    private static <T extends Comparable<? super T>> int minRunLength(int minMerge, int n) {
        int r = 0;
        while (n >= minMerge) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    private static <T extends Comparable<? super T>> void insertionSort(List<T> arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            T key = arr.get(i);
            int j = i - 1;
            while (j >= left && arr.get(j).compareTo(key) > 0) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, key);
        }
    }

    private static <T extends Comparable<? super T>> void merge(List<T> arr, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;
        List<T> leftArr = arr.subList(left, mid + 1);
        List<T> rightArr = arr.subList(mid + 1, right + 1);

        // Copiamos los elementos a arreglos temporales
        @SuppressWarnings("unchecked")
		T[] tempLeft = (T[]) new Comparable[len1];
        @SuppressWarnings("unchecked")
		T[] tempRight = (T[]) new Comparable[len2];
        for (int i = 0; i < len1; i++) {
            tempLeft[i] = leftArr.get(i);
        }
        for (int i = 0; i < len2; i++) {
            tempRight[i] = rightArr.get(i);
        }

        int i = 0, j = 0, k = left;

        // Combinamos los arreglos temporales en el arreglo original
        while (i < len1 && j < len2) {
            if (tempLeft[i].compareTo(tempRight[j]) <= 0) {
                arr.set(k++, tempLeft[i++]);
            } else {
                arr.set(k++, tempRight[j++]);
            }
        }

        // Combinamos los elementos restantes del arreglo izquierdo
        while (i < len1) {
            arr.set(k++, tempLeft[i++]);
        }

        // Combinamos los elementos restantes del arreglo derecho
        while (j < len2) {
            arr.set(k++, tempRight[j++]);
        }
    }
}
