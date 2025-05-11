package generics;

public class GenericContainer<T> implements Container<T> {

    private T val;

    @Override
    public T get() {
        return val;
    }

    @Override
    public void set(T val) {
        this.val = val;
    }
}
