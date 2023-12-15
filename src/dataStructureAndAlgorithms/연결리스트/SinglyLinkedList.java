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

            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next=newNode;
        }

        this.size++;
    }

    @Override
    public boolean add(int idx, E e) {
        if(idx<0||idx>this.size) return false;

        Node<E> newNode=new Node(e);
        if(idx==0){//맨 앞에 삽입
            newNode.next=this.head;
            this.head=newNode;
        }
        else{
            int cnt=0;
            Node<E> prevNode=head;
            Node<E> curNode=head.next;
            while(cnt!=idx-1){
                prevNode=curNode;
                curNode=curNode.next;
                cnt++;
            }
            prevNode.next=newNode;
            newNode.next=curNode;
        }

        this.size++;
        return true;
    }

    @Override
    public E get(int idx) {
        if(idx<0||idx>this.size||this.size==0) return null;

        int cnt=0;
        Node<E> tempNode=this.head;
        while(cnt!=idx){
            tempNode = tempNode.next;
            cnt++;
        }

        return tempNode.data;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E remove(E e) {
        if(isEmpty()) return null;

        Node<E> prevNode=this.head;
        if(prevNode.data==e){
            this.head=prevNode.next;
            this.size--;
            return prevNode.data;
        }

        Node<E> curNode=this.head.next;
        while(curNode.next!=null&&curNode.data!=e){
            prevNode=curNode;
            curNode=curNode.next;
        }

        prevNode.next=curNode.next;
        E result=curNode.data;
        curNode=null;

        this.size--;
        return result;
    }

    @Override
    public void removeByIndex(int idx) {

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

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        Node<E> tempNode=this.head;
        while(tempNode!=null){
            str.append(tempNode.data).append(" ");
            tempNode=tempNode.next;
        }
        return str.toString();
    }
}
