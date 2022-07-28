package guru.qa.homework1.multi_class;

import java.util.ArrayList;
import java.util.List;

public class Student {
    String firstName;
    String lastName;
    String group;
    double averageMark;

    public Student(String firstName, String lastName, String group, double averageMark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.averageMark = averageMark;
    }

    public static void main(String[] args) {
        Student aspirant = new Aspirant("n1", "l1", "1", 5);
        System.out.println(aspirant.getScholarship());

        List<Student> students = new ArrayList<>();
        students.add(new Student("n2", "l2", "1", 4.5));
        students.add(new Student("n3", "l3", "1", 4.5));
        students.add(new Aspirant("n4", "l4", "5", 5));
        students.add(new Student("n5", "l5", "2", 4.5));
        students.add(new Aspirant("n6", "l6", "4", 4.21));
        students.add(new Student("n7", "l7", "2", 5));
        students.add(new Student("n8", "l8", "2", 4.5));

        for (Student student : students) {
            System.out.println(student.getScholarship());
        }

    }

    public int getScholarship() {
        if (averageMark == 5) {
            return 100;
        } else {
            return 80;
        }
    }
}
