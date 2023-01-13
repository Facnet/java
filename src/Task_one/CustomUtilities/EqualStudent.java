package Task_one.CustomUtilities;

import Task_one.CustomExceptions.EntitiesEmptyException;
import Task_one.Entities.Student;

import java.util.ArrayList;

public class EqualStudent {
    public static void equalStudent(ArrayList<Student> studentFromFile,ArrayList<Student> studentFromTask) throws EntitiesEmptyException {
        if (studentFromFile.isEmpty() || studentFromTask.isEmpty()) {
            throw new EntitiesEmptyException("Учеников по данным условиям нет.");
        } else {
            int count = 0;
            for (Student studentFF :
                    studentFromFile) {
                for (Student studentFT :
                        studentFromTask) {
                    if (studentFF.equals(studentFT)) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
