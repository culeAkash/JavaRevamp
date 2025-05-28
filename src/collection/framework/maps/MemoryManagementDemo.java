package collection.framework.maps;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class MemoryManagementDemo {
    public static void main(String[] args) {
        // Garbage collector clears the object even if there is a reference
        WeakReference<Person> personWeakReference = new WeakReference<>(new Person("Akash","Garpar"));

        System.out.println(personWeakReference.get());


        // Garbage collector is allowed to clear the object, but only if it is necessary to do so and there is no memory/space remaining
        SoftReference<Person> personSoftReference = new SoftReference<>(new Person("Amit","Beleghata"));

        System.out.println(personSoftReference.get());
        System.gc();
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

        System.out.println(personWeakReference.get()); // null
        System.out.println(personSoftReference.get()); // not null
    }
}

class Person{
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
