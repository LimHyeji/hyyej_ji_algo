package dataStructureAndAlgorithms.연결리스트;

import java.util.LinkedList;
import java.util.List;

public class Main {

    /* 레퍼런스 참조용 */
    List<Integer> list;
    LinkedList<Integer> linkedList;

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list=new SinglyLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);

        list.add(2,6);
        System.out.println(list);

        System.out.println("3th : "+list.get(3));

        list.remove(5);
        System.out.println(list);
    }
}
