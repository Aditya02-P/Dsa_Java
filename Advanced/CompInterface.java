import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student> {
    String name;
    int rollNumber;
    double marks;

    // Constructor
    Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Display method
    void displayStudent() {
        System.out.println("Name: " + name + ", Roll Number: " + rollNumber + ", Marks: " + marks);
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(this.marks, o.marks);
    }
}

class sortByName implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

public class CompInterface {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Adding 10 students
        students.add(new Student("Aditya", 1, 85.5));
        students.add(new Student("Rahul", 2, 78.0));
        students.add(new Student("Sneha", 3, 92.3));
        students.add(new Student("Kiran", 4, 67.8));
        students.add(new Student("Meena", 5, 88.9));
        students.add(new Student("Arjun", 6, 74.5));
        students.add(new Student("Priya", 7, 81.2));
        students.add(new Student("Vikram", 8, 69.4));
        students.add(new Student("Neha", 9, 90.0));
        students.add(new Student("Ravi", 10, 76.6));
        students.sort((a,b)-> (int) (b.marks- a.marks));
        // Display all students
        for (Student s : students) {
            s.displayStudent();
        }
    }
}