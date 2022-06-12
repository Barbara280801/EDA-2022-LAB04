
public class Node<E> {

    private E element = null;
    private Node<E> previous = null;
    private Node<E> next = null;

    public Node() {
    }

    public Node(E element) {
        this.element = element;
    }

    public Node(E element, Node<E> next) {
        this(element);
        this.next = next;
    }

    public Node(E element, Node<E> next, Node<E> previous) {
        this(element, next);
        this.previous = previous;
    }

    public Node<E> getNext() {
        return next;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public E getData() {
        return element;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }

    public void setData(E element) {
        this.element = element;
    }
}