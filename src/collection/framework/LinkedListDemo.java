package collection.framework;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>(List.of(1,2,4,5,6,7));

        linkedList.add(7);
        linkedList.add(5,12);
        linkedList.set(3,10);

        System.out.println(linkedList);

        linkedList.addFirst(30);
        linkedList.addLast(20);

        System.out.println(linkedList);

        linkedList.removeLast();
        linkedList.removeFirst();

        System.out.println(linkedList);

        List<Integer> integerList = new LinkedList<>(List.of(2,10,7));
        linkedList.removeAll(integerList);
//        linkedList.retainAll(integerList);
//        linkedList.retainAll()

        System.out.println(linkedList);

        //remove all even numbers
        linkedList.removeIf(x -> (x&1)==0);

        System.out.println(linkedList);
    }
}
