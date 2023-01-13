package Task_one.CustomIO;

import Task_one.CustomExceptions.FileEmptyException;
import Task_one.CustomExceptions.FileNameEmptyException;
import Task_one.Entities.Student;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import static Task_one.CustomUtilities.CheckFileEmpty.checkNameAndFileEmpty;

public class ReadFromFile {
    public static ArrayList<Student> readStudentFromFile(String filename) throws FileNameEmptyException, IOException, FileEmptyException, ClassNotFoundException {
        checkNameAndFileEmpty(filename);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return ((ArrayList<Student>) objectInputStream.readObject());
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Не удается найти класс сериализованного объекта.");
        } catch (IOException e){
            throw new IOException("Ошибка чтения файла");
        }
    }
}
