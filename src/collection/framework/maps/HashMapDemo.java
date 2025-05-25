package collection.framework.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();

        map.put(1,"Akash");
        map.put(2,"Amit");
        map.put(3,"Danish");

        System.out.println(map);

        System.out.println(map.get(3));

        System.out.println(map.get(69));

        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue("Akash"));

        // iterating in map
        Set<Integer> keys = map.keySet();

        keys.stream().forEach((key)-> System.out.println(map.get(key)));


        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        System.out.println(map.values());

        for(Map.Entry<Integer, String> entry : entries){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}

class HashMapExample{
    public static void main(String[] args) {
        Map<Student,Integer> map = new HashMap<>();


        // Since default hashCode() in Object class works by doing some operations on the memory location, two seperate objects with
        // same values will be treated as seperate keys, so we have to implement our own hashCode method

        // even if the hashcode is same, both keys are matched based on the equals(). So, implement and equals() also.

        Student s1 = new Student("Akash",1);
        Student s2 = new Student("Amit",2);
        Student s3 = new Student("Akash",1);

        map.put(s1,90);
        map.put(s2,88);
        map.put(s3,99);

        System.out.println(map.get(s1) + " " + map.get(s3));
        System.out.println(map.size());


    }
}

class Student{
    private String name;
    private int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public String getName(){
        return this.name;
    }

    public int getRollNumber(){
        return this.rollNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                '}';
    }

    @Override
    public int hashCode() {
        // calculates hash based on elements and not reference
        return Objects.hash(this.name,this.rollNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this)return true;

        if(obj==null)return false;

        if(obj.getClass() != getClass())return false;

        Student other = (Student) obj;

        return Objects.equals(other.name,this.name) && other.rollNumber == this.rollNumber;
    }
}
