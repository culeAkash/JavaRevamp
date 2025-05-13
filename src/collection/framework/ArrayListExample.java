package collection.framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//
//        list.add(10);
//        list.add(20);
//        list.add(80);
//
//        list.add(90);
//        list.set(1,100);
//        list.add(2,200);
//        System.out.println(list);
//        list.remove(2);
//        list.remove(Integer.valueOf(10));
//        System.out.println(list);

        // Creating ArrayList using different methods

        // From new Keyword
        List<String> list1 = new ArrayList<>();
        // this list is modifiable
        list1.add("abc");
        System.out.println(list1);

        // Creating list from Arrays.asList
        // using this method, we can't add or remove elements from list but can set values
        List<String> list2 = Arrays.asList("Apple", "Guava", "Pineapple");
//        list2.add("Watermelon");
        list2.set(1,"Watermelon");
        System.out.println(list2);

        // Creating list using List.of()
        // We can't add,remove or set elements, as it returns an UnModifiable List
        List<String> list3 = List.of("Mango", "Apple", "Guava");
//        list3.set(1,"Pineapple");
        System.out.println(list3);

        // We can convert unmodifiable list to modifiable list
        List<String> list4 = new ArrayList<>(list3);
        list4.set(1,"Hello");
        System.out.println(list4);

        List<String> list5 = new ArrayList<>(list2);
        list5.add("Cheeku");
        System.out.println(list5);

        // adding elements
        // addAll Method
        List<Integer> integers1 = new ArrayList<>();
        integers1.add(1);
        integers1.add(2);
        integers1.add(3);
        integers1.add(4);
        integers1.add(5);
        integers1.add(6);

        List<Integer> integers2 = List.of(7, 8, 9, 10);
        // adds elems from one to another list
        integers1.addAll(integers2);

        System.out.println(integers1);

        // remove
        // in order to call the object param method, we must pass a data type inheriting from Object
        integers1.remove(Integer.valueOf(1));


        // converting list to array
        // as convention we pass an empty array of data required to tell what will be the data type of the result array
        String[] array = list5.toArray(new String[0]);
        System.out.println(array);

        // sorting elems
        Collections.sort(list2);
        System.out.println(list2);


        /*
        * Time Complexity :
        * 1. Access by index takes O(1)
        * 2. Adding elem in O(N) in worst case when resizing occurs
        * 3. Removing can be O(N) as many elems have to be shifted to left
        * 4. Iteraion is O(N)
        * */
    }
}
