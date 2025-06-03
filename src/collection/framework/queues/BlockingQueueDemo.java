package collection.framework.queues;

import java.util.concurrent.*;


class Producer implements Runnable{
    BlockingQueue<Integer> queue;
    int value;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Producer produces " + value);
                queue.put(value++);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(e.getMessage());
            }
        }
    }
}

class Consumer implements Runnable{
    BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                int value = queue.take();
                System.out.println("Consuner consumes " + value);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(e.getMessage());
            }
        }
    }
}



public class BlockingQueueDemo {
    public static void main(String[] args) {
        /*
        A Queue that additionally supports operations that wait for the queue to become non-empty when retrieving an element,
         and wait for space to become available in the queue when storing an element.
         */
        // Doesn't accept null elements
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);
        // A bounded, blocking queue backed by an circular array
        // low memory overhead
        //uses single lock for both enqueue and deque operations
        // more threads -> problem

        Thread producer = new Thread(new Producer(blockingQueue));
        Thread consumer = new Thread(new Consumer(blockingQueue));

        producer.start();
        consumer.start();

        BlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingDeque<>(100);
        // Partially bounded blocking queue backed by LinkedList
        // Uses two seperate locks for enqueue and dequeue operations
        // Higher concurrency between Producers and Consumers

        PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>();
        // unbounded
        // Binary Heap as array and can grow dynamically
        // Head is based on the natural ordering or a provided comparator like priority queue
        // put won't block

        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();
        // each insert operation must wait for a corresponind remove operation by another thread and vice versa
        // it cannot store elements, can't peek, it just acts as a handover tunnel for, when a thread wants a value only then another thread can insert into it




    }
}
