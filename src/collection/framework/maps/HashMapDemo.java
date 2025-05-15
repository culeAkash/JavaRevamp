package collection.framework.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();

        map.put(1,"Akash");
        map.put(2,"Amit");
        map.put(3,"Danish");

        System.out.println(map);

        System.out.println(map.get(3));

        System.out.println(map.get(69));

        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue("Akash"));

        // iterating in map
        Set<Integer> keys = map.keySet();

        keys.stream().forEach((key)-> System.out.println(map.get(key)));


        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        System.out.println(map.values());

        for(Map.Entry<Integer, String> entry : entries){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
