package generics;


// Example showing Generics in constructor
public class Box2 {

    // even if class is not generic the constructor can be made generic
    public <T extends Number> Box2(T value){

    }

    public static void main(String[] args) {

    }
}
