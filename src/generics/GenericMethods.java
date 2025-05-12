package generics;

enum Operation{
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE;

    public <T extends Number> double apply(T a,T b){
        return switch (this){
            case ADD -> a.doubleValue() + b.doubleValue();
            case SUBTRACT -> a.doubleValue() - b.doubleValue();
            case MULTIPLY -> a.doubleValue() * b.doubleValue();
            case DIVIDE -> a.doubleValue() / b.doubleValue();
            default -> 0;
        };
    }
}

public class GenericMethods {
    public static void main(String[] args) {
        GenericMethods test = new GenericMethods();
        String[] arr = {"a","b","c"};
        test.printArray(arr);

        System.out.println(Operation.DIVIDE.apply(1,2));
    }


    // we can also define generic methods even if the class is not generic
//    public <T,V,E> T isPresentInArray(V[] array,E value){
//
//    }

    public <T> void printArray(T[] array){
        System.out.println("Generic Display");
        for(T element : array){
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // We can also overload the methods using generic and specified methods will act independently, other data types will call the generic method
    public void printArray(Integer[] array){
        System.out.println("Integer Display");
        for(Integer element : array){
            System.out.println(element + " ");
        }
        System.out.println();
    }
}
