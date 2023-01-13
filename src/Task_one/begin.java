package Task_one;

import Task_one.CustomExceptions.*;
import Task_one.CustomUtilities.AvgBall;
import Task_one.CustomUtilities.FindStudents;
import Task_one.Entities.Student;
import Task_one.Entities.Subject;

import java.io.IOException;
import java.util.Scanner;

import static Task_one.CustomUtilities.EqualStudent.equalStudent;
import static Task_one.CustomUtilities.GenStudents.genStudent;
import static Task_one.CustomUtilities.PrintStudents.printStidents;
import static Task_one.CustomIO.WriteToFile.saveStudentToFile;
import static Task_one.CustomIO.ReadFromFile.readStudentFromFile;

public class begin {
    public static void main(String[] args) {
        try {
            //генерации учеников
            Student[] students = genStudent(10);

            //все ученики
            //printStidents(FindStudents.findStudent(students, "", "", (byte) 0));

            //ученики, у которых наивысший балл
            //printStidents(AvgBall.getMaxAvgBall(students));
            //девочки, у которых пятёрка по математике
            //printStidents(FindStudents.findStudent(students, "Ж", Subject.MATHEMATICS.getTranslate(), (byte) 5));
            //мальчики, у которых нет троек
            //printStidents(FindStudents.findStudent(students, "М", "", (byte) -3));
            //все ученики из одной группы (группа вводится с клавиатуры)
            //printStidents(FindStudents.fromGroup(students, new Scanner(System.in).nextByte()));
            //всех круглых отличников, которые учатся в классе, выше 7.
            //printStidents(FindStudents.fromExcellentBeforeGroup(students, (byte) 7));
            //всех ударников(только 4 и 5), которые участвуют в каких-то активностях.
            //printStidents(FindStudents.fromExcellentWithActivity(students));
            //Сохранить в файл данные
            //saveStudentToFile(FindStudents.findStudent(students, "Ж", Subject.MATHEMATICS.getTranslate(), (byte) 5), "student.bin");
            saveStudentToFile(FindStudents.fromExcellentWithActivity(students), "student.bin");
            //Показать данные из файла
            //printStidents(readStudentFromFile("student.bin"));

            //Количество совпадений учеников
            equalStudent(readStudentFromFile("student.bin"),FindStudents.findStudent(students, "Ж", Subject.MATHEMATICS.getTranslate(), (byte) 5));

        } catch (EntitiesEmptyException | EntitiesFieldEmptyException | EntitiesFieldOutOfBoundsException | FileNameEmptyException | IOException | FileEmptyException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
