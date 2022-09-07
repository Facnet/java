package Task_one.CustomUtilities;

import Task_one.Entities.Student;
import Task_one.Entities.Subject;

import java.util.ArrayList;
import java.util.Collection;

public class AvgBall {
    public static int getAvgBall(Subject subjects) {
        double avgball = 0;
        Collection<Byte> ballColletion = subjects.getSubjectHashMap().values();
        for (byte b : ballColletion) {
            avgball = avgball + b;
        }
        return (int) Math.round(avgball / ballColletion.size());
    }

    public static ArrayList<Student> getMaxAvgBall(Student[] students){
        ArrayList<Student> studentsArrayList = new ArrayList<>();
        int maxavgball = 0;
        int avgball = 0;
        for (int i = 0; i < students.length; i++) {
            avgball = getAvgBall(students[i].getSubjectStudent());
            if (maxavgball < avgball){
                maxavgball = avgball;
            }
        }
        for (int i = 0; i < students.length; i++) {
            avgball = getAvgBall(students[i].getSubjectStudent());
            if (maxavgball == avgball){
                studentsArrayList.add(students[i]);
            }
        }
        return studentsArrayList;
    }
}
