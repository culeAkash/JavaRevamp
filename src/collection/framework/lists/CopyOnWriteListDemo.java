package collection.framework.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.*;

public class CopyOnWriteListDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = new CopyOnWriteArrayList<>();

        // This data structure is better in case of read extensive tasks as write operations will create multiple copies
        // which will increase the Space Complexity of the operation

        // Example
        // Using ArrayList
        List<String> shoppingList = new ArrayList<>(List.of("Milk","Eggs","Bread"));

        // reading through the list and writing happens at same time, and arraylist expects a stable list while reading
        try {
            shoppingList.stream().forEach((item) -> {
                System.out.println(item);
                if (item.equals("Eggs")) {
                    shoppingList.add("Butter");
                    System.out.println("Added Butter while reading");
                }
            });
        } catch (ConcurrentModificationException e) {
            System.out.println("Concurrent modification: " + e.getMessage());
        }

        System.out.println(shoppingList);

        System.out.println("--------------------------- USING WRITEONCOPYLIST --------------------------");

        List<String> shoppingList1 = new CopyOnWriteArrayList<>(List.of("Milk","Eggs","Bread"));

        // reading through the list and writing happens at same time, and arraylist expects a stable list while reading
        try {
            // while reading og list is used and only 3 values are printed
            // after reading new elem is added to copy list and ref of og list is updated
            shoppingList1.stream().forEach((item) -> {
                System.out.println(item);
                if (item.equals("Eggs")) {
                    shoppingList.add("Butter");
                    System.out.println("Added Butter while reading");
                }
            });
        } catch (ConcurrentModificationException e) {
            System.out.println("Concurrent modification: " + e.getMessage());
        }

        System.out.println(shoppingList);




        // Example 2
        System.out.println("------------- MULTITHREADED EXAMPLE -----------");

//        List<String> sharedList = new ArrayList<>(Arrays.asList("Item1","Item2","Item3"));
        List<String> sharedList = new CopyOnWriteArrayList<>(Arrays.asList("Item1","Item2","Item3"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<?> future1 = executorService.submit(() -> {
            try {
                while (true) {
                    for (String item : sharedList) {
                        System.out.println("Reading item: " + item);
                        Thread.sleep(1000);
                    }
                }
            } catch (Exception e) {
                System.out.println("Exception in reader thread " + e);
            }
        });

        Future<?> future2 = executorService.submit(() -> {
            try {
                Thread.sleep(500);
                sharedList.add("Item4");
                System.out.println("Adding item to list");

                Thread.sleep(500);
                sharedList.remove("Item1");
                System.out.println("Remove Item1 from list");
            } catch (Exception e) {
                System.out.println("Exception in writer thread " + e);
            }
        });

        executorService.shutdown();
        future1.get();
        future2.get();

        System.out.println(sharedList);


    }
}
