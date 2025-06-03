package collection.framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorDemo {
    public static void main(String[] args) {
//        Class implementing the Iterable interface and overriding the iterator() can use forEach loop
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        for(int i : arrayList){
            System.out.println(i);
        }
        // Internal working of above for each loop
        Iterator<Integer> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        // remove method is also there, if we try to remove an element from list while using for-each loop it will exception
        // but iterator provides remove() method to do so
        Iterator<Integer> integerIterator = arrayList.iterator();
        while(integerIterator.hasNext()){
            int number = integerIterator.next();
            if(number%2==0){
                integerIterator.remove();
            }
        }
        System.out.println(arrayList);


        ListIterator<Integer> integerListIterator = arrayList.listIterator();// iterator with more methods and also can be used to set values concurrently
    }
}
