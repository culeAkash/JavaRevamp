package collection.framework.maps;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapDemo {
    public static void main(String[] args) {
        // If we create a map, we can modify it anytime, if we want to make a map immutable
        Map<String,Integer> map1 = new HashMap<>();
        map1.put("Akash",82);
        map1.put("Amit",80);

        // This will make a copy of map1 which can't be modified
        Map<String, Integer> map2 = Collections.unmodifiableMap(map1);
        System.out.println(map2.get("Akash"));
//        map2.put("Akash",30); Throws Exception

        // But we can still modify map1 as map2 is only a copy
        map1.put("Akash",30);
        System.out.println(map1);


        // In order to create an unmodifiable map, this will create an immutable map but in this method we can only pass
        // 10 key-value pairs, not more than that
        Map<String, Integer> map3 = Map.of("Akash", 90, "Amit", 88, "Danish", 90);

        // In order to add more key-value pairs
        Map<String, Integer> map4 = Map.ofEntries(Map.entry("Akash", 90), Map.entry("Amit", 88));
        // By this method, we can add unlimited key-value pairs and create an immutable map

    }
}
