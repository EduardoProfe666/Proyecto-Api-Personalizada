package logica.algoritmos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Clase que contiene implementaciones de algunos de los métodos de ordenamiento más usados, dada una lista de elementos. 
 * Los elementos deben implementar la interfaz Comparable para poder realizar el algoritmo.
 * 
 * <h1>Métodos implementados:</h1>
 * 1.--{@link #bubbleSort(List)}<br>
 * 2.--{@link #insertionSort(List)}<br>
 * 3.--{@link #bucketSort(List, int)}<br>
 * 4.--{@link #selectionSort(List)}<br>
 * 5.--{@link #mergeSort(List)}<br>
 * 6.--{@link #quickSort(List)}<br>
 * 7.--{@link #heapSort(List)}<br>
 * 8.--{@link #radixSort(List)}<br>
 * 9.--{@link #shellSort(List)}<br>
 * 10.--{@link #cocktailSort(List)}<br>
 * 11.--{@link #combSort(List)}<br>
 * 12.--{@link #gnomeSort(List)}<br>
 * 13.--{@link #timSortNativo(List)}<br>
 * 14.--{@link #timSort(List)}<br>
 * 15.--{@link #oddEvenSort(List)}<br>
 * 
 * @version 04/07/2023
 * @author EduardoProfe
 *
 */
public final class Ordenamiento {
	private Ordenamiento() {}
	private static final int MIN_MERGE = 32;
	
	/**
	 * <b>Descripción:</b><br>
	 * Algoritmo de ordenamiento que modela el ordenamiento de burbuja. Es un método simple de ordenamiento 
	 * que funciona intercambiando repetidamente los elementos adyacentes de una lista si están en el orden 
	 * incorrecto. El proceso se repite hasta que la lista esté completamente ordenada. Es fácil de implementar y funciona 
	 * bien para listas pequeñas. Sin embargo, su eficiencia es baja ya que requiere un número cuadrático de comparaciones 
	 * y intercambios en el peor caso.
	 * <br><br><b>Funcionamiento:</b><br>
	 * El proceso comienza comparando el primer elemento de la lista con el segundo elemento. Si el primer elemento es 
	 * mayor que el segundo, se intercambian. Luego, se compara el segundo elemento con el tercer elemento y se intercambian 
	 * si es necesario. Este proceso continúa hasta que se llega al último par de elementos de la lista. Si el último par 
	 * de elementos se intercambia, se repite el proceso desde el principio hasta el penúltimo par de elementos. Este 
	 * proceso se repite hasta que no se necesiten más intercambios. En cada iteración del algoritmo, el elemento más 
	 * grande de la lista se "burbujea" hasta el final de la lista, como si fuera una burbuja subiendo a la superficie del agua.
	 * 
	 * @param lista Lista de elementos
	 */
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
	
	/**
	 * <b>Descripción:</b><br>
	 * Algoritmo de ordenamiento que modela el ordenamiento por insercion. Es un método sencillo de ordenamiento 
	 * que funciona construyendo una lista ordenada a partir de una lista desordenada. El proceso comienza con 
	 * el primer elemento de la lista desordenada y se inserta en la posición correcta en la lista ordenada. 
	 * Luego, se toma el siguiente elemento de la lista desordenada y se inserta en su posición correcta en la lista 
	 * ordenada, y así sucesivamente hasta que se insertan todos los elementos de la lista desordenada. Es eficiente para 
	 * listas pequeñas o listas que ya están ordenadas o casi ordenadas. El algoritmo es estable, lo que significa 
	 * que la posición relativa de los elementos con valores iguales se mantiene después de la ordenación.
	 * <br><br><b>Funcionamiento:</b><br>
	 * El proceso comienza con el primer elemento de la lista desordenada y se inserta en la posición correcta en la 
	 * lista ordenada. Luego, se toma el siguiente elemento de la lista desordenada y se inserta en su posición correcta
	 *  en la lista ordenada, y así sucesivamente hasta que se insertan todos los elementos de la lista desordenada. 
	 *  El proceso de inserción implica comparar el elemento actual con los elementos de la lista ordenada y desplazar 
	 *  los elementos mayores hacia la derecha para hacer espacio para el elemento actual. Una vez que se encuentra 
	 *  la posición correcta para el elemento actual, se lo inserta en la lista ordenada.
	 * 
	 * @param lista Lista de elementos
	 */
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
	
	/**
	 * <b>Descripción:</b><br>
	 * Algoritmo de ordenamiento que modela el ordenamiento de cubos. Es un método de ordenamiento que 
	 * se utiliza para ordenar una lista de números enteros en un rango específico. Este algoritmo es particularmente 
	 * eficiente cuando se trabaja con un rango de enteros pequeño en comparación con la cantidad de elementos en la lista, 
	 * ya que el número de cubos necesarios es proporcional al rango de enteros y no a la cantidad de elementos en la lista. 
	 * Sin embargo, su eficiencia disminuye cuando el rango de enteros es grande. Además, el algoritmo requiere espacio 
	 * adicional para almacenar los cubos, lo que puede ser un problema en sistemas con recursos limitados.
	 * <br><br><b>Funcionamiento:</b><br>
	 * El proceso comienza con la creación de un arreglo de cubos, donde cada cubo representa un rango específico de enteros. 
	 * Los elementos de la lista se colocan en los cubos correspondientes según su valor. Luego, los elementos de cada cubo 
	 * se ordenan, ya sea mediante el uso de otro algoritmo de ordenamiento o mediante la recursión del mismo algoritmo de 
	 * ordenamiento de cubos. Finalmente, los elementos se toman de cada cubo en orden y se colocan en la lista de salida. 
	 * La lista resultante estará ordenada en orden creciente.
	 * 
	 * @param lista Lista de elementos
	 * @param numeroBuckets Cantidad de cubos a emplear. Debe ser mayor que 0 o el algoritmo no funcionara.
	 */
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
	
	/**
	 * <b>Descripción:</b><br>
	 * Algoritmo de ordenamiento que modela el ordenamiento por seleccion. Es un método simple de ordenamiento 
	 * que funciona encontrando repetidamente el elemento mínimo de una lista desordenada y colocándolo al principio de 
	 * la lista. El proceso se repite hasta que la lista esté completamente ordenada. Es fácil de implementar y funciona 
	 * bien para listas pequeñas. Sin embargo, su eficiencia es baja ya que requiere un número cuadrático de comparaciones 
	 * y movimientos de elementos en el peor caso. 
	 * <br><br><b>Funcionamiento:</b><br>
	 * El proceso comienza encontrando el elemento mínimo de la lista desordenada y colocándolo en la primera posición de 
	 * la lista. Luego, se encuentra el siguiente elemento mínimo en la sublista restante y se coloca en la segunda posición 
	 * de la lista. Este proceso continúa hasta que se han encontrado todos los elementos mínimos de la lista y se han 
	 * colocado en la posición correcta. En cada iteración, el algoritmo busca el elemento mínimo de la sublista restante y 
	 * lo coloca en la posición correcta en la lista ordenada. De esta manera, la lista se va construyendo de manera 
	 * incremental, desde el principio hasta el final.
	 * 
	 * @param lista Lista de elementos
	 */
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
	
	/**
	 * <b>Descripción:</b><br>
	 * Algoritmo de ordenamiento que modela el ordenamiento de fusion. Es un método de ordenamiento eficiente 
	 * que funciona dividiendo repetidamente la lista en mitades más pequeñas y ordenándolas, para luego 
	 * fusionarlas en una lista ordenada. Es muy eficiente para grandes listas desordenadas, ya que su complejidad 
	 * temporal es de O(n log n), donde n es el número de elementos en la lista. Además, es un algoritmo estable, 
	 * lo que significa que la posición relativa de los elementos con valores iguales se mantiene después de la 
	 * ordenación. El algoritmo de ordenamiento por fusión también es utilizado en la implementación de otros 
	 * algoritmos de ordenamiento, como el algoritmo de ordenamiento Timsort.
	 * <br><br><b>Funcionamiento:</b><br>
	 * El proceso comienza dividiendo la lista en dos mitades iguales. Cada mitad se ordena recursivamente utilizando 
	 * el mismo algoritmo de ordenamiento por fusión. El proceso de ordenamiento recursivo se repite hasta que las 
	 * sublistas son lo suficientemente pequeñas como para ser ordenadas de manera trivial (por ejemplo, una sublista 
	 * de un solo elemento ya está ordenada). Luego, se fusionan las sublistas ordenadas en una lista ordenada. El proceso 
	 * de fusión implica comparar los elementos de ambas sublistas y colocarlos en la lista resultante en orden ascendente. 
	 * Este proceso se repite hasta que se han fusionado todas las sublistas y se obtiene una lista ordenada completa.
	 * 
	 * @param lista Lista de elementos
	 */
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
    
	/**
	 * <b>Descripción:</b><br>
	 * Algoritmo de ordenamiento que modela el ordenamiento rapido. Es un método de ordenamiento eficiente que 
	 * funciona dividiendo repetidamente la lista en dos sublistas más pequeñas, una con elementos menores que 
	 * un pivote elegido y otra con elementos mayores, y luego ordenándolas recursivamente. El algoritmo de ordenamiento 
	 * rápido es muy eficiente para grandes listas desordenadas, ya que su complejidad temporal promedio es de 
	 * O(n log n), donde n es el número de elementos en la lista. Sin embargo, su complejidad en el peor caso puede 
	 * ser de O(n^2), cuando el pivote elegido no es un buen representante del conjunto de datos o cuando la lista 
	 * está casi ordenada. Para mitigar este problema, se pueden utilizar diversas técnicas, como la elección de 
	 * pivotes aleatorios y la selección de pivotes medianos de tres elementos.
	 * <br><br><b>Funcionamiento:</b><br>
	 * El proceso comienza seleccionando un elemento de la lista como pivote. Luego, se reorganiza la lista de manera 
	 * que los elementos menores que el pivote estén a su izquierda y los elementos mayores estén a su derecha. Este 
	 * proceso se conoce como partición. Después de la partición, el pivote ocupa su posición final en la lista ordenada. 
	 * Luego, se ordenan recursivamente las sublistas a la izquierda y a la derecha del pivote utilizando el mismo algoritmo 
	 * de ordenamiento rápido. El proceso de ordenamiento recursivo se repite hasta que las sublistas sean lo suficientemente 
	 * pequeñas como para ser ordenadas de manera trivial.
	 * 
	 * @param lista Lista de elementos
	 */
    public static <T extends Comparable<? super T>> void quickSort(List<T> lista) {
        quickSort(lista, 0, lista.size() - 1);
    }
    
    /**
     * <b>Descripción:</b><br>
	 * Algoritmo de ordenamiento que modela el ordenamiento de monticulo. Es un método de ordenamiento que utiliza 
	 * la estructura de datos de montículo (heap) para ordenar una lista de elementos. El algoritmo de ordenamiento 
	 * de montículo es eficiente para listas grandes, ya que su complejidad temporal es de O(n log n), donde n es 
	 * el número de elementos en la lista. Sin embargo, su complejidad espacial es de O(n), ya que se requiere 
	 * espacio adicional para almacenar el montículo. Además, es un algoritmo in situ, es decir, que ordena la 
	 * lista original sin necesidad de crear una copia adicional.
	 * <br><br><b>Funcionamiento:</b><br>
	 * El proceso comienza construyendo un montículo a partir de la lista desordenada. Un montículo es una estructura 
	 * de datos en forma de árbol en la que cada nodo tiene un valor asociado y el valor de cada nodo es mayor o menor 
	 * que el valor de sus hijos, dependiendo del tipo de montículo que se esté utilizando. En el caso del algoritmo de 
	 * ordenamiento de montículo, se utiliza un max heap, donde el valor de cada nodo es mayor o igual que el valor de 
	 * sus hijos. Una vez construido el montículo, el elemento máximo (ubicado en la raíz del montículo) se intercambia 
	 * con el último elemento de la lista desordenada. Luego, se reduce el tamaño del montículo en uno y se ajusta el 
	 * montículo para que vuelva a ser un max heap. Este proceso se repite hasta que se hayan intercambiado todos los 
	 * elementos del montículo y la lista esté completamente ordenada.
	 * 
	 * @param lista Lista de elementos
	 */
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

    /**
     * <b>Descripción:</b><br>
	 * Algoritmo de ordenamiento que modela el ordenamiento por base. Funciona ordenando los elementos de una lista 
	 * según sus dígitos, de manera similar al algoritmo de ordenamiento por selección, pero en este caso se 
	 * compara cada dígito en lugar de cada elemento completo. Es eficiente para listas grandes y para listas 
	 * con un rango limitado de valores, ya que su complejidad temporal es lineal con respecto al número de 
	 * elementos y al rango de valores (O(n k)), donde n es el número de elementos en la lista y k es el rango de valores. 
	 * Sin embargo, su complejidad espacial puede ser alta, ya que requiere espacio adicional para almacenar 
	 * los grupos intermedios de elementos.
	 * <br><br><b>Funcionamiento:</b><br>
	 * El proceso comienza por separar los elementos de la lista en grupos según el dígito menos significativo. Luego, 
	 * se ordenan los elementos dentro de cada grupo utilizando un algoritmo de ordenamiento estable (por ejemplo, 
	 * el ordenamiento por inserción). Este proceso se repite para los dígitos más significativos, hasta que se hayan 
	 * ordenado todos los dígitos de los elementos. Es importante destacar que el algoritmo de ordenamiento por base 
	 * requiere que todos los elementos de la lista tengan la misma cantidad de dígitos. Si algunos elementos tienen 
	 * menos dígitos que otros, se deben agregar ceros a la izquierda para igualar la cantidad de dígitos.
	 * 
	 * @param lista Lista de elementos
	 */
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

    /**
     * <b>Descripción:</b><br>
	 * Algoritmo de ordenamiento que modela el ordenamiento de Shell-Metzner. Es un método de ordenamiento que 
	 * se basa en el algoritmo de ordenamiento por inserción, pero que utiliza una estrategia de incrementos 
	 * variables para mejorar su eficiencia. No tiene una complejidad temporal fácil de definir, ya que depende 
	 * de la secuencia de incrementos utilizada para separar los grupos de elementos. Sin embargo, se ha demostrado 
	 * que el algoritmo de ordenamiento Shell tiene un rendimiento mejor que el algoritmo de ordenamiento 
	 * por inserción para listas de tamaño mediano a grande.
	 * <br><br><b>Funcionamiento:</b><br>
	 * El proceso comienza dividiendo la lista en grupos de elementos separados por una cantidad fija de posiciones. 
	 * Luego, se ordenan los grupos utilizando el algoritmo de ordenamiento por inserción. Este proceso se repite varias 
	 * veces, cada vez con una cantidad de posiciones menor para separar los grupos. En cada iteración, se reduce la 
	 * cantidad de posiciones utilizadas para separar los grupos, hasta llegar a la cantidad mínima de posiciones. La 
	 * idea detrás del algoritmo de ordenamiento Shell es que al ordenar grupos de elementos separados por distancias 
	 * más grandes, se pueden mover elementos más grandes a sus posiciones finales con menos operaciones de intercambio 
	 * en comparación con el algoritmo de ordenamiento por inserción estándar. Luego, al ordenar grupos de elementos 
	 * separados por distancias más pequeñas, se asegura que la lista está casi ordenada, lo que reduce el número de 
	 * operaciones de intercambio necesarias para ordenar completamente la lista.
	 * 
	 * @param lista Lista de elementos
	 */
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

    /**
     * <b>Descripción:</b><br>
	 * Algoritmo de ordenamiento que modela el ordenamiento de coctel, tambien conocido como ordenamiento por sacudida u 
	 * ordenamiento de burbuja bidireccional. Es un método de ordenamiento que es similar al algoritmo de ordenamiento de 
	 * burbuja, pero que funciona en ambas direcciones. El algoritmo de ordenamiento por coctel tiene una complejidad 
	 * temporal de O(n^2) en el peor caso, donde n es el número de elementos en la lista. Debido a su baja eficiencia, 
	 * este algoritmo se utiliza principalmente para fines educativos y para ordenar listas pequeñas.
	 * <br><br><b>Funcionamiento:</b><br>
	 * El proceso comienza comparando el primer y el segundo elemento de la lista. Si el primer elemento es mayor que 
	 * el segundo, se intercambian. Luego, se compara el segundo y el tercer elemento, y así sucesivamente hasta llegar 
	 * al final de la lista. Este proceso se repite hasta que no se realice ningún intercambio en una pasada completa de la 
	 * lista. Una vez que se ha completado una pasada hacia adelante, se comienza una pasada hacia atrás, comenzando por el 
	 * último y el penúltimo elemento. Si el último elemento es mayor que el penúltimo, se intercambian. Luego, se compara el 
	 * penúltimo y el antepenúltimo elemento, y así sucesivamente hasta llegar al principio de la lista. Este proceso se repite 
	 * hasta que no se realice ningún intercambio en una pasada completa de la lista. El algoritmo de ordenamiento por coctel 
	 * se repite alternando pasadas hacia adelante y hacia atrás hasta que la lista esté completamente ordenada. Una ventaja 
	 * de este algoritmo es que puede detectar cuando la lista ya está ordenada y detenerse antes de completar todas las pasadas.
	 * 
	 * @param lista Lista de elementos
	 */
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
    
    /**
     * <b>Descripción:</b><br>
	 * Algoritmo de ordenamiento que modela el ordenamiento de peine mejorado. Es un método de ordenamiento 
	 * que es similar al algoritmo de ordenamiento por peine, pero que utiliza una estrategia de "peine" 
	 * mejorada para mejorar su eficiencia. El algoritmo de ordenamiento de peine tiene una complejidad 
	 * temporal promedio de O(n log n), donde n es el número de elementos en la lista. Sin embargo, su 
	 * complejidad temporal en el peor caso puede ser O(n^2), por lo que se recomienda utilizar otros 
	 * algoritmos de ordenamiento para listas grandes.
	 * <br><br><b>Funcionamiento:</b><br>
	 * El proceso comienza comparando los primeros dos elementos de la lista y, si el primer elemento es mayor que el 
	 * segundo, se intercambian. Luego, se compara el segundo y el tercer elemento, y así sucesivamente hasta el final 
	 * de la lista. Este proceso se repite hasta que se llega al final de la lista. En este punto, se reduce la cantidad 
	 * de elementos que se comparan en cada pasada utilizando un factor de reducción llamado "factor de peine". El factor 
	 * de peine es un número entre 1 y el tamaño de la lista, y se utiliza para separar los elementos que se compararán en 
	 * cada pasada. Sin embargo, a diferencia del algoritmo de ordenamiento por peine, el factor de peine se reduce mediante 
	 * una función de reducción que es más efectiva en la reducción del factor de peine. La función de reducción suele ser el 
	 * resultado de la división del factor de peine por un valor fijo, llamado "factor de reducción". El algoritmo de 
	 * ordenamiento comb se repite varias veces, reduciendo el factor de peine en cada iteración, utilizando la función de 
	 * reducción. En cada iteración, los elementos que se comparan están más cerca entre sí, lo que permite una comparación 
	 * más efectiva de los elementos y una reducción en el número de intercambios de elementos.
	 * 
	 * @param lista Lista de elementos
	 */
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

    /**
     * <b>Descripción:</b><br>
	 * Algoritmo de ordenamiento que modela el ordenamiento de gnome, tambien conocido como ordenamiento de la planta de jardin u 
	 * ordenamiento de Stupid. Es un método de ordenamiento que es similar al algoritmo de ordenamiento por inserción, pero que 
	 * utiliza una estrategia diferente para comparar y mover elementos en la lista. El algoritmo de ordenamiento de gnome 
	 * tiene una complejidad temporal promedio de O(n^2), donde n es el número de elementos en la lista. 
	 * Debido a su baja eficiencia, este algoritmo se utiliza principalmente para fines educativos y 
	 * para ordenar listas pequeñas.
	 * <br><br><b>Funcionamiento:</b><br>
	 * El proceso comienza comparando los primeros dos elementos de la lista y, si el primer elemento es mayor que el 
	 * segundo, se intercambian. Luego, se compara el segundo y el tercer elemento, y así sucesivamente hasta el final de 
	 * la lista. Si se encuentra que un elemento está en la posición incorrecta, se intercambia con el elemento anterior y 
	 * se retrocede una posición en la lista. Este proceso se repite hasta que se llega al principio de la lista. El algoritmo 
	 * de ordenamiento de gnome se repite varias veces, retrocediendo en la lista para mover los elementos a sus posiciones 
	 * correctas. A diferencia del algoritmo de ordenamiento por inserción, no se utiliza una estrategia de comparación y 
	 * movimiento de elementos en una sola dirección, sino que se retrocede en la lista para mover los elementos a su posición 
	 * correcta.
	 * 
	 * @param lista Lista de elementos
	 */
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

    /**
	 * Algoritmo de ordenamiento que utiliza el ordenamiento Tim nativo de {@link Collections}. 
	 * 
	 * 
	 * @param lista Lista de elementos
	 */
    public static <T extends Comparable<? super T>> void timSortNativo(List<T> lista) {
    	Collections.sort(lista);
    }
    
    /**
     * <b>Descripción:</b><br>
	 * Algoritmo de ordenamiento que modela el ordenamiento de pares e impares. Es un método de ordenamiento que 
	 * utiliza dos fases para ordenar una lista de números enteros. En la primera fase, se ordenan los elementos 
	 * pares, y en la segunda fase, se ordenan los elementos impares. Este algoritmo es especialmente útil para 
	 * listas grandes con valores repetidos, ya que puede reducir el número de intercambios necesarios para ordenar la lista. 
	 * El algoritmo de ordenamiento de pares e impares tiene una complejidad temporal promedio de 
	 * O(n^2), donde n es el número de elementos en la lista. Debido a su baja eficiencia, este algoritmo se utiliza 
	 * principalmente para fines educativos y para ordenar listas pequeñas.
	 * <br><br><b>Funcionamiento:</b><br>
	 * El proceso comienza comparando los elementos en posiciones pares y sus vecinos impares. Si el elemento en 
	 * la posición par es mayor que su vecino impar, se intercambian. Luego, se repite el proceso para todas las 
	 * posiciones pares en la lista. En la segunda fase, se realiza el mismo proceso pero esta vez se comparan las 
	 * posiciones impares y sus vecinos pares. Si el elemento en la posición impar es mayor que su vecino par, se 
	 * intercambian. Luego, se repite el proceso para todas las posiciones impares en la lista. El algoritmo de 
	 * ordenamiento de pares e impares se repite varias veces hasta que la lista esté completamente ordenada.
	 * 
	 * @param lista Lista de elementos
	 */
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
    
    /**
     * <b>Descripción:</b><br>
	 * Algoritmo de ordenamiento que modela el ordenamiento de Tim u ordenamiento por mezcla natural. Es un método 
	 * de ordenamiento que combina las técnicas de los algoritmos de ordenamiento por inserción y por mezcla. El algoritmo 
	 * de ordenamiento Tim es especialmente eficiente para listas que contienen sub-listas ordenadas, 
	 * ya que puede detectar y aprovechar estas sub-listas para reducir el número de operaciones de 
	 * comparación y mezcla necesarias. Además, el uso del algoritmo de ordenamiento por inserción 
	 * para ordenar los trozos de la lista también contribuye a mejorar su eficiencia para listas pequeñas.
	 * <br><br><b>Funcionamiento:</b><br>
	 * El proceso comienza dividiendo la lista en "trozos" ordenados de manera ascendente, utilizando el 
	 * algoritmo de ordenamiento por inserción para ordenar cada trozo. Luego, se mezclan los trozos en sub-listas 
	 * ordenadas utilizando el algoritmo de ordenamiento por mezcla. El algoritmo de ordenamiento Tim se repite varias 
	 * veces, dividiendo y ordenando los trozos de la lista hasta que se haya completado una pasada completa de la lista 
	 * sin necesidad de realizar ninguna mezcla. En este punto, la lista está completamente ordenada.
	 * 
	 * @param lista Lista de elementos
	 */
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
