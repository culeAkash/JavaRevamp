package collection.framework.maps;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {
    public static void main(String[] args) {
        SortedMap<Integer,String> sortedMap = new TreeMap<>((a,b)->-Integer.compare(a,b));

        sortedMap.put(99,"Akash");
        sortedMap.put(95,"Amit");
        sortedMap.put(90,"Akarsh");
        // Will give null pointer exception
//        sortedMap.put(null,"Ajay");
        sortedMap.put(75,"Ajay");

        System.out.println(sortedMap);

        System.out.println(sortedMap.firstKey());
        System.out.println(sortedMap.lastKey());
        System.out.println(sortedMap.headMap(95));
        System.out.println(sortedMap.tailMap(95));
        System.out.println(sortedMap.subMap(99,90));
    }
}
