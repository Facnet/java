package Task_one.CustomUtilities;

import Task_one.CustomExceptions.FileEmptyException;
import Task_one.CustomExceptions.FileNameEmptyException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckFileEmpty {
    public static void checkNameAndFileEmpty(String filename) throws FileNameEmptyException, FileEmptyException, IOException {
        if (filename.isEmpty()) {
            throw new FileNameEmptyException("Имя файла не может быть пустым!");
        } else {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
                if (bufferedReader.readLine() == null) {
                    throw new FileEmptyException("Указанный файл пуст!");
                }
            } catch (FileNotFoundException e){
                throw new FileNotFoundException("Указанный файл не существует или не может быть открыт для чтения по какой-либо другой причине!");
            } catch (IOException e) {
                throw new IOException("Упс. Ошибка чтения!");
            }
        }
    }
}
