package collection.framework.queues;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        // Part of Queue interface
        // orders elements based on their natural ordering (for primitives lowest first)
        // custom comparator for customized ordering
        // does not allow null elements

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(2);
        pq.offer(5);
        pq.offer(3);

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

        // internal implementation: min-heap for primitive data types
        // all operation complexity is O(logN)


    }
}
