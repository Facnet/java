package Task_one.CustomIO;

import Task_one.CustomExceptions.EntitiesEmptyException;
import Task_one.CustomExceptions.FileEmptyException;
import Task_one.CustomExceptions.FileNameEmptyException;
import Task_one.Entities.Student;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import static Task_one.CustomUtilities.PrintStudents.printStidents;
import static Task_one.CustomUtilities.CheckFileEmpty.checkNameAndFileEmpty;

public class ReadFromFile {
    public static void readStudentFromFile(String filename) throws FileNameEmptyException, IOException, FileEmptyException, ClassNotFoundException {
        checkNameAndFileEmpty(filename);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            printStidents((ArrayList<Student>) objectInputStream.readObject());
        } catch (EntitiesEmptyException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Не удается найти класс сериализованного объекта.");
        } catch (IOException e){
            throw new IOException("Ошибка чтения файла");
        }
    }
}
