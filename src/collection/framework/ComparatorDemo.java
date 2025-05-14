package collection.framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Student{
    private final String name;
    private final double gpa;


    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("banana","dates", "apple", "date");
        words.sort((s1,s2)->{
            int N = Math.min(s1.length(),s2.length());
            for(int i=0;i<N;i++){
                if(s1.charAt(i)!=s2.charAt(i)){
                    return s1.charAt(i) - s2.charAt(i);
                }
            }
            return s1.length() - s2.length();
        });
        System.out.println(words);

        List<Integer> integers = Arrays.asList(9, 6, 10, 7, 3, 4);
        integers.sort(Comparator.comparingInt(Integer::intValue));
        System.out.println(integers);


        List<Student> students = new ArrayList<>();
        students.add(new Student("Charlie",3.5));
        students.add(new Student("Alice",3.5));
        students.add(new Student("Bob",3.7));
        students.add(new Student("Akash",3.9));

        // using Java 8
        Comparator<Student> studentComparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);

        // using lamdba and logic
        students.sort((student1,student2)->{
            if(student1.getGpa() > student2.getGpa()){
                return -1;
            }
            else if(student2.getGpa() > student1.getGpa()){
                return 1;
            }
            else{
                return student1.getName().compareTo(student2.getName());
            }
        });
        System.out.println(students);


    }
}


/*
 For -ve value -> o1 must come before o2
 for +ve value -> o2 must come before o1
 for 0 -> same priority
 */
class StringComparator implements Comparator<String>{

    @Override
    public int compare(String s1, String s2) {
        int N = Math.min(s1.length(),s2.length());
        for(int i=0;i<N;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                return s1.charAt(i) - s2.charAt(i);
            }
        }
        return s1.length() - s2.length();
    }
}
