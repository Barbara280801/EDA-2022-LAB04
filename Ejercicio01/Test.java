import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {

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
