package collection.framework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ComparableDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

        list.add(new Student("Akash",9.31));
        list.add(new Student("Anwesha",8.88));
        list.add(new Student("Aman",8.88));
        list.add(new Student("Suhotra",9));

        // In order to pass null in sort(), we have to define natural ordering of class
        // To define natural ordering of a class we have to implement the Comparable interface
        list.sort(null);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(8);
        numbers.add(12);

        numbers.sort(null);




        System.out.println(list);
    }
}


class Student implements Comparable<Student>{
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }

    @Override
    public int compareTo(Student other) {
        if(this==other)
            return 0;
        if(this.getName().equals(other.getName()) && this.getGpa() == other.getGpa())
            return 0;

        if(this.getGpa() != other.getGpa()){
            return Double.compare(other.gpa,gpa);
        }else{
            return this.getName().compareTo(other.getName());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(gpa, student.gpa) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gpa);
    }
}