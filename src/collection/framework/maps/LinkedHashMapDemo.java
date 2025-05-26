package collection.framework.maps;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>(11,0.8f,true);

        linkedHashMap.put("Orange",10);
        linkedHashMap.put("Apple",20);
        linkedHashMap.put("Guava",13);

        // as accessOrder -> true, this action pushes the key-val pair with key "Apple" to end of LinkedList
        linkedHashMap.get("Apple");


        for(Map.Entry<String,Integer> entry : linkedHashMap.entrySet()){
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }


    }
}


class LRUCache<K,V> extends LinkedHashMap<K,V>{

    private int capacity;

    public LRUCache(int capacity){
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > this.capacity;
    }

    public static void main(String[] args) {
        LRUCache<String,Integer> lruCache = new LRUCache<>(3);

        lruCache.put("Bob",91);
        lruCache.put("Alice",70);
        lruCache.put("Mark",88);

        lruCache.put("Amin",100);

        System.out.println(lruCache);
    }
}
