public class DoubleLinkedList<E extends Comparable<E>> implements TDAList<E> {
    private Node<E> raiz;
    private int tamano;

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
    	Node<E> node = new Node<E>(x);
    	if (isEmpty()) {
    		this.raiz = node;
    	}else {
    		node.setNext(this.raiz);
    		this.raiz.setPrevious(node);
    		this.raiz = node;
    	}
    	tamano++;
    }

    @Override
    public void insertLast(E x) {
        if (this.isEmpty()) {
            insertFirst(x);
        } else {
            Node<E> aux = get(tamano-1);
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
            	this.raiz.setPrevious(null);
            }
            else {
            	this.get(ind).setPrevious(null);
                Node<E> anterior = this.get(ind-1);
                anterior.setNext(this.get(ind).getNext());
                if (anterior.getNext() != null)
                	anterior.getNext().setPrevious(anterior);
            }
            tamano--;
        }
    }

    @Override
    public void insert(E x, int p) {
        if (this.isEmpty() || p == 0) {
            insertFirst(x);
        } 
        else if (p >= this.tamano)
        	insertLast(x);
        else {
        	Node<E> aux = this.get(p-1);
            Node<E> nuevo = new Node<E>(x, aux.getNext(), aux);
            aux.getNext().setPrevious(nuevo);
            aux.setNext(nuevo);
        }
        tamano++;
    }

    public Node<E> get(int ind) {
    	Node<E> aux = this.raiz;
        for (int i = 0; i < ind; i++)
            aux = aux.getNext();
        return aux;
    }

    @Override
    public String toString() {
    	String str = "";
        for (Node<E> aux = this.raiz; aux != null; aux = aux.getNext()) {
            str += aux.getData() + ", ";
        }
        return str;
    }
}
