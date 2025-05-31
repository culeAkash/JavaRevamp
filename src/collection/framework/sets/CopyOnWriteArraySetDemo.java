package collection.framework.sets;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetDemo {
    public static void main(String[] args) {
        // Works similarly as CopyOnWriteArrayList
        // Follows a Copy-on-write mechanism

        CopyOnWriteArraySet<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet<>();

        copyOnWriteArraySet.add(2);
        copyOnWriteArraySet.add(1);
        copyOnWriteArraySet.add(3);
        copyOnWriteArraySet.add(5);

        // Use CopyOnWriteArraySet instead of ConcurrentSkipListSet
        // 1. when operations are not writing extensive, as new copy will be created each time when write is performed, hence memory management is not good
        // 2. when we want to iterate over the set and want consistency and not require unexpected behavior due to read happening from stable copy

        System.out.print("Iterating over the CopyOnWriteArraySet \n");
        for(Integer integer : copyOnWriteArraySet){
            System.out.print(integer + " ");

            copyOnWriteArraySet.add(4);
        }

        System.out.println(copyOnWriteArraySet);


        // If we use ConcurrentSkipListMap, during iteration if we add a new element, we can expect unexpected behavior
        // as it can be added or not added based on the conditions
        // use this data structure, when read-write extensive operations as it balances

        ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();
        concurrentSkipListSet.add(2);
        concurrentSkipListSet.add(1);
        concurrentSkipListSet.add(3);
        concurrentSkipListSet.add(5);

        System.out.println(concurrentSkipListSet);

        System.out.println("Iterating over the skip list set");
        for(Integer integer : concurrentSkipListSet){
            System.out.println(integer);

            // won't be printed in this case, so unexpected behavior
            if(integer==5)
                concurrentSkipListSet.add(4);
        }

        System.out.println(concurrentSkipListSet);
    }
}
