package dataStructureAndAlgorithms.연결리스트;

public interface SinglyLinkedListInterface<E> {

    boolean isEmpty();

    void add(E e);

    boolean add(int idx,E e);

    E get(int idx);

    int size();

    E remove(E e);

    void removeByIndex(int idx);

    void clear();

    void set(int idx,E e);

    int indexOf(E e);
}
