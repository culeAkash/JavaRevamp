package generics;

public class StringContainer implements Container<String>{

    private String val;

    @Override
    public String get() {
        return val;
    }

    @Override
    public void set(String val) {
        this.val = val;
    }
}
