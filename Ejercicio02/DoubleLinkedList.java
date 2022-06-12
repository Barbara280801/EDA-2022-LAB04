public class DoubleLinkedList<E extends Comparable<E>> implements TDAList<E> {
    Node<E> raiz;
    int tamano;

    public DoubleLinkedList() {
    	this.raiz = null;
    	this.tamano = 0; 
    }
    
    @Override
    public boolean isEmpty() {
    	return this.raiz == null;
    }

    @Override
    public void insertFirst(E x) {
    	this.raiz = new Node<E>(x, null, this.raiz);
    	tamano++;
    }

    @Override
    public void insertLast(E x) {
        if (this.isEmpty()) {
            insertFirst(x);
        } else {
            Node<E> aux = this.raiz;
            for (; aux.getNext() != null; aux = aux.getNext());
            aux.setNext(new Node<E>(x, null, aux));
        }
        tamano++;
    }

    @Override
    public boolean search(E x) {
    	Node<E> aux = this.raiz;
    	for (; aux.getNext() != null && !aux.getData().equals(x); aux = aux.getNext());
        return aux != null;
    }

    @Override
    public void remove(int ind) {
        if(ind < tamano) {
            if(ind == 0) {
                this.raiz = this.raiz.getNext();
            	this.raiz.setPreviuos(null);
            }
            else {
                Node<E> anterior = this.get(ind-1);
                anterior.setNext(this.get(ind+1));
                anterior.getNext().setPreviuos(anterior);;
            }
            tamano--;
        }
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
