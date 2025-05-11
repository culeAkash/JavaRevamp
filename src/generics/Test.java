package generics;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        String[] arr = {"a","b","c"};
        test.printArray(arr);
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

    // We can also override the methods using generic and specified methods will act independently, other data types will call the generic method
    public void printArray(Integer[] array){
        System.out.println("Integer Display");
        for(Integer element : array){
            System.out.println(element + " ");
        }
        System.out.println();
    }
}
