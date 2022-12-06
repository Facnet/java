package Task_one.CustomUtilities;

import Task_one.Entities.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class AvgBall {
    public static int getAvgBall(HashMap<String, Byte> subjects) {
        double avgball = 0;
        Collection<Byte> ballColletion = subjects.values();
        for (byte b : ballColletion) {
            avgball = avgball + b;
        }
        return (int) Math.round(avgball / ballColletion.size());
    }

    public static ArrayList<Student> getMaxAvgBall(Student[] students) {
        ArrayList<Student> studentsArrayList = new ArrayList<>();
        int maxavgball = 0;
        int avgball;
        for (Student student : students) {
            avgball = getAvgBall(student.getSubject());
            if (maxavgball < avgball) {
                maxavgball = avgball;
            }
        }
        for (Student student : students) {
            avgball = getAvgBall(student.getSubject());
            if (maxavgball == avgball) {
                studentsArrayList.add(student);
            }
        }
        return studentsArrayList;
    }
}
