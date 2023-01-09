package Task_one.CustomUtilities;

import Task_one.CustomExceptions.FileEmptyException;
import Task_one.CustomExceptions.FileNameEmptyException;

import java.io.BufferedReader;
import java.io.FileReader;

public class CheckFileEmpty {
    public static void checkNameAndFileEmpty(String filename) throws Exception {
        if (filename.isEmpty()) {
            throw new FileNameEmptyException("Имя файла не может быть пустым!");
        } else {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
                if (bufferedReader.readLine() == null) {
                    throw new FileEmptyException("Указанный файл пуст!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
