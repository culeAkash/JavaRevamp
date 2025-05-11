package generics;

public class GenericClassExample {
    public static void main(String[] args) {
        Box<Integer> box = new Box<>();

        box.setValue(1);

        Integer boxValue = box.getValue();

        System.out.println(boxValue);

        Pair<String,Integer> pair = new Pair<>("age",25);

        System.out.println(pair.getKey());
        System.out.println(pair.getValue());
    }
}

class Pair<K,V>{
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

