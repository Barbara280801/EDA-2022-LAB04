import java.util.concurrent.*;
import java.util.*;
import com.panayotis.gnuplot.*;
import java.io.*;

public class Test {
	public static void main (String[] args) throws Exception {
		final int CANTIDAD = 10000;
		long simulacionInicio, simulacionFin;
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
}
