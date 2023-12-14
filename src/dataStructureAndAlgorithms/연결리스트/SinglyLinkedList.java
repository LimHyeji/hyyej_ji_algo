package dataStructureAndAlgorithms.연결리스트;

public class SinglyLinkedList<E> implements SinglyLinkedListInterface<E>{

    int size=0;
    Node<E> head;

    @Override
    public boolean isEmpty() {
        if(size==0) return true;
        return false;
    }

    @Override
    public void add(E e) {
        Node<E> newNode=new Node(e);

        if(isEmpty()) this.head=newNode;
        else {
            Node<E> tempNode=head;

            while (tempNode != null) {
                tempNode = tempNode.next;
            }
            tempNode.next=newNode;
        }

        this.size++;
    }

    @Override
    public boolean add(int idx, E e) {
        if(idx>this.size||idx<0) return false;

        int cnt=0;
        Node<E> newNode=new Node(e);
        Node<E> tempNode=head;
        while(cnt!=idx){
            tempNode=tempNode.next;
            cnt++;
        }
        tempNode.next=newNode;

        return true;
    }

    @Override
    public E get(int idx) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(Object o) {

    }

    @Override
    public void remove(int idx) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void set(int idx, Object o) {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }
}
