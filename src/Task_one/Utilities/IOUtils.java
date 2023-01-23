package Task_one.Utilities;

import Task_one.Entities.Student;
import Task_one.Exceptions.StudentException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class IOUtils {
    public static ArrayList<Student> readStudentsFromFile(String filename) throws IOException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return ((ArrayList<Student>) objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new IOException("Ошибка чтения из файла для поиска студентов.");
        }
    }

    public static void saveStudentsToFile(ArrayList<Student> students, String filename) throws IOException, StudentException {
        if (students.isEmpty()) {
            throw new StudentException("Учеников по данным условиям для записи нет.");
        } else {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
                objectOutputStream.writeObject(students);
            } catch (IOException e) {
                throw new IOException("Ошибка записи в файл.");
            }
        }
    }

    public static byte scannerInputSymbol() {
        try {
            return new Scanner(System.in).nextByte();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Введен неправильный символ!");
        }
    }

    public static ArrayList<String> getNamesOrSurnames(String filename) throws IOException {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(filename));
            ArrayList<String> words = new ArrayList<>();
            while (fileReader.ready()) {
                words.addAll(Arrays.asList(fileReader.readLine().split(" ")));
            }
            return words;
        } catch (IOException e) {
            throw new IOException("Ошибка чтения файла.");
        }
    }
}