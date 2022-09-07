package Task_one;

import Task_one.CustomUtilities.FindStudents;
import Task_one.Entities.Student;

import java.util.ArrayList;

import static Task_one.CustomUtilities.GenStudents.genStudent;

public class begin {
    public static void main(String[] args) {

        try {
            //генерации учеников
            Student[] students = new Student[20];
            for (int i = 0; i < students.length; i++) {
                students[i] = genStudent();
            }
            ArrayList<Student> studentArrayList;
            //ученики, у которых наивысший балл
            /*studentArrayList = AvgBall.getMaxAvgBall(students);
            for (Student student : studentArrayList) {
                System.out.println(student);
            }*/
            //девочки, у которых пятёрка по математике
            /*studentArrayList = FindStudents.findStudent(students,"жен","", (byte) 5);
            for (Student student : studentArrayList) {
                System.out.println(student);
            }*/
            //мальчики, у которых нет троек
            studentArrayList = FindStudents.findStudent(students,"муж","",(byte) -3);
            for (Student student : studentArrayList) {
                System.out.println(student);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
