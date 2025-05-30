package collection.framework;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HashTableDemo {
    public static void main(String[] args) {
        Hashtable<Integer,String> hashtable = new Hashtable<>();

        // Hash table is synchronized but if want to use thread safe highly concurrent implementation,
        // then can use ConcurrentHashMap
        // all methods are synchronized in hashtable

        hashtable.put(1,"ONE");
        hashtable.put(2,"TWO");


        System.out.println(hashtable);

        System.out.println(hashtable.get(1));

        System.out.println(hashtable.containsKey(2));


        // Hashtable and HashMap concurrency example

        Hashtable<Integer,String> map = new Hashtable<>();

        ExecutorService executorService =Executors.newFixedThreadPool(1);

        executorService.submit(()->{
            for(int i=0;i<1000;i++){
                map.put(i,"Thread1");
            }
        });

        executorService.submit(()->{
            for(int i=1000;i<2000;i++){
                map.put(i,"Thread2");
            }
        });

        executorService.shutdown();

        while(true){
            try {
                if (executorService.awaitTermination(200,TimeUnit.MILLISECONDS)) break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(map.size());


    }
}
