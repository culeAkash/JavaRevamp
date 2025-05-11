package generics;

interface Printable{
    void print();
}

class MyNumber extends Number implements Printable{

    private final int value;

    public MyNumber(int value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.println(value);
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }
}

// first will be class extended and them one or multiple interfaces
class Boxx<T extends Number & Printable>{
    private T value;

    public Boxx(T value) {
        this.value = value;
    }

    public void display(){
        value.print();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

public class GenericsBoundExample {
    public static void main(String[] args) {
        MyNumber number = new MyNumber(12);
        Boxx<MyNumber> box = new Boxx<>(number);
        box.display();

    }
}
