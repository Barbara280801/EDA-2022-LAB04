import java.io.*;
import java.text.*;
import java.util.*;
import com.panayotis.gnuplot.GNUPlotParameters;
import com.panayotis.gnuplot.JavaPlot;

public class Test {
    public static void main(String[] args) throws Exception {
        int CANTIDAD = 10000;
        long simulacionInicio, simulacionFin, simulacionTotal;
        long insercionInicio, insercionFin, insercionTotal;

        PrintStream archivo = new PrintStream("insercion.dat");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        System.out.println("Inicio de simulacion: " + dateFormat.format(new Date()));
        simulacionInicio = System.nanoTime();
        for (int i = 2; i <= CANTIDAD; i++) {

            LinkedList<Integer> list = generarPeorCaso(i);
            insercionInicio = System.nanoTime();
            insertionSort(list);
            insercionFin = System.nanoTime();
            insercionTotal = insercionFin - insercionInicio;
            archivo.print(i);
            archivo.print(" ");
            archivo.print(insercionTotal);
            archivo.println();
        }
        archivo.close();
        simulacionFin = System.nanoTime();
        simulacionTotal = simulacionFin - simulacionInicio;
        System.out.println("Fin de simulacion: " + TimeUnit.NANOSECONDS.toMinutes(simulacionTotal) + "min");
        JavaPlot p = new JavaPlot();
        p.addPlot("\"/home/franco/eda/prueba/listas/src/insercion.dat\" with lines");
        p.setTitle("EDA - EJERCICIO 01 : ORDENAMIENTO DE LISTA ENLAZADA SIMPLE");
        GNUPlotParameters params = p.getParameters();
        params.set("title", "'EDA-LAB 04-EJERCICIO 1'");
        params.set("xlabel", "'Cantidad de datos'");
        params.set("ylabel", "'tiempo en nanosegundos'");
        params.set("grid");
        p.setParameters(params);
        p.plot();
    }

    public static <E extends Comparable<E>> void insertionSort(LinkedList<E> list) {
        E key;
        int i;
        for (int j = 1; j < list.tamanio; j = j + 1) {
            key = list.get(j).getDato();
            i = j - 1;
            while (i > -1 && list.get(i).getDato().compareTo(key) > 0) {
                list.get(i + 1).setDato(list.get(i).getDato());
                i = i - 1;
            }
            list.get(i + 1).setDato(key);
        }
        System.out.println(list);
    }

    public static LinkedList<Integer> generarPeorCaso(int t) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < t; i++) {
            list.insertFirst(i + 1);
        }
        return list;
    }

}
