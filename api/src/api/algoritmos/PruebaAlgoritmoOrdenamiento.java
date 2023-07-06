package api.algoritmos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import api.algoritmos.Ordenamiento;

/**
 *	Prueba de eficiencia en consola de los algoritmos de ordenamiento implementados en {@link Ordenamiento}. 
 * 
 * @version 04/07/2023
 * @author EduardoProfe
 *
 */
public final class PruebaAlgoritmoOrdenamiento {
	private PruebaAlgoritmoOrdenamiento() {}
	private static List<Integer> listaN = randomN();

	public static void main(String[] args) {
		algoritmos();

	}

	private static void imprimirResultado(String nombreAlgoritmo, double milisegundos) {
		BigDecimal b = new BigDecimal(milisegundos);
		b = b.setScale(6, RoundingMode.HALF_DOWN);
		System.out.println("Tiempo de ejecucion del algoritmo de ordenamiento "+nombreAlgoritmo+": "+b.toString()+"ms\n");
	}

	private static void algoritmos(){
		long tiempoInicio;
		long tiempoFin;
		List<Integer> lista;
		
		
		
		lista = new LinkedList<>(listaN);
		//BubbleSort
		tiempoInicio = System.nanoTime();
		Ordenamiento.bubbleSort(lista);
		tiempoFin = System.nanoTime();
		imprimirResultado("BubbleSort", (tiempoFin-tiempoInicio)/1e6);

		lista = new LinkedList<>(listaN);
		//InsertionSort
		tiempoInicio = System.nanoTime();
		Ordenamiento.insertionSort(lista);
		tiempoFin = System.nanoTime();
		imprimirResultado("InsertionSort", (tiempoFin-tiempoInicio)/1e6);

		lista = new LinkedList<>(listaN);
		//BucketSort
		tiempoInicio = System.nanoTime();
		Ordenamiento.bucketSort(lista,new Random().nextInt(100)+1);
		tiempoFin = System.nanoTime();
		imprimirResultado("BucketSort", (tiempoFin-tiempoInicio)/1e6);

		lista = new LinkedList<>(listaN);
		//SelectionSort
		tiempoInicio = System.nanoTime();
		Ordenamiento.selectionSort(lista);
		tiempoFin = System.nanoTime();
		imprimirResultado("SelectionSort", (tiempoFin-tiempoInicio)/1e6);

		lista = new LinkedList<>(listaN);
		//MergeSort
		tiempoInicio = System.nanoTime();
		Ordenamiento.mergeSort(lista);
		tiempoFin = System.nanoTime();
		imprimirResultado("MergeSort", (tiempoFin-tiempoInicio)/1e6);

		lista = new LinkedList<>(listaN);
		//QuickSort
		tiempoInicio = System.nanoTime();
		Ordenamiento.quickSort(lista);
		tiempoFin = System.nanoTime();
		imprimirResultado("QuickSort", (tiempoFin-tiempoInicio)/1e6);

		lista = new LinkedList<>(listaN);
		//HeapSort
		tiempoInicio = System.nanoTime();
		Ordenamiento.heapSort(lista);
		tiempoFin = System.nanoTime();
		imprimirResultado("HeapSort", (tiempoFin-tiempoInicio)/1e6);

		lista = new LinkedList<>(listaN);
		//RadixSort
		tiempoInicio = System.nanoTime();
		Ordenamiento.insertionSort(lista);
		tiempoFin = System.nanoTime();
		imprimirResultado("RadixSort", (tiempoFin-tiempoInicio)/1e6);
		
		lista = new LinkedList<>(listaN);
		//ShellSort
		tiempoInicio = System.nanoTime();
		Ordenamiento.shellSort(lista);
		tiempoFin = System.nanoTime();
		imprimirResultado("ShellSort", (tiempoFin-tiempoInicio)/1e6);
		
		lista = new LinkedList<>(listaN);
		//CocktailSort
		tiempoInicio = System.nanoTime();
		Ordenamiento.cocktailSort(lista);
		tiempoFin = System.nanoTime();
		imprimirResultado("CocktailSort", (tiempoFin-tiempoInicio)/1e6);
		
		lista = new LinkedList<>(listaN);
		//CombSort
		tiempoInicio = System.nanoTime();
		Ordenamiento.combSort(lista);
		tiempoFin = System.nanoTime();
		imprimirResultado("CombSort", (tiempoFin-tiempoInicio)/1e6);
		
		lista = new LinkedList<>(listaN);
		//GnomeSort
		tiempoInicio = System.nanoTime();
		Ordenamiento.gnomeSort(lista);
		tiempoFin = System.nanoTime();
		imprimirResultado("GnomeSort", (tiempoFin-tiempoInicio)/1e6);
		
		lista = new LinkedList<>(listaN);
		//TimSort
		tiempoInicio = System.nanoTime();
		Ordenamiento.timSort(lista);
		tiempoFin = System.nanoTime();
		imprimirResultado("TimSort", (tiempoFin-tiempoInicio)/1e6);

		lista = new LinkedList<>(listaN);
		//TimSort Nativo
		tiempoInicio = System.nanoTime();
		Ordenamiento.timSortNativo(lista);
		tiempoFin = System.nanoTime();
		imprimirResultado("TimSort Nativo", (tiempoFin-tiempoInicio)/1e6);
		
		lista = new LinkedList<>(listaN);
		//OddEvenSort
		tiempoInicio = System.nanoTime();
		Ordenamiento.oddEvenSort(lista);
		tiempoFin = System.nanoTime();
		imprimirResultado("OddEvenSort", (tiempoFin-tiempoInicio)/1e6);
	}

	private static List<Integer> randomN(){
		List<Integer> l = new LinkedList<>();
		Random r = new Random();

		for(int i=0;i<1000;i++)
			l.add(r.nextInt());

		return l;
	}

}
