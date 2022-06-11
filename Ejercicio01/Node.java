public class Node<E extends Comparable<E>> {
    private E dato;
    private Node<E> next;

    public E getDato() {
        return dato;
    }

    public Node(E dato) {
        this(dato, null);
    }

    public Node(E dato, Node<E> next) {
        this.dato = dato;
        this.next = next;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this.dato.toString();
    }

    public int compareTo(Node<E> x) {
        return this.getDato().compareTo(x.getDato());
    }

}
