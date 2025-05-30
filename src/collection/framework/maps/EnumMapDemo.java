package collection.framework.maps;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class EnumMapDemo {
    public static void main(String[] args) {
        /*
        If all the keys in a Map are values from a single enum, it is recommended to use an EnumMap as the specific implementation.
        An EnumMap, which has the advantage of knowing all possible keys in advance,
        is more efficient compared to other implementations, as it can use a simple array as its underlying data structure.
         */
        Map<Day,String> map = new EnumMap<>(Day.class);

        // order in enum is maintained here also
        map.put(Day.SATURDAY,"Walk");
        map.put(Day.THURSDAY,"Gym");

        System.out.println(map);
    }
}


enum Day{
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FIRDAY,SATURDAY,SUNDAY
}