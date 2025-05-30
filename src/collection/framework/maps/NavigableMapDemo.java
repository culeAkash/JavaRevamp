package collection.framework.maps;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapDemo {
    public static void main(String[] args) {
        NavigableMap<Integer,String> navigableMap = new TreeMap<>();

        navigableMap.put(1,"ONE");
        navigableMap.put(5,"FiVE");
        navigableMap.put(3,"THREE");

        System.out.println(navigableMap);

        Map.Entry<Integer,String> entry = navigableMap.floorEntry(5);

        System.out.println(navigableMap.ceilingEntry(1));
        System.out.println(navigableMap.floorEntry(5));

        System.out.println(entry.getKey() + " -> " + entry.getValue());

        System.out.println(navigableMap.descendingMap());
    }
}
