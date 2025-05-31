package collection.framework.queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    public static void main(String[] args) {
        // Double-ended queue
        // allows insertion and removal of elements from both ends
        // versatile then regular queues and stacks because it supports the functionality of both

        Deque<Integer> deque1 = new ArrayDeque<>();// faster iteration as internally array is used, low memory, no null allowed
        // no need to shift elements, head and tail pointers used in circular array

        deque1.addFirst(10);
        deque1.offerLast(20);
        deque1.offerFirst(5);
        deque1.offerLast(15);

        System.out.println(deque1.peekFirst());
        System.out.println(deque1.peekLast());

        deque1.removeFirst();
        deque1.pollLast();

        System.out.println(deque1);
    }
}
