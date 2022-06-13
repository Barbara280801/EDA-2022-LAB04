import java.util.concurrent.*;
import java.util.*;
import com.panayotis.gnuplot.*;
import java.io.*;

public class Test {
	public static void main (String[] args) throws Exception {
		final int CANTIDAD = 10000;
		long simulacionInicio, simulacionFin;

		ArrayList<DoubleLinkedList<Integer>> casos = new ArrayList<DoubleLinkedList<Integer>>();
		String archivoInsercion = "insercion.txt";
		PrintWriter oS = new PrintWriter(archivoInsercion);

		for (int n = 2; n <= CANTIDAD; n++) {
			casos.add(generarPeorCaso(n));
		}

		simulacionInicio = System.nanoTime();
		Iterator<DoubleLinkedList<Integer>> puntero = casos.iterator();
		while(puntero.hasNext()){
			oS.println(String.valueOf(insertionSort(puntero.next())));
		}
		simulacionFin = System.nanoTime();
		oS.close();

		long simulacionTotal = simulacionFin - simulacionInicio;
		System.out.println("Cantidad de datos: " + CANTIDAD);
		System.out.println("Fin de simulacion: " + TimeUnit.NANOSECONDS.toSeconds(simulacionTotal) + " segundos");

		JavaPlot p = new JavaPlot();
		p.addPlot("\"/insercion.txt\" with lines");
		p.setTitle("EDA - EJERCICIO 02 : ORDENAMIENTO DE LISTA ENLAZADA DOBLE");
		GNUPlotParameters params = p.getParameters();
		params.set("xlabel", "'Cantidad de datos'");
		params.set("ylabel", "'Tiempo en nanosegundos'");
		params.set("grid");
		p.setParameters(params);
		p.plot();
	}
	public static <E extends Comparable<E>> long insertionSort (DoubleLinkedList<E> list){
		long nano_startTime = System.nanoTime();
		for (Node<E> key = list.get(0).getNext(); key != null; key = key.getNext()){
			Node<E> i = key.getPrevious();
			E aux = key.getData();
			while(i != null && i.getData().compareTo(i.getNext().getData()) == 1){
				i.getNext().setData(i.getData());
				i.setData(aux);
				i = i.getPrevious();
			}
		}
		long nano_endTime = System.nanoTime();
		return nano_endTime - nano_startTime;
	}
	public static DoubleLinkedList<Integer> generarPeorCaso(int t){
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
		for (int i = 0; i < t; i++){
			list.insertFirst(i + 1);
		}
		return list;
	}
}
