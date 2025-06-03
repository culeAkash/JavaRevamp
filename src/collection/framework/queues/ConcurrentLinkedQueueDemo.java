package collection.framework.queues;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueDemo {
    public static void main(String[] args) {
        // Implementation of Queue interface that supports lock free thread safe concurrent operations
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

        Thread producer = new Thread(()->{
            while(true){
                concurrentLinkedQueue.add("Task " + System.currentTimeMillis());
            }
        });

        Thread consumer = new Thread(()->{
            while (true){
                System.out.println("Processing " + concurrentLinkedQueue.poll());
            }
        });

        // Producer and consumer won't block each other
        // Uses Compare and Swap Mechanism like ConcurrentHashMap
    }
}
