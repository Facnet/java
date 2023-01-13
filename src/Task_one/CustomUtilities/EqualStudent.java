package Task_one.CustomUtilities;

import Task_one.CustomExceptions.EntitiesEmptyException;
import Task_one.Entities.Student;

import java.util.ArrayList;

public class EqualStudent {
    public static void equalStudent(ArrayList<Student> studentFromFile,ArrayList<Student> studentFromTask) throws EntitiesEmptyException {
        if (studentFromFile.isEmpty() ) {
            throw new EntitiesEmptyException("Ученики из файла не были найдены или файл пуст.");
        } else {
            if (studentFromTask.isEmpty() ) {
                throw new EntitiesEmptyException("Учеников по данным условиям для сравнения нет.");
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
                System.out.println("Количество совпадений: "+count);
            }
        }
    }
}
