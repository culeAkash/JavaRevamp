package collection.framework.queues;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(4);
        q.add(5);

        System.out.println(q.poll());// returns null
        System.out.println(q.remove());// throws exception if queue is empty

        q.add(5);

        System.out.println(q.peek());// returns null
        System.out.println(q.element());// throws exception if queue is empty


        Queue<Integer> q2 = new ArrayBlockingQueue<>(2);

        System.out.println(q2.add(2));
        System.out.println(q2.offer(1));

//        System.out.println(q2.add(3)); throws exception
        System.out.println(q2.offer(3)); // returns false if queue is full


    }
}


class QueueImpl<T>{
    public static void main(String[] args) {
        QueueImpl<Integer> queue = new QueueImpl<>();

        queue.add(1);
        queue.add(4);
        queue.add(3);

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }

    private final List<T> queue;
    private int size;

    public QueueImpl(){
        queue = new LinkedList<>();
        size = 0;
    }

    public void add(T num){
        queue.addLast(num);
        size++;
    }

    public T top(){
        if(queue.isEmpty()){
            return null;
        }
        return queue.getFirst();
    }

    public T poll(){
        if(queue.isEmpty()){
            return null;
        }
        size--;
        return queue.removeFirst();
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
