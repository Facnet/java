package Task_one.Utilities;

import Task_one.Entities.Student;

import java.io.*;
import java.util.ArrayList;


public class IOUtils {
    public static ArrayList<Student> readStudentsFromFile(String filename) throws IOException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return ((ArrayList<Student>) objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new IOException("Ошибка чтения файла");
        }
    }

    public static void saveStudentsToFile(ArrayList<Student> students, String filename) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(students);
        } catch (IOException e) {
            throw new IOException("Ошибка записи файла");
        }
    }
}