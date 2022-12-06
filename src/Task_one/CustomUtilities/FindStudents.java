package Task_one.CustomUtilities;

import Task_one.Entities.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import static Task_one.CustomUtilities.CheckFieldEntities.checkFieldEntities;
import static Task_one.CustomUtilities.AvgBall.getAvgBall;

public class FindStudents {

    public static ArrayList<Student> findStudent(Student[] students, String gender, String subject, byte rating) {
        if (!gender.equals("") && !subject.equals("")) {
            return fromGenderAndSubjectAndRating(students, gender, subject, rating);
        }
        if (gender.equals("") && !subject.equals("")) {
            return fromSubjectAndRating(students, subject, rating);
        }
        if (!gender.equals("") && subject.equals("")) {
            return fromGenderAndRating(students, gender, rating);
        } else {
            return fromRating(students, rating);
        }
    }

    public static ArrayList<Student> fromGenderAndSubjectAndRating(Student[] students, String gender, String subject, byte rating) {
        ArrayList<Student> studentsArrayList = new ArrayList<>();
        for (Student student : students) {
            if (student.getGender().equals(gender)) {
                studentsArrayList.add(student);
            }
        }
        return fromSubjectAndRating(studentsArrayList.toArray(Student[]::new), subject, rating);
    }

    public static ArrayList<Student> fromSubjectAndRating(Student[] students, String subject, byte rating) {
        ArrayList<Student> studentsArrayList = new ArrayList<>();
        byte ratingstudent;
        for (Student student : students) {
            ratingstudent = student.getSubject().get(subject);
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

    public static ArrayList<Student> fromGenderAndRating(Student[] students, String gender, byte rating) {
        ArrayList<Student> studentsArrayList = new ArrayList<>();
        for (Student student : students) {
            if (student.getGender().equals(gender)) {
                studentsArrayList.add(student);
            }
        }
        return fromRating(studentsArrayList.toArray(Student[]::new), rating);
    }

    public static ArrayList<Student> fromRating(Student[] students, byte rating) {
        ArrayList<Student> studentsArrayList = new ArrayList<>();
        for (Student student : students) {
            if (rating > 0) {
                if (student.getSubject().containsValue(rating)) {
                    studentsArrayList.add(student);
                }
            } else {
                if (!student.getSubject().containsValue((byte) Math.abs(rating))) {
                    studentsArrayList.add(student);
                }
            }
        }
        return studentsArrayList;
    }

    public static ArrayList<Student> fromGroup(Student[] students, byte group) throws Exception {
        checkFieldEntities("Класс", group);
        ArrayList<Student> studentArrayList = new ArrayList<>();
        for (Student student : students) {
            if (student.getGroup() == group) {
                studentArrayList.add(student);
            }
        }
        return studentArrayList;
    }

    public static ArrayList<Student> fromExcellentBeforeGroup(Student[] students, byte group) {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        boolean excellencies = false;
        for (Student student : students) {
            if (student.getGroup() >= group) {
                if (getAvgBall(student.getSubject()) == 5) {
                    HashMap<String, Byte> map = student.getSubject();
                    for (String key : map.keySet()) {
                        if (map.get(key) == 5) {
                            excellencies = true;
                        } else {
                            excellencies = false;
                            break;
                        }
                    }
                    if (excellencies) {
                        studentArrayList.add(student);
                    }
                }
            }
        }
        return studentArrayList;
    }

    public static ArrayList<Student> fromExcellentWithActivity(Student[] students) {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        boolean excellencies = false;
        for (Student student : students) {
            if(!student.getActivity().isEmpty()) {
                HashMap<String, Byte> map = student.getSubject();
                for (String key : map.keySet()) {
                    if (map.get(key) == 5 || map.get(key) == 4) {
                        excellencies = true;
                    } else {
                        excellencies = false;
                        break;
                    }
                }
                if (excellencies) {
                    studentArrayList.add(student);
                }
            }
        }
        return studentArrayList;
    }

}
