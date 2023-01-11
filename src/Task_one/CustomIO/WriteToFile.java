package Task_one.CustomIO;

import Task_one.CustomExceptions.EntitiesEmptyException;
import Task_one.CustomExceptions.FileNameEmptyException;
import Task_one.Entities.Student;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class WriteToFile {
    public static void saveStudentToFile(ArrayList<Student> students, String filename) throws FileNameEmptyException, EntitiesEmptyException, IOException {
        if (filename.isEmpty()) {
            throw new FileNameEmptyException("Имя файла не может быть пустым!");
        } else {
            if (students.isEmpty()) {
                throw new EntitiesEmptyException("Учеников по данным условиям нет.");
            } else {
                try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
                    objectOutputStream.writeObject(students);
                }  catch (FileNotFoundException e){
                    throw new FileNotFoundException("Указанный файл не существует или не может быть создан или не может быть открыт по какой-либо другой причине");
                } catch (IOException e) {
                    throw new IOException("Ошибка записи");
                }
            }
        }
    }
}
