package Task_one.CustomUtilities;

import Task_one.Entities.Student;

import java.util.ArrayList;
import java.util.Collection;

public class FindStudents {

    public static ArrayList<Student> findStudent(Student[] students, String sex, String subject, byte rating) {
        if (!sex.equals("") && !subject.equals("")) {
            return fromSexAnaSubjectAndRating(students, sex, subject, rating);
        }
        if (sex.equals("") && !subject.equals("")) {
            return fromSubjectAndRating(students, subject, rating);
        }
        if (!sex.equals("") && subject.equals("")) {
            return fromSexAndRating(students, sex, rating);
        } else {
            return fromRating(students, rating);
        }
    }

    public static ArrayList<Student> fromSexAnaSubjectAndRating(Student[] students, String sex, String subject, byte rating) {
        ArrayList<Student> studentsArrayList = new ArrayList<>();
        for (Student student : students) {
            if (student.getSexStudent().equals(sex)) {
                studentsArrayList.add(student);
            }
        }
        return fromSubjectAndRating(studentsArrayList.toArray(Student[]::new), subject, rating);
    }

    public static ArrayList<Student> fromSubjectAndRating(Student[] students, String subject, byte rating) {
        ArrayList<Student> studentsArrayList = new ArrayList<>();
        byte ratingstudent;// = 0;
        for (Student student : students) {
            ratingstudent = student.getSubjectStudent().getSubjectHashMap().get(subject);
            if (rating > 0) {
                if (ratingstudent == rating) {
                    studentsArrayList.add(student);
                }
            } else {
                if (ratingstudent != Math.abs(rating)) {
                    studentsArrayList.add(student);
                }
            }
        }
        return studentsArrayList;
    }

    public static ArrayList<Student> fromSexAndRating(Student[] students, String sex, byte rating) {
        ArrayList<Student> studentsArrayList = new ArrayList<>();
        for (Student student : students) {
            if (student.getSexStudent().equals(sex)) {
                studentsArrayList.add(student);
            }
        }
        return fromRating(studentsArrayList.toArray(Student[]::new), rating);
    }

    public static ArrayList<Student> fromRating(Student[] students, byte rating) {
        ArrayList<Student> studentsArrayList = new ArrayList<>();
        Collection<Byte> ballColletion;
        for (Student student : students) {
            ballColletion = student.getSubjectStudent().getSubjectHashMap().values();
            if (rating > 0) {
                if (ballColletion.contains(rating)) {
                    studentsArrayList.add(student);
                }
            } else {
                if (!ballColletion.contains((byte)Math.abs(rating))) {
                    studentsArrayList.add(student);
                }
            }
        }
        return studentsArrayList;
    }
}
