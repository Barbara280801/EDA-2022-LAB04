public class LinkedList<E extends Comparable<E>> implements TDAList<E> {
    Node<E> first;
    int tamanio;

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    public LinkedList() {
        this.tamanio = 0;
    }

    @Override
    public void insertFirst(E x) {
        this.first = new Node<E>(x, this.first);
        tamanio++;
    }

    @Override
    public void insertLast(E x) {
        // si List esta vacio solo iserto x al inicio
        if (this.isEmpty()) {
            insertFirst(x);
        } else {// recorro hasta llegar al ultimo elemento, y referencio next
            Node<E> aux = this.first;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(new Node<E>(x));
        }
        tamanio++;

    }

    @Override
    public boolean search(E x) {
        Node<E> aux = this.first;
        while (aux != null && !aux.getDato().equals(x)) {
            aux = aux.getNext();
        }
        return aux != null;
    }

    @Override
    public void remove(E x) {
        // solo puede remover un elemento si list no esta vacio y si el elemento está
        if (!this.isEmpty()) {
            if (this.first.getDato().equals(x)) {
                this.first = first.getNext();

            } else {
                Node<E> aux = this.first;
                // recorro hasta llegar a un elemento antes del que se eliminara(pos-1)
                while (aux.getNext() != null && !aux.getNext().getDato().equals(x)) {
                    aux = aux.getNext();
                }
                // cambio el next de ese elemento por el (pos +1)
                if (aux.getNext() != null) {
                    aux.setNext(aux.getNext().getNext());
                }
            }
            tamanio++;
        }

    }

    @Override
    public void insert(E x, int p) {
        // si esta vacio solo se inserta en la primera posicion
        if (this.isEmpty() || p == 0) {
            insertFirst(x);
        } else {// de lo contrario recorro hasta la poscion anterior (p-1)
            Node<E> aux = this.first;
            // el next tiene que ser difente de null asi si ingresan indice exedente solo se
            // colocara al final
            for (int i = 0; i < p - 1 && aux.getNext() != null; i++) {
                aux = aux.getNext();// en la ultima vuelta next p-2 = p-1
            }
            // cambio el next por dato a insertar , y en next coloco el next de p-1
            aux.setNext(new Node<E>(x, aux.getNext()));
        }
        tamanio++;
    }

    public void remove(int indice) {
        if (indice < tamanio) {
            if (indice == 0)
                this.first = this.first.getNext();
            else {
                Node<E> anterior = this.get(indice - 1);
                anterior.setNext(this.get(indice + 1));
            }
            tamanio--;
        }
    }

    public Node<E> get(int indice) {
        Node<E> aux = this.first;
        for (int i = 0; i < indice; i++)
            aux = aux.getNext();
        return aux;
    }

    @Override
    public String toString() {
        String str = "";
        for (Node<E> aux = this.first; aux != null; aux = aux.getNext()) {
            str += aux.toString() + ", ";
        }
        return str;
    }

}
