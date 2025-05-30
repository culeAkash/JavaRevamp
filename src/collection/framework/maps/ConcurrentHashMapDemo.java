package collection.framework.maps;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer,String> concurrentHashMap = new ConcurrentHashMap<>();
    }
}


// MAP -> SORTED and SYNCHRONIZED
class ConcurrentSkipListMapDemo{
    public static void main(String[] args) {
        ConcurrentMap<Integer,String> map = new ConcurrentSkipListMap<>();
    }
}
