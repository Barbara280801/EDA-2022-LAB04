public interface TDAList<E> {
    boolean isEmpty();
    void insertFirst(E x);
    void insertLast(E x);
    boolean search(E x);
    void remove(int p);
    void insert(E x, int p);
}
