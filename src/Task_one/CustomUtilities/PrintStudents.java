package Task_one.CustomUtilities;

import Task_one.Entities.Student;

import java.util.ArrayList;

public class PrintStudents {
    public static void printStidents(ArrayList<Student> students){
        if (students.isEmpty()) {
            System.out.println("Учеников по данным условиям нет.");
        }
        else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
