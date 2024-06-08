package logica.algoritmos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *	Prueba de eficiencia en consola de los algoritmos de busqueda implementados en {@link Busqueda}. 
 * 
 * @version 04/07/2023
 * @author EduardoProfe
 *
 */
public class PruebaAlgoritmoBusqueda {
	private PruebaAlgoritmoBusqueda() {}

	public static void main(String[] args) {
		List<Integer> lista = randomN();
		Collections.sort(lista);

		Integer indice = new Random().nextInt(lista.size());
		Integer buscar = lista.get(indice);

		long tiempoInicio;
		long tiempoFin;

		//LinealSearch
		tiempoInicio = System.nanoTime();
		Busqueda.linealSearch(lista, buscar);
		tiempoFin = System.nanoTime();
		imprimirResultado("LinealSearch", (tiempoFin-tiempoInicio)/1e6);

		//BinarySearchRecursive
		tiempoInicio = System.nanoTime();
		Busqueda.binarySearchRecursive(lista, buscar);
		tiempoFin = System.nanoTime();
		imprimirResultado("BinarySearchRecursive", (tiempoFin-tiempoInicio)/1e6);

		//BinarySearchNotRecursive
		tiempoInicio = System.nanoTime();
		Busqueda.binarySearchNotRecursive(lista, buscar);
		tiempoFin = System.nanoTime();
		imprimirResultado("BinarySearchNotRecursive", (tiempoFin-tiempoInicio)/1e6);

		//BinarySearchNativo
		tiempoInicio = System.nanoTime();
		Busqueda.binarySearchNativo(lista, buscar);
		tiempoFin = System.nanoTime();
		imprimirResultado("BinarySearchNativo", (tiempoFin-tiempoInicio)/1e6);

		//ExponentialSearch
		tiempoInicio = System.nanoTime();
		Busqueda.exponentialSearch(lista, buscar);
		tiempoFin = System.nanoTime();
		imprimirResultado("ExponentialSearch", (tiempoFin-tiempoInicio)/1e6);

		//FibonacciSearch
		tiempoInicio = System.nanoTime();
		Busqueda.fibonacciSearch(lista, buscar);
		tiempoFin = System.nanoTime();
		imprimirResultado("FibonacciSearch", (tiempoFin-tiempoInicio)/1e6);

		//TernarySearch
		tiempoInicio = System.nanoTime();
		Busqueda.ternarySearch(lista, buscar);
		tiempoFin = System.nanoTime();
		imprimirResultado("TernarySearch", (tiempoFin-tiempoInicio)/1e6);
	}

	private static void imprimirResultado(String nombreAlgoritmo, double milisegundos) {
		BigDecimal b = new BigDecimal(milisegundos);
		b = b.setScale(6, RoundingMode.HALF_DOWN);
		System.out.println("Tiempo de ejecucion del algoritmo de busqueda "+nombreAlgoritmo+": "+b.toString()+"ms\n");
	}

	private static List<Integer> randomN(){
		List<Integer> l = new LinkedList<>();
		Random r = new Random();

		for(int i=0;i<1000000;i++)
			l.add(r.nextInt());

		return l;
	}
}
