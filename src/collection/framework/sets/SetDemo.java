package collection.framework.sets;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class SetDemo {
    public static void main(String[] args) {
        // Set implementation in Java is like Map impl
        // Faster operations based on principle of maps
        // In Map -> HashMap, LinkedHashMap, TreeMap and EnumMap
        // In Set -> HashSet, LinkedHashSet, TreeSet and EnumSet
        Set<Integer> set1 = new HashSet<>();

        set1.add(1);
        set1.add(4);
        set1.add(3);

        System.out.println(set1);


        // TreeSet
        // TreeSet implements NavigableSet which in turn implements SortedSet
        NavigableSet<Integer> treeSet = new TreeSet<>(List.of(1,5,2,3));

        System.out.println(treeSet.ceiling(4));
        System.out.println(treeSet.floor(3));

        System.out.println(treeSet);


        // We can also use ConcurrentSkipListSet here just like maps for concurrent sorted operations
        ConcurrentSkipListSet<Integer> skipListSet = new ConcurrentSkipListSet<>();


        // Unmodifiable sets can also be created easily
        Set<Integer> integers = Set.of(2, 3, 4, 1, 5);
        System.out.println(integers);


    }
}
