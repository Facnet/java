package Task_one;

import Task_one.Exceptions.StudentException;

import java.io.IOException;
import java.util.InputMismatchException;

import static Task_one.Utilities.IOUtils.scannerInputSymbol;
import static Task_one.Utilities.StudentUtils.*;

public class begin {
    public static void main(String[] args) {
        try {
            System.out.println("Введите номер задачи:\n" +
                    "        1) Найти учеников, у которых наивысший балл.\n" +
                    "        2) Найти девочек, у которых пятёрка по математике.\n" +
                    "        3) Найти мальчиков, у которых нет троек.\n" +
                    "        4) Найти всех учеников из одной группы(группа вводится с клавиатуры или в коде).\n" +
                    "        5) Найти всех круглых отличников, которые учатся в классе, выше 7.\n" +
                    "        6) Найти всех ударников(только 4 и 5), которые участвуют в каких-то активностях.\n" +
                    "        7) Сохранить в файл данные из любого задания.\n" +
                    "        8) Вывести на экран данные из файла.\n" +
                    "        9) Вывести на экран количество одинаковых учеников из файла и любого задания.\n");

            findStudents(scannerInputSymbol(), genStudent(200));

        } catch (StudentException | IOException | InputMismatchException e) {
            System.out.println(e);
        }
    }
}
