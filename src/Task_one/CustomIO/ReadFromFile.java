package Task_one.CustomIO;

import Task_one.Entities.Student;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import static Task_one.CustomUtilities.PrintStudents.printStidents;
import static Task_one.CustomUtilities.CheckFileEmpty.checkNameAndFileEmpty;

public class ReadFromFile {
    public static void readStudentFromFile(String filename) throws Exception {
        checkNameAndFileEmpty(filename);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            printStidents((ArrayList<Student>) objectInputStream.readObject());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
