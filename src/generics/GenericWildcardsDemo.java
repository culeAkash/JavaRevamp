package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericWildcardsDemo {
    public static void main(String[] args) {
        // not possible
        ArrayList<?> list = new ArrayList<>();
//        list.add(1);

        List<? extends Number> list1 = Arrays.asList(1, 2, 4, 6);

        System.out.println(add(list1));

        List<? super Integer>  list2 = Arrays.asList(1, 2, 4, 6);
        list2.add(2);

    }

    // must be a Number or its subclasses, hence defining an Upper Bound
    public static double add(List<? extends Number> list){
        double sum = 0;

        for(Number o : list){
            sum += o.doubleValue();
        }
        return sum;
    }

    // must be Integer or a super class of Integer, marking its Lower Bound which is Integer
    public void printArr(ArrayList<? super Integer> list){
        for(Object o : list){
            System.out.println(o);
        }
    }
    // wildcard ? specifies that the data type can be anything and is unknown, useful for read only mechanisms
    public void printList(ArrayList<?> list){
        for(Object o : list){
            System.out.println(o);
        }
    }

    // in this case wildcard can't be used as source and dest types may differ and it involves more than read operation
    public <T> void cloneList(List<T> source, List<T> destination){
        for(T obj : source){
            destination.add(obj);
        }
    }
}
