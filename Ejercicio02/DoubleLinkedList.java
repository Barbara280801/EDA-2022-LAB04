public class DoubleLinkedList<E extends Comparable<E>> implements TDAList<E> {
    Node<E> first;
    int tamano;

    public DoubleLinkedList() {
    	this.first = null;
    	this.tamano = 0; 
    }
    
    @Override
    public boolean isEmpty() {
    	return this.first == null;
    }

    @Override
    public void insertFirst(E x) {
    	this.first = new Node<E>(x, null, this.first);
    	tamano++;
    }

    @Override
    public void insertLast(E x) {
        if (this.isEmpty()) {
            insertFirst(x);
        } else {
            Node<E> aux = this.first;
            for (; aux.getNext() != null; aux = aux.getNext());
            aux.setNext(new Node<E>(x));
        }
        tamano++;
    }

    @Override
    public boolean search(E x) {
    	return false;
    }

    @Override
    public void remove(E x) {
    	
    }

    @Override
    public void insert(E x, int p) {
    	
    }

    public void remove(int ind) {

    }

    public Node<E> get(int ind) {
    	return null;
    }

    @Override
    public String toString() {
    	return "";
    }

}
